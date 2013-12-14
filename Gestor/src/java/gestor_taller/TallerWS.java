/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package gestor_taller;

import general.Taller;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author fawques
 */
@WebService(serviceName = "TallerWS")
public class TallerWS {

    /**
     * Web service operation
     */
    @WebMethod(operationName = "alta")
    public Boolean alta(@WebParam(name = "ID") int ID,@WebParam(name = "name") String name, @WebParam(name = "email") String email, @WebParam(name = "address") String address, @WebParam(name = "city") String city, @WebParam(name = "postalCode") int postalCode, @WebParam(name = "telephone") int telephone) {
        Taller t = new Taller(ID,name, email, address, city, postalCode, telephone);
        return t != null?true:false;
    }
    
    @WebMethod(operationName = "envioNuevoPedido")
    public Boolean envioNuevoPedido(@WebParam(name = "ID") int ID,@WebParam(name = "name") String name, @WebParam(name = "email") String email, @WebParam(name = "address") String address, @WebParam(name = "city") String city, @WebParam(name = "postalCode") int postalCode, @WebParam(name = "telephone") int telephone) {
        Taller t = new Taller(ID,name, email, address, city, postalCode, telephone);
        return t != null?true:false;
    }
}
