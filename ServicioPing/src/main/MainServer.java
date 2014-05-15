package main;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;

import org.boris.winrun4j.AbstractService;
import org.boris.winrun4j.ServiceException;
import org.boris.winrun4j.EventLog;

import wschecker.WSChecker;

public class MainServer extends AbstractService {
	
	public static void main(String[] args) {
		MainServer main = new MainServer();
		main.start();
	}
	
	@Override
	public int serviceMain(String[] args) throws ServiceException {
		try{
			start();
		}catch(Exception e){
			EventLog.report("WSPingSOR", EventLog.ERROR, "ERROR Exception general <" + e.getMessage() + ">");
		}
		return 0;
	}
	
	static final int PUERTO=5001;
	private void start(){
		WSChecker checker = new WSChecker();
		ServerSocket skServidor;
		try {
			skServidor = new ServerSocket(PUERTO);
			while(!shutdown){
				Socket skCliente = null;
				try{
					System.out.println("Aceptando conexiones en el puerto " + PUERTO);
					EventLog.report("WSPingSOR", EventLog.INFORMATION, "Aceptando conexiones en el puerto " + PUERTO);
					skCliente = skServidor.accept();
					OutputStream aux = skCliente.getOutputStream();
					DataOutputStream flujo= new DataOutputStream(aux);
					
					if(checker.ping()){
						flujo.writeUTF("OK");
					}else{
						flujo.writeUTF("ERROR");
					}
					
					skCliente.close();
				}catch(SocketException ex){
					skCliente.close();
					skServidor.close();
					System.err.println("Reiniciando el server");
	                EventLog.report("WSPingSOR", EventLog.ERROR, "Reiniciando el servidor <" + ex.getMessage() + ">");
					ex.printStackTrace();
					skServidor = new ServerSocket(PUERTO);
				}
				
			}
		} catch (IOException e) {
            EventLog.report("WSPingSOR", EventLog.ERROR, "ERROR IOException <" + e.getMessage() + ">");
			e.printStackTrace();
		}		
	}

}
