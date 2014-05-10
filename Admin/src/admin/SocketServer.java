/**
 * 
 */
package admin;

import java.io.DataOutputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author pablovm1990
 *
 */
public class SocketServer {
	class Servidor {
		static final int PUERTO=5000; 
		public Servidor() {

		}

		public boolean pingAGestor(){
			try {
				ServerSocket skServidor = new ServerSocket(PUERTO); 
				System.out.println("Escucho el puerto " + PUERTO );

				Socket skCliente = skServidor.accept(); // Crea objeto
				OutputStream aux = skCliente.getOutputStream(); 
				DataOutputStream flujo= new DataOutputStream( aux );
				flujo.writeUTF( "Hola cliente " + "1");
				skCliente.close();
			} catch( Exception e ) {
				System.out.println( e.getMessage() ); 
			}
			return 0;
		}
	}
}
