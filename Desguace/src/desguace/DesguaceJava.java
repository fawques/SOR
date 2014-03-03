/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package desguace;

import BD.InterfazBD;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import general.Desguace;
import general.EstadoGeneral;
import general.EstadoOferta;
import general.EstadoPedido;
import general.Oferta;
import general.Pedido;
import jUDDI.JUDDIProxy;

import java.io.IOException;
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
import webservices.Webservices;
import static webservices.Webservices.*;
import Async.AsyncManager;

/**
 * 
 * @author manu
 */
public class DesguaceJava extends Application {
	public Stage stage;
	static InterfazBD bd;
	public static Desguace desguace;

	@Override
	public void start(Stage stage2) throws IOException, SQLException {
		try {
			JUDDIProxy.loadWsdl("DesguaceJavaWS");
			stage = stage2;
			bd = new InterfazBD("sor_desguace");
			// System.out.println(bd.getPedidosActivos());
			desguace = bd.getDesguace();
			// bd.close();
			if (desguace != null) // pendiente de activacion
			{
				if (desguace.getEstado() == EstadoGeneral.PENDIENTE) // pendiente
																		// de
																		// activacion
				{
					FXMLLoader loader = changeScene("desguacePendienteActivacion.fxml");
					stage.setTitle("Esperando codigo de aceptacion");
					DesguacerPendienteActivacionController staticDataBox = (DesguacerPendienteActivacionController) loader
							.getController();
					staticDataBox.setStage(stage);
					staticDataBox.showStage();
				} else if (desguace.getEstado() == EstadoGeneral.ACTIVE) { // activo
					// Cargar GestionPedido
					FXMLLoader loader = changeScene("GestionPedidos.fxml");
					stage.setTitle("Desguace");
					GestionPedidos staticDataBox = (GestionPedidos) loader
							.getController();
					staticDataBox.setStage(stage);
					staticDataBox.showStage();

				} else if (desguace.getEstado() == EstadoGeneral.INACTIVE) {
					FXMLLoader loader = changeScene("DesguaceDeBaja.fxml");
					stage.setTitle("Desguace");
					DesguaceDeBajaController staticDataBox = (DesguaceDeBajaController) loader
							.getController();
					staticDataBox.setStage(stage);
					staticDataBox.showStage();

				} else { 
					FXMLLoader loader = changeScene("AltaDesguace.fxml");
					stage.setTitle("Alta de desguace");
					AltaDesguace staticDataBox = (AltaDesguace) loader
							.getController();
					staticDataBox.setStage(stage);
					staticDataBox.showStage();
				}
			} else { // no existe
				FXMLLoader loader = changeScene("AltaDesguace.fxml");
				stage.setTitle("Alta de desguace");
				AltaDesguace staticDataBox = (AltaDesguace) loader
						.getController();
				staticDataBox.setStage(stage);
				staticDataBox.showStage();
			}
			bd.close();
		} catch (ClassNotFoundException ex) {
			Logger.getLogger(DesguaceJava.class.getName()).log(Level.SEVERE,
					null, ex);
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

	public FXMLLoader changeScene(String fxml) throws IOException {
		// Mostrar pagina de espera interfaz basica
		URL location = getClass().getResource(fxml);
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

	public Parent replaceSceneContent(String fxml) throws Exception {
		Parent page = (Parent) FXMLLoader.load(
				DesguaceJava.class.getResource(fxml), null,
				new JavaFXBuilderFactory());
		Scene scene = stage.getScene();
		if (scene == null) {
			stage.setScene(scene);
		} else {
			stage.getScene().setRoot(page);
		}
		stage.sizeToScene();
		return page;
	}

	public static boolean activarDesguacesBD(String idRecibido) {
		try {
			bd = new InterfazBD("sor_desguace");
			boolean r = bd.activarDesguaceMainDesguace(idRecibido);
			bd.close();
			return r;

		} catch (SQLException ex) {
			Logger.getLogger(DesguaceJava.class.getName()).log(Level.SEVERE,
					null, ex);
		} catch (ClassNotFoundException ex) {
			Logger.getLogger(DesguaceJava.class.getName()).log(Level.SEVERE,
					null, ex);
		}

		return false;
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

	public static void crearOferta(Date fechaAlta, Date fechaLimite,
			String idPedido, double precio) throws ParseException {
		try {
			bd = new InterfazBD("sor_desguace");
			Desguace desguace = bd.getDesguace();
			String desguaceNombre = desguace.getName();
			String desguaceID = desguace.getID();
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
            Date fechafin = dateFormat.parse("1970/1/1");
			int id = bd.anadirOferta(fechaAlta, 0, precio, idPedido,
					desguaceID, desguaceNombre, fechafin, fechaLimite);
			Oferta nuevo = new Oferta("", id, precio, desguaceID,
					desguaceNombre, idPedido, fechaAlta, fechafin, fechaLimite,
					EstadoOferta.NEW);
			Gson gson = new GsonBuilder()
					.setDateFormat("yyyy-MM-dd'T'HH:mm:ss").create();
			String idFinal = nuevaOferta(gson.toJson(nuevo));
			if(!idFinal.equals("")){
				bd.activarOfertaDesguace(id, idFinal);
			}
			
			bd.close();
		} catch (SQLException ex) {
			Logger.getLogger(DesguaceJava.class.getName()).log(Level.SEVERE,
					null, ex);
		} catch (ClassNotFoundException ex) {
			Logger.getLogger(DesguaceJava.class.getName()).log(Level.SEVERE,
					null, ex);
		}

	}

	public static ArrayList<Oferta> actualizarOfertasAceptadas() {
		ArrayList<Oferta> of = new ArrayList<Oferta>();
		try {
			bd = new InterfazBD("sor_desguace");
			of = bd.getOfertasConID_aux(EstadoOferta.ACCEPTED);
			bd.close();
			return of;
		} catch (SQLException ex) {
			Logger.getLogger(DesguaceJava.class.getName()).log(Level.SEVERE,
					null, ex);
		} catch (ClassNotFoundException ex) {
			Logger.getLogger(DesguaceJava.class.getName()).log(Level.SEVERE,
					null, ex);
		}
		return of;
	}

	public static ArrayList<Oferta> getOfertasDesguace() {
		ArrayList<Oferta> of = new ArrayList<Oferta>();
		try {
			bd = new InterfazBD("sor_desguace");
			of = bd.getOfertasConID_aux();
			bd.close();
			return of;
		} catch (SQLException ex) {
			Logger.getLogger(DesguaceJava.class.getName()).log(Level.SEVERE,
					null, ex);
		} catch (ClassNotFoundException ex) {
			Logger.getLogger(DesguaceJava.class.getName()).log(Level.SEVERE,
					null, ex);
		}
		return of;
	}

	public static ArrayList<Oferta> actualizarOfertas() {
		ArrayList<Oferta> of = new ArrayList<Oferta>();
		try {
			bd = new InterfazBD("sor_desguace");
			of = bd.getOfertasConID_aux(EstadoOferta.ACTIVE);
			//of.addAll(bd.getOfertasConID_aux(EstadoOferta.ACCEPTED));
			bd.close();
			return of;
		} catch (SQLException ex) {
			Logger.getLogger(DesguaceJava.class.getName()).log(Level.SEVERE,
					null, ex);
		} catch (ClassNotFoundException ex) {
			Logger.getLogger(DesguaceJava.class.getName()).log(Level.SEVERE,
					null, ex);
		}
		return of;
	}

	public static boolean cambiarEstadoOferta(String id, EstadoOferta estado) {
		Boolean realizado = false;
		try {
			bd = new InterfazBD("sor_desguace");
			realizado = bd.cambiarEstadoOferta(estado, id);
			return realizado;
		} catch (SQLException ex) {
			Logger.getLogger(DesguaceJava.class.getName()).log(Level.SEVERE,
					null, ex);
		} catch (ClassNotFoundException ex) {
			Logger.getLogger(DesguaceJava.class.getName()).log(Level.SEVERE,
					null, ex);
		}
		return realizado;
	}

	public static boolean cambiarEstadoPedido(String id, EstadoPedido estado) {
		Boolean realizado = false;
		try {
			bd = new InterfazBD("sor_desguace");
			realizado = bd.cambiarEstadoPedido(estado, id);
			if (realizado) {
				cambiarEstadoPedido_1(id, estado.name());
			}
			bd.close();

			return realizado;
		} catch (SQLException ex) {
			Logger.getLogger(DesguaceJava.class.getName()).log(Level.SEVERE,
					null, ex);
		} catch (ClassNotFoundException ex) {
			Logger.getLogger(DesguaceJava.class.getName()).log(Level.SEVERE,
					null, ex);
		}
		return realizado;
	}

	public static ArrayList<Pedido> getPedidos() {
		ArrayList<Pedido> pedidoslista = new ArrayList<Pedido>();
		try {
			bd = new InterfazBD("sor_desguace");
			pedidoslista = bd.getPedidosConID_aux();
			bd.close();
			return pedidoslista;

		} catch (SQLException ex) {
			Logger.getLogger(DesguaceJava.class.getName()).log(Level.SEVERE,
					null, ex);
		} catch (ClassNotFoundException ex) {
			Logger.getLogger(DesguaceJava.class.getName()).log(Level.SEVERE,
					null, ex);
		}
		return pedidoslista;
	}

	public static boolean reactivarDesguace() {
		try {
			bd = new InterfazBD("sor_desguace");
			boolean r = bd.activarDesguace(desguace.getID());
			bd.close();
			return r;
		} catch (SQLException ex) {
			Logger.getLogger(DesguaceJava.class.getName()).log(Level.SEVERE,
					null, ex);
		} catch (ClassNotFoundException ex) {
			Logger.getLogger(DesguaceJava.class.getName()).log(Level.SEVERE,
					null, ex);
		}

		return false;
	}

	public static boolean bajaDesguace() {
		try {
			if (baja(desguace.getID())) {

				bd = new InterfazBD("sor_desguace");

				if (bd.bajaDesguace(desguace.getID())) {
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
			Logger.getLogger(DesguaceJava.class.getName()).log(Level.SEVERE,
					null, ex);
		} catch (ClassNotFoundException ex) {
			Logger.getLogger(DesguaceJava.class.getName()).log(Level.SEVERE,
					null, ex);
		}
		return false;
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

	public static boolean alta(java.lang.String name, java.lang.String email,
			java.lang.String address, java.lang.String city, String postalCode,
			String telephone) {
		AsyncManager manager = new AsyncManager("sor_desguace");
		manager.ejecutarAcciones();
		for (int i = 0; i < 10; i++) {
			try {
				boolean ret = Webservices.alta_WS(name, email, address, city,
						postalCode, telephone);
				// si no ha lanzado excepción, devolvemos correctamente
				return ret;
			} catch (javax.xml.ws.WebServiceException e) {
			}
		}
		try {
			if (JUDDIProxy.loadHasChanged("DesguaceJavaWS")) {
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

	public static String checkActivacion(java.lang.String mail) {
		for (int i = 0; i < 10; i++) {
			try {
				String ret = Webservices.checkActivacion_WS(mail);
				// si no ha lanzado excepción, devolvemos correctamente
				return ret;
			} catch (javax.xml.ws.WebServiceException e) {
			}
		}
		try {
			if (JUDDIProxy.loadHasChanged("DesguaceJavaWS")) {
				return checkActivacion(mail);
			}
		} catch (RemoteException e) {
			System.err.println("NO SE HA PODIDO CONECTAR A JUDDI");
		}catch (javax.xml.ws.WebServiceException e) {

			System.err.println("NO SE HA PODIDO CONECTAR A JUDDI");
		}
		System.err.println("NO SE HA PODIDO CONECTAR AL GESTOR");
		return "";
	}

	public static String nuevaOferta(java.lang.String oferta) {
		AsyncManager manager = new AsyncManager("sor_desguace");
		manager.ejecutarAcciones();
		for (int i = 0; i < 10; i++) {
			try {
				String ret = Webservices.nuevaOferta_WS(oferta);
				// si no ha lanzado excepción, devolvemos correctamente
				return ret;
			} catch (javax.xml.ws.WebServiceException e) {
			}
		}
		try {
			if (JUDDIProxy.loadHasChanged("DesguaceJavaWS")) {
				return nuevaOferta(oferta);
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
		String params[] = { oferta };
		manager.guardarAccion(m, params);
		return "";
	}

	public static String getOfertas() {
		AsyncManager manager = new AsyncManager("sor_desguace");
		manager.ejecutarAcciones();
		for (int i = 0; i < 10; i++) {
			try {
				String ret = Webservices.getOfertas_WS(desguace.getID());
				// si no ha lanzado excepción, devolvemos correctamente
				return ret;
			} catch (javax.xml.ws.WebServiceException e) {
			}
		}
		try {
			if (JUDDIProxy.loadHasChanged("DesguaceJavaWS")) {
				return getOfertas();
			}
		} catch (RemoteException e) {
			System.err.println("NO SE HA PODIDO CONECTAR A JUDDI");
		}catch (javax.xml.ws.WebServiceException e) {

			System.err.println("NO SE HA PODIDO CONECTAR A JUDDI");
		}
		System.err.println("NO SE HA PODIDO CONECTAR AL GESTOR");
		return "";
	}

	public static String getPedidosporID(java.lang.String string) {
		AsyncManager manager = new AsyncManager("sor_desguace");
		manager.ejecutarAcciones();
		for (int i = 0; i < 10; i++) {
			try {
				String ret = getPedidosporID_WS(string);
				// si no ha lanzado excepción, devolvemos correctamente
				return ret;
			} catch (javax.xml.ws.WebServiceException e) {
			}
		}
		try {
			if (JUDDIProxy.loadHasChanged("DesguaceJavaWS")) {
				return getPedidosporID(string);
			}
		} catch (RemoteException e) {
			System.err.println("NO SE HA PODIDO CONECTAR A JUDDI");
		}catch (javax.xml.ws.WebServiceException e) {

			System.err.println("NO SE HA PODIDO CONECTAR A JUDDI");
		}
		System.err.println("NO SE HA PODIDO CONECTAR AL GESTOR");
		return "";
	}

	public static String getPedidoporID(java.lang.String string) {
		AsyncManager manager = new AsyncManager("sor_desguace");
		manager.ejecutarAcciones();
		for (int i = 0; i < 10; i++) {
			try {
				String ret = getPedidoporID_WS(string);
				// si no ha lanzado excepción, devolvemos correctamente
				return ret;
			} catch (javax.xml.ws.WebServiceException e) {
			}
		}
		try {
			if (JUDDIProxy.loadHasChanged("DesguaceJavaWS")) {
				return getPedidoporID(string);
			}
		} catch (RemoteException e) {
			System.err.println("NO SE HA PODIDO CONECTAR A JUDDI");
		}catch (javax.xml.ws.WebServiceException e) {

			System.err.println("NO SE HA PODIDO CONECTAR A JUDDI");
		
		}
		System.err.println("NO SE HA PODIDO CONECTAR AL GESTOR");
		return "";
	}

	public static Boolean aceptarOfertaFin(java.lang.String id) {
		AsyncManager manager = new AsyncManager("sor_desguace");
		manager.ejecutarAcciones();
		for (int i = 0; i < 10; i++) {
			try {
				Boolean ret = Webservices.aceptarOfertaFin_WS(id);
				if (ret) {

				}
				// si no ha lanzado excepción, devolvemos correctamente
				return ret;
			} catch (javax.xml.ws.WebServiceException e) {
			}
		}
		try {
			if (JUDDIProxy.loadHasChanged("DesguaceJavaWS")) {
				return aceptarOfertaFin(id);
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

	public static Boolean cancelarOferta(java.lang.String id) {
		AsyncManager manager = new AsyncManager("sor_desguace");
		manager.ejecutarAcciones();
		for (int i = 0; i < 10; i++) {
			try {
				Boolean ret = Webservices.cancelarOferta_WS(id);
				if (ret) {

				}
				// si no ha lanzado excepción, devolvemos correctamente
				return ret;
			} catch (javax.xml.ws.WebServiceException e) {
			}
		}
		try {
			if (JUDDIProxy.loadHasChanged("DesguaceJavaWS")) {
				return cancelarOferta(id);
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

	public static Boolean baja(java.lang.String id) {
		AsyncManager manager = new AsyncManager("sor_desguace");
		manager.ejecutarAcciones();
		for (int i = 0; i < 10; i++) {
			try {
				Boolean ret = Webservices.baja_WS(id);
				if (ret) {

				}
				// si no ha lanzado excepción, devolvemos correctamente
				return ret;
			} catch (javax.xml.ws.WebServiceException e) {
			}
		}
		try {
			if (JUDDIProxy.loadHasChanged("DesguaceJavaWS")) {
				return baja(id);
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

	public static Boolean cambiarEstadoPedido_1(java.lang.String id,
			String estado) {
		AsyncManager manager = new AsyncManager("sor_desguace");
		manager.ejecutarAcciones();
		for (int i = 0; i < 10; i++) {
			try {
				Boolean ret = Webservices.cambiarEstadoPedido_WS(id, estado);
				// si no ha lanzado excepción, devolvemos correctamente
				return ret;
			} catch (javax.xml.ws.WebServiceException e) {
			}
		}
		try {
			if (JUDDIProxy.loadHasChanged("DesguaceJavaWS")) {
				return cambiarEstadoPedido_1(id, estado);
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
		String params[] = { id, estado };
		manager.guardarAccion(m, params);
		return false;
	}
	 public static boolean modificarDatos(String nombre, String email, String direccion, String ciudad, String codPostal, String telefono) {
	        try {
	            if (modificar(desguace.getID(), nombre, email, direccion, ciudad, codPostal, telefono)) {
	                bd = new InterfazBD("sor_desguace");
	                boolean o = bd.modificarDesguace(nombre, email, direccion, ciudad, Integer.parseInt(codPostal), Integer.parseInt(telefono));
	                desguace=bd.getDesguace();
	                bd.close();
	                return o;
	            }
	        } catch (SQLException ex) {
	            Logger.getLogger(DesguaceJava.class.getName()).log(Level.SEVERE, null, ex);
	        } catch (ClassNotFoundException ex) {
	            Logger.getLogger(DesguaceJava.class.getName()).log(Level.SEVERE, null, ex);
	        }
	        return false;
	    }
	    public static boolean modificar(java.lang.String id, java.lang.String name, java.lang.String email, java.lang.String address, java.lang.String city, String postalCode, String telephone) {
	        AsyncManager manager = new AsyncManager("sor_taller");
	        manager.ejecutarAcciones();
	        for (int i = 0; i < 10; i++) {
	            try{
	                Boolean ret = modificar_WS(id, name, email, address, city, postalCode, telephone);
	                // si no ha lanzado excepción, devolvemos correctamente
	                return ret;
	            }catch(javax.xml.ws.WebServiceException e){}
	        }
	        System.err.println("NO SE HA PODIDO CONECTAR AL GESTOR");
	        class Local {};
	        java.lang.reflect.Method m = Local.class.getEnclosingMethod();
	        String params[] = {id, name, email, address, city, postalCode, telephone};
	        manager.guardarAccion(m,params);
	        return false;
	    }
}
