/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package desguace;

import BD.InterfazBD;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.fxml.JavaFXBuilderFactory;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Cute
 */
public class DesguacerPendienteActivacionController implements Initializable {
 Stage thisStage;
    InterfazBD bd;
    /**
     * Initializes the controller class.
     */
    @FXML
    public Button btRecargar;
    public ProgressIndicator piIndicador;
    public Label lbEstado;
    public TextField tfValidar;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
    
    public void comprobarActivacion() throws  ClassNotFoundException, IOException {
     try {
         bd = new InterfazBD("sor_desguace");
         btRecargar.setDisable(true);
         lbEstado.setText("");
         piIndicador.setVisible(true);
         String email= bd.getDesguace().getEmail();
         String idRecibido = DesguaceJava.checkActivacion(email,tfValidar.getText());
         if ("".equals(idRecibido)) //No Activado
         {
             lbEstado.setStyle("-fx-border-color: red;");
             lbEstado.setText("Su usuario o contraseña es incorrecto");
         } else //Activado
         {
             //enviar a pantalla gestion de pedido
             System.out.println("He recibido " + idRecibido);
             
             if (!DesguaceJava.activarDesguacesBD(idRecibido)) {
                 System.out.println(",pero no he podido updatear");
                 lbEstado.setStyle("-fx-border-color: red;");
                 lbEstado.setText("Su cuenta no ha podido activarse");
             } else {
            	 DesguaceJava.desguace=bd.getDesguace();
            	 DesguaceJava.ponerCodigoActivacionTaller(tfValidar.getText());
                 URL location = getClass().getResource("GestionPedidos.fxml");
                 FXMLLoader loader = new FXMLLoader();
                 loader.setLocation(location);
                 loader.setBuilderFactory(new JavaFXBuilderFactory());
                 Parent page = (Parent) loader.load(location.openStream());
                 thisStage.getScene().setRoot(page);
                 thisStage.setTitle("Desguace");
                 GestionPedidos staticDataBox = (GestionPedidos) loader.getController();
                 staticDataBox.setStage(thisStage);
                 staticDataBox.showStage();
             }
         }
         bd.close();
         piIndicador.setVisible(false);
         btRecargar.setDisable(false);
     } catch (SQLException ex) {
         Logger.getLogger(DesguacerPendienteActivacionController.class.getName()).log(Level.SEVERE, null, ex);
     }
    }

    public void setStage(Stage stage) {
        thisStage = stage;
    }

    public void showStage() {
        thisStage.sizeToScene();
        thisStage.show();
    }
}
