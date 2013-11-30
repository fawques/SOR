/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package BD;

import general.EstadoPedido;
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
    int contadorTaller;

    public InterfazBD(String database) throws SQLException, ClassNotFoundException {
        conexion = new Conexion(database);
        contadorTaller=1;
    }
    
    public ArrayList<Pedido> getPedidosActivos(){
        ArrayList<Pedido> lista= new ArrayList<>();
        try{
            ResultSet resultados = conexion.ejecutarSQLSelect("SELECT * FROM pedido;");
            while(resultados.next()){
                Pedido nuevo = new Pedido(resultados.getInt("id"), resultados.getInt("taller"), resultados.getDate("fecha_alta"), resultados.getDate("fecha_baja"), resultados.getDate("fecha_limite"),resultados.getObject("estado",EstadoPedido.class));
                lista.add(nuevo);
            }
        }catch(SQLException ex){
            ex.printStackTrace();
            return null;
        }
        return lista;
        
    }
    
    public int altaTaller(String nombre, String email, String direccion, String ciudad, int codPostal, int telefono, int estado){
        conexion.ejecutarSQL("insert into taller values ("+contadorTaller+",'"+nombre+"', '"+email+"','"+direccion+"','"+ciudad+"',"+codPostal+","+telefono+","+estado+");");
        contadorTaller++;
        return contadorTaller-1;
    }
    
}
