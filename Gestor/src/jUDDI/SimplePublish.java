/*
 * Copyright 2001-2010 The Apache Software Foundation.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */
package jUDDI;

import java.net.Inet4Address;
import java.net.UnknownHostException;
import java.rmi.RemoteException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.apache.juddi.api_v3.Publisher;
import org.apache.juddi.api_v3.PublisherDetail;
import org.apache.juddi.api_v3.SavePublisher;
import org.apache.juddi.v3_service.JUDDIApiPortType;
import org.uddi.api_v3.AccessPoint;
import org.uddi.api_v3.AuthToken;
import org.uddi.api_v3.BindingTemplate;
import org.uddi.api_v3.BindingTemplates;
import org.uddi.api_v3.BusinessDetail;
import org.uddi.api_v3.BusinessEntity;
import org.uddi.api_v3.BusinessInfo;
import org.uddi.api_v3.BusinessInfos;
import org.uddi.api_v3.BusinessList;
import org.uddi.api_v3.BusinessService;
import org.uddi.api_v3.Description;
import org.uddi.api_v3.FindBusiness;
import org.uddi.api_v3.GetAuthToken;
import org.uddi.api_v3.Name;
import org.uddi.api_v3.SaveBusiness;
import org.uddi.api_v3.SaveService;
import org.uddi.api_v3.ServiceDetail;
import org.uddi.v3_service.DispositionReportFaultMessage;
import org.uddi.v3_service.UDDIPublicationPortType;
import org.uddi.v3_service.UDDISecurityPortType;


public class SimplePublish {

    private static UDDISecurityPortType security = null;

    private static JUDDIApiPortType juddiApi = null;
    private static UDDIPublicationPortType publish = null;

    public SimplePublish(){
//        try {
//        	// create a client and read the config in the archive; 
//            // you can use your config file name
//            UDDIClient uddiClient = new UDDIClient();/*("META-INF/uddi.xml");*/
//        	// a UddiClient can be a client to multiple UDDI nodes, so 
//            // supply the nodeName (defined in your uddi.xml.
//            // The transport can be WS, inVM, RMI etc which is defined in the uddi.xml
//            Transport transport = uddiClient.getTransport("default");
//            // Now you create a reference to the UDDI API
//            security = transport.getUDDISecurityService();
//            juddiApi = transport.getJUDDIApiService();
//            publish = transport.getUDDIPublishService();
//        } catch (TransportException e) {
//            e.printStackTrace();
//        } catch (ConfigurationException ex) {
//            Logger.getLogger(SimplePublish.class.getName()).log(Level.SEVERE, null, ex);
//        }
    }

    public void publish() {
        String ip = "localhost";
        try {
             ip = Inet4Address.getLocalHost().getHostAddress();
        } catch (UnknownHostException ex) {
            Logger.getLogger(SimplePublish.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        // servcicios[i][0] = Nombre (TallerWS)
        // servicios[i][1] = Descripcion (Lo que queramos)
        // servicios[i][2] = URL del wsdl
        String[][] servicios = new String[3][3];
        servicios[0][0] = "TallerWS";
        servicios[0][1] = "TallerWSPort";
        servicios[0][2] = "http://" + ip + ":8080/Gestor/services/TallerWSPort?wsdl";
        servicios[1][0] = "AdminWS";
        servicios[1][1] = "AdminWSPort";
        servicios[1][2] = "http://" + ip + ":8080/Gestor/services/AdminWSPort?wsdl";
        servicios[2][0] = "DesguaceJavaWS";
        servicios[2][1] = "DesguaceJavaWSPort";
        servicios[2][2] = "http://" + ip + ":8080/Gestor/services/DesguaceJavaWSPort?wsdl";
        try {
            
            // Setting up the values to get an authentication token for the 'root' user ('root' user has admin privileges
            // and can save other publishers).
            GetAuthToken getAuthTokenRoot = new GetAuthToken();
            getAuthTokenRoot.setUserID("root");
            getAuthTokenRoot.setCred("root");

            // Making API call that retrieves the authentication token for the 'root' user.
            AuthToken rootAuthToken = getAuthToken(getAuthTokenRoot);
            System.out.println("root AUTHTOKEN = " + rootAuthToken.getAuthInfo());

            // Creating a new publisher that we will use to publish our entities to.
            Publisher p = new Publisher();
            p.setAuthorizedName("SOR");
            p.setPublisherName("SOR");

            // Adding the publisher to the "save" structure, using the 'root' user authentication info and saving away. 
            SavePublisher sp = new SavePublisher();
            sp.getPublisher().add(p);
            sp.setAuthInfo(rootAuthToken.getAuthInfo());
            savePublisher(sp);

            // Our publisher is now saved, so now we want to retrieve its authentication token
            GetAuthToken getAuthTokenMyPub = new GetAuthToken();
            getAuthTokenMyPub.setUserID("SOR");
            getAuthTokenMyPub.setCred("");
            AuthToken myPubAuthToken = getAuthToken(getAuthTokenMyPub);
            System.out.println("SOR: AUTHTOKEN = " + myPubAuthToken.getAuthInfo());

            
            /*
            
             ====== A partir de aquí está lo que deberia hacer para registrar los WS ========
            
            */
            
            // Creating the parent business entity that will contain our service.
            BusinessEntity myBusEntity = new BusinessEntity();
            Name myBusName = new Name();
            myBusName.setValue("Gestor");
            myBusEntity.getName().add(myBusName);
            
            FindBusiness fb = new FindBusiness();
            Name n = new Name();
            n.setValue("Gestor");
            fb.getName().add(n);
            BusinessList busList = findBusiness(fb);
            BusinessInfos businessInfos = busList.getBusinessInfos();
            if(businessInfos!=null){
                  
                  List<BusinessInfo> businessInfoList = businessInfos.getBusinessInfo();
                  if (businessInfoList.size()> 0) {
                      myBusEntity.setBusinessKey(businessInfoList.get(0).getBusinessKey());
                  }
            
            }
          
            
            // Adding the business entity to the "save" structure, using our publisher's authentication info and saving away.
            SaveBusiness sb = new SaveBusiness();
            sb.getBusinessEntity().add(myBusEntity);
            sb.setAuthInfo(myPubAuthToken.getAuthInfo());
            BusinessDetail bd = saveBusiness(sb);
            String myBusKey = bd.getBusinessEntity().get(0).getBusinessKey();
            System.out.println("myBusiness key:  " + myBusKey);

            /*
                ======= Foreach webservice ======
            */
            for (String[] serv : servicios) {
                
            
                // Creating a service to save.  Only adding the minimum data: the parent business key retrieved from saving the business 
                // above and a single name.
                BusinessService myService = new BusinessService();
                myService.setBusinessKey(myBusKey);
                Name myServName = new Name();
                myServName.setValue(serv[0]);
                myService.getName().add(myServName);
                Description myServDescription = new Description();
                myServDescription.setValue(serv[1]);
                myService.getDescription().add(myServDescription);

                // Add binding templates, etc...
                BindingTemplate myBindingTemplate = new BindingTemplate();
                AccessPoint accessPoint = new AccessPoint();
                accessPoint.setValue(serv[2]);
                myBindingTemplate.setAccessPoint(accessPoint);
                //myBindingTemplate.setBindingKey("TallerWS"); --> no sé si hace falta
                BindingTemplates myBindingTemplates = new BindingTemplates();
                myBindingTemplates.getBindingTemplate().add(myBindingTemplate);
                myService.setBindingTemplates(myBindingTemplates);

                // Adding the service to the "save" structure, using our publisher's authentication info and saving away.
                SaveService ss = new SaveService();
                ss.getBusinessService().add(myService);
                ss.setAuthInfo(myPubAuthToken.getAuthInfo());
                ServiceDetail sd = saveService(ss);
                String myServKey = sd.getBusinessService().get(0).getServiceKey();
                System.out.println("myService key:  " + myServKey);
            }
            /*
                ===== End foreach ==
            */
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    private static AuthToken getAuthToken(org.uddi.api_v3.GetAuthToken body) {
        org.uddi.v3_service.UDDISecurityService service = new org.uddi.v3_service.UDDISecurityService();
        org.uddi.v3_service.UDDISecurityPortType port = service.getUDDISecurityImplPort();
        return port.getAuthToken(body);
    }
    
    private static BusinessDetail saveBusiness(org.uddi.api_v3.SaveBusiness body) {
        org.uddi.v3_service.UDDIPublicationService service = new org.uddi.v3_service.UDDIPublicationService();
        org.uddi.v3_service.UDDIPublicationPortType port = service.getUDDIPublicationImplPort();
        return port.saveBusiness(body);
}

    private static ServiceDetail saveService(org.uddi.api_v3.SaveService body) {
        org.uddi.v3_service.UDDIPublicationService service = new org.uddi.v3_service.UDDIPublicationService();
        org.uddi.v3_service.UDDIPublicationPortType port = service.getUDDIPublicationImplPort();
        return port.saveService(body);
    }

    private static void deleteBusiness(org.uddi.api_v3.DeleteBusiness body) {
        org.uddi.v3_service.UDDIPublicationService service = new org.uddi.v3_service.UDDIPublicationService();
        org.uddi.v3_service.UDDIPublicationPortType port = service.getUDDIPublicationImplPort();
        port.deleteBusiness(body);
    }

    private static BusinessList findBusiness(org.uddi.api_v3.FindBusiness body) throws RemoteException {
        org.uddi.v3_service.UDDIInquiryService service = new org.uddi.v3_service.UDDIInquiryService();
        org.uddi.v3_service.UDDIInquiryPortType port = service.getUDDIInquiryImplPort();
        return port.findBusiness(body);
    }

    private static PublisherDetail savePublisher(org.apache.juddi.api_v3.SavePublisher body) {
        org.apache.juddi.v3_service.JUDDIApiService service = new org.apache.juddi.v3_service.JUDDIApiService();
        org.apache.juddi.v3_service.JUDDIApiPortType port = service.getJUDDIApiImplPort();
        return port.savePublisher(body);
    }
}
