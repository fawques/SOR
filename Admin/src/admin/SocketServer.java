/**
 * 
 */
package admin;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author pablovm1990
 *
 */
public class SocketServer {
	public SocketServer(int puerto) {
		try {
			ServerSocket skServidor = new ServerSocket(puerto);
			skServidor.setSoTimeout(1000);
			System.out.println("Escucho el puerto " + puerto );
			Socket skCliente = skServidor.accept(); // Crea objeto
			InputStream aux = skCliente.getInputStream(); 
			DataInputStream flujo= new DataInputStream(aux);
			System.out.println(flujo.read());
			skCliente.close();
		} catch( Exception e ) {
			System.out.println(" 222" + e.getMessage() ); 
		}
	}
}
