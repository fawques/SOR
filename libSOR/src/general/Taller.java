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
public class Taller extends Usuario{
    
    
    private ArrayList<Pedido> listaPedidos;

    /** Constructor para la base de datos en la parte de desguace o taller.
     *  Rellena todos los datos de la clase, incluyendo id, id_aux y lista de pedidos
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
     * @param listaDePedidos
     */
    public Taller(String ID, int ID_aux ,String name, String email, String address, String city, int postalCode, int telephone, EstadoGeneral estado, ArrayList<Pedido> listaDePedidos) {
        super(ID, ID_aux, name, email, address, city, postalCode, telephone, estado);
        this.listaPedidos = listaDePedidos;
    }
    
    /** Constructor para la base de datos en la parte de gestor.
     *  Rellena todos los datos de la clase, incluyendo id y lista de pedidos.
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
     * @param listaDePedidos
     */
    public Taller(String ID,String name, String email, String address, String city, int postalCode, int telephone, EstadoGeneral estado, ArrayList<Pedido> listaDePedidos) {
        super(ID, -1, name, email, address, city, postalCode, telephone, estado);
        this.listaPedidos = listaDePedidos;
    }

   @Override
    public String toString() {
        return "Taller{" + "name=" + name + ", email=" + email + ", address=" + address + ", city=" + city + ", postalCode=" + postalCode + ", telephone=" + telephone + '}';
    }
    
    public Pedido nuevoPedido(Date fecha_limite, boolean modoAutomatico) {
        Date ahora = new Date();
        Pedido nuevo = new Pedido((int) ahora.getTime(), ID, fecha_limite, modoAutomatico);
        listaPedidos.add(nuevo);
        return nuevo;
    }
    
    // recibe una oferta o un id para rechazar, y busca ese id en todas las ofertas de su lista?
    public boolean rechazarOferta(Oferta oferta){
        oferta.setEstado(EstadoOferta.REJECTED);
        return true;
    }
    
    
    // ========== Getters ===========
    
    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getAddress() {
        return address;
    }

    public String getCity() {
        return city;
    }

    public int getPostalCode() {
        return postalCode;
    }

    public int getTelephone() {
        return telephone;
    }

    public ArrayList<Pedido> getListaPedidos() {
        return listaPedidos;
    }
    
    
}
