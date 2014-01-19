/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package gestor_taller;

import BD.InterfazBD;
import activemq.Gestor_activemq;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import general.EstadoGeneral;
import general.EstadoOferta;
import general.EstadoPedido;
import general.Oferta;
import general.Pedido;
import general.Taller;
import java.lang.reflect.Type;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
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
    
    public boolean modificar(@WebParam(name = "id") String id, @WebParam(name = "name") String name, @WebParam(name = "email") String email, @WebParam(name = "address") String address, @WebParam(name = "city") String city, @WebParam(name = "postalCode") String postalCode, @WebParam(name = "telephone") String telephone) {
        try {
            bd = new InterfazBD("sor_gestor");
            boolean res = bd.modificarTaller(id, name, email, city, city, Integer.parseInt(postalCode), Integer.parseInt(telephone), EstadoGeneral.ACTIVE);
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
             Type collectionType = new TypeToken<Pedido>() {
             }.getType();
             Pedido p = gson.fromJson(pedido, collectionType);
            Date ahora = new Date();
            String stringID  = DigestUtils.md5Hex(ahora.toString());
            p.setID(stringID);
             bd.anadirPedido(stringID, p.getFecha_alta(), EstadoPedido.ACCEPTED.ordinal(), p.getTaller(), p.getFecha_baja(), p.getFecha_limite(), p.getModoAutomatico());
            Gestor_activemq activemq= new Gestor_activemq();
            activemq.create_Producer("pedidos");
            String pedidoFinal = gson.toJson(p.getID());
            activemq.producer.produceMessage(pedidoFinal);
            activemq.producer.closeProduce();
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
        Type collectionType = new TypeToken<ArrayList<Pedido>>() {
        }.getType();
        Gson gson = new GsonBuilder().setDateFormat("MMM dd, yyyy").create();
        ArrayList<Oferta> listaOferta = new ArrayList<>();
        ArrayList<Pedido> arrayPedido = new ArrayList<Pedido>();
        arrayPedido = gson.fromJson(listaPedidos, collectionType);
        try {
            bd = new InterfazBD("sor_gestor");
            for (Iterator<Pedido> it = arrayPedido.iterator(); it.hasNext();) {
                Pedido p = it.next();
                listaOferta.addAll(bd.getOfertasPedido(p.getID(), EstadoOferta.ACTIVE));
            }
             Gson gsonn = new GsonBuilder().setDateFormat("MMM dd, yyyy hh:mm:ss a").create();
            String retu=gsonn.toJson(listaOferta);
            bd.close();
            return retu;
        } catch (SQLException ex) {
            Logger.getLogger(TallerWS.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(TallerWS.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "aceptarOferta")
    public Boolean aceptarOferta(@WebParam(name = "ID") String ID) {
        try {
            bd = new InterfazBD("sor_gestor");
            bd.cambiarEstadoOferta(EstadoOferta.ACCEPTED, ID);
            bd.close();
        } catch (SQLException ex) {
            Logger.getLogger(TallerWS.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(TallerWS.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "rechazarOferta")
    public Boolean rechazarOferta(@WebParam(name = "ID") String ID) {
        try {
            bd = new InterfazBD("sor_gestor");
            bd.cambiarEstadoOferta(EstadoOferta.REJECTED, ID);
            bd.close();
        } catch (SQLException ex) {
            Logger.getLogger(TallerWS.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(TallerWS.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "hello")
    public String hello() {
        return "hello";
    }
    
    @WebMethod(operationName = "baja")
    public Boolean bajaTaller(@WebParam(name = "tallerID") String tallerID) {
        try {
            bd = new InterfazBD("sor_gestor");
            boolean oool = bd.bajaTaller(tallerID);
            bd.close();
            return oool;
        } catch (SQLException ex) {
            Logger.getLogger(TallerWS.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(TallerWS.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "alta")
    public boolean alta(@WebParam(name = "name") String name, @WebParam(name = "email") String email, @WebParam(name = "address") String address, @WebParam(name = "city") String city, @WebParam(name = "postalCode") String postalCode, @WebParam(name = "telephone") String telephone) {
        try {
            bd = new InterfazBD("sor_gestor");
            Date ahora = new Date();
            String stringID  = DigestUtils.md5Hex(ahora.toString());
            boolean res = bd.altaTaller(stringID, name, email, address, city, Integer.parseInt(postalCode), Integer.parseInt(telephone), EstadoGeneral.PENDIENTE.ordinal());
            bd.close();
            return res;
        } catch (java.sql.SQLException ex) {
            Logger.getLogger(TallerWS.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(TallerWS.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
        
    @WebMethod(operationName = "cancelarPedido")
    public Boolean cancelarPedido(@WebParam(name = "idPedido") String idPedido) {
        try {
            bd = new InterfazBD("sor_gestor");
            boolean oool = bd.cancelarPedido(idPedido);
            bd.close();
            return oool;
        } catch (SQLException ex) {
            Logger.getLogger(TallerWS.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(TallerWS.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

}
