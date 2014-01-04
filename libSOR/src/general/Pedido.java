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
    private String ID;
    private int ID_aux;
    private String tallerID;
    private Date fecha_alta;
    private Date fecha_baja;
    private Date fecha_limite;
    private EstadoPedido estado;
    
    private ArrayList<Pieza> listaPiezas;
    private ArrayList<Integer> listaCantidadesPiezas;
    private ArrayList<Oferta> listaOfertas;

    /** Constructor para la base de datos.
     *
     * @param ID
     * @param ID_aux
     * @param tallerID
     * @param fecha_alta
     * @param fecha_baja
     * @param fecha_limite
     * @param estado
     * @param listaPiezas
     * @param listaCantidadesPiezas
     * @param listaOfertas
     */
    public Pedido(String ID, int ID_aux, String tallerID, Date fecha_alta, Date fecha_baja, Date fecha_limite, EstadoPedido estado, ArrayList<Pieza> listaPiezas, ArrayList<Integer> listaCantidadesPiezas, ArrayList<Oferta> listaOfertas) {
        this.ID = ID;
        this.ID_aux = ID_aux;
        this.tallerID = tallerID;
        this.fecha_alta = fecha_alta;
        this.fecha_baja = fecha_baja;
        this.fecha_limite = fecha_limite;
        this.estado = estado;
        this.listaPiezas = listaPiezas;
        this.listaCantidadesPiezas = listaCantidadesPiezas;
        this.listaOfertas = listaOfertas;
    }

    /** Constructor para la base de datos sin id_aux.
     *  Pone id_aux a -1.
     *
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
    public Pedido(String ID, String tallerID, Date fecha_alta, Date fecha_baja, Date fecha_limite, EstadoPedido estado, ArrayList<Pieza> listaPiezas, ArrayList<Integer> listaCantidadesPiezas, ArrayList<Oferta> listaOfertas) {
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
     * Constructor para pedidos nuevos. Se pone el estado a NO_OFFERS y la fecha_alta a la fecha actual.
     * No tiene piezas, en principio, habrá que añadirlas
     * @param ID_aux id del nuevo pedido 
     * @param tallerID taller que hace el pedido
     * @param fecha_limite fecha límite para recibir ofertas de este pedido. Pasada esa fecha, el pedido se cancelará
     */
    public Pedido(int ID_aux, String tallerID, Date fecha_limite) {
        this.ID = "";
        this.ID_aux = ID_aux;
        this.tallerID = tallerID;
        this.fecha_alta = new Date();
        this.fecha_baja = null;
        this.fecha_limite = fecha_limite;
        this.listaPiezas = new ArrayList<>();
        this.listaCantidadesPiezas = new ArrayList<>();
        this.listaOfertas = new ArrayList<>();
        this.estado = EstadoPedido.NO_OFFERS;
    }
    
    /** Constructor de copia
     *
     * @param p pedido
     */
    public Pedido(Pedido p) {
        this.ID = p.ID;
        this.ID_aux = p.ID_aux;
        this.tallerID =p.tallerID;
        this.fecha_alta = p.fecha_alta;
        this.fecha_baja = p.fecha_baja;
        this.fecha_limite = p.fecha_limite;
        this.listaPiezas =new ArrayList<>( p.listaPiezas);
        this.listaCantidadesPiezas =new ArrayList<>(p.listaCantidadesPiezas) ;
        this.listaOfertas =new ArrayList<>( p.listaOfertas);
        this.estado = p.estado;
    }
    
    public boolean addPieza(Pieza pieza, Integer cantidad){
        listaPiezas.add(pieza);
        listaCantidadesPiezas.add(cantidad);
//TODO: habrá que mirar más cosas para devolver true/false o lo que sea
        return true;
    }
    
    
    // ======== Getters/Setters ==========

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public int getID_aux() {
        return ID_aux;
    }    

    public String getTaller() {
        return tallerID;
    }

    public Date getFecha_alta() {
        return fecha_alta;
    }

    public void setEstado(EstadoPedido estado) {
        this.estado = estado;
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
