/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package taller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
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

    public void reactivarTaller() {
        MainTaller.reactivarTaller();
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
