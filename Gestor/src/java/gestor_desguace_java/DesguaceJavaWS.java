/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package gestor_desguace_java;

import BD.InterfazBD;
import activemq.Gestor_activemq;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import general.Desguace;
import general.EstadoGeneral;
import general.Pedido;
import java.lang.reflect.Type;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.jms.JMSException;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import org.apache.commons.codec.digest.DigestUtils;

/**
 *
 * @author Cute
 */
@WebService(serviceName = "DesguaceJavaWS")
public class DesguaceJavaWS {
    InterfazBD bd;
    /**
     * Web service operation
     */
    @WebMethod(operationName = "getPedidos")
    public String getPedidos() {
        
        try {
            Gson gson = new GsonBuilder().setDateFormat("MMM dd, yyyy hh:mm:ss a").create();
            ArrayList<Pedido> listaPedidos = new ArrayList<Pedido>();
            ArrayList<String> listaIdsString = new ArrayList<String>();
            Type collectionType = new TypeToken<ArrayList<String>>(){}.getType();
            Gestor_activemq activemq= new Gestor_activemq();
            activemq.create_Consumer("patata");
            listaIdsString = gson.fromJson(activemq.consumer.consumeMessage(), collectionType); 
            activemq.consumer.closeConsumer();
            
            bd = new InterfazBD("sor_gestor");
            for(String pedidotaller:listaIdsString){
                listaPedidos.add(bd.getPedidoID(pedidotaller));
            }
            String listaJSON = gson.toJson(listaPedidos);
            System.out.println("listaJSON = " + listaJSON);
            return listaJSON;
 
        } catch (JMSException ex) {
            Logger.getLogger(DesguaceJavaWS.class.getName()).log(Level.SEVERE, null, ex);
            
        } catch (SQLException ex) {
            Logger.getLogger(DesguaceJavaWS.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DesguaceJavaWS.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "";
    }
      @WebMethod(operationName = "alta")
    public boolean alta(@WebParam(name = "name") String name, @WebParam(name = "email") String email, @WebParam(name = "address") String address, @WebParam(name = "city") String city, @WebParam(name = "postalCode") int postalCode, @WebParam(name = "telephone") int telephone) {

        try {       
            bd = new InterfazBD("sor_gestor");

            Date ahora = new Date();
            String stringID  = DigestUtils.md5Hex(ahora.toString());
            boolean res = bd.altaDesguace(stringID, name, email, address, city, postalCode, telephone, 2);
            bd.close();
            return res;
        } catch (SQLException ex) {
            Logger.getLogger(DesguaceJavaWS.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DesguaceJavaWS.class.getName()).log(Level.SEVERE, null, ex);
        }


       return false;

    }
    
        @WebMethod(operationName = "checkActivacion")
    public String checkActivacion(@WebParam(name = "mail") String email){

        try {

            bd = new InterfazBD("sor_gestor");
            Desguace desguace = bd.getDesguace(email);
            String res;
            if (desguace.getEstado() == EstadoGeneral.ACTIVE) {
                res = desguace.getID();
            }else{
                res = "";
            }
            bd.close();
            return res;

            
            
            

        } catch (SQLException ex) {
            Logger.getLogger(DesguaceJavaWS.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DesguaceJavaWS.class.getName()).log(Level.SEVERE, null, ex);
        }

        return "";

    }
}

