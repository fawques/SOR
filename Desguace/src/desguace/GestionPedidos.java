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
import general.PedidoCorto;
import interfaz.TablaOfertas;
import interfaz.TablaPedidos;
import java.io.IOException;
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
    private int borrarOferta=-1;
    private int borrarOfertaAceptadas=-1;
    ObservableList<TablaPedidos> datatablePedidos = FXCollections.observableArrayList();
    ObservableList<TablaPedidos> datatableHistorico = FXCollections.observableArrayList();
    ObservableList<TablaOfertas> olTablaOfertas = FXCollections.observableArrayList();
    ObservableList<TablaOfertas> olTablaOfertasAceptadas = FXCollections.observableArrayList();
    ObservableList<TablaOfertas> datatableHistoricoOfertas = FXCollections.observableArrayList();
    InterfazBD bd;
  
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        tablaPedidos();
        tablaOfertasActivas();
        tablaHistoricoPedidos();
        tablaOfertasHistorico();
    }    

    @FXML
    private void buscar(ActionEvent event) {
    }
        public void setStage(Stage stage) {
        thisStage = stage;
    }
    private void actualizarOfertasHistorico(){
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
    private void tablaOfertasHistorico(){
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
        TableColumn fecha_bajaCol = new TableColumn("Fecha baja");
        fecha_bajaCol.setCellValueFactory(new PropertyValueFactory<TablaOfertas, String>("fecha_baja"));      
        TableColumn fecha_limiteCol = new TableColumn("Fecha limite");
        fecha_limiteCol.setCellValueFactory(new PropertyValueFactory<TablaOfertas, String>("fecha_limite"));
      

      
        tablaHistoricoOfertas.setEditable(true);
        tablaHistoricoOfertas.setItems(datatableHistoricoOfertas);
        tablaHistoricoOfertas.getColumns().addAll(id_auxCol, idCol, fecha_altaCol, importeCol, estadoCol, pedidoCol, desguaceCol, fecha_bajaCol, fecha_limiteCol);
     
            
     
    }    
    private void tablaOfertasActivas(){
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
        tableOfertasAceptadas.getColumns().addAll(id_auxCol, idCol, fecha_altaCol, importeCol, estadoCol, pedidoCol, desguaceCol, fecha_bajaCol, fecha_limiteCol);
        bd.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(GestionPedidos.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(GestionPedidos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void CompararOfertasGestorDesguace(){
        
    ArrayList<Oferta>  ofertas= DesguaceJava.actualizarOfertas();   
    ArrayList<Oferta> ofertasgestor= new ArrayList<Oferta>();
      Gson gson = new Gson();
        Type collectionType = new TypeToken<ArrayList<Oferta>>(){}.getType();
        String ofertasstring= DesguaceJava.getOfertas();
        if(!ofertasstring.equals("") && ofertasstring!=null){
            ofertasgestor = gson.fromJson(ofertasstring, collectionType);
        }
       for(Oferta ofertagestor:ofertasgestor){
           for(Oferta ofertadesguace:ofertas){
               if(ofertagestor.getID().equals(ofertadesguace.getID())){
                    if(ofertagestor.getEstado()!=ofertadesguace.getEstado()){
                           DesguaceJava.cambiarEstadoOferta(ofertagestor.getID(),ofertagestor.getEstado());
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
    private void actualizarHistoricoPedidos(){
        ArrayList<Pedido> listaPedidos= new ArrayList<Pedido>();
        datatableHistorico.clear();
         listaPedidos=DesguaceJava.getPedidos();
         TablaPedidos interfaz;
         for(Pedido pedido: listaPedidos){
             interfaz= new TablaPedidos(pedido);
             datatableHistorico.add(interfaz);
        }

    }
    private void tablaHistoricoPedidos(){
        
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
       
        TableColumn fecha_bajaCol1 = new TableColumn("Fecha baja");
        fecha_bajaCol1.setCellValueFactory(new PropertyValueFactory<TablaPedidos, String>("fecha_baja"));
      
        TableColumn fecha_limiteCol1 = new TableColumn("Fecha limite");
        fecha_limiteCol1.setCellValueFactory(new PropertyValueFactory<TablaPedidos, String>("fecha_limite"));

        tablaHistoricoPedidos.setItems(datatableHistorico);
        tablaHistoricoPedidos.getColumns().addAll(id_auxCol1, idCol1, fecha_altaCol1, estadoCol1, tallerCol, fecha_bajaCol1, fecha_limiteCol1);

        
    }
    private void tablaPedidos(){
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
        estadoCol1.setCellValueFactory(new PropertyValueFactory<TablaPedidos, String>("estado"));
         estadoCol1.setCellFactory(stringCellFactory);
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
        ArrayList<String> stringid= new ArrayList<String>();
        ArrayList<String> stringbueno= new ArrayList<String>();
        
        
        if(listaIdsString!=null){
            stringid= gson.fromJson(listaIdsString, collectionType);
            collectionType = new TypeToken<ArrayList<PedidoCorto>>(){}.getType();
            PedidoCorto p=null; 
            for(String s: stringid){
                p=gson.fromJson(s, collectionType);
                if(!DesguaceJava.cambiarEstadoPedido(p.getID(), p.getEstado())){
                    stringbueno.add(p.getID());
                }
                
            }
            Gson gsonn = new GsonBuilder().setDateFormat("MMM dd, yyyy hh:mm:ss a").create();
            String listaJSON = gsonn.toJson(stringbueno);
            pedidosstring= DesguaceJava.getPedidosporID(listaJSON);
        }
        if(!pedidosstring.equals("") && pedidosstring!=null){
             collectionType = new TypeToken<ArrayList<Pedido>>(){}.getType();
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
      actualizarOfertas();
      actualizarOfertasOfertadas();
   }
     public void actualizarOfertasOfertadas() {
      CompararOfertasGestorDesguace();
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
          Gson gson = new GsonBuilder().setDateFormat("MMM dd, yyyy").create();
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
        } catch (JMSException ex) {
            Logger.getLogger(GestionPedidos.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        if(listaIdsString!=null){
            for(PedidoCorto pcorto: idlista){
                if(!DesguaceJava.cambiarEstadoPedido(pcorto.getID(), pcorto.getEstado())){
                    idlistabuena.add(pcorto.getID());
                }
            }
             Gson gsonnuevo = new GsonBuilder().setDateFormat("MMM dd, yyyy hh:mm:ss a").create();
            String listaJSON = gsonnuevo.toJson(idlistabuena);
             pedidosstring= DesguaceJava.getPedidosporID(listaJSON);
        }
        collectionType = new TypeToken<ArrayList<Pedido>>(){}.getType();
        if(pedidosstring!=null && !pedidosstring.equals("")){
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

    private void cambiarAPantallaDesguaceDeBaja() throws IOException {
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
            if(tabla.equals("tablePedidos")){
                if(datatablePedidos.size()>=index){
                    lbID.setText(datatablePedidos.get(index).getId());
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
            
}
