package wschecker;


import java.net.MalformedURLException;
import java.net.URL;

import gestor_taller.*;
import gestor_desguace_java.*;

public class WSChecker {
	public boolean ping(){
		try{
			TallerWS_Service serviceTaller = new TallerWS_Service(new URL("http://localhost:8080/Gestor/services/TallerWSPort?wsdl"));
			TallerWS portTaller = serviceTaller.getTallerWSPort();
			String taller = portTaller.hello();
			
			DesguaceJavaWS_Service serviceDesguace = new DesguaceJavaWS_Service(new URL("http://localhost:8080/Gestor/services/DesguaceJavaWSPort?wsdl"));
			DesguaceJavaWS port = serviceDesguace.getDesguaceJavaWSPort();
			String desguace = port.hello();
			
			return taller.equals("hello") && desguace.equals("hello"); 
		}catch(javax.xml.ws.WebServiceException e){
			return false;
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

}
