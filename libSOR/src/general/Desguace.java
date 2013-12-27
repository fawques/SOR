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

    
    /** Constructor para la base de datos en la parte de desguace o taller.
     *  Rellena todos los datos de la clase, incluyendo id, id_aux y lista de ofertas
     * 
     * @param ID 
     * @param ID_aux 
     * @param name
     * @param email
     * @param address
     * @param city
     * @param postalCode
     * @param telephone
     * @param estado
     * @param listaDeOfertas
     */
    public Desguace(String ID, int ID_aux ,String name, String email, String address, String city, int postalCode, int telephone, EstadoGeneral estado, ArrayList<Oferta> listaDeOfertas) {
        super(ID, ID_aux, name, email, address, city, postalCode, telephone, estado);
        this.listaOfertas = listaDeOfertas;
    }
    
    /** Constructor para la base de datos en la parte de gestor.
     *  Rellena todos los datos de la clase, incluyendo id y lista de ofertas.
     *  id_aux se pondrá al valor de error (-1).
     *
     * @param ID
     * @param name
     * @param email
     * @param address
     * @param city
     * @param postalCode
     * @param telephone
     * @param estado
     * @param listaDeOfertas
     */
    public Desguace(String ID,String name, String email, String address, String city, int postalCode, int telephone, EstadoGeneral estado, ArrayList<Oferta> listaDeOfertas) {
        super(ID, -1, name, email, address, city, postalCode, telephone, estado);
        this.listaOfertas = listaDeOfertas;
    }

    /*public Oferta nuevaOferta(Date fecha_alta, Date fecha_baja, Date fecha_limite, double precio, int pedidoID){
        Date ahora = new Date();
//TODO: Darle un ID de verdad, no el tiempo actual...
//Oferta(int ID, Date fecha_alta, Date fecha_baja, Date fecha_limite, double precio, int desguaceID, int pedidoID, EstadoOferta estado)
        //Oferta nueva = new Oferta((int)ahora.getTime(),fecha_alta, fecha_baja, fecha_limite, precio, ID,pedidoID);
        //Oferta nueva = new Oferta(pedidoID,fecha_alta,fecha_baja,fecha_limite,precio,)
        listaOfertas.add(nueva);
        return nueva;
    }*/
    
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
