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
    private String ID;
    private int ID_aux;
    private Date fecha_alta;
    private Date fecha_baja;
    private Date fecha_limite;
    private double precio;
    private String desguaceID;
    private String pedidoID;
    private EstadoOferta estado;
    private String desguaceNombre;

    /** Constructor para la base de datos.
     *
     * @param ID
     * @param ID_aux
     * @param precio
     * @param desguaceID
     * @param pedidoID
     * @param fecha_alta
     * @param fecha_baja
     * @param fecha_limite
     * @param estado
     */
    public Oferta(String ID, int ID_aux, double precio, String desguaceID, String desguaceNombre,String pedidoID, Date fecha_alta, Date fecha_baja, Date fecha_limite, EstadoOferta estado) {
        this.ID = ID;
        this.ID_aux = ID_aux;
        this.precio = precio;
        this.desguaceID = desguaceID;
        this.pedidoID = pedidoID;
        this.fecha_alta = fecha_alta;
        this.fecha_baja = fecha_baja;
        this.fecha_limite = fecha_limite;
        this.estado = estado;
        this.desguaceNombre=desguaceNombre;
    }

    /** Constructor para la base de datos sin id_aux.
     *  Pone id_aux a -1.
     *
     * @param ID
     * @param precio
     * @param desguaceID
     * @param pedidoID
     * @param fecha_alta
     * @param fecha_baja
     * @param fecha_limite
     * @param estado
     */
   /* public Oferta(String ID, double precio, String desguaceID, String desguaceNombre, String pedidoID, Date fecha_alta, Date fecha_baja, Date fecha_limite, EstadoOferta estado) {
        this.ID = ID;
        this.ID_aux = -1;
        this.precio = precio;
        this.desguaceID = desguaceID;
        this.pedidoID = pedidoID;
        this.fecha_alta = fecha_alta;
        this.fecha_baja = fecha_baja;
        this.fecha_limite = fecha_limite;
        this.estado = estado;
        this.desguaceNombre=desguaceNombre;
    }*/

    /**
     * Constructor para ofertas nuevos. Se pone el estado a NEW y la fecha_alta a la fecha actual.
     * @param ID_aux id del nuevo pedido 
     * @param precio 
     * @param desguaceID taller que hace el pedido
     * @param pedidoID
     * @param fecha_limite fecha límite para recibir ofertas de este pedido. Pasada esa fecha, el pedido se cancelará
     */
    /*public Oferta(int ID_aux, double precio, String desguaceID, String desguaceNombre,  String pedidoID, Date fecha_limite) {
        this.ID = "";
        this.ID_aux = ID_aux;
        this.precio = precio;
        this.desguaceID = desguaceID;
        this.fecha_alta = new Date();
        this.fecha_baja = null;
        this.pedidoID = pedidoID;
        this.fecha_limite = fecha_limite;
        this.estado = EstadoOferta.NEW;
        this.desguaceNombre=desguaceNombre;
    }*/
    
    /** Constructor de copia
     *
     * @param o oferta
     */
    public Oferta(Oferta o) {
        this.ID = o.ID;
        this.ID_aux = o.ID_aux;
        this.precio = o.precio;
        this.desguaceID =o.desguaceID;
        this.pedidoID =o.pedidoID;
        this.fecha_alta = o.fecha_alta;
        this.fecha_baja = o.fecha_baja;
        this.fecha_limite = o.fecha_limite;
        this.estado = o.estado;
        this.desguaceNombre=o.desguaceNombre;
    }


    // OJO, mirar si hace falta esto, es bastante peligroso!!
    public void setEstado(EstadoOferta estado) {
        this.estado = estado;
    }

    
    // ============ Getters ==========
    
    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public int getID_aux() {
        return ID_aux;
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

    public String getDesguace() {
        return desguaceID;
    }
    public String getDesguaceNombre() {
        return desguaceNombre;
    }
    public String getPedido() {
        return pedidoID;
    }

    public EstadoOferta getEstado() {
        return estado;
    }

    
    
    
}
