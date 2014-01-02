/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package gestion;

import java.util.Properties;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
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
 * @author Cute
 */
public class Gestion extends Application {

    static String getOfertasporPedido() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
        
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.show();
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

    public static String getAltas() {
        gestor_admin.AdminWS_Service service = new gestor_admin.AdminWS_Service();
        gestor_admin.AdminWS port = service.getAdminWSPort();
        return port.getAltas();
    }

    public static String getDesguaces() {
        gestor_admin.AdminWS_Service service = new gestor_admin.AdminWS_Service();
        gestor_admin.AdminWS port = service.getAdminWSPort();
        return port.getDesguaces();
    }

    public static String getOfertas() {
        gestor_admin.AdminWS_Service service = new gestor_admin.AdminWS_Service();
        gestor_admin.AdminWS port = service.getAdminWSPort();
        return port.getOfertas();
    }

    public static String getPedidos() {
        gestor_admin.AdminWS_Service service = new gestor_admin.AdminWS_Service();
        gestor_admin.AdminWS port = service.getAdminWSPort();
        return port.getPedidos();
    }

    public static String getTalleres() {
        gestor_admin.AdminWS_Service service = new gestor_admin.AdminWS_Service();
        gestor_admin.AdminWS port = service.getAdminWSPort();
        return port.getTalleres();
    }

    public static String getPedidoID(java.lang.String id) {
        gestor_admin.AdminWS_Service service = new gestor_admin.AdminWS_Service();
        gestor_admin.AdminWS port = service.getAdminWSPort();
        return port.getPedidoID(id);
    }

    public static String getOfertasporPedido(java.lang.String idPedido) {
        gestor_admin.AdminWS_Service service = new gestor_admin.AdminWS_Service();
        gestor_admin.AdminWS port = service.getAdminWSPort();
        return port.getOfertasporPedido(idPedido);
    }

}
