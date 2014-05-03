/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package gestor_desguace_java;

import BD.InterfazBD;
import activemq.Gestor_activemq;

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
		if (index != -1) {
			try {
				bd=new InterfazBD("sor_gestor");
				Desguace desg = bd.getDesguaceEnGestor(idDesguace);
				if (desg != null) {
					SecretKey key = listaSecretKeys.get(index);
					return key;
				}
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return null;
	}
	
	static public void removeKey(String idTaller) {
		int index = listaIdDesguace.indexOf(idTaller);
		if (index != -1) {
			listaSecretKeys.remove(index);
			listaIdDesguace.remove(index);
		} else {
			System.err.println("ERROR - idTaller no esta en la lista de claves de Reto");
		}
	}
	
	@WebMethod(operationName = "generarClaveReto")
    public String generarClaveReto(@WebParam(name = "idDesguace") String idDesguace,@WebParam(name = "password") String password) {
		// Generamos la clave de reto y se la mandamos al cliente
		try {
			bd=new InterfazBD("sor_gestor");
			Desguace desg = bd.getDesguaceEnGestor(idDesguace);
			if (desg != null && desg.getPassword().equals(password)) {
				try {
					SecretKey clave = TripleDes.generateKey();

					if (listaIdDesguace.indexOf(idDesguace) != -1) {
						// borramos el anterior
						listaSecretKeys.remove(listaIdDesguace.indexOf(idDesguace));
						listaIdDesguace.remove(listaIdDesguace.indexOf(idDesguace));
					}
					// anyadir nuevo
					listaIdDesguace.add(idDesguace);
					listaSecretKeys.add(clave);
					Base64 b64 = new Base64();
					bd.close();
					return b64.encodeToString(clave.getEncoded());
				} catch (NoSuchAlgorithmException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} else {
				System.err
						.println("id taller incorrecto. Clave de reto no generada");
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
    
      @WebMethod(operationName = "alta")
    public boolean alta(@WebParam(name = "name") String name, @WebParam(name = "email") String email, @WebParam(name = "address") String address, @WebParam(name = "city") String city, @WebParam(name = "postalCode") String postalCode, @WebParam(name = "telephone") String telephone) {
    
        try {       
            bd = new InterfazBD("sor_gestor");

            Date ahora = new Date();
            Random r = new Random(ahora.getTime());
            String stringID  = DigestUtils.md5Hex(ahora.toString() + r);
            boolean res = bd.altaDesguace(stringID, name, email, address, city, Integer.parseInt(postalCode), Integer.parseInt(telephone), 2);
            bd.close();
            return res;
        } catch (SQLException ex) {
            Logger.getLogger(DesguaceJavaWS.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DesguaceJavaWS.class.getName()).log(Level.SEVERE, null, ex);
        }

    	bd.close();
       return false;

    }
    
        @WebMethod(operationName = "checkActivacion")
    public String checkActivacion(@WebParam(name="email") String email, @WebParam(name = "contrasenya") String contrasenya){

        try {

            bd = new InterfazBD("sor_gestor");
            Desguace desg = bd.getDesguace(email);
			if (desg != null && desg.getPassword().equals(contrasenya)) {
	            Desguace desguace = bd.getDesguaceActivar(contrasenya);
	            String res;
	            if (desguace!=null) {
	                res = desguace.getID();
	            }else{
	                res = "";
	            }
	            bd.close();
	            return res;
			}

		
        } catch (SQLException ex) {
            Logger.getLogger(DesguaceJavaWS.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DesguaceJavaWS.class.getName()).log(Level.SEVERE, null, ex);
        }
    	bd.close();
        return "";

    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "nuevaOferta")
    public String nuevaOferta(@WebParam(name = "oferta") String oferta, @WebParam(name = "idDesguace") String idDesguace, @WebParam(name = "password") String password) {
        try {          
             Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ss").create();
             bd = new InterfazBD("sor_gestor");
             SecretKey key = getKey(idDesguace);
 			if (key != null|| !seguridad.Config.isCifradoSimetrico()) {
 				Desguace nuevoDesguace= bd.getDesguaceEnGestor(idDesguace);
				if(TripleDes.decrypt(key, password).equals(nuevoDesguace.getPassword())){
		             Oferta p = gson.fromJson(TripleDes.decrypt(key, oferta),Oferta.class);
		            Date ahora = new Date();
		            String stringID  = "Oferta_" + bd.getNumOfertas();
		            p.setID(stringID);
		     
		             bd.anadirOferta(stringID,p.getID_aux(), p.getFecha_alta(),p.getPrecio(), EstadoOferta.ACTIVE.ordinal(),  p.getPedido(), p.getDesguace(),p.getDesguaceNombre(), p.getFecha_baja(),p.getFecha_limite());
		             bd.close();
		             return stringID;
				}
				else{
					System.err.println("Login incorrecto");
				}
 			}
 			else{
				System.err.println("secretKey = NULL!");
				return "errorClaveSimetrica";
 			}
        } catch (SQLException ex) {
            Logger.getLogger(DesguaceJavaWS.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DesguaceJavaWS.class.getName()).log(Level.SEVERE, null, ex);
        }
           
    	bd.close();
        return "";

    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "getOfertas")
    public String getOfertas(@WebParam(name = "string") String id, @WebParam(name="password") String password) {
        try {   

        	 bd = new InterfazBD("sor_gestor");
        	   SecretKey key = getKey(id);
   			
   			if (key != null|| !seguridad.Config.isCifradoSimetrico()) {   			
   				Desguace nuevoDesguace= bd.getDesguaceEnGestor(id);
   				bd.close();
   				if(TripleDes.decrypt(key, password).equals(nuevoDesguace.getPassword())){
   					bd = new InterfazBD("sor_gestor");
	             ArrayList<Oferta> listaOfertas = new ArrayList<Oferta>();
	            listaOfertas=bd.getOfertasDesguace(id);
	            Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ss").create();
	            String listaJSON = gson.toJson(listaOfertas);
	            System.out.println("listaJSON = " + listaJSON);
	            bd.close();
	            return TripleDes.encrypt(key, listaJSON);
			}
   			
		
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
           return "";
        }       

    /**
     * Web service operation
     */
    @WebMethod(operationName = "getPedidosporID")
    public String getPedidosporID(@WebParam(name = "string") String string, @WebParam(name="password") String password) {
    	 Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ss").create();
        try {

        	 bd = new InterfazBD("sor_gestor");
            SecretKey key = getKey(string);
			
			if (key != null|| !seguridad.Config.isCifradoSimetrico()) {
				
			
				Desguace nuevoDesguace= bd.getDesguaceEnGestor(string);
				if(TripleDes.decrypt(key, password).equals(nuevoDesguace.getPassword())){

	             Type collectionType = new TypeToken<ArrayList<String>>(){}.getType();
	             ArrayList<String>  listaids = gson.fromJson(string, collectionType);
	            ArrayList<Pedido> listapedidos= new ArrayList<Pedido>();
	             for(String s: listaids){
	                 listapedidos.add(bd.getPedidoID(s));
	             }
	             
	            String listaJSON = gson.toJson(listapedidos);
	            System.out.println("listaJSON = " + listaJSON);
	            bd.close();

	            return TripleDes.encrypt(key, listaJSON);
				}else{
					System.err.println("Login incorrecto");
				}

	            

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
        return null;
    }
    /**
     * Web service operation
     */
    @WebMethod(operationName = "getPedidoporID")
    public String getPedidoporID(@WebParam(name = "string") String id,@WebParam(name = "idDesguace") String idDesguace, @WebParam(name="password") String password) {
    	 Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ss").create();
        try {
            bd = new InterfazBD("sor_gestor");

            SecretKey key = getKey(idDesguace);
			
			if (key != null|| !seguridad.Config.isCifradoSimetrico()) {
				Desguace nuevoDesguace= bd.getDesguaceEnGestor(idDesguace);
				if(TripleDes.decrypt(key, password).equals(nuevoDesguace.getPassword())){

	            String listapedidos="";
	            Pedido p=bd.getPedidoID(id);
	            listapedidos=gson.toJson(p);
	            bd.close();

return TripleDes.encrypt(key, listapedidos);
				}
				else{
					System.err.println("Login incorrecto");
				}

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
        return null;
    }
    /**
     * Web service operation
     */
    @WebMethod(operationName = "aceptarOfertaFin")
    public Boolean aceptarOfertaFin(@WebParam(name = "id") String id, @WebParam(name = "idDesguace") String idDesguace, @WebParam(name = "password") String password) {
        Boolean aceptada=false;
        try {
        	  bd = new InterfazBD("sor_gestor");
        	SecretKey key = getKey(idDesguace);
 			if (key != null|| !seguridad.Config.isCifradoSimetrico()) {
 				Desguace nuevoDesguace= bd.getDesguaceEnGestor(idDesguace);
				if(TripleDes.decrypt(key, password).equals(nuevoDesguace.getPassword())){
	          
	            Oferta of= bd.getOfertaporID(TripleDes.decrypt(key, id));
	            aceptada=bd.cambiarEstadoOferta(EstadoOferta.FINISHED_OK, id);
	            Pedido ped= bd.getPedido(of.getPedido());
	            ArrayList<Oferta> listaoferta=bd.getOfertasPedido(ped.getID());
	            for(Oferta oferta:listaoferta){
	            	if(oferta.getEstado()==EstadoOferta.ACTIVE ||oferta.getEstado()==EstadoOferta.NEW ||oferta.getEstado()==EstadoOferta.ACCEPTED){
	            		bd.cambiarEstadoOferta(EstadoOferta.REJECTED, oferta.getID());
	            	}
	            }
	            bd.cambiarEstadoPedido(EstadoPedido.FINISHED_OK,ped.getID());
	            bd.close();
	            return aceptada;
				}else{
					System.err.println("Login incorrecto");
				}
 			}
 			else{
 				
 			}
 			
        } catch (SQLException ex) {
            Logger.getLogger(DesguaceJavaWS.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DesguaceJavaWS.class.getName()).log(Level.SEVERE, null, ex);
        }
        bd.close();
        return aceptada;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "cancelarOferta")
    public Boolean cancelarOferta(@WebParam(name = "id") String id, @WebParam(name = "idDesguace") String idDesguace, @WebParam(name = "password") String password) {
        Boolean aceptada=false;
        try {
        	 bd = new InterfazBD("sor_gestor");
        	SecretKey key = getKey(idDesguace);
 			if (key != null || !seguridad.Config.isCifradoSimetrico()) {
 				Desguace nuevoDesguace= bd.getDesguaceEnGestor(idDesguace);
				if(TripleDes.decrypt(key, password).equals(nuevoDesguace.getPassword())){
	           
	            aceptada=bd.cambiarEstadoOferta(EstadoOferta.CANCELLED, id);
	            bd.close();
	            
	            return aceptada;
				}else{
					System.err.println("Login incorrecto");
				}
 			}
 			else{
 				
 			}
            
        } catch (SQLException ex) {
            Logger.getLogger(DesguaceJavaWS.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DesguaceJavaWS.class.getName()).log(Level.SEVERE, null, ex);
        }
        bd.close();
        return aceptada;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "baja")
    public Boolean baja(@WebParam(name = "id") String id, @WebParam(name="password") String password) {
        try {        
       	 bd = new InterfazBD("sor_gestor");
     	SecretKey key = getKey(id);
			if (key != null|| !seguridad.Config.isCifradoSimetrico()) {
				Desguace nuevoDesguace= bd.getDesguaceEnGestor(id);
				if(TripleDes.decrypt(key, password).equals(nuevoDesguace.getPassword())){
	            boolean oool = bd.bajaDesguace(id);
	            bd.close();
	            return oool;
			}
			
			}
        } catch (SQLException ex) {
            Logger.getLogger(DesguaceJavaWS.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DesguaceJavaWS.class.getName()).log(Level.SEVERE, null, ex);
        }
        bd.close();
        return false;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "cambiarEstadoPedido")
    public Boolean cambiarEstadoPedido(@WebParam(name = "id") String id, @WebParam(name = "estado") String estado, @WebParam(name = "idDesguace") String idDesguace, @WebParam(name = "password") String password) {
         
           
        try {
        	 bd= new InterfazBD("sor_gestor");
        	SecretKey key = getKey(idDesguace);
 			if (key != null|| !seguridad.Config.isCifradoSimetrico()) {
 				Desguace nuevoDesguace= bd.getDesguaceEnGestor(idDesguace);
				if(TripleDes.decrypt(key, password).equals(nuevoDesguace.getPassword())){
	           
	            System.out.println("miau");
	           Boolean ool = bd.cambiarEstadoPedido(EstadoPedido.valueOf(estado), id);
	           bd.close();
	           return ool;
				}else{
					
					System.err.println("Login incorrecto");
				}
 			}
 			else{
 				
 			}
 			
        } catch (SQLException ex) {
            Logger.getLogger(DesguaceJavaWS.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DesguaceJavaWS.class.getName()).log(Level.SEVERE, null, ex);
        }
            
        bd.close();
        return false;
    }
    @WebMethod(operationName = "cambiarEstadoPedidoOtravez")
    public Boolean cambiarEstadoPedidoOtravez(@WebParam(name = "id") String id, @WebParam(name = "estado") String estado, @WebParam(name = "idDesguace") String idDesguace, @WebParam(name = "password") String password) {
         
           
        try {
        	 bd= new InterfazBD("sor_gestor");
        	SecretKey key = getKey(idDesguace);
 			if (key != null|| !seguridad.Config.isCifradoSimetrico()) {
 				Desguace nuevoDesguace= bd.getDesguaceEnGestor(idDesguace);
				if(TripleDes.decrypt(key, password).equals(nuevoDesguace.getPassword())){
	           
	           Boolean ool = bd.cambiarEstadoPedido(EstadoPedido.valueOf(estado), id);
	           bd.close();
	           return ool;
				}else{
					System.err.println("Login incorrecto");
				}
 			}
 			else{
 				
 			}
      
        } catch (SQLException ex) {
            Logger.getLogger(DesguaceJavaWS.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DesguaceJavaWS.class.getName()).log(Level.SEVERE, null, ex);
        }
            
        bd.close();
        return false;
    }
    public boolean modificar(@WebParam(name = "id") String id, @WebParam(name = "name") String name, @WebParam(name = "email") String email, @WebParam(name = "address") String address, @WebParam(name = "city") String city, @WebParam(name = "postalCode") String postalCode, @WebParam(name = "telephone") String telephone, @WebParam(name = "password") String password) {
        try {
        	bd = new InterfazBD("sor_gestor");
			SecretKey key = getKey(id);
			if (key != null|| !seguridad.Config.isCifradoSimetrico()) {
				Desguace nuevoDesguace= bd.getDesguaceEnGestor(id);
				if(TripleDes.decrypt(key, password).equals(nuevoDesguace.getPassword())){
	            
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
	            return res;
				}
				else{
					System.err.println("Login incorrecto");
				}
			} else {
				System.err.println("secretKey = NULL!");
			}
			
        } catch (java.sql.SQLException ex) {
            Logger.getLogger(TallerWS.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(TallerWS.class.getName()).log(Level.SEVERE, null, ex);
        }
        bd.close();
        return false;
    }
}

