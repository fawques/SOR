/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package taller;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.TimeZone;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

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
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        TimeZone tz = null;
    }    
    
    public void onClickNuevoPedido(ActionEvent e)
    {
        //System.out.println("hola");
         
        //MainTaller.envioNuevoPedido(id, null, null, null, null, postalCode, telephone);
                
        
    }
    
}
