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
    private Desguace desguace;
    private Pedido pedido;

    public Oferta(int ID, Date fecha_alta, Date fecha_baja, Date fecha_limite, double precio, Desguace desguace, Pedido pedido) {
        this.ID = ID;
        this.fecha_alta = fecha_alta;
        this.fecha_baja = fecha_baja;
        this.fecha_limite = fecha_limite;
        this.precio = precio;
        this.desguace = desguace;
        this.pedido = pedido;
    }

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

    public Desguace getDesguace() {
        return desguace;
    }

    public Pedido getPedido() {
        return pedido;
    }

    
    
    
}
