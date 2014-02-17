using Newtonsoft.Json;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace desguaceNET.libSOR.general
{
    abstract class Usuario
    {
        /**
       * id proporcionado por el gestor. Tiene 32 caracteres. El valor de error es ""
       */
        [JsonProperty]
        protected string ID;

        /**
         * id auxiliar para taller o desguace. El valor de error es -1.
         */
        [JsonProperty]
        protected int ID_aux { get; set; }
        [JsonProperty]
        protected string name { get; set; }
        [JsonProperty]
        protected string email { get; set; }
        [JsonProperty]
        protected string address { get; set; }
        [JsonProperty]
        protected string city { get; set; }
        [JsonProperty]
        protected int postalCode { get; set; }
        [JsonProperty]
        protected int telephone { get; set; }
        [JsonProperty]
        protected EstadoGeneral estado { get; set; }

        [JsonConstructor]
        public Usuario(string ID, int ID_aux, string name, string email, string address, string city, int postalCode, int telephone, EstadoGeneral estado)
        {
            this.ID = ID;
            this.ID_aux = ID_aux;
            this.name = name;
            this.email = email;
            this.address = address;
            this.city = city;
            this.postalCode = postalCode;
            this.telephone = telephone;
            this.estado = estado;
        }

        public string getID()
        {
            return ID;
        }

        public void setID(string ID)
        {
            this.ID = ID;
        }

        public int getID_aux()
        {
            return ID_aux;
        }

        public void setID_aux(int ID_aux)
        {
            this.ID_aux = ID_aux;
        }

        public string getName()
        {
            return name;
        }

        public string getEmail()
        {
            return email;
        }

        public string getAddress()
        {
            return address;
        }

        public string getCity()
        {
            return city;
        }

        public int getPostalCode()
        {
            return postalCode;
        }

        public int getTelephone()
        {
            return telephone;
        }

        public EstadoGeneral getEstado()
        {
            return estado;
        }

        public void activar()
        {
            this.estado = EstadoGeneral.ACTIVE;
        }

        public void activar(string id)
        {
            this.estado = EstadoGeneral.ACTIVE;
            this.ID = id;
        }

        public void baja()
        {
            this.estado = EstadoGeneral.INACTIVE;
        }

        public void setPendiente()
        {
            this.estado = EstadoGeneral.PENDIENTE;
        }
    }
}
