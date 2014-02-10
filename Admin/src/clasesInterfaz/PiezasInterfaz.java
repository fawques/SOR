/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package clasesInterfaz;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author Cute
 */
public class PiezasInterfaz {
    private final SimpleIntegerProperty cant;
    private final SimpleStringProperty nombrePieza;

    public PiezasInterfaz(int cant, String nombrePieza) {
        this.cant = new SimpleIntegerProperty( cant);
        this.nombrePieza = new SimpleStringProperty( nombrePieza);
    }
    public PiezasInterfaz(){
        this.cant=new SimpleIntegerProperty();
        this.nombrePieza= new SimpleStringProperty("");
    }

    public Integer getCant() {
        return cant.get();
    }

    public String getNombrePieza() {
        return nombrePieza.get();
    }
    
}
