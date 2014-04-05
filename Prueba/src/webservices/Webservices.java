/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package webservices;

import java.io.File;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.binary.Base64;

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
    	Base64 b64 = new Base64();
    	byte[] encodedKey     = b64.decode(generarClaveReto(idTaller));
    	SecretKey encryptor = new SecretKeySpec(encodedKey, 0, encodedKey.length, "DESede");
    	
        gestor_taller.TallerWS_Service service = new gestor_taller.TallerWS_Service(JUDDIProxy.getWsdl());
        gestor_taller.TallerWS port = service.getTallerWSPort();
        try {
			return port.nuevoPedido(TripleDes.encrypt(encryptor, pedido), idTaller);
		} catch (InvalidKeyException | NoSuchAlgorithmException
				| NoSuchPaddingException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return null;
    }
    
    public static boolean alta_WS(java.lang.String name, java.lang.String email, java.lang.String address, java.lang.String city, java.lang.String postalCode, java.lang.String telephone) {
    	//SecretKey encryptor = generarClaveReto();

        //gestor_taller.TallerWS_Service service = new gestor_taller.TallerWS_Service(JUDDIProxy.getWsdl());
        //gestor_taller.TallerWS port = service.getTallerWSPort();
        //return port.alta(TripleDes.encrypt(encryptor, name), TripleDes.encrypt(encryptor, email), TripleDes.encrypt(encryptor, address), TripleDes.encrypt(encryptor, city), TripleDes.encrypt(encryptor, postalCode), TripleDes.encrypt(encryptor, telephone));
    	return false;
    }
    
    public static String generarClaveReto(String idTaller) {
    	TallerWS_Service service = new gestor_taller.TallerWS_Service(JUDDIProxy.getWsdl());
        gestor_taller.TallerWS port = service.getTallerWSPort();
        return port.generarClaveReto(idTaller);
    }
    
    public static String checkActivacion_WS(String mail) {
    	TallerWS_Service service = new gestor_taller.TallerWS_Service(JUDDIProxy.getWsdl());
        gestor_taller.TallerWS port = service.getTallerWSPort();
        return port.checkActivacion(mail);
    }
    
    public static String getOfertas_WS(String listaPedidos, String idTaller) {
    	Base64 b64 = new Base64();
    	byte[] encodedKey     = b64.decode(generarClaveReto(idTaller));
    	SecretKey encryptor = new SecretKeySpec(encodedKey, 0, encodedKey.length, "DESede");
    	
        gestor_taller.TallerWS_Service service = new gestor_taller.TallerWS_Service(JUDDIProxy.getWsdl());
        gestor_taller.TallerWS port = service.getTallerWSPort();
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
    	Base64 b64 = new Base64();
    	byte[] encodedKey     = b64.decode(generarClaveReto(idTaller));
    	SecretKey encryptor = new SecretKeySpec(encodedKey, 0, encodedKey.length, "DESede");
    	
        gestor_taller.TallerWS_Service service= new gestor_taller.TallerWS_Service(JUDDIProxy.getWsdl());;
        gestor_taller.TallerWS port = service.getTallerWSPort();
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
    	Base64 b64 = new Base64();
    	byte[] encodedKey     = b64.decode(generarClaveReto(idTaller));
    	SecretKey encryptor = new SecretKeySpec(encodedKey, 0, encodedKey.length, "DESede");
    	
        gestor_taller.TallerWS_Service service = new gestor_taller.TallerWS_Service(JUDDIProxy.getWsdl());
        gestor_taller.TallerWS port = service.getTallerWSPort();
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
    	gestor_taller.TallerWS_Service service = new TallerWS_Service(JUDDIProxy.getWsdl());
        gestor_taller.TallerWS port = service.getTallerWSPort();
        return port.hello();
    }
    
    public static Boolean baja_WS(String tallerID) {
    	gestor_taller.TallerWS_Service service = new gestor_taller.TallerWS_Service(JUDDIProxy.getWsdl());
        gestor_taller.TallerWS port = service.getTallerWSPort();
        return port.baja(tallerID);
    }
    
    public static boolean modificar_WS(String id, String name, String email, String address, String city, String postalCode, String telephone) {
    	Base64 b64 = new Base64();
    	byte[] encodedKey     = b64.decode(generarClaveReto(id));
    	SecretKey encryptor = new SecretKeySpec(encodedKey, 0, encodedKey.length, "DESede");
    	
        gestor_taller.TallerWS_Service service = new gestor_taller.TallerWS_Service(JUDDIProxy.getWsdl());
        gestor_taller.TallerWS port = service.getTallerWSPort();
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
    	Base64 b64 = new Base64();
    	byte[] encodedKey     = b64.decode(generarClaveReto(idTaller));
    	SecretKey encryptor = new SecretKeySpec(encodedKey, 0, encodedKey.length, "DESede");
    	
        gestor_taller.TallerWS_Service service = new gestor_taller.TallerWS_Service(JUDDIProxy.getWsdl());
        gestor_taller.TallerWS port = service.getTallerWSPort();
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
    	Base64 b64 = new Base64();
    	byte[] encodedKey     = b64.decode(generarClaveReto(idTaller));
    	SecretKey encryptor = new SecretKeySpec(encodedKey, 0, encodedKey.length, "DESede");
    	
        gestor_taller.TallerWS_Service service = new gestor_taller.TallerWS_Service(JUDDIProxy.getWsdl());
        gestor_taller.TallerWS port = service.getTallerWSPort();
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
    	gestor_taller.TallerWS_Service service = new gestor_taller.TallerWS_Service(JUDDIProxy.getWsdl());
        gestor_taller.TallerWS port = service.getTallerWSPort();
		return port.getPedidos(id);
    }

}
