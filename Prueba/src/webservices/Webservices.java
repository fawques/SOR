/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package webservices;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.InvalidKeyException;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.security.spec.InvalidKeySpecException;

import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import org.apache.commons.codec.binary.Base64;
import org.apache.cxf.configuration.jsse.TLSClientParameters;
import org.apache.cxf.frontend.ClientProxy;
import org.apache.cxf.transport.http.HTTPConduit;

import seguridad.MainSeguridad;
import seguridad.TripleDes;
import jUDDI.JUDDIProxy;
import gestor_taller.JMSException;
import gestor_taller.JMSException_Exception;
import gestor_taller.TallerWS_Service;

/**
 *
 * @author fawques
 */
public class Webservices {
    static public String nuevoPedido_WS(String pedido, String idTaller) throws JMSException_Exception {
    	disableCertificateChecking();
    	
    	Base64 b64 = new Base64();
    	byte[] encodedKey     = b64.decode(generarClaveReto(idTaller));
    	SecretKey encryptor = new SecretKeySpec(encodedKey, 0, encodedKey.length, "DESede");
    	
        gestor_taller.TallerWS_Service service = new gestor_taller.TallerWS_Service(JUDDIProxy.getWsdl());
        gestor_taller.TallerWS port = service.getTallerWSPort();

        disableCNChecker(port);
        try {
			return port.nuevoPedido(TripleDes.encrypt(encryptor, pedido), idTaller);
		} catch (InvalidKeyException | NoSuchAlgorithmException
				| NoSuchPaddingException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return null;
    }
    
    /**
     * @param name
     * @param email
     * @param address
     * @param city
     * @param postalCode
     * @param telephone
     * @return
     */
    public static boolean alta_WS(java.lang.String name, java.lang.String email, java.lang.String address, java.lang.String city, java.lang.String postalCode, java.lang.String telephone) {
    	disableCertificateChecking();
        	TallerWS_Service service = new gestor_taller.TallerWS_Service(JUDDIProxy.getWsdl());
	        gestor_taller.TallerWS port = service.getTallerWSPort();
	        disableCNChecker(port);
	        return port.alta(name, email, address, city, postalCode, telephone);
	    
    }

	private static void disableCertificateChecking() {
		/*
         *  fix for
         *    Exception in thread "main" javax.net.ssl.SSLHandshakeException:
         *       sun.security.validator.ValidatorException:
         *           PKIX path building failed: sun.security.provider.certpath.SunCertPathBuilderException:
         *               unable to find valid certification path to requested target
         */
        TrustManager[] trustAllCerts = new TrustManager[] {
           new X509TrustManager() {

			@Override
			public void checkClientTrusted(X509Certificate[] chain,
					String authType) throws CertificateException {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void checkServerTrusted(X509Certificate[] chain,
					String authType) throws CertificateException {
				// TODO Auto-generated method stub
				
			}

			@Override
			public X509Certificate[] getAcceptedIssuers() {
				// TODO Auto-generated method stub
				return null;
			}
           }
        };

        SSLContext sc;
		try {
			sc = SSLContext.getInstance("SSL");
	        sc.init(null, trustAllCerts, new java.security.SecureRandom());
	        HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());
		} catch (NoSuchAlgorithmException | KeyManagementException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

        // Create all-trusting host name verifier
        HostnameVerifier allHostsValid = new HostnameVerifier() {

			@Override
			public boolean verify(String arg0, SSLSession arg1) {
				// TODO Auto-generated method stub
				return true;
			}
        };
        // Install the all-trusting host verifier
        HttpsURLConnection.setDefaultHostnameVerifier(allHostsValid);
        
        /*
         * end of the fix
         */
	}

	private static void disableCNChecker(gestor_taller.TallerWS port) {
		HTTPConduit httpConduit = (HTTPConduit) ClientProxy.getClient(port).getConduit();

		TLSClientParameters tlsCP = new TLSClientParameters();
		// other TLS/SSL configuration like setting up TrustManagers
		tlsCP.setDisableCNCheck(true);
		httpConduit.setTlsClientParameters(tlsCP);
	}
    
    public static String generarClaveReto(String idTaller) {
    	disableCertificateChecking();
    	TallerWS_Service service = new gestor_taller.TallerWS_Service(JUDDIProxy.getWsdl());
        gestor_taller.TallerWS port = service.getTallerWSPort();
        disableCNChecker(port);
        return port.generarClaveReto(idTaller);
    }
    
    public static String checkActivacion_WS(String mail) {
    	disableCertificateChecking();
    	TallerWS_Service service = new gestor_taller.TallerWS_Service(JUDDIProxy.getWsdl());
        gestor_taller.TallerWS port = service.getTallerWSPort();
        disableCNChecker(port);
        return port.checkActivacion(mail);
    }
    
    public static String getOfertas_WS(String listaPedidos, String idTaller) {
    	disableCertificateChecking();
    	Base64 b64 = new Base64();
    	byte[] encodedKey     = b64.decode(generarClaveReto(idTaller));
    	SecretKey encryptor = new SecretKeySpec(encodedKey, 0, encodedKey.length, "DESede");
    	
        gestor_taller.TallerWS_Service service = new gestor_taller.TallerWS_Service(JUDDIProxy.getWsdl());
        gestor_taller.TallerWS port = service.getTallerWSPort();
        disableCNChecker(port);
        try {
			return port.getOfertas(TripleDes.encrypt(encryptor, listaPedidos), idTaller);
		} catch (InvalidKeyException | NoSuchAlgorithmException
				| NoSuchPaddingException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return null;
    }
    
    public static Boolean aceptarOferta_WS(String id, String idTaller) {
    	disableCertificateChecking();
    	Base64 b64 = new Base64();
    	byte[] encodedKey     = b64.decode(generarClaveReto(idTaller));
    	SecretKey encryptor = new SecretKeySpec(encodedKey, 0, encodedKey.length, "DESede");
    	
        gestor_taller.TallerWS_Service service= new gestor_taller.TallerWS_Service(JUDDIProxy.getWsdl());;
        gestor_taller.TallerWS port = service.getTallerWSPort();
        disableCNChecker(port);
        try {
			return port.aceptarOferta(TripleDes.encrypt(encryptor, id), idTaller);
		} catch (InvalidKeyException | NoSuchAlgorithmException
				| NoSuchPaddingException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return null;
    }
    
    public static Boolean rechazarOferta_WS(String id, String idTaller) {
    	disableCertificateChecking();
    	Base64 b64 = new Base64();
    	byte[] encodedKey     = b64.decode(generarClaveReto(idTaller));
    	SecretKey encryptor = new SecretKeySpec(encodedKey, 0, encodedKey.length, "DESede");
    	
        gestor_taller.TallerWS_Service service = new gestor_taller.TallerWS_Service(JUDDIProxy.getWsdl());
        gestor_taller.TallerWS port = service.getTallerWSPort();
        disableCNChecker(port);
        try {
			return port.rechazarOferta(TripleDes.encrypt(encryptor, id), idTaller);
		} catch (InvalidKeyException | NoSuchAlgorithmException
				| NoSuchPaddingException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return null;
    }
    
    public static String hello() throws javax.xml.ws.WebServiceException{
    	disableCertificateChecking();
    	gestor_taller.TallerWS_Service service = new TallerWS_Service(JUDDIProxy.getWsdl());
        gestor_taller.TallerWS port = service.getTallerWSPort();
        disableCNChecker(port);
        return port.hello();
    }
    
    public static Boolean baja_WS(String tallerID) {
    	disableCertificateChecking();
    	gestor_taller.TallerWS_Service service = new gestor_taller.TallerWS_Service(JUDDIProxy.getWsdl());
        gestor_taller.TallerWS port = service.getTallerWSPort();
        disableCNChecker(port);
        return port.baja(tallerID);
    }
    
    public static boolean modificar_WS(String id, String name, String email, String address, String city, String postalCode, String telephone) {
    	disableCertificateChecking();
    	Base64 b64 = new Base64();
    	byte[] encodedKey     = b64.decode(generarClaveReto(id));
    	SecretKey encryptor = new SecretKeySpec(encodedKey, 0, encodedKey.length, "DESede");
    	
        gestor_taller.TallerWS_Service service = new gestor_taller.TallerWS_Service(JUDDIProxy.getWsdl());
        gestor_taller.TallerWS port = service.getTallerWSPort();
        disableCNChecker(port);
        try {
			return port.modificar(id, TripleDes.encrypt(encryptor, name), TripleDes.encrypt(encryptor, email), TripleDes.encrypt(encryptor, address), TripleDes.encrypt(encryptor, city), TripleDes.encrypt(encryptor, postalCode), TripleDes.encrypt(encryptor, telephone));
		} catch (InvalidKeyException | NoSuchAlgorithmException
				| NoSuchPaddingException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return false;
    }
    
    public static Boolean cancelarPedido_WS(String idPedido, String idTaller) {
    	disableCertificateChecking();
    	Base64 b64 = new Base64();
    	byte[] encodedKey     = b64.decode(generarClaveReto(idTaller));
    	SecretKey encryptor = new SecretKeySpec(encodedKey, 0, encodedKey.length, "DESede");
    	
        gestor_taller.TallerWS_Service service = new gestor_taller.TallerWS_Service(JUDDIProxy.getWsdl());
        gestor_taller.TallerWS port = service.getTallerWSPort();
        disableCNChecker(port);
        try {
			return port.cancelarPedido(TripleDes.encrypt(encryptor, idPedido), idTaller);
		} catch (InvalidKeyException | NoSuchAlgorithmException
				| NoSuchPaddingException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return null;
    }

    public static Boolean cambiarEstadoPedido_WS(int estado, java.lang.String id, String idTaller) {
    	disableCertificateChecking();
    	Base64 b64 = new Base64();
    	byte[] encodedKey     = b64.decode(generarClaveReto(idTaller));
    	SecretKey encryptor = new SecretKeySpec(encodedKey, 0, encodedKey.length, "DESede");
    	
        gestor_taller.TallerWS_Service service = new gestor_taller.TallerWS_Service(JUDDIProxy.getWsdl());
        gestor_taller.TallerWS port = service.getTallerWSPort();
        disableCNChecker(port);
        try {
			return port.cambiarEstadoPedido(estado, TripleDes.encrypt(encryptor, id),idTaller);
		} catch (InvalidKeyException | NoSuchAlgorithmException
				| NoSuchPaddingException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return null;
    }

    public static String getPedidos_WS(String id) {
    	disableCertificateChecking();
    	gestor_taller.TallerWS_Service service = new gestor_taller.TallerWS_Service(JUDDIProxy.getWsdl());
        gestor_taller.TallerWS port = service.getTallerWSPort();
        disableCNChecker(port);
		return port.getPedidos(id);
    }

}
