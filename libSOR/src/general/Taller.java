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

    public Taller(int ID,String name, String email, String address, String city, int postalCode, int telephone) {
        super(ID, name, email, address, city, postalCode, telephone);
        this.listaPedidos = new ArrayList<>();
    }

    @Override
    public String toString() {
        return "Taller{" + "name=" + name + ", email=" + email + ", address=" + address + ", city=" + city + ", postalCode=" + postalCode + ", telephone=" + telephone + '}';
    }
    
    public Pedido nuevoPedido(Date fecha_limite){
        Date ahora = new Date();
//TODO: Darle un ID de verdad, no el tiempo actual...
        Pedido nuevo = new Pedido((int)ahora.getTime(),ID , fecha_limite);
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
