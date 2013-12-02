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

    /**
     * Web service operation
     */
    @WebMethod(operationName = "getDesguaces")
    public String getDesguaces() {
        ArrayList<Desguace> listaDesguaces = new ArrayList<Desguace>();
        listaDesguaces.add(new Desguace(1,"Pepito S.L", "comprame@gmai.com", "C/Mariano Luis", "España", 1234,124124));
        listaDesguaces.add(new Desguace(2,"Construcciones S.L", "todoparavender@gmail.com", "C/ Empresario Rico", "España", 1234,124124));

        Gson gson = new Gson();
        String listaJSON = gson.toJson(listaDesguaces);
        System.out.println("listaJSON = " + listaJSON);
        return listaJSON;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "getTalleres")
    public String getTalleres() {
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
    @WebMethod(operationName = "getOfertasporPedido")
    public String getOfertasporPedido(@WebParam(name = "idPedido") int idPedido) {
        ArrayList<Oferta> listaOfertas = new ArrayList<Oferta>();
        if(idPedido==1){
        listaOfertas.add(new Oferta(1,new Date(),new Date(), new Date(),32.2,1,1));
        listaOfertas.add(new Oferta(2,new Date(),new Date(), new Date(),20.0,1,1));
        }
        else{
        listaOfertas.add(new Oferta(1,new Date(),new Date(), new Date(),32.2,1,2));
        listaOfertas.add(new Oferta(2,new Date(),new Date(), new Date(),20.0,1,2));
        }

        
        Gson gson = new Gson();
        String listaJSON = gson.toJson(listaOfertas);
        System.out.println("listaJSON = " + listaJSON);
        return listaJSON;
    }
}
