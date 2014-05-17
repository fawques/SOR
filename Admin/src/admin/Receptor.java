package admin;
import com.sun.org.apache.xml.internal.serializer.utils.Messages;

import admin.Mensajes;
public class Receptor implements Runnable {
	SocketServer skServer;
	
	public Receptor(){
		skServer = new SocketServer(5000);
	}
	@Override
	public void run() {
		
		skServer.recibirPeticion();
		
	}
	private void receiveMessage(){
		//	Espera un tiempo determinado hasta recibir un mensaje. Si no lo recibe, lanza excepcion / devuelve null
		Message m= skServer.recibirMensaje();
		if(m.mensaje==Mensajes.respuesta){
			if(Admin.enviadaEleccion==true){		
				Admin.enviadaEleccion=false;
			}
		}
		else{
			Admin.bullyAlg.processMessage(m.mensaje,m.ip);
		}
	}
	

}
