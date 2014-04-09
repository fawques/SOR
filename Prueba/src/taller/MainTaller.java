/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package taller;

import Async.AsyncManager;
import BD.InterfazBD;
import permisos.permisos;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import general.EstadoGeneral;
import general.EstadoOferta;
import general.EstadoPedido;
import general.Oferta;
import general.Pedido;
import general.Pieza;
import general.Taller;
import gestor_taller.JMSException_Exception;

import java.io.IOException;
import java.lang.reflect.Type;
import java.net.URL;
import java.rmi.RemoteException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.fxml.JavaFXBuilderFactory;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import jUDDI.JUDDIProxy;
import webservices.Webservices;
import static webservices.Webservices.*;

/**
 * 
 * @author Pablo
 */
public class MainTaller extends Application {

	static InterfazBD bd;
	static permisos Permisos;
	/**
     *
     */
	public static Taller taller;
	public static Pedido pedidoModificar;
	public static String nombreUsuario;
	/**
     *
     */
	public static Stage stage;

	/**
	 * 
	 * @param stage2
	 * @throws Exception
	 */
	@Override
	public void start(Stage stage2) throws Exception {
		stage = stage2;

		try {
			JUDDIProxy.loadWsdl("TallerWS");
			hello();
			inicioTaller();
		} catch (javax.xml.ws.WebServiceException e) {
			FXMLLoader loader = changeScene("reintentarConexion.fxml");
			stage.setTitle("Conexion fallida");
			ReintentarConexionController staticDataBox = (ReintentarConexionController) loader
					.getController();
			staticDataBox.setStage(stage);
			staticDataBox.showStage();
		}
	}

	public static void inicioTaller() throws IOException,
			ClassNotFoundException, SQLException {

		bd = new InterfazBD("sor_taller");
		// System.out.println(bd.getPedidosActivos());
		taller = bd.getPrimerTaller();
		// bd.close();
		if (taller != null) // esta pendiente o activado
		{
			if (taller.getEstado() == EstadoGeneral.PENDIENTE) // pendiente de
																// activacion
			{
				FXMLLoader loader = changeScene("tallerPendienteActivacion.fxml");
				stage.setTitle("Esperando codigo de aceptacion");
				TallerPendienteActivacionController staticDataBox = (TallerPendienteActivacionController) loader
						.getController();
				staticDataBox.setStage(stage);
				staticDataBox.showStage();
			} else if (taller.getEstado() == EstadoGeneral.ACTIVE) { // activo
				// Cargar GestionPedido
				FXMLLoader loader = changeScene("inicio.fxml");
				stage.setTitle("Inicio");
				inicioController staticDataBox = (inicioController) loader
						.getController();
				staticDataBox.setStage(stage);
				staticDataBox.showStage();
				
			} else { // baja
				FXMLLoader loader = changeScene("TallerDeBaja.fxml");
				stage.setTitle("Baja de taller");
				TallerDeBajaController staticDataBox = (TallerDeBajaController) loader
						.getController();
				staticDataBox.setStage(stage);
				staticDataBox.showStage();
			}
		} else {
			FXMLLoader loader = changeScene("AltaTaller.fxml");
			stage.setTitle("Alta de taller");
			AltaTallerController staticDataBox = (AltaTallerController) loader
					.getController();
			staticDataBox.setStage(stage);
			staticDataBox.showStage();
		}
	}

	/**
	 * The main() method is ignored in correctly deployed JavaFX application.
	 * main() serves only as fallback in case the application can not be
	 * launched through deployment artifacts, e.g., in IDEs with limited FX
	 * support. NetBeans ignores main().
	 * 
	 * @param args
	 *            the command line arguments
	 */
	public static void main(String[] args) {
		launch(args);
	}

	/**
	 * ****************** Escenas *************************
	 */
	/**
	 * @param fxml
	 * @return
	 * @throws java.io.IOException
	 */

	public static FXMLLoader changeScene(String fxml) throws IOException {
		URL location = MainTaller.class.getResource(fxml);
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(location);
		loader.setBuilderFactory(new JavaFXBuilderFactory());
		Parent page = (Parent) loader.load(location.openStream());
		if (stage.getScene() == null) {
			Scene scene = new Scene(page);
			stage.setScene(scene);
		} else {
			stage.getScene().setRoot(page);
			stage.sizeToScene();
		}

		return loader;

	}

	/**
	 * ******************** Validaciones **************************
	 */
	/**
	 * 
	 * @param n
	 * @return
	 */
	public static boolean validarNombre(String n) {

		Pattern p = Pattern.compile("^[a-zA-Z][a-zA-Z ]{0,21}");
		Matcher m = p.matcher(n);
		if (!m.matches()) {
			return false;
		}

		return true;
	}

	public static boolean validarFecha(String dia, String mes, String anyo) {
		Pattern p = Pattern
				.compile("^((((((0[13578])|(1[02]))[\\s\\.\\-\\/\\\\]?((0[1-9])|([12][0-9])|(3[01])))|(((0[469])|(11))[\\s\\.\\-\\/\\\\]?((0[1-9])|([12][0-9])|(30)))|((02)[\\s\\.\\-\\/\\\\]?((0[1-9])|(1[0-9])|(2[0-8]))))[\\s\\.\\-\\/\\\\]?(((([2468][^048])|([13579][^26]))00)|(\\d\\d\\d[13579])|(\\d\\d[02468][^048])|(\\d\\d[13579][^26])))|(((((0[13578])|(1[02]))[\\s\\.\\-\\/\\\\]?((0[1-9])|([12][0-9])|(3[01])))|(((0[469])|(11))[\\s\\.\\-\\/\\\\]?((0[1-9])|([12][0-9])|(30)))|((02)[\\s\\.\\-\\/\\\\]?((0[1-9])|([12][0-9]))))[\\s\\.\\-\\/\\\\]?(((([2468][048])|([13579][26]))00)|(\\d\\d[2468][048])|(\\d\\d[13579][26])|(\\d\\d0[48]))))$");
		Matcher m = p.matcher(mes + dia + anyo);
		if (!m.matches()) {
			return false;
		}

		return true;
	}

	/**
	 * 
	 * @param dir
	 * @return
	 */
	public static boolean validarDireccion(String dir) {
		return dir.length() < 22;
	}

	/**
	 * 
	 * @param num
	 * @return
	 */
	public static boolean validarSoloNumeros(String num) {
		// Verificar que no se pase de 9 digitos!
		Pattern p = Pattern.compile("^[0-9]{0,8}[0-9]");
		Matcher m = p.matcher(num);
		if (!m.matches()) {
			return false;
		}
		return true;
	}

	/**
	 * 
	 * @param n
	 * @return
	 */
	public static boolean validarEmail(String n) {
		Pattern p = Pattern
				.compile("^(([a-zA-Z0-9_\\-\\.]+)@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.)|(([a-zA-Z0-9\\-]+\\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\\]?))$");
		Matcher m = p.matcher(n);
		if (!m.matches()) {
			return false;
		}
		return true;
	}

	/**
	 * 
	 * @param nombreTaller
	 * @param email
	 * @param direccion
	 * @param ciudad
	 * @param cp
	 * @param telefono
	 * @return
	 */
	public static boolean validar(String nombreTaller, String email,
			String direccion, String ciudad, String cp, String telefono) {
		return validarNombre(nombreTaller) && validarEmail(email)
				&& validarNombre(ciudad) && validarSoloNumeros(cp)
				&& validarSoloNumeros(telefono) && validarDireccion(direccion);
	}

	/**
	 * ****************** BD *************************
	 */
	/**
	 * 
	 * @param idRecibido
	 * @return
	 */

	public static boolean activarTallerBD(String idRecibido) {
		try {
			bd = new InterfazBD("sor_taller");
			boolean r = bd.activarTallerMainTaller(idRecibido);
			bd.close();
			return r;
		} catch (SQLException ex) {
			Logger.getLogger(MainTaller.class.getName()).log(Level.SEVERE,
					null, ex);
		} catch (ClassNotFoundException ex) {
			Logger.getLogger(MainTaller.class.getName()).log(Level.SEVERE,
					null, ex);
		}

		return false;
	}

	public static ArrayList<Oferta> actualizarOfertas() {
		try {
			bd = new InterfazBD("sor_taller");
			taller = bd.getPrimerTaller();
			bd.close();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ss")
				.create();

		String ofertasGson = getOfertas(getPedidosActivos());
		Type collectionType = new TypeToken<ArrayList<Oferta>>() {
		}.getType();
		ArrayList<Oferta> listOf = new ArrayList<Oferta>();
		listOf = gson.fromJson(ofertasGson, collectionType);
		// listOf = gson.fromJson(ofertasGson, collectionType);
		try {
			if (listOf != null) {
				for (Oferta of : listOf) {

					if (!MainTaller.cambiarEstadoOferta(of.getEstado(),
							of.getID())) {
						bd = new InterfazBD("sor_taller");
						bd.anadirOferta(of.getID(), of.getFecha_alta(),
								of.getPrecio(), of.getEstado().ordinal(),
								of.getPedido(), of.getDesguace(),
								of.getDesguaceNombre(), of.getFecha_baja(),
								of.getFecha_limite());
						bd.close();
					}

				}
			}				


		} catch (SQLException ex) {
			Logger.getLogger(MainTaller.class.getName()).log(Level.SEVERE,
					null, ex);
		} catch (ClassNotFoundException ex) {
			Logger.getLogger(MainTaller.class.getName()).log(Level.SEVERE,
					null, ex);
		}
		return listOf;
	}

	public static String getPedidosActivos() {
		try {
			bd = new InterfazBD("sor_taller");
			ArrayList<Pedido> p = bd.getPedidosConID_aux();
			bd.close();
			Gson gson = new GsonBuilder()
					.setDateFormat("yyyy-MM-dd'T'HH:mm:ss").create();
			return gson.toJson(p);
		} catch (SQLException ex) {
			Logger.getLogger(MainTaller.class.getName()).log(Level.SEVERE,
					null, ex);
		} catch (ClassNotFoundException ex) {
			Logger.getLogger(MainTaller.class.getName()).log(Level.SEVERE,
					null, ex);
		}
		return null;
	}

	public static String getAllPedidos() {
		try {
			CompararPedidosGestorDesguace();
		}catch(javax.xml.ws.WebServiceException ex){
			System.out.println("Error comparando con el gestor");
		}
		try{
			bd = new InterfazBD("sor_taller");
			ArrayList<Pedido> p = bd.getPedidosConID_aux();
			bd.close();
			Gson gson = new GsonBuilder()
					.setDateFormat("yyyy-MM-dd'T'HH:mm:ss").create();
			return gson.toJson(p);
		} catch (SQLException ex) {
			Logger.getLogger(MainTaller.class.getName()).log(Level.SEVERE,
					null, ex);
		} catch (ClassNotFoundException ex) {
			Logger.getLogger(MainTaller.class.getName()).log(Level.SEVERE,
					null, ex);
		}
		return null;
	}

	public static void CompararPedidosGestorDesguace() {
		try {
			bd = new InterfazBD("sor_taller");
			taller = bd.getPrimerTaller();
			bd.close();
			ArrayList<Pedido> pedidos = new ArrayList<Pedido>();
			ArrayList<Pedido> pedidosgestor = new ArrayList<Pedido>();
			Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ss")
					.create();
			Type collectionType = new TypeToken<ArrayList<Pedido>>() {
			}.getType();
			String pedidosString = getPedidosActivos();
			String pedidosGestorString = getPedidos_WS(taller.getID());
			if (!"".equals(pedidosString) && !"".equals(pedidosGestorString)) {
				pedidosgestor = gson.fromJson(pedidosGestorString, collectionType);
				pedidos = gson.fromJson(pedidosString, collectionType);
			}
			if (pedidosgestor != null) {
				for (Pedido pedidogestor : pedidosgestor) {
					for (Pedido pedidodesguace : pedidos) {
						if (pedidogestor.getID_aux()==pedidodesguace.getID_aux()) {
							if (pedidogestor.getEstado() != pedidodesguace.getEstado()) {
								cambiarEstadoPedido(pedidogestor.getEstado(),pedidogestor.getID());
							}
							if(!pedidogestor.getID().equals(pedidodesguace.getID())){
								bd = new InterfazBD("sor_taller");
								bd.activarPedidoTaller(pedidodesguace.getID_aux(),pedidogestor.getID());
								bd.close();
							}
						}
					}
				}
			}
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public static ArrayList<Pedido> buscarPedidos(String idPedido,
			String idPieza, String estado, Date fechaLimite,
			String modoAceptacion) {
		try {
			bd = new InterfazBD("sor_taller");
			ArrayList<Pedido> p = bd.buscarPedido(idPedido, idPieza, estado,
					fechaLimite, modoAceptacion);
			bd.close();
			return p;
		} catch (SQLException ex) {
			Logger.getLogger(MainTaller.class.getName()).log(Level.SEVERE,
					null, ex);
		} catch (ClassNotFoundException ex) {
			Logger.getLogger(MainTaller.class.getName()).log(Level.SEVERE,
					null, ex);
		}
		return null;
	}

	public static void crearPedido(Date fechaAlta, EstadoPedido estado,
			Date fechaLimite, boolean modoAutomatico, ArrayList<Pieza> piezas,
			ArrayList<Integer> cantidades) throws JMSException_Exception, ParseException {
		try {
			bd = new InterfazBD("sor_taller");
			Taller taller = bd.getPrimerTaller();
			String tallerID = taller.getID();
			String tallerNombre = taller.getName();
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
            Date fechafin = dateFormat.parse("1970/1/1");
			int id = bd.anadirPedido(fechaAlta, estado, tallerID, tallerNombre,
					fechafin, fechaLimite, modoAutomatico);
			Pedido nuevo = new Pedido("", id, tallerID, tallerNombre,
					fechaAlta, fechafin, fechaLimite, estado, modoAutomatico,
					piezas, cantidades, new ArrayList<Oferta>());
			Gson gson = new GsonBuilder()
					.setDateFormat("yyyy-MM-dd'T'HH:mm:ss").create();
			String idFinal = nuevoPedido(gson.toJson(nuevo));
			if(!idFinal.equals("")){
				bd.activarPedidoTaller(id, idFinal);				
			}
			bd.anyadirPiezasAPedido(id, piezas, cantidades);
			bd.close();
		} catch (SQLException ex) {
			Logger.getLogger(MainTaller.class.getName()).log(Level.SEVERE,
					null, ex);
		} catch (ClassNotFoundException ex) {
			Logger.getLogger(MainTaller.class.getName()).log(Level.SEVERE,
					null, ex);
		}

	}

	public static boolean reactivarTaller() {
		try {
			bd = new InterfazBD("sor_taller");
			boolean r = bd.activarTaller(taller.getID());
			bd.close();
			return r;
		} catch (SQLException ex) {
			Logger.getLogger(MainTaller.class.getName()).log(Level.SEVERE,
					null, ex);
		} catch (ClassNotFoundException ex) {
			Logger.getLogger(MainTaller.class.getName()).log(Level.SEVERE,
					null, ex);
		}

		return false;
	}

	public static boolean bajaTaller() {
		try {
			if (baja(taller.getID())) {
				bd = new InterfazBD("sor_taller");
				if (bd.bajaTaller(taller.getID())) {
					bd.close();
					return true;
				} else {
					System.err
							.println("Error: No se ha podido cambiar el estado en taller.");
				}
			} else {
				System.err
						.println("Error: No se ha podido dar de baja en gestor.");
			}
		} catch (SQLException ex) {
			Logger.getLogger(MainTaller.class.getName()).log(Level.SEVERE,
					null, ex);
		} catch (ClassNotFoundException ex) {
			Logger.getLogger(MainTaller.class.getName()).log(Level.SEVERE,
					null, ex);
		}
		return false;
	}

	public static boolean modificarDatos(String nombre, String email,
			String direccion, String ciudad, String codPostal, String telefono) {
		try {
			if (modificar(taller.getID(), nombre, email, direccion, ciudad,
					codPostal, telefono)) {
				bd = new InterfazBD("sor_taller");
				boolean o = bd.modificarTaller(nombre, email, direccion,
						ciudad, Integer.parseInt(codPostal),
						Integer.parseInt(telefono));
				taller = bd.getPrimerTaller();
				bd.close();
				return o;
			}
		} catch (SQLException ex) {
			Logger.getLogger(MainTaller.class.getName()).log(Level.SEVERE,
					null, ex);
		} catch (ClassNotFoundException ex) {
			Logger.getLogger(MainTaller.class.getName()).log(Level.SEVERE,
					null, ex);
		}
		return false;
	}

	public static boolean cancellPedido(String idPedido) {
		try {
			if (cancelarPedido(idPedido)) {
				bd = new InterfazBD("sor_taller");
				boolean o = bd.cancelarPedido(idPedido);
				bd.close();
				return o;
			}
		} catch (SQLException ex) {
			Logger.getLogger(MainTaller.class.getName()).log(Level.SEVERE,
					null, ex);
		} catch (ClassNotFoundException ex) {
			Logger.getLogger(MainTaller.class.getName()).log(Level.SEVERE,
					null, ex);
		}
		return false;
	}

	public static Boolean cambiarEstadoOferta(EstadoOferta estado,
			String idPedido) {
		try {
			bd = new InterfazBD("sor_taller");
			Boolean aceptado = bd.cambiarEstadoOferta(estado, idPedido);

			bd.close();
			return aceptado;
		} catch (SQLException ex) {
			Logger.getLogger(MainTaller.class.getName()).log(Level.SEVERE,
					null, ex);
		} catch (ClassNotFoundException ex) {
			Logger.getLogger(MainTaller.class.getName()).log(Level.SEVERE,
					null, ex);
		}
		return false;
	}

	public static Boolean cambiarEstadoPedido(EstadoPedido estado,
			String idPedido) {
		try {
			bd = new InterfazBD("sor_taller");
			Boolean aceptado = bd.cambiarEstadoPedido(estado, idPedido);

			bd.close();
			if (aceptado) {
				return cambiarEstadoPedido_preWS(
						Integer.toString(estado.ordinal()), idPedido);
			}
		} catch (SQLException ex) {
			Logger.getLogger(MainTaller.class.getName()).log(Level.SEVERE,
					null, ex);
		} catch (ClassNotFoundException ex) {
			Logger.getLogger(MainTaller.class.getName()).log(Level.SEVERE,
					null, ex);
		}
		return false;
	}

	/**
	 * ******************* WebServices *************************
	 * 
	 * @param name
	 * @param email
	 * @param address
	 * @param city
	 * @param postalCode
	 * @param telephone
	 * @return
	 */

	public static boolean cambiarEstadoPedido_preWS(String estado,
			String idPedido) {
		AsyncManager manager = new AsyncManager("sor_taller");
		manager.ejecutarAcciones();
		for (int i = 0; i < 10; i++) {
			try {
				return cambiarEstadoPedido_WS(Integer.parseInt(estado), idPedido);
			} catch (javax.xml.ws.WebServiceException e) {
			}
		}
		try {
			if (JUDDIProxy.loadHasChanged("TallerWS")) {
				return cambiarEstadoPedido_preWS(estado, idPedido);
			}
		} catch (RemoteException e) {
			System.err.println("NO SE HA PODIDO CONECTAR A JUDDI");
		}catch (javax.xml.ws.WebServiceException e) {

			System.err.println("NO SE HA PODIDO CONECTAR A JUDDI");
		}
		System.err.println("NO SE HA PODIDO CONECTAR AL GESTOR");
		// tenemos que guardar el alta en local, y dejarla pendiente de mandar
		class Local {
		}
		;
		java.lang.reflect.Method m = Local.class.getEnclosingMethod();
		String params[] = { estado, idPedido };
		manager.guardarAccion(m, params);
		return false;
	}

	public static boolean alta(java.lang.String name, java.lang.String email,
			java.lang.String address, java.lang.String city, String postalCode,
			String telephone) {
		AsyncManager manager = new AsyncManager("sor_taller");
		manager.ejecutarAcciones();
		for (int i = 0; i < 10; i++) {
			try {
				boolean ret = alta_WS(name, email, address, city, postalCode,
						telephone);
				// si no ha lanzado excepción, devolvemos correctamente
				return ret;
			} catch (javax.xml.ws.WebServiceException e) {
			}
		}
		try {
			if (JUDDIProxy.loadHasChanged("TallerWS")) {
				return alta(name, email, address, city, postalCode, telephone);
			}
		} catch (RemoteException e) {
			System.err.println("NO SE HA PODIDO CONECTAR A JUDDI");
		}catch (javax.xml.ws.WebServiceException e) {

			System.err.println("NO SE HA PODIDO CONECTAR A JUDDI");
		}
		System.err.println("NO SE HA PODIDO CONECTAR AL GESTOR");
		// tenemos que guardar el alta en local, y dejarla pendiente de mandar
		class Local {
		}
		;
		java.lang.reflect.Method m = Local.class.getEnclosingMethod();
		String params[] = { name, email, address, city, postalCode, telephone };
		manager.guardarAccion(m, params);
		return false;
	}

	public static String checkActivacion(java.lang.String contrasenya) {
		for (int i = 0; i < 10; i++) {
			try {
				String ret = checkActivacion_WS(contrasenya);
				// si no ha lanzado excepción, devolvemos correctamente
				return ret;
			} catch (javax.xml.ws.WebServiceException e) {
			}
		}
		try {
			if (JUDDIProxy.loadHasChanged("TallerWS")) {
				return checkActivacion(contrasenya);
			}
		} catch (RemoteException e) {
			System.err.println("NO SE HA PODIDO CONECTAR A JUDDI");
		}catch (javax.xml.ws.WebServiceException e) {

			System.err.println("NO SE HA PODIDO CONECTAR A JUDDI");
		
		}
		System.err.println("NO SE HA PODIDO CONECTAR AL GESTOR");
		return "";
	}

	public static String nuevoPedido(java.lang.String pedido)
			throws JMSException_Exception {
		AsyncManager manager = new AsyncManager("sor_taller");
		manager.ejecutarAcciones();
		for (int i = 0; i < 10; i++) {
			try {
				String ret = nuevoPedido_WS(pedido);
				// si no ha lanzado excepción, devolvemos correctamente
				return ret;
			} catch (javax.xml.ws.WebServiceException e) {
			}
		}
		try {
			if (JUDDIProxy.loadHasChanged("TallerWS")) {
				return nuevoPedido(pedido);
			}
		} catch (RemoteException e) {
			System.err.println("NO SE HA PODIDO CONECTAR A JUDDI");
			
		}catch (javax.xml.ws.WebServiceException e) {
			System.err.println("NO SE HA PODIDO CONECTAR A JUDDI");
		}
		System.err.println("NO SE HA PODIDO CONECTAR AL GESTOR");
		class Local {
		}
		;
		java.lang.reflect.Method m = Local.class.getEnclosingMethod();
		String params[] = { pedido };
		manager.guardarAccion(m, params);
		return "";
	}

	public static String getOfertas(java.lang.String listaPedidos) {
		AsyncManager manager = new AsyncManager("sor_taller");
		manager.ejecutarAcciones();
		for (int i = 0; i < 10; i++) {
			try {
				String ret = getOfertas_WS(listaPedidos);
				// si no ha lanzado excepción, devolvemos correctamente
				return ret;
			} catch (javax.xml.ws.WebServiceException e) {
			}
		}
		try {
			if (JUDDIProxy.loadHasChanged("TallerWS")) {
				return getOfertas(listaPedidos);
			}
		} catch (RemoteException e) {
			System.err.println("NO SE HA PODIDO CONECTAR A JUDDI");
		}catch (javax.xml.ws.WebServiceException e) {

			System.err.println("NO SE HA PODIDO CONECTAR A JUDDI");
		}
		System.err.println("NO SE HA PODIDO CONECTAR AL GESTOR");
		return "";
	}

	public static Boolean aceptarOferta(java.lang.String id) {
		AsyncManager manager = new AsyncManager("sor_taller");
		manager.ejecutarAcciones();
		for (int i = 0; i < 10; i++) {
			try {
				Boolean ret = aceptarOferta_WS(id);
				if (ret) {

				}
				// si no ha lanzado excepción, devolvemos correctamente
				return ret;
			} catch (javax.xml.ws.WebServiceException e) {
			}
		}
		try {
			if (JUDDIProxy.loadHasChanged("TallerWS")) {
				return aceptarOferta(id);
			}
		} catch (RemoteException e) {
			System.err.println("NO SE HA PODIDO CONECTAR A JUDDI");
		}catch (javax.xml.ws.WebServiceException e) {

			System.err.println("NO SE HA PODIDO CONECTAR A JUDDI");
		}
		System.err.println("NO SE HA PODIDO CONECTAR AL GESTOR");
		class Local {
		}
		;
		java.lang.reflect.Method m = Local.class.getEnclosingMethod();
		String params[] = { id };
		manager.guardarAccion(m, params);
		return false;
	}

	public static Boolean rechazarOferta(java.lang.String id) {
		AsyncManager manager = new AsyncManager("sor_taller");
		manager.ejecutarAcciones();
		for (int i = 0; i < 10; i++) {
			try {
				Boolean ret = rechazarOferta_WS(id);
				// si no ha lanzado excepción, devolvemos correctamente
				return ret;
			} catch (javax.xml.ws.WebServiceException e) {
			}
		}
		try {
			if (JUDDIProxy.loadHasChanged("TallerWS")) {
				return rechazarOferta(id);
			}
		} catch (RemoteException e) {
			System.err.println("NO SE HA PODIDO CONECTAR A JUDDI");
		}catch (javax.xml.ws.WebServiceException e) {

			System.err.println("NO SE HA PODIDO CONECTAR A JUDDI");
		}
		System.err.println("NO SE HA PODIDO CONECTAR AL GESTOR");
		class Local {
		}
		;
		java.lang.reflect.Method m = Local.class.getEnclosingMethod();
		String params[] = { id };
		manager.guardarAccion(m, params);
		return false;
	}

	public static String hello() throws javax.xml.ws.WebServiceException {
		AsyncManager manager = new AsyncManager("sor_taller");
		manager.ejecutarAcciones();
		for (int i = 0; i < 10; i++) {
			try {
				return Webservices.hello();
			} catch (javax.xml.ws.WebServiceException e) {
			}
		}
		try {
			if (JUDDIProxy.loadHasChanged("TallerWS")) {
				return Webservices.hello();
			}
		} catch (RemoteException e) {
			System.err.println("NO SE HA PODIDO CONECTAR A JUDDI");
		}catch (javax.xml.ws.WebServiceException e) {

			System.err.println("NO SE HA PODIDO CONECTAR A JUDDI");
		}
		return "";
	}

	private static Boolean baja(java.lang.String tallerID) {
		AsyncManager manager = new AsyncManager("sor_taller");
		manager.ejecutarAcciones();
		for (int i = 0; i < 10; i++) {
			try {
				Boolean ret = baja_WS(tallerID);
				// si no ha lanzado excepción, devolvemos correctamente
				return ret;
			} catch (javax.xml.ws.WebServiceException e) {
			}
		}
		try {
			if (JUDDIProxy.loadHasChanged("TallerWS")) {
				return baja(tallerID);
			}
		} catch (RemoteException e) {
			System.err.println("NO SE HA PODIDO CONECTAR A JUDDI");
		}catch (javax.xml.ws.WebServiceException e) {

			System.err.println("NO SE HA PODIDO CONECTAR A JUDDI");
		}
		System.err.println("NO SE HA PODIDO CONECTAR AL GESTOR");
		class Local {
		}
		;
		java.lang.reflect.Method m = Local.class.getEnclosingMethod();
		String params[] = { tallerID };
		manager.guardarAccion(m, params);
		return false;
	}

	public static boolean modificar(java.lang.String id, java.lang.String name,
			java.lang.String email, java.lang.String address,
			java.lang.String city, String postalCode, String telephone) {
		AsyncManager manager = new AsyncManager("sor_taller");
		manager.ejecutarAcciones();
		for (int i = 0; i < 10; i++) {
			try {
				Boolean ret = modificar_WS(id, name, email, address, city,
						postalCode, telephone);
				// si no ha lanzado excepción, devolvemos correctamente
				return ret;
			} catch (javax.xml.ws.WebServiceException e) {
			}
		}
		try {
			if (JUDDIProxy.loadHasChanged("TallerWS")) {
				return modificar(id, name, email, address, city, postalCode,
						telephone);
			}
		} catch (RemoteException e) {
			System.err.println("NO SE HA PODIDO CONECTAR A JUDDI");
		}catch (javax.xml.ws.WebServiceException e) {

			System.err.println("NO SE HA PODIDO CONECTAR A JUDDI");
		}
		System.err.println("NO SE HA PODIDO CONECTAR AL GESTOR");
		class Local {
		}
		;
		java.lang.reflect.Method m = Local.class.getEnclosingMethod();
		String params[] = { id, name, email, address, city, postalCode,
				telephone };
		manager.guardarAccion(m, params);
		return false;
	}

	private static Boolean cancelarPedido(java.lang.String idPedido) {
		AsyncManager manager = new AsyncManager("sor_taller");
		manager.ejecutarAcciones();
		for (int i = 0; i < 10; i++) {
			try {
				Boolean ret = cancelarPedido_WS(idPedido);
				// si no ha lanzado excepción, devolvemos correctamente
				return ret;
			} catch (javax.xml.ws.WebServiceException e) {
			}
		}
		try {
			if (JUDDIProxy.loadHasChanged("TallerWS")) {
				return cancelarPedido(idPedido);
			}
		} catch (RemoteException e) {
			System.err.println("NO SE HA PODIDO CONECTAR A JUDDI");
		}catch (javax.xml.ws.WebServiceException e) {

			System.err.println("NO SE HA PODIDO CONECTAR A JUDDI");
		}
		System.err.println("NO SE HA PODIDO CONECTAR AL GESTOR");
		class Local {
		}
		;
		java.lang.reflect.Method m = Local.class.getEnclosingMethod();
		String params[] = { idPedido };
		manager.guardarAccion(m, params);
		return false;
	}

	public static void pedidoModificar(String id) {
		try {
			bd = new InterfazBD("sor_taller");
			pedidoModificar = bd.getPedidoID_aux(id);
			bd.close();
			Gson gson = new GsonBuilder()
					.setDateFormat("yyyy-MM-dd'T'HH:mm:ss").create();

		} catch (SQLException ex) {
			Logger.getLogger(MainTaller.class.getName()).log(Level.SEVERE,
					null, ex);
		} catch (ClassNotFoundException ex) {
			Logger.getLogger(MainTaller.class.getName()).log(Level.SEVERE,
					null, ex);
		}

	}

	public static Boolean anyadirRolUsuario(String nombre, String contrasenya, String rol) {
		try {
			bd=new InterfazBD("sor_taller");
			Boolean estarRol= bd.anyadirRolUsuario(nombre,contrasenya,rol);
			bd.close();
			return estarRol;
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
		
	}

	public static Boolean comprobarInicio(String usuario, String contrasenya) {
		try {
			bd=new InterfazBD("sor_taller");
			Boolean comprobar= bd.comprobarInicio(usuario,contrasenya);
			bd.close();
			return comprobar;
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
	}
	public static void anyadirRol(String nombre, ArrayList<Integer> listaOpciones) {
		try {
			bd=new InterfazBD("sor_taller");
			bd.anyadirRol(nombre,listaOpciones);
			bd.close();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}

	public static void cambiarUsuario(String nombre,ArrayList<Integer> listaOpciones) throws Exception {	
		try {
			Permisos= new permisos();
			Permisos.comprobarPermisos("sor_taller", nombreUsuario, "cambiar_usuario");
			bd=new InterfazBD("sor_taller");
			bd.cambiarUsuario(nombre,listaOpciones);
			bd.close();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}

	public static void cambiarRol(String nombreRol,
			ArrayList<Integer> listaOpciones) {
		try {
			bd=new InterfazBD("sor_taller");
			bd.cambiarRol(nombreRol,listaOpciones);
			bd.close();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	public static ArrayList<String> getUsuarios() {
		ArrayList<String> listausuarios=new ArrayList<String>();
		try {
			bd=new InterfazBD("sor_taller");
			listausuarios=bd.getUsuarios();
			bd.close();
			return listausuarios;
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// TODO Auto-generated method stub
		return null;
	}

	public static ArrayList<String> getRoles() {
		ArrayList<String> listausuarios=new ArrayList<String>();
		try {
			bd=new InterfazBD("sor_taller");
			listausuarios=bd.getRoles();
			bd.close();
			return listausuarios;
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// TODO Auto-generated method stub
		return null;
	}

}
