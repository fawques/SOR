/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package clasesInterfaz;



import general.Oferta;
import javafx.beans.property.*;
/**
 *
 * @author Cute
 */
public class OfertasInterfaz {

    public OfertasInterfaz() {
        this.ID= new SimpleStringProperty();
        this.idPedido = new SimpleStringProperty();
        this.idDesguace= new SimpleStringProperty();
        this.fecha_alta=new SimpleStringProperty("");
        this.fecha_baja=new SimpleStringProperty("");
        this.fecha_limite=new SimpleStringProperty("");
        this.precio = new SimpleDoubleProperty();
    }
     public OfertasInterfaz(String _ID,String _IdPedido,String _IdDesguace,String fecha_alta, String fecha_baja,String fecha_limite,Double _precio) {
        this.ID= new SimpleStringProperty(_ID);
        this.idPedido= new SimpleStringProperty(_IdPedido);
        this.idDesguace= new SimpleStringProperty(_IdDesguace);
        this.fecha_alta=new SimpleStringProperty(fecha_alta);
        this.fecha_baja=new SimpleStringProperty(fecha_baja);
        this.fecha_limite=new SimpleStringProperty(fecha_limite);
        this.precio= new SimpleDoubleProperty(_precio);
    }
    public OfertasInterfaz(Oferta oferta){
        this.ID= new SimpleStringProperty(oferta.getID());
        this.idPedido= new SimpleStringProperty(oferta.getPedido());
        this.idDesguace= new SimpleStringProperty(oferta.getDesguace());
        this.fecha_alta=new SimpleStringProperty(oferta.getFecha_alta().toString());
        this.fecha_baja=new SimpleStringProperty(oferta.getFecha_baja().toString());
        this.fecha_limite=new SimpleStringProperty(oferta.getFecha_limite().toString());
        this.precio= new SimpleDoubleProperty(oferta.getPrecio());
    }
    private final SimpleStringProperty ID ;
    private final SimpleStringProperty idPedido;
    private final SimpleStringProperty idDesguace;
    private final SimpleStringProperty fecha_alta;
    private final SimpleStringProperty fecha_baja;
    private final SimpleStringProperty fecha_limite;
    private final SimpleDoubleProperty precio;

    public double getPrecio(){
        return precio.get();
    }
    public String getID() {
        return ID.get();
    }
    public String getIdPedido(){
        return idPedido.get();
    }
    public String getIdDesguace() {
        return idDesguace.get();
    }

    public String getFecha_alta() {
        return fecha_alta.get();
    }

    public String getFecha_baja() {
        return fecha_baja.get();
    }

    public String getFecha_limite() {
        return fecha_limite.get();
    }
    
}


