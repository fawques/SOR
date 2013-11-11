/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package gestor_taller;

import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author fawques
 */
@WebService(serviceName = "TallerWS")
public class TallerWS {

    /**
     * This is a sample web service operation
     */
    @WebMethod(operationName = "alta")
    public String alta(@WebParam(name = "name") String txt) {
        System.out.println("He recibido" + txt);
        return "Hello " + txt + " !";
    }
}
