/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package desguace;

import BD.InterfazBD;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

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
public class AltaDesguace implements Initializable {

    Stage thisStage;
    InterfazBD bd;
    /**
     * Class Fxml variables
     */
    @FXML
    public TextField tfNombreDesguace;
    public TextField tfEmail;
    public TextField tfDireccion;
    public TextField tfCiudad;
    public TextField tfCp;
    public TextField tfTelefono;
    public TextField tfContrasenya;
    public Label errorNombreDesguace;
    public Label errorEmail;
    public Label errorDireccion;
    public Label errorCiudad;
    public Label errorCp;
    public Label errorTelefono;
    public Label labelID;
    /**
     * Initializes the controller class.
     */
    @Override

    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        assert tfNombreDesguace != null : "fx:id=\"myButton\" was not injected: check your FXML file 'simple.fxml'.";
        /**
         *
         */
        tfNombreDesguace.focusedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> arg0, Boolean arg1, Boolean arg2) {
                if (!arg2) { //Code here the action when the object lose the focus
                    if (DesguaceJava.validarNombre(tfNombreDesguace.getText())) {
                        tfNombreDesguace.setStyle("-fx-border-color: green;");
                        errorNombreDesguace.setText("");
                    } else {
                        //add errors in the interface
                        if (tfNombreDesguace.getText().length() < 22) {
                        	errorNombreDesguace.setText("No pueden contener caracteres extranyos, ni numeros");
                        } else if (tfNombreDesguace.getText().isEmpty()) {
                        	errorNombreDesguace.setText("No puede ser vacio");
                        } else {
                        	errorNombreDesguace.setText("No mas de 21 caracteres");
                        }

                        tfNombreDesguace.setStyle("-fx-border-color: red;");
                    }
                }
            }
        });

        tfEmail.focusedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> arg0, Boolean arg1, Boolean arg2) {
                if (!arg2) { //Code here the action when the object lose the focus
                    if (DesguaceJava.validarEmail(tfEmail.getText())) {
                        tfEmail.setStyle("-fx-border-color: green;");
                        errorEmail.setText("");
                    } else {
                        tfEmail.setStyle("-fx-border-color: red;");
                        //add errors in the interface
                        if (tfEmail.getText().isEmpty()) {
                            errorEmail.setText("No puede ser vacio");
                        } else {
                            errorEmail.setText("Email incorrecto");
                        }
                    }
                }
            }
        });

        tfCiudad.focusedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> arg0, Boolean arg1, Boolean arg2) {
                if (!arg2) { //Code here the action when the object lose the focus
                    if (DesguaceJava.validarNombre(tfCiudad.getText())) {
                        tfCiudad.setStyle("-fx-border-color: green;");
                        errorCiudad.setText("");
                    } else {
                        tfCiudad.setStyle("-fx-border-color: red;");
                        //add errors in the interface
                        if (tfCiudad.getText().length() < 22) {
                            errorCiudad.setText("No pueden contener caracteres extranyos, ni numeros");
                        } else if (tfCiudad.getText().isEmpty()) {
                            errorCiudad.setText("No puede ser vacio");
                        } else {
                            errorCiudad.setText("No mas de 21 caracteres");
                        }
                    }
                }
            }
        });

        tfDireccion.focusedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> arg0, Boolean arg1, Boolean arg2) {
                if (!arg2) { //Code here the action when the object lose the focus
                    if (DesguaceJava.validarDireccion(tfDireccion.getText())) {
                        tfDireccion.setStyle("-fx-border-color: green;");
                        errorDireccion.setText("");
                    } else {
                        tfDireccion.setStyle("-fx-border-color: red;");
                        //add errors in the interface
                        errorDireccion.setText("No mas de 21 caracteres");
                    }
                }
            }
        });

        tfCp.focusedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> arg0, Boolean arg1, Boolean arg2) {
                if (!arg2) { //Code here the action when the object lose the focus
                    if (DesguaceJava.validarSoloNumeros(tfCp.getText())) {
                        tfCp.setStyle("-fx-border-color: green;");
                        errorCp.setText("");
                    } else {
                        tfCp.setStyle("-fx-border-color: red;");
                        //add errors in the interface
                        if (tfCp.getText().length() >= 10) {
                            errorCp.setText("No mas de 9 caracteres");
                        } else if (tfCp.getText().isEmpty()) {
                            errorCp.setText("No puede ser vacio");
                        } else {
                            errorCp.setText("Solo anyadir numeros");
                        }
                    }
                }
            }
        });

        tfTelefono.focusedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> arg0, Boolean arg1, Boolean arg2) {
                if (!arg2) { //Code here the action when the object lose the focus
                    if (DesguaceJava.validarSoloNumeros(tfTelefono.getText())) {
                        tfTelefono.setStyle("-fx-border-color: green;");
                        errorTelefono.setText("");
                    } else {
                        tfTelefono.setStyle("-fx-border-color: red;");
                        //add errors in the interface
                        if (tfTelefono.getText().length() >= 10) {
                            errorTelefono.setText("No mas de 9 caracteres");
                        } else if (tfTelefono.getText().isEmpty()) {
                            errorTelefono.setText("No puede ser vacio");
                        } else {
                            errorTelefono.setText("Solo anyadir numeros");
                        }
                    }
                }
            }
        });
        
        if(DesguaceJava.desguace!=null){
            tfNombreDesguace.setText(DesguaceJava.desguace.getName());
            tfEmail.setText(DesguaceJava.desguace.getEmail());
            tfCiudad.setText(DesguaceJava.desguace.getCity());
            tfCp.setText(Integer.toString((DesguaceJava.desguace.getPostalCode())));
            tfDireccion.setText(DesguaceJava.desguace.getAddress());
            tfTelefono.setText(Integer.toString(DesguaceJava.desguace.getTelephone()));
            labelID.setText(DesguaceJava.desguace.getID());
           
           }
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
        tfNombreDesguace.setEditable(b);
        tfEmail.setEditable(b);
        tfDireccion.setEditable(b);
        tfCiudad.setEditable(b);
        tfCp.setEditable(b);
        tfTelefono.setEditable(b);
        tfContrasenya.setEditable(b);
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
        /*Pedido nuevoP = new Pedido(1, "", new Date());
           Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ss").create();
        String listaJSON = g.toJson(nuevoP);
        MainTaller.nuevoPedido(listaJSON);*/
        setEditableAllInputs(false);
        if (DesguaceJava.validar(tfNombreDesguace.getText(), tfEmail.getText(), tfDireccion.getText(), tfCiudad.getText(), tfCp.getText(), tfTelefono.getText())) {
            //then we can send the registration
            System.out.println("Enviando...");
            if (DesguaceJava.alta(tfNombreDesguace.getText(), tfEmail.getText(), tfDireccion.getText(), tfCiudad.getText(), tfCp.getText(), tfTelefono.getText())) {
                //METER en base de datos si esta todo ok.
                bd = new InterfazBD("sor_desguace");
                if (bd.altaDesguace(tfNombreDesguace.getText(), tfEmail.getText(), tfDireccion.getText(), tfCiudad.getText(), Integer.parseInt(tfCp.getText()), Integer.parseInt(tfTelefono.getText()), 2,tfContrasenya.getText()) != -1) {
                	DesguaceJava.anyadirRolUsuario("Administrador",tfContrasenya.getText(),"Administrador");
                	URL location = getClass().getResource("desguacePendienteActivacion.fxml");
                    FXMLLoader loader = new FXMLLoader();
                    loader.setLocation(location);
                    loader.setBuilderFactory(new JavaFXBuilderFactory());
                    Parent page = (Parent) loader.load(location.openStream());
                    thisStage.getScene().setRoot(page);
                    thisStage.setTitle("Esperando codigo de aceptacion");
                    DesguacerPendienteActivacionController staticDataBox = (DesguacerPendienteActivacionController) loader.getController();
                    staticDataBox.setStage(thisStage);
                    staticDataBox.showStage();
                } else {
                    //devolver un error
                }
                bd.close();
            }
            else{
                System.err.println("alta me ha devuelto < 0");
            }
        }
        //else nothing
    }
    public void irAGestionPedidos() throws IOException {
        URL location = getClass().getResource("GestionPedidos.fxml");
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(location);
        loader.setBuilderFactory(new JavaFXBuilderFactory());
        Parent page = (Parent) loader.load(location.openStream());
        thisStage.getScene().setRoot(page);
        GestionPedidos tdCont = (GestionPedidos) loader.getController();
        tdCont.setStage(thisStage);
        tdCont.showStage();
    }

    public void modificarDesguace() throws IOException {
        if (DesguaceJava.validar(tfNombreDesguace.getText(), tfEmail.getText(), tfDireccion.getText(), tfCiudad.getText(), tfCp.getText(), tfTelefono.getText())) {
            System.out.println("Enviando...");
            if (DesguaceJava.modificarDatos(tfNombreDesguace.getText(), tfEmail.getText(), tfDireccion.getText(), tfCiudad.getText(), tfCp.getText(), tfTelefono.getText()))
                irAGestionPedidos();
        }
    }

}
