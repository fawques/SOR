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
    private transient Taller taller;
    private Date fecha_alta;
    private Date fecha_baja;
    private Date fecha_limite;
    
    private ArrayList<Pieza> listaPiezas;
    private ArrayList<Integer> listaCantidadesPiezas;
    private ArrayList<Oferta> listaOfertas;

    public Pedido(int ID, Taller taller, Date fecha_alta, Date fecha_baja, Date fecha_limite) {
        this.ID = ID;
        //this.taller = taller;
        this.fecha_alta = fecha_alta;
        this.fecha_baja = fecha_baja;
        this.fecha_limite = fecha_limite;
        this.listaPiezas = new ArrayList<>();
        this.listaCantidadesPiezas = new ArrayList<>();
        this.listaOfertas = new ArrayList<>();
    }
    
    public boolean addPieza(Pieza pieza, Integer cantidad){
        listaPiezas.add(pieza);
        listaCantidadesPiezas.add(cantidad);
//TODO: habrá que mirar más cosas para devolver true/false o lo que sea
        return true;
    }

    public int getID() {
        return ID;
    }

    /*public Taller getTaller() {
        return taller;
    }*/

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
    
    
    
}
