/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package gestion;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author Cute
 */
public class Gestion extends Application {

    static String getOfertasporPedido() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
        
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.show();
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

    public static String getAltas() {
        gestor_admin.AdminWS_Service service = new gestor_admin.AdminWS_Service();
        gestor_admin.AdminWS port = service.getAdminWSPort();
        return port.getAltas();
    }

    public static String getDesguaces() {
        gestor_admin.AdminWS_Service service = new gestor_admin.AdminWS_Service();
        gestor_admin.AdminWS port = service.getAdminWSPort();
        return port.getDesguaces();
    }

    public static String getOfertas() {
        gestor_admin.AdminWS_Service service = new gestor_admin.AdminWS_Service();
        gestor_admin.AdminWS port = service.getAdminWSPort();
        return port.getOfertas();
    }

    public static String getPedidos() {
        gestor_admin.AdminWS_Service service = new gestor_admin.AdminWS_Service();
        gestor_admin.AdminWS port = service.getAdminWSPort();
        return port.getPedidos();
    }

    public static String getTalleres() {
        gestor_admin.AdminWS_Service service = new gestor_admin.AdminWS_Service();
        gestor_admin.AdminWS port = service.getAdminWSPort();
        return port.getTalleres();
    }

    public static String getPedidoID(java.lang.String id) {
        gestor_admin.AdminWS_Service service = new gestor_admin.AdminWS_Service();
        gestor_admin.AdminWS port = service.getAdminWSPort();
        return port.getPedidoID(id);
    }

    public static String getOfertasporPedido(java.lang.String idPedido) {
        gestor_admin.AdminWS_Service service = new gestor_admin.AdminWS_Service();
        gestor_admin.AdminWS port = service.getAdminWSPort();
        return port.getOfertasporPedido(idPedido);
    }

}
