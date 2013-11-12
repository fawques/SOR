/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package taller;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author Pablo
 */
public class MainTaller extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        //if(noEstaRegistradoEnGestor)
        Parent root = FXMLLoader.load(getClass().getResource("AltaTaller.fxml"));

        Scene scene = new Scene(root);

        stage.setScene(scene);
        stage.show();
    }

    /* public void abrirAlta()
     {
     Parent altaTaller = FXMLLoader.load(getClass().getResource("AltaTaller.fxml"));
        
     Scene scene = new Scene(altaTaller);
     }*/
    /**
     *
     * @param n
     * @return
     */
    public static boolean validarNombre(String n) {
        Pattern p = Pattern.compile("^[a-zA-Z ]*[a-zA-Z]");
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
        Pattern p = Pattern.compile("^[0-9 ]*[0-9]");
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
        Pattern p = Pattern.compile("^[a-zA-Z0-9]+@[a-zA-Z0-9]+[.][a-zA-Z]+");
        Matcher m = p.matcher(n);
        if (!m.matches()) {
            return false;
        }
        return true;
    }

    /*//mail.jar send mail netbeans
     public static void sendMail() {
     Properties props = new Properties();
     props.put("mail.smtp.host", "smtp.gmail.com");
     props.put("mail.smtp.port", "465");

     Session mailSession = Session.getDefaultInstance(props);
     Message simpleMessage = new MimeMessage(mailSession);

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
     simpleMessage.setText(text);

     Transport.send(simpleMessage);
     } catch (MessagingException e) {
     // TODO Auto-generated catch block
     e.printStackTrace();
     }
     }*/
    /**
     *
     * @param nombreTaller
     * @param nombreDuenyo
     * @param direccion
     * @param ciudad
     * @param cp
     * @param telefono
     * @return
     */
    public static boolean validar(String nombreTaller, String nombreDuenyo, String direccion, String ciudad, String cp, String telefono) {
        return validarNombre(nombreTaller) && validarNombre(nombreDuenyo) && validarNombre(ciudad) && validarSoloNumeros(cp) && validarSoloNumeros(telefono);
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
    /*public static Boolean alta(java.lang.String name, java.lang.String email, java.lang.String address, java.lang.String city, int postalCode, int telephone) {
     taller_ws.TallerWS_Service service = new taller_ws.TallerWS_Service();
     taller_ws.TallerWS port = service.getTallerWSPort();
     return port.alta(name, email, address, city, postalCode, telephone);
     }*/
}
