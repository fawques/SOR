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
                    } else {
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
                    } else {
                        tfNombreDuenyo.setStyle("-fx-border-color: red;");
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
                    } else {
                        tfCiudad.setStyle("-fx-border-color: red;");
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
                    } else {
                        tfDireccion.setStyle("-fx-border-color: red;");
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
                    } else {
                        tfCp.setStyle("-fx-border-color: red;");
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
                    } else {
                        tfTelefono.setStyle("-fx-border-color: red;");
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
            System.out.println("ok");
        }
        //else nothing
    }

}
