package taller;

import Async.Accion;
import javafx.beans.property.SimpleStringProperty;

public class TablaAcciones {
	
	SimpleStringProperty id;
	

	public TablaAcciones(Accion accion){
		
		this.id= new SimpleStringProperty(accion.toString());
	}
	public String getId() {
		return id.get();
	}



	
}
