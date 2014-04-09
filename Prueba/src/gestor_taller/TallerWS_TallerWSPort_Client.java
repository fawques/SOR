
package gestor_taller;

/**
 * Please modify this class to meet your needs
 * This class is not complete
 */

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

/**
 * This class was generated by Apache CXF 3.0.0-milestone1
 * 2014-04-08T17:50:45.689+02:00
 * Generated source version: 3.0.0-milestone1
 * 
 */
public final class TallerWS_TallerWSPort_Client {

    private static final QName SERVICE_NAME = new QName("http://gestor_taller/", "TallerWS");

    private TallerWS_TallerWSPort_Client() {
    }

    public static void main(String args[]) throws java.lang.Exception {
        URL wsdlURL = TallerWS_Service.WSDL_LOCATION;
        if (args.length > 0 && args[0] != null && !"".equals(args[0])) { 
            File wsdlFile = new File(args[0]);
            try {
                if (wsdlFile.exists()) {
                    wsdlURL = wsdlFile.toURI().toURL();
                } else {
                    wsdlURL = new URL(args[0]);
                }
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
        }
      
        TallerWS_Service ss = new TallerWS_Service(wsdlURL, SERVICE_NAME);
        TallerWS port = ss.getTallerWSPort();  
        
        {
        System.out.println("Invoking alta...");
        java.lang.String _alta_name = "_alta_name-1783566035";
        java.lang.String _alta_email = "_alta_email-1175945175";
        java.lang.String _alta_address = "_alta_address-672306987";
        java.lang.String _alta_city = "_alta_city-239241368";
        java.lang.String _alta_postalCode = "_alta_postalCode-666790926";
        java.lang.String _alta_telephone = "_alta_telephone-1715362923";
        boolean _alta__return = port.alta(_alta_name, _alta_email, _alta_address, _alta_city, _alta_postalCode, _alta_telephone);
        System.out.println("alta.result=" + _alta__return);


        }
        {
        System.out.println("Invoking cancelarPedido...");
        java.lang.String _cancelarPedido_idPedido = "_cancelarPedido_idPedido1197839454";
        java.lang.String _cancelarPedido_idTaller = "_cancelarPedido_idTaller2099411955";
        java.lang.String _cancelarPedido_password = "_cancelarPedido_password-116310400";
        java.lang.Boolean _cancelarPedido__return = port.cancelarPedido(_cancelarPedido_idPedido, _cancelarPedido_idTaller, _cancelarPedido_password);
        System.out.println("cancelarPedido.result=" + _cancelarPedido__return);


        }
        {
        System.out.println("Invoking generarClaveReto...");
        java.lang.String _generarClaveReto_idTaller = "_generarClaveReto_idTaller1139884700";
        java.lang.String _generarClaveReto_password = "_generarClaveReto_password-1644453008";
        java.lang.String _generarClaveReto__return = port.generarClaveReto(_generarClaveReto_idTaller, _generarClaveReto_password);
        System.out.println("generarClaveReto.result=" + _generarClaveReto__return);


        }
        {
        System.out.println("Invoking cambiarEstadoPedido...");
        java.lang.String _cambiarEstadoPedido_idTaller = "_cambiarEstadoPedido_idTaller2006007254";
        java.lang.String _cambiarEstadoPedido_password = "_cambiarEstadoPedido_password-1756616643";
        int _cambiarEstadoPedido_estado = 431402617;
        java.lang.String _cambiarEstadoPedido_id = "_cambiarEstadoPedido_id-914241091";
        java.lang.Boolean _cambiarEstadoPedido__return = port.cambiarEstadoPedido(_cambiarEstadoPedido_idTaller, _cambiarEstadoPedido_password, _cambiarEstadoPedido_estado, _cambiarEstadoPedido_id);
        System.out.println("cambiarEstadoPedido.result=" + _cambiarEstadoPedido__return);


        }
        {
        System.out.println("Invoking getPedidos...");
        java.lang.String _getPedidos_idTaller = "_getPedidos_idTaller151376555";
        java.lang.String _getPedidos_password = "_getPedidos_password-605028727";
        java.lang.String _getPedidos__return = port.getPedidos(_getPedidos_idTaller, _getPedidos_password);
        System.out.println("getPedidos.result=" + _getPedidos__return);


        }
        {
        System.out.println("Invoking baja...");
        java.lang.String _baja_tallerID = "_baja_tallerID1622296947";
        java.lang.String _baja_password = "_baja_password-1608030949";
        java.lang.Boolean _baja__return = port.baja(_baja_tallerID, _baja_password);
        System.out.println("baja.result=" + _baja__return);


        }
        {
        System.out.println("Invoking hello...");
        java.lang.String _hello__return = port.hello();
        System.out.println("hello.result=" + _hello__return);


        }
        {
        System.out.println("Invoking modificar...");
        java.lang.String _modificar_id = "_modificar_id-2047945990";
        java.lang.String _modificar_password = "_modificar_password745415203";
        java.lang.String _modificar_name = "_modificar_name1699840626";
        java.lang.String _modificar_email = "_modificar_email-789965942";
        java.lang.String _modificar_address = "_modificar_address751522290";
        java.lang.String _modificar_city = "_modificar_city1164564170";
        java.lang.String _modificar_postalCode = "_modificar_postalCode-540641836";
        java.lang.String _modificar_telephone = "_modificar_telephone1995679093";
        boolean _modificar__return = port.modificar(_modificar_id, _modificar_password, _modificar_name, _modificar_email, _modificar_address, _modificar_city, _modificar_postalCode, _modificar_telephone);
        System.out.println("modificar.result=" + _modificar__return);


        }
        {
        System.out.println("Invoking checkActivacion...");
        java.lang.String _checkActivacion_mail = "_checkActivacion_mail-1685840811";
        java.lang.String _checkActivacion__return = port.checkActivacion(_checkActivacion_mail);
        System.out.println("checkActivacion.result=" + _checkActivacion__return);


        }
        {
        System.out.println("Invoking getOfertas...");
        java.lang.String _getOfertas_listaPedidos = "_getOfertas_listaPedidos20400423";
        java.lang.String _getOfertas_idTaller = "_getOfertas_idTaller-1114093695";
        java.lang.String _getOfertas_password = "_getOfertas_password-9539528";
        java.lang.String _getOfertas__return = port.getOfertas(_getOfertas_listaPedidos, _getOfertas_idTaller, _getOfertas_password);
        System.out.println("getOfertas.result=" + _getOfertas__return);


        }
        {
        System.out.println("Invoking aceptarOferta...");
        java.lang.String _aceptarOferta_id = "_aceptarOferta_id-156929356";
        java.lang.String _aceptarOferta_idTaller = "_aceptarOferta_idTaller-1465217303";
        java.lang.String _aceptarOferta_password = "_aceptarOferta_password-585725380";
        java.lang.Boolean _aceptarOferta__return = port.aceptarOferta(_aceptarOferta_id, _aceptarOferta_idTaller, _aceptarOferta_password);
        System.out.println("aceptarOferta.result=" + _aceptarOferta__return);


        }
        {
        System.out.println("Invoking nuevoPedido...");
        java.lang.String _nuevoPedido_pedido = "_nuevoPedido_pedido-1041382174";
        java.lang.String _nuevoPedido_idTaller = "_nuevoPedido_idTaller490582748";
        java.lang.String _nuevoPedido_password = "_nuevoPedido_password-468449999";
        try {
            java.lang.String _nuevoPedido__return = port.nuevoPedido(_nuevoPedido_pedido, _nuevoPedido_idTaller, _nuevoPedido_password);
            System.out.println("nuevoPedido.result=" + _nuevoPedido__return);

        } catch (JMSException_Exception e) { 
            System.out.println("Expected exception: JMSException has occurred.");
            System.out.println(e.toString());
        }
            }
        {
        System.out.println("Invoking rechazarOferta...");
        java.lang.String _rechazarOferta_id = "_rechazarOferta_id566970428";
        java.lang.String _rechazarOferta_idTaller = "_rechazarOferta_idTaller1763741499";
        java.lang.String _rechazarOferta_password = "_rechazarOferta_password-948394864";
        java.lang.Boolean _rechazarOferta__return = port.rechazarOferta(_rechazarOferta_id, _rechazarOferta_idTaller, _rechazarOferta_password);
        System.out.println("rechazarOferta.result=" + _rechazarOferta__return);


        }

        System.exit(0);
    }

}
