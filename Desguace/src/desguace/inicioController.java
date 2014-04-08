package desguace;

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

public class inicioController implements Initializable {

    Stage thisStage;
    InterfazBD bd;
    public TextField tfUsuario;
    public TextField tfContrasenya;
    public Button btEntrar;
    public Label lbEstado;
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}
	public void Entrar() throws IOException{
		Boolean aceptado=DesguaceJava.comprobarInicio(tfUsuario.getText(),tfContrasenya.getText());
		if(aceptado==false){
		            System.out.println(",pero no he podido updatear");
		            lbEstado.setStyle("-fx-border-color: red;");
		            lbEstado.setText("Su usuario o contraseña no son válidos");
		        } else {
		            URL location = getClass().getResource("GestionPedidos.fxml");
		            FXMLLoader loader = new FXMLLoader();
		            loader.setLocation(location);
		            loader.setBuilderFactory(new JavaFXBuilderFactory());
		            Parent page = (Parent) loader.load(location.openStream());
		            thisStage.getScene().setRoot(page);
		            thisStage.setTitle("Desguace");
		            GestionPedidos staticDataBox = (GestionPedidos) loader.getController();
		            staticDataBox.setStage(thisStage);
		            staticDataBox.showStage();
		        }
	}
    public void setStage(Stage stage) {
        thisStage = stage;
    }

    public void showStage() {
        thisStage.sizeToScene();
        thisStage.show();
    }
}