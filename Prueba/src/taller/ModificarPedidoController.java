
package taller;

import general.EstadoPedido;
import general.Pedido;
import general.Pieza;
import gestor_taller.JMSException_Exception;



import java.io.IOException;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.fxml.JavaFXBuilderFactory;
import javafx.scene.Parent;
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
import taller.NuevoPedidoController.TablePieza;

/**
 * FXML Controller class
 *
 * @author manu
 */


public class ModificarPedidoController implements Initializable {

    Stage stage;
    ObservableList data = FXCollections.observableArrayList();
    @FXML
    public Button btAnadirPieza;
    public TableView tbPiezas;
    public ComboBox cbModoAutomatico;
    public TextField tfLimiteDia;
    public TextField tfLimiteMes;
    public TextField tfLimiteAnyo;
    public TextField tfIdPieza;
    public TextField tfCantidadPieza;
    public Label lbMensaje;
    public int removeIndex;
    public Pedido p;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    	p= MainTaller.pedidoModificar;
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
        TableColumn idCol = new TableColumn("Id");
        idCol.setCellValueFactory(new PropertyValueFactory<TablePieza, String>("id"));
        idCol.setCellFactory(stringCellFactory);
        TableColumn cantidadCol = new TableColumn("Cantidad");
        cantidadCol.setCellValueFactory(new PropertyValueFactory<TablePieza, Integer>("cantidad"));
        cantidadCol.setCellFactory(integerCellFactory);
        
        ArrayList<Integer> cantidades= p.getListaCantidadesPiezas();
        ArrayList<Pieza> listaPieza= p.getListaPiezas();
        for(int i=0; i<p.getListaCantidadesPiezas().size();i++){
        	TablePieza tp= new TablePieza(listaPieza.get(i).getNombre(), cantidades.get(i));
        	data.add(tp);
        }

        tbPiezas.setEditable(true);
        tbPiezas.setItems(data);
        tbPiezas.getColumns().addAll(idCol, cantidadCol);
    }

    public void setStage(Stage s) {
        stage = s;
    }
    public void showStage() {
    	stage.sizeToScene();
        stage.show();
    }

    public void realizarPedido() throws Exception {
        try {
            //validar
            //EstadoAutomatico.valueOf(cbEstado.getValue().toString()) falta añadir estado manual/automatica
            Date today = new Date();
            String fecha = "" + tfLimiteAnyo.getText() + "/" + tfLimiteMes.getText() + "/" + tfLimiteDia.getText();
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
            Date fechaLimite = dateFormat.parse(fecha);
            ArrayList<Pieza> piezasPedido = new ArrayList<>();
            ArrayList<Integer> cantidadPiezas = new ArrayList<>();
            for (Iterator it = data.iterator(); it.hasNext();) {
                TablePieza tp = (TablePieza) it.next();
                piezasPedido.add(new Pieza(tp.getId()));
                cantidadPiezas.add(tp.getCantidad());
            }
            MainTaller.cancellPedido(p.getID());
            MainTaller.crearPedido(today, EstadoPedido.ACTIVE, fechaLimite, "Automatico".equals(cbModoAutomatico.getValue().toString()), piezasPedido, cantidadPiezas);
            //Mensaje
            lbMensaje.setText("El pedido se ha creado correctamente");
            irAGestionPedidos();
            
        } catch (ParseException ex) {
            lbMensaje.setText("Algo no ha ido bien... :(");
            Logger.getLogger(NuevoPedidoController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void anyadirPiezaAPedido() {
        data.add(new TablePieza(tfIdPieza.getText(), Integer.parseInt(tfCantidadPieza.getText())));
        tbPiezas.setItems(data);
    }
    public void irAGestionPedidos() throws IOException {
        URL location = getClass().getResource("GestionPedidos.fxml");
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(location);
        loader.setBuilderFactory(new JavaFXBuilderFactory());
        Parent page = (Parent) loader.load(location.openStream());
        stage.getScene().setRoot(page);
        GestionPedidosController tdCont = (GestionPedidosController) loader.getController();
        tdCont.setStage(stage);
        tdCont.showStage();
    }
    public  class TablePieza {
        SimpleStringProperty id;
        SimpleIntegerProperty cantidad;

        public TablePieza(String id, Integer cantidad) {
            this.id = new SimpleStringProperty(id);
            this.cantidad = new SimpleIntegerProperty(cantidad);
        }

        public String getId() {
            return id.get();
        }

        public Integer getCantidad() {
            return cantidad.get();
        }
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
            if(data.size()>=index){
            	removeIndex=index;
            }

           
            
        }
    }
    public void remove(){
    	 if(data.size()>=removeIndex){
         	data.remove(removeIndex);
         }
    }
}


