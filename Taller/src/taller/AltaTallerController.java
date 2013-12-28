/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package taller;

import BD.InterfazBD;
import com.google.gson.Gson;
import general.Pedido;
import java.io.IOException;
import java.net.URL;
import java.util.Date;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.fxml.JavaFXBuilderFactory;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Pablo
 */
public class AltaTallerController implements Initializable {

    Stage thisStage;
    InterfazBD bd;
    /**
     * Class Fxml variables
     */
    @FXML
    public TextField tfNombreTaller;
    public TextField tfEmail;
    public TextField tfDireccion;
    public TextField tfCiudad;
    public TextField tfCp;
    public TextField tfTelefono;
    public Label errorNombreTaller;
    public Label errorEmail;
    public Label errorDireccion;
    public Label errorCiudad;
    public Label errorCp;
    public Label errorTelefono;

    /**
     * Initializes the controller class.
     */
    @Override

    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        assert tfNombreTaller != null : "fx:id=\"myButton\" was not injected: check your FXML file 'simple.fxml'.";
        /**
         *
         */
        tfNombreTaller.focusedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> arg0, Boolean arg1, Boolean arg2) {
                if (!arg2) { //Code here the action when the object lose the focus
                    if (MainTaller.validarNombre(tfNombreTaller.getText())) {
                        tfNombreTaller.setStyle("-fx-border-color: green;");
                        errorNombreTaller.setText("");
                    } else {
                        //add errors in the interface
                        errorNombreTaller.setText("No pueden contener carácteres extraños, ni números");
                        tfNombreTaller.setStyle("-fx-border-color: red;");
                    }
                }
            }
        });

        tfEmail.focusedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> arg0, Boolean arg1, Boolean arg2) {
                if (!arg2) { //Code here the action when the object lose the focus
                    if (MainTaller.validarEmail(tfEmail.getText())) {
                        tfEmail.setStyle("-fx-border-color: green;");
                        errorEmail.setText("");
                    } else {
                        tfEmail.setStyle("-fx-border-color: red;");
                        //add errors in the interface
                        errorEmail.setText("Email incorrecto");
                    }
                }
            }
        });

        tfCiudad.focusedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> arg0, Boolean arg1, Boolean arg2) {
                if (!arg2) { //Code here the action when the object lose the focus
                    if (MainTaller.validarNombre(tfCiudad.getText())) {
                        tfCiudad.setStyle("-fx-border-color: green;");
                        errorCiudad.setText("");
                    } else {
                        tfCiudad.setStyle("-fx-border-color: red;");
                        //add errors in the interface
                        errorCiudad.setText("No pueden contener carácteres extraños, ni números");
                    }
                }
            }
        });

        tfDireccion.focusedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> arg0, Boolean arg1, Boolean arg2) {
                if (!arg2) { //Code here the action when the object lose the focus
                    if (true) {
                        tfDireccion.setStyle("-fx-border-color: green;");
                        errorDireccion.setText("");
                    } else {
                        tfDireccion.setStyle("-fx-border-color: red;");
                        //add errors in the interface
                        errorDireccion.setText("Caca");
                    }
                }
            }
        });

        tfCp.focusedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> arg0, Boolean arg1, Boolean arg2) {
                if (!arg2) { //Code here the action when the object lose the focus
                    if (MainTaller.validarSoloNumeros(tfCp.getText())) {
                        tfCp.setStyle("-fx-border-color: green;");
                        errorCp.setText("");
                    } else {
                        tfCp.setStyle("-fx-border-color: red;");
                        //add errors in the interface
                        errorCp.setText("Sólo añadir números");
                    }
                }
            }
        });

        tfTelefono.focusedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> arg0, Boolean arg1, Boolean arg2) {
                if (!arg2) { //Code here the action when the object lose the focus
                    if (MainTaller.validarSoloNumeros(tfTelefono.getText())) {
                        tfTelefono.setStyle("-fx-border-color: green;");
                        errorTelefono.setText("");
                    } else {
                        tfTelefono.setStyle("-fx-border-color: red;");
                        //add errors in the interface
                        errorTelefono.setText("Sólo añadir números");
                    }
                }
            }
        });
    }

    public void setStage(Stage stage) {
        thisStage = stage;
    }

    public void showStage() {
        thisStage.sizeToScene();
        thisStage.show();
    }

    /**
     *
     * @param e
     */
    public void onClickCancel(ActionEvent e) {
        System.exit(0);
    }

    public void setEditableAllInputs(boolean b) {
        tfNombreTaller.setEditable(b);
        tfEmail.setEditable(b);
        tfDireccion.setEditable(b);
        tfCiudad.setEditable(b);
        tfCp.setEditable(b);
        tfTelefono.setEditable(b);
    }

    /**
     *
     * @param e
     * @throws java.io.IOException
     */
    @SuppressWarnings("empty-statement")
    public void onClickAceptar(ActionEvent e) throws IOException, Exception {
        //If the validation goes well
        //bloquear los inputs
        Pedido nuevoP = new Pedido(1, "", new Date());
        Gson g = new Gson();
        String listaJSON = g.toJson(nuevoP);
        MainTaller.nuevoPedido(listaJSON);
        setEditableAllInputs(false);
        if (MainTaller.validar(tfNombreTaller.getText(), tfEmail.getText(), tfDireccion.getText(), tfCiudad.getText(), tfCp.getText(), tfTelefono.getText())) {
            //then we can send the registration
            System.out.println("Enviando...");
            if (MainTaller.alta(tfNombreTaller.getText(), tfEmail.getText(), tfDireccion.getText(), tfCiudad.getText(), Integer.parseInt(tfCp.getText()), Integer.parseInt(tfTelefono.getText())) >= 0) {
                //METER en base de datos si está todo ok.
                bd = new InterfazBD("sor_taller");
                if (bd.altaTaller(tfNombreTaller.getText(), tfEmail.getText(), tfDireccion.getText(), tfCiudad.getText(), Integer.parseInt(tfCp.getText()), Integer.parseInt(tfTelefono.getText()), 2) != -1) {
                    URL location = getClass().getResource("tallerPendienteActivacion.fxml");
                    FXMLLoader loader = new FXMLLoader();
                    loader.setLocation(location);
                    loader.setBuilderFactory(new JavaFXBuilderFactory());
                    Parent page = (Parent) loader.load(location.openStream());
                    thisStage.getScene().setRoot(page);
                    thisStage.setTitle("Esperando código de aceptación");
                    TallerPendienteActivacionController staticDataBox = (TallerPendienteActivacionController) loader.getController();
                    staticDataBox.setStage(thisStage);
                    staticDataBox.showStage();
                } else {
                    //devolver un error
                }
                //bd.close()
            }
            else{
                System.err.println("alta me ha devuelto < 0");
            }
            //Faltaría anyadir el código recibido por el gestor hay que pasarlo al gestor
            /*MainTaller.sendMail("pablovm1990@gmail.com", tfEmail.getText(), "Usuario SorApp creado correctamente",
             "<p>Gracias por confiar en nosotros como su gestor de actividades. No le defraudaremos.</p>"
             + "<br/><br/>Los datos que ha introducido han sido los siguientes:<br/>"
             + "<li>" + tfNombreTaller.getText() + "</li><br/>"
             + "<li>" + tfDireccion.getText() + "</li><br/>"
             + "<li>" + tfCiudad.getText() + "</li><br/>"
             + "<li>" + tfCp.getText() + "</li><br/>"
             + "<li>" + tfTelefono.getText() + "</li><br/>"
             + "<br/>El equipo de SorPracs, liderador por el Sr. Albentosa");*/
        }
        //else nothing
    }

}
