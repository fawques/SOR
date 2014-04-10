using desguaceNET.Async;
using desguaceNET.desguaceWS;
using desguaceNET.libSOR.activemq;
using desguaceNET.libSOR.BD;
using desguaceNET.libSOR.general;
using desguaceNET.libSOR.jUDDI;
using MySql.Data.MySqlClient;
using Newtonsoft.Json;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Reflection;
using System.ServiceModel;
using System.Text;
using System.Threading.Tasks;

namespace desguaceNET
{
    class DesguaceNet
    {
        InterfazBD bd;
        Desguace desguace;

        public DesguaceNet()
        {
            bd = new InterfazBD("sor_desguace");
            desguace = bd.getDesguace();
        }

        public Desguace getDesguace()
        {
            return desguace;
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
                string desguaceNombre = desguace.getName();
                int id = bd.anadirOferta(fechaAlta, (int)EstadoOferta.NEW, precio, idPedido, desguaceID, desguaceNombre, new DateTime(1970, 01, 01), fechaLimite);
                if (id != -1)
                {
                    Oferta nuevo = new Oferta(id, precio, desguaceID, desguaceNombre, idPedido, fechaLimite);
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

        public List<Accion> getAcciones()
        {
            AsyncManager async = new AsyncManager("sor_desguace");
            return async.getAcciones();
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


        public string comprobarActivacion(string contrasenya)
        {
            string id = checkActivacion(contrasenya);
            bd.activarDesguaceMainDesguace(id);
            return id;
        }

        public bool cancelarOfertaDesguace(string id, string idPedido = "")
        {
            if (cancelarOferta(id))
            {
                if (idPedido != "")
                {
                    bd.cambiarEstadoPedido(EstadoPedido.ACTIVE, idPedido);
                }
                return cambiarEstadoOferta(id, EstadoOferta.CANCELLED);
            }
            return false;
        }

        public bool cambiarEstadoOferta(string id, EstadoOferta estado)
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
                pedidoslista = bd.getPedidosConID_aux();
                return pedidoslista;

            }
            catch (MySqlException ex)
            {
                Console.WriteLine(ex.StackTrace);
            }
            return pedidoslista;
        }

        public List<Pedido> getPedidosActivos()
        {
            List<Pedido> pedidoslista = new List<Pedido>();
            try
            {
                pedidoslista = bd.getPedidosConID_aux(EstadoPedido.ACTIVE);
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

        public List<Pedido> actualizarPedidos()
        {
            string listaIdsstring = "";
            // coger los pedidos de activeMQ
            try
            {
                Gestor_activemq activemq = new Gestor_activemq();
                activemq.create_Consumer(desguace.getID());
                listaIdsstring = activemq.consumer.consumeMessage();
                activemq.consumer.closeConsumer();
            }
            catch (System.Net.Sockets.SocketException ex)
            {
                Console.WriteLine("activemequuuuuuuuuuuuu");
            }

            List<PedidoCorto> listaPedidosCortos = new List<PedidoCorto>();
            List<string> listaPedidosCortosstring = JsonConvert.DeserializeObject<List<string>>(listaIdsstring);
            PedidoCorto p = null;
            foreach (string item in listaPedidosCortosstring)
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
            return listaPedidos;
        }

        public bool cambiarEstadoPedidoDesguace(string id, EstadoPedido estado)
        {
            bool realizado = false;
            try
            {
                realizado = bd.cambiarEstadoPedido(estado, id);
                if (realizado)
                {
                    cambiarEstadoPedido(id, (estado).ToString());
                }

                return realizado;
            }
            catch (MySqlException ex)
            {
                Console.WriteLine(ex.StackTrace);
            }
            return realizado;
        }

        public bool aceptarOferta(string id, string idPedido)
        {
            bool ped = false;
            if (aceptarOfertaFin(id))
            {
                ped = bd.cambiarEstadoOferta(EstadoOferta.FINISHED_OK, id);
                ped = ped && bd.cambiarEstadoPedido(EstadoPedido.FINISHED_OK, idPedido);
                //cambiarEstadoPedido(idPedido, (EstadoPedido.FINISHED_OK).ToString());
            }
            return ped;
        }

        public List<Oferta> getOfertasLocal()
        {
            return bd.getOfertasConID_aux();
        }

        public void CompararOfertasGestorDesguace()
        {

            List<Oferta> ofertas = actualizarOfertas();
            List<Oferta> ofertasgestor = new List<Oferta>();
            string ofertasstring = getOfertas();
            if (ofertasstring != null && ofertasstring != "")
            {
                ofertasgestor = JsonConvert.DeserializeObject<List<Oferta>>(ofertasstring);
            }
            foreach (Oferta ofertagestor in ofertasgestor)
            {
                foreach (Oferta ofertadesguace in ofertas)
                {
                    if (ofertagestor.getID_aux() == ofertadesguace.getID_aux())
                    {
                        if (ofertadesguace.getID() != ofertagestor.getID())
                        {
                            bd.activarOfertaDesguace(ofertagestor.getID_aux(), ofertagestor.getID());
                        }
                        if (ofertagestor.getEstado() != ofertadesguace.getEstado())
                        {
                            cambiarEstadoOferta(ofertagestor.getID(), ofertagestor.getEstado());
                        }

                    }
                }
            }
        }

        public bool modificarDesguace(string name, string email, string address, string city, string postalCode, string telephone)
        {
            string id = desguace.getID();
            if (modificar(id, name, email, address, city, postalCode, telephone))
            {
                //METER en base de datos si está todo ok.
                if (bd.modificarDesguace(id,name, email, address, city, int.Parse(postalCode), int.Parse(telephone), desguace.getEstado()))
                {
                    desguace = bd.getDesguace();
                    Console.WriteLine("Esperando activación");
                    return true;
                }
                else
                {
                    //devolver un error
                    Console.WriteLine("Error en el alta en la bd");
                }
            }
            return false;

        }

        // ============================
        public bool alta(string name, string email, string address, string city, string postalCode, string telephone)
        {
            AsyncManager manager = new AsyncManager("sor_desguace");
            manager.ejecutarAcciones();
            for (int i = 0; i < 10; i++)
            {
                try
                {
                    var addr = new EndpointAddress("http://" + jUDDIProxy.getWsdl().Host + ":" + jUDDIProxy.getWsdl().Port + jUDDIProxy.getWsdl().AbsolutePath);
                    DesguaceJavaWSClient client = new DesguaceJavaWSClient("DesguaceJavaWSPort", addr);
                    return client.alta(name, email, address, city, postalCode, telephone);
                }
                catch (EndpointNotFoundException e) { }catch (TimeoutException e) { }
            }
            try
            {
                if (jUDDIProxy.loadHasChanged("DesguaceJavaWS"))
                {
                    return alta(name, email, address, city, postalCode, telephone);
                }
            }
            catch (EndpointNotFoundException e)
            {
                Console.WriteLine("NO SE HA PODIDO CONECTAR A JUDDI");
            }
            catch (TimeoutException e)
            {
                Console.WriteLine("NO SE HA PODIDO CONECTAR A JUDDI");
            }
            Console.WriteLine("NO SE HA PODIDO CONECTAR AL GESTOR");
            MethodBase m = MethodBase.GetCurrentMethod();
            string[] parametros = { name, email, address, city, postalCode, telephone };
            manager.guardarAccion(m, parametros);
            return false;
        }

        public string checkActivacion(string contrasenya)
        {
            AsyncManager manager = new AsyncManager("sor_desguace");
            manager.ejecutarAcciones();
            for (int i = 0; i < 10; i++)
            {
                try
                {
                    var address = new EndpointAddress("http://" + jUDDIProxy.getWsdl().Host + ":" + jUDDIProxy.getWsdl().Port + jUDDIProxy.getWsdl().AbsolutePath);
                    DesguaceJavaWSClient client = new DesguaceJavaWSClient("DesguaceJavaWSPort", address);
                    return client.checkActivacion(contrasenya);
                }
                catch (EndpointNotFoundException e) { }catch (TimeoutException e) { }
            }
            try
            {
                if (jUDDIProxy.loadHasChanged("DesguaceJavaWS"))
                {
                    return checkActivacion(contrasenya);
                }
            }
            catch (EndpointNotFoundException e)
            {
                Console.WriteLine("NO SE HA PODIDO CONECTAR A JUDDI");
            }
            catch (TimeoutException e)
            {
                Console.WriteLine("NO SE HA PODIDO CONECTAR A JUDDI");
            }
            Console.WriteLine("NO SE HA PODIDO CONECTAR AL GESTOR");
            return "";
        }


        public string nuevaOferta(string oferta)
        {
            AsyncManager manager = new AsyncManager("sor_desguace");
            manager.ejecutarAcciones();
            for (int i = 0; i < 10; i++)
            {
                try
                {
                    var address = new EndpointAddress("http://" + jUDDIProxy.getWsdl().Host + ":" + jUDDIProxy.getWsdl().Port + jUDDIProxy.getWsdl().AbsolutePath);
                    DesguaceJavaWSClient client = new DesguaceJavaWSClient("DesguaceJavaWSPort", address);
                    return client.nuevaOferta(oferta);
                }
                catch (EndpointNotFoundException e) { }catch (TimeoutException e) { }
            }
            try
            {
                if (jUDDIProxy.loadHasChanged("DesguaceJavaWS"))
                {
                    return nuevaOferta(oferta);
                }
            }
            catch (EndpointNotFoundException e)
            {
                Console.WriteLine("NO SE HA PODIDO CONECTAR A JUDDI");
            }
            catch (TimeoutException e)
            {
                Console.WriteLine("NO SE HA PODIDO CONECTAR A JUDDI");
            }
            Console.WriteLine("NO SE HA PODIDO CONECTAR AL GESTOR");
            MethodBase m = MethodBase.GetCurrentMethod();
            string[] parametros = { oferta };
            manager.guardarAccion(m, parametros);
            return "";
        }

        public string getOfertas()
        {
            AsyncManager manager = new AsyncManager("sor_desguace");
            manager.ejecutarAcciones();
            for (int i = 0; i < 10; i++)
            {
                try
                {
                    var address = new EndpointAddress("http://" + jUDDIProxy.getWsdl().Host + ":" + jUDDIProxy.getWsdl().Port + jUDDIProxy.getWsdl().AbsolutePath);
                    DesguaceJavaWSClient client = new DesguaceJavaWSClient("DesguaceJavaWSPort", address);
                    return client.getOfertas(desguace.getID());
                }
                catch (EndpointNotFoundException e) { }catch (TimeoutException e) { }
            }
            try
            {
                if (jUDDIProxy.loadHasChanged("DesguaceJavaWS"))
                {
                    return getOfertas();
                }
            }
            catch (EndpointNotFoundException e)
            {
                Console.WriteLine("NO SE HA PODIDO CONECTAR A JUDDI");
            }
            catch (TimeoutException e)
            {
                Console.WriteLine("NO SE HA PODIDO CONECTAR A JUDDI");
            }
            Console.WriteLine("NO SE HA PODIDO CONECTAR AL GESTOR");
            return "";
        }

        public string getPedidosporID(string str)
        {
            AsyncManager manager = new AsyncManager("sor_desguace");
            manager.ejecutarAcciones();
            for (int i = 0; i < 10; i++)
            {
                try
                {
                    var address = new EndpointAddress("http://" + jUDDIProxy.getWsdl().Host + ":" + jUDDIProxy.getWsdl().Port + jUDDIProxy.getWsdl().AbsolutePath);
                    DesguaceJavaWSClient client = new DesguaceJavaWSClient("DesguaceJavaWSPort", address);
                    return client.getPedidosporID(str);
                }
                catch (EndpointNotFoundException e) { }catch (TimeoutException e) { }
            }
            try
            {
                if (jUDDIProxy.loadHasChanged("DesguaceJavaWS"))
                {
                    return getPedidosporID(str);
                }
            }
            catch (EndpointNotFoundException e)
            {
                Console.WriteLine("NO SE HA PODIDO CONECTAR A JUDDI");
            }
            catch (TimeoutException e)
            {
                Console.WriteLine("NO SE HA PODIDO CONECTAR A JUDDI");
            }
            Console.WriteLine("NO SE HA PODIDO CONECTAR AL GESTOR");
            return "";
        }

        public bool aceptarOfertaFin(string id)
        {
            AsyncManager manager = new AsyncManager("sor_desguace");
            manager.ejecutarAcciones();
            for (int i = 0; i < 10; i++)
            {
                try
                {
                    var address = new EndpointAddress("http://" + jUDDIProxy.getWsdl().Host + ":" + jUDDIProxy.getWsdl().Port + jUDDIProxy.getWsdl().AbsolutePath);
                    DesguaceJavaWSClient client = new DesguaceJavaWSClient("DesguaceJavaWSPort", address);
                    return client.aceptarOfertaFin(id);
                }
                catch (EndpointNotFoundException e) { }catch (TimeoutException e) { }
            }
            try
            {
                if (jUDDIProxy.loadHasChanged("DesguaceJavaWS"))
                {
                    return aceptarOfertaFin(id);
                }
            }
            catch (EndpointNotFoundException e)
            {
                Console.WriteLine("NO SE HA PODIDO CONECTAR A JUDDI");
            }
            catch (TimeoutException e)
            {
                Console.WriteLine("NO SE HA PODIDO CONECTAR A JUDDI");
            }
            Console.WriteLine("NO SE HA PODIDO CONECTAR AL GESTOR");
            MethodBase m = MethodBase.GetCurrentMethod();
            string[] parametros = { id };
            manager.guardarAccion(m, parametros);
            return false;

        }

        public bool baja(string id)
        {
            AsyncManager manager = new AsyncManager("sor_desguace");
            manager.ejecutarAcciones();
            for (int i = 0; i < 10; i++)
            {
                try
                {
                    var address = new EndpointAddress("http://" + jUDDIProxy.getWsdl().Host + ":" + jUDDIProxy.getWsdl().Port + jUDDIProxy.getWsdl().AbsolutePath);
                    DesguaceJavaWSClient client = new DesguaceJavaWSClient("DesguaceJavaWSPort", address);
                    return client.baja(id);
                }
                catch (EndpointNotFoundException e) { }catch (TimeoutException e) { }
            }
            try
            {
                if (jUDDIProxy.loadHasChanged("DesguaceJavaWS"))
                {
                    return baja(id);
                }
            }
            catch (EndpointNotFoundException e)
            {
                Console.WriteLine("NO SE HA PODIDO CONECTAR A JUDDI");
            }
            catch (TimeoutException e)
            {
                Console.WriteLine("NO SE HA PODIDO CONECTAR A JUDDI");
            }
            Console.WriteLine("NO SE HA PODIDO CONECTAR AL GESTOR");
            MethodBase m = MethodBase.GetCurrentMethod();
            string[] parametros = { id };
            manager.guardarAccion(m, parametros);
            return false;
        }

        public bool cancelarOferta(string id)
        {
            AsyncManager manager = new AsyncManager("sor_desguace");
            manager.ejecutarAcciones();
            for (int i = 0; i < 10; i++)
            {
                try
                {
                    var address = new EndpointAddress("http://" + jUDDIProxy.getWsdl().Host + ":" + jUDDIProxy.getWsdl().Port + jUDDIProxy.getWsdl().AbsolutePath);
                    DesguaceJavaWSClient client = new DesguaceJavaWSClient("DesguaceJavaWSPort", address);
                    return client.cancelarOferta(id);
                }
                catch (EndpointNotFoundException e) { }catch (TimeoutException e) { }
            }
            try
            {
                if (jUDDIProxy.loadHasChanged("DesguaceJavaWS"))
                {
                    return cancelarOferta(id);
                }
            }
            catch (EndpointNotFoundException e)
            {
                Console.WriteLine("NO SE HA PODIDO CONECTAR A JUDDI");
            }
            catch (TimeoutException e)
            {
                Console.WriteLine("NO SE HA PODIDO CONECTAR A JUDDI");
            }
            Console.WriteLine("NO SE HA PODIDO CONECTAR AL GESTOR");
            MethodBase m = MethodBase.GetCurrentMethod();
            string[] parametros = { id };
            manager.guardarAccion(m, parametros);
            return false;
        }

        public bool cambiarEstadoPedido(string id, string estado)
        {
            AsyncManager manager = new AsyncManager("sor_desguace");
            manager.ejecutarAcciones();
            for (int i = 0; i < 10; i++)
            {
                try
                {
                    var address = new EndpointAddress("http://" + jUDDIProxy.getWsdl().Host + ":" + jUDDIProxy.getWsdl().Port + jUDDIProxy.getWsdl().AbsolutePath);
                    DesguaceJavaWSClient client = new DesguaceJavaWSClient("DesguaceJavaWSPort", address);
                    return client.cambiarEstadoPedidoOtravez(id, estado);
                }
                catch (EndpointNotFoundException e) { }
                catch (TimeoutException e) { }
            }
            try
            {
                if (jUDDIProxy.loadHasChanged("DesguaceJavaWS"))
                {
                    return cambiarEstadoPedido(id, estado);
                }
            }
            catch (EndpointNotFoundException e)
            {
                Console.WriteLine("NO SE HA PODIDO CONECTAR A JUDDI");
            }
            catch (TimeoutException e)
            {
                Console.WriteLine("NO SE HA PODIDO CONECTAR A JUDDI");
            }
            Console.WriteLine("NO SE HA PODIDO CONECTAR AL GESTOR");
            MethodBase m = MethodBase.GetCurrentMethod();
            string[] parametros = { id, estado };
            manager.guardarAccion(m, parametros);
            return false;
        }

        public bool modificar(string id, string name, string email, string address, string city, string postalCode, string telephone)
        {
            AsyncManager manager = new AsyncManager("sor_desguace");
            manager.ejecutarAcciones();
            for (int i = 0; i < 10; i++)
            {
                try
                {
                    var addr = new EndpointAddress("http://" + jUDDIProxy.getWsdl().Host + ":" + jUDDIProxy.getWsdl().Port + jUDDIProxy.getWsdl().AbsolutePath);
                    DesguaceJavaWSClient client = new DesguaceJavaWSClient("DesguaceJavaWSPort", addr);
                    return client.modificar(id, name, email, address, city, postalCode, telephone);
                }
                catch (EndpointNotFoundException e) { }
                catch (TimeoutException e) { }
            }
            try
            {
                if (jUDDIProxy.loadHasChanged("DesguaceJavaWS"))
                {
                    return modificar(id, name, email, address, city, postalCode, telephone);
                }
            }
            catch (EndpointNotFoundException e)
            {
                Console.WriteLine("NO SE HA PODIDO CONECTAR A JUDDI");
            }
            catch (TimeoutException e)
            {
                Console.WriteLine("NO SE HA PODIDO CONECTAR A JUDDI");
            }
            Console.WriteLine("NO SE HA PODIDO CONECTAR AL GESTOR");
            MethodBase m = MethodBase.GetCurrentMethod();
            string[] parametros = { id, name, email, address, city, postalCode, telephone };
            manager.guardarAccion(m, parametros);
            return false;

        }
        public  Boolean comprobarInicio(String usuario, String contrasenya){
        
                
                Boolean comprobar = bd.comprobarInicio(usuario, contrasenya);
        
                return comprobar;
          
        
        }

        public void anyadirRolUsuario(String nombre, String contrasenya, String rol)
        {

                
                bd.anyadirRolUsuario(nombre, contrasenya, rol);
               




        }
        public void anyadirRol(String rol,List<int> listaOpciones)
        {


            bd.anyadirRol(rol,listaOpciones);





        }


    }
}
