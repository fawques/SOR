using desguaceNET.libSOR.BD;
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
    public partial class DesguacerPendienteActivacion : Form
    {
        public string idResult { get; set; }

        public DesguacerPendienteActivacion()
        {
            InitializeComponent();
        }

        private void DesguacerPendienteActivacion_Load(object sender, EventArgs e)
        {

        }

        private void button1_Click(object sender, EventArgs e)
        {
            InterfazBD bd = new InterfazBD("sor_desguace");
            Desguace desguace = bd.getDesguace();
            DesguaceNet main = new DesguaceNet();
            string id = main.comprobarActivacion(tbValidar.Text);
            if (id != "")
            {
                idResult = id;
                DialogResult = DialogResult.OK;
            }
        }
    }
}
