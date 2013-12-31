/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package taller;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import general.Pedido;
import java.io.IOException;
import java.net.URL;
import java.util.Date;
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
 * @author pablovm1990
 */
public class GestionPedidosController implements Initializable {

    Stage thisStage;

    @FXML
    Button btNuevoPedido;
    public TextField tfIDPedido;
    public TextField tfIDPieza;
    public ComboBox cbEstado;
    public ComboBox cbModo;
    public TableView tvGrid;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    public void onClickNuevoPedido(ActionEvent e) throws IOException, Exception {
        //If the validation goes well
        //bloquear los inputs
        Pedido nuevoP = new Pedido(1001, "", new Date());
        Gson gson = new GsonBuilder().setDateFormat("MMM dd, yyyy hh:mm:ss a").create();
        String listaJSON = gson.toJson(nuevoP);
        MainTaller.nuevoPedido(listaJSON);
    }

    public void buscar(ActionEvent e) {
        System.out.println(MainTaller.buscarPedidos(tfIDPedido.getText(), tfIDPieza.getText(), cbEstado.getValue().toString(), new Date(), cbModo.getValue().toString()));

    }

    public void eliminarPedido(ActionEvent e) {

    }

    public void setStage(Stage stage) {
        thisStage = stage;
    }

    public void showStage() {
        thisStage.sizeToScene();
        thisStage.show();
    }
}
