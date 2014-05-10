/**
 * 
 */
package admin;

import java.io.DataInputStream;
import java.io.InputStream;
import java.net.Socket;

/**
 * @author pablovm1990
 *
 */
public class SocketCliente {
	//static final String HOST = "localhost"; 
	//static final int PUERTO=5000;
	
	public SocketCliente() {
		
	}
	
	public boolean enviaMensaje(String host, int puerto, String mensaje){
		try {
			Socket skCliente = new Socket(host, puerto);
			InputStream aux = skCliente.getInputStream();
			DataInputStream flujo = new DataInputStream(aux);
			flujo.readUTF();
			skCliente.close();
			return flujo;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
