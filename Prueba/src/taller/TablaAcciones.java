package taller;

import javafx.beans.property.SimpleStringProperty;

public class TablaAcciones {
	
	SimpleStringProperty id;
	SimpleStringProperty json;
	
	public TablaAcciones(String id, String json) {
		this.id = new SimpleStringProperty(id);
		this.json = new SimpleStringProperty(json);
	}
	public String getId() {
		return id.get();
	}
	public void setId(String id) {
		this.id = new SimpleStringProperty(id);
	}
	public String getJson() {
		return json.get();
	}
	public void setJson(String json) {
		this.json =new SimpleStringProperty(json);
	}
	
}
