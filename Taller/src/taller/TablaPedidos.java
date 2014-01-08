/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package taller;

import general.EstadoPedido;
import general.Pedido;
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

    public TablaPedidos(Pedido p) {
        this.id_aux = new SimpleIntegerProperty(p.getID_aux());
        this.id = new SimpleStringProperty(p.getID());
        this.fecha_alta = new SimpleObjectProperty<>(p.getFecha_alta());
        this.estado = new SimpleObjectProperty<>(p.getEstado());
        this.taller = new SimpleStringProperty(p.getTaller());
        this.fecha_baja = new SimpleObjectProperty<>(p.getFecha_baja());
        this.fecha_limite = new SimpleObjectProperty<>(p.getFecha_limite());
    }

    public int getId_aux() {
        return id_aux.get();
    }

    public String getId() {
        return id.get();
    }

    public Date getFecha_alta() {
        return fecha_alta.get();
    }

    public EstadoPedido getEstado() {
        return estado.get();
    }

    public String getTaller() {
        return taller.get();
    }

    public Date getFecha_baja() {
        return fecha_baja.get();
    }

    public Date getFecha_limite() {
        return fecha_limite.get();
    }

}
