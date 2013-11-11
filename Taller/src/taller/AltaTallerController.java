/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package taller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Pablo
 */
public class AltaTallerController implements Initializable {

    /**
     * Class Fxml variables
     */
    @FXML
    public TextField tfNombreTaller;
    public TextField tfNombreDuenyo;
    public TextField tfDireccion;
    public TextField tfCiudad;
    public TextField tfCp;
    public TextField tfTelefono;
    public Label errorNombreTaller;
    public Label errorNombreDuenyo;
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
                    if (Taller.validarNombre(tfNombreTaller.getText())) {
                        tfNombreTaller.setStyle("-fx-border-color: green;");
                        errorNombreTaller.setText("");
                    } else {
                        //add errors in the interface
                        errorNombreTaller.setText("No pueden contener carácteres extraños (á,é,ñ,...)");
                        tfNombreTaller.setStyle("-fx-border-color: red;");
                    }
                }
            }
        });

        tfNombreDuenyo.focusedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> arg0, Boolean arg1, Boolean arg2) {
                if (!arg2) { //Code here the action when the object lose the focus
                    if (Taller.validarNombre(tfNombreDuenyo.getText())) {
                        tfNombreDuenyo.setStyle("-fx-border-color: green;");
                        errorNombreDuenyo.setText("");
                    } else {
                        tfNombreDuenyo.setStyle("-fx-border-color: red;");
                        //add errors in the interface
                        errorNombreDuenyo.setText("No pueden contener carácteres extraños (á,é,ñ,...)");
                    }
                }
            }
        });

        tfCiudad.focusedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> arg0, Boolean arg1, Boolean arg2) {
                if (!arg2) { //Code here the action when the object lose the focus
                    if (Taller.validarNombre(tfCiudad.getText())) {
                        tfCiudad.setStyle("-fx-border-color: green;");
                        errorCiudad.setText("");
                    } else {
                        tfCiudad.setStyle("-fx-border-color: red;");
                        //add errors in the interface
                        errorCiudad.setText("No pueden contener carácteres extraños (á,é,ñ,...)");
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
                    if (Taller.validarSoloNumeros(tfCp.getText())) {
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
                    if (Taller.validarSoloNumeros(tfTelefono.getText())) {
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

    /**
     *
     * @param e
     */
    public void onClickCancel(ActionEvent e) {
        System.exit(0);
    }

    /**
     *
     * @param e
     */
    public void onClickAceptar(ActionEvent e) {
        //If the validation goes well
        if (Taller.validar(tfNombreTaller.getText(), tfNombreDuenyo.getText(), tfDireccion.getText(), tfCiudad.getText(), tfCp.getText(), tfTelefono.getText())) {
            //then we can send the registration
            System.out.println(Taller.alta("hola que tal"));

        }
        //else nothing
    }

}
