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
public class Pieza {
    private int ID;
    private String nombre;
    private EstadoPieza estado;
    private String descripcion;
    private Date fecha_baja;

    public Pieza(int ID, String nombre, EstadoPieza estado, String descripcion) {
        this.ID = ID;
        this.nombre = nombre;
        this.estado = estado;
        this.descripcion = descripcion;
    }

    public int getID() {
        return ID;
    }

    public String getNombre() {
        return nombre;
    }

    public EstadoPieza getEstado() {
        return estado;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public Date getFecha_baja() {
        return fecha_baja;
    }
    
}
