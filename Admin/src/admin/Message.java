/**
 * 
 */
package admin;

import java.net.InetAddress;

/**
 * @author pablovm1990
 *
 */
public class Message {
	InetAddress ip;
	Mensajes mensaje;
	
	public Message(InetAddress ip, Mensajes mensaje) {
		super();
		this.ip = ip;
		this.mensaje = mensaje;
	}
	
	public Message() {
		super();
	}

	public InetAddress getIp() {
		return ip;
	}

	public void setIp(InetAddress ip) {
		this.ip = ip;
	}

	public Mensajes getMensaje() {
		return mensaje;
	}

	public void setMensaje(Mensajes mensaje) {
		this.mensaje = mensaje;
	}
	
	public boolean equals(String msg){
		return this.mensaje.name().equals(msg);
	}
	
	

}
