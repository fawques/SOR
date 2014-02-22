/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package webservices;

import jUDDI.JUDDIProxy;

/**
 *
 * @author pablovm1990
 */
public class Webservices {
    public static boolean alta_WS(java.lang.String name, java.lang.String email, java.lang.String address, java.lang.String city, String postalCode, String telephone) {
        gestor_desguace_java.DesguaceJavaWS_Service service = new gestor_desguace_java.DesguaceJavaWS_Service(JUDDIProxy.getWsdl());
        gestor_desguace_java.DesguaceJavaWS port = service.getDesguaceJavaWSPort();
        return port.alta(name, email, address, city, postalCode, telephone);
    }

    public static String checkActivacion_WS(java.lang.String mail) {
        gestor_desguace_java.DesguaceJavaWS_Service service = new gestor_desguace_java.DesguaceJavaWS_Service(JUDDIProxy.getWsdl());
        gestor_desguace_java.DesguaceJavaWS port = service.getDesguaceJavaWSPort();
        return port.checkActivacion(mail);
    }

    public static String getOfertas_WS() {
        gestor_desguace_java.DesguaceJavaWS_Service service = new gestor_desguace_java.DesguaceJavaWS_Service(JUDDIProxy.getWsdl());
        gestor_desguace_java.DesguaceJavaWS port = service.getDesguaceJavaWSPort();
        return port.getOfertas();
    }
    
    public static String nuevaOferta_WS(java.lang.String oferta) {
        gestor_desguace_java.DesguaceJavaWS_Service service = new gestor_desguace_java.DesguaceJavaWS_Service(JUDDIProxy.getWsdl());
        gestor_desguace_java.DesguaceJavaWS port = service.getDesguaceJavaWSPort();
        return port.nuevaOferta(oferta);
    }

    public static String getPedidosporID_WS(java.lang.String string) {
        gestor_desguace_java.DesguaceJavaWS_Service service = new gestor_desguace_java.DesguaceJavaWS_Service(JUDDIProxy.getWsdl());
        gestor_desguace_java.DesguaceJavaWS port = service.getDesguaceJavaWSPort();
        return port.getPedidosporID(string);
    }
    public static String getPedidoporID_WS(java.lang.String string) {
        gestor_desguace_java.DesguaceJavaWS_Service service = new gestor_desguace_java.DesguaceJavaWS_Service(JUDDIProxy.getWsdl());
        gestor_desguace_java.DesguaceJavaWS port = service.getDesguaceJavaWSPort();
        return port.getPedidoporID(string);
    }
    public static Boolean aceptarOfertaFin_WS(java.lang.String id) {
        gestor_desguace_java.DesguaceJavaWS_Service service = new gestor_desguace_java.DesguaceJavaWS_Service(JUDDIProxy.getWsdl());
        gestor_desguace_java.DesguaceJavaWS port = service.getDesguaceJavaWSPort();
        return port.aceptarOfertaFin(id);
    }

    public static Boolean cancelarOferta_WS(java.lang.String id) {
        gestor_desguace_java.DesguaceJavaWS_Service service = new gestor_desguace_java.DesguaceJavaWS_Service(JUDDIProxy.getWsdl());
        gestor_desguace_java.DesguaceJavaWS port = service.getDesguaceJavaWSPort();
        return port.cancelarOferta(id);
    }

    public static Boolean baja_WS(java.lang.String id) {
        gestor_desguace_java.DesguaceJavaWS_Service service = new gestor_desguace_java.DesguaceJavaWS_Service(JUDDIProxy.getWsdl());
        gestor_desguace_java.DesguaceJavaWS port = service.getDesguaceJavaWSPort();
        return port.baja(id);
    }

    public static Boolean cambiarEstadoPedido_WS(java.lang.String id, java.lang.String estado) {
        gestor_desguace_java.DesguaceJavaWS_Service service = new gestor_desguace_java.DesguaceJavaWS_Service(JUDDIProxy.getWsdl());
        gestor_desguace_java.DesguaceJavaWS port = service.getDesguaceJavaWSPort();
        return port.cambiarEstadoPedidoOtravez(id, estado);
    }
    public static boolean modificar_WS(String id, String name, String email, String address, String city, String postalCode, String telephone) {
    	gestor_desguace_java.DesguaceJavaWS_Service service = new gestor_desguace_java.DesguaceJavaWS_Service(JUDDIProxy.getWsdl());
    	 gestor_desguace_java.DesguaceJavaWS port = service.getDesguaceJavaWSPort();
        return port.modificar(id, name, email, address, city, postalCode, telephone);
    }
}
