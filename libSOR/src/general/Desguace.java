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
public class Desguace extends Usuario{
    
    
    private ArrayList<Oferta> listaOfertas;

    public Desguace(int ID,String name, String email, String address, String city, int postalCode, int telephone) {
        super(ID, name, email, address, city, postalCode, telephone);
       
        listaOfertas = new ArrayList<>();
    }

    public Oferta nuevaOferta(Date fecha_alta, Date fecha_baja, Date fecha_limite, double precio, int pedidoID){
        Date ahora = new Date();
//TODO: Darle un ID de verdad, no el tiempo actual...
        Oferta nueva = new Oferta((int)ahora.getTime(),fecha_alta, fecha_baja, fecha_limite, precio, ID,pedidoID);
        listaOfertas.add(nueva);
        return nueva;
    }
    
    // OJO: ver rechazarOferta en Pedido también
    public boolean cancelarOferta(Oferta oferta){
        oferta.setEstado(EstadoOferta.CANCELLED);
        return true;
    }
    
    // ======== Getters =======
    

    public ArrayList<Oferta> getListaOfertas() {
        return listaOfertas;
    }
    
}
