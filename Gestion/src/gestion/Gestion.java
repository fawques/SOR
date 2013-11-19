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

    private static String getDesguaces() {
        gestor_admin.AdminWS_Service service = new gestor_admin.AdminWS_Service();
        gestor_admin.AdminWS port = service.getAdminWSPort();
        return port.getDesguaces();
    }

    private static String getOfertas() {
        gestor_admin.AdminWS_Service service = new gestor_admin.AdminWS_Service();
        gestor_admin.AdminWS port = service.getAdminWSPort();
        return port.getOfertas();
    }

    private static String getPedidos() {
        gestor_admin.AdminWS_Service service = new gestor_admin.AdminWS_Service();
        gestor_admin.AdminWS port = service.getAdminWSPort();
        return port.getPedidos();
    }

    private static String getTalleres() {
        gestor_admin.AdminWS_Service service = new gestor_admin.AdminWS_Service();
        gestor_admin.AdminWS port = service.getAdminWSPort();
        return port.getTalleres();
    }


    
}
