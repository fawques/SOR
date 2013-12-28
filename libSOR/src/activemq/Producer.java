/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package activemq;

 
import javax.jms.Connection;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;
import org.apache.activemq.ActiveMQConnectionFactory;
 
public class Producer {
    public
            ActiveMQConnectionFactory connectionFactory;
            Connection connection;
            Session session;
            Destination queue;
            MessageProducer producer;
 
    public Producer(String nombreCola) throws JMSException {
        connectionFactory = new ActiveMQConnectionFactory();
        connection = connectionFactory.createConnection();
        session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        queue = session.createQueue(nombreCola);
        producer = session.createProducer(queue);
        
    }
 
    public void produceMessage(String mensaje) throws JMSException {
        //Send Message

        producer.send(session.createTextMessage(mensaje));

    }
    public void closeProduce() throws JMSException{
            //Close Producer
        producer.close();
        //Close Session
        session.close();
        //Close Connection
        connection.close();
    }
}
