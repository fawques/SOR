using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Reflection;

namespace desguaceNET.Async
{
    class Accion
    {
        string name{ get; set; }
        Type[] paramTypes;
        string[] paramValues{ get; set; }

        public Accion(string name, Type[] paramTypes, string[] paramValues) {
            this.name = name;
            this.paramTypes = paramTypes;
            this.paramValues = paramValues;
        }

        public Accion(MethodBase m, string[] paramValues) {
            this.name = m.Name;
            ParameterInfo[] parametros = m.GetParameters();
            paramTypes = new Type[parametros.Length];
            for (int i = 0; i < parametros.Length; i++)
            {
                paramTypes[i] = parametros[i].GetType();
            }
            this.paramValues = paramValues;
        }

        public void invocar(){
            // forName de los parámetros, y después un invocar a pelo de MainTaller -- Cómo?
            MethodInfo method = typeof(DesguaceNet).GetMethod(name);
            method.Invoke(new DesguaceNet(),paramValues);
        }
    
        public string ToString() {
            string types = "";
            string values = "";
            for (int i = 0; i < paramTypes.Length; i++) {
                if (i != 0) {
                    types += "|";
                    values += "|";
                }
                types += paramTypes[i].Name;
                values += paramValues[i];
            }
            return name + ":__:" + types + ":__:" + values;
        }
    }
}
