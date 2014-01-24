using desguaceNET.libSOR.BD;
using desguaceNET.libSOR.general;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace desguaceNET
{
    static class Program
    {
        /// <summary>
        /// Punto de entrada principal para la aplicación.
        /// </summary>
        [STAThread]
        static void Main()
        {
            Application.EnableVisualStyles();
            Application.SetCompatibleTextRenderingDefault(false);

            InterfazBD bd = new InterfazBD("sor_desguace");
            Desguace desguace = bd.getDesguace();
            if (desguace == null)
            {
                AltaDesguace alta = new AltaDesguace();
                alta.ShowDialog();
                desguace = bd.getDesguace();
            }

            if (desguace.getEstado() == EstadoGeneral.INACTIVE)
            {
                /*DesguaceDeBaja baja = new DesguaceDeBaja();
                baja.ShowDialog();*/
                /*if (baja.DialogResult == DialogResult.OK)
                {
                    desguace.setPendiente();
                }*/
            }

            if (desguace.getEstado() == EstadoGeneral.PENDIENTE) //pendiente de activacion
            {
                DesguacerPendienteActivacion pendiente = new DesguacerPendienteActivacion();
                pendiente.ShowDialog();
                if (pendiente.DialogResult == DialogResult.OK) {
                    string id = pendiente.idResult;
                    desguace.activar(id);
                }
            }

            if (desguace.getEstado() == EstadoGeneral.ACTIVE)
            { //activo
                //Cargar GestionPedido
                GestionPedidos pedidos = new GestionPedidos();
                pedidos.ShowDialog();

            }
            
            
        }
    }
}
