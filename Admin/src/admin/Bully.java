package admin;

import java.io.IOException;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;

import admin.Mensajes;
public class Bully implements Runnable  {
	ArrayList<InetAddress> gestores;
	ArrayList<InetAddress> gestoresOriginal;
	int posicion;
	SocketServer skServer;
	InetAddress gestorPrincipal;
	static int NUM_REINTENTOS = 3;
	Boolean estarCaido;
	public Bully(){
		// Si es el proceso de identificador mas alto -> manda mensaje de coordinador a todos
		// else
		estarCaido=false;
		skServer = new SocketServer(5000);
		gestoresOriginal= new ArrayList<InetAddress>(3);
		gestores= new ArrayList<InetAddress>(3);
		try {
			gestorPrincipal = InetAddress.getByName("192.168.1.150");
			gestores.add(InetAddress.getByName("192.168.1.104"));
			gestores.add(InetAddress.getByName("192.168.1.103"));
			gestores.add(InetAddress.getByName("192.168.1.100"));
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		}
		
		gestoresOriginal.addAll(gestores);
		
		posicion=1;
		cambiarIP(gestores.get(posicion));
		startElection();		
	}
	
	@Override
	public void run() {
		skServer.recibirPeticion();
		
		
		if(!pingGestor()){
			if(gestores.indexOf(gestorPrincipal)==posicion){
				FXMLDocumentController.cambiarEstadoGestor(EstadoGestor.Caido);
				estarCaido=true;
			}
			else{
				startElection();
			}
			
		}
		else{

		    if(estarCaido && gestores.indexOf(gestorPrincipal)==posicion){
				FXMLDocumentController.cambiarEstadoGestor(EstadoGestor.Activo);
				startElection();
				estarCaido=false;
			}

		}
		// TODO Auto-generated method stub
	}
	
	public boolean pingGestor() {
		// TODO hacer el ping y tal
		System.out.println("Ping a gestor");	
		
		SocketCliente sc = new SocketCliente();
		String mensaje = null;
		int cont=0;
		mensaje = sc.recieveMessage(gestorPrincipal.getHostAddress(), 5001);
		while(!mensaje.equals("OK") && cont<NUM_REINTENTOS){
			System.out.println("Reintento ping");
			mensaje = sc.recieveMessage(gestorPrincipal.getHostAddress(), 5001);
			cont++;
		}
		
		if(mensaje.equals("OK"))
			return true;
		else {
			if(gestorPrincipal.equals(gestores.get(posicion))){
				FXMLDocumentController.cambiarEstadoGestor(EstadoGestor.Caido);
			}
			return false;
		}
	}

	public void startElection(){

		System.out.println("Start election");
		FXMLDocumentController.cambiarEstadoGestor(EstadoGestor.Error);
		// envia mensaje de eleccion a los procesos con identificador mayor que el suyo
		for(int i=0;i<posicion;i++){
				sendMessage(Mensajes.eleccion,gestores.get(i));
		}
		Message msg=receiveMessage();
		if(msg.getMensaje() == Mensajes.error){
			iAmGestor();
		}else{
			if(msg.equals("respuesta")){
			}else{
				processMessage(msg.getMensaje(), msg.getIp());
			}
		} 
	}
	
	private void setGestor(InetAddress gestorIP) {
		// guarda el identificador y trata a ese proceso como nuevo coordinador
//		gestorPrincipal = gestorIP;
		
		InetAddress original = gestoresOriginal.get(posicion);
		cambiarIP(original);
		try{
			gestores.set(gestores.indexOf(gestorPrincipal), gestoresOriginal.get(gestores.indexOf(gestorPrincipal)));
		}catch(IndexOutOfBoundsException e){
			// no hago nada
		}
		gestores.set(gestores.indexOf(gestorIP), gestorPrincipal);
		System.out.println(("El gestor es: " + gestorIP));
		FXMLDocumentController.cambiarEstadoGestor(EstadoGestor.Activo);
	}

	private Message receiveMessage(){
		//	Espera un tiempo determinado hasta recibir un mensaje. Si no lo recibe, lanza excepcion / devuelve null
		return skServer.recibirMensaje();
	}
	
	public void processMessage(Mensajes msg, InetAddress inetAddress){

		System.out.println("Procesar mensaje:"+ msg.toString() + " "+ inetAddress.getHostAddress());
		Boolean respuesta=false;
		if(msg==Mensajes.eleccion){
			FXMLDocumentController.cambiarEstadoGestor(EstadoGestor.Error);
			// startElection()
			for(int i=0;i<posicion;i++){
				if(sendMessage(msg,gestores.get(i))){
					respuesta=true;
				}
			}
			if(respuesta==false){
				sendMessage(Mensajes.respuesta,gestores.get(gestores.indexOf(inetAddress)));
				iAmGestor();
			}
		}
		else if (msg==Mensajes.coordinacion){
			setGestor(inetAddress);
			//cambiar gestor a otro
		}
		else{
			System.err.print("Error de mensaje");
		}
	}
	
	private boolean sendMessage(Mensajes msg, InetAddress inetAddress) {
		// TODO Auto-generated method stub
		SocketCliente sc = new SocketCliente();
		return sc.sendMessage(inetAddress.getHostAddress(), 5000, msg.toString());
	}

	private void iAmGestor(){
		//el proceso se erige como coordinador y envia mensaje de coordinador a todos los procesos con identificadores mas bajos
//		gestorPrincipal = gestores.get(posicion);
		System.out.println(("Yo soy el gestor"));
		//decirle a uddi que yo soy el gestor

		try{
			gestores.set(gestores.indexOf(gestorPrincipal), gestoresOriginal.get(gestores.indexOf(gestorPrincipal)));
		}catch(IndexOutOfBoundsException e){
			// no hago nada
		}
		gestores.set(posicion, gestorPrincipal);
		cambiarIP(gestorPrincipal);
		for(int i=posicion+1; i<gestores.size(); i++){
			sendMessage(Mensajes.coordinacion, gestores.get(i));
		}
		FXMLDocumentController.soyElGestor();

	}
	
	private void cambiarIP(InetAddress ip){
        String str1=ip.getHostAddress();
        String str2="255.255.255.0";
        String[] command1 = { "netsh", "interface", "ip", "set address name=\"Ethernet\" source=static addr=\""+str1+"\" mask=\""+str2+"\""};
        Process pp;
		try {
			pp = java.lang.Runtime.getRuntime().exec(command1);
	        System.out.println(pp.getOutputStream().toString());
	        System.out.println(pp.getInputStream().toString());
	        System.out.println(pp.getErrorStream().toString());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
