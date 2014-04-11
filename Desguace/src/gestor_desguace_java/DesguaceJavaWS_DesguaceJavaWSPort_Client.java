
package gestor_desguace_java;

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
 * 2014-04-11T11:53:35.861+02:00
 * Generated source version: 3.0.0-milestone1
 * 
 */
public final class DesguaceJavaWS_DesguaceJavaWSPort_Client {

    private static final QName SERVICE_NAME = new QName("http://gestor_desguace_java/", "DesguaceJavaWS");

    private DesguaceJavaWS_DesguaceJavaWSPort_Client() {
    }

    public static void main(String args[]) throws java.lang.Exception {
        URL wsdlURL = DesguaceJavaWS_Service.WSDL_LOCATION;
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
      
        DesguaceJavaWS_Service ss = new DesguaceJavaWS_Service(wsdlURL, SERVICE_NAME);
        DesguaceJavaWS port = ss.getDesguaceJavaWSPort();  
        
        {
        System.out.println("Invoking checkActivacion...");
        java.lang.String _checkActivacion_mail = "_checkActivacion_mail772085683";
        java.lang.String _checkActivacion__return = port.checkActivacion(_checkActivacion_mail);
        System.out.println("checkActivacion.result=" + _checkActivacion__return);


        }
        {
        System.out.println("Invoking getPedidoporID...");
        java.lang.String _getPedidoporID_string = "_getPedidoporID_string915407932";
        java.lang.String _getPedidoporID__return = port.getPedidoporID(_getPedidoporID_string);
        System.out.println("getPedidoporID.result=" + _getPedidoporID__return);


        }
        {
        System.out.println("Invoking getPedidosporID...");
        java.lang.String _getPedidosporID_string = "_getPedidosporID_string964945142";
        java.lang.String _getPedidosporID__return = port.getPedidosporID(_getPedidosporID_string);
        System.out.println("getPedidosporID.result=" + _getPedidosporID__return);


        }
        {
        System.out.println("Invoking modificar...");
        java.lang.String _modificar_id = "_modificar_id-855316615";
        java.lang.String _modificar_name = "_modificar_name-1963585402";
        java.lang.String _modificar_email = "_modificar_email-1303918397";
        java.lang.String _modificar_address = "_modificar_address603747038";
        java.lang.String _modificar_city = "_modificar_city1759236646";
        java.lang.String _modificar_postalCode = "_modificar_postalCode-1954389762";
        java.lang.String _modificar_telephone = "_modificar_telephone-1865041752";
        boolean _modificar__return = port.modificar(_modificar_id, _modificar_name, _modificar_email, _modificar_address, _modificar_city, _modificar_postalCode, _modificar_telephone);
        System.out.println("modificar.result=" + _modificar__return);


        }
        {
        System.out.println("Invoking cambiarEstadoPedido...");
        java.lang.String _cambiarEstadoPedido_id = "_cambiarEstadoPedido_id-1328752481";
        java.lang.String _cambiarEstadoPedido_estado = "_cambiarEstadoPedido_estado73615806";
        java.lang.Boolean _cambiarEstadoPedido__return = port.cambiarEstadoPedido(_cambiarEstadoPedido_id, _cambiarEstadoPedido_estado);
        System.out.println("cambiarEstadoPedido.result=" + _cambiarEstadoPedido__return);


        }
        {
        System.out.println("Invoking alta...");
        java.lang.String _alta_name = "_alta_name414837073";
        java.lang.String _alta_email = "_alta_email-1555599119";
        java.lang.String _alta_address = "_alta_address-1844857294";
        java.lang.String _alta_city = "_alta_city179075502";
        java.lang.String _alta_postalCode = "_alta_postalCode-294812327";
        java.lang.String _alta_telephone = "_alta_telephone-418410034";
        boolean _alta__return = port.alta(_alta_name, _alta_email, _alta_address, _alta_city, _alta_postalCode, _alta_telephone);
        System.out.println("alta.result=" + _alta__return);


        }
        {
        System.out.println("Invoking aceptarOfertaFin...");
        java.lang.String _aceptarOfertaFin_id = "_aceptarOfertaFin_id842738996";
        java.lang.Boolean _aceptarOfertaFin__return = port.aceptarOfertaFin(_aceptarOfertaFin_id);
        System.out.println("aceptarOfertaFin.result=" + _aceptarOfertaFin__return);


        }
        {
        System.out.println("Invoking getOfertas...");
        java.lang.String _getOfertas_string = "_getOfertas_string-1972475032";
        java.lang.String _getOfertas__return = port.getOfertas(_getOfertas_string);
        System.out.println("getOfertas.result=" + _getOfertas__return);


        }
        {
        System.out.println("Invoking baja...");
        java.lang.String _baja_id = "_baja_id1494654308";
        java.lang.Boolean _baja__return = port.baja(_baja_id);
        System.out.println("baja.result=" + _baja__return);


        }
        {
        System.out.println("Invoking nuevaOferta...");
        java.lang.String _nuevaOferta_oferta = "_nuevaOferta_oferta-919805733";
        java.lang.String _nuevaOferta__return = port.nuevaOferta(_nuevaOferta_oferta);
        System.out.println("nuevaOferta.result=" + _nuevaOferta__return);


        }
        {
        System.out.println("Invoking cambiarEstadoPedidoOtravez...");
        java.lang.String _cambiarEstadoPedidoOtravez_id = "_cambiarEstadoPedidoOtravez_id58691545";
        java.lang.String _cambiarEstadoPedidoOtravez_estado = "_cambiarEstadoPedidoOtravez_estado-236340159";
        java.lang.Boolean _cambiarEstadoPedidoOtravez__return = port.cambiarEstadoPedidoOtravez(_cambiarEstadoPedidoOtravez_id, _cambiarEstadoPedidoOtravez_estado);
        System.out.println("cambiarEstadoPedidoOtravez.result=" + _cambiarEstadoPedidoOtravez__return);


        }
        {
        System.out.println("Invoking cancelarOferta...");
        java.lang.String _cancelarOferta_id = "_cancelarOferta_id828796999";
        java.lang.Boolean _cancelarOferta__return = port.cancelarOferta(_cancelarOferta_id);
        System.out.println("cancelarOferta.result=" + _cancelarOferta__return);


        }

        System.exit(0);
    }

}
