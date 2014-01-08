/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package clasesInterfaz;
import general.Pedido;
import javafx.beans.property.*;
/**
 *
 * @author Cute
 */
public class PedidosInterfaz {

    public PedidosInterfaz() {
        this.ID= new SimpleStringProperty();
        this.idTaller= new SimpleStringProperty();
        this.fecha_alta=new SimpleStringProperty("");
        this.fecha_baja=new SimpleStringProperty("");
        this.fecha_limite=new SimpleStringProperty("");
    }
     public PedidosInterfaz(String _ID,String _Idtaller,String fecha_alta, String fecha_baja,String fecha_limite) {
        this.ID= new SimpleStringProperty(_ID);
        this.idTaller= new SimpleStringProperty(_Idtaller);
        this.fecha_alta=new SimpleStringProperty(fecha_alta);
        this.fecha_baja=new SimpleStringProperty(fecha_baja);
        this.fecha_limite=new SimpleStringProperty(fecha_limite);
    }
    public PedidosInterfaz(Pedido pedido){
        this.ID= new SimpleStringProperty(pedido.getID());
        this.idTaller= new SimpleStringProperty(pedido.getTaller());
        this.fecha_alta=new SimpleStringProperty(pedido.getFecha_alta().toString());
        this.fecha_baja=new SimpleStringProperty(pedido.getFecha_baja().toString());
        this.fecha_limite=new SimpleStringProperty(pedido.getFecha_limite().toString());
    }
    private final SimpleStringProperty ID ;
    private final SimpleStringProperty idTaller;
    private final SimpleStringProperty fecha_alta;
    private final SimpleStringProperty fecha_baja;
    private final SimpleStringProperty fecha_limite;

    public String getID() {
        return ID.get();
    }

    public String getIdTaller() {
        return idTaller.get();
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
