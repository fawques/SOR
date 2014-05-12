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
	SocketServer sk = null;
	SocketCliente sc;
	@Override
	public void run() {
		if(sk==null)
			sk = new SocketServer(5000);
		
		sk.recibirPeticion();
		
		// TODO Auto-generated method stub
		FXMLDocumentController.cambiarEstadoGestor1();
		FXMLDocumentController.cambiarEstadoGestor2();
		FXMLDocumentController.cambiarEstadoGestor3();
		
		
		/*sc = new SocketCliente();
		sc.sendMessage("192.168.1.24", 5001, "hola que tal");*/
	}
}
