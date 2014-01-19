/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package activemq;

import activemq.Consumer;
import activemq.Producer;
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
    public Gestor_activemq() throws JMSException {
         BasicConfigurator.configure();

    }
    public void create_Producer(String _nombreCola) throws JMSException{
    producer = new Producer(_nombreCola);
    }
    public void create_Consumer(String _nombreCola) throws JMSException{
    consumer = new Consumer(_nombreCola);
    }
    
    
}
