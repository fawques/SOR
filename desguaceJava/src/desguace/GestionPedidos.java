/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package desguace;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import general.EstadoOferta;
import general.Pedido;
import interfaz.TablaPedidos;
import java.lang.reflect.Type;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Cute
 */
public class GestionPedidos implements Initializable {
    Stage thisStage;
    public TableView tablePedidos;
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
ObservableList<TablaPedidos> datatablePedidos = FXCollections.observableArrayList();
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        tablaPedidos();
    }    

    @FXML
    private void buscar(ActionEvent event) {
    }
        public void setStage(Stage stage) {
        thisStage = stage;
    }
    private void tablaPedidos(){
        Gson gson = new GsonBuilder().setDateFormat("MMM dd, yyyy").create();
        ArrayList<Pedido> listaPedidos= new ArrayList<Pedido>();
      TableColumn id_auxCol1 = new TableColumn("Id_aux");
        id_auxCol1.setCellValueFactory(new PropertyValueFactory<TablaPedidos, Integer>("id_aux"));
        TableColumn idCol1 = new TableColumn("Id");
        idCol1.setCellValueFactory(new PropertyValueFactory<TablaPedidos, String>("id"));
        TableColumn fecha_altaCol1 = new TableColumn("Fecha alta");
        fecha_altaCol1.setCellValueFactory(new PropertyValueFactory<TablaPedidos, Date>("fecha_alta"));
        TableColumn estadoCol1 = new TableColumn("Estado");
        estadoCol1.setCellValueFactory(new PropertyValueFactory<TablaPedidos, EstadoOferta>("estado"));
        TableColumn tallerCol = new TableColumn("Taller");
        tallerCol.setCellValueFactory(new PropertyValueFactory<TablaPedidos, String>("taller"));
        TableColumn fecha_bajaCol1 = new TableColumn("Fecha baja");
        fecha_bajaCol1.setCellValueFactory(new PropertyValueFactory<TablaPedidos, Date>("fecha_baja"));
        TableColumn fecha_limiteCol1 = new TableColumn("Fecha limite");
        fecha_limiteCol1.setCellValueFactory(new PropertyValueFactory<TablaPedidos, Date>("fecha_limite"));
        
          Type collectionType = new TypeToken<ArrayList<Pedido>>(){}.getType();
        String pedidosstring= DesguaceJava.getPedidos();
        if(!pedidosstring.equals("") && pedidosstring!=null){
            listaPedidos = gson.fromJson(pedidosstring, collectionType);
        }
        System.out.println("pasa por aqui");
        TablaPedidos interfaz= new TablaPedidos();
         for (Pedido pedido : listaPedidos) {
             interfaz= new TablaPedidos(pedido);
             datatablePedidos.add(interfaz);
             System.out.println(pedido);
        }
        
        tablePedidos.setItems(datatablePedidos);
        tablePedidos.getColumns().addAll(id_auxCol1, idCol1, fecha_altaCol1, estadoCol1, tallerCol, fecha_bajaCol1, fecha_limiteCol1);

    }
    public void showStage() {
        thisStage.sizeToScene();
        thisStage.show();
    }
}
