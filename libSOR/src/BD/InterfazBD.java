/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BD;

import general.EstadoPedido;
import general.Pedido;
import general.Taller;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author fawques
 */
public class InterfazBD {

    Conexion conexion;

    public InterfazBD(String database) throws SQLException, ClassNotFoundException {
        conexion = new Conexion(database);
    }

    public ArrayList<Pedido> getPedidosActivos() {
        ArrayList<Pedido> lista = new ArrayList<>();
        try {
            ResultSet resultados = conexion.ejecutarSQLSelect("SELECT * FROM pedido;");
            while (resultados.next()) {
                Pedido nuevo = new Pedido(resultados.getInt("id"), resultados.getInt("taller"), resultados.getDate("fecha_alta"), resultados.getDate("fecha_baja"), resultados.getDate("fecha_limite"), resultados.getObject("estado", EstadoPedido.class));
                lista.add(nuevo);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }
        return lista;

    }

    public Taller getRegistroTaller() {
        ResultSet resultado = conexion.ejecutarSQLSelect("SELECT * FROM taller;");

        try {
            if (resultado.first()) {
                System.out.println("hola holita");
                return new Taller(resultado.getInt("id"), resultado.getString("nombre"), resultado.getString("email"), resultado.getString("direccion"), resultado.getString("ciudad"), resultado.getInt("codPostal"), resultado.getInt("telefono"));
            } else {
                System.out.println("hola que ase");
            }
            return null;
        } catch (SQLException ex) {
            Logger.getLogger(InterfazBD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public int altaTaller(String nombre, String email, String direccion, String ciudad, int codPostal, int telefono, int estado) {
        return conexion.ejecutarInsert("insert into taller (nombre, email, direccion, ciudad, codPostal, telefono, estado) values ('" + nombre + "', '" + email + "','" + direccion + "','" + ciudad + "'," + codPostal + "," + telefono + "," + estado + ");");
    }

    public int activarTaller(String email) {
        ResultSet res = conexion.ejecutarSQLSelect("SELECT id from taller where='" + email + "';");
        try {
            return res.getInt("id");
        } catch (SQLException ex) {
            Logger.getLogger(InterfazBD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }

}
