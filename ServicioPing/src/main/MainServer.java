package main;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

import org.boris.winrun4j.AbstractService;
import org.boris.winrun4j.ServiceException;

import wschecker.WSChecker;

public class MainServer extends AbstractService {
	
	public static void main(String[] args) {
		start();
	}
	
	public int serviceMain(String[] args) throws ServiceException {
		start();
		return 0;
	}
	
	static final int PUERTO=5001;
	private static void start(){
		WSChecker checker = new WSChecker();
		ServerSocket skServidor;
		try {
			skServidor = new ServerSocket(PUERTO);
			while(true){
				Socket skCliente = skServidor.accept();
				OutputStream aux = skCliente.getOutputStream();
				DataOutputStream flujo= new DataOutputStream(aux);
				
				if(checker.ping()){
					flujo.writeUTF("OK");
				}else{
					flujo.writeUTF("ERROR");
				}
				
				skCliente.close();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}

}
