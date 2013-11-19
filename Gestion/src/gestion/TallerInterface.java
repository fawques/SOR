/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package gestion;

import general.Taller;
import javafx.beans.property.*;


/**
 *
 * @author Cute
 */
public class TallerInterface {
    
    
    
    private SimpleIntegerProperty ID;
    private SimpleStringProperty nombreTaller;
    private SimpleStringProperty email;
    private SimpleStringProperty direccion;
    private SimpleStringProperty ciudad;    
    private SimpleIntegerProperty codigoPostal;
    private SimpleIntegerProperty numeroTelefono;
    private SimpleIntegerProperty estado;

    public TallerInterface(){
    ID= new SimpleIntegerProperty();
    nombreTaller=new SimpleStringProperty("");
    direccion=new SimpleStringProperty("");
    ciudad=new SimpleStringProperty("");
    email=new SimpleStringProperty("");
    codigoPostal=new SimpleIntegerProperty();
    numeroTelefono=new SimpleIntegerProperty();
    estado= new SimpleIntegerProperty();
    }
    
    public TallerInterface(int _ID,String _nombre,String _direccion,String _provincia,String _email,int _codigo,int _numero,int _estado){
        crearTallerInterface(_ID, _nombre, _direccion, _provincia, _email, _codigo, _numero,_estado);
    }

    private void crearTallerInterface(int _ID, String _nombre, String _direccion, String _provincia, String _email, int _codigo, int _numero,int _estado) {
        ID= new SimpleIntegerProperty(_ID);
        nombreTaller=new SimpleStringProperty(_nombre);
        direccion=new SimpleStringProperty(_direccion);
        ciudad=new SimpleStringProperty(_provincia);
        email=new SimpleStringProperty(_email);
        codigoPostal=new SimpleIntegerProperty(_codigo);
        numeroTelefono=new SimpleIntegerProperty(_numero);
        estado = new SimpleIntegerProperty(_estado);
    }


    public TallerInterface(Taller taller){
        crearTallerInterface(taller.getName(), taller.get, null, null, null, codigo, numero);
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
