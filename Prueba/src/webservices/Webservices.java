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
    static public String nuevoPedido_WS(String pedido) throws JMSException_Exception {
        gestor_taller.TallerWS_Service service = new gestor_taller.TallerWS_Service(JUDDIProxy.getWsdl());
        gestor_taller.TallerWS port = service.getTallerWSPort();
        return port.nuevoPedido(pedido);
    }
    
    public static boolean alta_WS(java.lang.String name, java.lang.String email, java.lang.String address, java.lang.String city, java.lang.String postalCode, java.lang.String telephone) {
        gestor_taller.TallerWS_Service service = new gestor_taller.TallerWS_Service(JUDDIProxy.getWsdl());
        gestor_taller.TallerWS port = service.getTallerWSPort();
        TripleDes t = new TripleDes();
        
        String nameCifrado = "";
        File keyfile = new File("pepe.txt");
        SecretKey key2 = t.generarClaveGuardar(keyfile);
		try {
			key2 = t.readKey(keyfile);
			try {
				nameCifrado = t.encrypt(key2, name);
				System.out.println("ESTimado, esta es la clave de cifrado: " + key2);
				System.out.println("ESTimado, este es el cifrado: " + nameCifrado);
				//decrypt(key2,cifrado);
			} catch (NoSuchPaddingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (InvalidKeyException | NoSuchAlgorithmException
				| InvalidKeySpecException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

        return port.alta(nameCifrado, email, address, city, postalCode, telephone);
    }
    
    public static String checkActivacion_WS(String mail) {
        TallerWS_Service service = new gestor_taller.TallerWS_Service(JUDDIProxy.getWsdl());
        gestor_taller.TallerWS port = service.getTallerWSPort();
        return port.checkActivacion(mail);
    }
    
    public static String getOfertas_WS(String listaPedidos) {
        gestor_taller.TallerWS_Service service = new gestor_taller.TallerWS_Service(JUDDIProxy.getWsdl());
        gestor_taller.TallerWS port = service.getTallerWSPort();
        return port.getOfertas(listaPedidos);
    }
    
    public static Boolean aceptarOferta_WS(String id) {
        gestor_taller.TallerWS_Service service= new gestor_taller.TallerWS_Service(JUDDIProxy.getWsdl());;
        gestor_taller.TallerWS port = service.getTallerWSPort();
        return port.aceptarOferta(id);
    }
    
    public static Boolean rechazarOferta_WS(String id) {
        gestor_taller.TallerWS_Service service = new gestor_taller.TallerWS_Service(JUDDIProxy.getWsdl());
        gestor_taller.TallerWS port = service.getTallerWSPort();
        return port.rechazarOferta(id);
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
        gestor_taller.TallerWS_Service service = new gestor_taller.TallerWS_Service(JUDDIProxy.getWsdl());
        gestor_taller.TallerWS port = service.getTallerWSPort();
        return port.modificar(id, name, email, address, city, postalCode, telephone);
    }
    
    public static Boolean cancelarPedido_WS(String idPedido) {
        gestor_taller.TallerWS_Service service = new gestor_taller.TallerWS_Service(JUDDIProxy.getWsdl());
        gestor_taller.TallerWS port = service.getTallerWSPort();
        return port.cancelarPedido(idPedido);
    }

    public static Boolean cambiarEstadoPedido_WS(int estado, java.lang.String id) {
        gestor_taller.TallerWS_Service service = new gestor_taller.TallerWS_Service(JUDDIProxy.getWsdl());
        gestor_taller.TallerWS port = service.getTallerWSPort();
        return port.cambiarEstadoPedido(estado, id);
    }

    public static String getPedidos_WS(String id) {
        gestor_taller.TallerWS_Service service = new gestor_taller.TallerWS_Service(JUDDIProxy.getWsdl());
        gestor_taller.TallerWS port = service.getTallerWSPort();
        return port.getPedidos(id);
    }

}
