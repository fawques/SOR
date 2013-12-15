/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package BD;

import com.mysql.jdbc.PreparedStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author manu
 */


public class Conexion {

    Connection conexion;
    String database;
    
    /**
    * Constructor de clase utilizado para establecer la conexión con la base de datos
     * @param database nombre de la base de datos a la que conectar
    */
    public Conexion(String database) throws SQLException, ClassNotFoundException {
        this.database = database;
        try {
          Class.forName("com.mysql.jdbc.Driver");
          System.out.println("Conexion establecida");
          conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + database,"root","12345");
          System.out.println("Conexion establecida");
       } catch (SQLException ex) {
          ex.printStackTrace();
          //return false;
          throw ex;
       } catch (ClassNotFoundException ex) {
          ex.printStackTrace();
          //return false;
          throw ex;
       }
    }

    /**
    * Método utilizado para recuperar el valor del atributo conexion
    * @return conexion contiene el estado de la conexión
    *
    */
  
    
    public Connection getConexion()
    {
       return conexion;
    }

    /**
    *
    *Método utilizado para realizar las instrucciones: INSERT, DELETE y UPDATE
    *@param sql Cadena que contiene la instrucción SQL a ejecutar
    *@return estado regresa el estado de la ejecución, true(éxito) o false(error)
    *
    */
    public boolean ejecutarSQL(String sql)
    {
       try {
          Statement sentencia = conexion.createStatement();
          sentencia.executeUpdate(sql);
       } catch (SQLException ex) {
          ex.printStackTrace();
       return false;
       }

       return true;
    }

    /**
    *
    *Método utilizado para realizar la instrucción SELECT
    *@param sql Cadena que contiene la instrucción SQL a ejecutar
    *@return resultado regresa los registros generados por la consulta
    *
    */
    public ResultSet ejecutarSQLSelect(String sql)
    {
       ResultSet resultado;
       try {
          Statement sentencia = conexion.createStatement();
          resultado = sentencia.executeQuery(sql);
       } catch (SQLException ex) {
          ex.printStackTrace();
          return null;
       }

       return resultado;
    }
    
    public int ejecutarInsert(String sql)
    {
        int numero=-1;
        try {
            try (Statement stmt = conexion.createStatement()) {
                stmt.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS);
                ResultSet rs = stmt.getGeneratedKeys();
                if (rs.next()){
                    numero=rs.getInt(1);
                }else{
                    numero = 0;
                }
                rs.close();
            }
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return numero;
    }

    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        
    }
    
    
}
