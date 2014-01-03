/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package taller;

import BD.InterfazBD;
import com.google.gson.Gson;
import general.EstadoGeneral;
import general.EstadoPedido;
import general.Pedido;
import general.Pieza;
import general.Taller;
import gestor_taller.JMSException_Exception;
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
 * @author Pablo
 */
public class MainTaller extends Application {

    static InterfazBD bd;

    /**
     *
     */
    public static Taller taller;

    /**
     *
     */
    public Stage stage;

    /**
     *
     * @param stage2
     * @throws Exception
     */
    @Override
    public void start(Stage stage2) throws Exception {
        stage = stage2;
        bd = new InterfazBD("sor_taller");
        //System.out.println(bd.getPedidosActivos());
        taller = bd.getPrimerTaller();
        //bd.close();
        if (taller != null) //está pendiente o activado
        {
            if (taller.getEstado() == EstadoGeneral.PENDIENTE) //pendiente de activación
            {
                FXMLLoader loader = changeScene("tallerPendienteActivacion.fxml");
                stage.setTitle("Esperando código de aceptación");
                TallerPendienteActivacionController staticDataBox = (TallerPendienteActivacionController) loader.getController();
                staticDataBox.setStage(stage);
                staticDataBox.showStage();
            } else if (taller.getEstado() == EstadoGeneral.ACTIVE) { //activo
                //Cargar GestionPedido
                FXMLLoader loader = changeScene("GestionPedidos.fxml");
                stage.setTitle("Gestión de pedidos");
                GestionPedidosController staticDataBox = (GestionPedidosController) loader.getController();
                 staticDataBox.setStage(stage);
                staticDataBox.showStage();
            } else { //baja
                //Yo lo que haria sería un volver a darme de alta, con los mismos datos
                //un botón y prou
                FXMLLoader loader = changeScene("AltaTaller.fxml");
                stage.setTitle("Alta de taller");
                AltaTallerController staticDataBox = (AltaTallerController) loader.getController();
                staticDataBox.setStage(stage);
                staticDataBox.showStage();
            }
        } else { //no existe
            FXMLLoader loader = changeScene("AltaTaller.fxml");
            stage.setTitle("Alta de taller");
            AltaTallerController staticDataBox = (AltaTallerController) loader.getController();
            staticDataBox.setStage(stage);
            staticDataBox.showStage();
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

    /**
     * ****************** Escenas *************************
     */
    /**
     * @param fxml
     * @return
     * @throws java.io.IOException
     */

    public FXMLLoader changeScene(String fxml) throws IOException {
        //Mostrar página de espera interfaz básica
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

    /**
     *
     * @param fxml
     * @return
     * @throws Exception
     */
    public Parent replaceSceneContent(String fxml) throws Exception {
        Parent page = (Parent) FXMLLoader.load(MainTaller.class.getResource(fxml), null, new JavaFXBuilderFactory());
        Scene scene = stage.getScene();
        if (scene == null) {
            stage.setScene(scene);
        } else {
            stage.getScene().setRoot(page);
        }
        stage.sizeToScene();
        return page;
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

    /**
     * ****************** BD *************************
     */
    /**
     * 
     * @param idRecibido
     * @return
     */

    public static boolean activarTallerBD(String idRecibido) {
        try {
            bd = new InterfazBD("sor_taller");
            boolean r = bd.activarTallerMainTaller(idRecibido);
            //bd.close();
            return r;
        } catch (SQLException ex) {
            Logger.getLogger(MainTaller.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(MainTaller.class.getName()).log(Level.SEVERE, null, ex);
        }

        return false;
    }

    public static ArrayList<Pedido> buscarPedidos(String idPedido, String idPieza, String estado, Date fechaLimite, String modoAceptacion) {
        try {
            bd = new InterfazBD("sor_taller");
            ArrayList<Pedido> p = bd.buscarPedido(idPedido, idPieza, estado, fechaLimite, modoAceptacion);
            //bd.close();
            return p;
        } catch (SQLException ex) {
            Logger.getLogger(MainTaller.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(MainTaller.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public static void crearPedido(Date fechaAlta, EstadoPedido estado, Date fechaLimite, ArrayList<Pieza> piezas, ArrayList<Integer> cantidades) {
        try {
            bd = new InterfazBD("sor_taller");
            int id = bd.anadirPedido(fechaAlta, estado, bd.getPrimerTaller().getID(), new Date(), fechaLimite);
            bd.anyadirPiezasAPedido(id, piezas, cantidades);
            //bd.close();
            Gson gson = new Gson();
            nuevoPedido(gson.toJson(new Pedido(id, bd.getPrimerTaller().getID(), fechaLimite)));
        } catch (SQLException ex) {
            Logger.getLogger(MainTaller.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(MainTaller.class.getName()).log(Level.SEVERE, null, ex);
        } catch (JMSException_Exception ex) {
            Logger.getLogger(MainTaller.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    /**
     * ******************* WebServices *************************
     * @param name
     * @param email
     * @param address
     * @param city
     * @param postalCode
     * @param telephone
     * @return 
     */

    public static boolean alta(java.lang.String name, java.lang.String email, java.lang.String address, java.lang.String city, int postalCode, int telephone) {
        gestor_taller.TallerWS_Service service = new gestor_taller.TallerWS_Service();
        gestor_taller.TallerWS port = service.getTallerWSPort();
        return port.alta(name, email, address, city, postalCode, telephone);
    }

    public static String checkActivacion(java.lang.String mail) {
        gestor_taller.TallerWS_Service service = new gestor_taller.TallerWS_Service();
        gestor_taller.TallerWS port = service.getTallerWSPort();
        return port.checkActivacion(mail);
    }
    
    public static String nuevoPedido(java.lang.String pedido) throws JMSException_Exception {
        gestor_taller.TallerWS_Service service = new gestor_taller.TallerWS_Service();
        gestor_taller.TallerWS port = service.getTallerWSPort();
        return port.nuevoPedido(pedido);
    }     
}
