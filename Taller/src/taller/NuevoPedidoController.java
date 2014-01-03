/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package taller;

import general.EstadoPedido;
import general.Pieza;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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
 * @author manu
 */
public class NuevoPedidoController implements Initializable {

    Stage stage;
    ObservableList data = FXCollections.observableArrayList();
    @FXML
    public Button btAnadirPieza;
    public TableView tbPedidos;
    public ComboBox cbEstado;
    public TextField tfLimiteDia;
    public TextField tfLimiteMes;
    public TextField tfLimiteAnyo;
    public TextField tfIdPieza;
    public TextField tfCantidadPieza;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    public void setStage(Stage s) {
        stage = s;
    }
    public void showStage() {
        stage.show();
    }

    public void realizarPedido() {
        //validar
        //EstadoAutomatico.valueOf(cbEstado.getValue().toString()) falta añadir estado manual/automatica
        Date today = new Date();
        Date fechaLimite = new Date(Integer.parseInt(tfLimiteAnyo.getText()), Integer.parseInt(tfLimiteMes.getText()), Integer.parseInt(tfLimiteDia.getText()));
        MainTaller.crearPedido(today, EstadoPedido.WAITING_ACCEPT, fechaLimite, new ArrayList<Pieza>(), new ArrayList<Integer>());
    }

    public void anyadirPiezaAPedido() {
        //NO ESTA HECHO
        tbPedidos.setItems(data);
    }
}
