/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package activemq;

import javax.jms.Connection;
import javax.jms.Connection;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageConsumer;
import javax.jms.Session;
import javax.jms.TextMessage;
import org.apache.activemq.ActiveMQConnectionFactory;
 
public class Consumer {
    public
            //Create ConnectionFactory
        ActiveMQConnectionFactory connectionFactory ;
        //Create Connection
        Connection connection;
        //Create Session
        Session session;
        //Create Queue
        Destination queue;
        //Create Consumer
        MessageConsumer consumer;
    public Consumer(String queueName) throws JMSException {
            //Create ConnectionFactory
        connectionFactory = new ActiveMQConnectionFactory();
        //Create Connection
       connection = connectionFactory.createConnection();
        //Create Session
        session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        //Create Queue
        queue = session.createQueue(queueName);
        //Create Consumer
         consumer = session.createConsumer(queue);
    }
 
    public String consumeMessage() throws JMSException {

        //Start Connection
        /** Starts (or restarts) a connection's delivery of incoming messages. */
        connection.start();
        //Consume Message
        TextMessage message = (TextMessage) consumer.receive();
        //Display Message
        
        System.out.println(message.getText());
        return message.getText();
    }
    public void closeConsumer() throws JMSException{
            //Close Consumer
        consumer.close();
        //Close Session
        session.close();
        //Close Connection
        connection.close();
    }
}