/**
 * 
 */
package altaDisponibilidad;

import java.io.IOException;
import java.net.URL;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.fxml.JavaFXBuilderFactory;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * @author pablovm1990
 *
 */
public class AltaDisponibilidad extends Application {
	
	public static Stage stage;

	@Override
	public void start(Stage stage2) throws Exception {
		// TODO Auto-generated method stub
		stage = stage2;
	}

	public static FXMLLoader changeScene(String fxml) throws IOException {
		URL location = AltaDisponibilidad.class.getResource(fxml);
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(location);
		loader.setBuilderFactory(new JavaFXBuilderFactory());
		Parent page = (Parent) loader.load(location.openStream());
		if (stage.getScene() == null) {
			Scene scene = new Scene(page);
			stage.setScene(scene);
		} else {
			stage.getScene().setRoot(page);
			stage.sizeToScene();
		}

		return loader;

	}
}
