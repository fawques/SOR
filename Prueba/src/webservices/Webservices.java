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
    static public String nuevoPedido_WS(String pedido) throws JMSException_Exception {
    	SecretKey encryptor = generarClaveReto();
    	TripleDes t = new TripleDes();
        gestor_taller.TallerWS_Service service = new gestor_taller.TallerWS_Service(JUDDIProxy.getWsdl());
        gestor_taller.TallerWS port = service.getTallerWSPort();
        return port.nuevoPedido(t.encrypt(encryptor, pedido));
    }
    
    public static boolean alta_WS(java.lang.String name, java.lang.String email, java.lang.String address, java.lang.String city, java.lang.String postalCode, java.lang.String telephone) {
    	SecretKey encryptor = generarClaveReto();
    	TripleDes t = new TripleDes();
        gestor_taller.TallerWS_Service service = new gestor_taller.TallerWS_Service(JUDDIProxy.getWsdl());
        gestor_taller.TallerWS port = service.getTallerWSPort();
        return port.alta(t.encrypt(encryptor, name), t.encrypt(encryptor, email), t.encrypt(encryptor, address), t.encrypt(encryptor, city), t.encrypt(encryptor, postalCode), t.encrypt(encryptor, telephone));
    }
    
    public static String checkActivacion_WS(String mail) {
    	SecretKey encryptor = generarClaveReto();
    	TripleDes t = new TripleDes();
    	TallerWS_Service service = new gestor_taller.TallerWS_Service(JUDDIProxy.getWsdl());
        gestor_taller.TallerWS port = service.getTallerWSPort();
        return port.checkActivacion(t.encrypt(encryptor, mail));
    }
    
    public static String getOfertas_WS(String listaPedidos) {
    	SecretKey encryptor = generarClaveReto();
    	TripleDes t = new TripleDes();
    	gestor_taller.TallerWS_Service service = new gestor_taller.TallerWS_Service(JUDDIProxy.getWsdl());
        gestor_taller.TallerWS port = service.getTallerWSPort();
        return port.getOfertas(t.encrypt(encryptor, listaPedidos));
    }
    
    public static Boolean aceptarOferta_WS(String id) {
    	SecretKey encryptor = generarClaveReto();
    	TripleDes t = new TripleDes();
    	gestor_taller.TallerWS_Service service= new gestor_taller.TallerWS_Service(JUDDIProxy.getWsdl());;
        gestor_taller.TallerWS port = service.getTallerWSPort();
        return port.aceptarOferta(t.encrypt(encryptor, id));
    }
    
    public static Boolean rechazarOferta_WS(String id) {
    	SecretKey encryptor = generarClaveReto();
    	TripleDes t = new TripleDes();
    	gestor_taller.TallerWS_Service service = new gestor_taller.TallerWS_Service(JUDDIProxy.getWsdl());
        gestor_taller.TallerWS port = service.getTallerWSPort();
        return port.rechazarOferta(t.encrypt(encryptor, id));
    }
    
    public static String hello() throws javax.xml.ws.WebServiceException{
    	SecretKey encryptor = generarClaveReto();
    	TripleDes t = new TripleDes();
    	gestor_taller.TallerWS_Service service = new TallerWS_Service(JUDDIProxy.getWsdl());
        gestor_taller.TallerWS port = service.getTallerWSPort();
        return port.hello();
    }
    
    public static Boolean baja_WS(String tallerID) {
    	SecretKey encryptor = generarClaveReto();
    	TripleDes t = new TripleDes();
    	gestor_taller.TallerWS_Service service = new gestor_taller.TallerWS_Service(JUDDIProxy.getWsdl());
        gestor_taller.TallerWS port = service.getTallerWSPort();
        return port.baja(t.encrypt(encryptor, tallerID));
    }
    
    public static boolean modificar_WS(String id, String name, String email, String address, String city, String postalCode, String telephone) {
    	SecretKey encryptor = generarClaveReto();
    	TripleDes t = new TripleDes();
    	gestor_taller.TallerWS_Service service = new gestor_taller.TallerWS_Service(JUDDIProxy.getWsdl());
        gestor_taller.TallerWS port = service.getTallerWSPort();
        return port.modificar(t.encrypt(encryptor, id), t.encrypt(encryptor, name), t.encrypt(encryptor, email), t.encrypt(encryptor, address), t.encrypt(encryptor, city), t.encrypt(encryptor, postalCode), t.encrypt(encryptor, telephone));
    }
    
    public static Boolean cancelarPedido_WS(String idPedido) {
    	SecretKey encryptor = generarClaveReto();
    	TripleDes t = new TripleDes();
    	gestor_taller.TallerWS_Service service = new gestor_taller.TallerWS_Service(JUDDIProxy.getWsdl());
        gestor_taller.TallerWS port = service.getTallerWSPort();
        return port.cancelarPedido(t.encrypt(encryptor, idPedido));
    }

    public static Boolean cambiarEstadoPedido_WS(int estado, java.lang.String id) {
    	SecretKey encryptor = generarClaveReto();
    	TripleDes t = new TripleDes();
    	gestor_taller.TallerWS_Service service = new gestor_taller.TallerWS_Service(JUDDIProxy.getWsdl());
        gestor_taller.TallerWS port = service.getTallerWSPort();
        return port.cambiarEstadoPedido(t.encrypt(encryptor, estado), t.encrypt(encryptor, id));
    }

    public static String getPedidos_WS(String id) {
    	SecretKey encryptor = generarClaveReto();
    	TripleDes t = new TripleDes();
    	gestor_taller.TallerWS_Service service = new gestor_taller.TallerWS_Service(JUDDIProxy.getWsdl());
        gestor_taller.TallerWS port = service.getTallerWSPort();
        return port.getPedidos(t.encrypt(encryptor, id));
    }

}
