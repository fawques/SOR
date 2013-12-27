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
public class UsuarioECommerce extends Usuario{

    /** Constructor para la base de datos en la parte de gestor.
     *  Rellena todos los datos de la clase, incluyendo id y lista de pedidos.
     *  id_aux se pondrá al valor de error (-1).
     *
     * @param ID
     * @param name
     * @param email
     * @param address
     * @param city
     * @param postalCode
     * @param telephone
     * @param estado
     * @param listaDePedidos
     */
    public UsuarioECommerce(String ID,String name, String email, String address, String city, int postalCode, int telephone, EstadoGeneral estado) {
        super(ID, -1, name, email, address, city, postalCode, telephone, estado);
    }
    
    
}
