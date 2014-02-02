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
import general.EstadoOferta;
import general.EstadoPedido;
import general.Oferta;
import general.Pedido;
import general.PedidoCorto;
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
      @WebMethod(operationName = "alta")
    public boolean alta(@WebParam(name = "name") String name, @WebParam(name = "email") String email, @WebParam(name = "address") String address, @WebParam(name = "city") String city, @WebParam(name = "postalCode") String postalCode, @WebParam(name = "telephone") String telephone) {
    
        try {       
            bd = new InterfazBD("sor_gestor");

            Date ahora = new Date();
            String stringID  = DigestUtils.md5Hex(ahora.toString());
            boolean res = bd.altaDesguace(stringID, name, email, address, city, Integer.parseInt(postalCode), Integer.parseInt(telephone), 2);
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

    /**
     * Web service operation
     */
    @WebMethod(operationName = "nuevaOferta")
    public String nuevaOferta(@WebParam(name = "oferta") String oferta) {
        try {          
            bd = new InterfazBD("sor_gestor");
             Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ss").create();
             Type collectionType = new TypeToken<Oferta>() {
             }.getType();
             Oferta p = gson.fromJson(oferta, collectionType);
            Date ahora = new Date();
            String stringID  = DigestUtils.md5Hex(ahora.toString());
            p.setID(stringID);
             bd.anadirOferta(stringID, p.getFecha_alta(),p.getPrecio(), EstadoOferta.ACTIVE.ordinal(),  p.getPedido(), p.getDesguace(), p.getFecha_baja(),p.getFecha_limite());
            bd.close();
            return stringID;
        } catch (SQLException ex) {
            Logger.getLogger(DesguaceJavaWS.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DesguaceJavaWS.class.getName()).log(Level.SEVERE, null, ex);
        }
           

        return "";

    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "getOfertas")
    public String getOfertas() {
        try {   
            bd = new InterfazBD("sor_gestor");
             ArrayList<Oferta> listaOfertas = new ArrayList<Oferta>();
            listaOfertas=bd.getOfertas();
            Gson gson = new GsonBuilder().setDateFormat("MMM dd, yyyy hh:mm:ss a").create();
            String listaJSON = gson.toJson(listaOfertas);
            System.out.println("listaJSON = " + listaJSON);
            return listaJSON;
        } catch (SQLException ex) {
            Logger.getLogger(DesguaceJavaWS.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DesguaceJavaWS.class.getName()).log(Level.SEVERE, null, ex);
        }
           return "";
        }       

    /**
     * Web service operation
     */
    @WebMethod(operationName = "getPedidosporID")
    public String getPedidosporID(@WebParam(name = "string") String string) {
          Gson gson = new Gson();
        try {
            bd = new InterfazBD("sor_gestor");
             Type collectionType = new TypeToken<ArrayList<String>>(){}.getType();
             ArrayList<String>  listaids = gson.fromJson(string, collectionType);
            ArrayList<Pedido> listapedidos= new ArrayList<Pedido>();
             for(String s: listaids){
                 listapedidos.add(bd.getPedidoID(s));
             }
             Gson gsonn = new GsonBuilder().setDateFormat("MMM dd, yyyy hh:mm:ss a").create();
            String listaJSON = gsonn.toJson(listapedidos);
            System.out.println("listaJSON = " + listaJSON);
            return listaJSON;
        } catch (SQLException ex) {
            Logger.getLogger(DesguaceJavaWS.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DesguaceJavaWS.class.getName()).log(Level.SEVERE, null, ex);
        }
           
        return null;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "aceptarOfertaFin")
    public Boolean aceptarOfertaFin(@WebParam(name = "id") String id) {
        Boolean aceptada=false;
        try {
            bd = new InterfazBD("sor_gestor");
            aceptada=bd.cambiarEstadoOferta(EstadoOferta.FINISHED_OK, id);
            bd.close();
            return aceptada;
            
        } catch (SQLException ex) {
            Logger.getLogger(DesguaceJavaWS.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DesguaceJavaWS.class.getName()).log(Level.SEVERE, null, ex);
        }
        return aceptada;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "cancelarOferta")
    public Boolean cancelarOferta(@WebParam(name = "id") String id) {
        Boolean aceptada=false;
        try {
            bd = new InterfazBD("sor_gestor");
            aceptada=bd.cambiarEstadoOferta(EstadoOferta.CANCELLED, id);
            bd.close();
            
            return aceptada;
            
        } catch (SQLException ex) {
            Logger.getLogger(DesguaceJavaWS.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DesguaceJavaWS.class.getName()).log(Level.SEVERE, null, ex);
        }
        return aceptada;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "baja")
    public Boolean baja(@WebParam(name = "id") String id) {
        try {        
            bd = new InterfazBD("sor_gestor");
            boolean oool = bd.bajaDesguace(id);
            bd.close();
            return oool;
        } catch (SQLException ex) {
            Logger.getLogger(DesguaceJavaWS.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DesguaceJavaWS.class.getName()).log(Level.SEVERE, null, ex);
        }
            
      
        return false;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "cambiarEstadoPedido")
    public Boolean cambiarEstadoPedido(@WebParam(name = "id") String id, @WebParam(name = "estado") int estado) {
         
            Gson gson = new Gson();
        try {
            bd= new InterfazBD("sor_gestor");
           return  bd.cambiarEstadoPedido(EstadoPedido.values()[estado], id);
      
        } catch (SQLException ex) {
            Logger.getLogger(DesguaceJavaWS.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DesguaceJavaWS.class.getName()).log(Level.SEVERE, null, ex);
        }
            
       
        return false;
    }
    
}

