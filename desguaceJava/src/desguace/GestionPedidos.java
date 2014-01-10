/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package desguace;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Cute
 */
public class GestionPedidos implements Initializable {
    Stage thisStage;
    @FXML
    private TextField tfNombreTaller;
    @FXML
    private TextField tfNombrePieza;
    @FXML
    private Button btBuscarPedido;
    @FXML
    private TextField tfLimiteDia;
    @FXML
    private TextField tfLimiteMes;
    @FXML
    private TextField tfLimiteAnyo;
    @FXML
    private TableView<?> tvGrid;
    @FXML
    private TextField tfIDOferta;
    @FXML
    private TextField tfPVPmin;
    @FXML
    private ComboBox<?> cbEstadoOfertas;
    @FXML
    private Button btBuscarOfertas;
    @FXML
    private TextField tfPVPMax;
    @FXML
    private Button btNuevaOferta;
    @FXML
    private Button btAnularOferta;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void buscar(ActionEvent event) {
    }
        public void setStage(Stage stage) {
        thisStage = stage;
    }

    public void showStage() {
        thisStage.sizeToScene();
        thisStage.show();
    }
}
