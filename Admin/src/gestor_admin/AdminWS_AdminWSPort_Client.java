
package gestor_admin;

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
 * 2014-02-10T11:24:33.565+01:00
 * Generated source version: 3.0.0-milestone1
 * 
 */
public final class AdminWS_AdminWSPort_Client {

    private static final QName SERVICE_NAME = new QName("http://gestor_admin/", "AdminWS");

    private AdminWS_AdminWSPort_Client() {
    }

    public static void main(String args[]) throws java.lang.Exception {
        URL wsdlURL = AdminWS_Service.WSDL_LOCATION;
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
      
        AdminWS_Service ss = new AdminWS_Service(wsdlURL, SERVICE_NAME);
        AdminWS port = ss.getAdminWSPort();  
        
        {
        System.out.println("Invoking getPedidos...");
        java.lang.String _getPedidos__return = port.getPedidos();
        System.out.println("getPedidos.result=" + _getPedidos__return);


        }
        {
        System.out.println("Invoking sendMail...");
        java.lang.String _sendMail_arg0 = "_sendMail_arg0-1649841593";
        java.lang.String _sendMail_arg1 = "_sendMail_arg11038785131";
        java.lang.String _sendMail_arg2 = "_sendMail_arg2-1775643697";
        java.lang.String _sendMail_arg3 = "_sendMail_arg3-1004909064";
        port.sendMail(_sendMail_arg0, _sendMail_arg1, _sendMail_arg2, _sendMail_arg3);


        }
        {
        System.out.println("Invoking getAltaDesguace...");
        java.lang.String _getAltaDesguace__return = port.getAltaDesguace();
        System.out.println("getAltaDesguace.result=" + _getAltaDesguace__return);


        }
        {
        System.out.println("Invoking getTalleres...");
        java.lang.String _getTalleres__return = port.getTalleres();
        System.out.println("getTalleres.result=" + _getTalleres__return);


        }
        {
        System.out.println("Invoking addAccesoDesguace...");
        java.lang.String _addAccesoDesguace_id = "_addAccesoDesguace_id1725711527";
        java.lang.Boolean _addAccesoDesguace__return = port.addAccesoDesguace(_addAccesoDesguace_id);
        System.out.println("addAccesoDesguace.result=" + _addAccesoDesguace__return);


        }
        {
        System.out.println("Invoking registrar...");
        java.lang.String _registrar__return = port.registrar();
        System.out.println("registrar.result=" + _registrar__return);


        }
        {
        System.out.println("Invoking getDesguaces...");
        java.lang.String _getDesguaces__return = port.getDesguaces();
        System.out.println("getDesguaces.result=" + _getDesguaces__return);


        }
        {
        System.out.println("Invoking hello...");
        java.lang.String _hello__return = port.hello();
        System.out.println("hello.result=" + _hello__return);


        }
        {
        System.out.println("Invoking darAccesoTaller...");
        java.lang.String _darAccesoTaller_id = "_darAccesoTaller_id921621716";
        java.lang.Boolean _darAccesoTaller__return = port.darAccesoTaller(_darAccesoTaller_id);
        System.out.println("darAccesoTaller.result=" + _darAccesoTaller__return);


        }
        {
        System.out.println("Invoking getPedidoID...");
        java.lang.String _getPedidoID_id = "_getPedidoID_id615584967";
        java.lang.String _getPedidoID__return = port.getPedidoID(_getPedidoID_id);
        System.out.println("getPedidoID.result=" + _getPedidoID__return);


        }
        {
        System.out.println("Invoking getAltaTalleres...");
        java.lang.String _getAltaTalleres__return = port.getAltaTalleres();
        System.out.println("getAltaTalleres.result=" + _getAltaTalleres__return);


        }
        {
        System.out.println("Invoking getOfertasporPedido...");
        java.lang.String _getOfertasporPedido_idPedido = "_getOfertasporPedido_idPedido1335382250";
        java.lang.String _getOfertasporPedido__return = port.getOfertasporPedido(_getOfertasporPedido_idPedido);
        System.out.println("getOfertasporPedido.result=" + _getOfertasporPedido__return);


        }
        {
        System.out.println("Invoking getOfertas...");
        java.lang.String _getOfertas__return = port.getOfertas();
        System.out.println("getOfertas.result=" + _getOfertas__return);


        }

        System.exit(0);
    }

}