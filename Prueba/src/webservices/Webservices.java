/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package webservices;

import java.util.HashMap;
import java.util.Map;

import jUDDI.JUDDIProxy;
import gestor_taller.JMSException;
import gestor_taller.JMSException_Exception;
import gestor_taller.TallerWS_Service;

import org.apache.cxf.frontend.ClientProxy;
import org.apache.cxf.ws.security.wss4j.WSS4JInInterceptor;
import org.apache.cxf.ws.security.wss4j.WSS4JOutInterceptor;

/**
 *
 * @author fawques
 */
public class Webservices {
	
    static public String nuevoPedido_WS(String pedido) throws JMSException_Exception {
        gestor_taller.TallerWS_Service service = new gestor_taller.TallerWS_Service(JUDDIProxy.getWsdl());
        gestor_taller.TallerWS port = service.getTallerWSPort();
        /* Security */
    	org.apache.cxf.endpoint.Client client = ClientProxy.getClient(port);
    	org.apache.cxf.endpoint.Endpoint cxfEndpoint = client.getEndpoint();
    	//Map<String,Object> inProps= new HashMap<String,Object>();
    	//WSS4JInInterceptor wssIn = new WSS4JInInterceptor(inProps);
    	
    	
    	//cxfEndpoint.getInInterceptors().add(wssIn);
        //client.getOutInterceptors().remove(wssIn);
    	Map<String,Object> outProps = new HashMap<String,Object>();
    	outProps.put("action", "UsernameToken");
        outProps.put("user", "alice");
        outProps.put("passwordType", "PasswordText");
    	WSS4JOutInterceptor wssOut = new WSS4JOutInterceptor(outProps);
    	cxfEndpoint.getOutInterceptors().add(wssOut);
    	/* endSecurity */
        return port.nuevoPedido(pedido);
    }
    
    public static boolean alta_WS(java.lang.String name, java.lang.String email, java.lang.String address, java.lang.String city, java.lang.String postalCode, java.lang.String telephone) {
        gestor_taller.TallerWS_Service service = new gestor_taller.TallerWS_Service(JUDDIProxy.getWsdl());
        gestor_taller.TallerWS port = service.getTallerWSPort();
        return port.alta(name, email, address, city, postalCode, telephone);
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
