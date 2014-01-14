/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package interfaz;

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
       public TablaPedidos() {
        this.id_aux = new SimpleIntegerProperty();
        this.id = new SimpleStringProperty("");
        this.fecha_alta = new SimpleObjectProperty<>();
        this.estado = new SimpleObjectProperty<>();
        this.taller = new SimpleStringProperty("");
        this.fecha_baja = new SimpleObjectProperty<>();
        this.fecha_limite = new SimpleObjectProperty<>();
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

    public void setId_aux(SimpleIntegerProperty id_aux) {
        this.id_aux = id_aux;
    }

    public void setId(SimpleStringProperty id) {
        this.id = id;
    }

    public void setFecha_alta(SimpleObjectProperty<Date> fecha_alta) {
        this.fecha_alta = fecha_alta;
    }

    public void setEstado(SimpleObjectProperty<EstadoPedido> estado) {
        this.estado = estado;
    }

    public void setTaller(SimpleStringProperty taller) {
        this.taller = taller;
    }

    public void setFecha_baja(SimpleObjectProperty<Date> fecha_baja) {
        this.fecha_baja = fecha_baja;
    }

    public void setFecha_limite(SimpleObjectProperty<Date> fecha_limite) {
        this.fecha_limite = fecha_limite;
    }

}
