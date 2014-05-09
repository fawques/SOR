using Newtonsoft.Json;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace desguaceNET.libSOR.general
{
    class Desguace : Usuario
    {

        [JsonProperty]
        private List<Oferta> listaOfertas;


        /** Constructor para la base de datos en la parte de desguace o taller.
         *  Rellena todos los datos de la clase, incluyendo id, id_aux y lista de ofertas
         * 
         * @param ID 
         * @param ID_aux 
         * @param name
         * @param email
         * @param address
         * @param city
         * @param postalCode
         * @param telephone
         * @param estado
         * @param listaDeOfertas
         */
        public Desguace(String ID, int ID_aux, String name, String email, String address, String city, int postalCode, int telephone, EstadoGeneral estado, String password, List<Oferta> listaDeOfertas)
        :
            base(ID, ID_aux, password,name, email, address, city, postalCode, telephone, estado)
        {
            this.listaOfertas = listaDeOfertas;
        }

        /** Constructor para la base de datos en la parte de gestor.
         *  Rellena todos los datos de la clase, incluyendo id y lista de ofertas.
         *  id_aux se pondrá al valor de error (-1).
         *
         * @param ID
         * @param name
         * @param email
         * @param address
         * @param city
         * @param postalCode
         * @param telephone
         * @param estado
         * @param listaDeOfertas
         */
        public Desguace(String ID, String name, String email, String address, String city, int postalCode, int telephone, EstadoGeneral estado, String password, List<Oferta> listaDeOfertas) :
            base(ID, -1,password, name, email, address, city, postalCode, telephone, estado)
        {
            this.listaOfertas = listaDeOfertas;
        }

        /*public Oferta nuevaOferta(DateTime fecha_alta, DateTime fecha_baja, DateTime fecha_limite, double precio, int pedidoID){
            DateTime ahora = new DateTime();
        //TODO: Darle un ID de verdad, no el tiempo actual...
        //Oferta(int ID, DateTime fecha_alta, DateTime fecha_baja, DateTime fecha_limite, double precio, int desguaceID, int pedidoID, EstadoOferta estado)
            //Oferta nueva = new Oferta((int)ahora.getTime(),fecha_alta, fecha_baja, fecha_limite, precio, ID,pedidoID);
            //Oferta nueva = new Oferta(pedidoID,fecha_alta,fecha_baja,fecha_limite,precio,)
            listaOfertas.add(nueva);
            return nueva;
        }*/

        // OJO: ver rechazarOferta en Pedido también
        public bool cancelarOferta(Oferta oferta)
        {
            oferta.setEstado(EstadoOferta.CANCELLED);
            return true;
        }

        // ======== Getters =======


        public List<Oferta> getListaOfertas()
        {
            return listaOfertas;
        }
    
    }
}
