/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package taller;

import BD.InterfazBD;
import java.sql.SQLException;
import general.EstadoGeneral;
import general.Taller;
import java.io.IOException;
import java.net.URL;
import java.util.Properties;
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
import javax.mail.Message;
import javax.mail.Message.RecipientType;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author Pablo
 */
public class MainTaller extends Application {

    InterfazBD bd;
    public static Taller taller;
    public Stage stage;

    @Override
    public void start(Stage stage2) throws Exception {
        stage = stage2;
        bd = new InterfazBD("sor_taller");
        System.out.println(bd.getPedidosActivos());
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
                //FXMLLoader loader = changeScene(".fxml");
                stage.setTitle("Gestión de pedidos");
                /*TallerPendienteActivacionController staticDataBox = (TallerPendienteActivacionController) loader.getController();
                 staticDataBox.setStage(stage);
                staticDataBox.showStage();*/
            } else { //baja
                //FXMLLoader loader = changeScene(".fxml");
                stage.setTitle("Estoy de baja no sé que hacer");
                /*TallerPendienteActivacionController staticDataBox = (TallerPendienteActivacionController) loader.getController();
                 staticDataBox.setStage(stage);
                 staticDataBox.showStage();*/
            }
        } else {
            FXMLLoader loader = changeScene("AltaTaller.fxml");
            stage.setTitle("Alta de taller");
            /*TallerPendienteActivacionController staticDataBox = (TallerPendienteActivacionController) loader.getController();
             staticDataBox.setStage(stage);
             staticDataBox.showStage();*/
            AltaTallerController staticDataBox = (AltaTallerController) loader.getController();
            staticDataBox.setStage(stage);
            staticDataBox.showStage();
        }
    }

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
     *
     */
    public void goToTallerPendienteActivacion() {
        try {
            replaceSceneContent("tallerPendienteActivacion.fxml");
        } catch (Exception ex) {
            Logger.getLogger(MainTaller.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void vilella() throws SQLException, ClassNotFoundException{
        InterfazBD i = new InterfazBD("sor_gestor");
        System.out.println("aquí");
        
    }

    /**
     *
     * @param n
     * @return
     */
    public static boolean validarNombre(String n) {
        InterfazBD i = null;
        try {
            //vilella();
                        
            i = new InterfazBD("sor_gestor");
            
            i.getPedidosActivos();
            
            
        } catch (SQLException ex) {
            Logger.getLogger(MainTaller.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(MainTaller.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("aquí");
        
        Pattern p = Pattern.compile("^[a-zA-Z][a-zA-Z ]*[a-zA-Z]");
        Matcher m = p.matcher(n);
        if (!m.matches()) {
            return false;
        }

        return true;
    }

    /**
     *
     * @param num
     * @return
     */
    public static boolean validarSoloNumeros(String num) {
        //Verificar que no se pase de 9 digitos!
        Pattern p = Pattern.compile("^[0-9]*[0-9]");
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
        Pattern p = Pattern.compile("^[a-zA-Z0-9._-]+@[a-zA-Z0-9]+[.][a-zA-Z]+");
        Matcher m = p.matcher(n);
        if (!m.matches()) {
            return false;
        }
        return true;
    }

    /**
     *
     * @param from
     * @param to
     * @param subject
     * @param text
     */
    public static void sendMail(final String from, String to, String subject, String text) {
        String SMTP_HOST_NAME = "smtp.gmail.com";
        String SMTP_PORT = "465";
        String SSL_FACTORY = "javax.net.ssl.SSLSocketFactory";
        Properties props = new Properties();
        props.put("mail.smtp.host", SMTP_HOST_NAME);
        props.put("mail.smtp.auth", "true");
        props.put("mail.debug", "true");
        props.put("mail.smtp.port", SMTP_PORT);
        props.put("mail.smtp.socketFactory.port", SMTP_PORT);
        props.put("mail.smtp.socketFactory.class", SSL_FACTORY);
        props.put("mail.smtp.socketFactory.fallback", "false");

        Session session = Session.getDefaultInstance(props,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        //a priori, para que funcione en otro pc,
                        //a lo mejor habría que generar otra contrasenya, pero creo que no
                        return new PasswordAuthentication("pablovm1990@gmail.com",
                                "gcjacxtujgfqigxt");
                    }
                });

        session.setDebug(true);

        Message simpleMessage = new MimeMessage(session);
        InternetAddress fromAddress = null;
        InternetAddress toAddress = null;
        try {
            fromAddress = new InternetAddress(from);
            toAddress = new InternetAddress(to);
        } catch (AddressException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        try {
            simpleMessage.setFrom(fromAddress);
            simpleMessage.setRecipient(RecipientType.TO, toAddress);
            simpleMessage.setSubject(subject);
            simpleMessage.setContent(text, "text/html");

            Transport.send(simpleMessage);
        } catch (MessagingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
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
        return validarNombre(nombreTaller) && validarEmail(email) && validarNombre(ciudad) && validarSoloNumeros(cp) && validarSoloNumeros(telefono);
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
     *
     * @param name
     * @param email
     * @param address
     * @param city
     * @param postalCode
     * @param telephone
     * @return
     */
    public static int alta(java.lang.String name, java.lang.String email, java.lang.String address, java.lang.String city, int postalCode, int telephone) {
        taller_ws.TallerWS_Service service = new taller_ws.TallerWS_Service();
        taller_ws.TallerWS port = service.getTallerWSPort();
        return port.alta(name, email, address, city, postalCode, telephone);
    }

    public  static int activarTaller(java.lang.String mail) {
        taller_ws.TallerWS_Service service = new taller_ws.TallerWS_Service();
        taller_ws.TallerWS port = service.getTallerWSPort();
        return port.activarTaller(mail);
    }

}
