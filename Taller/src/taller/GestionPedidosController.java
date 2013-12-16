/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package taller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.TimeZone;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.fxml.FXMLLoader;
import javafx.fxml.JavaFXBuilderFactory;
import javafx.scene.Parent;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author pablovm1990
 */
public class GestionPedidosController implements Initializable {

    @FXML
    //añadir botón al controlador
    Button btNuevoPedido;
    public TextField tfIDPedido;
    public TextField tfIDCliente;
    public TextField tfIDPieza;
    public ComboBox cbEstado;
    private Stage thisStage;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        TimeZone tz = null;
    }    
    
   
    public void onClickNuevoPedido(ActionEvent e) throws IOException
    {
        URL location = getClass().getResource("NuevoPedido.fxml");
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(location);
        loader.setBuilderFactory(new JavaFXBuilderFactory());
        Parent page = (Parent) loader.load(location.openStream());
        thisStage.getScene().setRoot(page);
        thisStage.setTitle("Esperando código de aceptación");
        NuevoPedidoController staticDataBox = (NuevoPedidoController) loader.getController();
        staticDataBox.setStage(thisStage);
        staticDataBox.showStage();
    }
    
    public void setStage(Stage stage) {
        thisStage = stage;
    }

    public void showStage() {
        thisStage.sizeToScene();
        thisStage.show();
    }
    
}
