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
import seguridad.SslConfig;
import seguridad.TripleDes;
import jUDDI.JUDDIProxy;
import gestor_taller.*;

/**
 * 
 * @author fawques
 */
public class Webservices {
	private static TallerWS prepararWebService() {
		TallerWS_Service service = new TallerWS_Service(JUDDIProxy.getWsdl());
		TallerWS port = service.getTallerWSPort();

		SslConfig.disableCNChecker(port);
		return port;
	}

	private static SecretKey prepararClaveReto(String idTaller, String password) {
		SslConfig.disableCertificateChecking();

		Base64 b64 = new Base64();
		String clave = generarClaveReto(idTaller,password);
		if (clave != null) {
			byte[] encodedKey = b64.decode(clave);
			SecretKey encryptor = new SecretKeySpec(encodedKey, 0,
					encodedKey.length, "DESede");
			return encryptor;
		} else {
			return null;
		}

	}

	// public:

	public static String nuevoPedido_WS(String pedido, String idTaller, String password)
			throws JMSException_Exception {
		SecretKey encryptor = prepararClaveReto(idTaller,password);
		if (encryptor != null) {

			TallerWS port = prepararWebService();
			try {
				return port.nuevoPedido(TripleDes.encrypt(encryptor, pedido),
						idTaller,TripleDes.encrypt(encryptor, password));
			} catch (InvalidKeyException | NoSuchAlgorithmException
					| NoSuchPaddingException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
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
	public static boolean alta_WS(java.lang.String name,
			java.lang.String email, java.lang.String address,
			java.lang.String city, java.lang.String postalCode,
			java.lang.String telephone) {
		SslConfig.disableCertificateChecking();
		TallerWS port = prepararWebService();
		return port.alta(name, email, address, city, postalCode, telephone);

	}

	public static String generarClaveReto(String idTaller, String password) {
		SslConfig.disableCertificateChecking();
		TallerWS port = prepararWebService();
		return port.generarClaveReto(idTaller, password);
	}

    public static String checkActivacion_WS(String contrasenya) {
    	SslConfig.disableCertificateChecking();
        TallerWS port = prepararWebService();
        return port.checkActivacion(contrasenya);
	}

	public static String getOfertas_WS(String listaPedidos, String idTaller, String password) {
		SecretKey encryptor = prepararClaveReto(idTaller,password);
		if (encryptor != null) {

			TallerWS port = prepararWebService();
			try {
				return port.getOfertas(
						TripleDes.encrypt(encryptor, listaPedidos), idTaller,TripleDes.encrypt(encryptor, password));
			} catch (InvalidKeyException | NoSuchAlgorithmException
					| NoSuchPaddingException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return null;
	}

	public static Boolean aceptarOferta_WS(String id, String idTaller,String password) {
		SecretKey encryptor = prepararClaveReto(idTaller,password);
		if (encryptor != null) {

			TallerWS port = prepararWebService();
			try {
				return port.aceptarOferta(TripleDes.encrypt(encryptor, id),
						idTaller,TripleDes.encrypt(encryptor, password));
			} catch (InvalidKeyException | NoSuchAlgorithmException
					| NoSuchPaddingException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return null;
	}

	public static Boolean rechazarOferta_WS(String id, String idTaller,String password) {
		SecretKey encryptor = prepararClaveReto(idTaller,password);
		if (encryptor != null) {

			TallerWS port = prepararWebService();
			try {
				return port.rechazarOferta(TripleDes.encrypt(encryptor, id),
						idTaller,TripleDes.encrypt(encryptor, password));
			} catch (InvalidKeyException | NoSuchAlgorithmException
					| NoSuchPaddingException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return null;
	}

	public static String hello() throws javax.xml.ws.WebServiceException {
		SslConfig.disableCertificateChecking();
		TallerWS port = prepararWebService();
		return port.hello();
	}

	public static Boolean baja_WS(String tallerID,String password) {
		SslConfig.disableCertificateChecking();
		TallerWS port = prepararWebService();
		return port.baja(tallerID,password);
	}

	public static boolean modificar_WS(String id, String name, String email,
			String address, String city, String postalCode, String telephone,String password) {
		SecretKey encryptor = prepararClaveReto(id,password);
		if (encryptor != null) {

			TallerWS port = prepararWebService();
			try {
				return port.modificar(id, TripleDes.encrypt(encryptor, password),TripleDes.encrypt(encryptor, name),
						TripleDes.encrypt(encryptor, email),
						TripleDes.encrypt(encryptor, address),
						TripleDes.encrypt(encryptor, city),
						TripleDes.encrypt(encryptor, postalCode),
						TripleDes.encrypt(encryptor, telephone));
			} catch (InvalidKeyException | NoSuchAlgorithmException
					| NoSuchPaddingException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return false;
	}

	public static Boolean cancelarPedido_WS(String idPedido, String idTaller,String password) {
		SecretKey encryptor = prepararClaveReto(idTaller,password);
		if (encryptor != null) {

			TallerWS port = prepararWebService();
			try {
				return port.cancelarPedido(
						TripleDes.encrypt(encryptor, idPedido), idTaller,TripleDes.encrypt(encryptor, password));
			} catch (InvalidKeyException | NoSuchAlgorithmException
					| NoSuchPaddingException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return null;
	}

	public static Boolean cambiarEstadoPedido_WS(String idTaller,String password,int estado,
			java.lang.String id) {
		SecretKey encryptor = prepararClaveReto(idTaller,password);
		if (encryptor != null) {

			TallerWS port = prepararWebService();
			try {
				return port.cambiarEstadoPedido(idTaller,TripleDes.encrypt(encryptor, password),estado,
						TripleDes.encrypt(encryptor, id));
			} catch (InvalidKeyException | NoSuchAlgorithmException
					| NoSuchPaddingException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return null;
	}

	public static String getPedidos_WS(String idTaller,String password) {
		SslConfig.disableCertificateChecking();
		TallerWS port = prepararWebService();
		return port.getPedidos(idTaller,password);
	}

}
