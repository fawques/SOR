/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package taller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Pablo
 */
public class AltaTallerController implements Initializable {
    
    /**
     * Class variables
     */
    @FXML
    public TextField TfNombreTaller;
    public TextField TfNombreDuenyo;
    public TextField TfDireccion;
    public TextField TfProvincia;
    public TextField TfCp;
    public TextField TfTelefono;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        assert TfNombreTaller != null : "fx:id=\"myButton\" was not injected: check your FXML file 'simple.fxml'.";
    }
    
    public void onClickCancel(ActionEvent e)
    {
        System.exit(0);
    }
    
    public void onClickAceptar(ActionEvent e)
    {
        //Validar
        if(Taller.validar())
        {
            
        }
    }
    
}
