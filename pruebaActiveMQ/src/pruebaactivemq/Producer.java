/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pruebaactivemq;

 
import javax.jms.Connection;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;
import org.apache.activemq.ActiveMQConnectionFactory;
 
public class Producer {
 
    public void produceMessage(String queueName) throws JMSException {
        //Create ConnectionFactory
        ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory();
        //Create Connection
        Connection connection = connectionFactory.createConnection();
        //Create Session
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        //Create Queue
        Destination queue = session.createQueue(queueName);
        //Create Producer
        MessageProducer producer = session.createProducer(queue);
        //Create Message
        TextMessage message = session.createTextMessage("Hello ActiveMQ");
        //Send Message
        producer.send(message);
        //Close Producer
        producer.close();
        //Close Session
        session.close();
        //Close Connection
        connection.close();
    }
}
