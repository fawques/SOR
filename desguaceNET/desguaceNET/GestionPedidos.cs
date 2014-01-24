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

        public GestionPedidos()
        {
            InitializeComponent();
            DesguaceNet main = new DesguaceNet();
            listaPedidos = new List<Pedido>();
            listaOfertasActivas = main.actualizarOfertas();
            listaOfertasAceptadas = main.actualizarOfertasAceptadas();

            
            Pedido pedido1 = new Pedido("pedido1", 1, "taller1", DateTime.Today, new DateTime(),new DateTime(), EstadoPedido.ACTIVE, true, new List<Pieza>(), new List<int>(), new List<Oferta>());
            Pedido pedido2 = new Pedido("pedido2", 2, "taller1", DateTime.Today, new DateTime(), new DateTime(), EstadoPedido.ACTIVE, true, new List<Pieza>(), new List<int>(), new List<Oferta>());
            Pedido pedido3 = new Pedido("pedido3", 3, "taller2", DateTime.Today, new DateTime(), new DateTime(), EstadoPedido.ACTIVE, true, new List<Pieza>(), new List<int>(), new List<Oferta>());
            Pedido pedido4 = new Pedido("pedido4", 4, "taller3", DateTime.Today, new DateTime(), new DateTime(), EstadoPedido.ACTIVE, true, new List<Pieza>(), new List<int>(), new List<Oferta>());
            Pedido pedido5 = new Pedido("pedido5", 5, "taller2", DateTime.Today, new DateTime(), new DateTime(), EstadoPedido.ACTIVE, true, new List<Pieza>(), new List<int>(), new List<Oferta>());
            
            listaPedidos.Add(pedido1);
            listaPedidos.Add(pedido2);
            listaPedidos.Add(pedido3);
            listaPedidos.Add(pedido4);
            listaPedidos.Add(pedido5);
            dataGridView1.DataSource = listaPedidos;

            dataGridView2.DataSource = listaOfertasActivas;
            dataGridView3.DataSource = listaOfertasAceptadas;
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
                DesguaceNet main = new DesguaceNet();
                // anular la oferta 
                //idOfertaActiva
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
            DesguaceNet main = new DesguaceNet();
            Oferta of = main.crearOferta(DateTime.Today, fechaLimite, idPedido, precio);
            if (of != null)
            {
                listaOfertasActivas.Add(of);
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
                tbNombreTaller.Text = idOfertaActiva;
            }
        }

        private void dataGridView3_SelectionChanged(object sender, EventArgs e)
        {
            if (dataGridView3.SelectedRows.Count > 0)
            {
                idOfertaAceptada = (string)dataGridView3.SelectedRows[0].Cells[0].Value;
                tbNombreTaller.Text = idOfertaAceptada;
            }
        }
    }
}
