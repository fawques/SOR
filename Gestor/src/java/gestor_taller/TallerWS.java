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
import java.util.logging.Level;
import java.util.logging.Logger;
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
     * 
     * @param name
     * @param email
     * @param address
     * @param city
     * @param postalCode
     * @param telephone
     * @return
     * @throws SQLException
     * @throws ClassNotFoundException 
     */
    @WebMethod(operationName = "alta")
    public int alta(@WebParam(name = "name") String name, @WebParam(name = "email") String email, @WebParam(name = "address") String address, @WebParam(name = "city") String city, @WebParam(name = "postalCode") int postalCode, @WebParam(name = "telephone") int telephone) {
        try {
            bd = new InterfazBD("sor_gestor");
            return bd.altaTaller(name, email, address, city, postalCode, telephone, 0);
        } catch (java.sql.SQLException ex) {
            Logger.getLogger(TallerWS.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(TallerWS.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }
}
