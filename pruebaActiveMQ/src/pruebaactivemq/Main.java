/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pruebaactivemq;

import javax.jms.JMSException;
import org.apache.log4j.BasicConfigurator;
 
public class Main {
 
    public static void main(String[] args) throws JMSException {
        //BasicConfigurator.configure();
        String queueName = "Pedidos";
        Producer producer = new Producer();
       // Consumer consumer = new Consumer();
         
        producer.produceMessage(queueName);
        //consumer.consumeMessage(queueName);
    }
}