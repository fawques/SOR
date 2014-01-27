using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using Apache.NMS.ActiveMQ;

namespace desguaceNET.libSOR.activemq
{
    class Gestor_activemq
    {
        public Consumer consumer;
        public string nombreCola;
        public Gestor_activemq()
        {
            //BasicConfigurator.configure();

        }

        public void create_Consumer(String _nombreCola)
        {
            consumer = new Consumer(_nombreCola);
        }
    }
}
