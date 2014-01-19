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
    SimpleStringProperty fecha_alta;
    SimpleIntegerProperty estado;
    SimpleStringProperty taller;
    SimpleStringProperty fecha_baja;
    SimpleStringProperty fecha_limite;

    public TablaPedidos(Pedido p) {
        this.id_aux = new SimpleIntegerProperty(p.getID_aux());
        this.id = new SimpleStringProperty(p.getID());
        this.fecha_alta = new SimpleStringProperty(p.getFecha_alta().toString());
        this.estado = new SimpleIntegerProperty(p.getEstado().ordinal());
        this.taller = new SimpleStringProperty(p.getTaller());
        if(p.getFecha_baja()!=null){
            this.fecha_baja = new SimpleStringProperty(p.getFecha_baja().toString());
        }
        this.fecha_limite = new SimpleStringProperty(p.getFecha_limite().toString());
    }
       public TablaPedidos() {
        this.id_aux = new SimpleIntegerProperty();
        this.id = new SimpleStringProperty("");
        this.fecha_alta = new SimpleStringProperty("");
        this.estado = new SimpleIntegerProperty();
        this.taller = new SimpleStringProperty("");
        this.fecha_baja = new SimpleStringProperty("");
        this.fecha_limite = new SimpleStringProperty("");
    }

    public int getId_aux() {
        return id_aux.get();
    }

    public String getId() {
        return id.get();
    }

    public String getFecha_alta() {
        return fecha_alta.get();
    }

    public int getEstado() {
        return estado.get();
    }

    public String getTaller() {
        return taller.get();
    }

    public String getFecha_baja() {
        if(fecha_baja==null){
        return "";
        }
        return fecha_baja.get();
    }

    public String getFecha_limite() {
        return fecha_limite.get();
    }

    public void setId_aux(SimpleIntegerProperty id_aux) {
        this.id_aux = id_aux;
    }

    public void setId(SimpleStringProperty id) {
        this.id = id;
    }

    public void setFecha_alta(SimpleStringProperty fecha_alta) {
        this.fecha_alta =  fecha_alta;
    }

    public void setEstado(SimpleIntegerProperty estado) {
        this.estado = estado;
    }

    public void setTaller(SimpleStringProperty taller) {
        this.taller = taller;
    }

    public void setFecha_baja(SimpleStringProperty fecha_baja) {
        this.fecha_baja =fecha_baja;
    }

    public void setFecha_limite(SimpleStringProperty fecha_limite) {
        this.fecha_limite =  fecha_limite;
    }

}
