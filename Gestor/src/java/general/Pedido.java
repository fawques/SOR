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
    private Date fecha_alta;
    private Date fecha_baja;
    private Date fecha_limite;
    private ArrayList<Pieza> piezas;
    private ArrayList<Oferta> listaOfertas;

    public Pedido(int ID, Date fecha_alta, Date fecha_limite) {
        this.ID = ID;
        this.fecha_alta = fecha_alta;
        this.fecha_limite = fecha_limite;
        this.piezas = new ArrayList<>();
        this.listaOfertas = new ArrayList<>();
    }
    
    
    
}
