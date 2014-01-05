/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package taller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author manu
 */
public class DetallePiezaController implements Initializable {

    public TextField tfNombrePieza;
    public ComboBox cbTipo;
    public ComboBox cbEstado;
    public TextField tfStock;
    public TextArea taDescripcion;
    public CheckBox chActiva;
    public TextField tfBajaDia;
    public TextField tfBajaMes;
    public TextField tfBajaAnyo;
    public Button btBaja;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
