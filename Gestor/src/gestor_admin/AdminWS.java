/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor_admin;

import BD.InterfazBD;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import general.Desguace;
import general.Oferta;
import general.Pedido;
import general.Taller;
import general.Desguace;
import java.util.ArrayList;
import java.util.Date;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import BD.InterfazBD;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import general.EstadoOferta;
import general.EstadoPedido;
import jUDDI.SimplePublish;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Type;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.Timer;

/**
 *
 * @author Cute
 */
@WebService(serviceName = "AdminWS")
public class AdminWS {
    InterfazBD bd;
    /**
     *
     * @param from
     * @param to
     * @param subject
     * @param text
     */
    
    private ActionListener actionListener = new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent arg0) {
                try {
                    bd = new InterfazBD("sor_gestor");
                     Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ss").create();
                ArrayList<Oferta> listaOferta= bd.getOfertasPorEstado(EstadoOferta.ACTIVE);
                listaOferta.addAll(bd.getOfertasPorEstado(EstadoOferta.ACCEPTED));
                ArrayList<Pedido> listaPedido=bd.getPedidosPorEstado(EstadoPedido.ACTIVE);
                listaPedido.addAll(bd.getPedidosPorEstado(EstadoPedido.ACCEPTED));
                
                 for(Pedido pedido:listaPedido){
                    if((new Date()).after(pedido.getFecha_limite())){                
                        bd.cancelarPedido(pedido.getID());
                    }
                }
                for(Oferta oferta:listaOferta){
                    if((new Date()).after(oferta.getFecha_limite())){                
                        bd.cambiarEstadoOferta(EstadoOferta.CANCELLED,oferta.getID());
                    }
                }
               
                } catch (SQLException ex) {
                    Logger.getLogger(AdminWS.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(AdminWS.class.getName()).log(Level.SEVERE, null, ex);
                }
             
                
            }

        };
    public Timer timer = new Timer(6000,actionListener); // Timer(TimeInMilliSeconds, ActionListener) 1000ms = 1s 

    public void sendMail(final String from, String to, String subject, String text) {
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
            simpleMessage.setRecipient(Message.RecipientType.TO, toAddress);
            simpleMessage.setSubject(subject);
            simpleMessage.setContent(text, "text/html");

            Transport.send(simpleMessage);
        } catch (MessagingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    /**
     * This is a sample web service operation
     */
    @WebMethod(operationName = "hello")
    public String hello() {
        return "Hello";
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "getPedidos")
    public String getPedidos() {
    	 Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ss").create();
        //Dec 7, 2013 5:46:35 PM
        try {
            ArrayList<Pedido> listaPedidos = new ArrayList<Pedido>();
            bd = new InterfazBD("sor_gestor");
            listaPedidos = bd.getPedidosActivos();
            String listaJSON = gson.toJson(listaPedidos);
            System.out.println("listaJSON = " + listaJSON);
            return listaJSON;
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AdminWS.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(AdminWS.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "getOfertas")
    public String getOfertas() {
        try {
            bd = new InterfazBD("sor_gestor");
            ArrayList<Oferta> listaOfertas = new ArrayList<Oferta>();
        //listaOfertas.add(new Oferta(1,new Date(),new Date(), new Date(),32.2,1,1));
            //listaOfertas.add(new Oferta(2,new Date(),new Date(), new Date(),20.0,1,1));
            listaOfertas = bd.getOfertas();
            Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ss").create();
            String listaJSON = gson.toJson(listaOfertas);
            System.out.println("listaJSON = " + listaJSON);
            return listaJSON;
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AdminWS.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(AdminWS.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "getDesguaces")
    public String getDesguaces() {
        try {
            bd = new InterfazBD("sor_gestor");
            ArrayList<Desguace> listaDesguaces = new ArrayList<Desguace>();
       // listaDesguaces.add(new Desguace(1,"Pepito S.L", "comprame@gmai.com", "C/Mariano Luis", "España", 1234,124124));
            //listaDesguaces.add(new Desguace(2,"Construcciones S.L", "todoparavender@gmail.com", "C/ Empresario Rico", "España", 1234,124124));
            listaDesguaces = bd.getDesguaces();
            Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ss").create();
            String listaJSON = gson.toJson(listaDesguaces);
            System.out.println("listaJSON = " + listaJSON);
            return listaJSON;
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AdminWS.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(AdminWS.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "getTalleres")
    public String getTalleres() {
        try {
            bd = new InterfazBD("sor_gestor");
            ArrayList<Taller> listaTalleres = new ArrayList<Taller>();
            listaTalleres=bd.getTalleres();
            Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ss").create();
            String listaJSON = gson.toJson(listaTalleres);
            System.out.println("listaJSON = " + listaJSON);
            return listaJSON;
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AdminWS.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(AdminWS.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "getOfertasporPedido")
    public String getOfertasporPedido(@WebParam(name = "idPedido") String idPedido) {
    	 Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ss").create();
        //Dec 7, 2013 5:46:35 PM
        try {
            ArrayList<Oferta> listaOfertas = new ArrayList<Oferta>();
            bd = new InterfazBD("sor_gestor");
            listaOfertas = bd.getOfertasPedido(idPedido);
            String listaJSON = gson.toJson(listaOfertas);
            System.out.println("listaJSON = " + listaJSON);
            return listaJSON;
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AdminWS.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(AdminWS.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "getPedidoID")
    public String getPedidoID(@WebParam(name = "id") String id) {
        try {
            bd = new InterfazBD("sor_gestor");
            ArrayList<Pedido> listaPedido = new ArrayList<Pedido>();
            listaPedido.add(bd.getPedido(id));
            Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ss").create();
            String listaJSON = gson.toJson(listaPedido);
            System.out.println("listaJSON = " + listaJSON);
            return listaJSON;
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AdminWS.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(AdminWS.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;

    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "Registrar")
    public String Registrar() {
        SimplePublish sp = new SimplePublish();
        sp.publish();
        return "hola";
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "getAltaTalleres")
    public String getAltaTalleres() {
         try{
            bd = new InterfazBD("sor_gestor");
             ArrayList<Taller> listaTalleres = new ArrayList<Taller>();
             listaTalleres=bd.getAltasTaller();
             Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ss").create();
            String listaJSON = gson.toJson(listaTalleres);
            System.out.println("listaJSON = " + listaJSON);
            return listaJSON;
        }        
        catch (ClassNotFoundException ex) {
         Logger.getLogger(AdminWS.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
         Logger.getLogger(AdminWS.class.getName()).log(Level.SEVERE, null, ex);
     }
        return null;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "darAccesoTaller")
    public Boolean darAccesoTaller(@WebParam(name = "ID") String ID) {
     try {
         bd = new InterfazBD("sor_gestor");
         boolean res = bd.activarTaller(ID);
         Taller t = bd.getTallerEnGestor(ID);
        //TODO descomentar
         /* if (res) {
             sendMail("pablovm1990@gmail.com", t.getEmail(), "Usuario SorApp creado correctamente",
                     "<p>Gracias por confiar en nosotros como su gestor de actividades. No le defraudaremos.</p>"
                     + "<br/><br/>Los datos que ha introducido han sido los siguientes:<br/>"
                     + "<li>" + t.getName() + "</li><br/>"
                     + "<li>" + t.getAddress() + "</li><br/>"
                     + "<li>" + t.getCity() + "</li><br/>"
                     + "<li>" + t.getPostalCode() + "</li><br/>"
                     + "<li>" + t.getTelephone() + "</li><br/>"
                     + "<br/>El equipo de SorPracs, liderador por el Sr. Albentosa");
         }*/
         bd.close();
         return res;
        
     } catch (SQLException ex) {
         Logger.getLogger(AdminWS.class.getName()).log(Level.SEVERE, null, ex);
     } catch (ClassNotFoundException ex) {
         Logger.getLogger(AdminWS.class.getName()).log(Level.SEVERE, null, ex);
     }
            
            
        return false;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "addAccesoDesguace")
    public Boolean addAccesoDesguace(@WebParam(name = "ID") String ID) {
     try {
         bd = new InterfazBD("sor_gestor");
        return  bd.activarDesguace(ID);
        
     } catch (SQLException ex) {
         Logger.getLogger(AdminWS.class.getName()).log(Level.SEVERE, null, ex);
     } catch (ClassNotFoundException ex) {
         Logger.getLogger(AdminWS.class.getName()).log(Level.SEVERE, null, ex);
     }
            
            
        return false;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "getAltaDesguace")
    public String getAltaDesguace() {
         try{
            bd = new InterfazBD("sor_gestor");
             ArrayList<Desguace> listaDesguace = new ArrayList<Desguace>();
             listaDesguace=bd.getAltasDesguaces();
             Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ss").create();
            String listaJSON = gson.toJson(listaDesguace);
            System.out.println("listaJSON = " + listaJSON);
            return listaJSON;
        }        
        catch (ClassNotFoundException ex) {
         Logger.getLogger(AdminWS.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
         Logger.getLogger(AdminWS.class.getName()).log(Level.SEVERE, null, ex);
     }
        return null;
    }
}
