using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using desguaceNET.inquiry;

namespace desguaceNET.libSOR.jUDDI
{
    class jUDDIProxy
    {
        private static inquiry.UDDI_Inquiry_PortTypeClient client = new inquiry.UDDI_Inquiry_PortTypeClient();
        private static Uri wsdl;
    
        public static void loadWsdl(string servicio) {
            
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
            if(sis != null && sis.Length != 0){
            serviceInfo si = sis[0];

            string serviceKey = si.serviceKey;
            get_serviceDetail gsd = new get_serviceDetail();
            string[] servkey = gsd.serviceKey;
            servkey[0] = serviceKey;

            serviceDetail sd = client.get_serviceDetail(gsd);
            businessService[] bsList = sd.businessService;
            businessService bs = bsList[0];
            bindingTemplate[] btList =  bs.bindingTemplates;
            bindingTemplate bt = btList[0];
            accessPoint ap = bt.accessPoint;
            String wsdlString = ap.Value;
            wsdl = new Uri(wsdlString);
            
            Console.WriteLine("WSDL: " + wsdlString);
            }
        }

        public static Uri getWsdl() {
            return wsdl;
        }
    }
}
