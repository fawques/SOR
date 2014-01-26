/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package desguace;

import BD.InterfazBD;
import com.google.gson.Gson;
import general.Desguace;
import general.EstadoGeneral;
import general.EstadoOferta;
import general.EstadoPedido;
import general.Oferta;
import general.Pedido;
import jUDDI.JUDDIProxy;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.fxml.JavaFXBuilderFactory;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author manu
 */
public class DesguaceJava extends Application {
    public Stage stage;
    static InterfazBD bd;
    public static Desguace desguace;
    @Override
    public void start(Stage stage2) throws IOException, SQLException{
        try {
            JUDDIProxy.loadWsdl("DesguaceJavaWS");
            stage = stage2;
            bd = new InterfazBD("sor_desguace");
            //System.out.println(bd.getPedidosActivos());
            desguace = bd.getDesguace();
            //bd.close();
            if (desguace != null) //pendiente de activacion
            {
                if (desguace.getEstado() == EstadoGeneral.PENDIENTE) //pendiente de activacion
                {
                    FXMLLoader loader = changeScene("desguacePendienteActivacion.fxml");
                    stage.setTitle("Esperando codigo de aceptacion");
                    DesguacerPendienteActivacionController staticDataBox = (DesguacerPendienteActivacionController) loader.getController();
                    staticDataBox.setStage(stage);
                    staticDataBox.showStage();
                } else if (desguace.getEstado() == EstadoGeneral.ACTIVE) { //activo
                    //Cargar GestionPedido
                    FXMLLoader loader = changeScene("GestionPedidos.fxml");
                    stage.setTitle("Gestion de pedidos");
                    GestionPedidos staticDataBox = (GestionPedidos) loader.getController();
                    staticDataBox.setStage(stage);
                    staticDataBox.showStage();
                    
                }
                else if(desguace.getEstado() == EstadoGeneral.INACTIVE){
                    FXMLLoader loader = changeScene("DesguaceDeBaja.fxml");
                    stage.setTitle("Gestion de pedidos");
                    DesguaceDeBajaController staticDataBox = (DesguaceDeBajaController) loader.getController();
                    staticDataBox.setStage(stage);
                    staticDataBox.showStage();
                
                }
                else { //un botÃ³n y prou
                    //Yo lo que haria serÃ­a un volver a darme de alta, con los mismos datos
                    //un botÃ³n y prou
                    FXMLLoader loader = changeScene("AltaTaller.fxml");
                    stage.setTitle("Alta de taller");
                    AltaDesguace staticDataBox = (AltaDesguace) loader.getController();
                    staticDataBox.setStage(stage);
                    staticDataBox.showStage();
                }
            } else { //no existe
                FXMLLoader loader = changeScene("AltaDesguace.fxml");
                stage.setTitle("Alta de desguace");
                AltaDesguace staticDataBox = (AltaDesguace) loader.getController();
                staticDataBox.setStage(stage);
                staticDataBox.showStage();
            }
            bd.close();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DesguaceJava.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * The main() method is ignored in correctly deployed JavaFX application.
     * main() serves only as fallback in case the application can not be
     * launched through deployment artifacts, e.g., in IDEs with limited FX
     * support. NetBeans ignores main().
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
        public FXMLLoader changeScene(String fxml) throws IOException {
        //Mostrar pÃ¡gina de espera interfaz bÃ¡sica
        URL location = getClass().getResource(fxml);
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(location);
        loader.setBuilderFactory(new JavaFXBuilderFactory());
        Parent page = (Parent) loader.load(location.openStream());
        if (stage.getScene() == null) {
            Scene scene = new Scene(page);
            stage.setScene(scene);
        } else {
            stage.getScene().setRoot(page);
            stage.sizeToScene();
        }

        return loader;

    }
            public Parent replaceSceneContent(String fxml) throws Exception {
        Parent page = (Parent) FXMLLoader.load(DesguaceJava.class.getResource(fxml), null, new JavaFXBuilderFactory());
        Scene scene = stage.getScene();
        if (scene == null) {
            stage.setScene(scene);
        } else {
            stage.getScene().setRoot(page);
        }
        stage.sizeToScene();
        return page;
    }
    
    public static boolean activarDesguacesBD(String idRecibido) {
        try {
            bd = new InterfazBD("sor_desguace");
            boolean r = bd.activarDesguaceMainDesguace(idRecibido);
            bd.close();
            return r;
            
        } catch (SQLException ex) {
            Logger.getLogger(DesguaceJava.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DesguaceJava.class.getName()).log(Level.SEVERE, null, ex);
        }

        return false;
    }
         /**
     * ******************** Validaciones **************************
     */
    /**
     *
     * @param n
     * @return
     */
    public static boolean validarNombre(String n) {
        
        Pattern p = Pattern.compile("^[a-zA-Z][a-zA-Z ]{0,21}");
        Matcher m = p.matcher(n);
        if (!m.matches()) {
            return false;
        }

        return true;
    }

    public static boolean validarFecha(String dia, String mes, String anyo) {
        Pattern p = Pattern.compile("^((((((0[13578])|(1[02]))[\\s\\.\\-\\/\\\\]?((0[1-9])|([12][0-9])|(3[01])))|(((0[469])|(11))[\\s\\.\\-\\/\\\\]?((0[1-9])|([12][0-9])|(30)))|((02)[\\s\\.\\-\\/\\\\]?((0[1-9])|(1[0-9])|(2[0-8]))))[\\s\\.\\-\\/\\\\]?(((([2468][^048])|([13579][^26]))00)|(\\d\\d\\d[13579])|(\\d\\d[02468][^048])|(\\d\\d[13579][^26])))|(((((0[13578])|(1[02]))[\\s\\.\\-\\/\\\\]?((0[1-9])|([12][0-9])|(3[01])))|(((0[469])|(11))[\\s\\.\\-\\/\\\\]?((0[1-9])|([12][0-9])|(30)))|((02)[\\s\\.\\-\\/\\\\]?((0[1-9])|([12][0-9]))))[\\s\\.\\-\\/\\\\]?(((([2468][048])|([13579][26]))00)|(\\d\\d[2468][048])|(\\d\\d[13579][26])|(\\d\\d0[48]))))$");
        Matcher m = p.matcher(mes + dia + anyo);
        if (!m.matches()) {
            return false;
        }

        return true;
    }

    /**
     *
     * @param dir
     * @return
     */
    public static boolean validarDireccion(String dir) {
        return dir.length() < 22;
    }

    /**
     *
     * @param num
     * @return
     */
    public static boolean validarSoloNumeros(String num) {
        //Verificar que no se pase de 9 digitos!
        Pattern p = Pattern.compile("^[0-9]{0,8}[0-9]");
        Matcher m = p.matcher(num);
        if (!m.matches()) {
            return false;
        }
        return true;
    }

    /**
     *
     * @param n
     * @return
     */
    public static boolean validarEmail(String n) {
        Pattern p = Pattern.compile("^(([a-zA-Z0-9_\\-\\.]+)@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.)|(([a-zA-Z0-9\\-]+\\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\\]?))$");
        Matcher m = p.matcher(n);
        if (!m.matches()) {
            return false;
        }
        return true;
    }
    public static void crearOferta(Date fechaAlta,Date fechaLimite,String idPedido,double precio) {
        try {           
            bd = new InterfazBD("sor_desguace");
            String desguaceID = bd.getDesguace().getID();            
            int id = bd.anadirOferta(fechaAlta,0,precio,idPedido, desguaceID,null,fechaLimite);
            Oferta nuevo = new Oferta("", id, precio, desguaceID, idPedido,fechaAlta, null, fechaLimite, EstadoOferta.NEW);
            Gson gson = new Gson();
            String idFinal = nuevaOferta(gson.toJson(nuevo));
            bd.activarOfertaDesguace(id, idFinal);
            bd.close();
        } catch (SQLException ex) {
            Logger.getLogger(DesguaceJava.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DesguaceJava.class.getName()).log(Level.SEVERE, null, ex);
        }


        
    }
   public static ArrayList<Oferta> actualizarOfertasAceptadas(){
   ArrayList<Oferta> of = new ArrayList<Oferta>();
        try {
            bd = new InterfazBD("sor_desguace");
            of = bd.getOfertasConID_aux(EstadoOferta.ACCEPTED);
            bd.close();
             return of;
        } catch (SQLException ex) {
            Logger.getLogger(DesguaceJava.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DesguaceJava.class.getName()).log(Level.SEVERE, null, ex);
        }
        return of;
   }
 public static ArrayList<Oferta> getOfertasDesguace() {
       ArrayList<Oferta> of = new ArrayList<Oferta>();
        try {
            bd = new InterfazBD("sor_desguace");
            of = bd.getOfertas();
            bd.close();
             return of;
        } catch (SQLException ex) {
            Logger.getLogger(DesguaceJava.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DesguaceJava.class.getName()).log(Level.SEVERE, null, ex);
        }
        return of;
    }
    public static ArrayList<Oferta> actualizarOfertas() {
       ArrayList<Oferta> of = new ArrayList<Oferta>();
        try {
            bd = new InterfazBD("sor_desguace");
            of = bd.getOfertasConID_aux(EstadoOferta.ACTIVE);
            bd.close();
             return of;
        } catch (SQLException ex) {
            Logger.getLogger(DesguaceJava.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DesguaceJava.class.getName()).log(Level.SEVERE, null, ex);
        }
        return of;
    }
    public static boolean cambiarEstadoOferta(String id,EstadoOferta estado){
    Boolean realizado=false;
        try {
            bd= new InterfazBD("sor_desguace");
            realizado= bd.cambiarEstadoOferta(estado, id);
            return realizado;
        } catch (SQLException ex) {
            Logger.getLogger(DesguaceJava.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DesguaceJava.class.getName()).log(Level.SEVERE, null, ex);
        }
        return realizado;
    }
        public static boolean cambiarEstadoPedido(String id,EstadoPedido estado){
    Boolean realizado=false;
        try {
            bd= new InterfazBD("sor_desguace");
            realizado= bd.cambiarEstadoPedido(estado, id);
            if(realizado){
                cambiarEstadoPedido_1(id,estado.ordinal());
            }
            bd.close();
            
            return realizado;
        } catch (SQLException ex) {
            Logger.getLogger(DesguaceJava.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DesguaceJava.class.getName()).log(Level.SEVERE, null, ex);
        }
        return realizado;
    }
    public static ArrayList<Pedido> getPedidos(){
        ArrayList<Pedido> pedidoslista= new ArrayList<Pedido>();
        try {
            bd= new InterfazBD("sor_desguace");
            pedidoslista=bd.getPedidosActivos();
             bd.close();
            return pedidoslista;
           
        } catch (SQLException ex) {
            Logger.getLogger(DesguaceJava.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DesguaceJava.class.getName()).log(Level.SEVERE, null, ex);
        }
        return pedidoslista;
    }
    public static boolean reactivarDesguace() {
        try {     
            bd = new InterfazBD("sor_desguace");
            boolean r = bd.activarDesguace(desguace.getID());
            bd.close();
            return r;
        } catch (SQLException ex) {
            Logger.getLogger(DesguaceJava.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DesguaceJava.class.getName()).log(Level.SEVERE, null, ex);
        }
            
       

        return false;
    }
        public static boolean bajaDesguace() {
      try {
            if (baja(desguace.getID())) {
               
                    bd = new InterfazBD("sor_desguace");
              
                if (bd.bajaDesguace(desguace.getID())) {
                    bd.close();
                    return true;
                } else {
                    System.err.println("Error: No se ha podido cambiar el estado en taller.");
                }
            } else {
                System.err.println("Error: No se ha podido dar de baja en gestor.");
            }
        } catch (SQLException ex) {
           Logger.getLogger(DesguaceJava.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
           Logger.getLogger(DesguaceJava.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    /**
     *
     * @param nombreTaller
     * @param email
     * @param direccion
     * @param ciudad
     * @param cp
     * @param telefono
     * @return
     */
    public static boolean validar(String nombreTaller, String email, String direccion, String ciudad, String cp, String telefono) {
        return validarNombre(nombreTaller) && validarEmail(email) && validarNombre(ciudad) && validarSoloNumeros(cp) && validarSoloNumeros(telefono) && validarDireccion(direccion);
    }

    public static boolean alta(java.lang.String name, java.lang.String email, java.lang.String address, java.lang.String city, int postalCode, int telephone) {
        gestor_desguace_java.DesguaceJavaWS_Service service = new gestor_desguace_java.DesguaceJavaWS_Service(JUDDIProxy.getWsdl());
        gestor_desguace_java.DesguaceJavaWS port = service.getDesguaceJavaWSPort();
        return port.alta(name, email, address, city, postalCode, telephone);
    }

    public static String checkActivacion(java.lang.String mail) {
        gestor_desguace_java.DesguaceJavaWS_Service service = new gestor_desguace_java.DesguaceJavaWS_Service(JUDDIProxy.getWsdl());
        gestor_desguace_java.DesguaceJavaWS port = service.getDesguaceJavaWSPort();
        return port.checkActivacion(mail);
    }


    public static String nuevaOferta(java.lang.String oferta) {
        gestor_desguace_java.DesguaceJavaWS_Service service = new gestor_desguace_java.DesguaceJavaWS_Service(JUDDIProxy.getWsdl());
        gestor_desguace_java.DesguaceJavaWS port = service.getDesguaceJavaWSPort();
        return port.nuevaOferta(oferta);
    }

    public static String getOfertas() {
        gestor_desguace_java.DesguaceJavaWS_Service service = new gestor_desguace_java.DesguaceJavaWS_Service(JUDDIProxy.getWsdl());
        gestor_desguace_java.DesguaceJavaWS port = service.getDesguaceJavaWSPort();
        return port.getOfertas();
    }

    public static String getPedidosporID(java.lang.String string) {
        gestor_desguace_java.DesguaceJavaWS_Service service = new gestor_desguace_java.DesguaceJavaWS_Service(JUDDIProxy.getWsdl());
        gestor_desguace_java.DesguaceJavaWS port = service.getDesguaceJavaWSPort();
        return port.getPedidosporID(string);
    }

    public static Boolean aceptarOfertaFin(java.lang.String id) {
        gestor_desguace_java.DesguaceJavaWS_Service service = new gestor_desguace_java.DesguaceJavaWS_Service(JUDDIProxy.getWsdl());
        gestor_desguace_java.DesguaceJavaWS port = service.getDesguaceJavaWSPort();
        return port.aceptarOfertaFin(id);
    }

    public static Boolean cancelarOferta(java.lang.String id) {
        gestor_desguace_java.DesguaceJavaWS_Service service = new gestor_desguace_java.DesguaceJavaWS_Service(JUDDIProxy.getWsdl());
        gestor_desguace_java.DesguaceJavaWS port = service.getDesguaceJavaWSPort();
        return port.cancelarOferta(id);
    }

    public static Boolean baja(java.lang.String id) {
        gestor_desguace_java.DesguaceJavaWS_Service service = new gestor_desguace_java.DesguaceJavaWS_Service(JUDDIProxy.getWsdl());
        gestor_desguace_java.DesguaceJavaWS port = service.getDesguaceJavaWSPort();
        return port.baja(id);
    }

    public static Boolean cambiarEstadoPedido_1(java.lang.String id, int estado) {
        gestor_desguace_java.DesguaceJavaWS_Service service = new gestor_desguace_java.DesguaceJavaWS_Service(JUDDIProxy.getWsdl());
        gestor_desguace_java.DesguaceJavaWS port = service.getDesguaceJavaWSPort();
        return port.cambiarEstadoPedido(id, estado);
    }

}
