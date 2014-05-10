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
	static final String HOST = "localhost"; 
	static final int PUERTO=5000;
	
	public SocketCliente() {
		try {
			Socket skCliente = new Socket(HOST, PUERTO);
			InputStream aux = skCliente.getInputStream();
			DataInputStream flujo = new DataInputStream(aux);
			System.out.println(flujo.readUTF());
			skCliente.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
