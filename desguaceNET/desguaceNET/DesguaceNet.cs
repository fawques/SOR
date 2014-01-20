using desguaceNET.desguaceWS;
using desguaceNET.libSOR.BD;
using desguaceNET.libSOR.general;
using MySql.Data.MySqlClient;
using Newtonsoft.Json;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace desguaceNET
{
    class DesguaceNet
    {
        InterfazBD bd;

        public bool activarDesguacesBD(string idRecibido)
        {
            try
            {
                bd = new InterfazBD("sor_desguace");
                bool r = bd.activarDesguaceMainDesguace(idRecibido);
                return r;

            }
            catch (MySqlException ex)
            {
                Console.WriteLine(ex.StackTrace);
            }

            return false;
        }

        public void crearOferta(DateTime fechaAlta, DateTime fechaLimite, string idPedido, double precio)
        {
            try
            {
                bd = new InterfazBD("sor_desguace");
                string desguaceID = bd.getDesguace().getID();
                int id = bd.anadirOferta(fechaAlta, (int)EstadoOferta.NEW, precio, idPedido, desguaceID, fechaLimite);
                Oferta nuevo = new Oferta(id, precio, desguaceID, idPedido, fechaLimite);
                string idFinal = nuevaOferta(JsonConvert.SerializeObject(nuevo));
                bd.activarOfertaDesguace(id, idFinal);
            }
            catch (MySqlException ex)
            {
                Console.WriteLine(ex.StackTrace);
            }



        }
        public List<Oferta> actualizarOfertasAceptadas()
        {
            List<Oferta> of = new List<Oferta>();
            try
            {
                bd = new InterfazBD("sor_desguace");
                of = bd.getOfertasConID_aux(EstadoOferta.ACCEPTED);
                return of;
            }
            catch (MySqlException ex)
            {
                Console.WriteLine(ex.StackTrace);
            }
            return of;
        }
        public List<Oferta> actualizarOfertas()
        {
            List<Oferta> of = new List<Oferta>();
            try
            {
                bd = new InterfazBD("sor_desguace");
                of = bd.getOfertasConID_aux(EstadoOferta.ACTIVE);
                return of;
            }
            catch (MySqlException ex)
            {
                Console.WriteLine(ex.StackTrace);
            }
            return of;
        }
        public bool cambiarEstadoOferta(string id)
        {
            bool realizado = false;
            try
            {
                bd = new InterfazBD("sor_desguace");
                realizado = bd.cambiarEstadoOferta(EstadoOferta.FINISHED_OK, id);
                return realizado;
            }
            catch (MySqlException ex)
            {
                Console.WriteLine(ex.StackTrace);
            }
            return realizado;
        }

        public bool hacerAlta(string name, string email, string address, string city, int postalCode, int telephone){
            // TODO: meter a la BD y esas cosas que en java están en el controller de interfaz
            return alta(name, email, address, city, postalCode, telephone);
        }

        private bool alta(string name, string email, string address, string city, int postalCode, int telephone)
        {
            DesguaceJavaWSClient client = new DesguaceJavaWSClient(/*Aquí irá jUDDI*/);
            return client.alta(name, email, address, city, postalCode, telephone);
        }

        private string checkActivacion(string mail)
        {
            DesguaceJavaWSClient client = new DesguaceJavaWSClient(/*Aquí irá jUDDI*/);
            return client.checkActivacion(mail);
        }


        private string nuevaOferta(string oferta)
        {
            DesguaceJavaWSClient client = new DesguaceJavaWSClient(/*Aquí irá jUDDI*/);
            return client.nuevaOferta(oferta);
        }

        private string getOfertas()
        {
            DesguaceJavaWSClient client = new DesguaceJavaWSClient(/*Aquí irá jUDDI*/);
            return client.getOfertas();
        }

        private string getPedidosporID(string str)
        {
            DesguaceJavaWSClient client = new DesguaceJavaWSClient(/*Aquí irá jUDDI*/);
            return client.getPedidosporID(str);
        }

        private bool aceptarOfertaFin(string id)
        {
            DesguaceJavaWSClient client = new DesguaceJavaWSClient(/*Aquí irá jUDDI*/);
            return client.aceptarOfertaFin(id);
        }

    }
}
