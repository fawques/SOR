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
public class Taller {
    public String name;
    public String email;
    public String address;
    public String city;
    public int postalCode;
    public int telephone;

    public Taller(String name, String email, String address, String city, int postalCode, int telephone) {
        this.name = name;
        this.email = email;
        this.address = address;
        this.city = city;
        this.postalCode = postalCode;
        this.telephone = telephone;
    }

    @Override
    public String toString() {
        return "Taller{" + "name=" + name + ", email=" + email + ", address=" + address + ", city=" + city + ", postalCode=" + postalCode + ", telephone=" + telephone + '}';
    }
    
    
    
}
