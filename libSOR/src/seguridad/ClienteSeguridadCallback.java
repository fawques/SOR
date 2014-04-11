/**
 * 
 */
package seguridad;

import java.io.IOException;
import java.security.KeyStore.CallbackHandlerProtection;

import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;

import org.apache.ws.security.WSPasswordCallback;


/**
 * @author pablovm1990
 *
 */
public class ClienteSeguridadCallback implements CallbackHandler {

	/**
	 * @param handler
	 */
	public void handle(Callback[] callbacks) throws IOException,UnsupportedCallbackException {
		      WSPasswordCallback pc = (WSPasswordCallback) callbacks[0];
		      // set the password for our message.
		      pc.setPassword("password");

		      // En caso de que el cliente sea multiusuario, 
		      // con pc.getIdentifier() podriamos obtener el nombre de usuario
		      // para poner la password que corresponda a ese usuario.
	}
}
