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

    /**
     * id proporcionado por el gestor. Tiene 32 caracteres. El valor de error es ""
     */
    protected String ID;

    /**
     * id auxiliar para taller o desguace. El valor de error es -1.
     */
    protected int ID_aux;
    protected String name;
    protected String email;
    protected String address;
    protected String city;
    protected int postalCode;
    protected int telephone;
    protected EstadoGeneral estado;

    public Usuario(String ID, int ID_aux, String name, String email, String address, String city, int postalCode, int telephone, EstadoGeneral estado) {
        this.ID = ID;
        this.ID_aux = ID_aux;
        this.name = name;
        this.email = email;
        this.address = address;
        this.city = city;
        this.postalCode = postalCode;
        this.telephone = telephone;
        this.estado = estado;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public int getID_aux() {
        return ID_aux;
    }

    public void setID_aux(int ID_aux) {
        this.ID_aux = ID_aux;
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
    
    public void activar(){
        this.estado = EstadoGeneral.ACTIVE;
    }
    
    public void baja(){
        this.estado = EstadoGeneral.INACTIVE;
    }
}
