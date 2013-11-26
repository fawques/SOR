/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package BD;

import general.Pedido;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author fawques
 */
public class InterfazBD {
    
    Conexion conexion;

    public InterfazBD(String database) throws SQLException, ClassNotFoundException {
        conexion = new Conexion(database);
    }
    
    public ArrayList<Pedido> getPedidosActivos(){
        ArrayList<Pedido> lista= new ArrayList<>();
        try{
            ResultSet resultados = conexion.ejecutarSQLSelect("SELECT * FROM pedido;");
            while(resultados.next()){
                // TODO: meter en la BD los campos de fecha_alta, baja y límite
                Pedido nuevo = new Pedido(resultados.getInt("id"), resultados.getInt("taller"), null, null, null);
                lista.add(nuevo);
            }
        }catch(SQLException ex){
            ex.printStackTrace();
            return null;
        }
        return lista;
        
    }
    
    
    
}
