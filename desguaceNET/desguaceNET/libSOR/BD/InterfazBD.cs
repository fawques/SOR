using desguaceNET.libSOR.general;
using MySql.Data.MySqlClient;
using System;
using System.Collections.Generic;
using System.Data;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace desguaceNET.libSOR.BD
{
    class InterfazBD
    {
        Conexion conexion;
        public InterfazBD(string database)
        {
            database = "sor_desguace";
            conexion = new Conexion(database);
        }

        public int anadirOferta(DateTime fechaAlta, int estado, double importe, string pedido, string desguace, DateTime fechaBaja, DateTime fechaLimite)
        {
            return conexion.ejecutarInsert(new MySqlCommand("insert INTO oferta (id, fecha_alta, importe, estado, pedido, desguace, fecha_baja, fecha_limite) values ('', " + (fechaAlta != null ? "'" + fechaAlta.ToString("yyyy/MM/dd") + "'" : null) + ",'" + importe + "','" + estado + "','" + pedido + "','" + desguace + "'," + (fechaBaja != null ? "'" + fechaBaja.ToString("yyyy/MM/dd") + "'" : null) + "," + (fechaLimite != null ? "'" + fechaLimite.ToString("yyyy/MM/dd") + "'" : null) + ");"));
        }

        public int anadirDesguace(int id, string nombre, string email, string direccion, string ciudad, int codPostal, int telefono, int estado)
        {
            return conexion.ejecutarInsert(new MySqlCommand("insert INTO desguace (id, nombre, email, direccion, ciudad, codPostal, telefono, estado) values ('" + id + "','" + nombre + "', '" + email + "','" + direccion + "','" + ciudad + "','" + codPostal + "','" + telefono + "','" + estado + "');"));
        }

        // getters
        public List<Oferta> getOfertas()
        {
            List<Oferta> lista= new List<Oferta>();
            try{
                DataSet resultados = conexion.ejecutarSQLSelect(new MySqlCommand("SELECT * FROM oferta;"));
                DataTableReader reader = resultados.CreateDataReader();
                while(reader.Read()){
                    Oferta nuevo = new Oferta(reader.GetString(1), reader.GetInt32(0), reader.GetDouble(3), reader.GetString(6), reader.GetString(5),reader.GetDateTime(2), reader.GetDateTime(7), reader.GetDateTime(8), (EstadoOferta)reader.GetInt32(4));
                    lista.Add(nuevo);
                }
            }catch(MySqlException ex){
                Console.WriteLine(ex.StackTrace);
                return null;
            }
            return lista;    
        }

        public List<Pedido> getPedidosConID_aux(EstadoPedido estado) {
        List<Pedido> lista = new List<Pedido>();
        try {
            DataSet resultados = conexion.ejecutarSQLSelect(new MySqlCommand("SELECT * FROM pedido where estado='" + (int)estado + "'"));
            DataTableReader reader = resultados.CreateDataReader();
                while(reader.Read()){
                string pedidoID = reader.GetString(1);
                List<Pieza> piezas = new List<Pieza>();
                List<int> cantidades = new List<int>();
                getPiezasYCantidades(pedidoID, piezas, cantidades);

                Pedido nuevo = new Pedido(pedidoID, reader.GetInt32(0), reader.GetString(4), reader.GetDateTime(2), reader.GetDateTime(5), reader.GetDateTime(6), (EstadoPedido)reader.GetInt32(3), reader.GetBoolean(7), piezas, cantidades, getOfertasPedido(pedidoID));
                lista.Add(nuevo);
           }
        } catch (MySqlException ex) {
            Console.WriteLine(ex.StackTrace);
            return null;
        }
        return lista;

    }
        public List<Oferta> getOfertasConID_aux(EstadoOferta estado)
        {
            List<Oferta> lista = new List<Oferta>();
            try
            {
                DataSet resultados = conexion.ejecutarSQLSelect(new MySqlCommand("SELECT * FROM oferta where estado='" + (int)estado + "'"));
                DataTableReader reader = resultados.CreateDataReader();
                while(reader.Read()){
                    string ofertaID = reader.GetString(1);


                    Oferta nuevo = new Oferta(ofertaID, reader.GetInt32(0), reader.GetDouble(3), reader.GetString(6), reader.GetString(5), reader.GetDateTime(2), reader.GetDateTime(7), reader.GetDateTime(8), (EstadoOferta)reader.GetInt32(4));
                    lista.Add(nuevo);
                }
            }
            catch (MySqlException ex)
            {
                Console.WriteLine(ex.StackTrace);
                return null;
            }
            return lista;

        }

        public Pedido getPedido(string id)
    {
        Pedido pedido = null;
        try{
            DataSet resultados = conexion.ejecutarSQLSelect(new MySqlCommand("SELECT * FROM pedido where id ='"+id+"';"));
            DataTableReader reader = resultados.CreateDataReader();while(reader.Read()){
                List<Pieza> piezas =new List<Pieza>();
        
                List<int> cantidades = new List<int>();
                getPiezasYCantidades(id, piezas, cantidades);

                pedido = new Pedido(reader.GetString(1), reader.GetString(4), reader.GetDateTime(2), reader.GetDateTime(5), reader.GetDateTime(6), (EstadoPedido)reader.GetInt32(3), reader.GetBoolean(7), piezas, cantidades, getOfertasPedido(id));

            }
        }catch(MySqlException ex){
            Console.WriteLine(ex.StackTrace);
            return null;
        }
        return pedido;
    }

        public void getPiezasYCantidades(string pedidoID, List<Pieza> piezas, List<int> cantidades)
        {
            try
            {
                DataSet resultados = conexion.ejecutarSQLSelect(new MySqlCommand("SELECT * FROM pedido_pieza WHERE pedido='" + pedidoID + "';"));
                DataTableReader reader = resultados.CreateDataReader();
                while(reader.Read()){
                    piezas.Add(new Pieza(reader.GetString(1)));
                    cantidades.Add(reader.GetInt32(2));
                }
            }
            catch (MySqlException ex)
            {
                Console.WriteLine(ex.StackTrace);
                //return null;
            }
        }

         public List<Pieza> getPiezasPedido(string pedidoID){
        List<Pieza> lista = new List<Pieza>();
        try{
            DataSet resultados = conexion.ejecutarSQLSelect(new MySqlCommand("SELECT * FROM pedido_pieza WHERE pedido='" + pedidoID + "';"));
            DataTableReader reader = resultados.CreateDataReader();
            while(reader.Read()){
                Pieza nueva = new Pieza(reader.GetString(1));
                lista.Add(nueva);
            }
        } catch (MySqlException ex) {
            Console.WriteLine(ex.StackTrace);
            return null;
        }
        return lista;

    }

    public List<Oferta> getOfertasDesguace(string desguaceID){
        List<Oferta> lista = new List<Oferta>();
        try{
            DataSet resultados = conexion.ejecutarSQLSelect(new MySqlCommand("SELECT * FROM oferta WHERE desguace='" + desguaceID + "';"));
            DataTableReader reader = resultados.CreateDataReader(); while(reader.Read()){
                Oferta nueva = new Oferta(reader.GetString(1),  reader.GetDouble(3), reader.GetString(6), reader.GetString(5),reader.GetDateTime(2), reader.GetDateTime(7), reader.GetDateTime(8), (EstadoOferta)reader.GetInt32(4));
                lista.Add(nueva);
            }
        }catch(MySqlException ex){
            Console.WriteLine(ex.StackTrace);
            return null;
        }
        return lista;
        
    }
        
    public List<Oferta> getOfertasPedido(string pedidoID){
        List<Oferta> lista = new List<Oferta>();
        try{
            DataSet resultados = conexion.ejecutarSQLSelect(new MySqlCommand("SELECT * FROM oferta WHERE pedido='" + pedidoID + "';"));
            Oferta nueva;
            DataTableReader reader = resultados.CreateDataReader();
            while(reader.Read()){
                nueva = new Oferta(reader.GetString(1), reader.GetDouble(3), reader.GetString(6), reader.GetString(5), reader.GetDateTime(2), reader.GetDateTime(7), reader.GetDateTime(8), (EstadoOferta)reader.GetInt32(4));

                lista.Add(nueva);
            }
        } catch (MySqlException ex) {
            Console.WriteLine(ex.StackTrace);
            return null;
        }
        return lista;

    }

    public List<Oferta> getOfertasPedido(string pedidoID, EstadoOferta estado) {
        List<Oferta> lista = new List<Oferta>();
        try {
            DataSet resultados = conexion.ejecutarSQLSelect(new MySqlCommand("SELECT * FROM oferta WHERE pedido='" + pedidoID + "' and estado='" + (int)estado + "';"));
            Oferta nueva;
            DataTableReader reader = resultados.CreateDataReader();
            while(reader.Read()){
                nueva = new Oferta(reader.GetString(1), reader.GetDouble(3), reader.GetString(6), reader.GetString(5), reader.GetDateTime(2), reader.GetDateTime(7), reader.GetDateTime(8), (EstadoOferta)reader.GetInt32(4));

                lista.Add(nueva);
            }
        } catch (MySqlException ex) {
            Console.WriteLine(ex.StackTrace);
            return null;
        }
        return lista;

    }
     public Desguace getDesguace(){
        DataSet resultados = conexion.ejecutarSQLSelect(new MySqlCommand("SELECT * FROM desguace"));
        try {
            DataTableReader reader = resultados.CreateDataReader();
            if (reader.NextResult()) {
                string tallerID = reader.GetString(1);
                if(tallerID == ""){
                     return  new Desguace(reader.GetString(1), reader.GetString(2), reader.GetString(3), reader.GetString(4), reader.GetString(5),reader.GetInt32(6),reader.GetInt32(7),(EstadoGeneral)reader.GetInt32(8) ,null);
                }else{
                    List<Oferta> listaOfertas = getOfertasDesguace(reader.GetString(1));
                return  new Desguace(reader.GetString(1), reader.GetString(2), reader.GetString(3), reader.GetString(4), reader.GetString(5),reader.GetInt32(6),reader.GetInt32(7),(EstadoGeneral)reader.GetInt32(8) ,listaOfertas);
                }
                
            }

        } catch (MySqlException ex) {
            Console.WriteLine(ex.StackTrace);
        }
        return null;
     }
     public Desguace getDesguace(string email){
        DataSet resultados = conexion.ejecutarSQLSelect(new MySqlCommand("SELECT * FROM desguace WHERE email='" + email + "';"));
        try {
            DataTableReader reader = resultados.CreateDataReader();
            if (reader.NextResult())
            {
                string tallerID = reader.GetString(1);
                if (tallerID == "")
                {
                     return  new Desguace(reader.GetString(1), reader.GetString(2), reader.GetString(3), reader.GetString(4), reader.GetString(5),reader.GetInt32(6),reader.GetInt32(7),(EstadoGeneral)reader.GetInt32(8) ,null);
                }else{
                    List<Oferta> listaOfertas = getOfertasDesguace(reader.GetString(1));
                return  new Desguace(reader.GetString(1), reader.GetString(2), reader.GetString(3), reader.GetString(4), reader.GetString(5),reader.GetInt32(6),reader.GetInt32(7),(EstadoGeneral)reader.GetInt32(8) ,listaOfertas);
                }
                
            }

        } catch (MySqlException ex) {
            Console.WriteLine(ex.StackTrace);
        }
        return null;
     }


    // método que llaman talleres y desguaces, sin id (lo autogenera la bd)
    public int altaDesguace(string nombre, string email, string direccion, string ciudad, int codPostal, int telefono, int estado) {
        return conexion.ejecutarInsert(new MySqlCommand("insert into desguace (nombre, email, direccion, ciudad, codPostal, telefono, estado) values ('" + nombre + "', '" + email + "','" + direccion + "','" + ciudad + "'," + codPostal + "," + telefono + "," + estado + ");"));
    }

    public string getMD5IdDesguace(string email) {
        DataSet res = conexion.ejecutarSQLSelect(new MySqlCommand("SELECT id from desguace where email='" + email + "';"));
        try {
            DataTableReader reader = res.CreateDataReader();
            if (reader.NextResult())
            {
                return reader.GetString(1);
            }
        } catch (MySqlException ex) {
            Console.WriteLine(ex.StackTrace);
        }
        return "ERROR";
    }
    
    public bool modificarDesguace(string ID, string nombre, string email, string direccion, string ciudad, int codPostal, int telefono, EstadoGeneral estado){
        return conexion.ejecutarSQL(new MySqlCommand("UPDATE `desguace` SET `nombre`='" + nombre + "', `email`='" + email + "', `direccion`='" + direccion + "', `ciudad`='" + ciudad + "', `codPostal`='" + codPostal + "', `telefono`='" + telefono + "', `estado`='" + (int)estado + "' WHERE `id`='" + ID + "';"));
    }

    }
}
