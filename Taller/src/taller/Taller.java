/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package taller;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.util.regex.*;

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
    
    public static boolean validarNombre(String n)
    {
        Pattern p = Pattern.compile("^[a-zA-Z]+");
        Matcher m = p.matcher(n);
        if(!m.find())
        {
            System.err.println("Los nombres no pueden contener carácteres extraños (á,é,ñ,...)");
            return false;
        }
        return true;
    }
    
    public static boolean validar()
    {
        return validarNombre("hoal");
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
    
}
