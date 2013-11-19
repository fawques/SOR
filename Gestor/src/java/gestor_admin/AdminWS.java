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
import java.util.ArrayList;
import java.util.Date;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;


/**
 *
 * @author Cute
 */
@WebService(serviceName = "AdminWS")
public class AdminWS {

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
    public String getAltas() {
        
        ArrayList<Taller> listaTalleres = new ArrayList<Taller>();
        listaTalleres.add(new Taller(1,"Silvia", "sdgm1@alu.ua.es", "Miau", "España", 1234,124124));
        listaTalleres.add(new Taller(2,"Silvia2", "sdgm1@alu.ua.es", "Miau", "España", 1234,124124));
        listaTalleres.get(0).nuevoPedido(new Date(), new Date(), new Date());
        Gson gson = new Gson();
        String listaJSON = gson.toJson(listaTalleres);
        System.out.println("listaJSON = " + listaJSON);
        return listaJSON;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "getPedidos")
    public String getPedidos() {
        ArrayList<Pedido> listaPedidos = new ArrayList<Pedido>();
        listaPedidos.add(new Pedido(1,1,new Date(), new Date(),new Date()));
       listaPedidos.add(new Pedido(2,1,new Date(), new Date(),new Date()));
        
        Gson gson = new Gson();
        String listaJSON = gson.toJson(listaPedidos);
        System.out.println("listaJSON = " + listaJSON);
        return listaJSON;
        
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "getOfertas")
    public String getOfertas() {
        ArrayList<Oferta> listaOfertas = new ArrayList<Oferta>();
        listaOfertas.add(new Oferta(1,new Date(),new Date(), new Date(),32.2,1,1));
        listaOfertas.add(new Oferta(2,new Date(),new Date(), new Date(),20.0,1,1));
        
        Gson gson = new Gson();
        String listaJSON = gson.toJson(listaOfertas);
        System.out.println("listaJSON = " + listaJSON);
        return listaJSON;
        
    }
}
