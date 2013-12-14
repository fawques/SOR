/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package general;

import java.util.Date;

/**
 *
 * @author fawques
 */
public class Pieza {
    private String nombre;
    
    public Pieza(String nombre) {
        this.nombre = nombre;
    }

    
    // ======== Getters =========

    
    public String getNombre() {
        return nombre;
    }
}
