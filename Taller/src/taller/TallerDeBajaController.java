/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package taller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.fxml.JavaFXBuilderFactory;
import javafx.scene.Parent;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author pablovm1990
 */
public class TallerDeBajaController implements Initializable {

    Stage thisStage;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    public void reactivarTaller() throws IOException {
        if (MainTaller.reactivarTaller()) {
            URL location = getClass().getResource("GestionPedidos.fxml");
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(location);
            loader.setBuilderFactory(new JavaFXBuilderFactory());
            Parent page = (Parent) loader.load(location.openStream());
            thisStage.getScene().setRoot(page);
            GestionPedidosController tdCont = (GestionPedidosController) loader.getController();
            tdCont.setStage(thisStage);
            tdCont.showStage();
        }
    }

    /**
     *
     * @param stage
     */
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
