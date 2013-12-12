/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package gestor_admin;

import com.google.gson.Gson;
import general.Oferta;
import general.Pedido;
import general.Taller;
import general.Desguace;
import general.EstadoGeneral;
import general.Pieza;
import java.util.ArrayList;
import java.util.Date;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import BD.InterfazBD;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import com.google.gson.GsonBuilder;
import java.text.DateFormat;


/**
 *
 * @author Cute
 */
@WebService(serviceName = "AdminWS")
public class AdminWS {
 InterfazBD bd;
    /**
     * This is a sample web service operation
     */
    @WebMethod(operationName = "hello")
    public String hello(@WebParam(name = "name") String txt) {
        return "Hello " + txt + " !";
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "getAltas")
    public String getAltas(){
        try{
            bd = new InterfazBD("sor_gestor");
            ArrayList<Taller> listaTalleres = new ArrayList<Taller>();
     //   listaTalleres.add(new Taller(1,"Silvia", "sdgm1@alu.ua.es", "Miau", "España", 1234,124124));
      //  listaTalleres.add(new Taller(2,"Silvia2", "sdgm1@alu.ua.es", "Miau", "España", 1234,124124));
            listaTalleres=bd.getTalleres();
            listaTalleres.get(0).nuevoPedido(new Date());
            Gson gson = new GsonBuilder().setDateFormat("MMM dd, yyyy hh:mm:ss a").create();
            String listaJSON = gson.toJson(listaTalleres);
            System.out.println("listaJSON = " + listaJSON);
            return listaJSON;
        } catch (SQLException ex) {        
         Logger.getLogger(AdminWS.class.getName()).log(Level.SEVERE, null, ex);
     } catch (ClassNotFoundException ex) {
         Logger.getLogger(AdminWS.class.getName()).log(Level.SEVERE, null, ex);
     }        
        return null;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "getPedidos")
    public String getPedidos() {
        Gson gson = new GsonBuilder().setDateFormat("MMM dd, yyyy hh:mm:ss a").create();
        //Dec 7, 2013 5:46:35 PM
         try{
            ArrayList<Pedido> listaPedidos = new ArrayList<Pedido>();            
            bd = new InterfazBD("sor_gestor");
            listaPedidos=bd.getPedidosActivos();
            String listaJSON = gson.toJson(listaPedidos);
            System.out.println("listaJSON = " + listaJSON);
            return listaJSON;
        }        
        catch (ClassNotFoundException ex) {
         Logger.getLogger(AdminWS.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
         Logger.getLogger(AdminWS.class.getName()).log(Level.SEVERE, null, ex);
     } 
        return null;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "getOfertas")
    public String getOfertas() {
         try{
            bd = new InterfazBD("sor_gestor");
            ArrayList<Oferta> listaOfertas = new ArrayList<Oferta>();
        //listaOfertas.add(new Oferta(1,new Date(),new Date(), new Date(),32.2,1,1));
        //listaOfertas.add(new Oferta(2,new Date(),new Date(), new Date(),20.0,1,1));
            listaOfertas=bd.getOfertas();
            Gson gson = new GsonBuilder().setDateFormat("MMM dd, yyyy hh:mm:ss a").create();
            String listaJSON = gson.toJson(listaOfertas);
            System.out.println("listaJSON = " + listaJSON);
            return listaJSON;
        }        
        catch (ClassNotFoundException ex) {
         Logger.getLogger(AdminWS.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
         Logger.getLogger(AdminWS.class.getName()).log(Level.SEVERE, null, ex);
     }

        
        return null;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "getDesguaces")
    public String getDesguaces() {
         try{
            bd = new InterfazBD("sor_gestor");
            ArrayList<Desguace> listaDesguaces = new ArrayList<Desguace>();
       // listaDesguaces.add(new Desguace(1,"Pepito S.L", "comprame@gmai.com", "C/Mariano Luis", "España", 1234,124124));
        //listaDesguaces.add(new Desguace(2,"Construcciones S.L", "todoparavender@gmail.com", "C/ Empresario Rico", "España", 1234,124124));
            listaDesguaces=bd.getDesguaces();
            Gson gson = new GsonBuilder().setDateFormat("MMM dd, yyyy hh:mm:ss a").create();
            String listaJSON = gson.toJson(listaDesguaces);
            System.out.println("listaJSON = " + listaJSON);
            return listaJSON;
        }        
        catch (ClassNotFoundException ex) {
         Logger.getLogger(AdminWS.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
         Logger.getLogger(AdminWS.class.getName()).log(Level.SEVERE, null, ex);
     }
         return null;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "getTalleres")
    public String getTalleres() {
         try{
            bd = new InterfazBD("sor_gestor");
             ArrayList<Taller> listaTalleres = new ArrayList<Taller>();
             listaTalleres=bd.getTalleres();
            //listaTalleres.add(new Taller(1,"Silvia", "sdgm1@alu.ua.es", "Miau", "España", 1234,124124));
            //listaTalleres.add(new Taller(2,"Silvia2", "sdgm1@alu.ua.es", "Miau", "España", 1234,124124));
            listaTalleres.get(0).nuevoPedido(new Date());
            Gson gson = new GsonBuilder().setDateFormat("MMM dd, yyyy hh:mm:ss a").create();
            String listaJSON = gson.toJson(listaTalleres);
            System.out.println("listaJSON = " + listaJSON);
            return listaJSON;
        }        
        catch (ClassNotFoundException ex) {
         Logger.getLogger(AdminWS.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
         Logger.getLogger(AdminWS.class.getName()).log(Level.SEVERE, null, ex);
     }
        return null;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "getOfertasporPedido")
    public String getOfertasporPedido(@WebParam(name = "idPedido") int idPedido) {
         Gson gson = new GsonBuilder().setDateFormat("MMM dd, yyyy hh:mm:ss a").create();
        //Dec 7, 2013 5:46:35 PM
         try{
            ArrayList<Oferta> listaOfertas = new ArrayList<Oferta>();           
            bd = new InterfazBD("sor_gestor");
            listaOfertas=bd.getOfertasPedido(idPedido);
            String listaJSON = gson.toJson(listaOfertas);
            System.out.println("listaJSON = " + listaJSON);
            return listaJSON; 
        }        
        catch (ClassNotFoundException ex) {
         Logger.getLogger(AdminWS.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
         Logger.getLogger(AdminWS.class.getName()).log(Level.SEVERE, null, ex);
     }
        return null;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "getPedidoID")
    public String getPedidoID(@WebParam(name = "id") int id) {
         try{
            bd = new InterfazBD("sor_gestor");
        }        
        catch (ClassNotFoundException ex) {
         Logger.getLogger(AdminWS.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
         Logger.getLogger(AdminWS.class.getName()).log(Level.SEVERE, null, ex);
     }
        ArrayList<Pedido> listaPedido = new ArrayList<Pedido>();

        listaPedido.add(new Pedido(1,1,new Date()));
        Pieza p = new Pieza(1, "Patatas Maria", EstadoGeneral.ACTIVE, null);
        listaPedido.get(0).addPieza(p, 11);
        Gson gson = new GsonBuilder().setDateFormat("MMM dd, yyyy hh:mm:ss a").create();
        String listaJSON = gson.toJson(listaPedido);
        System.out.println("listaJSON = " + listaJSON);
        return listaJSON;
    }
}
