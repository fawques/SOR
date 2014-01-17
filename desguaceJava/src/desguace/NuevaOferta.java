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
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Cute
 */
public class NuevaOferta implements Initializable {
    @FXML
    private Button btConfirmarEnvio;
    @FXML
    private TextField tfIdOferta;
    @FXML
    private TextArea taPiezas;
    @FXML
    private TextField tfPVP;
    @FXML
    private TextField tfLimiteDia;
    @FXML
    private TextField tfLimiteMes;
    @FXML
    private TextField tfLimiteAnyo;
    @FXML
    private TextField tfEntregaDia;
    @FXML
    private TextField tfEntregaMes;
    @FXML
    private TextField tfEntregaAnyo;
    @FXML
    private Button btCancelar;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void realizarPedido(ActionEvent event) {
    }
    
}
