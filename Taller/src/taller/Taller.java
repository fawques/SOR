/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package taller;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author Pablo
 */
public class Taller extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        //if(noEstaRegistradoEnGestor)
        Parent root = FXMLLoader.load(getClass().getResource("AltaTaller.fxml"));

        Scene scene = new Scene(root);

        stage.setScene(scene);
        stage.show();
    }

    /* public void abrirAlta()
     {
     Parent altaTaller = FXMLLoader.load(getClass().getResource("AltaTaller.fxml"));
        
     Scene scene = new Scene(altaTaller);
     }*/
    public static boolean validarNombre(String n) {
        Pattern p = Pattern.compile("^[a-zA-Z ]*[a-zA-Z]");
        Matcher m = p.matcher(n);
        if (!m.matches()) {
            return false;
        }
        return true;
    }

    public static boolean validarSoloNumeros(String num) {
        Pattern p = Pattern.compile("^[0-9 ]*[0-9]");
        Matcher m = p.matcher(num);
        if (!m.matches()) {
            return false;
        }
        return true;
    }

    public static boolean validarEmail(String n) {
        Pattern p = Pattern.compile("^[a-zA-Z0-9]+@[a-zA-Z0-9]+[.][a-zA-Z]+");
        Matcher m = p.matcher(n);
        if (!m.matches()) {
            return false;
        }
        return true;
    }

    public static boolean validar(String nombreTaller, String nombreDuenyo, String direccion, String ciudad, String cp, String telefono) {
        return validarNombre(nombreTaller) && validarNombre(nombreDuenyo) && validarNombre(ciudad) && validarSoloNumeros(cp) && validarSoloNumeros(telefono);
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

    public static String alta(java.lang.String name) {
        taller.TallerWS_Service service = new taller.TallerWS_Service();
        taller.TallerWS port = service.getTallerWSPort();
        return port.alta(name);
    }
}
