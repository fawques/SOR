using desguaceNET.libSOR.general;
using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace desguaceNET
{
    public partial class AltaDesguace : Form
    {
        public AltaDesguace()
        {
            InitializeComponent();
        }

        private void button1_Click(object sender, EventArgs e)
        {
            DesguaceNet main = new DesguaceNet();
            if (main.hacerAlta("pepe", "hola@email.com", "calle de las pipas", "ciudad", 123, 456))
            {
                Console.WriteLine("Alta ha devuelto true");
            }
            else
            {
                Console.WriteLine("Alta ha devuelto FALSE");
            }
        }

        private void button4_Click(object sender, EventArgs e)
        {
            DesguaceNet main = new DesguaceNet();
            if (main.comprobarActivacion("hola@email.com") != "")
            {
                Console.WriteLine("cuenta activada");
            }
            else
            {
                Console.WriteLine("cuenta no activada");
            }
        }

        private void button2_Click(object sender, EventArgs e)
        {
            Console.WriteLine("not implemented yet");
        }

        private void button3_Click(object sender, EventArgs e)
        {
            DesguaceNet main = new DesguaceNet();
            Oferta o = main.crearOferta(DateTime.Today, new DateTime(2020, 5, 15), "pedido", 13.5);
            if (o != null)
            {
                Console.WriteLine("oferta creada correctamente");
            }
            else
            {
                Console.WriteLine("ERROR creando oferta");
            }
        }
    }
}
