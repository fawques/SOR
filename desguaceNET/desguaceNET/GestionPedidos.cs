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
    public partial class GestionPedidos : Form
    {
        List<Pedido> listaPedidos;
        List<Oferta> listaOfertasActivas;
        List<Oferta> listaOfertasAceptadas;
        string idPedidoSelected;
        string idOfertaActiva;
        string idOfertaAceptada;
        string idPedidoAceptado;
        DesguaceNet main;

        public GestionPedidos()
        {
            InitializeComponent();
            main = new DesguaceNet();
            listaPedidos = new List<Pedido>();
            main.actualizarPedidos();
            listaOfertasActivas = main.actualizarOfertas();
            listaOfertasAceptadas = main.actualizarOfertasAceptadas();            
            listaPedidos = main.getPedidos();

            dataGridView1.DataSource = listaPedidos;

            dataGridView2.DataSource = listaOfertasActivas;
            dataGridView3.DataSource = listaOfertasAceptadas;
        }

        private void updatePedidos()
        {
            main.actualizarPedidos();
            listaPedidos = main.getPedidosActivos();
            dataGridView1.DataSource = null;
            dataGridView1.DataSource = listaPedidos;
        }

        private void updateOfertasActivas()
        {
            listaOfertasActivas = main.actualizarOfertas();
            dataGridView2.DataSource = null;
            dataGridView2.DataSource = listaOfertasActivas;
        }

        private void updateOfertasAceptadas()
        {
            main.CompararOfertasGestorDesguace();
            listaOfertasAceptadas = main.actualizarOfertasAceptadas();
            dataGridView3.DataSource = null;
            dataGridView3.DataSource = listaOfertasAceptadas;
        }

        private void updateHistoricoOfertas()
        {
            dataGridView5.DataSource = null;
            dataGridView5.DataSource = main.getOfertasLocal();
        }

        private void updateHistoricoPedidos()
        {
            dataGridView4.DataSource = null;
            dataGridView4.DataSource = main.getPedidos();
        }

        private void dataGridView1_CellContentClick(object sender, DataGridViewCellEventArgs e)
        {

        }

        private void panel1_Paint(object sender, PaintEventArgs e)
        {

        }

        private void comboBox1_SelectedIndexChanged(object sender, EventArgs e)
        {

        }

        private void label1_Click(object sender, EventArgs e)
        {

        }

        private void label3_Click(object sender, EventArgs e)
        {

        }

        private void GestionPedidos_Load(object sender, EventArgs e)
        {

        }

        private void label1_Click_1(object sender, EventArgs e)
        {

        }

        private void label6_Click(object sender, EventArgs e)
        {

        }

        private void label5_Click(object sender, EventArgs e)
        {

        }

        private void label8_Click(object sender, EventArgs e)
        {

        }

        private void dataGridView2_CellContentClick(object sender, DataGridViewCellEventArgs e)
        {

        }

        private void button1_Click(object sender, EventArgs e)
        {
            DialogResult res = MessageBox.Show("¿Estás seguro de que quieres cancelar esta oferta?","¿Cancelar?",MessageBoxButtons.YesNo);
            if(res == DialogResult.Yes){
                if (!main.cancelarOfertaDesguace(idOfertaActiva))
                {
                    MessageBox.Show("Error al cancelar la oferta", "ERROR", MessageBoxButtons.OK);
                }
            }
        }

        private void label4_Click(object sender, EventArgs e)
        {

        }

        private void btBuscarPedido_Click(object sender, EventArgs e)
        {
            string idPedido = tbNombreTaller.Text;
            double precio = double.Parse(tbPrecio.Text);
            DateTime fechaLimite = dtpFecha.Value;
            Oferta of = main.crearOferta(DateTime.Today, fechaLimite, idPedido, precio);
            if (of != null)
            {
                listaOfertasActivas.Add(of);
                dataGridView2.DataSource = null;
                dataGridView2.DataSource = listaOfertasActivas;
            }
            else
            {
                MessageBox.Show("Error al crear oferta", "ERROR", MessageBoxButtons.OK);
            }
        }

        private void dataGridView1_SelectionChanged(object sender, EventArgs e)
        {
            if (dataGridView1.SelectedRows.Count > 0)
            {
                idPedidoSelected = (string)dataGridView1.SelectedRows[0].Cells[0].Value;
                tbNombreTaller.Text = idPedidoSelected;
            }
        }

        private void dataGridView2_SelectionChanged(object sender, EventArgs e)
        {
            if (dataGridView2.SelectedRows.Count > 0)
            {
                idOfertaActiva = (string)dataGridView2.SelectedRows[0].Cells[0].Value;
            }
        }

        private void dataGridView3_SelectionChanged(object sender, EventArgs e)
        {
            if (dataGridView3.SelectedRows.Count > 0)
            {
                idOfertaAceptada = (string)dataGridView3.SelectedRows[0].Cells[0].Value;
                idPedidoAceptado = (string)dataGridView3.SelectedRows[0].Cells[7].Value;

            }
        }

        private void button1_Click_1(object sender, EventArgs e)
        {
            DialogResult res = MessageBox.Show("¿Estás seguro de que quieres darte de baja?", "¿Seguro?", MessageBoxButtons.YesNo);
            if (res == DialogResult.Yes)
            {
                if (main.bajaDesguace())
                {
                    DialogResult = DialogResult.Abort;
                }
                else
                {
                    MessageBox.Show("Error al procesar la baja", "ERROR", MessageBoxButtons.OK);
                }
            }
        }

        private void Pedidos_MouseClick(object sender, MouseEventArgs e)
        {
            updatePedidos();
            updateOfertasAceptadas();
            updateOfertasActivas();
            updateHistoricoOfertas();
            updateHistoricoPedidos();
        }

        private void Pedidos_SelectedIndexChanged(object sender, EventArgs e)
        {
            
        }

        private void btAceptarOferta_Click(object sender, EventArgs e)
        {
            if (!main.aceptarOferta(idOfertaAceptada, idPedidoAceptado))
            {
                MessageBox.Show("Error al aceptar oferta", "ERROR", MessageBoxButtons.OK);
            }
        }

        private void btAnularOfertaAceptada_Click(object sender, EventArgs e)
        {
            if (!main.cancelarOfertaDesguace(idOfertaAceptada, idPedidoAceptado))
            {
                MessageBox.Show("Error al aceptar oferta", "ERROR", MessageBoxButtons.OK);
            }
        }   

        
    }
}
