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
import java.rmi.RemoteException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.uddi.api_v3.*;
import org.uddi.v3_service.DispositionReportFaultMessage;
import org.uddi.v3_service.UDDIInquiryPortType;
import org.uddi.v3_service.UDDIInquiryService;

/**
 *
 * @author fawques
 */
public class JUDDIProxy {
    private static URL wsdl;
    private static URL wsdl_HTTPS;
    private static String urlActiveMQ;
    private static URL urlUddi;
    public static void loadWsdl(String servicio) throws RemoteException {
        try {
			wsdl = new URL(load(servicio));
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        try {
			wsdl_HTTPS = new URL(load(servicio+"_HTTPS"));
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        urlActiveMQ = load("ActiveMQ");
    }
    public static String load(String servicio) throws RemoteException {
    	try {
			urlUddi= new URL("http://localhost:8081/juddiv3/services/inquiry?wsdl");
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        FindService fs = new FindService();
        FindQualifiers fq = new FindQualifiers();
        fq.getFindQualifier().add("exactMatch");
        fs.setFindQualifiers(fq);
        Name name = new Name();
        name.setValue(servicio);
        fs.getName().add(name);
        ServiceList bi = findService(fs);
        ServiceInfos sis = bi.getServiceInfos();
        if(sis!=null){
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
        System.out.println("WSDL: " + wsdlString);
        return wsdlString;
        }
		return "";
    }

    public static URL getWsdl() {
    	//if (seguridad.Config.isCifradoAsimetrico()) {
			//return wsdl_HTTPS;
		//}else {
			return wsdl;	
		//}
    }
    
    public static String getActiveMQ() {
        return urlActiveMQ;
    }
    
    public static boolean loadHasChanged(String servicio) throws RemoteException{
    	URL wsdl_backup = wsdl;
    	loadWsdl(servicio);
    	// si son iguales, el endpoint no ha cambiado
    	return !wsdl_backup.equals(wsdl);
    }
    
    
    private static ServiceList findService(org.uddi.api_v3.FindService body) throws RemoteException {
        UDDIInquiryService service = new UDDIInquiryService(urlUddi);
        org.uddi.v3_service.UDDIInquiryPortType port = service.getUDDIInquiryImplPort();
        return port.findService(body);
    }

    private static ServiceDetail getServiceDetail(org.uddi.api_v3.GetServiceDetail body) throws RemoteException {
        UDDIInquiryService service = new UDDIInquiryService(urlUddi);
        org.uddi.v3_service.UDDIInquiryPortType port = service.getUDDIInquiryImplPort();
        return port.getServiceDetail(body);
    }

    private static BusinessList findBusiness(org.uddi.api_v3.FindBusiness body) throws RemoteException {
        UDDIInquiryService service = new UDDIInquiryService(urlUddi);
        org.uddi.v3_service.UDDIInquiryPortType port = service.getUDDIInquiryImplPort();
        return port.findBusiness(body);
    }
    
}
