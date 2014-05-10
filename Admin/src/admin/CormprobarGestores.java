/**
 * 
 */
package admin;

import javafx.scene.paint.Paint;

/**
 * @author pablovm1990
 *
 */
public class CormprobarGestores implements Runnable {

	/* (non-Javadoc)
	 * @see java.lang.Runnable#run()
	 */
	@Override
	public void run() {
		// TODO Auto-generated method stub
		FXMLDocumentController.cambiarEstadoGestor1();
		FXMLDocumentController.cambiarEstadoGestor2();
		FXMLDocumentController.cambiarEstadoGestor3();
		
		SocketServer sk = new SocketServer(5000);

		SocketCliente sc = new SocketCliente("localhost", 5000, "hola que tal");
	}
}
