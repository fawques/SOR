﻿using desguaceNET.desguaceWS_Silvia;
using desguaceNET.libSOR.activemq;
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
        Desguace desguace;

        public DesguaceNet(){
            bd = new InterfazBD("sor_desguace");
            desguace = bd.getDesguace();
        }

        public bool activarDesguacesBD(string idRecibido)
        {
            try
            {
                bool r = bd.activarDesguaceMainDesguace(idRecibido);
                return r;

            }
            catch (MySqlException ex)
            {
                Console.WriteLine(ex.StackTrace);
            }

            return false;
        }

        public Oferta crearOferta(DateTime fechaAlta, DateTime fechaLimite, string idPedido, double precio)
        {
            try
            {
                string desguaceID = desguace.getID();
                int id = bd.anadirOferta(fechaAlta, (int)EstadoOferta.NEW, precio, idPedido, desguaceID, fechaLimite);
                if (id != -1)
                {
                    Oferta nuevo = new Oferta(id, precio, desguaceID, idPedido, fechaLimite);
                    string mierdajson = JsonConvert.SerializeObject(nuevo);
                    string idFinal = nuevaOferta(mierdajson);
                    if (idFinal != "")
                    {
                        nuevo.setID(idFinal);
                        nuevo.setEstado(EstadoOferta.ACTIVE);
                        bd.activarOfertaDesguace(id, idFinal);
                        return nuevo;
                    }                    
                }
            }
            catch (MySqlException ex)
            {
                Console.WriteLine(ex.StackTrace);
            }

            return null;

        }
        public List<Oferta> actualizarOfertasAceptadas()
        {
            List<Oferta> of = new List<Oferta>();
            try
            {
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
                realizado = bd.cambiarEstadoOferta(EstadoOferta.FINISHED_OK, id);
                return realizado;
            }
            catch (MySqlException ex)
            {
                Console.WriteLine(ex.StackTrace);
            }
            return realizado;
        }

        public bool hacerAlta(string name, string email, string address, string city, string postalCode, string telephone)
        {

            if (alta(name, email, address, city, postalCode, telephone))
            {
                //METER en base de datos si está todo ok.
                if (bd.altaDesguace(name, email, address, city, int.Parse(postalCode), int.Parse(telephone), (int)EstadoGeneral.PENDIENTE) != -1)
                {

                    Console.WriteLine("Esperando activación");
                    return true;
                }
                else
                {
                    //devolver un error
                    Console.WriteLine("Error en el alta en la bd");
                }
            }
            else
            {
                Console.WriteLine("Error en el alta");
            }
            return false;
        }


        public string comprobarActivacion(string mail)
        {
            string id = checkActivacion(mail);
            bd.activarDesguaceMainDesguace(id);
            return id;
        }

        public bool cancelarOfertaDesguace(string id)
        {
            if (cancelarOferta(id))
            {
                return cambiarEstadoOferta(id, EstadoOferta.CANCELLED);
            }
            return false;
        }

        public bool cambiarEstadoOferta(String id, EstadoOferta estado)
        {
            bool realizado = false;
            try
            {
                realizado = bd.cambiarEstadoOferta(estado, id);
                return realizado;
            }
            catch (MySqlException ex)
            {
                Console.WriteLine(ex.StackTrace);
            }
            return realizado;
        }

        public List<Pedido> getPedidos()
        {
            List<Pedido> pedidoslista = new List<Pedido>();
            try
            {
                pedidoslista = bd.getPedidos();
                return pedidoslista;

            }
            catch (MySqlException ex)
            {
                Console.WriteLine(ex.StackTrace);
            }
            return pedidoslista;
        }

        public bool reactivarDesguace()
        {
            try
            {
                bool r = bd.activarDesguaceMainDesguace(desguace.getID());
                return r;
            }
            catch (MySqlException ex)
            {
                Console.WriteLine(ex.StackTrace);
            }
            return false;
        }

        public bool bajaDesguace()
        {
            try
            {
                if (baja(desguace.getID()))
                {
                    if (bd.bajaDesguace(desguace.getID()))
                    {
                        return true;
                    }
                    else
                    {
                        Console.WriteLine("Error: No se ha podido cambiar el estado en taller.");
                    }
                }
                else
                {
                    Console.WriteLine("Error: No se ha podido dar de baja en gestor.");
                }
            }
            catch (MySqlException ex)
            {
                Console.WriteLine(ex.StackTrace);
            }
            return false;
        }

        public void actualizarPedidos()
        {
            // coger los pedidos de activeMQ
            Gestor_activemq activemq = new Gestor_activemq();
            activemq.create_Consumer(desguace.getID());
            string listaIdsString = activemq.consumer.consumeMessage();
            activemq.consumer.closeConsumer();

            List<PedidoCorto> listaPedidosCortos= new List<PedidoCorto>();
            List<string> listaPedidosCortosString = JsonConvert.DeserializeObject <List<string>>(listaIdsString);
            PedidoCorto p = null;
            foreach (string item in listaPedidosCortosString)
	        {
                p = JsonConvert.DeserializeObject<PedidoCorto>(item);
                listaPedidosCortos.Add(p);
	        }

            // cambias el estado de tu BD según ponga activeMQ
            List<string> listaIDs = new List<string>();
            foreach (PedidoCorto pcorto in listaPedidosCortos)
	        {
                DesguaceNet main = new DesguaceNet();
                if (!main.cambiarEstadoPedidoDesguace(pcorto.getID(), pcorto.getEstado()))
                {
                    listaIDs.Add(pcorto.getID());
                }
	        }
            // si no puedes cambiarlos, creas nuevos
            string listaJSON = JsonConvert.SerializeObject(listaIDs);
            string pedidosstring = getPedidosporID(listaJSON);
            List<Pedido> listaPedidos = null;
            if (pedidosstring != null && pedidosstring != "")
            {
                listaPedidos = JsonConvert.DeserializeObject<List<Pedido>>(pedidosstring);
                foreach (Pedido ped in listaPedidos)
                {
                    bd.anadirPedido(ped);

                }
            }
        }

    public bool cambiarEstadoPedidoDesguace(String id,EstadoPedido estado){
    bool realizado=false;
        try {
            realizado= bd.cambiarEstadoPedido(estado, id);
            if(realizado){
                cambiarEstadoPedido(id,(int)estado);
            }
            
            return realizado;
        } catch (MySqlException ex) {
            Console.WriteLine(ex.StackTrace);
        }
        return realizado;
    }

    public bool aceptarOferta(string id,string idPedido)
    {
        bool ped = false;
        if (aceptarOfertaFin(id))
        {
            ped = bd.cambiarEstadoOferta(EstadoOferta.FINISHED_OK, id);
            ped = ped && bd.cambiarEstadoPedido(EstadoPedido.FINISHED_OK, idPedido);
        }
        return ped;
    }

        // ============================
        private bool alta(string name, string email, string address, string city, string postalCode, string telephone)
        {
            DesguaceJavaWSClient client = new DesguaceJavaWSClient(/*Aquí irá jUDDI*/);
            return client.alta(name, email, address, city, int.Parse(postalCode), int.Parse(telephone));
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

        private bool baja(string id)
        {
            DesguaceJavaWSClient client = new DesguaceJavaWSClient(/*Aquí irá jUDDI*/);
            return client.baja(id);
        }

        private bool cancelarOferta(string id)
        {
            DesguaceJavaWSClient client = new DesguaceJavaWSClient(/*Aquí irá jUDDI*/);
            return client.cancelarOferta(id);
        }

        private bool cambiarEstadoPedido(string id, int estado) {
            DesguaceJavaWSClient client = new DesguaceJavaWSClient(/*Aquí irá jUDDI*/);
            return client.cambiarEstadoPedido(id,estado);
        }

    }
}
