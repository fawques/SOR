using desguaceNET.desguaceWS;
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
            if (main.alta("pepe", "hola@email.com", "calle de las pipas", "ciudad", 123, 456))
            {
                Console.WriteLine("Alta ha devuelto true");
            }
            else
            {
                Console.WriteLine("Alta ha devuelto FALSE");
            }
        }
    }
}
