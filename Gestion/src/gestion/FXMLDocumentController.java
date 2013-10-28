/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package gestion;

import java.net.URL;
import java.util.Map;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 *
 * @author Cute
 */

public class FXMLDocumentController implements Initializable {
   private ObservableList<Taller> personData = FXCollections.observableArrayList();
    @FXML
    private Label label;
    @FXML
    private Button button;
    @FXML private TableView tableTalleres;
    /*@FXML private TableColumn<Taller, String> columnID;
    
    @FXML private TableColumn<Taller, String> columnNombre;
    @FXML private TableColumn<Taller, String> columnEmail;
    @FXML private TableColumn<Taller, String> columnFecha;
    *///@FXML private TableColumn<Taller, String> columnEstado;
    
    @FXML
    private void handleButtonAction(ActionEvent event) {
        System.out.println("You clicked me!");
        //label.setText("Hello World!");
         
         
          personData.add(new Taller("SilviaSL", "Silvia De Gregorio", "C/ Piruleta", "Nyan","asfasf@gmasf.com",1,8612));
         for (Taller taller : personData) {
             System.out.println(taller);
        }
         
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        TableColumn columnNombreTaller = new TableColumn("Nombre taller");
         TableColumn columnDuenyo = new TableColumn("Nombre dueño");
          TableColumn columnDireccion = new TableColumn("Dirección");
          TableColumn columnProvincia = new TableColumn("Provincia");
          TableColumn columnEmail = new TableColumn("Email");
           TableColumn columnCodigoPostal = new TableColumn("Código Postal");
          TableColumn columnNumero = new TableColumn("Número telefónico");
           tableTalleres.setEditable(true);
        System.out.println("Initialize!");
          columnNombreTaller.setCellValueFactory(
           new PropertyValueFactory<Taller,String>("nombreTaller")
               );
           columnDuenyo.setCellValueFactory(
           new PropertyValueFactory<Taller,String>("nombreDuenyo")
           );
           columnDireccion.setCellValueFactory(
           new PropertyValueFactory<Taller,String>("direccion")
           );
           columnProvincia.setCellValueFactory(
           new PropertyValueFactory<Taller,String>("provincia")
           );
           columnEmail.setCellValueFactory(
           new PropertyValueFactory<Taller,String>("email")
           );
           columnCodigoPostal.setCellValueFactory(
           new PropertyValueFactory<Taller,String>("codigoPostal")
           );
           columnNumero.setCellValueFactory(
           new PropertyValueFactory<Taller,String>("numeroTelefono")
           );
           
           personData.add(new Taller("SilviaSL", "Silvia De Gregorio", "C/ Piruleta", "Nyan","asfasf@gmasf.com",1,8612));
           tableTalleres.setItems(personData);
         tableTalleres.getColumns().addAll(columnNombreTaller,columnDuenyo,columnDireccion,columnProvincia,columnEmail,columnCodigoPostal,columnNumero);
        // TODO
    }    
    
}
