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
        this.ID= new SimpleIntegerProperty();
        this.idTaller= new SimpleIntegerProperty();
        this.fecha_alta=new SimpleStringProperty("");
        this.fecha_baja=new SimpleStringProperty("");
        this.fecha_limite=new SimpleStringProperty("");
    }
     public PedidosInterfaz(int _ID,int _Idtaller,String fecha_alta, String fecha_baja,String fecha_limite) {
        this.ID= new SimpleIntegerProperty(_ID);
        this.idTaller= new SimpleIntegerProperty(_Idtaller);
        this.fecha_alta=new SimpleStringProperty(fecha_alta);
        this.fecha_baja=new SimpleStringProperty(fecha_baja);
        this.fecha_limite=new SimpleStringProperty(fecha_limite);
    }
    public PedidosInterfaz(Pedido pedido){
        this.ID= new SimpleIntegerProperty(pedido.getID());
        this.idTaller= new SimpleIntegerProperty(pedido.getTaller());
        this.fecha_alta=new SimpleStringProperty(pedido.getFecha_alta().toString());
        this.fecha_baja=new SimpleStringProperty(pedido.getFecha_baja().toString());
        this.fecha_limite=new SimpleStringProperty(pedido.getFecha_limite().toString());
    }
    private final SimpleIntegerProperty ID ;
    private final SimpleIntegerProperty idTaller;
    private final SimpleStringProperty fecha_alta;
    private final SimpleStringProperty fecha_baja;
    private final SimpleStringProperty fecha_limite;

    public int getID() {
        return ID.get();
    }

    public int getIdTaller() {
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
