using desguaceNET.libSOR.general;
using MySql.Data.MySqlClient;
using System;
using System.Collections.Generic;
using System.Data;
using System.Globalization;
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
        public int anadirOferta(DateTime fechaAlta, int estado, double importe, String pedido, String desguace, String desguaceNombre, DateTime fechaBaja, DateTime fechaLimite)
        {
            return conexion.ejecutarInsert(new MySqlCommand("insert INTO oferta (id, fecha_alta, importe, estado, pedido, desguace, desguaceNombre,fecha_baja, fecha_limite) values ('', " + (fechaAlta != null ? "'" + fechaAlta.ToString("yyyy/MM/dd") + "'" : null) + ",'" + importe.ToString("G", new CultureInfo("en-US")) + "','" + estado + "','" + pedido + "','" + desguace + "','" + desguaceNombre + "'," + (fechaBaja != null ? "'" + fechaBaja.ToString("yyyy/MM/dd") + "'" : null) + "," + (fechaLimite != null ? "'" + fechaLimite.ToString("yyyy/MM/dd") + "'" : null) + ");"));
        }

        public void anadirPedido(string id, DateTime fechaAlta, int estado, string taller, String tallerNombre, DateTime fechaBaja, DateTime fechaLimite, bool modoAutomatico)
        {
            conexion.ejecutarSQL(new MySqlCommand("insert INTO pedido (id, fecha_alta, estado, taller, tallerNombre, fecha_baja, fecha_limite, modo_automatico) values ('" + id + "'," + (fechaAlta != null ? "'" + fechaAlta.ToString("yyyy/MM/dd") + "'" : null) + ",'" + estado + "','" + taller + "','" + tallerNombre + "'," + (fechaBaja != null ? "'" + fechaBaja.ToString("yyyy/MM/dd") + "'" : null) + "," + (fechaLimite != null ? "'" + fechaLimite.ToString("yyyy/MM/dd") + "'" : null) + ", '" + (modoAutomatico ? 1 : 0) + "');"));
        }

        public int anadirPedido(DateTime fechaAlta, EstadoPedido estado, string taller, string tallerNombre, DateTime fechaBaja, DateTime fechaLimite, bool modoAutomatico)
        {
            return conexion.ejecutarInsert(new MySqlCommand("insert INTO pedido (id, fecha_alta, estado, taller,tallerNombre, fecha_limite, modo_automatico) values ('', " + (fechaAlta != null ? "'" + fechaAlta.ToString("yyyy/MM/dd") + "'" : null) + ",'" + (int)estado + "','" + taller + "','" + tallerNombre + "'," + (fechaLimite != null ? "'" + fechaLimite.ToString("yyyy/MM/dd") + "'" : null) + ", '" + (modoAutomatico ? 1 : 0) + "');"));
        }

        public int anadirPedido(Pedido p)
        {
            int id = conexion.ejecutarInsert(new MySqlCommand("insert INTO pedido (id,fecha_alta, estado, taller, tallerNombre, fecha_limite, fecha_baja, modo_automatico) values ('" + p.ID + "', '" + p.fecha_alta.ToString("yyyy/MM/dd") + "','" + (int)p.estado + "','" + p.tallerID + "','" + p.tallerNombre + "','" + p.fecha_limite.ToString("yyyy/MM/dd") + "', '" + p.getFecha_baja().ToString("yyyy/MM/dd") + "', '" + (p.modoAutomatico ? 1 : 0) + "');"));
            anyadirPiezasAPedido(id, p.listaPiezas, p.listaCantidadesPiezas);
            return id;
        }

        public int anadirDesguace(int id, string nombre, string email, string direccion, string ciudad, int codPostal, int telefono, int estado)
        {
            return conexion.ejecutarInsert(new MySqlCommand("insert INTO desguace (id, nombre, email, direccion, ciudad, codPostal, telefono, estado) values ('" + id + "','" + nombre + "', '" + email + "','" + direccion + "','" + ciudad + "','" + codPostal + "','" + telefono + "','" + estado + "');"));
        }

        // getters
        public List<Oferta> getOfertas()
        {
            List<Oferta> lista = new List<Oferta>();
            try
            {
                DataSet resultados = conexion.ejecutarSQLSelect(new MySqlCommand("SELECT * FROM oferta;"));
                DataTableReader reader = resultados.CreateDataReader();
                while (reader.Read())
                {
                    Oferta nuevo = new Oferta(reader.GetString(1), reader.GetInt32(0), reader.GetDouble(3), reader.GetString(6), (string)reader["desguaceNombre"], reader.GetString(5), reader.GetDateTime(2), reader.GetDateTime(7), reader.GetDateTime(8), (EstadoOferta)reader.GetInt32(4));
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

        public List<Pedido> getPedidosConID_aux()
        { //devuelve pedidos en general
            List<Pedido> lista = new List<Pedido>();
            try
            {
                DataSet resultados = conexion.ejecutarSQLSelect(new MySqlCommand("SELECT * FROM pedido;"));
                DataTableReader reader = resultados.CreateDataReader();
                while (reader.Read())
                {
                    int pedidoID_aux = (int)reader["id_aux"];
                    string pedidoID = (string)reader["id"];
                    List<Pieza> piezas = new List<Pieza>();
                    List<int> cantidades = new List<int>();
                    getPiezasYCantidades(pedidoID_aux, piezas, cantidades);

                    Pedido nuevo = new Pedido(pedidoID, (int)reader["id_aux"], (string)reader["taller"], (string)reader["tallerNombre"], reader.GetDateTime(2), reader.GetDateTime(5), reader.GetDateTime(6), (EstadoPedido)reader.GetInt32(3), (sbyte)reader["modo_automatico"] != 0, piezas, cantidades, getOfertasPedido(pedidoID));
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

        public List<Pedido> getPedidosConID_aux(EstadoPedido estado)
        {
            List<Pedido> lista = new List<Pedido>();
            try
            {
                DataSet resultados = conexion.ejecutarSQLSelect(new MySqlCommand("SELECT * FROM pedido where estado='" + (int)estado + "'"));
                DataTableReader reader = resultados.CreateDataReader();
                while (reader.Read())
                {
                    string pedidoID = reader.GetString(1);
                    List<Pieza> piezas = new List<Pieza>();
                    List<int> cantidades = new List<int>();
                    getPiezasYCantidades((int)reader["id_aux"], piezas, cantidades);

                    Pedido nuevo = new Pedido(pedidoID, reader.GetInt32(0), (string)reader["taller"], (string)reader["tallerNombre"], reader.GetDateTime(2), reader.GetDateTime(5), reader.GetDateTime(6), (EstadoPedido)reader.GetInt32(3), (sbyte)reader["modo_automatico"] != 0, piezas, cantidades, getOfertasPedido(pedidoID));
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
        public List<Oferta> getOfertasConID_aux(EstadoOferta estado)
        {
            List<Oferta> lista = new List<Oferta>();
            try
            {
                DataSet resultados = conexion.ejecutarSQLSelect(new MySqlCommand("SELECT * FROM oferta where estado='" + (int)estado + "'"));
                DataTableReader reader = resultados.CreateDataReader();
                while (reader.Read())
                {
                    string ofertaID = reader.GetString(1);


                    Oferta nuevo = new Oferta(ofertaID, reader.GetInt32(0), reader.GetDouble(3), reader.GetString(6), (string)reader["desguaceNombre"], reader.GetString(5), reader.GetDateTime(2), reader.GetDateTime(7), reader.GetDateTime(8), (EstadoOferta)reader.GetInt32(4));
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

        public List<Oferta> getOfertasConID_aux()
        {
            List<Oferta> lista = new List<Oferta>();
            try
            {
                DataSet resultados = conexion.ejecutarSQLSelect(new MySqlCommand("SELECT * FROM oferta"));
                DataTableReader reader = resultados.CreateDataReader();
                while (reader.Read())
                {
                    string ofertaID = reader.GetString(1);


                    Oferta nuevo = new Oferta(ofertaID, reader.GetInt32(0), reader.GetDouble(3), reader.GetString(6), (string)reader["desguaceNombre"], reader.GetString(5), reader.GetDateTime(2), reader.GetDateTime(7), reader.GetDateTime(8), (EstadoOferta)reader.GetInt32(4));
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
            try
            {
                DataSet resultados = conexion.ejecutarSQLSelect(new MySqlCommand("SELECT * FROM pedido where id ='" + id + "';"));
                DataTableReader reader = resultados.CreateDataReader(); while (reader.Read())
                {
                    List<Pieza> piezas = new List<Pieza>();

                    List<int> cantidades = new List<int>();
                    getPiezasYCantidades((int)reader["id_aux"], piezas, cantidades);

                    pedido = new Pedido(reader.GetString(1), (string)reader["taller"], (string)reader["tallerNombre"], reader.GetDateTime(2), reader.GetDateTime(5), reader.GetDateTime(6), (EstadoPedido)reader.GetInt32(3), (sbyte)reader["modo_automatico"] != 0, piezas, cantidades, getOfertasPedido(id));

                }
            }
            catch (MySqlException ex)
            {
                Console.WriteLine(ex.StackTrace);
                return null;
            }
            return pedido;
        }

        public void getPiezasYCantidades(int pedidoID, List<Pieza> piezas, List<int> cantidades)
        {
            try
            {
                DataSet resultados = conexion.ejecutarSQLSelect(new MySqlCommand("SELECT * FROM pedido_pieza WHERE pedido='" + pedidoID + "';"));
                DataTableReader reader = resultados.CreateDataReader();
                while (reader.Read())
                {
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

        public List<Pieza> getPiezasPedido(string pedidoID)
        {
            List<Pieza> lista = new List<Pieza>();
            try
            {
                DataSet resultados = conexion.ejecutarSQLSelect(new MySqlCommand("SELECT * FROM pedido_pieza WHERE pedido='" + pedidoID + "';"));
                DataTableReader reader = resultados.CreateDataReader();
                while (reader.Read())
                {
                    Pieza nueva = new Pieza(reader.GetString(1));
                    lista.Add(nueva);
                }
            }
            catch (MySqlException ex)
            {
                Console.WriteLine(ex.StackTrace);
                return null;
            }
            return lista;

        }

        public List<Oferta> getOfertasDesguace(string desguaceID)
        {
            List<Oferta> lista = new List<Oferta>();
            try
            {
                DataSet resultados = conexion.ejecutarSQLSelect(new MySqlCommand("SELECT * FROM oferta WHERE desguace='" + desguaceID + "';"));
                DataTableReader reader = resultados.CreateDataReader(); while (reader.Read())
                {
                    Oferta nueva = new Oferta(reader.GetString(1), reader.GetDouble(3), reader.GetString(6), (string)reader["desguaceNombre"], reader.GetString(5), reader.GetDateTime(2), (!reader.IsDBNull(7) ? reader.GetDateTime(7) : new DateTime()), reader.GetDateTime(8), (EstadoOferta)reader.GetInt32(4));
                    lista.Add(nueva);
                }
            }
            catch (MySqlException ex)
            {
                Console.WriteLine(ex.StackTrace);
                return null;
            }
            return lista;

        }

        public List<Oferta> getOfertasPedido(string pedidoID)
        {
            List<Oferta> lista = new List<Oferta>();
            try
            {
                DataSet resultados = conexion.ejecutarSQLSelect(new MySqlCommand("SELECT * FROM oferta WHERE pedido='" + pedidoID + "';"));
                Oferta nueva;
                DataTableReader reader = resultados.CreateDataReader();
                while (reader.Read())
                {
                    nueva = new Oferta(reader.GetString(1), reader.GetDouble(3), reader.GetString(6), (string)reader["desguaceNombre"], reader.GetString(5), reader.GetDateTime(2), reader.GetDateTime(7), reader.GetDateTime(8), (EstadoOferta)reader.GetInt32(4));

                    lista.Add(nueva);
                }
            }
            catch (MySqlException ex)
            {
                Console.WriteLine(ex.StackTrace);
                return null;
            }
            return lista;

        }

        public List<Oferta> getOfertasPedido(string pedidoID, EstadoOferta estado)
        {
            List<Oferta> lista = new List<Oferta>();
            try
            {
                DataSet resultados = conexion.ejecutarSQLSelect(new MySqlCommand("SELECT * FROM oferta WHERE pedido='" + pedidoID + "' and estado='" + (int)estado + "';"));
                Oferta nueva;
                DataTableReader reader = resultados.CreateDataReader();
                while (reader.Read())
                {
                    nueva = new Oferta(reader.GetString(1), reader.GetDouble(3), reader.GetString(6), (string)reader["desguaceNombre"], reader.GetString(5), reader.GetDateTime(2), reader.GetDateTime(7), reader.GetDateTime(8), (EstadoOferta)reader.GetInt32(4));

                    lista.Add(nueva);
                }
            }
            catch (MySqlException ex)
            {
                Console.WriteLine(ex.StackTrace);
                return null;
            }
            return lista;

        }
        public Desguace getDesguace()
        {
            DataSet resultados = conexion.ejecutarSQLSelect(new MySqlCommand("SELECT * FROM desguace"));
            try
            {
                if (resultados != null)
                {
                    DataTableReader reader = resultados.CreateDataReader();
                    if (reader.Read())
                    {
                        string desguaceID = reader.GetString(1);
                        if (desguaceID == "")
                        {
                            return new Desguace(desguaceID, reader.GetString(2), reader.GetString(3), reader.GetString(4), reader.GetString(5), reader.GetInt32(6), reader.GetInt32(7), (EstadoGeneral)reader.GetInt32(8), null);
                        }
                        else
                        {
                            List<Oferta> listaOfertas = getOfertasDesguace(reader.GetString(1));
                            return new Desguace(reader.GetString(1), reader.GetString(2), reader.GetString(3), reader.GetString(4), reader.GetString(5), reader.GetInt32(6), reader.GetInt32(7), (EstadoGeneral)reader.GetInt32(8), listaOfertas);
                        }

                    }
                }

            }
            catch (MySqlException ex)
            {
                Console.WriteLine(ex.StackTrace);
            }
            return null;
        }
        public Desguace getDesguace(string email)
        {
            DataSet resultados = conexion.ejecutarSQLSelect(new MySqlCommand("SELECT * FROM desguace WHERE email='" + email + "';"));
            try
            {
                DataTableReader reader = resultados.CreateDataReader();
                if (reader.NextResult())
                {
                    string tallerID = reader.GetString(1);
                    if (tallerID == "")
                    {
                        return new Desguace(reader.GetString(1), reader.GetString(2), reader.GetString(3), reader.GetString(4), reader.GetString(5), reader.GetInt32(6), reader.GetInt32(7), (EstadoGeneral)reader.GetInt32(8), null);
                    }
                    else
                    {
                        List<Oferta> listaOfertas = getOfertasDesguace(reader.GetString(1));
                        return new Desguace(reader.GetString(1), reader.GetString(2), reader.GetString(3), reader.GetString(4), reader.GetString(5), reader.GetInt32(6), reader.GetInt32(7), (EstadoGeneral)reader.GetInt32(8), listaOfertas);
                    }

                }

            }
            catch (MySqlException ex)
            {
                Console.WriteLine(ex.StackTrace);
            }
            return null;
        }


        // método que llaman talleres y desguaces, sin id (lo autogenera la bd)
        public int altaDesguace(string nombre, string email, string direccion, string ciudad, int codPostal, int telefono, int estado)
        {
            return conexion.ejecutarInsert(new MySqlCommand("insert into desguace (nombre, email, direccion, ciudad, codPostal, telefono, estado) values ('" + nombre + "', '" + email + "','" + direccion + "','" + ciudad + "'," + codPostal + "," + telefono + "," + estado + ");"));
        }

        public string getMD5IdDesguace(string email)
        {
            DataSet res = conexion.ejecutarSQLSelect(new MySqlCommand("SELECT id from desguace where email='" + email + "';"));
            try
            {
                DataTableReader reader = res.CreateDataReader();
                if (reader.NextResult())
                {
                    return reader.GetString(1);
                }
            }
            catch (MySqlException ex)
            {
                Console.WriteLine(ex.StackTrace);
            }
            return "ERROR";
        }

        public bool modificarDesguace(string ID, string nombre, string email, string direccion, string ciudad, int codPostal, int telefono, EstadoGeneral estado)
        {
            return conexion.ejecutarSQL(new MySqlCommand("UPDATE `desguace` SET `nombre`='" + nombre + "', `email`='" + email + "', `direccion`='" + direccion + "', `ciudad`='" + ciudad + "', `codPostal`='" + codPostal + "', `telefono`='" + telefono + "', `estado`='" + (int)estado + "' WHERE `id`='" + ID + "';"));
        }

        public bool activarDesguaceMainDesguace(string idRecibido)
        {
            return conexion.ejecutarSQL(new MySqlCommand("UPDATE `desguace` SET  `estado`='0', `id`='" + idRecibido + "'"));
        }

        public List<Pedido> buscarPedido(string idPedido, string idPieza, string estado, DateTime fechaLimite, string modoAceptacion)
        {
            List<Pedido> alPedidos = new List<Pedido>();

            string sWhere = "";
            DataSet pedidos;

            sWhere = crearWhereDeSelect(idPedido, sWhere, modoAceptacion, fechaLimite, estado);

            if (sWhere == "")
            {
                pedidos = conexion.ejecutarSQLSelect(new MySqlCommand("Select * from pedido;"));
            }
            else
            {
                pedidos = conexion.ejecutarSQLSelect(new MySqlCommand("SELECT * FROM pedido where " + sWhere));
            }
            DataTableReader reader = pedidos.CreateDataReader();
            while (reader.Read())
            {
                List<Pieza> piezas = new List<Pieza>();
                List<int> cantidades = new List<int>();
                getPiezasYCantidades((int)reader["id_aux"], piezas, cantidades);
                //falta filtrar por pieza
                Pedido p = new Pedido(reader.GetString(1), reader.GetInt32(0), (string)reader["taller"], (string)reader["tallerNombre"], reader.GetDateTime(2), reader.GetDateTime(5), reader.GetDateTime(6), (EstadoPedido)reader.GetInt32(3), (sbyte)reader["modo_automatico"] != 0, piezas, cantidades, getOfertasPedido(reader.GetString(1)));
                alPedidos.Add(p);
            }

            return alPedidos;
        }

        //falta añadir el modoAceptación
        private string crearWhereDeSelect(string idPedido, string sWhere, string modoAceptacion, DateTime fechaLimite, string estado)
        {
            if (idPedido == "")
            {
                sWhere += " (id_aux='" + idPedido + "' or id='" + idPedido + "')";
            }
            if (modoAceptacion == "")
            {
                if (sWhere == "")
                {
                    sWhere += " and ";
                }
                sWhere += "modo_automatico='" + ("Automatico".Equals(modoAceptacion) ? 1 : 0) + "'";
            }
            if (fechaLimite.ToString() == "")
            {
                if (sWhere == "")
                {
                    sWhere += " and ";
                }
                sWhere += "fecha_limite='" + fechaLimite.ToString() + "'";
            }
            //estado debe ser el último porque es un and
            if (estado == "")
            {
                if (sWhere == "")
                {
                    sWhere += " and ";
                }
                sWhere += "estado='" + estado + "'";
            }
            return sWhere;
        }

        private bool anyadirPiezasATablaPieza(List<Pieza> piezas)
        {
            foreach (Pieza pieza in piezas)
            {
                conexion.ejecutarInsert(new MySqlCommand("Insert into pieza(nombre) values ('" + pieza.getNombre() + "')"));
            }
            return true;
        }

        public bool anyadirPiezasAPedido(int idPedido, List<Pieza> piezas, List<int> cantidades)
        {
            if (anyadirPiezasATablaPieza(piezas))
            {
                for (int i = 0; i < piezas.Count; i++)
                {
                    conexion.ejecutarInsert(new MySqlCommand("Insert into pedido_pieza(pedido,pieza,cantidad) values ('" + idPedido + "', '" + piezas[i].getNombre() + "', '" + cantidades[i] + "')"));
                }
                return true;
            }
            return false;
        }

        public bool cambiarEstadoOferta(EstadoOferta eOf, string id)
        {
            return conexion.ejecutarSQL(new MySqlCommand("Update oferta set estado='" + (int)eOf + "' where id='" + id + "'"));
        }


        public bool activarOfertaDesguace(int id_aux, string id)
        {
            return conexion.ejecutarSQL(new MySqlCommand("Update oferta set estado=" + (int)EstadoOferta.ACTIVE + ", id='" + id + "' where id_aux='" + id_aux + "';"));
        }
        public bool cancelarOfertas(string idPedido)
        {
            return conexion.ejecutarSQL(new MySqlCommand("Update oferta set estado='" + (int)EstadoOferta.CANCELLED + "' where pedido='" + idPedido + "'"));
        }

        public bool cancelarOfertasDesguace(string idDesguace)
        {
            return conexion.ejecutarSQL(new MySqlCommand("Update oferta set estado='" + (int)EstadoOferta.CANCELLED + "' where desguace='" + idDesguace + "'"));
        }

        public bool bajaDesguace(string id)
        {
            try
            {
                cancelarOfertasDesguace(id);
            }
            catch (MySqlException ex)
            {
                Console.WriteLine(ex.StackTrace);
            }
            return conexion.ejecutarSQL(new MySqlCommand("Update desguace set estado='" + (int)EstadoGeneral.INACTIVE + "' where id='" + id + "'"));
        }

        public bool cambiarEstadoPedido(EstadoPedido ePed, string id)
        {
            return conexion.ejecutarSQL(new MySqlCommand("Update pedido set estado='" + (int)ePed + "' where id='" + id + "'"));
        }



        /**
         *
         * @param accion debe tener formato "nombre:param0|param1|...|paramN"
         * @param paramValues debe tener formato "valor0|valor1|...|valorN"
         * @return
         */
        public bool guardarAccion(string accion, string paramValues)
        {
            return conexion.ejecutarSQL(new MySqlCommand("INSERT INTO `acciones`(`accion`,`params`) VALUES('" + accion + "', '" + paramValues + "');"));
        }

        public DataSet getAcciones()
        {
            DataSet result = conexion.ejecutarSQLSelect(new MySqlCommand("SELECT * FROM `acciones`;"));
            return result;
        }


        public DataSet getAccionesYBorra()
        {
            DataSet result = getAcciones();
            conexion.ejecutarSQL(new MySqlCommand("DELETE FROM `acciones`;"));
            return result;
        }
        public Boolean anyadirRolUsuario(String nombre, String contrasenya, String rol) {
            conexion.ejecutarSQLSelect(new MySqlCommand("Insert into usuarios(nombre,contrasenya,rol) values ('" + nombre + "', '" + contrasenya + "', '" + rol + "')"));
           List<int> listaOpciones = getRolLista(rol);
            if (listaOpciones == null) { return false; }
            conexion.ejecutarSQLSelect(new MySqlCommand("Insert into usuarios(nombre,contrasenya,rol,nuevo_pedido,borrar_pedido,modificar_pedido,modificar_datos,baja,aceptar_ofertas,rechazar_ofertas,nuevo_usuario,nuevo_rol,cambiar_usuario,cambiar_rol) values ('" + nombre + "', '" + contrasenya + "', '" + rol + "', '" + listaOpciones[0] + "', '" + listaOpciones[1] + "', '" + listaOpciones[2] + "', '" + listaOpciones[3] + "', '" + listaOpciones[4] + "', '" + listaOpciones[5]+ "', '" + listaOpciones[6] + "', '" + listaOpciones[7] + "', '" + listaOpciones[8] + "', '" + listaOpciones[9] + "', '" + listaOpciones[10] + "')"));

            return true;
		
	    }
        public void anyadirRol(String nombre, List<int> listaOpciones)
        {
            conexion.ejecutarInsert(new MySqlCommand("Insert into roles(rol,nuevo_pedido,borrar_pedido,modificar_pedido,modificar_datos,baja,aceptar_ofertas,rechazar_ofertas,nuevo_usuario,nuevo_rol,cambiar_usuario,cambiar_rol) values ('" + nombre + "', '" + listaOpciones[0] + "', '" + listaOpciones[1] + "', '" + listaOpciones[2] + "', '" + listaOpciones[3] + "', '" + listaOpciones[4] + "', '" + listaOpciones[5] + "', '" + listaOpciones[6] + "', '" + listaOpciones[7] + "', '" + listaOpciones[8] + "', '" + listaOpciones[9] + "', '" + listaOpciones[10] + "')"));



        }
        private List<int> getRolLista(String rol)
        {

            List<int> listaOpciones = new List<int>();
            DataSet opciones = conexion.ejecutarSQLSelect(new MySqlCommand("SELECT * from roles where rol='" + rol + "';"));

            DataTableReader reader = opciones.CreateDataReader();
            if (reader.NextResult())
            {
                    for (int i = 2; i <= 12; i++)
                    {
                        listaOpciones.Add(reader.GetInt32(i));
                    }
                    return listaOpciones;
                }


            return null;
        }

	public Boolean comprobarInicio(String usuario, String contrasenya) {
        DataSet res = conexion.ejecutarSQLSelect(new MySqlCommand("SELECT * FROM `usuarios` where nombre='" + usuario + "';"));
        try
        {
            DataTableReader reader = res.CreateDataReader();
            if (reader.NextResult())
            {

                if (usuario.Equals((string)reader["nombre"]) && contrasenya.Equals((string)reader["contrasenya"]))
                {
                    return true;
                }
            }
        }
        catch (MySqlException ex)
        {
            Console.WriteLine(ex.StackTrace);
        }
        return false;
	}
    }
}