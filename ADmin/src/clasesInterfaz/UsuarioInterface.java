/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package clasesInterfaz;

import general.Desguace;
import general.Taller;
import javafx.beans.property.*;


/**
 *
 * @author Cute
 */
public class UsuarioInterface {
    
    
    
    private final SimpleStringProperty ID;
    private final SimpleStringProperty nombreTaller;
    private final SimpleStringProperty email;
    private final SimpleStringProperty direccion;
    private final SimpleStringProperty ciudad;    
    private final SimpleIntegerProperty codigoPostal;
    private final SimpleIntegerProperty numeroTelefono;


    public UsuarioInterface(){
    ID= new SimpleStringProperty();
    nombreTaller=new SimpleStringProperty("");
    direccion=new SimpleStringProperty("");
    ciudad=new SimpleStringProperty("");
    email=new SimpleStringProperty("");
    codigoPostal=new SimpleIntegerProperty();
    numeroTelefono=new SimpleIntegerProperty();

    }
    
    /*public TallerInterface(int _ID,String _nombre,String _direccion,String _provincia,String _email,int _codigo,int _numero){
    crearTallerInterface(_ID, _nombre, _direccion, _provincia, _email, _codigo, _numero);
    }
    private void crearTallerInterface(int _ID, String _nombre, String _direccion, String _provincia, String _email, int _codigo, int _numero) {
    ID= new SimpleIntegerProperty(_ID);
    nombreTaller=new SimpleStringProperty(_nombre);
    direccion=new SimpleStringProperty(_direccion);
    ciudad=new SimpleStringProperty(_provincia);
    email=new SimpleStringProperty(_email);
    codigoPostal=new SimpleIntegerProperty(_codigo);
    numeroTelefono=new SimpleIntegerProperty(_numero);
    }
    public TallerInterface(Taller taller){
    crearTallerInterface(taller.getID(),taller.getName(), taller.getAddress(), taller.getCity(), taller.getEmail(),taller.getPostalCode(),taller.getTelephone());
    }*/

    public UsuarioInterface(String _ID, String _nombre, String _direccion, String _provincia, String _email, int _codigo, int _numero) {
     
        ID= new SimpleStringProperty(_ID);
        nombreTaller=new SimpleStringProperty(_nombre);
        direccion=new SimpleStringProperty(_direccion);
        ciudad=new SimpleStringProperty(_provincia);
        email=new SimpleStringProperty(_email);
        codigoPostal=new SimpleIntegerProperty(_codigo);
        numeroTelefono=new SimpleIntegerProperty(_numero);
    }
     public UsuarioInterface(Taller taller) {
         
        ID= new SimpleStringProperty(taller.getID());
        nombreTaller=new SimpleStringProperty(taller.getName());
        direccion=new SimpleStringProperty(taller.getAddress());
        ciudad=new SimpleStringProperty( taller.getCity());
        email=new SimpleStringProperty( taller.getEmail());
        codigoPostal=new SimpleIntegerProperty(taller.getPostalCode());
        numeroTelefono=new SimpleIntegerProperty(taller.getTelephone());
    }
     public UsuarioInterface(Desguace desguace) {
         
        ID= new SimpleStringProperty(desguace.getID());
        nombreTaller=new SimpleStringProperty(desguace.getName());
        direccion=new SimpleStringProperty(desguace.getAddress());
        ciudad=new SimpleStringProperty( desguace.getCity());
        email=new SimpleStringProperty( desguace.getEmail());
        codigoPostal=new SimpleIntegerProperty(desguace.getPostalCode());
        numeroTelefono=new SimpleIntegerProperty(desguace.getTelephone());
    }
    public String getID() {
        return ID.get();
    }

 

    public String getNombreTaller() {
        return nombreTaller.get();
    }



    public String getEmail() {
        return email.get();
    }



    public String getDireccion() {
        return direccion.get();
    }



    public String getCiudad() {
        return ciudad.get();
    }


    public int getCodigoPostal() {
        return codigoPostal.get();
    }



    public int getNumeroTelefono() {
        return numeroTelefono.get();
    }

    @Override
    public String toString() {
        return "TallerInterface{" + "ID=" + ID + ", nombreTaller=" + nombreTaller + ", email=" + email + ", direccion=" + direccion + ", ciudad=" + ciudad + ", codigoPostal=" + codigoPostal + ", numeroTelefono=" + numeroTelefono + '}';
    }
    
}

