using System;
using System.Data;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using MySql.Data.MySqlClient;
using Connection = MySql.Data.MySqlClient.MySqlConnection;

namespace desguaceNET.libSOR.BD
{
    class Conexion
    {
        Connection conexion;
        string database;

        public Conexion(string database)
        {
            conexion = new MySqlConnection("server=localhost;user id=root;password=12345;database=sor_desguace;persistsecurityinfo=True;port=3306");
            Console.WriteLine("Conexion establecida");
        }

        public Connection getConexion()
        {
            return conexion;
        }

        public void closeConexion(){
            conexion.Close();
        }

        /**
        *
        *Método utilizado para realizar las instrucciones: INSERT, DELETE y UPDATE
        *@param sql Cadena que contiene la instrucción SQL a ejecutar
        *@return estado regresa el estado de la ejecución, true(éxito) o false(error)
        *
        */
        public bool ejecutarSQL(MySqlCommand sql)
        {
            try
            {
                conexion.Open();
                sql.Connection = conexion;
                return sql.ExecuteNonQuery() > 0;
            }catch(MySqlException ex){
                Console.WriteLine(ex.StackTrace);
                return false;
            }
            finally
            {
                closeConexion();
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
        public DataSet ejecutarSQLSelect(MySqlCommand sql)
        {
            DataSet resultado = new DataSet();
            try
            {
                conexion.Open();
                sql.Connection = conexion;
                MySqlDataAdapter adapter = new MySqlDataAdapter(sql);
                adapter.Fill(resultado);
            }
            catch (MySqlException ex)
            {
                Console.WriteLine(ex.StackTrace);
                return null;
            }
            finally
            {
                closeConexion();
            }

            return resultado;
        }

        /**
        *
        *Método utilizado para realizar las instrucciones: INSERT, DELETE y UPDATE
        *@param sql Cadena que contiene la instrucción SQL a ejecutar
        *@return estado regresa el estado de la ejecución, true(éxito) o false(error)
        *
        */
        public int ejecutarInsert(MySqlCommand sql)
        {
            int resultado = 0;
            try
            {
                conexion.Open();
                sql.Connection = conexion;
                sql.ExecuteNonQuery();
                resultado = (int)sql.LastInsertedId;
            }
            catch (MySqlException ex)
            {
                Console.WriteLine(ex.StackTrace);
                return -1;
            }
            finally
            {
                closeConexion();
            }
            return resultado;
        }
        
    }
}
