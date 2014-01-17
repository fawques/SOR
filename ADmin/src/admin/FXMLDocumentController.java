/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package admin;

import clasesInterfaz.OfertasInterfaz;
import clasesInterfaz.PedidosInterfaz;
import clasesInterfaz.PiezasInterfaz;
import clasesInterfaz.UsuarioInterface;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import general.Desguace;
import general.Oferta;
import general.Pedido;
import general.Taller;
import admin.Admin;
import com.google.gson.JsonSyntaxException;
import java.lang.reflect.Type;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.util.Callback;

/**
 *
 * @author Cute
 */

public class FXMLDocumentController implements Initializable {
   private ObservableList<UsuarioInterface> personData = FXCollections.observableArrayList();
   private ObservableList<UsuarioInterface> personDataDesguaces = FXCollections.observableArrayList();
   private ObservableList<PedidosInterfaz> personDataPedidos = FXCollections.observableArrayList();
   private ObservableList<OfertasInterfaz> personDataOferta = FXCollections.observableArrayList();
   private ObservableList<PiezasInterfaz> personDataPiezas = FXCollections.observableArrayList();
   private ObservableList<UsuarioInterface> altaTaller = FXCollections.observableArrayList();
   private ObservableList<UsuarioInterface> altaDesguaces = FXCollections.observableArrayList();
    @FXML
    private Label label;
    @FXML
    private Button button;
    @FXML
    private Button btnNew = new Button("New Record");
    @FXML private TableView tableTalleres;
    @FXML private TableView tableDesguaces;
    @FXML private TableView tablePedidos;
    @FXML private TableView tableOfertas;
    @FXML private TableView tablePiezas;
    @FXML private TableView tableAltaTalleres;
    @FXML private TableView tableAltaDesguaces;
    @FXML
    private void handleButtonAction(ActionEvent event) {
    
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        talleresInterfaz();
        desguacesInterfaz();
        ofertasInterfaz();
        pedidosInterfaz();
        altaTaller();
        AltaDesguaces();
    }

    public void actualizarPedidos(){
        personDataPedidos.clear();
    ArrayList<Pedido> listaPedidos= new ArrayList<Pedido>();
     Gson gson = new Gson();
      Type collectionType = new TypeToken<ArrayList<Pedido>>(){}.getType();
        String pedidosstring= Admin.getPedidos();
        if(!pedidosstring.equals("") && pedidosstring!=null){
            listaPedidos = gson.fromJson(pedidosstring, collectionType);
        }
        System.out.println("pasa por aqui");
        PedidosInterfaz interfaz= new PedidosInterfaz();
         for (Pedido pedido : listaPedidos) {
             interfaz= new PedidosInterfaz(pedido);
             personDataPedidos.add(interfaz);
             System.out.println(pedido);
        }
         if(personDataPedidos.size()!=0){
             piezasInterfaz(personDataPedidos.get(0).getID());
         }
         
           tablePedidos.setItems(personDataPedidos);
    }
    public void  pedidosInterfaz(){
     ArrayList<Pedido> listaPedidos= new ArrayList<Pedido>();
     Gson gson = new Gson();
     TableColumn columnID = new TableColumn("ID");
     TableColumn columnIDtaller = new TableColumn("idTaller");
     TableColumn columnAlta = new TableColumn("fecha_alta");
     TableColumn columnBaja = new TableColumn("fecha_baja");
     TableColumn columnLimite = new TableColumn("fecha_limite");
     tablePedidos.setEditable(true);
     
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
       columnID.setCellValueFactory(
           new PropertyValueFactory<UsuarioInterface,String>("ID")
               );
       columnID.setCellFactory(stringCellFactory);
       
       columnIDtaller.setCellValueFactory(
           new PropertyValueFactory<UsuarioInterface,String>("idTaller")
       );
       columnIDtaller.setCellFactory(stringCellFactory);
       columnAlta.setCellValueFactory(
           new PropertyValueFactory<UsuarioInterface,String>("fecha_alta")
       );
       columnAlta.setCellFactory(stringCellFactory);
       columnBaja.setCellValueFactory(
           new PropertyValueFactory<UsuarioInterface,String>("fecha_baja")
       );
       columnBaja.setCellFactory(stringCellFactory);
       columnLimite.setCellValueFactory(
           new PropertyValueFactory<UsuarioInterface,String>("fecha_limite")
       );
       columnLimite.setCellFactory(stringCellFactory);
        Type collectionType = new TypeToken<ArrayList<Pedido>>(){}.getType();
        String pedidosstring= Admin.getPedidos();
        if(!pedidosstring.equals("") && pedidosstring!=null){
            listaPedidos = gson.fromJson(pedidosstring, collectionType);
        }
        System.out.println("pasa por aqui");
        PedidosInterfaz interfaz= new PedidosInterfaz();
         for (Pedido pedido : listaPedidos) {
             interfaz= new PedidosInterfaz(pedido);
             personDataPedidos.add(interfaz);
             System.out.println(pedido);
        }
         if(personDataPedidos.size()!=0){
             piezasInterfaz(personDataPedidos.get(0).getID());
         }
         
           tablePedidos.setItems(personDataPedidos);
           tablePedidos.getColumns().addAll(columnID,columnIDtaller,columnAlta,columnBaja,columnLimite);

    }
    public void actualizarOfertas(){
     ArrayList<Oferta> listaOferta= new ArrayList<Oferta>();
     Gson gson = new Gson();
     personDataOferta.clear();
     Type collectionType = new TypeToken<ArrayList<Oferta>>(){}.getType();
      String ofertasstring= Admin.getOfertas();
      if(!ofertasstring.equals("") && ofertasstring!=null){
      listaOferta = gson.fromJson(ofertasstring, collectionType);
      }
        
        System.out.println("pasa por aqui");
        OfertasInterfaz interfaz= new OfertasInterfaz();
         for (Oferta oferta : listaOferta) {
             interfaz= new OfertasInterfaz(oferta);
             personDataOferta.add(interfaz);
             System.out.println(oferta);
        }
           tableOfertas.setItems(personDataOferta);
    }
    public void ofertasInterfaz(){
         
     ArrayList<Oferta> listaOferta= new ArrayList<Oferta>();
     Gson gson = new Gson();
     TableColumn columnID = new TableColumn("ID");
     TableColumn columnIDPedido = new TableColumn("idPedido");
     TableColumn columnIDDesguace = new TableColumn("idDesguace");
     TableColumn columnAlta = new TableColumn("fecha_alta");
     TableColumn columnBaja = new TableColumn("fecha_baja");
     TableColumn columnLimite = new TableColumn("fecha_limite");
     TableColumn columnPrecio= new TableColumn("precio");
     tableOfertas.setEditable(true);
       columnID.setCellValueFactory(
           new PropertyValueFactory<UsuarioInterface,String>("ID")
               );
    
       
       columnIDDesguace.setCellValueFactory(
           new PropertyValueFactory<UsuarioInterface,String>("idDesguace")
       );
       columnIDPedido.setCellValueFactory(
           new PropertyValueFactory<UsuarioInterface,String>("idPedido")
       );
       columnAlta.setCellValueFactory(
           new PropertyValueFactory<UsuarioInterface,String>("fecha_alta")
       );
 
       columnBaja.setCellValueFactory(
           new PropertyValueFactory<UsuarioInterface,String>("fecha_baja")
       );
       
       columnLimite.setCellValueFactory(
           new PropertyValueFactory<UsuarioInterface,String>("fecha_limite")
       );
      columnPrecio.setCellValueFactory(
           new PropertyValueFactory<UsuarioInterface,Double>("precio")
       );
      
      Type collectionType = new TypeToken<ArrayList<Oferta>>(){}.getType();
      String ofertasstring= Admin.getOfertas();
      if(!ofertasstring.equals("") && ofertasstring!=null){
      listaOferta = gson.fromJson(ofertasstring, collectionType);
      }
        
        System.out.println("pasa por aqui");
        OfertasInterfaz interfaz= new OfertasInterfaz();
         for (Oferta oferta : listaOferta) {
             interfaz= new OfertasInterfaz(oferta);
             personDataOferta.add(interfaz);
             System.out.println(oferta);
        }
           tableOfertas.setItems(personDataOferta);
           tableOfertas.getColumns().addAll(columnID,columnIDDesguace,columnIDPedido,columnAlta,columnBaja,columnLimite,columnPrecio);
     
     
    }
    public void ofertasclickPedido(String id){
    personDataOferta.clear();
     ArrayList<Oferta> listaOferta= new ArrayList<Oferta>();
     Gson gson = new Gson();
     Type collectionType = new TypeToken<ArrayList<Oferta>>(){}.getType();
     String ofertasstring=Admin.getOfertasporPedido(id);
     if(!ofertasstring.equals("") && ofertasstring!=null){
        listaOferta = gson.fromJson(ofertasstring, collectionType);
     }
        System.out.println("pasa por aqui");
        OfertasInterfaz interfaz= new OfertasInterfaz();
         for (Oferta oferta : listaOferta) {
             interfaz= new OfertasInterfaz(oferta);
             personDataOferta.add(interfaz);
             System.out.println(oferta);
        }
      
      
    }
    public void piezasInterfaz(String id ){
     ArrayList<Pedido> listaPedidos= new ArrayList<Pedido>();
        Gson gson = new Gson();
        TableColumn columnCant = new TableColumn("cant");
        TableColumn columnNombre = new TableColumn("nombrePieza");
        tablePiezas.setEditable(true);
        columnCant.setCellValueFactory(
           new PropertyValueFactory<UsuarioInterface,Integer>("cant")
        );
        columnNombre.setCellValueFactory(
           new PropertyValueFactory<UsuarioInterface,String>("nombrePieza")
        );
        Type collectionType = new TypeToken<ArrayList<Pedido>>(){}.getType();
        String pedidosstring= Admin.getPedidoID(id);
        if(!pedidosstring.equals("") && pedidosstring!=null){
            listaPedidos =gson.fromJson(pedidosstring, collectionType);
        }
        
       
         PiezasInterfaz interfaz= new PiezasInterfaz();
         for (Pedido p : listaPedidos) {
             for(int i=0;i<p.getListaPiezas().size();i++){
                interfaz= new PiezasInterfaz(p.getListaCantidadesPiezas().get(i),p.getListaPiezas().get(i).getNombre());
                personDataPiezas.add(interfaz);
                
             }
        }
          tablePiezas.setItems(personDataPiezas);
           tablePiezas.getColumns().addAll(columnNombre,columnCant);
     
    }
    public void piezasclickPedido(String id){
        personDataPiezas.clear();
        ArrayList<Pedido> listaPedidos= new ArrayList<Pedido>();
        Gson gson = new Gson();
       
        Type collectionType = new TypeToken<ArrayList<Pedido>>(){}.getType();
        String pedidosstring=Admin.getPedidoID(id);
        if(!pedidosstring.equals("") && pedidosstring!=null){
         listaPedidos = gson.fromJson(pedidosstring, collectionType);
        }
        
       
         PiezasInterfaz interfaz= new PiezasInterfaz();
         for (Pedido p : listaPedidos) {
             for(int i=0;i<p.getListaPiezas().size();i++){
                interfaz= new PiezasInterfaz(p.getListaCantidadesPiezas().get(i),p.getListaPiezas().get(i).getNombre());
                personDataPiezas.add(interfaz);
                
             }
        }
          tablePiezas.setItems(personDataPiezas);

     
    
    }
    public void actualizarPedidosPestaña(){
        actualizarPedidos();
        actualizarOfertas();
        
    }
    public void actualizarUsuariosPestaña(){
        actualizarDesguaces();
        actualizarTaller();
    }
    public void actualizarAltasPestaña(){
        actualizarAltasTaller();
        actualizarAltasDesguaces();
    }
    public void actualizarDesguaces(){
    personDataDesguaces.clear();
    Gson gson = new Gson();
    ArrayList<Desguace> listaDesguaces= new ArrayList<>();
        Type collectionType = new TypeToken<ArrayList<Desguace>>(){}.getType();
        String desguacestring=Admin.getDesguaces();
        if(!desguacestring.equals("") && desguacestring!=null){
            listaDesguaces = gson.fromJson(desguacestring, collectionType);
        }
        System.out.println("pasa por aqui");
        UsuarioInterface interfaz= new UsuarioInterface();
         for (Desguace desguace : listaDesguaces) {
             interfaz= new UsuarioInterface(desguace);
             personDataDesguaces.add(interfaz);
             System.out.println(desguace);
        }
           tableDesguaces.setItems(personDataDesguaces);
    }
    public void actualizarAltasDesguaces(){
    altaDesguaces.clear();
    Gson gson = new Gson();
    ArrayList<Desguace> listaDesguaces= new ArrayList<>();
       Type collectionType = new TypeToken<ArrayList<Desguace>>(){}.getType();
        String desguacestring=Admin.getAltaDesguace();
        if(!desguacestring.equals("") && desguacestring!=null){
            listaDesguaces = gson.fromJson(desguacestring, collectionType);
        }
        System.out.println("pasa por aqui");
        UsuarioInterface interfaz= new UsuarioInterface();
         for (Desguace desguace : listaDesguaces) {
             interfaz= new UsuarioInterface(desguace);
             altaDesguaces.add(interfaz);
             System.out.println(desguace);
        }
           tableAltaDesguaces.setItems(altaDesguaces);
    }
    
    public void desguacesInterfaz(){
     ArrayList<Desguace> listaDesguaces= new ArrayList<>();
     Gson gson = new Gson();
     TableColumn columnID = new TableColumn("ID");
     TableColumn columnNombre = new TableColumn("nombreTaller");
     TableColumn columnEmail = new TableColumn("email");
     TableColumn columnDireccion = new TableColumn("direccion");
     TableColumn columnCiudad = new TableColumn("ciudad");
     TableColumn columnCodigoPostal = new TableColumn("codigoPostal");
     TableColumn columnNumero = new TableColumn("numeroTelefono");
     tableDesguaces.setEditable(true);
     
           columnID.setCellValueFactory(
           new PropertyValueFactory<UsuarioInterface,String>("ID")
               );
           columnNombre.setCellValueFactory(
           new PropertyValueFactory<UsuarioInterface,String>("nombreTaller")
           );
           columnEmail.setCellValueFactory(
           new PropertyValueFactory<UsuarioInterface,String>("email")
           );
           columnCiudad.setCellValueFactory(
           new PropertyValueFactory<UsuarioInterface,String>("ciudad")
           );
           columnCodigoPostal.setCellValueFactory(
           new PropertyValueFactory<UsuarioInterface,Integer>("codigoPostal")
           );
           columnNumero.setCellValueFactory(
           new PropertyValueFactory<UsuarioInterface,Integer>("numeroTelefono")
           );
           columnDireccion.setCellValueFactory(
           new PropertyValueFactory<UsuarioInterface,String>("direccion")
           );
        Type collectionType = new TypeToken<ArrayList<Desguace>>(){}.getType();
        String desguacestring=Admin.getDesguaces();
        if(!desguacestring.equals("") && desguacestring!=null){
            listaDesguaces = gson.fromJson(desguacestring, collectionType);
        }
        System.out.println("pasa por aqui");
        UsuarioInterface interfaz= new UsuarioInterface();
         for (Desguace desguace : listaDesguaces) {
             interfaz= new UsuarioInterface(desguace);
             personDataDesguaces.add(interfaz);
             System.out.println(desguace);
        }
           tableDesguaces.setItems(personDataDesguaces);
           tableDesguaces.getColumns().addAll(columnID,columnNombre,columnEmail,columnDireccion,columnCiudad,columnCodigoPostal,columnNumero);
    }
    public void AltaDesguaces(){
     ArrayList<Desguace> listaDesguaces= new ArrayList<>();
     Gson gson = new Gson();
     TableColumn columnID = new TableColumn("ID");
     TableColumn columnNombre = new TableColumn("nombreTaller");
     TableColumn columnEmail = new TableColumn("email");
     TableColumn columnDireccion = new TableColumn("direccion");
     TableColumn columnCiudad = new TableColumn("ciudad");
     TableColumn columnCodigoPostal = new TableColumn("codigoPostal");
     TableColumn columnNumero = new TableColumn("numeroTelefono");
     tableAltaDesguaces.setEditable(true);
     btnNew.setOnAction(btnNewHandler);
           columnID.setCellValueFactory(
           new PropertyValueFactory<UsuarioInterface,String>("ID")
               );
           columnNombre.setCellValueFactory(
           new PropertyValueFactory<UsuarioInterface,String>("nombreTaller")
           );
           columnEmail.setCellValueFactory(
           new PropertyValueFactory<UsuarioInterface,String>("email")
           );
           columnCiudad.setCellValueFactory(
           new PropertyValueFactory<UsuarioInterface,String>("ciudad")
           );
           columnCodigoPostal.setCellValueFactory(
           new PropertyValueFactory<UsuarioInterface,Integer>("codigoPostal")
           );
           columnNumero.setCellValueFactory(
           new PropertyValueFactory<UsuarioInterface,Integer>("numeroTelefono")
           );
           columnDireccion.setCellValueFactory(
           new PropertyValueFactory<UsuarioInterface,String>("direccion")
           );
            TableColumn col_action = new TableColumn<>("Action");
        col_action.setSortable(false);
         
        col_action.setCellValueFactory(
                new Callback<TableColumn.CellDataFeatures<UsuarioInterface, Boolean>, 
                ObservableValue<Boolean>>() {
 
            @Override
            public ObservableValue<Boolean> call(TableColumn.CellDataFeatures<UsuarioInterface, Boolean> p) {
                return new SimpleBooleanProperty(p.getValue() != null);
            }
        });
 
        col_action.setCellFactory(
                new Callback<TableColumn<UsuarioInterface, Boolean>, TableCell<UsuarioInterface, Boolean>>() {
 
            @Override
            public TableCell<UsuarioInterface, Boolean> call(TableColumn<UsuarioInterface, Boolean> p) {
                return new ButtonCell();
            }
         
        });
        Type collectionType = new TypeToken<ArrayList<Desguace>>(){}.getType();
        String desguacestring=Admin.getAltaDesguace();
        if(!desguacestring.equals("") && desguacestring!=null){
            listaDesguaces = gson.fromJson(desguacestring, collectionType);
        }
        System.out.println("pasa por aqui");
        UsuarioInterface interfaz= new UsuarioInterface();
         for (Desguace desguace : listaDesguaces) {
             interfaz= new UsuarioInterface(desguace);
             altaDesguaces.add(interfaz);
             System.out.println(desguace);
        }
           tableAltaDesguaces.setItems(altaDesguaces);
           tableAltaDesguaces.getColumns().addAll(columnID,columnNombre,columnEmail,columnDireccion,columnCiudad,columnCodigoPostal,columnNumero,col_action);
    }
     private class ButtonCell extends TableCell<UsuarioInterface, Boolean> {
        final Button cellButton = new Button("Estado");
         
        ButtonCell(){
             
            cellButton.setOnAction(new EventHandler<ActionEvent>(){
 
                @Override
                public void handle(ActionEvent t) {
                    // do something when button clicked
                    int selectdIndex = getTableRow().getIndex();
                    String table= getTableView().getId();
                    if(table.equals("tableTalleres")){
                        if(altaTaller.size()>=selectdIndex){
                            String id=altaTaller.get(selectdIndex).getID();
                            if(id!=null){
                                Admin.darAccesoTaller(altaTaller.get(selectdIndex).getID());
                            }
                        
                        actualizarAltasTaller();
                    }
                    }
                    else{
                    if(altaDesguaces.size()>=selectdIndex){
                        Admin.addAccesoDesguace(altaDesguaces.get(selectdIndex).getID());
                        actualizarAltasDesguaces();
                    }
                    }
                    
                    //Cambiar a aceptado.
                }
            });
        }
 
        //Display button if the row is not empty
        @Override
        protected void updateItem(Boolean t, boolean empty) {
            super.updateItem(t, empty);
            if(!empty){
                setGraphic(cellButton);
            }
        }
    }
     
    EventHandler<ActionEvent> btnNewHandler = 
            new EventHandler<ActionEvent>(){
 
        @Override
        public void handle(ActionEvent t) {
   
             
        }
    };
    
        public void actualizarAltasTaller(){
    altaTaller.clear();
        ArrayList<Taller> listaTalleres= new ArrayList<>();
        Gson gson = new Gson();
        Type collectionType = new TypeToken<ArrayList<Taller>>(){}.getType();
        String tallerstring=Admin.getAltaTalleres();
        if( !tallerstring.equals("") && tallerstring!=null ){
            listaTalleres = gson.fromJson(tallerstring, collectionType);
        }
        System.out.println("pasa por aqui");
         UsuarioInterface interfaz= new UsuarioInterface();
         for (Taller taller : listaTalleres) {
             interfaz= new UsuarioInterface(taller);
             altaTaller.add(interfaz);
             System.out.println(taller);
        }
           
          
           tableAltaTalleres.setItems(altaTaller);
    }
public void actualizarTaller(){
    personData.clear();
        ArrayList<Taller> listaTalleres= new ArrayList<>();
        Gson gson = new Gson();
        Type collectionType = new TypeToken<ArrayList<Taller>>(){}.getType();
        String tallerstring=Admin.getTalleres();
        if( !tallerstring.equals("") && tallerstring!=null ){
            listaTalleres = gson.fromJson(tallerstring, collectionType);
        }
        System.out.println("pasa por aqui");
         UsuarioInterface interfaz= new UsuarioInterface();
         for (Taller taller : listaTalleres) {
             interfaz= new UsuarioInterface(taller);
             personData.add(interfaz);
             System.out.println(taller);
        }
           
          
           tableTalleres.setItems(personData);
    }
    public void altaTaller(){
        
        ArrayList<Taller> listaTalleres= new ArrayList<>();
        Gson gson = new Gson();
         TableColumn columnID = new TableColumn("ID");
         TableColumn columnNombre = new TableColumn("nombreTaller");
          TableColumn columnEmail = new TableColumn("email");
          TableColumn columnDireccion = new TableColumn("direccion");
          TableColumn columnCiudad = new TableColumn("ciudad");
           TableColumn columnCodigoPostal = new TableColumn("codigoPostal");
          TableColumn columnNumero = new TableColumn("numeroTelefono");          
           tableAltaTalleres.setEditable(true);
        System.out.println("Initialize!");
          columnID.setCellValueFactory(
           new PropertyValueFactory<UsuarioInterface,String>("ID")
               );
           columnNombre.setCellValueFactory(
           new PropertyValueFactory<UsuarioInterface,String>("nombreTaller")
           );
           columnEmail.setCellValueFactory(
           new PropertyValueFactory<UsuarioInterface,String>("email")
           );
           columnCiudad.setCellValueFactory(
           new PropertyValueFactory<UsuarioInterface,String>("ciudad")
           );
           columnCodigoPostal.setCellValueFactory(
           new PropertyValueFactory<UsuarioInterface,Integer>("codigoPostal")
           );
           columnNumero.setCellValueFactory(
           new PropertyValueFactory<UsuarioInterface,Integer>("numeroTelefono")
           );
           columnDireccion.setCellValueFactory(
           new PropertyValueFactory<UsuarioInterface,String>("direccion")
           );
                     TableColumn col_action = new TableColumn<>("Action");
        col_action.setSortable(false);
         
        col_action.setCellValueFactory(
                new Callback<TableColumn.CellDataFeatures<UsuarioInterface, Boolean>, 
                ObservableValue<Boolean>>() {
 
            @Override
            public ObservableValue<Boolean> call(TableColumn.CellDataFeatures<UsuarioInterface, Boolean> p) {
                return new SimpleBooleanProperty(p.getValue() != null);
            }
        });
 
        col_action.setCellFactory(
                new Callback<TableColumn<UsuarioInterface, Boolean>, TableCell<UsuarioInterface, Boolean>>() {
 
            @Override
            public TableCell<UsuarioInterface, Boolean> call(TableColumn<UsuarioInterface, Boolean> p) {
                return new ButtonCell();
            }
         
        });
           
        
        Type collectionType = new TypeToken<ArrayList<Taller>>(){}.getType();
        String tallerstring=Admin.getAltaTalleres();
        if( !tallerstring.equals("") && tallerstring!=null ){
            listaTalleres = gson.fromJson(tallerstring, collectionType);
        }
        System.out.println("pasa por aqui");
         UsuarioInterface interfaz= new UsuarioInterface();
         for (Taller taller : listaTalleres) {
             interfaz= new UsuarioInterface(taller);
             altaTaller.add(interfaz);
             System.out.println(taller);
        }
           
          
           tableAltaTalleres.setItems(altaTaller);
           tableAltaTalleres.getColumns().addAll(columnID,columnNombre,columnEmail,columnDireccion,columnCiudad,columnCodigoPostal,columnNumero,col_action);
     
          
    }
    public void talleresInterfaz(){
        ArrayList<Taller> listaTalleres= new ArrayList<>();
        Gson gson = new Gson();
         TableColumn columnID = new TableColumn("ID");
         TableColumn columnNombre = new TableColumn("nombreTaller");
          TableColumn columnEmail = new TableColumn("email");
          TableColumn columnDireccion = new TableColumn("direccion");
          TableColumn columnCiudad = new TableColumn("ciudad");
           TableColumn columnCodigoPostal = new TableColumn("codigoPostal");
          TableColumn columnNumero = new TableColumn("numeroTelefono");          
           tableTalleres.setEditable(true);
        System.out.println("Initialize!");
          columnID.setCellValueFactory(
           new PropertyValueFactory<UsuarioInterface,String>("ID")
               );
           columnNombre.setCellValueFactory(
           new PropertyValueFactory<UsuarioInterface,String>("nombreTaller")
           );
           columnEmail.setCellValueFactory(
           new PropertyValueFactory<UsuarioInterface,String>("email")
           );
           columnCiudad.setCellValueFactory(
           new PropertyValueFactory<UsuarioInterface,String>("ciudad")
           );
           columnCodigoPostal.setCellValueFactory(
           new PropertyValueFactory<UsuarioInterface,Integer>("codigoPostal")
           );
           columnNumero.setCellValueFactory(
           new PropertyValueFactory<UsuarioInterface,Integer>("numeroTelefono")
           );
           columnDireccion.setCellValueFactory(
           new PropertyValueFactory<UsuarioInterface,String>("direccion")
           );
           
           
        
        Type collectionType = new TypeToken<ArrayList<Taller>>(){}.getType();
        String tallerstring=Admin.getTalleres();
        if( !tallerstring.equals("") && tallerstring!=null ){
            listaTalleres = gson.fromJson(tallerstring, collectionType);
        }
        System.out.println("pasa por aqui");
         UsuarioInterface interfaz= new UsuarioInterface();
         for (Taller taller : listaTalleres) {
             interfaz= new UsuarioInterface(taller);
             personData.add(interfaz);
             System.out.println(taller);
        }
           
          
           tableTalleres.setItems(personData);
           tableTalleres.getColumns().addAll(columnID,columnNombre,columnEmail,columnDireccion,columnCiudad,columnCodigoPostal,columnNumero);
     
    }
 
    class MyEventHandler implements EventHandler<MouseEvent> {

 
        @Override
        public void handle(MouseEvent t) {
            TableCell c = (TableCell) t.getSource();
            String tabla= c.getTableView().getId();
            int index = c.getIndex();
        if(personDataPedidos.size()>=index){
           ofertasclickPedido( personDataPedidos.get(index).getID());
           piezasclickPedido(personDataPedidos.get(index).getID());
        }
           

           
            
        }
    }
    
    class MyIntegerTableCell extends TableCell<PedidosInterfaz, Integer> {
 
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
 
    class MyStringTableCell extends TableCell<PedidosInterfaz, String> {
 
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
}
