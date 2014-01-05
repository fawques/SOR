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
import general.EstadoGeneral;
import general.Oferta;
import general.Pedido;
import general.Taller;
import java.lang.reflect.Type;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.jms.JMSException;
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
    public boolean alta(@WebParam(name = "name") String name, @WebParam(name = "email") String email, @WebParam(name = "address") String address, @WebParam(name = "city") String city, @WebParam(name = "postalCode") int postalCode, @WebParam(name = "telephone") int telephone) {
        try {
            bd = new InterfazBD("sor_gestor");
            Date ahora = new Date();
            String stringID  = DigestUtils.md5Hex(ahora.toString());
            boolean res = bd.altaTaller(stringID, name, email, address, city, postalCode, telephone, 2);
            bd.close();
            return res;
        } catch (java.sql.SQLException ex) {
            Logger.getLogger(TallerWS.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(TallerWS.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    /**
     *
     * @param email
     * @return
     */
    @WebMethod(operationName = "checkActivacion")
    public String checkActivacion(@WebParam(name = "mail") String email)    {
        try {
            bd = new InterfazBD("sor_gestor");
            Taller taller = bd.getTaller(email);
            String res;
            if (taller.getEstado() == EstadoGeneral.ACTIVE) {
                res = taller.getID();
            }else{
                res = "";
            }
            bd.close();
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
    public String nuevoPedido(@WebParam(name = "pedido") String pedido) throws JMSException {
         try {
            bd = new InterfazBD("sor_gestor");
            Gson gson = new Gson();
             Type collectionType = new TypeToken<Pedido>(){}.getType();
            Pedido p = gson.fromJson(pedido, collectionType);
            Date ahora = new Date();
            String stringID  = DigestUtils.md5Hex(ahora.toString());
            p.setID(stringID);
            bd.anadirPedido(stringID, p.getFecha_alta(), p.getEstado().ordinal(), p.getTaller(), p.getFecha_baja(), p.getFecha_limite());
            Gestor_activemq activemq= new Gestor_activemq("Pedidos");
            String pedidoFinal = gson.toJson(p);
            activemq.producer.produceMessage(pedidoFinal);
            activemq.producer.closeProduce(); // WARNING: esto hay que hacerlo aquí?
            bd.close();
            return stringID;
        } catch (SQLException ex) {
            Logger.getLogger(TallerWS.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(TallerWS.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return "";
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "getOfertas")
    public String getOfertas(@WebParam(name = "listaPedidos") String listaPedidos) {
        Type collectionType = new TypeToken<ArrayList<Oferta>>() {
        }.getType();
        Gson gson = new Gson();
        ArrayList<Oferta> listaOferta = new ArrayList<>();
        ArrayList<Pedido> arrayPedido = gson.fromJson(listaPedidos, collectionType);
        try {
            bd = new InterfazBD("sor_gestor");
            for (Pedido p : arrayPedido) {
                listaOferta.addAll(bd.getOfertasPedido(p.getID()));
            }
            bd.close();
            return gson.toJson(listaOferta);
        } catch (SQLException ex) {
            Logger.getLogger(TallerWS.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(TallerWS.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }
}
