/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package general;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author fawques
 */
public class Pedido {
    private int ID;
    private int tallerID;
    private Date fecha_alta;
    private Date fecha_baja;
    private Date fecha_limite;
    private EstadoPedido estado;
    
    private ArrayList<Pieza> listaPiezas;
    private ArrayList<Integer> listaCantidadesPiezas;
    private ArrayList<Oferta> listaOfertas;

    /**
     * Constructor para recrear el objeto desde la BD, con todos los campos
     * @param ID
     * @param tallerID
     * @param fecha_alta
     * @param fecha_baja
     * @param fecha_limite
     * @param estado
     * @param listaPiezas
     * @param listaCantidadesPiezas
     * @param listaOfertas
     */
    public Pedido(int ID, int tallerID, Date fecha_alta, Date fecha_baja, Date fecha_limite, EstadoPedido estado, ArrayList<Pieza> listaPiezas, ArrayList<Integer> listaCantidadesPiezas, ArrayList<Oferta> listaOfertas) {
        this.ID = ID;
        this.tallerID = tallerID;
        this.fecha_alta = fecha_alta;
        this.fecha_baja = fecha_baja;
        this.fecha_limite = fecha_limite;
        this.estado = estado;
        this.listaPiezas = listaPiezas;
        this.listaCantidadesPiezas = listaCantidadesPiezas;
        this.listaOfertas = listaOfertas;
    }

    
    
    /**
     * Constructor para pedidos nuevos. Se pone el estado a NO_OFFERS y la fecha_alta a la fecha actual
     * @param ID id del nuevo pedido
     * @param tallerID taller que hace el pedido
     * @param fecha_limite fecha límite para recibir ofertas de este pedido. Pasada esa fecha, el pedido se cancelará
     */
    public Pedido(int ID, int tallerID, Date fecha_limite) {
        this.ID = ID;
        this.tallerID = tallerID;
        this.fecha_alta = new Date();
        this.fecha_baja = null;
        this.fecha_limite = fecha_limite;
        this.listaPiezas = new ArrayList<>();
        this.listaCantidadesPiezas = new ArrayList<>();
        this.listaOfertas = new ArrayList<>();
        this.estado = EstadoPedido.NO_OFFERS;
    }
    public Pedido(Pedido p) {
        this.ID = p.ID;
        this.tallerID =p.tallerID;
        this.fecha_alta = p.fecha_alta;
        this.fecha_baja = p.fecha_baja;
        this.fecha_limite = p.fecha_limite;
        this.listaPiezas = p.listaPiezas;
        this.listaCantidadesPiezas = p.listaCantidadesPiezas;
        this.listaOfertas = p.listaOfertas;
        this.estado = p.estado;
    }
    
    public boolean addPieza(Pieza pieza, Integer cantidad){
        listaPiezas.add(pieza);
        listaCantidadesPiezas.add(cantidad);
//TODO: habrá que mirar más cosas para devolver true/false o lo que sea
        return true;
    }
    
    
    // ======== Getters ==========

    public int getID() {
        return ID;
    }

    public int getTaller() {
        return tallerID;
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

    public ArrayList<Pieza> getListaPiezas() {
        return listaPiezas;
    }

    public ArrayList<Integer> getListaCantidadesPiezas() {
        return listaCantidadesPiezas;
    }

    public ArrayList<Oferta> getListaOfertas() {
        return listaOfertas;
    }

    public EstadoPedido getEstado() {
        return estado;
    }
    
}
