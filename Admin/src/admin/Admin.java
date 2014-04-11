/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package admin;


import general.Taller;
import jUDDI.JUDDIProxy;

import java.io.IOException;
import java.net.URL;





import BD.InterfazBD;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.fxml.JavaFXBuilderFactory;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;/*
import javax.mail.Message;
import javax.mail.Message.RecipientType;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;*/

/**
 *
 * @author Cute
 */
public class Admin extends Application {
	   public static Stage stage;
    static String getOfertasporPedido() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public void start(Stage stage2) throws Exception {
    	JUDDIProxy.loadWsdl("AdminWS");
    	 stage = stage2;
        FXMLLoader loader = changeScene("FXMLDocument.fxml");
        stage.setTitle("Admin");
        FXMLDocumentController staticDataBox = (FXMLDocumentController) loader.getController();
        staticDataBox.setStage(stage);
        staticDataBox.showStage();
    }
    
    public static FXMLLoader changeScene(String fxml) throws IOException {
        URL location = Admin.class.getResource(fxml);
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
     * The main() method is ignored in correctly deployed JavaFX application.
     * main() serves only as fallback in case the application can not be
     * launched through deployment artifacts, e.g., in IDEs with limited FX
     * support. NetBeans ignores main().
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

    public static String getOfertas() {
        gestor_admin.AdminWS_Service service = new gestor_admin.AdminWS_Service(JUDDIProxy.getWsdl());
        gestor_admin.AdminWS port = service.getAdminWSPort();
        return port.getOfertas();
    }

    public static String getPedidos() {
        gestor_admin.AdminWS_Service service = new gestor_admin.AdminWS_Service(JUDDIProxy.getWsdl());
        gestor_admin.AdminWS port = service.getAdminWSPort();
        return port.getPedidos();
    }

    public static String getTalleres() {
        gestor_admin.AdminWS_Service service = new gestor_admin.AdminWS_Service(JUDDIProxy.getWsdl());
        gestor_admin.AdminWS port = service.getAdminWSPort();
        return port.getTalleres();
    }
    public static String getTalleresAceptados() {
        gestor_admin.AdminWS_Service service = new gestor_admin.AdminWS_Service(JUDDIProxy.getWsdl());
        gestor_admin.AdminWS port = service.getAdminWSPort();
        return port.getTalleresAceptados();
    }
    public static String getPedidoID(java.lang.String id) {
        gestor_admin.AdminWS_Service service = new gestor_admin.AdminWS_Service(JUDDIProxy.getWsdl());
        gestor_admin.AdminWS port = service.getAdminWSPort();
        return port.getPedidoID(id);
    }

    public static String getOfertasporPedido(java.lang.String idPedido) {
        gestor_admin.AdminWS_Service service = new gestor_admin.AdminWS_Service(JUDDIProxy.getWsdl());
        gestor_admin.AdminWS port = service.getAdminWSPort();
        return port.getOfertasporPedido(idPedido);
    }

    public static String getDesguacesAceptados() {
        gestor_admin.AdminWS_Service service = new gestor_admin.AdminWS_Service(JUDDIProxy.getWsdl());
        gestor_admin.AdminWS port = service.getAdminWSPort();
        return port.getDesguacesAceptados();
    }

    public static String getDesguaces() {
        gestor_admin.AdminWS_Service service = new gestor_admin.AdminWS_Service(JUDDIProxy.getWsdl());
        gestor_admin.AdminWS port = service.getAdminWSPort();
        return port.getDesguaces();
    }



    public static String getAltaTalleres() {
        gestor_admin.AdminWS_Service service = new gestor_admin.AdminWS_Service(JUDDIProxy.getWsdl());
        gestor_admin.AdminWS port = service.getAdminWSPort();
        return port.getAltaTalleres();
    }

    public static void darAccesoTaller(java.lang.String id) {
        gestor_admin.AdminWS_Service service = new gestor_admin.AdminWS_Service(JUDDIProxy.getWsdl());
        gestor_admin.AdminWS port = service.getAdminWSPort();
        port.darAccesoTaller(id);
    }

    public static Boolean addAccesoDesguace(java.lang.String id) {
        gestor_admin.AdminWS_Service service = new gestor_admin.AdminWS_Service(JUDDIProxy.getWsdl());
        gestor_admin.AdminWS port = service.getAdminWSPort();
        return port.addAccesoDesguace(id);
    }

    public static String getAltaDesguace() {
        gestor_admin.AdminWS_Service service = new gestor_admin.AdminWS_Service(JUDDIProxy.getWsdl());
        gestor_admin.AdminWS port = service.getAdminWSPort();
        return port.getAltaDesguace();
    }
    public static String getContrasenyaPorTallerID(java.lang.String id) {
        gestor_admin.AdminWS_Service service = new gestor_admin.AdminWS_Service(JUDDIProxy.getWsdl());
        gestor_admin.AdminWS port = service.getAdminWSPort();
        return port.getContrasenyaPorTallerID(id);
    }
    public static String getContrasenyaPorDesguaceID(java.lang.String id) {
        gestor_admin.AdminWS_Service service = new gestor_admin.AdminWS_Service(JUDDIProxy.getWsdl());
        gestor_admin.AdminWS port = service.getAdminWSPort();
        return port.getContrasenyaPorDesguaceID(id);
    }
}
