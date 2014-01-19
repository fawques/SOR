/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package desguace;

import BD.InterfazBD;
import activemq.Gestor_activemq;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import general.EstadoOferta;
import general.EstadoPedido;
import general.Oferta;
import general.Pedido;
import interfaz.TablaOfertas;
import interfaz.TablaPedidos;
import java.lang.reflect.Type;
import java.net.URL;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.util.Callback;
import javax.jms.JMSException;
import javax.swing.text.LabelView;

/**
 * FXML Controller class
 *
 * @author Cute
 */
public class GestionPedidos implements Initializable {
    Stage thisStage;
    public TableView tablePedidos;
    public TableView tableOfertas;
    @FXML
    private Label lbID;
    @FXML 
    private TextField tfPrecio;
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
  ObservableList<TablaOfertas> olTablaOfertas = FXCollections.observableArrayList();
  InterfazBD bd;
  
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
        try {
            bd= new InterfazBD("sor_desguace");
        } catch (SQLException ex) {
            Logger.getLogger(GestionPedidos.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(GestionPedidos.class.getName()).log(Level.SEVERE, null, ex);
        }
          
      Callback<TableColumn, TableCell> integerCellFactory =
                new Callback<TableColumn, TableCell>() {
            @Override
            public TableCell call(TableColumn p) {
                MyIntegerTableCell cell = new MyIntegerTableCell();
                cell.addEventFilter(MouseEvent.MOUSE_CLICKED, new MyEventHandler());
                return cell;
            }
        };
 
        Callback<TableColumn, TableCell> stringCellFactory =
                new Callback<TableColumn, TableCell>() {
            @Override
            public TableCell call(TableColumn p) {
                MyStringTableCell cell = new MyStringTableCell();
                cell.addEventFilter(MouseEvent.MOUSE_CLICKED, new MyEventHandler());
                return cell;
            }
        };
        Gson gson = new GsonBuilder().setDateFormat("MMM dd, yyyy").create();
        ArrayList<Pedido> listaPedidos= new ArrayList<Pedido>();
        ArrayList<Oferta> ofertas= new ArrayList<Oferta>();
      TableColumn id_auxCol1 = new TableColumn("Id_aux");
        id_auxCol1.setCellValueFactory(new PropertyValueFactory<TablaPedidos, Integer>("id_aux")); 
        TableColumn idCol1 = new TableColumn("Id");
        idCol1.setCellValueFactory(new PropertyValueFactory<TablaPedidos, String>("id"));
         idCol1.setCellFactory(stringCellFactory);
        TableColumn fecha_altaCol1 = new TableColumn("Fecha alta");
        fecha_altaCol1.setCellValueFactory(new PropertyValueFactory<TablaPedidos, String>("fecha_alta"));
         fecha_altaCol1.setCellFactory(stringCellFactory);
        TableColumn estadoCol1 = new TableColumn("Estado");
        estadoCol1.setCellValueFactory(new PropertyValueFactory<TablaPedidos, Integer>("estado"));
         estadoCol1.setCellFactory(integerCellFactory);
        TableColumn tallerCol = new TableColumn("Taller");
        tallerCol.setCellValueFactory(new PropertyValueFactory<TablaPedidos, String>("taller"));
         tallerCol.setCellFactory(stringCellFactory);
        TableColumn fecha_bajaCol1 = new TableColumn("Fecha baja");
        fecha_bajaCol1.setCellValueFactory(new PropertyValueFactory<TablaPedidos, String>("fecha_baja"));
         fecha_bajaCol1.setCellFactory(stringCellFactory);
        TableColumn fecha_limiteCol1 = new TableColumn("Fecha limite");
        fecha_limiteCol1.setCellValueFactory(new PropertyValueFactory<TablaPedidos, String>("fecha_limite"));
         fecha_limiteCol1.setCellFactory(stringCellFactory);
        
          Type collectionType = new TypeToken<ArrayList<String>>(){}.getType();
            Gestor_activemq activemq;
            String listaIdsString = null;

             ArrayList<String>  listaids = new ArrayList<String>();
        try {
            activemq = new Gestor_activemq();
            activemq.create_Consumer("pedidos");
            
            listaIdsString= activemq.consumer.consumeMessage();
            
           
            activemq.consumer.closeConsumer();
        } catch (JMSException ex) {
            Logger.getLogger(GestionPedidos.class.getName()).log(Level.SEVERE, null, ex);
        }
        String pedidosstring=null;
        collectionType = new TypeToken<ArrayList<Pedido>>(){}.getType();
        if(listaIdsString!=null){
            pedidosstring= DesguaceJava.getPedidosporID(listaIdsString);
        }
        if(!pedidosstring.equals("") && pedidosstring!=null){
            listaPedidos = gson.fromJson(pedidosstring, collectionType);
        }
        
        System.out.println("pasa por aqui");
        TablaPedidos interfaz= new TablaPedidos();
         for (Pedido pedido : listaPedidos) {
            bd.anadirPedido(pedido.getID(), pedido.getFecha_alta(), 1, pedido.getTaller(), pedido.getFecha_baja(),pedido.getFecha_limite(), true);
            interfaz= new TablaPedidos(pedido);
             datatablePedidos.add(interfaz);
             
        }
        for (Pedido pedido : bd.getPedidosConID_aux(EstadoPedido.ACTIVE)) {         
            interfaz= new TablaPedidos(pedido);
             datatablePedidos.add(interfaz);
             
        }
       
        tablePedidos.setItems(datatablePedidos);
        tablePedidos.getColumns().addAll(id_auxCol1, idCol1, fecha_altaCol1, estadoCol1, tallerCol, fecha_bajaCol1, fecha_limiteCol1);

        
        
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

        ofertas = DesguaceJava.actualizarOfertas();
        TablaOfertas tpOf;
        for (Oferta of : ofertas) {
            tpOf = new TablaOfertas(of);
            olTablaOfertas.add(tpOf);
        }

        tableOfertas.setEditable(true);
        tableOfertas.setItems(olTablaOfertas);
        tableOfertas.getColumns().addAll(id_auxCol, idCol, fecha_altaCol, importeCol, estadoCol, pedidoCol, desguaceCol, fecha_bajaCol, fecha_limiteCol);
    }
    public void showStage() {
        thisStage.sizeToScene();
        thisStage.show();
    }
        public void realizarOferta() throws ParseException {
      
            //validar
            //EstadoAutomatico.valueOf(cbEstado.getValue().toString()) falta añadir estado manual/automatica
           
            Date today = new Date();
            String fecha = "" + tfLimiteAnyo.getText() + "/" + tfLimiteMes.getText() + "/" + tfLimiteDia.getText();
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
            Date fechaLimite = dateFormat.parse(fecha);
            
           DesguaceJava.crearOferta(today, fechaLimite,lbID.getText(),Double.parseDouble( tfPrecio.getText()));
            //Mensaje
          //  lbMensaje.setText("La oferta se ha creado correctamente");

       
    }
   public void actualizarOfertas() {
        ArrayList<Oferta> ofertas= new ArrayList<Oferta>();
        olTablaOfertas.clear();
       ofertas = DesguaceJava.actualizarOfertas();
        TablaOfertas tpOf;
        for (Oferta of : ofertas) {
            tpOf = new TablaOfertas(of);
            olTablaOfertas.add(tpOf);
        }

        
        tableOfertas.setItems(olTablaOfertas);
    }
      public void actualizarPedidos() {
           try {
            bd= new InterfazBD("sor_desguace");
        } catch (SQLException ex) {
            Logger.getLogger(GestionPedidos.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(GestionPedidos.class.getName()).log(Level.SEVERE, null, ex);
        }
          Gson gson = new GsonBuilder().setDateFormat("MMM dd, yyyy").create();
          ArrayList<Pedido> listaPedidos= new ArrayList<Pedido>();
        datatablePedidos.clear();
          Type collectionType = new TypeToken<ArrayList<String>>(){}.getType();
            Gestor_activemq activemq;
            String listaIdsString = null;

             ArrayList<String>  listaids = new ArrayList<String>();
        try {
            activemq = new Gestor_activemq();
            activemq.create_Consumer("pedidos");
            
            listaIdsString= activemq.consumer.consumeMessage();
            
           
            activemq.consumer.closeConsumer();
        } catch (JMSException ex) {
            Logger.getLogger(GestionPedidos.class.getName()).log(Level.SEVERE, null, ex);
        }
        String pedidosstring=null;
        collectionType = new TypeToken<ArrayList<Pedido>>(){}.getType();
        if(listaIdsString!=null){
            pedidosstring= DesguaceJava.getPedidosporID(listaIdsString);
        }
        if(!pedidosstring.equals("") && pedidosstring!=null){
            listaPedidos = gson.fromJson(pedidosstring, collectionType);
        }
        
        System.out.println("pasa por aqui");
        TablaPedidos interfaz= new TablaPedidos();
         for (Pedido pedido : listaPedidos) {
            bd.anadirPedido(pedido.getID(), pedido.getFecha_alta(), 1, pedido.getTaller(), pedido.getFecha_baja(),pedido.getFecha_limite(), true);
            interfaz= new TablaPedidos(pedido);
             datatablePedidos.add(interfaz);
             
        }
        for (Pedido pedido : bd.getPedidosConID_aux(EstadoPedido.ACTIVE)) {         
            interfaz= new TablaPedidos(pedido);
             datatablePedidos.add(interfaz);
             
        }
       
        tablePedidos.setItems(datatablePedidos);
      

    }
   
    class MyIntegerTableCell extends TableCell<TablaPedidos, Integer> {
 
        @Override
        public void updateItem(Integer item, boolean empty) {
            super.updateItem(item, empty);
            setText(empty ? null : getString());
            setGraphic(null);
        }
 
        private String getString() {
            return getItem() == null ? "" : getItem().toString();
        }
    }
 
    class MyStringTableCell extends TableCell<TablaPedidos, String> {
 
        @Override
        public void updateItem(String item, boolean empty) {
            super.updateItem(item, empty);
            setText(empty ? null : getString());
            setGraphic(null);
        }
 
        private String getString() {
            return getItem() == null ? "" : getItem().toString();
        }
    }
            
    class MyEventHandler implements EventHandler<MouseEvent> {

 
        @Override
        public void handle(MouseEvent t) {
            TableCell c = (TableCell) t.getSource();
            String tabla= c.getTableView().getId();
            int index = c.getIndex();
            if(datatablePedidos.size()>=index){
                lbID.setText(datatablePedidos.get(index).getId());
            }
           

           
            
        }
    }
            
}
