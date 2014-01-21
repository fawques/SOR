using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace desguaceNET.libSOR.general
{
    class Pedido
    {
        public string ID { get; set; }
        public int ID_aux { get; set; }
        public string tallerID { get; set; }
        public DateTime fecha_alta { get; set; }
        public DateTime fecha_baja { get; set; }
        public DateTime fecha_limite { get; set; }
        public EstadoPedido estado { get; set; }
        public bool modoAutomatico { get; set; }

        public List<Pieza> listaPiezas { get; set; }
        public List<int> listaCantidadesPiezas { get; set; }
        public List<Oferta> listaOfertas { get; set; }

        /** Constructor para la base de datos.
         *
         * @param ID
         * @param ID_aux
         * @param tallerID
         * @param fecha_alta
         * @param fecha_baja
         * @param fecha_limite
         * @param estado
         * @param listaPiezas
         * @param listaCantidadesPiezas
         * @param listaOfertas
         */
        public Pedido(string ID, int ID_aux, string tallerID, DateTime fecha_alta, DateTime fecha_baja, DateTime fecha_limite, EstadoPedido estado, bool modoAutomatico, List<Pieza> listaPiezas, List<int> listaCantidadesPiezas, List<Oferta> listaOfertas)
        {
            this.ID = ID;
            this.ID_aux = ID_aux;
            this.tallerID = tallerID;
            this.fecha_alta = fecha_alta;
            this.fecha_baja = fecha_baja;
            this.fecha_limite = fecha_limite;
            this.estado = estado;
            this.listaPiezas = listaPiezas;
            this.listaCantidadesPiezas = listaCantidadesPiezas;
            this.listaOfertas = listaOfertas;
            this.modoAutomatico = modoAutomatico;
        }

        /** Constructor para la base de datos sin id_aux.
         *  Pone id_aux a -1.
         *
         * @param ID
         * @param tallerID
         * @param fecha_alta
         * @param fecha_baja
         * @param fecha_limite
         * @param estado
         * @param modoAutomatico
         * @param listaPiezas
         * @param listaCantidadesPiezas
         * @param listaOfertas
         */
        public Pedido(string ID, string tallerID, DateTime fecha_alta, DateTime fecha_baja, DateTime fecha_limite, EstadoPedido estado, bool modoAutomatico, List<Pieza> listaPiezas, List<int> listaCantidadesPiezas, List<Oferta> listaOfertas)
        {
            this.ID = ID;
            this.tallerID = tallerID;
            this.fecha_alta = fecha_alta;
            this.fecha_baja = fecha_baja;
            this.fecha_limite = fecha_limite;
            this.estado = estado;
            this.listaPiezas = listaPiezas;
            this.listaCantidadesPiezas = listaCantidadesPiezas;
            this.listaOfertas = listaOfertas;
            this.modoAutomatico = modoAutomatico;
        }

        /**
         * Constructor para pedidos nuevos. Se pone el estado a NEW y la fecha_alta a la fecha actual.
         * No tiene piezas, en principio, habrá que añadirlas
         * @param ID_aux id del nuevo pedido 
         * @param tallerID taller que hace el pedido
         * @param fecha_limite fecha límite para recibir ofertas de este pedido. Pasada esa fecha, el pedido se cancelará
         */
        public Pedido(int ID_aux, string tallerID, DateTime fecha_limite, bool modoAutomatico) {
        this.ID = "";
        this.ID_aux = ID_aux;
        this.tallerID = tallerID;
        this.fecha_alta = new DateTime();
        //this.fecha_baja = null;
        this.fecha_limite = fecha_limite;
        this.listaPiezas = new List<Pieza>();
        this.listaCantidadesPiezas = new List<int>();
        this.listaOfertas = new List<Oferta>();
        this.estado = EstadoPedido.NEW;
        this.modoAutomatico = modoAutomatico;
    }

        /** Constructor de copia
         *
         * @param p pedido
         */
        public Pedido(Pedido p) {
        this.ID = p.ID;
        this.ID_aux = p.ID_aux;
        this.tallerID =p.tallerID;
        this.fecha_alta = p.fecha_alta;
        this.fecha_baja = p.fecha_baja;
        this.fecha_limite = p.fecha_limite;
        this.listaPiezas =new List<Pieza>(p.listaPiezas);
        this.listaCantidadesPiezas =new List<int>(p.listaCantidadesPiezas) ;
        this.listaOfertas =new List<Oferta>( p.listaOfertas);
        this.estado = p.estado;
        this.modoAutomatico = p.modoAutomatico;
    }

        public bool addPieza(Pieza pieza, int cantidad)
        {
            listaPiezas.Add(pieza);
            listaCantidadesPiezas.Add(cantidad);
            //TODO: habrá que mirar más cosas para devolver true/false o lo que sea
            return true;
        }


        // ======== Getters/Setters ==========

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

        public string getTaller()
        {
            return tallerID;
        }

        public DateTime getFecha_alta()
        {
            return fecha_alta;
        }

        public void setEstado(EstadoPedido estado)
        {
            this.estado = estado;
        }

        public DateTime getFecha_baja()
        {
            return fecha_baja;
        }

        public DateTime getFecha_limite()
        {
            return fecha_limite;
        }

        public List<Pieza> getListaPiezas()
        {
            return listaPiezas;
        }

        public List<int> getListaCantidadesPiezas()
        {
            return listaCantidadesPiezas;
        }

        public List<Oferta> getListaOfertas()
        {
            return listaOfertas;
        }

        public EstadoPedido getEstado()
        {
            return estado;
        }

        public bool getModoAutomatico()
        {
            return modoAutomatico;
        }
    }
}
