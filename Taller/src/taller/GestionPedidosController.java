/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package taller;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import general.EstadoOferta;
import general.Oferta;
import general.Pedido;
import java.io.IOException;
import java.lang.reflect.Type;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author pablovm1990
 */
public class GestionPedidosController implements Initializable {

    Stage thisStage;
    ArrayList<Oferta> ofertas;
    ObservableList<TablaOfertas> olTablaOfertas = FXCollections.observableArrayList();
    ObservableList<TablaPedidos> olTablaPedidos = FXCollections.observableArrayList();

    @FXML
    Button btNuevoPedido;
    public TextField tfIDPedido;
    public TextField tfIDPieza;
    public TextField tfLimiteDia;
    public TextField tfLimiteMes;
    public TextField tfLimiteAnyo;
    public ComboBox cbEstado;
    public ComboBox cbModo;
    public TableView tbPedidos;
    public Button btBuscarPedido;
    
    /* PIEZAS */
    
    public TextField tfNombrePieza;
    public ComboBox cbTipoPiezas;
    public ComboBox cbEstadoPiezas;
    public Button btNuevaPieza;
    public Button btBuscarPieza;
    public TableView tbPiezas;
    
    /* OFERTAS */
    public TextField tfIDPedidoOferta;
    public TextField tfIDCliente;
    public TextField tfIDPiezaOferta;
    public TextField tfNombreCliente;
    public TextField tfApellidos;
    public ComboBox cbEstadoOfertas;
    public TextField tfOfertasDia;
    public TextField tfOfertasMes;
    public TextField tfOfertasAnyo;
    public TableView tbOfertas;
    public TableView tbPedidosOfertas;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        Gson gson = new Gson();

        TableColumn id_auxCol = new TableColumn("Id_aux");
        id_auxCol.setCellValueFactory(new PropertyValueFactory<TablaOfertas, Integer>("id_aux"));
        TableColumn idCol = new TableColumn("Id");
        idCol.setCellValueFactory(new PropertyValueFactory<TablaOfertas, String>("id"));
        TableColumn fecha_altaCol = new TableColumn("Fecha alta");
        fecha_altaCol.setCellValueFactory(new PropertyValueFactory<TablaOfertas, Date>("fecha_alta"));
        TableColumn importeCol = new TableColumn("Importe");
        importeCol.setCellValueFactory(new PropertyValueFactory<TablaOfertas, Double>("importe"));
        TableColumn estadoCol = new TableColumn("Estado");
        estadoCol.setCellValueFactory(new PropertyValueFactory<TablaOfertas, EstadoOferta>("estado"));
        TableColumn pedidoCol = new TableColumn("Pedido");
        pedidoCol.setCellValueFactory(new PropertyValueFactory<TablaOfertas, String>("pedido"));
        TableColumn desguaceCol = new TableColumn("Desguace");
        desguaceCol.setCellValueFactory(new PropertyValueFactory<TablaOfertas, String>("desguace"));
        TableColumn fecha_bajaCol = new TableColumn("Fecha baja");
        fecha_bajaCol.setCellValueFactory(new PropertyValueFactory<TablaOfertas, Date>("fecha_baja"));
        TableColumn fecha_limiteCol = new TableColumn("Fecha limite");
        fecha_limiteCol.setCellValueFactory(new PropertyValueFactory<TablaOfertas, Date>("fecha_limite"));

        ofertas = MainTaller.actualizarOfertas();
        TablaOfertas tpOf;
        for (Oferta of : ofertas) {
            tpOf = new TablaOfertas(of);
            olTablaOfertas.add(tpOf);
        }

        tbOfertas.setEditable(true);
        tbOfertas.setItems(olTablaOfertas);
        tbOfertas.getColumns().addAll(id_auxCol, idCol, fecha_altaCol, importeCol, estadoCol, pedidoCol, desguaceCol, fecha_bajaCol, fecha_limiteCol);

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


        Type collectionType = new TypeToken<ArrayList<Pedido>>() {
        }.getType();
        ArrayList<Pedido> alPedidos = gson.fromJson(MainTaller.getAllPedidos(), collectionType);
        TablaPedidos tpPed;
        for (Pedido pedido : alPedidos) {
            tpPed = new TablaPedidos(pedido);
            olTablaPedidos.add(tpPed);
        }

        tbPedidosOfertas.setEditable(true);
        tbPedidosOfertas.setItems(olTablaPedidos);
        tbPedidosOfertas.getColumns().addAll(id_auxCol1, idCol1, fecha_altaCol1, estadoCol1, tallerCol, fecha_bajaCol1, fecha_limiteCol1);
        tbPedidos.setEditable(true);
        tbPedidos.setItems(olTablaPedidos);
        tbPedidos.getColumns().addAll(id_auxCol1, idCol1, fecha_altaCol1, estadoCol1, tallerCol, fecha_bajaCol1, fecha_limiteCol1);

    }
    
    public void onClickNuevoPedido(ActionEvent e) throws IOException, Exception {
        URL location = getClass().getResource("NuevoPedido.fxml");
        Stage stage = new Stage();
        FXMLLoader loader = new FXMLLoader();
        Parent root = FXMLLoader.load(NuevoPedidoController.class.getResource("NuevoPedido.fxml"));
        loader.load(location.openStream());
        stage.setScene(new Scene(root));
        stage.setTitle("Nuevo pedido");
        stage.initModality(Modality.WINDOW_MODAL);
        stage.initOwner(((Node) e.getSource()).getScene().getWindow());
        NuevoPedidoController np = (NuevoPedidoController) loader.getController();
        np.setStage(stage);
        np.showStage();
        /* Pedido nuevoP = new Pedido(1001, "", new Date());
         Gson gson = new GsonBuilder().setDateFormat("MMM dd, yyyy hh:mm:ss a").create();
        String listaJSON = gson.toJson(nuevoP);
        MainTaller.nuevoPedido(listaJSON);*/
    }

    public void buscarPedido(ActionEvent e) {
        Date fechaLimite = new Date(Integer.parseInt(tfLimiteAnyo.getText().toString()), Integer.parseInt(tfLimiteMes.getText().toString()), Integer.parseInt(tfLimiteDia.getText().toString()));
        System.out.println(MainTaller.buscarPedidos(tfIDPedido.getText(), tfIDPieza.getText(), cbEstado.getValue().toString(), fechaLimite, cbModo.getValue().toString()));

    }

    public void buscarOfertas() {

    }

    public void buscarPieza() {

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

    public void aceptarOferta() {
        //comprobar si hay alguna oferta seleccionada y obtener el ID
        String id = null;
        MainTaller.aceptarOferta(id);
    }

    public void rechazarOferta() {
        //comprobar si hay alguna oferta seleccionada y obtener el ID
        String id = null;
        MainTaller.rechazarOferta(id);
    }

    public void actualizarOfertas() {
        ofertas = MainTaller.actualizarOfertas();
    }
}
