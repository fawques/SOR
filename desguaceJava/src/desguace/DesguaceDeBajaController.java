/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package desguace;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.fxml.JavaFXBuilderFactory;
import javafx.scene.Parent;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Cute
 */
public class DesguaceDeBajaController implements Initializable {
    Stage thisStage;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
        public void reactivarDesguace() throws IOException {
        if (DesguaceJava.reactivarDesguace()) {
            URL location = getClass().getResource("GestionPedidos.fxml");
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(location);
            loader.setBuilderFactory(new JavaFXBuilderFactory());
            Parent page = (Parent) loader.load(location.openStream());
            thisStage.getScene().setRoot(page);
            GestionPedidos tdCont = (GestionPedidos) loader.getController();
            tdCont.setStage(thisStage);
            tdCont.showStage();
        }
    }

    public void setStage(Stage stage) {
        thisStage = stage;
    }

    /**
     *
     */
    public void showStage() {
        thisStage.sizeToScene();
        thisStage.show();
    }
    
}
