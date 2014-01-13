/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package desguace;

import BD.InterfazBD;
import desguace.AltaDesguace;
import desguace.DesguacerPendienteActivacionController;
import desguace.GestionPedidos;
import general.Desguace;
import general.EstadoGeneral;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.fxml.JavaFXBuilderFactory;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author manu
 */
public class DesguaceJava extends Application {
    public Stage stage;
    static InterfazBD bd;
    @Override
    public void start(Stage stage2) throws IOException, SQLException{
        try {
            Desguace desguace;
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
                } else { //un botÃ³n y prou
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
            //bd.close();
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
        gestor_desguace_java.DesguaceJavaWS_Service service = new gestor_desguace_java.DesguaceJavaWS_Service();
        gestor_desguace_java.DesguaceJavaWS port = service.getDesguaceJavaWSPort();
        return port.alta(name, email, address, city, postalCode, telephone);
    }

    public static String checkActivacion(java.lang.String mail) {
        gestor_desguace_java.DesguaceJavaWS_Service service = new gestor_desguace_java.DesguaceJavaWS_Service();
        gestor_desguace_java.DesguaceJavaWS port = service.getDesguaceJavaWSPort();
        return port.checkActivacion(mail);
    }

    public static String getPedidos() {
        gestor_desguace_java.DesguaceJavaWS_Service service = new gestor_desguace_java.DesguaceJavaWS_Service();
        gestor_desguace_java.DesguaceJavaWS port = service.getDesguaceJavaWSPort();
        return port.getPedidos();
    }

}
