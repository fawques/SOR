/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package webservices;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;

import gestor_desguace_java.DesguaceJavaWS;

import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.binary.Base64;

import BD.InterfazBD;
import seguridad.SslConfig;
import seguridad.TripleDes;
import jUDDI.JUDDIProxy;

/**
 *
 * @author pablovm1990
 */
public class Webservices {
	static InterfazBD bd;
	static int errorCont;
	private static DesguaceJavaWS prepararWebService() {
		SslConfig.disableCertificateChecking();
		gestor_desguace_java.DesguaceJavaWS_Service service = new gestor_desguace_java.DesguaceJavaWS_Service(JUDDIProxy.getWsdl());
        gestor_desguace_java.DesguaceJavaWS port = service.getDesguaceJavaWSPort();
		SslConfig.disableCNChecker(port);
		return port;
	}

	private static SecretKey prepararClaveReto(String idDesguace, String password) {
		Base64 b64 = new Base64();
		String clave = null;
		if(seguridad.Config.isCifradoSimetrico()){
			clave = generarClaveReto(idDesguace,password);
		}
			
		if (clave!=null) {
			byte[] encodedKey = b64.decode(clave);
			SecretKey encryptor = new SecretKeySpec(encodedKey, 0,
					encodedKey.length, "DESede");
			return encryptor;
		} else {
			return null;
		}



	}
	
	public static String generarClaveReto(String idDesguace, String password){
		SslConfig.disableCertificateChecking();
		gestor_desguace_java.DesguaceJavaWS port = prepararWebService();
        return port.generarClaveReto(idDesguace, password);
    }
	
    public static boolean alta_WS(java.lang.String name, java.lang.String email, java.lang.String address, java.lang.String city, String postalCode, String telephone) {
    	SslConfig.disableCertificateChecking();
		gestor_desguace_java.DesguaceJavaWS port = prepararWebService();
        return port.alta(name, email, address, city, postalCode, telephone);
    }

    public static String checkActivacion_WS(java.lang.String email,java.lang.String contrasenya) {
    	SslConfig.disableCertificateChecking();
		gestor_desguace_java.DesguaceJavaWS port = prepararWebService();
        return port.checkActivacion(email,contrasenya);
    }

    public static String getOfertas_WS(java.lang.String id,java.lang.String password) {
    	SecretKey encryptor = prepararClaveReto(id,password);
			gestor_desguace_java.DesguaceJavaWS port = prepararWebService();
	        try {
				return TripleDes.decrypt(encryptor, port.getOfertas(id,TripleDes.encrypt(encryptor,password)));
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
		return null;
    }
    
    public static String nuevaOferta_WS(java.lang.String oferta, String idDesguace, String password) {
    	SecretKey encryptor = prepararClaveReto(idDesguace,password);
			DesguaceJavaWS port = prepararWebService();
			try {
				String aux = port.nuevaOferta(TripleDes.encrypt(encryptor, oferta), idDesguace, TripleDes.encrypt(encryptor, password));
				if(aux.equals("errorClaveSimetrica")){
					try {
						bd = new InterfazBD("sor_desguace");
						errorCont = bd.getNumPedidosPorError("errorClaveSimetrica");
						bd.close();
						return "errorClaveSimetrica"+errorCont;
					} catch (ClassNotFoundException | SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				return aux;
			} catch (InvalidKeyException | NoSuchAlgorithmException
					| NoSuchPaddingException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return null;
    }

    public static String getPedidosporID_WS(java.lang.String string,java.lang.String password) {
    	SecretKey encryptor = prepararClaveReto(string,password);
			gestor_desguace_java.DesguaceJavaWS port = prepararWebService();
	        try {
				return TripleDes.decrypt(encryptor,port.getPedidosporID(string,TripleDes.encrypt(encryptor, password)));
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
		return null;
    }
    

    public static String getPedidoporID_WS(java.lang.String string,java.lang.String idDesguace,java.lang.String password) {
    	SecretKey encryptor = prepararClaveReto(idDesguace,password);
			gestor_desguace_java.DesguaceJavaWS port = prepararWebService();
	        try {
				return TripleDes.decrypt(encryptor, port.getPedidoporID(string,idDesguace,TripleDes.encrypt(encryptor, password)));
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
		return null;

    }
    
    public static Boolean aceptarOfertaFin_WS(java.lang.String id, String idDesguace, String password) {
    	SecretKey encryptor = prepararClaveReto(idDesguace,password);
			DesguaceJavaWS port = prepararWebService();
			try {
				return port.aceptarOfertaFin(TripleDes.encrypt(encryptor, id), idDesguace, TripleDes.encrypt(encryptor, password));
			} catch (InvalidKeyException | NoSuchAlgorithmException
					| NoSuchPaddingException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return false;
    }

    public static Boolean cancelarOferta_WS(java.lang.String id, String idDesguace, String password) {
    	SecretKey encryptor = prepararClaveReto(idDesguace,password);
			DesguaceJavaWS port = prepararWebService();
			try {
				return port.cancelarOferta(TripleDes.encrypt(encryptor, id), idDesguace, TripleDes.encrypt(encryptor, password));
			} catch (InvalidKeyException | NoSuchAlgorithmException
					| NoSuchPaddingException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return false;
    }

    public static Boolean baja_WS(java.lang.String id, String password) {

       
        
        SecretKey encryptor = prepararClaveReto(id,password);
			DesguaceJavaWS port = prepararWebService();
			
				 try {
					return port.baja(id,  TripleDes.encrypt(encryptor, password));
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
				
	
			
		return false;
    }

    public static Boolean cambiarEstadoPedido_WS(java.lang.String id, java.lang.String estado, String idDesguace, String password) {
    	SecretKey encryptor = prepararClaveReto(idDesguace,password);
			DesguaceJavaWS port = prepararWebService();
			try {
				return port.cambiarEstadoPedidoOtravez(TripleDes.encrypt(encryptor, id), TripleDes.encrypt(encryptor, estado), idDesguace, TripleDes.encrypt(encryptor, password));
			} catch (InvalidKeyException | NoSuchAlgorithmException
					| NoSuchPaddingException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return false;
    }
    public static boolean modificar_WS(String id, String name, String email, String address, String city, String postalCode, String telephone, String password) {
    	SecretKey encryptor = prepararClaveReto(id,password);
			DesguaceJavaWS port = prepararWebService();
			try {
				return port.modificar(id, TripleDes.encrypt(encryptor, name), TripleDes.encrypt(encryptor, email), TripleDes.encrypt(encryptor, address), TripleDes.encrypt(encryptor, city), TripleDes.encrypt(encryptor, postalCode), TripleDes.encrypt(encryptor, telephone), TripleDes.encrypt(encryptor, password));
			} catch (InvalidKeyException | NoSuchAlgorithmException
					| NoSuchPaddingException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return false;
    }
}
