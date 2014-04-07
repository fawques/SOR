/**
 * 
 */
package repetir;

import jUDDI.SimplePublish;

import java.net.Inet4Address;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;

import seguridad.InstallCert;
import seguridad.MainSeguridad;

/**
 * @author pablovm1990
 *
 */
public class InstallCertificado implements Runnable {

	/* (non-Javadoc)
	 * @see java.lang.Runnable#run()
	 */
	@Override
	public void run() {
		// TODO Auto-generated method stub
		/*String ip = "localhost";
        try {
             ip = Inet4Address.getLocalHost().getHostAddress();
        } catch (UnknownHostException ex) {
            Logger.getLogger(SimplePublish.class.getName()).log(Level.SEVERE, null, ex);
        }
        String[] args = {ip+":8443"};
        try {
			InstallCert.main(args);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		MainSeguridad m = new MainSeguridad("");
	}

}
