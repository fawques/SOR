/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package activemq;

import javax.jms.JMSException;
import org.apache.log4j.BasicConfigurator;

/**
 *
 * @author Cute
 */
public class Gestor_activemq {
     
       public     Producer producer;
       public     Consumer consumer;
        public    String nombreCola;
    public Gestor_activemq(String _nombreCola) throws JMSException {
         BasicConfigurator.configure();
         nombreCola=_nombreCola;
         producer = new Producer(nombreCola);
         consumer = new Consumer(nombreCola);

    }
    
    
}
