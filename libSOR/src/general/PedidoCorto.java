/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package general;

/**
 *
 * @author Cute
 */
public class PedidoCorto {
     private String ID;
     private EstadoPedido estado;

    public PedidoCorto(String ID, EstadoPedido estado) {
        this.ID = ID;
        this.estado = estado;
    }
    public PedidoCorto(String ID,String estado){
        this.ID=ID;
        this.estado= EstadoPedido.values()[Integer.parseInt(estado)];
    }
    public PedidoCorto(){
        this.ID="";
        this.estado=null;
    }

    public PedidoCorto(PedidoCorto p){
    this.ID=p.getID();
    this.estado=p.getEstado();
    }
    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public EstadoPedido getEstado() {
        return estado;
    }

    public void setEstado(EstadoPedido estado) {
        this.estado = estado;
    }
     
}
