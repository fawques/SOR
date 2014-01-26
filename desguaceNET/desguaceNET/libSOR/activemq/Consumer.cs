using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using Apache.NMS;
using Apache.NMS.ActiveMQ;
using Newtonsoft.Json;

namespace desguaceNET.libSOR.activemq
{
    class Consumer
    {
        private IConnection connection;
        private IConnectionFactory connectionFactory;
        private ISession session;
        IDestination queue;
        IMessageConsumer consumer;



        public Consumer(string queueName)
        {
            //Create ConnectionFactory
            connectionFactory = new ConnectionFactory("failover:(tcp://192.168.1.104:61616)");
            //Create Connection
            connection = connectionFactory.CreateConnection();
            //Create Session
            session = connection.CreateSession(AcknowledgementMode.AutoAcknowledge);
            //Create Queue
            queue = session.GetQueue(queueName);
            //Create Consumer
            consumer = session.CreateConsumer(queue);

        }

        public string consumeMessage(){
    //Gson gson = new GsonBuilder().setDateFormat("MMM dd, yyyy hh:mm:ss a").create();
        
        //Start Connection
        /** Starts (or restarts) a connection's delivery of incoming messages. */
        connection.Start();
        //Consume Message
        IMessage message =  consumer.Receive(new TimeSpan(10000));
        var textMessage = message as ITextMessage;

       /* if(message==null){
            throw new javax.jms.IllegalStateException("no ha cogido ningún mensaje");
        }*/
        List<string> listamensaje= new List<string>();
        
        while(message!=null){
            listamensaje.Add(textMessage.Text.Replace("\"",""));
            message =  consumer.ReceiveNoWait();
            textMessage = message as ITextMessage;
        }
        string listaJSON = JsonConvert.SerializeObject(listamensaje);
        //Display Message

       
        return listaJSON;
    }
        public void closeConsumer()
        {
            //Close Consumer
            consumer.Close();
            //Close Session
            session.Close();
            //Close Connection
            connection.Close();
        }
    }
}
