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
    SimpleStringProperty estado;
    SimpleStringProperty taller;
    SimpleStringProperty fecha_baja;
    SimpleStringProperty fecha_limite;

    public TablaPedidos(Pedido p) {
        this.id_aux = new SimpleIntegerProperty(p.getID_aux());
        this.id = new SimpleStringProperty(p.getID());
        this.fecha_alta = new SimpleStringProperty(p.getFecha_alta().toString());
        this.estado =new SimpleStringProperty(p.getEstado().toString());
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
        this.estado = new SimpleStringProperty("");
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

    public String getEstado() {
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



}
