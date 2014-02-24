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
    public partial class ModificarDesguace : Form
    {
        public ModificarDesguace()
        {
            InitializeComponent();
            DesguaceNet main = new DesguaceNet();
            Desguace desguace = main.getDesguace();
            lb_ID_contenido.Text = desguace.getID();
            tbNombreDesguace.Text = desguace.getName();
            tbEmail.Text = desguace.getEmail();
            tbDireccion.Text = desguace.getAddress();
            tbCiudad.Text = desguace.getCity();
            tbCP.Text = desguace.getPostalCode().ToString();
            tbTelefono.Text = desguace.getTelephone().ToString();
        }

        private void btAceptar_Click(object sender, EventArgs e)
        {
            DesguaceNet main = new DesguaceNet();
            if (main.modificarDesguace(tbNombreDesguace.Text, tbEmail.Text, tbDireccion.Text, tbCiudad.Text, tbCP.Text, tbTelefono.Text))
            {
                Console.WriteLine("Modificación correcta");
                DialogResult = DialogResult.OK;
            }
            else
            {
                MessageBox.Show("Error al modificar, vuelve a intentarlo", "ERROR", MessageBoxButtons.OK);
            }
        }

        private void btCancelar_Click(object sender, EventArgs e)
        {
            Close();
        }
    }
}
