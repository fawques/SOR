/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package taller;

import general.EstadoOferta;
import general.Oferta;
import java.util.Date;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author pablovm1990
 */
public class TablaOfertas {
    SimpleIntegerProperty id_aux;
    SimpleStringProperty id;
    SimpleObjectProperty<Date> fecha_alta;
    SimpleDoubleProperty importe;
    SimpleObjectProperty<EstadoOferta> estado;
    SimpleStringProperty pedido;
    SimpleStringProperty desguace;
    SimpleObjectProperty<Date> fecha_baja;
    SimpleObjectProperty<Date> fecha_limite;

    public TablaOfertas(SimpleIntegerProperty id_aux, SimpleStringProperty id, SimpleObjectProperty<Date> fecha_alta, SimpleDoubleProperty importe, SimpleObjectProperty<EstadoOferta> estado, SimpleStringProperty pedido, SimpleStringProperty desguace, SimpleObjectProperty<Date> fecha_baja, SimpleObjectProperty<Date> fecha_limite) {
        this.id_aux = id_aux;
        this.id = id;
        this.fecha_alta = fecha_alta;
        this.importe = importe;
        this.estado = estado;
        this.pedido = pedido;
        this.desguace = desguace;
        this.fecha_baja = fecha_baja;
        this.fecha_limite = fecha_limite;
    }

    TablaOfertas(Oferta of) {
        this.id_aux = new SimpleIntegerProperty(of.getID_aux());
        this.id = new SimpleStringProperty(of.getID());
        this.fecha_alta = new SimpleObjectProperty<>(of.getFecha_alta());
        this.importe = new SimpleDoubleProperty(of.getPrecio());
        this.estado = new SimpleObjectProperty<>(of.getEstado());
        this.pedido = new SimpleStringProperty(of.getPedido());
        this.desguace = new SimpleStringProperty(of.getDesguace());
        this.fecha_baja = new SimpleObjectProperty<>(of.getFecha_baja());
        this.fecha_limite = new SimpleObjectProperty<>(of.getFecha_limite());
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

    public SimpleDoubleProperty getImporte() {
        return importe;
    }

    public SimpleObjectProperty<EstadoOferta> getEstado() {
        return estado;
    }

    public SimpleStringProperty getPedido() {
        return pedido;
    }

    public SimpleStringProperty getDesguace() {
        return desguace;
    }

    public SimpleObjectProperty<Date> getFecha_baja() {
        return fecha_baja;
    }

    public SimpleObjectProperty<Date> getFecha_limite() {
        return fecha_limite;
    }

}
