/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package gestor_taller;

import BD.InterfazBD;
import activemq.Gestor_activemq;
import audit.AuditLogger;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import general.Desguace;
import general.EstadoGeneral;
import general.EstadoOferta;
import general.EstadoPedido;
import general.Oferta;
import general.Pedido;
import general.PedidoCorto;
import general.Taller;

import java.io.IOException;
import java.lang.reflect.Type;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.jms.JMSException;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.codec.binary.Base64;

import seguridad.TripleDes;

/**
 * 
 * @author fawques
 */
@WebService(serviceName = "TallerWS")
public class TallerWS {

	InterfazBD bd;
	static ArrayList<String> listaIdTaller = new ArrayList<String>();
	static ArrayList<SecretKey> listaSecretKeys = new ArrayList<SecretKey>();
	
	private SecretKey getKey(String idTaller) {
		int index = listaIdTaller.indexOf(idTaller);
		if (index != -1) {
			Taller t = bd.getTallerEnGestor(idTaller);
			if (t != null ) {
				SecretKey key = listaSecretKeys.get(index);
                removeKey(idTaller);
				return key;
			}
		}
		return null;
	}
	
	static private void removeKey(String idTaller) {
		int index = listaIdTaller.indexOf(idTaller);
		if (index != -1) {
			listaSecretKeys.remove(index);
			listaIdTaller.remove(index);
			AuditLogger.info("Seguridad", "Eliminada clave de reto del taller <" + idTaller + ">");
		} else {
			AuditLogger.error("idTaller <" + idTaller + "> no esta en la lista de claves de Reto");
		}
	}
	
	private void enviarPedidoActivemq(String nombreCola, PedidoCorto pedido)
			throws JMSException {
		Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ss")
				.create();
		Gestor_activemq activemq = new Gestor_activemq();
		activemq.create_Producer(nombreCola);
		String pedidoFinal = gson.toJson(pedido);
		activemq.producer.produceMessage(pedidoFinal);
		activemq.producer.closeProduce();
		AuditLogger.CRUD_Pedido("Pedido <" + pedido.getID() + "> enviado a ActiveMQ, cola <" + nombreCola + ">");
	}

	public boolean modificar(@WebParam(name = "id") String id,
			@WebParam(name = "password") String password,
			@WebParam(name = "name") String name,
			@WebParam(name = "email") String email,
			@WebParam(name = "address") String address,
			@WebParam(name = "city") String city,
			@WebParam(name = "postalCode") String postalCode,
			@WebParam(name = "telephone") String telephone) {
		try {
			AuditLogger.setUser(id);
			bd = new InterfazBD("sor_gestor");
			SecretKey key = getKey(id);
			if (key != null || !seguridad.Config.isCifradoSimetrico()) {
				Taller nuevotaller= bd.getTallerEnGestor(id);
				if(TripleDes.decrypt(key, password).equals(nuevotaller.getPassword())){
					AuditLogger.ES(id,"Login correcto");
				
				// desencriptar elementos
				boolean res = bd.modificarTaller(id,
						TripleDes.decrypt(key, name),
						TripleDes.decrypt(key, email),
						TripleDes.decrypt(key, city),
						TripleDes.decrypt(key, city),
						Integer.parseInt(TripleDes.decrypt(key, postalCode)),
						Integer.parseInt(TripleDes.decrypt(key, telephone)),
						EstadoGeneral.ACTIVE);
				bd.close();
				if(res){
					AuditLogger.CRUD_Taller(id,"Taller modificado");
				}else{
					AuditLogger.error(id,"No se ha podido modificar el Taller");
				}
				removeKey(id);
				return res;
				}
				else{
					AuditLogger.ES(id,"ERROR: Login incorrecto");
				}
			} else {
				AuditLogger.error(id,"secretKey = NULL!");
			}
		} catch (java.sql.SQLException ex) {
			Logger.getLogger(TallerWS.class.getName()).log(Level.SEVERE, null,
					ex);
		} catch (ClassNotFoundException ex) {
			Logger.getLogger(TallerWS.class.getName()).log(Level.SEVERE, null,
					ex);
		}
		bd.close();
		AuditLogger.error(id,"No se ha podido modificar el Taller");
		return false;
	}

	public String generarClaveReto(@WebParam(name = "idTaller") String idTaller,@WebParam(name = "password") String password) {
		AuditLogger.setUser(idTaller);
		// Generamos la clave de reto y se la mandamos al cliente
		try {
			bd=new InterfazBD("sor_gestor");
			Taller t = bd.getTallerEnGestor(idTaller);
			if (t != null && t.getPassword().equals(password)) {
				try {
					SecretKey clave = TripleDes.generateKey();

					if (listaIdTaller.indexOf(idTaller) != -1) {
						// borramos el anterior
						listaSecretKeys.remove(listaIdTaller.indexOf(idTaller));
						listaIdTaller.remove(listaIdTaller.indexOf(idTaller));
					}
					// anyadir nuevo
					listaIdTaller.add(idTaller);
					listaSecretKeys.add(clave);
					Base64 b64 = new Base64();
					bd.close();
					AuditLogger.info("Seguridad", "Generada nueva clave de reto para el taller <" + idTaller + ">");
					return b64.encodeToString(clave.getEncoded());
				} catch (NoSuchAlgorithmException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			} else {
				AuditLogger.error("id taller <" + idTaller + "> incorrecto. Clave de reto no generada");
			}
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		bd.close();
		return null;
	}

	/**
	 * 
	 * @param email
	 * @return
	 */
	// REMODELACION PARA QUE HAYA UNA ESPECIE DE LOGIN
	@WebMethod(operationName = "checkActivacion")
    public String checkActivacion(@WebParam(name="email") String email,@WebParam(name = "mail") String contrasenya)    {
		try{	
			bd = new InterfazBD("sor_gestor");
			Taller taller = bd.getTaller(email);
	            
				String res;
				if (taller != null && taller.getPassword().equals(contrasenya)) {
					 taller = bd.getTallerActivar(contrasenya);
					 if(taller!=null){
						 res = taller.getID();
					 }
					 else {
					res = "";
					 }
						bd.close();
						return res;
				}
			
		} catch (SQLException ex) {
			Logger.getLogger(TallerWS.class.getName()).log(Level.SEVERE, null,
					ex);
		} catch (ClassNotFoundException ex) {
			Logger.getLogger(TallerWS.class.getName()).log(Level.SEVERE, null,
					ex);
		}
		bd.close();
		return ""; // devolvemos el estado pendiente, por defecto
	}

	/**
	 * Web service operation
	 */
	@WebMethod(operationName = "nuevoPedido")
	public String nuevoPedido(@WebParam(name = "pedido") String pedido,
			@WebParam(name = "idTaller") String idTaller,@WebParam(name = "password") String password) throws JMSException {
		AuditLogger.setUser(idTaller);
		try {
			bd = new InterfazBD("sor_gestor");
			Gson gson = new GsonBuilder()
					.setDateFormat("yyyy-MM-dd'T'HH:mm:ss").create();
			Type collectionType = new TypeToken<Pedido>() {
			}.getType();

			SecretKey key = getKey(idTaller);
			
			if (key != null || !seguridad.Config.isCifradoSimetrico()) {
				Taller nuevotaller= bd.getTallerEnGestor(idTaller);
				if(TripleDes.decrypt(key, password).equals(nuevotaller.getPassword())){
					Pedido p = gson.fromJson(TripleDes.decrypt(key, pedido),
							collectionType);
	
					Date ahora = new Date();
					String stringID = "Pedido_" + bd.getNumPedidos();
					p.setID(stringID);
					bd.anadirPedido(stringID, p.getID_aux(), p.getFecha_alta(), p
							.getEstado().ordinal(), p.getTaller(), p
							.getTallerNombre(), p.getFecha_baja(), p
							.getFecha_limite(), p.getModoAutomatico());
					bd.anyadirPiezasAPedido(stringID, p.getListaPiezas(),
							p.getListaCantidadesPiezas());
					for (Desguace desguace : bd.getDesguaces()) {
						enviarPedidoActivemq(desguace.getID(),
								new PedidoCorto(p.getID(), p.getEstado()));
					}
					bd.close();
					return stringID;
				}
				else{
					System.err.println("Login incorrecto");
				}
			} else {
				System.err.println("secretKey = NULL!");
			}

		} catch (SQLException ex) {
			Logger.getLogger(TallerWS.class.getName()).log(Level.SEVERE, null,
					ex);
		} catch (ClassNotFoundException ex) {
			Logger.getLogger(TallerWS.class.getName()).log(Level.SEVERE, null,
					ex);
		}
		bd.close();
		return "";
	}

	/**
	 * Web service operation
	 */
	@WebMethod(operationName = "getOfertas")
	public String getOfertas(
			@WebParam(name = "listaPedidos") String listaPedidos,
			@WebParam(name = "idTaller") String idTaller,@WebParam(name = "password") String password) {
		AuditLogger.setUser(idTaller);
		Type collectionType = new TypeToken<ArrayList<Pedido>>() {
		}.getType();
		Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ss")
				.create();
		ArrayList<Oferta> listaOferta = new ArrayList<>();
		ArrayList<Pedido> arrayPedido = new ArrayList<Pedido>();
		try {
			bd = new InterfazBD("sor_gestor");
			SecretKey key = getKey(idTaller);
			
			if (key != null || !seguridad.Config.isCifradoSimetrico()) {
				Taller nuevotaller= bd.getTallerEnGestor(idTaller);
				if(TripleDes.decrypt(key, password).equals(nuevotaller.getPassword())){
				arrayPedido = gson.fromJson(TripleDes.decrypt(key, listaPedidos),
					collectionType);
				
				for (Iterator<Pedido> it = arrayPedido.iterator(); it.hasNext();) {
					Pedido p = it.next();
					listaOferta.addAll(bd.getOfertasPedido(p.getID()));
				}

				String retu = gson.toJson(listaOferta);
				bd.close();
				return TripleDes.encrypt(key, retu);
				}
				else{
					System.err.println("Login incorrecto");
				}
			} else {
				System.err.println("secretKey = NULL!");
			}
		
		} catch (SQLException ex) {
			Logger.getLogger(TallerWS.class.getName()).log(Level.SEVERE,
					null, ex);
		} catch (ClassNotFoundException ex) {
			Logger.getLogger(TallerWS.class.getName()).log(Level.SEVERE,
					null, ex);
		} catch (InvalidKeyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchPaddingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		bd.close();
		return null;
	}

	/**
	 * Web service operation
	 */
	@WebMethod(operationName = "aceptarOferta")
	public Boolean aceptarOferta(@WebParam(name = "ID") String ID,
			@WebParam(name = "idTaller") String idTaller,@WebParam(name = "password") String password) {
		AuditLogger.setUser(idTaller);
		try {
			bd = new InterfazBD("sor_gestor");
			SecretKey key = getKey(idTaller);
			if (key != null || !seguridad.Config.isCifradoSimetrico()) {
				Taller nuevotaller= bd.getTallerEnGestor(idTaller);
				if(TripleDes.decrypt(key, password).equals(nuevotaller.getPassword())){
				bd.cambiarEstadoOferta(EstadoOferta.ACCEPTED,
						TripleDes.decrypt(key, ID));
				bd.close();
				return true;
				}
				else{
					System.err.println("Login incorrecto");
				}
			} else {
				System.err.println("secretKey = NULL!");
			}
			bd.close();
		} catch (SQLException ex) {
			Logger.getLogger(TallerWS.class.getName()).log(Level.SEVERE, null,
					ex);
		} catch (ClassNotFoundException ex) {
			Logger.getLogger(TallerWS.class.getName()).log(Level.SEVERE, null,
					ex);
		}
		bd.close();
		return false;
	}

	/**
	 * Web service operation
	 */
	@WebMethod(operationName = "rechazarOferta")
	public Boolean rechazarOferta(@WebParam(name = "ID") String ID,
			@WebParam(name = "idTaller") String idTaller,@WebParam(name = "password") String password) {
		AuditLogger.setUser(idTaller);
		try {
			bd = new InterfazBD("sor_gestor");

			SecretKey key = getKey(idTaller);
			if (key != null || !seguridad.Config.isCifradoSimetrico()) {
				Taller nuevotaller= bd.getTallerEnGestor(idTaller);
				if(TripleDes.decrypt(key, password).equals(nuevotaller.getPassword())){
				bd.cambiarEstadoOferta(EstadoOferta.REJECTED,
						TripleDes.decrypt(key, ID));
				bd.close();
				return true;
				}
				else{
					System.err.println("Login incorrecto");
				}
			} else {
				System.err.println("secretKey = NULL!");
			}
			
		} catch (SQLException ex) {
			Logger.getLogger(TallerWS.class.getName()).log(Level.SEVERE, null,
					ex);
		} catch (ClassNotFoundException ex) {
			Logger.getLogger(TallerWS.class.getName()).log(Level.SEVERE, null,
					ex);
		}
		bd.close();
		return false;
	}

	/**
	 * Web service operation
	 */
	@WebMethod(operationName = "hello")
	public String hello() {
		return "hello";
	}

	@WebMethod(operationName = "baja")
	public Boolean bajaTaller(@WebParam(name = "tallerID") String tallerID,@WebParam(name = "password") String password) {
		AuditLogger.setUser(tallerID);
		try {
			bd = new InterfazBD("sor_gestor");
			Taller t = bd.getTallerEnGestor(tallerID);
			if (t != null && t.getPassword().equals(password)) {
				boolean oool = bd.bajaTaller(tallerID);
				bd.close();
				return oool;
			}
			
		} catch (SQLException ex) {
			Logger.getLogger(TallerWS.class.getName()).log(Level.SEVERE, null,
					ex);
		} catch (ClassNotFoundException ex) {
			Logger.getLogger(TallerWS.class.getName()).log(Level.SEVERE, null,
					ex);
		}
		bd.close();
		return false;
	}

	/**
	 * Web service operation
	 */
	@WebMethod(operationName = "alta")
	public boolean alta(@WebParam(name = "name") String name,
			@WebParam(name = "email") String email,
			@WebParam(name = "address") String address,
			@WebParam(name = "city") String city,
			@WebParam(name = "postalCode") String postalCode,
			@WebParam(name = "telephone") String telephone) {
		try {
			bd = new InterfazBD("sor_gestor");
			Date ahora = new Date();
			Random r = new Random(ahora.getTime());
			String stringID = DigestUtils.md5Hex(ahora.toString() + r);
			boolean res = bd.altaTaller(stringID, name, email, address, city,
					Integer.parseInt(postalCode), Integer.parseInt(telephone),
					EstadoGeneral.PENDIENTE.ordinal());
			bd.close();
			return res;
		} catch (java.sql.SQLException ex) {
			Logger.getLogger(TallerWS.class.getName()).log(Level.SEVERE, null,
					ex);
		} catch (ClassNotFoundException ex) {
			Logger.getLogger(TallerWS.class.getName()).log(Level.SEVERE, null,
					ex);
		}
		bd.close();
		return false;
	}

	@WebMethod(operationName = "cancelarPedido")
	public Boolean cancelarPedido(@WebParam(name = "idPedido") String idPedido,
			@WebParam(name = "idTaller") String idTaller,@WebParam(name = "password") String password) {
		AuditLogger.setUser(idTaller);
		try {
			bd = new InterfazBD("sor_gestor");

			SecretKey key = getKey(idTaller);
			if (key != null || !seguridad.Config.isCifradoSimetrico()) {
				Taller nuevotaller= bd.getTallerEnGestor(idTaller);
				if(TripleDes.decrypt(key, password).equals(nuevotaller.getPassword())){
				boolean oool = bd.cancelarPedido(TripleDes.decrypt(key,
						idPedido));
				cambiarEstadoPedido(idTaller,password,EstadoPedido.CANCELLED.ordinal(), idPedido);
				bd.close();
				return oool;
				}
				else{
					System.err.println("Login incorrecto");
				}
			} else {
				System.err.println("secretKey = NULL!");
			}
		
		} catch (SQLException ex) {
			Logger.getLogger(TallerWS.class.getName()).log(Level.SEVERE, null,
					ex);
		} catch (ClassNotFoundException ex) {
			Logger.getLogger(TallerWS.class.getName()).log(Level.SEVERE, null,
					ex);
		}
		bd.close();
		return false;
	}

	/**
	 * Web service operation
	 */
	@WebMethod(operationName = "cambiarEstadoPedido")
	public Boolean cambiarEstadoPedido(@WebParam(name = "idTaller") String idTaller,@WebParam(name = "password") String password,@WebParam(name = "estado") int estado,
			@WebParam(name = "id") String id
			) {
		AuditLogger.setUser(idTaller);
		try {
			bd = new InterfazBD("sor_gestor");
			SecretKey key = getKey(idTaller);
			if (key != null || !seguridad.Config.isCifradoSimetrico()) {
				Taller nuevotaller= bd.getTallerEnGestor(idTaller);
				if(TripleDes.decrypt(key, password).equals(nuevotaller.getPassword())){
				Gson gson = new GsonBuilder().setDateFormat(
						"yyyy-MM-dd'T'HH:mm:ss").create();
				
				for (Desguace desguace : bd.getDesguaces()) {
					enviarPedidoActivemq(desguace.getID(), new PedidoCorto(
							TripleDes.decrypt(key, id),
							EstadoPedido.values()[estado]));
				}
				Boolean ool = bd.cambiarEstadoPedido(
						EstadoPedido.values()[estado],
						TripleDes.decrypt(key, id));
				bd.close();
				return ool;
				}
				else{
					System.err.println("Login incorrecto");
				}
			} else {
				System.err.println("secretKey = NULL!");
			}
			
		} catch (SQLException ex) {
			Logger.getLogger(TallerWS.class.getName()).log(Level.SEVERE, null,
					ex);
		} catch (ClassNotFoundException ex) {
			Logger.getLogger(TallerWS.class.getName()).log(Level.SEVERE, null,
					ex);
		} catch (JMSException ex) {
			Logger.getLogger(TallerWS.class.getName()).log(Level.SEVERE, null,
					ex);
		}
		bd.close();
		return false;
	}

	/**
	 * Web service operation
	 */
	@WebMethod(operationName = "getPedidos")
	public String getPedidos(@WebParam(name = "idTaller") String idTaller,@WebParam(name = "password") String password) {
		AuditLogger.setUser(idTaller);
		Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ss")
				.create();
		// Dec 7, 2013 5:46:35 PM

		ArrayList<Pedido> listaPedidos = new ArrayList<Pedido>();
		try {
			bd = new InterfazBD("sor_gestor");
			SecretKey key = getKey(idTaller);
			Taller t = bd.getTallerEnGestor(idTaller);
			if (t != null && t.getPassword().equals(TripleDes.decrypt(key, password))) {
				listaPedidos = bd.getPedidosTaller(idTaller);
				for (Pedido p : listaPedidos) {
					if (p.getEstado() == EstadoPedido.FINISHED_OK) {
						ArrayList<Oferta> listaOferta = bd.getOfertasPedido(p
								.getID());
						for (Oferta of : listaOferta) {
							if (of.getEstado() != EstadoOferta.FINISHED_OK) {
								bd.cambiarEstadoOferta(EstadoOferta.REJECTED,
										of.getID());
							}
						}
					}
				}
				String listaJSON = gson.toJson(listaPedidos);
				System.out.println("listaJSON = " + listaJSON);
				bd.close();
				return TripleDes.encrypt(key, listaJSON);
			}
			
		} catch (SQLException ex) {
			Logger.getLogger(TallerWS.class.getName()).log(Level.SEVERE, null,
					ex);
		} catch (ClassNotFoundException ex) {
			Logger.getLogger(TallerWS.class.getName()).log(Level.SEVERE, null,
					ex);
		} catch (InvalidKeyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchPaddingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		bd.close();
		return null;
	}

}
