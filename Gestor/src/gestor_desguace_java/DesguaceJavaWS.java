/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package gestor_desguace_java;

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
import gestor_taller.TallerWS;

import java.io.IOException;
import java.lang.reflect.Type;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.jms.JMSException;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.digest.DigestUtils;

import seguridad.TripleDes;

/**
 *
 * @author Cute
 */
@WebService(serviceName = "DesguaceJavaWS")
public class DesguaceJavaWS {
    InterfazBD bd;
    

	static ArrayList<String> listaIdDesguace = new ArrayList<String>();
	static ArrayList<SecretKey> listaSecretKeys = new ArrayList<SecretKey>();;
    
	private SecretKey getKey(String idDesguace) {
		int index = listaIdDesguace.indexOf(idDesguace);
		if(seguridad.Config.isCifradoSimetrico()) {
			if (index != -1) {
					Desguace desg = bd.getDesguaceEnGestor(idDesguace);
					if (desg != null) {
						SecretKey key = listaSecretKeys.get(index);
						return key;
					}
			}
		}
		return null;
	}
	
	static public void removeKey(String idDesguace) {
		int index = listaIdDesguace.indexOf(idDesguace);
		if (index != -1) {
			listaSecretKeys.remove(index);
			listaIdDesguace.remove(index);
			AuditLogger.info("Seguridad", "Eliminada clave de reto del desguace <" + idDesguace + ">");
		} else {
			AuditLogger.error("idDesguace <" + idDesguace + "> no esta en la lista de claves de Reto");
		}
	}
	
	@WebMethod(operationName = "generarClaveReto")
    public String generarClaveReto(@WebParam(name = "idDesguace") String idDesguace,@WebParam(name = "password") String password) {
		AuditLogger.setUser(idDesguace);
		// Generamos la clave de reto y se la mandamos al cliente
		try {
		if(seguridad.Config.isCifradoSimetrico()){
			bd=new InterfazBD("sor_gestor");
			Desguace desg = bd.getDesguaceEnGestor(idDesguace);
			if (desg != null && desg.getPassword().equals(password)) {
				AuditLogger.ES("Login correcto");
				try {
					SecretKey clave = TripleDes.generateKey();

					if (listaIdDesguace.indexOf(idDesguace) != -1) {
						// borramos el anterior
						removeKey(idDesguace);
					}
					// anyadir nuevo
					listaIdDesguace.add(idDesguace);
					listaSecretKeys.add(clave);
					Base64 b64 = new Base64();
					bd.close();
					AuditLogger.info("Seguridad", "Generada nueva clave de reto para el desguace <" + idDesguace + ">");
					return b64.encodeToString(clave.getEncoded());
				} catch (NoSuchAlgorithmException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} else {
				AuditLogger.error("id desguace <" + idDesguace + "> incorrecto.");
			}
		}else{
			AuditLogger.error("Cifrado simetrico deshabilitado en gestor");
		}
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		bd.close();
		AuditLogger.error("Clave de reto no generada");
		return null;
	}
    
      @WebMethod(operationName = "alta")
    public boolean alta(@WebParam(name = "name") String name, @WebParam(name = "email") String email, @WebParam(name = "address") String address, @WebParam(name = "city") String city, @WebParam(name = "postalCode") String postalCode, @WebParam(name = "telephone") String telephone) {
    	  
    
        try {       
            bd = new InterfazBD("sor_gestor");

            Date ahora = new Date();
            Random r = new Random(ahora.getTime());
            String stringID  = DigestUtils.md5Hex(ahora.toString() + r);
            boolean res = bd.altaDesguace(stringID, name, email, address, city, Integer.parseInt(postalCode), Integer.parseInt(telephone), 2);
            bd.close();
            AuditLogger.CRUD_Desguace("Desguace dado de alta con ID <" + stringID + ">");
            return res;
        } catch (SQLException ex) {
            Logger.getLogger(DesguaceJavaWS.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DesguaceJavaWS.class.getName()).log(Level.SEVERE, null, ex);
        }

    	bd.close();
    	AuditLogger.CRUD_Desguace("No se ha podido dar de alta el desguace");
       return false;

    }
    
        @WebMethod(operationName = "checkActivacion")
    public String checkActivacion(@WebParam(name="email") String email, @WebParam(name = "contrasenya") String contrasenya){

        try {

            bd = new InterfazBD("sor_gestor");
            Desguace desg = bd.getDesguace(email);
			if (desg != null && desg.getPassword().equals(contrasenya)) {
				AuditLogger.ES("Login correcto");
	            Desguace desguace = bd.getDesguaceActivar(contrasenya);
	            String res;
	            if (desguace!=null) {
	                res = desguace.getID();
	                AuditLogger.CRUD_Desguace("Desguace <" + res + "> esta activado. Devolviendo id");
	            }else{
	                res = "";
	                AuditLogger.CRUD_Desguace("Desguace con email <" + email + "> no esta activado");
	            }
	            bd.close();
	            return res;
			}else{
				AuditLogger.ES("ERROR: Login incorrecto");
			}

		
        } catch (SQLException ex) {
            Logger.getLogger(DesguaceJavaWS.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DesguaceJavaWS.class.getName()).log(Level.SEVERE, null, ex);
        }
    	bd.close();
    	AuditLogger.error("No se ha podido comprobar la activacion del desguace");
        return "";

    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "nuevaOferta")
    public String nuevaOferta(@WebParam(name = "oferta") String oferta, @WebParam(name = "idDesguace") String idDesguace, @WebParam(name = "password") String password) {
    	AuditLogger.setUser(idDesguace);
        try {          
             Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ss").create();
             bd = new InterfazBD("sor_gestor");
             SecretKey key = getKey(idDesguace);
 			if (key != null|| !seguridad.Config.isCifradoSimetrico()) {
 				Desguace nuevoDesguace= bd.getDesguaceEnGestor(idDesguace);
				if(TripleDes.decrypt(key, password).equals(nuevoDesguace.getPassword())){
					AuditLogger.ES("Login correcto");
		             Oferta p = gson.fromJson(TripleDes.decrypt(key, oferta),Oferta.class);
		            Date ahora = new Date();
		            String stringID  = "Oferta_" + bd.getNumOfertas();
		            p.setID(stringID);
		     
		             bd.anadirOferta(stringID,p.getID_aux(), p.getFecha_alta(),p.getPrecio(), EstadoOferta.ACTIVE.ordinal(),  p.getPedido(), p.getDesguace(),p.getDesguaceNombre(), p.getFecha_baja(),p.getFecha_limite());
		             bd.close();
		             AuditLogger.CRUD_Oferta("Creada nueva oferta <" + stringID + ">");
		             return stringID;
				}
				else{
					AuditLogger.ES("ERROR: Login incorrecto");
				}
 			}
 			else{
 				bd.close();
				AuditLogger.error("secretKey = NULL!");
				return "errorClaveSimetrica";
 			}
        } catch (SQLException ex) {
            Logger.getLogger(DesguaceJavaWS.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DesguaceJavaWS.class.getName()).log(Level.SEVERE, null, ex);
        }
           
    	bd.close();
    	AuditLogger.error("No se ha podido crear una nueva oferta");
        return "";

    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "getOfertas")
    public String getOfertas(@WebParam(name = "string") String id, @WebParam(name="password") String password) {
    	AuditLogger.setUser(id);
        try {   

        	 bd = new InterfazBD("sor_gestor");
        	   SecretKey key = getKey(id);
   			
   			if (key != null|| !seguridad.Config.isCifradoSimetrico()) {   			
   				Desguace nuevoDesguace= bd.getDesguaceEnGestor(id);
   				if(TripleDes.decrypt(key, password).equals(nuevoDesguace.getPassword())){
   					AuditLogger.ES("Login correcto");
	             ArrayList<Oferta> listaOfertas = new ArrayList<Oferta>();
	            listaOfertas=bd.getOfertasDesguace(id);
	            Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ss").create();
	            String listaJSON = gson.toJson(listaOfertas);
	            System.out.println("listaJSON = " + listaJSON);
	            bd.close();
	            AuditLogger.informe("Obtenida lista de ofertas");
	            return TripleDes.encrypt(key, listaJSON);
			}else{
				AuditLogger.ES("ERROR: Login incorrecto");
			}
   			
		
   			}else{
   				AuditLogger.error("secretKey = NULL!");
   			}
        } catch (SQLException ex) {
            Logger.getLogger(DesguaceJavaWS.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DesguaceJavaWS.class.getName()).log(Level.SEVERE, null, ex);

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
		AuditLogger.error("No se ha podido obtener la lista de ofertas");
           return "";
        }       

    /**
     * Web service operation
     */
    @WebMethod(operationName = "getPedidoporID")
    public String getPedidoporID(@WebParam(name = "string") String id,@WebParam(name = "idDesguace") String idDesguace, @WebParam(name="password") String password) {
    	AuditLogger.setUser(idDesguace);
    	 Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ss").create();
        try {
            bd = new InterfazBD("sor_gestor");

            SecretKey key = getKey(idDesguace);
			
			if (key != null|| !seguridad.Config.isCifradoSimetrico()) {
				Desguace nuevoDesguace= bd.getDesguaceEnGestor(idDesguace);
				if(TripleDes.decrypt(key, password).equals(nuevoDesguace.getPassword())){
					AuditLogger.ES("Login correcto");

	            String listapedidos="";
	            String idDecrypt = TripleDes.decrypt(key, id);
	            Pedido p=bd.getPedidoID(idDecrypt);
	            listapedidos=gson.toJson(p);
	            bd.close();
	            String resultado="";
	         try{
	             resultado=TripleDes.encrypt(key, listapedidos);
	         }
	         catch(Exception e){
	        	 e.printStackTrace();
	        	 AuditLogger.error(e.getMessage());
	         }
	            AuditLogger.informe("Obtenido pedido completo <" + idDecrypt + ">");
	            return resultado;
	            
				}
				else{
					AuditLogger.ES("ERROR: Login incorrecto");
				}

			}else{
				AuditLogger.error("secretKey = NULL!");
			}
			
        } catch (SQLException ex) {
            Logger.getLogger(DesguaceJavaWS.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DesguaceJavaWS.class.getName()).log(Level.SEVERE, null, ex);

        }/* catch (InvalidKeyException e) {
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
		}*/
           
        bd.close();
        AuditLogger.error("No se ha podido obtener el pedido completo <" + id + ">");
        return null;
    }
    /**
     * Web service operation
     */
    @WebMethod(operationName = "aceptarOfertaFin")
    public Boolean aceptarOfertaFin(@WebParam(name = "id") String id, @WebParam(name = "idDesguace") String idDesguace, @WebParam(name = "password") String password) {
    	AuditLogger.setUser(idDesguace);
        Boolean aceptada=false;
        try {
        	  bd = new InterfazBD("sor_gestor");
        	SecretKey key = getKey(idDesguace);
 			if (key != null|| !seguridad.Config.isCifradoSimetrico()) {
 				Desguace nuevoDesguace= bd.getDesguaceEnGestor(idDesguace);
				if(TripleDes.decrypt(key, password).equals(nuevoDesguace.getPassword())){
					AuditLogger.ES("Login correcto");
	            Oferta of= bd.getOfertaporID(TripleDes.decrypt(key, id));
	            aceptada=bd.cambiarEstadoOferta(EstadoOferta.FINISHED_OK, of.getID());
	            if(aceptada){
		            Pedido ped= bd.getPedido(of.getPedido());
		            ArrayList<Oferta> listaoferta=bd.getOfertasPedido(ped.getID());
		            for(Oferta oferta:listaoferta){
		            	if(oferta.getEstado()==EstadoOferta.ACTIVE ||oferta.getEstado()==EstadoOferta.NEW ||oferta.getEstado()==EstadoOferta.ACCEPTED){
		            		bd.cambiarEstadoOferta(EstadoOferta.REJECTED, oferta.getID());
		            		AuditLogger.CRUD_Oferta("Oferta <" + oferta.getID() + "> rechazada");
		            	}
		            }
		            bd.cambiarEstadoPedido(EstadoPedido.FINISHED_OK,ped.getID());
		            AuditLogger.CRUD_Oferta("Oferta <" + of.getID() + "> finalizada correctamente");
		            AuditLogger.CRUD_Pedido("Pedido <" + of.getPedido() + "> finalizado correctamente");
				}
	            else{
	            	AuditLogger.error("No se ha podido finalizar la oferta <" + of.getID() + ">");
	            }
	            bd.close();
	            
	            return aceptada;
				}else{
					AuditLogger.ES("ERROR: Login incorrecto");
				}
 			}
 			else{
 				AuditLogger.error("secretKey = NULL!");
 			}
 			
        } catch (SQLException ex) {
            Logger.getLogger(DesguaceJavaWS.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DesguaceJavaWS.class.getName()).log(Level.SEVERE, null, ex);
        }
        bd.close();
        AuditLogger.error("No se ha podido finalizar la oferta <" + id + ">");
        return aceptada;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "cancelarOferta")
    public Boolean cancelarOferta(@WebParam(name = "id") String id, @WebParam(name = "idDesguace") String idDesguace, @WebParam(name = "password") String password) {
    	AuditLogger.setUser(idDesguace);
        Boolean aceptada=false;
        try {
        	 bd = new InterfazBD("sor_gestor");
        	SecretKey key = getKey(idDesguace);
 			if (key != null || !seguridad.Config.isCifradoSimetrico()) {
 				Desguace nuevoDesguace= bd.getDesguaceEnGestor(idDesguace);
				if(TripleDes.decrypt(key, password).equals(nuevoDesguace.getPassword())){
					AuditLogger.ES("Login correcto");
	           String idDecrypt = TripleDes.decrypt(key, id);
	            aceptada=bd.cambiarEstadoOferta(EstadoOferta.CANCELLED, idDecrypt);
	            bd.close();
	            AuditLogger.CRUD_Oferta("Oferta <" + idDecrypt + "> cancelada");
	            return aceptada;
				}else{
					AuditLogger.ES("ERROR: Login incorrecto");
				}
 			}
 			else{
 				AuditLogger.error("secretKey = NULL!");
 			}
            
        } catch (SQLException ex) {
            Logger.getLogger(DesguaceJavaWS.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DesguaceJavaWS.class.getName()).log(Level.SEVERE, null, ex);
        }
        bd.close();
        AuditLogger.error("No se ha podido cancelar la oferta <" + id + ">");
        return aceptada;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "baja")
    public Boolean baja(@WebParam(name = "id") String id, @WebParam(name="password") String password) {
    	AuditLogger.setUser(id);
        try {        
       	 bd = new InterfazBD("sor_gestor");
     	SecretKey key = getKey(id);
			if (key != null|| !seguridad.Config.isCifradoSimetrico()) {
				Desguace nuevoDesguace= bd.getDesguaceEnGestor(id);
				if(TripleDes.decrypt(key, password).equals(nuevoDesguace.getPassword())){
					AuditLogger.ES("Login correcto");
	            boolean oool = bd.bajaDesguace(id);
	            bd.close();
	            AuditLogger.CRUD_Desguace("Desguace <" + id + "> dado de baja");
	            return oool;
			}else{
				AuditLogger.ES("ERROR: Login incorrecto");
			}
			
			}else{
				AuditLogger.error("secretKey = NULL!");
			}
        } catch (SQLException ex) {
            Logger.getLogger(DesguaceJavaWS.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DesguaceJavaWS.class.getName()).log(Level.SEVERE, null, ex);
        }
        bd.close();
        AuditLogger.error("No se ha podido dar de baja el desguace");
        return false;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "cambiarEstadoPedido")
    public Boolean cambiarEstadoPedido(@WebParam(name = "id") String id, @WebParam(name = "estado") String estado, @WebParam(name = "idDesguace") String idDesguace, @WebParam(name = "password") String password) {
    	AuditLogger.setUser(idDesguace);
         
           
        try {
        	 bd= new InterfazBD("sor_gestor");
        	SecretKey key = getKey(idDesguace);
 			if (key != null|| !seguridad.Config.isCifradoSimetrico()) {
 				Desguace nuevoDesguace= bd.getDesguaceEnGestor(idDesguace);
				if(TripleDes.decrypt(key, password).equals(nuevoDesguace.getPassword())){
					AuditLogger.ES("Login correcto");
					String idDecrypt = TripleDes.decrypt(key, id);
					String estadoDecrypt = TripleDes.decrypt(key, estado);
	           Boolean ool = bd.cambiarEstadoPedido(EstadoPedido.valueOf(estadoDecrypt), idDecrypt);
	           bd.close();
	           AuditLogger.CRUD_Pedido("Pedido <" + idDecrypt + "> cambiado al estado <" + estadoDecrypt + ">");
	           return ool;
				}else{
					
					AuditLogger.ES("ERROR: Login incorrecto");
				}
 			}
 			else{
 				AuditLogger.error("secretKey = NULL!");
 			}
 			
        } catch (SQLException ex) {
            Logger.getLogger(DesguaceJavaWS.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DesguaceJavaWS.class.getName()).log(Level.SEVERE, null, ex);
        }
            
        bd.close();
        AuditLogger.error("No se ha podido cambiar el estado del pedido <" + id + ">");
        return false;
    }
    @WebMethod(operationName = "cambiarEstadoPedidoOtravez")
    public Boolean cambiarEstadoPedidoOtravez(@WebParam(name = "id") String id, @WebParam(name = "estado") String estado, @WebParam(name = "idDesguace") String idDesguace, @WebParam(name = "password") String password) {
    	AuditLogger.setUser(idDesguace);
         
           
        try {
        	 bd= new InterfazBD("sor_gestor");
        	SecretKey key = getKey(idDesguace);
 			if (key != null|| !seguridad.Config.isCifradoSimetrico()) {
 				Desguace nuevoDesguace= bd.getDesguaceEnGestor(idDesguace);
				if(TripleDes.decrypt(key, password).equals(nuevoDesguace.getPassword())){
					AuditLogger.ES("Login correcto");
					String idDecrypt = TripleDes.decrypt(key, id);
					String estadoDecrypt = TripleDes.decrypt(key, estado);
	           
	           Boolean ool = bd.cambiarEstadoPedido(EstadoPedido.valueOf(estadoDecrypt), idDecrypt);
	           bd.close();
	           AuditLogger.CRUD_Pedido("Pedido <" + idDecrypt + "> cambiado al estado <" + estadoDecrypt + ">");
	           return ool;
				}else{
					AuditLogger.ES("ERROR: Login incorrecto");
				}
 			}
 			else{
 				AuditLogger.error("secretKey = NULL!");
 			}
      
        } catch (SQLException ex) {
            Logger.getLogger(DesguaceJavaWS.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DesguaceJavaWS.class.getName()).log(Level.SEVERE, null, ex);
        }
            
        bd.close();
        AuditLogger.error("No se ha podido cambiar el estado del pedido <" + id + ">");
        return false;
    }
    public boolean modificar(@WebParam(name = "id") String id, @WebParam(name = "name") String name, @WebParam(name = "email") String email, @WebParam(name = "address") String address, @WebParam(name = "city") String city, @WebParam(name = "postalCode") String postalCode, @WebParam(name = "telephone") String telephone, @WebParam(name = "password") String password) {
    	AuditLogger.setUser(id);
        try {
        	bd = new InterfazBD("sor_gestor");
			SecretKey key = getKey(id);
			if (key != null|| !seguridad.Config.isCifradoSimetrico()) {
				Desguace nuevoDesguace= bd.getDesguaceEnGestor(id);
				if(TripleDes.decrypt(key, password).equals(nuevoDesguace.getPassword())){
					AuditLogger.ES("Login correcto");
	            
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
				removeKey(id);
				if(res){
					AuditLogger.CRUD_Desguace("Desguace modificado");
				}else{
					AuditLogger.error("No se ha podido modificar el Desguace");
				}
	            return res;
				}
				else{
					AuditLogger.ES("ERROR: Login incorrecto");
				}
			} else {
				AuditLogger.error("secretKey = NULL!");
			}
			
        } catch (java.sql.SQLException ex) {
            Logger.getLogger(TallerWS.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(TallerWS.class.getName()).log(Level.SEVERE, null, ex);
        }
        bd.close();
        AuditLogger.error("No se ha podido modificar el Desguace");
        return false;
    }
}

