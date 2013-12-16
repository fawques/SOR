/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package gestor_taller;

import BD.InterfazBD;
import activemq.Gestor_activemq;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import general.Pedido;
import java.lang.reflect.Type;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.jms.JMSException;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

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
            int res = bd.altaTaller(name, email, address, city, postalCode, telephone, 2);
            //bd.close();
            return res;
        } catch (java.sql.SQLException ex) {
            Logger.getLogger(TallerWS.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(TallerWS.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }
    
    /**
     *
     * @param email
     * @return
     */
    @WebMethod(operationName = "activarTaller")
    public String activarTaller(@WebParam(name = "mail") String email)    {
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

    /**
     * Web service operation
     */
    @WebMethod(operationName = "nuevoPedido")
    public Boolean nuevoPedido(@WebParam(name = "pedido") String pedido) throws JMSException {
         try {
            bd = new InterfazBD("sor_gestor");
            Gson gson = new Gson();
             Type collectionType = new TypeToken<Pedido>(){}.getType();
            Pedido p = gson.fromJson(pedido, collectionType);
           // bd.anadirPedido(p.getID(), p.getFecha_alta(), p.getEstado().ordinal(), p.getTaller(), p.getFecha_baja(), p.getFecha_limite());
            Gestor_activemq activemq= new Gestor_activemq("Pedidos");
            activemq.producer.produceMessage(pedido);
            activemq.producer.closeProduce();
            // bd.close();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(TallerWS.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(TallerWS.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return false;
    }
}
