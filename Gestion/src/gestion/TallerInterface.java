/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package gestion;

import javafx.beans.property.*;


/**
 *
 * @author Cute
 */
public class TallerInterface {
    
    
    
    private final SimpleStringProperty nombreTaller;
    private final SimpleStringProperty nombreDuenyo;
    private final SimpleStringProperty direccion;
    private final SimpleStringProperty provincia;
    private final SimpleStringProperty email;
    private final SimpleIntegerProperty codigoPostal;
    private final SimpleIntegerProperty numeroTelefono;

    public TallerInterface(){
         nombreTaller= new SimpleStringProperty("");
    nombreDuenyo=new SimpleStringProperty("");
    direccion=new SimpleStringProperty("");
    provincia=new SimpleStringProperty("");
    email=new SimpleStringProperty("");
    codigoPostal=new SimpleIntegerProperty();
    numeroTelefono=new SimpleIntegerProperty();
    }
    
    public TallerInterface(String _nombre,String _duenyo,String _direccion,String _provincia,String _email,int codigo,int numero){
        
    nombreTaller= new SimpleStringProperty(_nombre);
    nombreDuenyo=new SimpleStringProperty(_duenyo);
    direccion=new SimpleStringProperty(_direccion);
    provincia=new SimpleStringProperty(_provincia);
    email=new SimpleStringProperty(_email);
    codigoPostal=new SimpleIntegerProperty(codigo);
    numeroTelefono=new SimpleIntegerProperty(numero);
    }
    public String getNombreTaller() {
        return nombreTaller.get();
    }

    public void setNombreTaller(String nombreTaller) {
        this.nombreTaller.set(nombreTaller);
    }

    public String getNombreDuenyo() {
        return nombreDuenyo.get();
    }

    public void setNombreDuenyo(String nombreDuenyo) {
        this.nombreDuenyo.set(nombreDuenyo);
    }

    public String getDireccion() {
        return direccion.get();
    }

    public void setDireccion(String direccion) {
        this.direccion.set(direccion);
    }

    public String getProvincia() {
        return provincia.get();
    }

    public void setProvincia(String provincia) {
        this.provincia.set(provincia);
    }

    public int getCodigoPostal() {
        return codigoPostal.get();
    }

    public void setCodigoPostal(int codigoPostal) {
        this.codigoPostal.set(codigoPostal);
    }

    public int getNumeroTelefono() {
        return numeroTelefono.get();
    }

    public void setNumeroTelefono(int numeroTelefono) {
        this.numeroTelefono.set(numeroTelefono);
    }
    public String getEmail() {
        return email.get();
    }

    public void setEmail(String email) {
        this.email.set(email);
    }
    @Override
    public String toString() {
        return "Taller{" + "nombreTaller=" + nombreTaller + ", nombreDuenyo=" + nombreDuenyo + ", direccion=" + direccion + ", provincia=" + provincia + ", codigoPostal=" + codigoPostal + ", numeroTelefono=" + numeroTelefono + '}';
    }




    
}
