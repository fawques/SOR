package taller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.fxml.JavaFXBuilderFactory;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class PermisosError implements Initializable {
    Stage thisStage;
    String mensajeError;
    public Label lbError;
    public void setStage(Stage stage) {
        thisStage = stage;
    }

    public void showStage() {
        thisStage.sizeToScene();
        thisStage.show();
    }
    public void setError(String error){
    	mensajeError=error;
    	
    	lbError.setText(mensajeError);
    }

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		
	}
    public void irAGestionPedidos() throws IOException {
        URL location = getClass().getResource("GestionPedidos.fxml");
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(location);
        loader.setBuilderFactory(new JavaFXBuilderFactory());
        Parent page = (Parent) loader.load(location.openStream());
        thisStage.getScene().setRoot(page);
        GestionPedidosController tdCont = (GestionPedidosController) loader.getController();
        tdCont.setStage(thisStage);
        tdCont.showStage();
    }
}
