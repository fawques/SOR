using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace desguaceNET.libSOR.general
{
    class Pieza
    {
        public string nombre { get; set; }

        public Pieza(string nombre)
        {
            this.nombre = nombre;
        }


        // ======== Getters =========


        public string getNombre()
        {
            return nombre;
        }
    }
}
