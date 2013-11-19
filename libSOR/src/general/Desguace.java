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
public class Desguace {
    private int ID;
    private String name;
    private String email;
    private String address;
    private String city;
    private int postalCode;
    private int telephone;
    private EstadoGeneral estado;
    
    private ArrayList<Oferta> listaOfertas;

    public Desguace(int ID,String name, String email, String address, String city, int postalCode, int telephone) {
       this.ID=ID;
        this.name = name;
        this.email = email;
        this.address = address;
        this.city = city;
        this.postalCode = postalCode;
        this.telephone = telephone;
        listaOfertas = new ArrayList<>();
        this.estado = EstadoGeneral.ACTIVE;
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

    public ArrayList<Oferta> getListaOfertas() {
        return listaOfertas;
    }
    
}
