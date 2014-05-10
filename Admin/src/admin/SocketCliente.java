/**
 * 
 */
package admin;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 * @author pablovm1990
 *
 */
public class SocketCliente {
	//static final String HOST = "localhost"; 
	//static final int PUERTO=5000;
	
	public SocketCliente(String host, int puerto, String mensaje) {
		try {
			Socket skCliente = new Socket(host, puerto);
			skCliente.setSoTimeout(1000);
			OutputStream aux = skCliente.getOutputStream();
			DataOutputStream flujo = new DataOutputStream(aux);
			flujo.writeUTF(mensaje);
			skCliente.close();
		} catch (Exception e) {
			System.out.println(" 222111" + e.getMessage());
		}
	}
}
