using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using desguaceNET.inquiry;
using System.ServiceModel;

namespace desguaceNET.libSOR.jUDDI
{
    class jUDDIProxy
    {
        private static inquiry.UDDI_Inquiry_PortTypeClient client = new inquiry.UDDI_Inquiry_PortTypeClient();
        private static Uri wsdl;
        private static Uri urlActiveMQ;
        // urlUddi se puede configurar en Service References > inquiry > Configurar referencia de servicio...
    
        public static void loadWsdl(String servicio){
            try{
                load(servicio);
                load("ActiveMQ");
            }
            catch (EndpointNotFoundException e)
            {
                Console.WriteLine("##################");
                Console.WriteLine("Error loading jUDDI - default to localhost");
                Console.WriteLine("##################");
                wsdl = new Uri("http://localhost:8080/Gestor/services/DesguaceJavaWSPort?wsdl");
                urlActiveMQ = new Uri("tcp://localhost:61616");
            }
        }
        public static void load(String servicio){
                find_service fs = new find_service();
                string[] findQualifiers = new string[1];
                findQualifiers[0] = "exactMatch";
                fs.findQualifiers = findQualifiers;
                name[] names = new name[1];
                names[0] = new name();
                names[0].Value = servicio;
                fs.name = names;
                serviceList bi = client.find_service(fs);
                serviceInfo[] sis = bi.serviceInfos;
                if (sis != null && sis.Length != 0)
                {
                    serviceInfo si = sis[0];

                    string serviceKey = si.serviceKey;
                    get_serviceDetail gsd = new get_serviceDetail();
                    string[] servkey = new string[1];
                    servkey[0] = serviceKey;
                    gsd.serviceKey = servkey;


                    serviceDetail sd = client.get_serviceDetail(gsd);
                    businessService[] bsList = sd.businessService;
                    businessService bs = bsList[0];
                    bindingTemplate[] btList = bs.bindingTemplates;
                    bindingTemplate bt = btList[0];
                    accessPoint ap = bt.accessPoint;
                    String wsdlString = ap.Value;
                    if (servicio == "ActiveMQ")
                    {
                        urlActiveMQ = new Uri(wsdlString);
                    }
                    else
                    {
                        wsdl = new Uri(wsdlString);
                    }

                    Console.WriteLine("WSDL: " + wsdlString);
                }
        }

        public static Uri getWsdl() {
            return wsdl;
        }

        public static Uri getActiveMQ()
        {
            return urlActiveMQ;
        }
    }
}
