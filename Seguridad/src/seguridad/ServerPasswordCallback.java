/**
 * 
 */
package seguridad;

import java.io.IOException;

import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;

import org.apache.ws.security.WSPasswordCallback;

/**
 * @author pablovm1990
 *
 */
public class ServerPasswordCallback implements CallbackHandler {

	@Override
	public void handle(Callback[] callbacks) throws IOException,
			UnsupportedCallbackException {
		// TODO Auto-generated method stub
		WSPasswordCallback pc = (WSPasswordCallback) callbacks[0];

	      System.out.println("usuario recibido : " + pc.getIdentifier());
	      if (pc.getIdentifier().equals("joe")) {
	         // Ponemos cual ser’a la password valida para este usuario.
	         // El framework CXF se encargar‡ de verificar que coincide
	         // con la enviada por el cliente.
	         pc.setPassword("password");
	      }
	}
}
