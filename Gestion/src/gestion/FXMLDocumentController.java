/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package gestion;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import general.Taller;
import java.lang.reflect.Type;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
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
   private ObservableList<TallerInterface> personData = FXCollections.observableArrayList();
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
        //System.out.println("You clicked me!");
        //label.setText("Hello World!");
         
         
          //personData.add(new TallerInterface("SilviaSL", "Silvia De Gregorio", "C/ Piruleta", "Nyan","asfasf@gmasf.com",1,8612));
         //for (TallerInterface taller : personData) {
           //  System.out.println(taller);
        //}
         ArrayList<Taller> listaTalleres= new ArrayList<>();
        //ArrayList<Object> objlist= new ArrayList<> (Gestion.getAltas());
        Gson gson = new Gson();
        Type collectionType = new TypeToken<ArrayList<Taller>>(){}.getType();
        listaTalleres = gson.fromJson(Gestion.getAltas(), collectionType);
         System.out.println("pasa por aqui");
         for (Taller taller : listaTalleres) {
             System.out.println(taller);
        }
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        TableColumn columnID = new TableColumn("ID taller");
         TableColumn columnNombre = new TableColumn("Nombre taller");
          TableColumn columnEmail = new TableColumn("Email");
          TableColumn columnDireccion = new TableColumn("Dirección");
          TableColumn columnCiudad = new TableColumn("Ciudad");
           TableColumn columnCodigoPostal = new TableColumn("Código Postal");
          TableColumn columnNumero = new TableColumn("Número telefónico");
           TableColumn columnEstado = new TableColumn("Estado");
           tableTalleres.setEditable(true);
        System.out.println("Initialize!");
          columnID.setCellValueFactory(
           new PropertyValueFactory<TallerInterface,String>("ID taller")
               );
           columnNombre.setCellValueFactory(
           new PropertyValueFactory<TallerInterface,String>("Nombre taller")
           );
           columnEmail.setCellValueFactory(
           new PropertyValueFactory<TallerInterface,String>("Email")
           );
           columnCiudad.setCellValueFactory(
           new PropertyValueFactory<TallerInterface,String>("Ciudad")
           );
           columnEstado.setCellValueFactory(
           new PropertyValueFactory<TallerInterface,String>("Estado")
           );
           columnCodigoPostal.setCellValueFactory(
           new PropertyValueFactory<TallerInterface,String>("codigoPostal")
           );
           columnNumero.setCellValueFactory(
           new PropertyValueFactory<TallerInterface,String>("numeroTelefono")
           );
           columnDireccion.setCellValueFactory(
           new PropertyValueFactory<TallerInterface,String>("Dirección")
           );
           personData.add(new TallerInterface("SilviaSL", "Silvia De Gregorio", "C/ Piruleta", "Nyan","asfasf@gmasf.com",1,8612));
           tableTalleres.setItems(personData);
           tableTalleres.getColumns().addAll(columnID,columnNombre,columnEmail,columnDireccion,columnCiudad,columnEstado,columnCodigoPostal,columnNumero);
        // TODO
    }    
    
}
