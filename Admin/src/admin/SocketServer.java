/**
 * 
 */
package admin;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author pablovm1990
 *
 */
public class SocketServer {
	ServerSocket skServidor;
	int puertoAhora;
	public SocketServer(int puerto) {
		puertoAhora=puerto;
		try {
			skServidor = new ServerSocket(puerto);
			skServidor.setSoTimeout(Admin.timeout);
			System.out.println("Escucho el puerto " + puerto );
			
		} catch(IOException e ) {
			//e.printStackTrace();
			System.out.println("Servidor: " + e.getMessage() ); 
		}
	}
	
	public void recibirPeticion(){
		try {
			System.out.println("Recibiendo"+puertoAhora);
			Socket skCliente = skServidor.accept(); // Crea objeto
			InputStream aux = skCliente.getInputStream(); 
			DataInputStream flujo= new DataInputStream(aux);
			String mensaje = flujo.readUTF();
			System.out.println(mensaje);
			
			Admin.bullyAlg.processMessage(Mensajes.valueOf(mensaje), skCliente.getInetAddress());
			skCliente.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			System.out.println("Servidor: " + e.getMessage() ); 
		}
	}
	
	public Message recibirMensaje(){
		try {
			System.out.println("Recibiendo"+puertoAhora );
			Socket skCliente = skServidor.accept(); // Crea objeto
			InputStream aux = skCliente.getInputStream(); 
			DataInputStream flujo= new DataInputStream(aux);
			String mensaje = flujo.readUTF();
			System.out.println(mensaje);
			skCliente.close();
			return new Message(skCliente.getInetAddress(),Mensajes.valueOf(mensaje));
		} catch (IOException e) {
			//e.printStackTrace();
			// TODO Auto-generated catch block
			System.out.println("Servidor: " + e.getMessage() ); 
		}
		return new Message(null, Mensajes.error);
	}
}
