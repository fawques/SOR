/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package interfaz;

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
    SimpleStringProperty fecha_alta;
    SimpleStringProperty importe;
    SimpleStringProperty estado;
    SimpleStringProperty pedido;
    SimpleStringProperty desguace;
    SimpleStringProperty desguaceNombre;
    SimpleStringProperty fecha_baja;
    SimpleStringProperty fecha_limite;

   public TablaOfertas(Oferta of) {
        this.id_aux = new SimpleIntegerProperty(of.getID_aux());
        this.id = new SimpleStringProperty(of.getID());
        this.fecha_alta = new SimpleStringProperty(of.getFecha_alta().toString());
        this.importe = new SimpleStringProperty(Double.toString(of.getPrecio()));
        this.estado = new SimpleStringProperty(of.getEstado().toString());
        this.pedido = new SimpleStringProperty(of.getPedido());
        this.desguace = new SimpleStringProperty(of.getDesguace());
        this.desguaceNombre = new SimpleStringProperty(of.getDesguaceNombre());
        if(of.getFecha_baja()!=null){
            this.fecha_baja = new SimpleStringProperty(of.getFecha_baja().toString());
        }
        this.fecha_limite = new SimpleStringProperty(of.getFecha_limite().toString());
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

    public String getImporte() {
        return importe.get();
    }

    public String getEstado() {
        return estado.get();
    }

    public String getPedido() {
        return pedido.get();
    }

    public String getDesguace() {
        return desguace.get();
    }
    public String getDesguaceNombre() {
        return desguaceNombre.get();
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
