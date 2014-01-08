/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package gestor_desguace_java;

import activemq.Gestor_activemq;
import javax.jms.JMSException;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author Cute
 */
@WebService(serviceName = "DesguaceJavaWS")
public class DesguaceJavaWS {

    /**
     * Web service operation
     */
    @WebMethod(operationName = "getPedidos")
    public String getPedidos() throws JMSException {
      Gestor_activemq activemq= new Gestor_activemq("Pedidos");
      String pedidos= activemq.consumer.consumeMessage();
      activemq.consumer.closeConsumer();
        return pedidos;
    }
}
