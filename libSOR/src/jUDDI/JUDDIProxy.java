/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jUDDI;

import java.net.Inet4Address;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.uddi.api_v3.AccessPoint;
import org.uddi.api_v3.AuthToken;
import org.uddi.api_v3.BindingTemplate;
import org.uddi.api_v3.BindingTemplates;
import org.uddi.api_v3.BusinessList;
import org.uddi.api_v3.BusinessService;
import org.uddi.api_v3.FindQualifiers;
import org.uddi.api_v3.FindService;
import org.uddi.api_v3.GetAuthToken;
import org.uddi.api_v3.GetServiceDetail;
import org.uddi.api_v3.Name;
import org.uddi.api_v3.ServiceDetail;
import org.uddi.api_v3.ServiceInfo;
import org.uddi.api_v3.ServiceInfos;
import org.uddi.api_v3.ServiceList;

/**
 *
 * @author fawques
 */
public class JUDDIProxy {
    private static URL wsdl;
    
    public static void loadWsdl(String servicio) {
        FindService fs = new FindService();
        FindQualifiers fq = new FindQualifiers();
        fq.getFindQualifier().add("exactMatch");
        fs.setFindQualifiers(fq);
        Name name = new Name();
        name.setValue(servicio);
        fs.getName().add(name);
        ServiceList bi = findService(fs);
        ServiceInfos sis = bi.getServiceInfos();
        List<ServiceInfo> siList = sis.getServiceInfo();
        ServiceInfo si = siList.get(0);

        String serviceKey = si.getServiceKey();

        GetServiceDetail gsd = new GetServiceDetail();
        gsd.getServiceKey().add(serviceKey);
        ServiceDetail sd = getServiceDetail(gsd);
        List<BusinessService> bsList = sd.getBusinessService();
        BusinessService bs = bsList.get(0);
        BindingTemplates bts =  bs.getBindingTemplates();
        List<BindingTemplate> btList = bts.getBindingTemplate();
        BindingTemplate bt = btList.get(0);
        AccessPoint ap = bt.getAccessPoint();
        String wsdlString = ap.getValue();
        try {
            wsdl = new URL(wsdlString);
        } catch (MalformedURLException ex) {
            Logger.getLogger(JUDDIProxy.class.getName()).log(Level.SEVERE, null, ex);
            wsdl = null;
        }
        System.out.println("WSDL: " + wsdlString);
    }

    public static URL getWsdl() {
        return wsdl;
    }
    
    
    
    
    
    private static ServiceList findService(org.uddi.api_v3.FindService body) {
        org.uddi.v3_service.UDDIInquiryService service = new org.uddi.v3_service.UDDIInquiryService();
        org.uddi.v3_service.UDDIInquiryPortType port = service.getUDDIInquiryImplPort();
        return port.findService(body);
    }

    private static ServiceDetail getServiceDetail(org.uddi.api_v3.GetServiceDetail body) {
        org.uddi.v3_service.UDDIInquiryService service = new org.uddi.v3_service.UDDIInquiryService();
        org.uddi.v3_service.UDDIInquiryPortType port = service.getUDDIInquiryImplPort();
        return port.getServiceDetail(body);
    }

    private static BusinessList findBusiness(org.uddi.api_v3.FindBusiness body) {
        org.uddi.v3_service.UDDIInquiryService service = new org.uddi.v3_service.UDDIInquiryService();
        org.uddi.v3_service.UDDIInquiryPortType port = service.getUDDIInquiryImplPort();
        return port.findBusiness(body);
    }
    
}
