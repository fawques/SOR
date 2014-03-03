using desguaceNET.libSOR.BD;
using MySql.Data.MySqlClient;
using System;
using System.Collections.Generic;
using System.Data;
using System.Linq;
using System.Reflection;
using System.Text;
using System.Threading.Tasks;

namespace desguaceNET.Async
{
    class AsyncManager
    {
        InterfazBD bd;

        public AsyncManager(string database)
        {
            try
            {
                bd = new InterfazBD(database);
            }
            catch (MySqlException ex)
            {
                Console.WriteLine("blablablabal");
            }
        }


        public void guardarAccion(MethodBase method, string[] valores)
        {
            Accion accion = new Accion(method, valores);
            string[] delim = new string[1];
            delim[0] = ":__:";
            string[] partes = accion.ToString().Split(delim, StringSplitOptions.None);
            string accionYParams = partes[0] + ":__:" + partes[1];
            string paramValues = partes[2];
            bd.guardarAccion(accionYParams, paramValues);
        }

        public void ejecutarAcciones()
        {
            try
            {

                List<Accion> listaAcciones = getAccionesYBorra();
                foreach (Accion accion in listaAcciones)
                {
                    accion.invocar();
                }
            }
            catch (MySqlException ex)
            {
                Console.WriteLine("blablabla2");
            }

        }



        public List<Accion> getAcciones()
        {
            DataSet acciones = bd.getAcciones();
            return procesarAcciones(acciones);
        }

        private List<Accion> getAccionesYBorra()
        {
            DataSet acciones = bd.getAccionesYBorra();
            return procesarAcciones(acciones);
        }

        private List<Accion> procesarAcciones(DataSet dataset)
        {
            List<Accion> listaAcciones = new List<Accion>();
            DataTableReader acciones = dataset.CreateDataReader();
            while (acciones.Read())
            {
                string resultAccion = acciones.GetString(0);
                string[] delim = new string[1];
                delim[0] = ":__:";
                string[] partes = resultAccion.Split(delim, StringSplitOptions.None);
                string name = partes[0];
                string paramTypes = partes[1];
                string[] stringTypes = paramTypes.Split(((new char[1])[0] = '|'));
                Type[] types = new Type[stringTypes.Length];

                for (int i = 0; i < stringTypes.Length; i++)
                {
                    types[i] = Type.GetType(stringTypes[i]);
                }
                string resultParams = acciones.GetString(1);

                Accion nuevo = new Accion(name, types, resultParams.Split(((new char[1])[0] = '|')));
                listaAcciones.Add(nuevo);
            }
            return listaAcciones;

        }

    }
}
