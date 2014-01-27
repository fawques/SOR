using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace desguaceNET.libSOR.general
{
    class PedidoCorto
    {
        public string ID {get;set;}
        public EstadoPedido estado { get; set; }

        public PedidoCorto()
        {
            this.ID = "";
            this.estado = EstadoPedido.NEW;
        }
        public PedidoCorto(string ID, EstadoPedido estado)
        {
            this.ID = ID;
            this.estado = estado;
        }
        public PedidoCorto(string ID, string estado)
        {
            this.ID = ID;
            this.estado = (EstadoPedido) Enum.Parse(typeof(EstadoPedido),estado);
        }

        public PedidoCorto(PedidoCorto p)
        {
            this.ID = p.getID();
            this.estado = p.getEstado();
        }
        public string getID()
        {
            return ID;
        }

        public void setID(string ID)
        {
            this.ID = ID;
        }

        public EstadoPedido getEstado()
        {
            return estado;
        }

        public void setEstado(EstadoPedido estado)
        {
            this.estado = estado;
        }
    }
}
