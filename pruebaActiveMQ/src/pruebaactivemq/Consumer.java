/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pruebaactivemq;

import javax.jms.Connection;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageConsumer;
import javax.jms.Session;
import javax.jms.TextMessage;
import org.apache.activemq.ActiveMQConnectionFactory;
 
public class Consumer {
 
    public void consumeMessage(String queueName) throws JMSException {
        //Create ConnectionFactory
        ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory();
        //Create Connection
        Connection connection = connectionFactory.createConnection();
        //Create Session
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        //Create Queue
        Destination queue = session.createQueue(queueName);
        //Create Consumer
        MessageConsumer consumer = session.createConsumer(queue);
        //Start Connection
        /** Starts (or restarts) a connection's delivery of incoming messages. */
        connection.start();
        //Consume Message
        TextMessage message = (TextMessage) consumer.receive();
        //Display Message
        System.out.println(message.getText());
        //Close Consumer
        consumer.close();
        //Close Session
        session.close();
        //Close Connection
        connection.close();
    }
}