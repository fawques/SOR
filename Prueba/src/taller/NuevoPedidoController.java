/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package taller;

import general.EstadoPedido;
import general.Pieza;
import gestor_taller.JMSException_Exception;

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
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import taller.NuevoPedidoController.TablePieza;

/**
 * FXML Controller class
 *
 * @author manu
 */
public class NuevoPedidoController implements Initializable {

    Stage stage;
    ObservableList data = FXCollections.observableArrayList();
    @FXML
    public Button btAnadirPieza;
    public Button lbRealizar;
    public TableView tbPiezas;
    public ComboBox cbModoAutomatico;
    public TextField tfLimiteDia;
    public TextField tfLimiteMes;
    public TextField tfLimiteAnyo;
    public TextField tfIdPieza;
    public TextField tfCantidadPieza;
    public Label lbMensaje;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        TableColumn idCol = new TableColumn("Id");
        idCol.setCellValueFactory(new PropertyValueFactory<TablePieza, String>("id"));

        TableColumn cantidadCol = new TableColumn("Cantidad");
        cantidadCol.setCellValueFactory(
                new PropertyValueFactory<TablePieza, Integer>("cantidad")
        );
        tbPiezas.setEditable(true);
        tbPiezas.getColumns().addAll(idCol, cantidadCol);
    }

    public void setStage(Stage s) {
        stage = s;
    }
    public void showStage() {
        stage.show();
    }

    public void realizarPedido() throws JMSException_Exception {
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

            MainTaller.crearPedido(today, EstadoPedido.ACTIVE, fechaLimite, "Automatico".equals(cbModoAutomatico.getValue().toString()), piezasPedido, cantidadPiezas);
            //Mensaje
            lbMensaje.setText("El pedido se ha creado correctamente");
            lbRealizar.setDisable(true);
        } catch (ParseException ex) {
            lbMensaje.setText("Algo no ha ido bien... :(");
            Logger.getLogger(NuevoPedidoController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void anyadirPiezaAPedido() {
        data.add(new TablePieza(tfIdPieza.getText(), Integer.parseInt(tfCantidadPieza.getText())));
        tbPiezas.setItems(data);
    }

    public static class TablePieza {
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
}
