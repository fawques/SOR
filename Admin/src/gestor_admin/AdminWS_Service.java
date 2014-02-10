package gestor_admin;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceFeature;
import javax.xml.ws.Service;

/**
 * This class was generated by Apache CXF 3.0.0-milestone1
 * 2014-02-10T11:24:33.659+01:00
 * Generated source version: 3.0.0-milestone1
 * 
 */
@WebServiceClient(name = "AdminWS", 
                  wsdlLocation = "http://localhost:8080/Gestor/services/AdminWSPort?wsdl",
                  targetNamespace = "http://gestor_admin/") 
public class AdminWS_Service extends Service {

    public final static URL WSDL_LOCATION;

    public final static QName SERVICE = new QName("http://gestor_admin/", "AdminWS");
    public final static QName AdminWSPort = new QName("http://gestor_admin/", "AdminWSPort");
    static {
        URL url = null;
        try {
            url = new URL("file:/C:/Users/Silvia/workspace/SOR/Gestor/WebContent/wsdl/adminws.wsdl");
        } catch (MalformedURLException e) {
            java.util.logging.Logger.getLogger(AdminWS_Service.class.getName())
                .log(java.util.logging.Level.INFO, 
                     "Can not initialize the default wsdl from {0}", "file:/C:/Users/Silvia/workspace/SOR/Gestor/WebContent/wsdl/adminws.wsdl");
        }
        WSDL_LOCATION = url;
    }

    public AdminWS_Service(URL wsdlLocation) {
        super(wsdlLocation, SERVICE);
    }

    public AdminWS_Service(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public AdminWS_Service() {
        super(WSDL_LOCATION, SERVICE);
    }
    
    //This constructor requires JAX-WS API 2.2. You will need to endorse the 2.2
    //API jar or re-run wsdl2java with "-frontend jaxws21" to generate JAX-WS 2.1
    //compliant code instead.
    public AdminWS_Service(WebServiceFeature ... features) {
        super(WSDL_LOCATION, SERVICE, features);
    }

    //This constructor requires JAX-WS API 2.2. You will need to endorse the 2.2
    //API jar or re-run wsdl2java with "-frontend jaxws21" to generate JAX-WS 2.1
    //compliant code instead.
    public AdminWS_Service(URL wsdlLocation, WebServiceFeature ... features) {
        super(wsdlLocation, SERVICE, features);
    }

    //This constructor requires JAX-WS API 2.2. You will need to endorse the 2.2
    //API jar or re-run wsdl2java with "-frontend jaxws21" to generate JAX-WS 2.1
    //compliant code instead.
    public AdminWS_Service(URL wsdlLocation, QName serviceName, WebServiceFeature ... features) {
        super(wsdlLocation, serviceName, features);
    }    

    /**
     *
     * @return
     *     returns AdminWS
     */
    @WebEndpoint(name = "AdminWSPort")
    public AdminWS getAdminWSPort() {
        return super.getPort(AdminWSPort, AdminWS.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns AdminWS
     */
    @WebEndpoint(name = "AdminWSPort")
    public AdminWS getAdminWSPort(WebServiceFeature... features) {
        return super.getPort(AdminWSPort, AdminWS.class, features);
    }

}
