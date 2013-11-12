/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package gestor_admin;

import general.Taller;
import java.util.ArrayList;
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
    public ArrayList<Taller> getAltas() {
        System.out.println("hola");
        ArrayList<Taller> listaTalleres = new ArrayList<Taller>();
        listaTalleres.add(new Taller("Silvia", "sdgm1@alu.ua.es", "Miau", "España", 1234,124124));
        listaTalleres.add(new Taller("Silvia2", "sdgm1@alu.ua.es", "Miau", "España", 1234,124124));
        
        return listaTalleres;
    }
}
