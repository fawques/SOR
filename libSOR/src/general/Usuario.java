/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package general;

/**
 *
 * @author fawques
 */
public abstract class Usuario {
    protected int ID;
    protected String name;
    protected String email;
    protected String address;
    protected String city;
    protected int postalCode;
    protected int telephone;
    protected EstadoGeneral estado;

    public Usuario(int ID, String name, String email, String address, String city, int postalCode, int telephone) {
        this.ID = ID;
        this.name = name;
        this.email = email;
        this.address = address;
        this.city = city;
        this.postalCode = postalCode;
        this.telephone = telephone;
        this.estado = EstadoGeneral.ACTIVE;
    }

    public int getID() {
        return ID;
    }

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

    public EstadoGeneral getEstado() {
        return estado;
    }
    
    
}
