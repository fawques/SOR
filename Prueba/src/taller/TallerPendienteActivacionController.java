/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package taller;

import BD.InterfazBD;



import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.fxml.JavaFXBuilderFactory;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressIndicator;
import javafx.stage.Stage;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author pablovm1990
 */
public class TallerPendienteActivacionController implements Initializable {

    Stage thisStage;
    InterfazBD bd;
    /**
     * Initializes the controller class.
     */
    @FXML
    public Button btRecargar;
    public ProgressIndicator piIndicador;
    public Label lbEstado;
    @FXML
    public TextField tfValidar;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        tfValidar.setEditable(true);
    }

    public void comprobarActivacion(){

        btRecargar.setDisable(true);
        lbEstado.setText("");
        piIndicador.setVisible(true);


    }
public void comprobarContrasenya() throws IOException, ClassNotFoundException, SQLException{
    bd = new InterfazBD("sor_taller");
    MainTaller.getTaller();
    String idRecibido =MainTaller.checkActivacion(MainTaller.taller.getEmail(),tfValidar.getText());
    if ("".equals(idRecibido)) //No Activado
    {
        lbEstado.setStyle("-fx-border-color: red;");
        lbEstado.setText("Su cuenta no esta activa o o ha copiado bien el código de activación");
    } else //Activado
    {
        //enviar a pantalla gestion de pedido
        System.out.println("He recibido " + idRecibido);

        if (!MainTaller.activarTallerBD(idRecibido)) {
            System.out.println(",pero no he podido updatear");
            lbEstado.setStyle("-fx-border-color: red;");
            lbEstado.setText("Su cuenta no ha podido activarse");
        } else {
        	MainTaller.getTaller();
        	MainTaller.nombreUsuario="Administrador";
        	MainTaller.ponerCodigoActivacionTaller(tfValidar.getText());
            URL location = getClass().getResource("GestionPedidos.fxml");
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(location);
            loader.setBuilderFactory(new JavaFXBuilderFactory());
            Parent page = (Parent) loader.load(location.openStream());
            thisStage.getScene().setRoot(page);
            thisStage.setTitle("Taller");
            GestionPedidosController staticDataBox = (GestionPedidosController) loader.getController();
            staticDataBox.setStage(thisStage);
            staticDataBox.showStage();
        }
    }
    bd.close();
    piIndicador.setVisible(false);
    btRecargar.setDisable(false);
}
    public void setStage(Stage stage) {
        thisStage = stage;
    }

    public void showStage() {
        thisStage.sizeToScene();
        thisStage.show();
    }
}
