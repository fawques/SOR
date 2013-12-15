/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package taller;

import BD.InterfazBD;
import java.net.URL;
import java.sql.SQLException;
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
    InterfazBD bd;
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
    
    public void comprobarActivacion() throws SQLException, ClassNotFoundException {
        bd = new InterfazBD("sor_taller");
        btRecargar.setDisable(true);
        lbEstado.setText("");
        piIndicador.setVisible(true);

        String idRecibido = MainTaller.activarTaller(bd.getPrimerTaller().getEmail());
        if (idRecibido.equals("")) //No Activado
        {
            lbEstado.setStyle("-fx-border-color: red;");
            lbEstado.setText("Su cuenta no está activa");
        } else //Activado
        {
            //enviar a pantalla gestion de pedido
            System.out.println("He recibido " + idRecibido);
            
        }
        //bd.close();
        piIndicador.setVisible(false);
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
