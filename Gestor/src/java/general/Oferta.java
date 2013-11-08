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
public class Oferta {
    private int ID;
    private Date fecha_alta;
    private Date fecha_baja;
    private Date fecha_limite;

    public Oferta(int ID, Date fecha_alta, Date fecha_limite) {
        this.ID = ID;
        this.fecha_alta = fecha_alta;
        this.fecha_limite = fecha_limite;
    }
    
    
}
