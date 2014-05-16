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
			skServidor.setSoTimeout(1000);
			System.out.println("Escucho el puerto " + puerto );
			
		} catch(IOException e ) {
			System.out.println("Servidor: " + e.getMessage() ); 
		}
	}
	
	public void recibirPeticion(){
		try {
			System.out.println("Recibiendo"+puertoAhora);
			Socket skCliente = skServidor.accept(); // Crea objeto
			InputStream aux = skCliente.getInputStream(); 
			DataInputStream flujo= new DataInputStream(aux);
			System.out.println(flujo.readUTF());
			
			Admin.bullyAlg.processMessage(Mensajes.valueOf(flujo.readUTF()), skCliente.getInetAddress());
			skCliente.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("Servidor: " + e.getMessage() ); 
		}
	}
	
	public Message recibirMensaje(){
		try {
			System.out.println("Recibiendo"+puertoAhora );
			Socket skCliente = skServidor.accept(); // Crea objeto
			InputStream aux = skCliente.getInputStream(); 
			DataInputStream flujo= new DataInputStream(aux);
			System.out.println(flujo.readUTF());
			skCliente.close();
			return new Message(skCliente.getInetAddress(),Mensajes.valueOf(flujo.readUTF()));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("Servidor: " + e.getMessage() ); 
		}
		return new Message(null, Mensajes.error);
	}
}
