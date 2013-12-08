/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package taller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressIndicator;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author pablovm1990
 */
public class TallerPendienteActivacionController implements Initializable {

    Stage thisStage;
    /**
     * Initializes the controller class.
     */
    @FXML
    public Button btRecargar;
    public ProgressIndicator piIndicador;
    public Label lbEstado;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
    
    public void comprobarActivacion() {
        btRecargar.setDisable(true);
        lbEstado.setText("");
        piIndicador.setVisible(true);

        if (MainTaller.activarTaller() == 0) //Activado
        {
            //enviar a pantalla gestion de pedido

        } else //No activado
        {
            lbEstado.setText("Lo siento, todavía no está activada su cuenta");
            lbEstado.setStyle("-fx-border-color: red;");
        }
        btRecargar.setDisable(false);
    }

    public void setStage(Stage stage) {
        thisStage = stage;
    }

    public void showStage() {
        thisStage.sizeToScene();
        thisStage.show();
    }
}
