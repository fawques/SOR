/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package gestor_taller;

import general.Pedido;
import java.util.Date;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author fawques
 */
@WebService(serviceName = "Taller")
public class Taller {

    /**
     * Web service operation
     */
    @WebMethod(operationName = "alta")
    public Boolean alta(@WebParam(name = "datos") String datos) {
        System.out.println("he recibido una petición de alta => " + datos);
        Pedido nuevo = new Pedido(0, new Date(), new Date(2014, 10, 1));
        return true;
    }
}
