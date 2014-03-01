using Newtonsoft.Json;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Runtime.Serialization;
using System.Text;
using System.Threading.Tasks;

namespace desguaceNET.libSOR.general
{
    [JsonObject(MemberSerialization.OptIn)]
    class Oferta
    {
        [JsonProperty]
        public string ID { get; set; }
        [JsonProperty]
        public int ID_aux { get; set; }
        [JsonProperty]
        public EstadoOferta estado { get; set; }
        [JsonProperty]
        public DateTime fecha_alta { get; set; }
        [JsonProperty]
        public DateTime fecha_limite { get; set; }
        [JsonProperty]
        public double precio { get; set; }
        [JsonProperty]
        public string desguaceID { get; set; }
        [JsonProperty]
        public string desguaceNombre { get; set; }
        [JsonProperty]
        public string pedidoID { get; set; }
        [JsonProperty]
        public DateTime fecha_baja { get; set; }

        /** Constructor para la base de datos.
         *
         * @param ID
         * @param ID_aux
         * @param precio
         * @param desguaceID
         * @param pedidoID
         * @param fecha_alta
         * @param fecha_baja
         * @param fecha_limite
         * @param estado
         */
        [JsonConstructor]
        public Oferta(string ID, int ID_aux, double precio, string desguaceID, string desguaceNombre, string pedidoID, DateTime fecha_alta, DateTime fecha_baja, DateTime fecha_limite, EstadoOferta estado)
        {
            this.ID = ID;
            this.ID_aux = ID_aux;
            this.precio = precio;
            this.desguaceID = desguaceID;
            this.desguaceNombre = desguaceNombre;
            this.pedidoID = pedidoID;
            this.fecha_alta = fecha_alta;
            this.fecha_baja = fecha_baja;
            this.fecha_limite = fecha_limite;
            this.estado = estado;
        }

        /** Constructor para la base de datos sin id_aux.
         *  Pone id_aux a -1.
         *
         * @param ID
         * @param precio
         * @param desguaceID
         * @param pedidoID
         * @param fecha_alta
         * @param fecha_baja
         * @param fecha_limite
         * @param estado
         */
        public Oferta(string ID, double precio, string desguaceID, string desguaceNombre, string pedidoID, DateTime fecha_alta, DateTime fecha_baja, DateTime fecha_limite, EstadoOferta estado)
        {
            this.ID = ID;
            this.ID_aux = -1;
            this.precio = precio;
            this.desguaceID = desguaceID;
            this.desguaceNombre = desguaceNombre;
            this.desguaceID = pedidoID;
            this.fecha_alta = fecha_alta;
            this.fecha_baja = fecha_baja;
            this.fecha_limite = fecha_limite;
            this.estado = estado;
        }

        /**
         * Constructor para ofertas nuevos. Se pone el estado a NEW y la fecha_alta a la fecha actual.
         * @param ID_aux id del nuevo pedido 
         * @param precio 
         * @param desguaceID taller que hace el pedido
         * @param pedidoID
         * @param fecha_limite fecha límite para recibir ofertas de este pedido. Pasada esa fecha, el pedido se cancelará
         */
        public Oferta(int ID_aux, double precio, string desguaceID, string desguaceNombre, string pedidoID, DateTime fecha_limite)
        {
            this.ID = "";
            this.ID_aux = ID_aux;
            this.precio = precio;
            this.desguaceID = desguaceID;
            this.desguaceNombre = desguaceNombre;
            this.fecha_alta = DateTime.Today;
            this.fecha_baja = new DateTime(1970,01,01);
            this.pedidoID = pedidoID;
            this.fecha_limite = fecha_limite;
            this.estado = EstadoOferta.NEW;
        }

        /** Constructor de copia
         *
         * @param o oferta
         */
        public Oferta(Oferta o)
        {
            this.ID = o.ID;
            this.ID_aux = o.ID_aux;
            this.precio = o.precio;
            this.desguaceID = o.desguaceID;
            this.desguaceNombre = o.desguaceNombre;
            this.pedidoID = o.pedidoID;
            this.fecha_alta = o.fecha_alta;
            this.fecha_baja = o.fecha_baja;
            this.fecha_limite = o.fecha_limite;
            this.estado = o.estado;
        }


        // OJO, mirar si hace falta esto, es bastante peligroso!!
        public void setEstado(EstadoOferta estado)
        {
            this.estado = estado;
        }


        // ============ Getters ==========

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

        public DateTime getFecha_alta()
        {
            return fecha_alta;
        }

        public DateTime getFecha_baja()
        {
            return fecha_baja;
        }

        public DateTime getFecha_limite()
        {
            return fecha_limite;
        }

        public double getPrecio()
        {
            return precio;
        }

        public string getDesguace()
        {
            return desguaceID;
        }

        public string getPedido()
        {
            return pedidoID;
        }

        public EstadoOferta getEstado()
        {
            return estado;
        }
    }
}
