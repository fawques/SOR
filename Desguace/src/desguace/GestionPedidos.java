/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package desguace;

import Async.Accion;
import Async.AsyncManager;
import BD.InterfazBD;
import activemq.Gestor_activemq;
import interfaz.PiezasInterfaz;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import general.EstadoOferta;
import general.EstadoPedido;
import general.Oferta;
import general.Pedido;
import general.PedidoCorto;
import interfaz.TablaAcciones;
import interfaz.TablaOfertas;
import interfaz.TablaPedidos;

import java.io.IOException;
import java.lang.reflect.Type;
import java.net.ConnectException;
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
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.fxml.JavaFXBuilderFactory;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
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
    public TableView tableOfertasAceptadas;
    public TableView tablaHistoricoPedidos;
    public TableView  tablaHistoricoOfertas;
    public TableView tablePiezas;
    public TableView tableAcciones;
    @FXML
    public Label lbID;
    @FXML 
    public TextField tfPrecio;
    @FXML
    public Button btBuscarPedido;
    @FXML
    public TextField tfLimiteDia;
    @FXML
    public TextField tfLimiteMes;
    @FXML
    public TextField tfLimiteAnyo;
    @FXML
    public TableView<?> tvGrid;
    @FXML
    public TextField tfIDOferta;
    @FXML
    public TextField tfPVPmin;
    @FXML
    public ComboBox<?> cbEstadoOfertas;
    @FXML
    public Button btBuscarOfertas;
    @FXML
    public TextField tfPVPMax;
    @FXML
    public Button btNuevaOferta;
    @FXML
    public Button btAnularOferta;
    public int borrarOferta=-1;
    public int borrarOfertaAceptadas=-1;
    ObservableList<TablaPedidos> datatablePedidos = FXCollections.observableArrayList();
    ObservableList<TablaPedidos> datatableHistorico = FXCollections.observableArrayList();
    ObservableList<TablaOfertas> olTablaOfertas = FXCollections.observableArrayList();
    ObservableList<TablaOfertas> olTablaOfertasAceptadas = FXCollections.observableArrayList();
    ObservableList<TablaOfertas> datatableHistoricoOfertas = FXCollections.observableArrayList();
    ObservableList<PiezasInterfaz> personDataPiezas= FXCollections.observableArrayList();
    ObservableList<TablaAcciones> olTablaAcciones = FXCollections.observableArrayList();

    InterfazBD bd;
    public CheckBox cbCifradoAsim;
    public CheckBox cbCifradoSim;
  
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        tablaPedidos();
        tablaOfertasActivas();
        tablaHistoricoPedidos();
        tablaOfertasHistorico();
        piezasInterfaz();
        tablaAcciones();
    }    

    @FXML
    public void buscar(ActionEvent event) {
    }
        public void setStage(Stage stage) {
        thisStage = stage;
    }
    public void actualizarOfertasHistorico(){
        datatableHistoricoOfertas.clear();
        ArrayList<Oferta> ofertas= new ArrayList<Oferta>();
        CompararOfertasGestorDesguace();
        TablaOfertas tpOf;
        ofertas= DesguaceJava.getOfertasDesguace();
        for (Oferta of : ofertas) {
            tpOf = new TablaOfertas(of);
            datatableHistoricoOfertas.add(tpOf);
        }
        
    }
    public void piezasInterfaz(){
    personDataPiezas.clear();
    
     
     TableColumn cantCol = new TableColumn("Cantidad");
     cantCol.setCellValueFactory(new PropertyValueFactory<PiezasInterfaz, String>("cant"));      
     TableColumn nombreCol = new TableColumn("Nombre");
     nombreCol.setCellValueFactory(new PropertyValueFactory<TablaOfertas, Integer>("nombrePieza"));        
     tablePiezas.setItems(personDataPiezas);
     tablePiezas.getColumns().addAll(nombreCol,cantCol);
     
    }
    public void actualizarTablaAcciones(){
        AsyncManager async= new AsyncManager("sor_desguace");
         olTablaAcciones.clear();
         TablaAcciones tpAcciones;
         ArrayList<Accion> acciones = async.getAcciones();
         for (Accion accion : acciones) {
        	tpAcciones=new TablaAcciones(accion);
             olTablaAcciones.add(tpAcciones);
         }  
         tableAcciones.setEditable(true);
         tableAcciones.setItems(olTablaAcciones);    	
        }
    public void tablaAcciones(){
    	
    	 TableColumn accionCol = new TableColumn("Accion");
         accionCol.setCellValueFactory(new PropertyValueFactory<TablaAcciones, String>("id"));
         tableAcciones.getColumns().addAll(accionCol);
         actualizarTablaAcciones();
    }
    public void piezasclickPedido(String id){
        personDataPiezas.clear();
        Pedido p = null;
        Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ss").create();       
        Type collectionType = new TypeToken<Pedido>(){}.getType();
        String pedidosstring=DesguaceJava.getPedidoporID(id);
        if(!pedidosstring.equals("") && pedidosstring!=null){
         p = gson.fromJson(pedidosstring, collectionType);
        }
        
       
         PiezasInterfaz interfaz= new PiezasInterfaz();
         if(p!=null){
             for(int i=0;i<p.getListaPiezas().size();i++){
                interfaz= new PiezasInterfaz(p.getListaCantidadesPiezas().get(i),p.getListaPiezas().get(i).getNombre());
                personDataPiezas.add(interfaz);
                
             }
         }
          tablePiezas.setItems(personDataPiezas);

     
    
    }
    public void tablaOfertasHistorico(){
        actualizarOfertasHistorico();
        TableColumn id_auxCol = new TableColumn("Id_aux");
        id_auxCol.setCellValueFactory(new PropertyValueFactory<TablaOfertas, Integer>("id_aux"));        
        TableColumn idCol = new TableColumn("Id");
        idCol.setCellValueFactory(new PropertyValueFactory<TablaOfertas, String>("id"));      
        TableColumn fecha_altaCol = new TableColumn("Fecha alta");
        fecha_altaCol.setCellValueFactory(new PropertyValueFactory<TablaOfertas, String>("fecha_alta"));      
        TableColumn importeCol = new TableColumn("Importe");
        importeCol.setCellValueFactory(new PropertyValueFactory<TablaOfertas, String>("importe"));      
        TableColumn estadoCol = new TableColumn("Estado");
        estadoCol.setCellValueFactory(new PropertyValueFactory<TablaOfertas, String>("estado"));       
        TableColumn pedidoCol = new TableColumn("Pedido");
        pedidoCol.setCellValueFactory(new PropertyValueFactory<TablaOfertas, String>("pedido"));      
        TableColumn desguaceCol = new TableColumn("Desguace");
        desguaceCol.setCellValueFactory(new PropertyValueFactory<TablaOfertas, String>("desguace"));
        TableColumn desguaceNombreCol = new TableColumn("Desguace");
        desguaceNombreCol.setCellValueFactory(new PropertyValueFactory<TablaOfertas, String>("desguaceNombre"));      
        TableColumn fecha_bajaCol = new TableColumn("Fecha baja");
        fecha_bajaCol.setCellValueFactory(new PropertyValueFactory<TablaOfertas, String>("fecha_baja"));      
        TableColumn fecha_limiteCol = new TableColumn("Fecha limite");
        fecha_limiteCol.setCellValueFactory(new PropertyValueFactory<TablaOfertas, String>("fecha_limite"));
      

      
        tablaHistoricoOfertas.setEditable(true);
        tablaHistoricoOfertas.setItems(datatableHistoricoOfertas);
        tablaHistoricoOfertas.getColumns().addAll(id_auxCol, idCol, fecha_altaCol, importeCol, estadoCol, pedidoCol,desguaceNombreCol, desguaceCol, fecha_bajaCol, fecha_limiteCol);
     
            
     
    }    
    public void tablaOfertasActivas(){
     try {
            bd= new InterfazBD("sor_desguace");
              ArrayList<Oferta> ofertas= new ArrayList<Oferta>();
      
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
        TableColumn id_auxCol = new TableColumn("Id_aux");
        id_auxCol.setCellValueFactory(new PropertyValueFactory<TablaOfertas, Integer>("id_aux"));
        id_auxCol.setCellFactory(integerCellFactory);
        TableColumn idCol = new TableColumn("Id");
        idCol.setCellValueFactory(new PropertyValueFactory<TablaOfertas, String>("id"));
        idCol.setCellFactory(stringCellFactory);
        TableColumn fecha_altaCol = new TableColumn("Fecha alta");
        fecha_altaCol.setCellValueFactory(new PropertyValueFactory<TablaOfertas, String>("fecha_alta"));
        fecha_altaCol.setCellFactory(stringCellFactory);
        TableColumn importeCol = new TableColumn("Importe");
        importeCol.setCellValueFactory(new PropertyValueFactory<TablaOfertas, String>("importe"));
        importeCol.setCellFactory(stringCellFactory);
        TableColumn estadoCol = new TableColumn("Estado");
        estadoCol.setCellValueFactory(new PropertyValueFactory<TablaOfertas, String>("estado"));
        estadoCol.setCellFactory(stringCellFactory);
        TableColumn pedidoCol = new TableColumn("Pedido");
        pedidoCol.setCellValueFactory(new PropertyValueFactory<TablaOfertas, String>("pedido"));
        pedidoCol.setCellFactory(stringCellFactory);
        TableColumn desguaceCol = new TableColumn("Desguace");
        desguaceCol.setCellValueFactory(new PropertyValueFactory<TablaOfertas, String>("desguace"));
        desguaceCol.setCellFactory(stringCellFactory);
        TableColumn desguaceNombreCol = new TableColumn("DesguaceNombre");
        desguaceNombreCol.setCellValueFactory(new PropertyValueFactory<TablaOfertas, String>("desguaceNombre"));
        desguaceNombreCol.setCellFactory(stringCellFactory);
        TableColumn fecha_bajaCol = new TableColumn("Fecha baja");
        fecha_bajaCol.setCellValueFactory(new PropertyValueFactory<TablaOfertas, String>("fecha_baja"));
        fecha_bajaCol.setCellFactory(stringCellFactory);
        TableColumn fecha_limiteCol = new TableColumn("Fecha limite");
        fecha_limiteCol.setCellValueFactory(new PropertyValueFactory<TablaOfertas, String>("fecha_limite"));
        fecha_limiteCol.setCellFactory(stringCellFactory);

       CompararOfertasGestorDesguace();
        TablaOfertas tpOf;
        ofertas= DesguaceJava.actualizarOfertasAceptadas();
          for (Oferta of : ofertas) {
            tpOf = new TablaOfertas(of);
            olTablaOfertasAceptadas.add(tpOf);
        }
      
      
        tableOfertasAceptadas.setEditable(true);
        tableOfertasAceptadas.setItems(olTablaOfertasAceptadas);
        tableOfertasAceptadas.getColumns().addAll(id_auxCol, idCol, fecha_altaCol, importeCol, estadoCol, pedidoCol,desguaceNombreCol, desguaceCol, fecha_bajaCol, fecha_limiteCol);
        bd.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(GestionPedidos.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(GestionPedidos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void CompararOfertasGestorDesguace(){
        
    ArrayList<Oferta>  ofertas= DesguaceJava.actualizarOfertas();  
    ofertas.addAll(DesguaceJava.actualizarOfertasAceptadas());
    ArrayList<Oferta> ofertasgestor= new ArrayList<Oferta>();
    Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ss").create();
        Type collectionType = new TypeToken<ArrayList<Oferta>>(){}.getType();
        String ofertasstring= DesguaceJava.getOfertas();
        if(!ofertasstring.equals("") && ofertasstring!=null){
            ofertasgestor = gson.fromJson(ofertasstring, collectionType);
        }
       for(Oferta ofertagestor:ofertasgestor){
           for(Oferta ofertadesguace:ofertas){
               if(ofertagestor.getID_aux()==ofertadesguace.getID_aux()){
                    if(ofertagestor.getEstado()!=ofertadesguace.getEstado()){
                           DesguaceJava.cambiarEstadoOferta(ofertagestor.getID(),ofertagestor.getEstado());
                    }
                    if(!ofertagestor.getID().equals(ofertadesguace.getID())){
                    	bd.activarOfertaDesguace(ofertagestor.getID_aux(),ofertagestor.getID());
                    }
               }
           }
       }
    }
    public void anularOfertaAceptada(){
       Boolean aceptado=false;
        if(borrarOfertaAceptadas!=-1){
            if(olTablaOfertasAceptadas.size()>=borrarOfertaAceptadas){
               Boolean gestorlohacambiado= DesguaceJava.cancelarOferta(olTablaOfertasAceptadas.get(borrarOfertaAceptadas).getId());
                Boolean gestorpedido=DesguaceJava.cambiarEstadoPedido(olTablaOfertasAceptadas.get(borrarOfertaAceptadas).getPedido(), EstadoPedido.ACTIVE); 
               if(gestorlohacambiado && gestorpedido){
                    aceptado= DesguaceJava.cambiarEstadoOferta(olTablaOfertasAceptadas.get(borrarOfertaAceptadas).getId(),EstadoOferta.CANCELLED);
                    if(aceptado==false){
                        System.err.println("No se ha podido aceptar la oferta");
                    }
                  }
                  else{
                    System.err.println("No se ha podido cambiar la oferta en gestor a finalizado");
                  }
            }
        }
        actualizarOfertasOfertadas();
    }
        public void anularOfertaCreada(){
       Boolean aceptado=false;
        if(borrarOferta!=-1){
            if(olTablaOfertas.size()>=borrarOferta){
               Boolean gestorlohacambiado= DesguaceJava.cancelarOferta(olTablaOfertas.get(borrarOferta).getId());
                  if(gestorlohacambiado==true){
                    aceptado= DesguaceJava.cambiarEstadoOferta(olTablaOfertas.get(borrarOferta).getId(),EstadoOferta.CANCELLED);
                    if(aceptado==false){
                        System.err.println("No se ha podido aceptar la oferta");
                    }
                  }
                  else{
                    System.err.println("No se ha podido cambiar la oferta en gestor a finalizado");
                  }
            }
        }
        actualizarOfertas();
    }
    public void actualizarPestanyaHistorico(){
        actualizarHistoricoPedidos();
        actualizarOfertasHistorico();
    }
    public void actualizarHistoricoPedidos(){
        ArrayList<Pedido> listaPedidos= new ArrayList<Pedido>();
        datatableHistorico.clear();
         listaPedidos=DesguaceJava.getPedidos();
         TablaPedidos interfaz;
         for(Pedido pedido: listaPedidos){
             interfaz= new TablaPedidos(pedido);
             datatableHistorico.add(interfaz);
        }

    }
    public void tablaHistoricoPedidos(){
        
        actualizarHistoricoPedidos();
        TableColumn id_auxCol1 = new TableColumn("Id_aux");
        id_auxCol1.setCellValueFactory(new PropertyValueFactory<TablaPedidos, Integer>("id_aux")); 
        TableColumn idCol1 = new TableColumn("Id");
        idCol1.setCellValueFactory(new PropertyValueFactory<TablaPedidos, String>("id"));
         
        TableColumn fecha_altaCol1 = new TableColumn("Fecha alta");
        fecha_altaCol1.setCellValueFactory(new PropertyValueFactory<TablaPedidos, String>("fecha_alta"));
        
        TableColumn estadoCol1 = new TableColumn("Estado");
        estadoCol1.setCellValueFactory(new PropertyValueFactory<TablaPedidos, String>("estado"));
   
        TableColumn tallerCol = new TableColumn("Taller");
        tallerCol.setCellValueFactory(new PropertyValueFactory<TablaPedidos, String>("taller"));
       
        TableColumn tallerNombreCol = new TableColumn("TallerNombre");
        tallerNombreCol.setCellValueFactory(new PropertyValueFactory<TablaPedidos, String>("tallerNombre"));
       
        TableColumn fecha_bajaCol1 = new TableColumn("Fecha baja");
        fecha_bajaCol1.setCellValueFactory(new PropertyValueFactory<TablaPedidos, String>("fecha_baja"));
      
        TableColumn fecha_limiteCol1 = new TableColumn("Fecha limite");
        fecha_limiteCol1.setCellValueFactory(new PropertyValueFactory<TablaPedidos, String>("fecha_limite"));

        tablaHistoricoPedidos.setItems(datatableHistorico);
        tablaHistoricoPedidos.getColumns().addAll(id_auxCol1, idCol1, fecha_altaCol1, estadoCol1,tallerNombreCol, tallerCol, fecha_bajaCol1, fecha_limiteCol1);

        
    }
    public void tablaPedidos(){
        try {
            bd= new InterfazBD("sor_desguace");
            
        } catch (SQLException ex) {
            Logger.getLogger(GestionPedidos.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(GestionPedidos.class.getName()).log(Level.SEVERE, null, ex);
        }
          datatablePedidos.clear();
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
        Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ss").create();
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
        estadoCol1.setCellValueFactory(new PropertyValueFactory<TablaPedidos, String>("estado"));
         estadoCol1.setCellFactory(stringCellFactory);
        TableColumn tallerCol = new TableColumn("Taller");
        tallerCol.setCellValueFactory(new PropertyValueFactory<TablaPedidos, String>("taller"));
         tallerCol.setCellFactory(stringCellFactory);
         TableColumn tallerNombreCol = new TableColumn("TallerNombre");
         tallerNombreCol.setCellValueFactory(new PropertyValueFactory<TablaPedidos, String>("tallerNombre"));
         tallerNombreCol.setCellFactory(stringCellFactory);
        TableColumn fecha_bajaCol1 = new TableColumn("Fecha baja");
        fecha_bajaCol1.setCellValueFactory(new PropertyValueFactory<TablaPedidos, String>("fecha_baja"));
         fecha_bajaCol1.setCellFactory(stringCellFactory);
        TableColumn fecha_limiteCol1 = new TableColumn("Fecha limite");
        fecha_limiteCol1.setCellValueFactory(new PropertyValueFactory<TablaPedidos, String>("fecha_limite"));
         fecha_limiteCol1.setCellFactory(stringCellFactory);
        tablePedidos.getColumns().addAll(id_auxCol1, idCol1, fecha_altaCol1, estadoCol1,tallerNombreCol, tallerCol, fecha_bajaCol1, fecha_limiteCol1);

        
        
        TableColumn id_auxCol = new TableColumn("Id_aux");
        id_auxCol.setCellValueFactory(new PropertyValueFactory<TablaOfertas, Integer>("id_aux"));
        id_auxCol.setCellFactory(integerCellFactory);
        TableColumn idCol = new TableColumn("Id");
        idCol.setCellValueFactory(new PropertyValueFactory<TablaOfertas, String>("id"));
        idCol.setCellFactory(stringCellFactory);
        TableColumn fecha_altaCol = new TableColumn("Fecha alta");
        fecha_altaCol.setCellValueFactory(new PropertyValueFactory<TablaOfertas, String>("fecha_alta"));
        fecha_altaCol.setCellFactory(stringCellFactory);
        TableColumn importeCol = new TableColumn("Importe");
        importeCol.setCellValueFactory(new PropertyValueFactory<TablaOfertas, String>("importe"));
        importeCol.setCellFactory(stringCellFactory);
        TableColumn estadoCol = new TableColumn("Estado");
        estadoCol.setCellValueFactory(new PropertyValueFactory<TablaOfertas, String>("estado"));
        estadoCol.setCellFactory(stringCellFactory);
        TableColumn pedidoCol = new TableColumn("Pedido");
        pedidoCol.setCellValueFactory(new PropertyValueFactory<TablaOfertas, String>("pedido"));
        pedidoCol.setCellFactory(stringCellFactory);
        TableColumn desguaceCol = new TableColumn("Desguace");
        desguaceCol.setCellValueFactory(new PropertyValueFactory<TablaOfertas, String>("desguace"));
        desguaceCol.setCellFactory(stringCellFactory);
        TableColumn fecha_bajaCol = new TableColumn("Fecha baja");
        fecha_bajaCol.setCellValueFactory(new PropertyValueFactory<TablaOfertas, String>("fecha_baja"));
        fecha_bajaCol.setCellFactory(stringCellFactory);
        TableColumn fecha_limiteCol = new TableColumn("Fecha limite");
        fecha_limiteCol.setCellValueFactory(new PropertyValueFactory<TablaOfertas, String>("fecha_limite"));
        fecha_limiteCol.setCellFactory(stringCellFactory);

        ofertas = DesguaceJava.actualizarOfertas();
        TablaOfertas tpOf;
        for (Oferta of : ofertas) {
            tpOf = new TablaOfertas(of);
            olTablaOfertas.add(tpOf);
        }

        
        tableOfertas.setEditable(true);
        tableOfertas.setItems(olTablaOfertas);
        tableOfertas.getColumns().addAll(id_auxCol, idCol, fecha_altaCol, importeCol, estadoCol, pedidoCol, desguaceCol, fecha_bajaCol, fecha_limiteCol);
        bd.close();
        actualizarPedidos();
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
   public void actualizarPestanyaOfertas(){
	  CompararOfertasGestorDesguace();
      actualizarOfertas();
      actualizarOfertasOfertadas();
   }
     public void actualizarOfertasOfertadas() {
      
         ArrayList<Oferta> ofertas= new ArrayList<Oferta>();
        olTablaOfertasAceptadas.clear();
       ofertas = DesguaceJava.actualizarOfertasAceptadas();
        TablaOfertas tpOf;
        for (Oferta of : ofertas) {
            tpOf = new TablaOfertas(of);
            olTablaOfertasAceptadas.add(tpOf);
        }

        
        tableOfertasAceptadas.setItems(olTablaOfertasAceptadas);
    }
   public void actualizarOfertas() {
       CompararOfertasGestorDesguace();
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
           Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ss").create();
          ArrayList<Pedido> listaPedidos= new ArrayList<Pedido>();
        datatablePedidos.clear();
          Type collectionType = new TypeToken<ArrayList<String>>(){}.getType();
            Gestor_activemq activemq;
            String listaIdsString = null;

             ArrayList<String>  listaids = new ArrayList<String>();
        try {
            activemq = new Gestor_activemq();
            activemq.create_Consumer(DesguaceJava.desguace.getID());
            
            listaIdsString= activemq.consumer.consumeMessage();
            
           
            activemq.consumer.closeConsumer();
            String pedidosstring=null;
            ArrayList<PedidoCorto> idlista= new ArrayList<PedidoCorto>();
            ArrayList<String> idlistabuena= gson.fromJson(listaIdsString,collectionType);
            collectionType = new TypeToken<PedidoCorto>(){}.getType();
            PedidoCorto p=new PedidoCorto();
            for(String o: idlistabuena){
                p= gson.fromJson(o, collectionType);
                idlista.add(p);
            }
            idlistabuena.clear();
            collectionType = new TypeToken<Pedido>(){}.getType();
            if(listaIdsString!=null){
                for(PedidoCorto pcorto: idlista){
                    if(!DesguaceJava.cambiarEstadoPedido(pcorto.getID(), pcorto.getEstado())){
                    	Pedido pedido = gson.fromJson(DesguaceJava.getPedidoporID(pcorto.getID()), collectionType);
                    	bd.anadirPedido(pedido.getID(), pedido.getFecha_alta(), 1, pedido.getTaller(),pedido.getTallerNombre(), pedido.getFecha_baja(),pedido.getFecha_limite(), true);
                        bd.anyadirPiezasAPedido(bd.getPedido(pedido.getID()).getID_aux(), pedido.getListaPiezas(), pedido.getListaCantidadesPiezas());
                   
                    }

                    
                }
               
            }
          
        } catch (JMSException ex) {
            Logger.getLogger(GestionPedidos.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ConnectException ex) {
        	Logger.getLogger(GestionPedidos.class.getName()).log(Level.SEVERE, null, ex);
		}
        
        
        System.out.println("pasa por aqui");
        TablaPedidos interfaz= new TablaPedidos();
        for (Pedido pedido : bd.getPedidosConID_aux(EstadoPedido.ACTIVE)) {         
            interfaz= new TablaPedidos(pedido);
             datatablePedidos.add(interfaz);
             
        }
       
        tablePedidos.setItems(datatablePedidos);
      
        bd.close();
    }
     public void aceptarOferta(){
         Boolean aceptado=false;
        if(borrarOfertaAceptadas!=-1){
            if(olTablaOfertasAceptadas.size()>=borrarOfertaAceptadas){
               Boolean gestorlohacambiado= DesguaceJava.aceptarOfertaFin(olTablaOfertasAceptadas.get(borrarOfertaAceptadas).getId());
               Boolean gestorpedido=DesguaceJava.cambiarEstadoPedido(olTablaOfertasAceptadas.get(borrarOfertaAceptadas).getPedido(), EstadoPedido.FINISHED_OK);
               if(gestorlohacambiado && gestorpedido){
                    aceptado= DesguaceJava.cambiarEstadoOferta(olTablaOfertasAceptadas.get(borrarOfertaAceptadas).getId(),EstadoOferta.FINISHED_OK);
                    if(aceptado==false){
                        System.err.println("No se ha podido aceptar la oferta");
                    }
                  }
                  else{
                    System.err.println("No se ha podido cambiar la oferta en gestor a finalizado");
                  }
            }
        }
        actualizarOfertasOfertadas();
     }
      public void bajaDesguace() throws IOException {
        if (DesguaceJava.bajaDesguace()) {
            cambiarAPantallaDesguaceDeBaja();
        } else {
            System.err.println("Lo siento, no se ha podido dar de baja.");
        }
    }

    public void cambiarAPantallaDesguaceDeBaja() throws IOException {
        URL location = getClass().getResource("DesguaceDeBaja.fxml");
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(location);
        loader.setBuilderFactory(new JavaFXBuilderFactory());
        Parent page = (Parent) loader.load(location.openStream());
        thisStage.getScene().setRoot(page);
        DesguaceDeBajaController tdCont = (DesguaceDeBajaController) loader.getController();
        tdCont.setStage(thisStage);
        tdCont.showStage();
    }

   
    class MyIntegerTableCell extends TableCell<TablaPedidos, Integer> {
 
        @Override
        public void updateItem(Integer item, boolean empty) {
            super.updateItem(item, empty);
            setText(empty ? null : getString());
            setGraphic(null);
        }
 
        public String getString() {
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
 
        public String getString() {
            return getItem() == null ? "" : getItem().toString();
        }
    }
            
    class MyEventHandler implements EventHandler<MouseEvent> {

 
        @Override
        public void handle(MouseEvent t) {
            TableCell c = (TableCell) t.getSource();
            String tabla= c.getTableView().getId();
            int index = c.getIndex();
            if(tabla.equals("tablePedidos")){
                if(datatablePedidos.size()>=index){
                    lbID.setText(datatablePedidos.get(index).getId());
                    piezasclickPedido(datatablePedidos.get(index).getId());
                }
            }
            else if(tabla.equals("tableOfertasAceptadas")){
            if(olTablaOfertasAceptadas.size()>=index){
                    borrarOfertaAceptadas=index;
                }
            }
            else{
                if(olTablaOfertas.size()>=index){
                    borrarOferta=index;
                }
            }

           
            
        }
    }
    public void modificarDesguace() throws IOException {
        URL location = getClass().getResource("modificarDatos.fxml");
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(location);
        loader.setBuilderFactory(new JavaFXBuilderFactory());
        Parent page = (Parent) loader.load(location.openStream());
        thisStage.getScene().setRoot(page);
        AltaDesguace tdCont = (AltaDesguace) loader.getController();
        tdCont.setStage(thisStage);
        tdCont.showStage();
    }
 public void nuevoUsuario(){
    	DesguaceJava.anyadirRolUsuario("pepe", "12", "empleado");
    	DesguaceJava.anyadirRolUsuario("pio", "11", "Entrenador_pokemon");

    }
 
 public void toggleAsimetrico(){
		seguridad.Config.setCifradoAsimetrico(cbCifradoAsim.isSelected());
 }
 public void toggleSimetrico(){
		seguridad.Config.setCifradoSimetrico(cbCifradoSim.isSelected());
 }
            
}
