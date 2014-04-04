/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package gestor_taller;

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

import java.lang.reflect.Type;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.crypto.SecretKey;
import javax.jms.JMSException;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import java.security.NoSuchAlgorithmException;

import org.apache.commons.codec.digest.DigestUtils;

import seguridad.TripleDes;

/**
 *
 * @author fawques
 */
@WebService(serviceName = "TallerWS")
public class TallerWS {
    
    InterfazBD bd;
    ArrayList<String> listaIdTaller;
    ArrayList<SecretKey> listaSecretKeys;
    
    public boolean modificar(@WebParam(name = "id") String id, @WebParam(name = "name") String name, @WebParam(name = "email") String email, @WebParam(name = "address") String address, @WebParam(name = "city") String city, @WebParam(name = "postalCode") String postalCode, @WebParam(name = "telephone") String telephone) {
        try {
        	SecretKey key = listaSecretKeys.get(listaIdTaller.indexOf(id));
        	//desencriptar aqui
            bd = new InterfazBD("sor_gestor");
        	//desencriptar elementos
            boolean res = bd.modificarTaller(id, TripleDes.decrypt(key, name), TripleDes.decrypt(key, email), TripleDes.decrypt(key, city), TripleDes.decrypt(key, city), Integer.parseInt(TripleDes.decrypt(key, postalCode)), Integer.parseInt(TripleDes.decrypt(key, telephone)), EstadoGeneral.ACTIVE);
            bd.close();
            return res;
        } catch (java.sql.SQLException ex) {
            Logger.getLogger(TallerWS.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(TallerWS.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    public byte[] generarClaveReto(@WebParam (name= "idTaller") String idTaller) {
    	//Generamos la clave de reto y se la mandamos al cliente
		try {
			SecretKey clave = TripleDes.generateKey();
			//habria comprobar que no exista;
			if(listaIdTaller.indexOf(idTaller)!=-1){
				//borramos el anterior
				listaSecretKeys.remove(listaIdTaller.indexOf(idTaller));
				listaIdTaller.remove(listaIdTaller.indexOf(idTaller));
				//y anyadimos el nuevo
				listaIdTaller.add(idTaller);
				listaSecretKeys.add(clave);
			} else{ //anyadir nuevo
				listaIdTaller.add(idTaller);
				listaSecretKeys.add(clave);
			}
			return clave.getEncoded();
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
    	return null;
    }
    
    /**
     *
     * @param email
     * @return
     */
    @WebMethod(operationName = "checkActivacion")
    public String checkActivacion(@WebParam(name = "mail") String email)    {
        try {
            bd = new InterfazBD("sor_gestor");
            Taller taller = bd.getTaller(email);
            String res;
            if (taller.getEstado() == EstadoGeneral.ACTIVE) {
                res = taller.getID();
            }else{
                res = "";
            }
            bd.close();
            return res;
        } catch (SQLException ex) {
            Logger.getLogger(TallerWS.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(TallerWS.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ""; //devolvemos el estado pendiente, por defecto
    }
    private void enviarPedidoActivemq(String nombreCola,PedidoCorto pedido) throws JMSException{
    	 Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ss").create();
            Gestor_activemq activemq= new Gestor_activemq();
            activemq.create_Producer(nombreCola);            
            String pedidoFinal = gson.toJson(pedido);
            activemq.producer.produceMessage(pedidoFinal);
            activemq.producer.closeProduce();
    }
    /**
     * Web service operation
     */
    @WebMethod(operationName = "nuevoPedido")
    public String nuevoPedido(@WebParam(name = "pedido") String pedido, @WebParam(name = "idTaller") String idTaller) throws JMSException {
         try {
            bd = new InterfazBD("sor_gestor");
            Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ss").create();
             Type collectionType = new TypeToken<Pedido>() {
             }.getType();

          	SecretKey key = listaSecretKeys.get(listaIdTaller.indexOf(idTaller));
             Pedido p = gson.fromJson(TripleDes.decrypt(key, pedido), collectionType);

         	
            Date ahora = new Date();
            String stringID  = "Pedido_"+ bd.getNumPedidos();
            p.setID(stringID);
             bd.anadirPedido(stringID,p.getID_aux(), p.getFecha_alta(), p.getEstado().ordinal(), p.getTaller(),p.getTallerNombre() ,p.getFecha_baja(), p.getFecha_limite(), p.getModoAutomatico());
             bd.anyadirPiezasAPedido(stringID, p.getListaPiezas(), p.getListaCantidadesPiezas());
             for(Desguace desguace: bd.getDesguaces()){
             enviarPedidoActivemq(desguace.getID(),new PedidoCorto(p.getID(),p.getEstado()));
            }
            bd.close();
            return stringID;
        } catch (SQLException ex) {
            Logger.getLogger(TallerWS.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(TallerWS.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return "";
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "getOfertas")
    public String getOfertas(@WebParam(name = "listaPedidos") String listaPedidos, @WebParam(name = "idTaller") String idTaller) {
        Type collectionType = new TypeToken<ArrayList<Pedido>>() {
        }.getType();
        Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ss").create();
        ArrayList<Oferta> listaOferta = new ArrayList<>();
        ArrayList<Pedido> arrayPedido = new ArrayList<Pedido>();
        SecretKey key = listaSecretKeys.get(listaIdTaller.indexOf(idTaller));
        arrayPedido = gson.fromJson(TripleDes.decrypt(key, listaPedidos), collectionType);
        try {
            bd = new InterfazBD("sor_gestor");
            for (Iterator<Pedido> it = arrayPedido.iterator(); it.hasNext();) {
                Pedido p = it.next();
                listaOferta.addAll(bd.getOfertasPedido(p.getID()));
            }
            
            String retu=gson.toJson(listaOferta);
            bd.close();
            return retu;
        } catch (SQLException ex) {
            Logger.getLogger(TallerWS.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(TallerWS.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "aceptarOferta")
    public Boolean aceptarOferta(@WebParam(name = "ID") String ID, @WebParam(name = "idTaller") String idTaller) {
        try {
            bd = new InterfazBD("sor_gestor");
            SecretKey key = listaSecretKeys.get(listaIdTaller.indexOf(idTaller));
            bd.cambiarEstadoOferta(EstadoOferta.ACCEPTED, TripleDes.decrypt(key, ID));
            bd.close();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(TallerWS.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(TallerWS.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "rechazarOferta")
    public Boolean rechazarOferta(@WebParam(name = "ID") String ID, @WebParam(name = "idTaller") String idTaller) {
        try {
            bd = new InterfazBD("sor_gestor");

            SecretKey key = listaSecretKeys.get(listaIdTaller.indexOf(idTaller));
            bd.cambiarEstadoOferta(EstadoOferta.REJECTED, TripleDes.decrypt(key, ID));
            bd.close();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(TallerWS.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(TallerWS.class.getName()).log(Level.SEVERE, null, ex);
        }
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
    public Boolean bajaTaller(@WebParam(name = "tallerID") String tallerID) {
        try {
            bd = new InterfazBD("sor_gestor");
            boolean oool = bd.bajaTaller(tallerID);
            bd.close();
            return oool;
        } catch (SQLException ex) {
            Logger.getLogger(TallerWS.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(TallerWS.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "alta")
    public boolean alta(@WebParam(name = "name") String name, @WebParam(name = "email") String email, @WebParam(name = "address") String address, @WebParam(name = "city") String city, @WebParam(name = "postalCode") String postalCode, @WebParam(name = "telephone") String telephone) {
        try {
            bd = new InterfazBD("sor_gestor");
            Date ahora = new Date();
            Random r = new Random(ahora.getTime());
            String stringID  = DigestUtils.md5Hex(ahora.toString() + r);
            boolean res = bd.altaTaller(stringID, name, email, address, city, Integer.parseInt(postalCode), Integer.parseInt(telephone), EstadoGeneral.PENDIENTE.ordinal());
            bd.close();
            return res;
        } catch (java.sql.SQLException ex) {
            Logger.getLogger(TallerWS.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(TallerWS.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
        
    @WebMethod(operationName = "cancelarPedido")
    public Boolean cancelarPedido(@WebParam(name = "idPedido") String idPedido, @WebParam(name = "idTaller") String idTaller) {
        try {
            bd = new InterfazBD("sor_gestor");

            SecretKey key = listaSecretKeys.get(listaIdTaller.indexOf(idTaller));
            boolean oool = bd.cancelarPedido(TripleDes.decrypt(key, idPedido));
            cambiarEstadoPedido(EstadoPedido.CANCELLED.ordinal(), TripleDes.decrypt(key, idPedido));
            bd.close();
            return oool;
        } catch (SQLException ex) {
            Logger.getLogger(TallerWS.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(TallerWS.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "cambiarEstadoPedido")
    public Boolean cambiarEstadoPedido(@WebParam(name = "estado") int estado, @WebParam(name = "id") String id) {
        try {
        	 Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ss").create();
            bd= new InterfazBD("sor_gestor");
            for(Desguace desguace: bd.getDesguaces()){
                enviarPedidoActivemq(desguace.getID(),new PedidoCorto(id,EstadoPedido.values()[estado]));
            }
           Boolean ool = bd.cambiarEstadoPedido(EstadoPedido.values()[estado], id);
           bd.close();
           return ool;
        } catch (SQLException ex) {
            Logger.getLogger(TallerWS.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(TallerWS.class.getName()).log(Level.SEVERE, null, ex);
        } catch (JMSException ex) {
            Logger.getLogger(TallerWS.class.getName()).log(Level.SEVERE, null, ex);
        }
       
        return false;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "getPedidos")
    public String getPedidos(@WebParam(name = "id") String id) {
    	 Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ss").create();
        //Dec 7, 2013 5:46:35 PM
       
            ArrayList<Pedido> listaPedidos = new ArrayList<Pedido>();
        try {
            bd = new InterfazBD("sor_gestor");
            listaPedidos = bd.getPedidosTaller(id);
            for(Pedido p: listaPedidos){
            	if(p.getEstado()==EstadoPedido.FINISHED_OK){
            		ArrayList<Oferta> listaOferta= bd.getOfertasPedido(p.getID());
            		for(Oferta of: listaOferta){
            			if(of.getEstado()!=EstadoOferta.FINISHED_OK){
            				bd.cambiarEstadoOferta(EstadoOferta.REJECTED, of.getID());
            			}
            		}
            	}
            }
            String listaJSON = gson.toJson(listaPedidos);
            System.out.println("listaJSON = " + listaJSON);
            bd.close();
            return listaJSON;
        } catch (SQLException ex) {
            Logger.getLogger(TallerWS.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(TallerWS.class.getName()).log(Level.SEVERE, null, ex);
        }
            
      
        return null;
    }

}
