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

        public AsyncManager(string database) {
            try {
                bd = new InterfazBD(database);
            } catch (MySqlException ex) {
                Console.WriteLine("blablablabal");
            }
        }
    
    
        public void guardarAccion(MethodBase method,string[] valores){
            Accion accion = new Accion(method,valores);
            char[] delim = new char[4];
            delim[0] = delim[3] = ':';
            delim[1] = delim[2] = '_';
            string[] partes = accion.ToString().Split(delim);
            string accionYParams = partes[0] + ":__:" + partes[1];
            string paramValues = partes[2];
            bd.guardarAccion(accionYParams,paramValues);
        }
    
        public void ejecutarAcciones(){
            try {
                DataSet dataset = bd.getAcciones();
                List<Accion> listaAcciones = new List<Accion>();
                DataTableReader acciones = dataset.CreateDataReader();
                while(acciones.Read()){
                    string resultAccion = acciones.GetString(0);
                    char[] delim = new char[4];
                    delim[0] = delim[3] = ':';
                    delim[1] = delim[2] = '_';
                    string[] partes = resultAccion.Split(delim);
                    string name = partes[0];
                    string paramTypes = partes[1];
                    string[] stringTypes = paramTypes.Split(((new char[1])[0] = '|'));
                    Type[] types = new Type[stringTypes.Length];
                
                    for (int i = 0; i < stringTypes.Length; i++) {
                        types[i] = Type.GetType(stringTypes[i]);
                    }
                    string resultParams = acciones.GetString(1);
                
                    Accion nuevo = new Accion(name, types, resultParams.Split(((new char[1])[0] = '|')));
                    listaAcciones.Add(nuevo);
                }
                foreach (Accion accion in listaAcciones) {
                    accion.invocar();
                }
            } catch (MySqlException ex) {
                Console.WriteLine("blablabla2");
            }
        
        }
    
    }
}
