/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package taller;

import general.EstadoPedido;
import java.util.Date;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author pablovm1990
 */
public class TablaPedidos {

    SimpleIntegerProperty id_aux;
    SimpleStringProperty id;
    SimpleObjectProperty<Date> fecha_alta;
    SimpleObjectProperty<EstadoPedido> estado;
    SimpleStringProperty taller;
    SimpleObjectProperty<Date> fecha_baja;
    SimpleObjectProperty<Date> fecha_limite;

    public TablaPedidos(SimpleIntegerProperty id_aux, SimpleStringProperty id, SimpleObjectProperty<Date> fecha_alta, SimpleObjectProperty<EstadoPedido> estado, SimpleStringProperty taller, SimpleObjectProperty<Date> fecha_baja, SimpleObjectProperty<Date> fecha_limite) {
        this.id_aux = id_aux;
        this.id = id;
        this.fecha_alta = fecha_alta;
        this.estado = estado;
        this.taller = taller;
        this.fecha_baja = fecha_baja;
        this.fecha_limite = fecha_limite;
    }

    public SimpleIntegerProperty getId_aux() {
        return id_aux;
    }

    public SimpleStringProperty getId() {
        return id;
    }

    public SimpleObjectProperty<Date> getFecha_alta() {
        return fecha_alta;
    }

    public SimpleObjectProperty<EstadoPedido> getEstado() {
        return estado;
    }

    public SimpleStringProperty getTaller() {
        return taller;
    }

    public SimpleObjectProperty<Date> getFecha_baja() {
        return fecha_baja;
    }

    public SimpleObjectProperty<Date> getFecha_limite() {
        return fecha_limite;
    }

}
