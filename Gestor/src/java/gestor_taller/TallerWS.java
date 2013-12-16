/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package gestor_taller;

import BD.InterfazBD;
import java.sql.SQLException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import org.apache.commons.codec.digest.DigestUtils;

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
            Date ahora = new Date();
            String stringID  = DigestUtils.md5Hex(ahora.toString());
            int res = bd.altaTaller(stringID, name, email, address, city, postalCode, telephone, 2);
            //bd.close();
            return res;
        } catch (java.sql.SQLException ex) {
            Logger.getLogger(TallerWS.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(TallerWS.class.getName()).log(Level.SEVERE, null, ex);
        }
        return -1;
    }
    
    /**
     *
     * @param email
     * @return
     */
    @WebMethod(operationName = "activarTaller")
    public String activarTaller(@WebParam(name = "mail") String email)
    {
        try {
            bd = new InterfazBD("sor_gestor");
            String res = bd.activarTaller(email);
           // bd.close();
            return res;
        } catch (SQLException ex) {
            Logger.getLogger(TallerWS.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(TallerWS.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ""; //devolvemos el estado pendiente, por defecto
    }
    
    @WebMethod(operationName = "envioNuevoPedido")
    public Boolean envioNuevoPedido(@WebParam(name = "ID") int ID,@WebParam(name = "name") String name, @WebParam(name = "email") String email, @WebParam(name = "address") String address, @WebParam(name = "city") String city, @WebParam(name = "postalCode") int postalCode, @WebParam(name = "telephone") int telephone) {
        Taller t = new Taller(ID,name, email, address, city, postalCode, telephone);
        return t != null?true:false;
    }
}
