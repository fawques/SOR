/**
 * 
 */
package seguridad;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;

import org.apache.ws.security.WSPasswordCallback;

/**
 * @author pablovm1990
 * 
 */
public class ServerPasswordCallback implements CallbackHandler {

	private Map<String, String> passwords = new HashMap<String, String>();

	public void ClientKeystorePasswordCallback() {
		passwords.put("myclientkey", "ckpass");
	}

	public void handle(Callback[] callbacks) throws IOException,
			UnsupportedCallbackException {
		for (int i = 0; i < callbacks.length; i++) {
			WSPasswordCallback pc = (WSPasswordCallback) callbacks[i];

			String pass = passwords.get(pc.getIdentifier());
			if (pass != null) {
				pc.setPassword(pass);
				return;
			}
		}
	}
}
