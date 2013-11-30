/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package gestor_taller;

import BD.Conexion;
import BD.InterfazBD;
import general.Taller;
import java.sql.SQLException;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author fawques
 */
@WebService(serviceName = "TallerWS")
public class TallerWS {
    
    InterfazBD bd;
    /**
     * Web service operation
     */
    @WebMethod(operationName = "alta")
    public Boolean alta(@WebParam(name = "ID") int ID,@WebParam(name = "name") String name, @WebParam(name = "email") String email, @WebParam(name = "address") String address, @WebParam(name = "city") String city, @WebParam(name = "postalCode") int postalCode, @WebParam(name = "telephone") int telephone) throws SQLException, ClassNotFoundException {
        Taller t = new Taller(ID,name, email, address, city, postalCode, telephone);
        
        bd = new InterfazBD("sor_taller");
        
        return t != null?true:false;
        //return codigoGestor
    }
}
