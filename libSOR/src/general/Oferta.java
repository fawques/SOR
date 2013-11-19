/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package general;

import java.util.Date;

/**
 *
 * @author fawques
 */
public class Oferta {
    private int ID;
    private Date fecha_alta;
    private Date fecha_baja;
    private Date fecha_limite;
    private double precio;
    private int desguaceID;
    private int pedidoID;
    private EstadoOferta estado;

    public Oferta(int ID, Date fecha_alta, Date fecha_baja, Date fecha_limite, double precio, int desguaceID, int pedidoID) {
        this.ID = ID;
        this.fecha_alta = fecha_alta;
        this.fecha_baja = fecha_baja;
        this.fecha_limite = fecha_limite;
        this.precio = precio;
        this.desguaceID = desguaceID;
        this.pedidoID = pedidoID;
        this.estado = EstadoOferta.WAITING_ACCEPT;
    }

    // OJO, mirar si hace falta esto, es bastante peligroso!!
    public void setEstado(EstadoOferta estado) {
        this.estado = estado;
    }

    
    // ============ Getters ==========
    
    public int getID() {
        return ID;
    }

    public Date getFecha_alta() {
        return fecha_alta;
    }

    public Date getFecha_baja() {
        return fecha_baja;
    }

    public Date getFecha_limite() {
        return fecha_limite;
    }

    public double getPrecio() {
        return precio;
    }

    public int getDesguace() {
        return desguaceID;
    }

    public int getPedido() {
        return pedidoID;
    }

    public EstadoOferta getEstado() {
        return estado;
    }

    
    
    
}
