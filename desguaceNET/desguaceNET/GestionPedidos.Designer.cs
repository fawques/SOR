namespace desguaceNET
{
    partial class GestionPedidos
    {
        /// <summary>
        /// Required designer variable.
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary>
        /// Clean up any resources being used.
        /// </summary>
        /// <param name="disposing">true if managed resources should be disposed; otherwise, false.</param>
        protected override void Dispose(bool disposing)
        {
            if (disposing && (components != null))
            {
                components.Dispose();
            }
            base.Dispose(disposing);
        }

        #region Windows Form Designer generated code

        /// <summary>
        /// Required method for Designer support - do not modify
        /// the contents of this method with the code editor.
        /// </summary>
        private void InitializeComponent()
        {
            this.menuStrip1 = new System.Windows.Forms.MenuStrip();
            this.pedidosToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
            this.ofertasToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
            this.Pedidos = new System.Windows.Forms.TabControl();
            this.tabPage1 = new System.Windows.Forms.TabPage();
            this.Ofertas = new System.Windows.Forms.TabPage();
            this.panel1 = new System.Windows.Forms.Panel();
            this.tbPrecio = new System.Windows.Forms.TextBox();
            this.label3 = new System.Windows.Forms.Label();
            this.tbNombreTaller = new System.Windows.Forms.TextBox();
            this.dtpFecha = new System.Windows.Forms.DateTimePicker();
            this.label2 = new System.Windows.Forms.Label();
            this.label1 = new System.Windows.Forms.Label();
            this.dataGridView1 = new System.Windows.Forms.DataGridView();
            this.idPedido = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.idPedidoGestor = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.Taller = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.piezasPedidas = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.FechaLimite = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.envioOferta = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.panel2 = new System.Windows.Forms.Panel();
            this.textBox1 = new System.Windows.Forms.TextBox();
            this.label4 = new System.Windows.Forms.Label();
            this.textBox2 = new System.Windows.Forms.TextBox();
            this.dtpFechaLimite1 = new System.Windows.Forms.DateTimePicker();
            this.label5 = new System.Windows.Forms.Label();
            this.label6 = new System.Windows.Forms.Label();
            this.dataGridView2 = new System.Windows.Forms.DataGridView();
            this.btBuscarPedido = new System.Windows.Forms.Button();
            this.btBuscar = new System.Windows.Forms.Button();
            this.label7 = new System.Windows.Forms.Label();
            this.dtpFechaLimite2 = new System.Windows.Forms.DateTimePicker();
            this.tbpvp1 = new System.Windows.Forms.TextBox();
            this.label8 = new System.Windows.Forms.Label();
            this.label9 = new System.Windows.Forms.Label();
            this.tbpvp2 = new System.Windows.Forms.TextBox();
            this.dataGridViewTextBoxColumn1 = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.dataGridViewTextBoxColumn2 = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.dataGridViewTextBoxColumn3 = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.dataGridViewTextBoxColumn4 = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.dataGridViewTextBoxColumn5 = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.dataGridViewTextBoxColumn6 = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.Estado = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.menuStrip1.SuspendLayout();
            this.Pedidos.SuspendLayout();
            this.tabPage1.SuspendLayout();
            this.Ofertas.SuspendLayout();
            this.panel1.SuspendLayout();
            ((System.ComponentModel.ISupportInitialize)(this.dataGridView1)).BeginInit();
            this.panel2.SuspendLayout();
            ((System.ComponentModel.ISupportInitialize)(this.dataGridView2)).BeginInit();
            this.SuspendLayout();
            // 
            // menuStrip1
            // 
            this.menuStrip1.Items.AddRange(new System.Windows.Forms.ToolStripItem[] {
            this.pedidosToolStripMenuItem,
            this.ofertasToolStripMenuItem});
            this.menuStrip1.Location = new System.Drawing.Point(0, 0);
            this.menuStrip1.Name = "menuStrip1";
            this.menuStrip1.Size = new System.Drawing.Size(734, 24);
            this.menuStrip1.TabIndex = 2;
            this.menuStrip1.Text = "menuStrip1";
            // 
            // pedidosToolStripMenuItem
            // 
            this.pedidosToolStripMenuItem.Name = "pedidosToolStripMenuItem";
            this.pedidosToolStripMenuItem.Size = new System.Drawing.Size(61, 20);
            this.pedidosToolStripMenuItem.Text = "Pedidos";
            // 
            // ofertasToolStripMenuItem
            // 
            this.ofertasToolStripMenuItem.Name = "ofertasToolStripMenuItem";
            this.ofertasToolStripMenuItem.Size = new System.Drawing.Size(57, 20);
            this.ofertasToolStripMenuItem.Text = "Ofertas";
            // 
            // Pedidos
            // 
            this.Pedidos.Controls.Add(this.tabPage1);
            this.Pedidos.Controls.Add(this.Ofertas);
            this.Pedidos.Location = new System.Drawing.Point(0, 0);
            this.Pedidos.Name = "Pedidos";
            this.Pedidos.SelectedIndex = 0;
            this.Pedidos.Size = new System.Drawing.Size(734, 390);
            this.Pedidos.TabIndex = 3;
            // 
            // tabPage1
            // 
            this.tabPage1.Controls.Add(this.panel1);
            this.tabPage1.Controls.Add(this.dataGridView1);
            this.tabPage1.Location = new System.Drawing.Point(4, 22);
            this.tabPage1.Name = "tabPage1";
            this.tabPage1.Padding = new System.Windows.Forms.Padding(3);
            this.tabPage1.Size = new System.Drawing.Size(726, 364);
            this.tabPage1.TabIndex = 0;
            this.tabPage1.Text = "Pedidos";
            this.tabPage1.UseVisualStyleBackColor = true;
            // 
            // Ofertas
            // 
            this.Ofertas.Controls.Add(this.panel2);
            this.Ofertas.Controls.Add(this.dataGridView2);
            this.Ofertas.Location = new System.Drawing.Point(4, 22);
            this.Ofertas.Name = "Ofertas";
            this.Ofertas.Padding = new System.Windows.Forms.Padding(3);
            this.Ofertas.Size = new System.Drawing.Size(726, 364);
            this.Ofertas.TabIndex = 1;
            this.Ofertas.Text = "Ofertas";
            this.Ofertas.UseVisualStyleBackColor = true;
            // 
            // panel1
            // 
            this.panel1.Controls.Add(this.btBuscarPedido);
            this.panel1.Controls.Add(this.tbPrecio);
            this.panel1.Controls.Add(this.label3);
            this.panel1.Controls.Add(this.tbNombreTaller);
            this.panel1.Controls.Add(this.dtpFecha);
            this.panel1.Controls.Add(this.label2);
            this.panel1.Controls.Add(this.label1);
            this.panel1.Location = new System.Drawing.Point(29, 20);
            this.panel1.Name = "panel1";
            this.panel1.Size = new System.Drawing.Size(669, 131);
            this.panel1.TabIndex = 3;
            // 
            // tbPrecio
            // 
            this.tbPrecio.Location = new System.Drawing.Point(435, 34);
            this.tbPrecio.Name = "tbPrecio";
            this.tbPrecio.Size = new System.Drawing.Size(94, 20);
            this.tbPrecio.TabIndex = 6;
            // 
            // label3
            // 
            this.label3.AutoSize = true;
            this.label3.Location = new System.Drawing.Point(376, 37);
            this.label3.Name = "label3";
            this.label3.Size = new System.Drawing.Size(37, 13);
            this.label3.TabIndex = 5;
            this.label3.Text = "Precio";
            // 
            // tbNombreTaller
            // 
            this.tbNombreTaller.Location = new System.Drawing.Point(138, 31);
            this.tbNombreTaller.Name = "tbNombreTaller";
            this.tbNombreTaller.Size = new System.Drawing.Size(136, 20);
            this.tbNombreTaller.TabIndex = 4;
            // 
            // dtpFecha
            // 
            this.dtpFecha.Location = new System.Drawing.Point(138, 76);
            this.dtpFecha.Name = "dtpFecha";
            this.dtpFecha.Size = new System.Drawing.Size(199, 20);
            this.dtpFecha.TabIndex = 3;
            // 
            // label2
            // 
            this.label2.AutoSize = true;
            this.label2.Location = new System.Drawing.Point(31, 76);
            this.label2.Name = "label2";
            this.label2.Size = new System.Drawing.Size(65, 13);
            this.label2.TabIndex = 1;
            this.label2.Text = "Fecha límite";
            // 
            // label1
            // 
            this.label1.AutoSize = true;
            this.label1.Location = new System.Drawing.Point(31, 34);
            this.label1.Name = "label1";
            this.label1.Size = new System.Drawing.Size(53, 13);
            this.label1.TabIndex = 0;
            this.label1.Text = "ID pedido";
            this.label1.Click += new System.EventHandler(this.label1_Click_1);
            // 
            // dataGridView1
            // 
            this.dataGridView1.ColumnHeadersHeightSizeMode = System.Windows.Forms.DataGridViewColumnHeadersHeightSizeMode.AutoSize;
            this.dataGridView1.Columns.AddRange(new System.Windows.Forms.DataGridViewColumn[] {
            this.idPedido,
            this.idPedidoGestor,
            this.Taller,
            this.piezasPedidas,
            this.FechaLimite,
            this.envioOferta});
            this.dataGridView1.Location = new System.Drawing.Point(29, 177);
            this.dataGridView1.Name = "dataGridView1";
            this.dataGridView1.Size = new System.Drawing.Size(669, 168);
            this.dataGridView1.TabIndex = 2;
            // 
            // idPedido
            // 
            this.idPedido.HeaderText = "idPedido";
            this.idPedido.Name = "idPedido";
            // 
            // idPedidoGestor
            // 
            this.idPedidoGestor.HeaderText = "idPedidoGestor";
            this.idPedidoGestor.Name = "idPedidoGestor";
            // 
            // Taller
            // 
            this.Taller.HeaderText = "Taller";
            this.Taller.Name = "Taller";
            // 
            // piezasPedidas
            // 
            this.piezasPedidas.HeaderText = "Piezas pedidas";
            this.piezasPedidas.Name = "piezasPedidas";
            // 
            // FechaLimite
            // 
            this.FechaLimite.HeaderText = "Fecha Límite";
            this.FechaLimite.Name = "FechaLimite";
            // 
            // envioOferta
            // 
            this.envioOferta.HeaderText = "¿Enviada oferta?";
            this.envioOferta.Name = "envioOferta";
            // 
            // panel2
            // 
            this.panel2.Controls.Add(this.tbpvp2);
            this.panel2.Controls.Add(this.label9);
            this.panel2.Controls.Add(this.tbpvp1);
            this.panel2.Controls.Add(this.label8);
            this.panel2.Controls.Add(this.dtpFechaLimite2);
            this.panel2.Controls.Add(this.label7);
            this.panel2.Controls.Add(this.btBuscar);
            this.panel2.Controls.Add(this.textBox1);
            this.panel2.Controls.Add(this.label4);
            this.panel2.Controls.Add(this.textBox2);
            this.panel2.Controls.Add(this.dtpFechaLimite1);
            this.panel2.Controls.Add(this.label5);
            this.panel2.Controls.Add(this.label6);
            this.panel2.Location = new System.Drawing.Point(29, 20);
            this.panel2.Name = "panel2";
            this.panel2.Size = new System.Drawing.Size(669, 131);
            this.panel2.TabIndex = 5;
            // 
            // textBox1
            // 
            this.textBox1.Location = new System.Drawing.Point(372, 31);
            this.textBox1.Name = "textBox1";
            this.textBox1.Size = new System.Drawing.Size(94, 20);
            this.textBox1.TabIndex = 6;
            // 
            // label4
            // 
            this.label4.AutoSize = true;
            this.label4.Location = new System.Drawing.Point(313, 34);
            this.label4.Name = "label4";
            this.label4.Size = new System.Drawing.Size(33, 13);
            this.label4.TabIndex = 5;
            this.label4.Text = "Pieza";
            // 
            // textBox2
            // 
            this.textBox2.Location = new System.Drawing.Point(138, 31);
            this.textBox2.Name = "textBox2";
            this.textBox2.Size = new System.Drawing.Size(136, 20);
            this.textBox2.TabIndex = 4;
            // 
            // dtpFechaLimite1
            // 
            this.dtpFechaLimite1.Location = new System.Drawing.Point(138, 76);
            this.dtpFechaLimite1.Name = "dtpFechaLimite1";
            this.dtpFechaLimite1.Size = new System.Drawing.Size(199, 20);
            this.dtpFechaLimite1.TabIndex = 3;
            // 
            // label5
            // 
            this.label5.AutoSize = true;
            this.label5.Location = new System.Drawing.Point(31, 76);
            this.label5.Name = "label5";
            this.label5.Size = new System.Drawing.Size(92, 13);
            this.label5.TabIndex = 1;
            this.label5.Text = "Fecha límite entre";
            this.label5.Click += new System.EventHandler(this.label5_Click);
            // 
            // label6
            // 
            this.label6.AutoSize = true;
            this.label6.Location = new System.Drawing.Point(31, 34);
            this.label6.Name = "label6";
            this.label6.Size = new System.Drawing.Size(69, 13);
            this.label6.TabIndex = 0;
            this.label6.Text = "Nombre taller";
            this.label6.Click += new System.EventHandler(this.label6_Click);
            // 
            // dataGridView2
            // 
            this.dataGridView2.ColumnHeadersHeightSizeMode = System.Windows.Forms.DataGridViewColumnHeadersHeightSizeMode.AutoSize;
            this.dataGridView2.Columns.AddRange(new System.Windows.Forms.DataGridViewColumn[] {
            this.dataGridViewTextBoxColumn1,
            this.dataGridViewTextBoxColumn2,
            this.dataGridViewTextBoxColumn3,
            this.dataGridViewTextBoxColumn4,
            this.dataGridViewTextBoxColumn5,
            this.dataGridViewTextBoxColumn6,
            this.Estado});
            this.dataGridView2.Location = new System.Drawing.Point(29, 177);
            this.dataGridView2.Name = "dataGridView2";
            this.dataGridView2.Size = new System.Drawing.Size(669, 168);
            this.dataGridView2.TabIndex = 4;
            this.dataGridView2.CellContentClick += new System.Windows.Forms.DataGridViewCellEventHandler(this.dataGridView2_CellContentClick);
            // 
            // btBuscarPedido
            // 
            this.btBuscarPedido.Location = new System.Drawing.Point(545, 85);
            this.btBuscarPedido.Name = "btBuscarPedido";
            this.btBuscarPedido.Size = new System.Drawing.Size(96, 28);
            this.btBuscarPedido.TabIndex = 7;
            this.btBuscarPedido.Text = "Buscar";
            this.btBuscarPedido.UseVisualStyleBackColor = true;
            // 
            // btBuscar
            // 
            this.btBuscar.Location = new System.Drawing.Point(554, 85);
            this.btBuscar.Name = "btBuscar";
            this.btBuscar.Size = new System.Drawing.Size(96, 28);
            this.btBuscar.TabIndex = 8;
            this.btBuscar.Text = "Buscar";
            this.btBuscar.UseVisualStyleBackColor = true;
            // 
            // label7
            // 
            this.label7.AutoSize = true;
            this.label7.Location = new System.Drawing.Point(31, 100);
            this.label7.Name = "label7";
            this.label7.Size = new System.Drawing.Size(12, 13);
            this.label7.TabIndex = 9;
            this.label7.Text = "y";
            // 
            // dtpFechaLimite2
            // 
            this.dtpFechaLimite2.Location = new System.Drawing.Point(138, 102);
            this.dtpFechaLimite2.Name = "dtpFechaLimite2";
            this.dtpFechaLimite2.Size = new System.Drawing.Size(199, 20);
            this.dtpFechaLimite2.TabIndex = 10;
            // 
            // tbpvp1
            // 
            this.tbpvp1.Location = new System.Drawing.Point(554, 31);
            this.tbpvp1.Name = "tbpvp1";
            this.tbpvp1.Size = new System.Drawing.Size(94, 20);
            this.tbpvp1.TabIndex = 12;
            // 
            // label8
            // 
            this.label8.AutoSize = true;
            this.label8.Location = new System.Drawing.Point(495, 34);
            this.label8.Name = "label8";
            this.label8.Size = new System.Drawing.Size(55, 13);
            this.label8.TabIndex = 11;
            this.label8.Text = "PVP entre";
            this.label8.Click += new System.EventHandler(this.label8_Click);
            // 
            // label9
            // 
            this.label9.AutoSize = true;
            this.label9.Location = new System.Drawing.Point(495, 47);
            this.label9.Name = "label9";
            this.label9.Size = new System.Drawing.Size(12, 13);
            this.label9.TabIndex = 13;
            this.label9.Text = "y";
            // 
            // tbpvp2
            // 
            this.tbpvp2.Location = new System.Drawing.Point(554, 57);
            this.tbpvp2.Name = "tbpvp2";
            this.tbpvp2.Size = new System.Drawing.Size(94, 20);
            this.tbpvp2.TabIndex = 14;
            // 
            // dataGridViewTextBoxColumn1
            // 
            this.dataGridViewTextBoxColumn1.HeaderText = "idOferta";
            this.dataGridViewTextBoxColumn1.Name = "dataGridViewTextBoxColumn1";
            this.dataGridViewTextBoxColumn1.Width = 75;
            // 
            // dataGridViewTextBoxColumn2
            // 
            this.dataGridViewTextBoxColumn2.HeaderText = "idOfertaGestor";
            this.dataGridViewTextBoxColumn2.Name = "dataGridViewTextBoxColumn2";
            this.dataGridViewTextBoxColumn2.Width = 75;
            // 
            // dataGridViewTextBoxColumn3
            // 
            this.dataGridViewTextBoxColumn3.HeaderText = "Taller";
            this.dataGridViewTextBoxColumn3.Name = "dataGridViewTextBoxColumn3";
            // 
            // dataGridViewTextBoxColumn4
            // 
            this.dataGridViewTextBoxColumn4.HeaderText = "Piezas pedidas";
            this.dataGridViewTextBoxColumn4.Name = "dataGridViewTextBoxColumn4";
            // 
            // dataGridViewTextBoxColumn5
            // 
            this.dataGridViewTextBoxColumn5.HeaderText = "PVP ofrecido";
            this.dataGridViewTextBoxColumn5.Name = "dataGridViewTextBoxColumn5";
            // 
            // dataGridViewTextBoxColumn6
            // 
            this.dataGridViewTextBoxColumn6.HeaderText = "Fecha límite";
            this.dataGridViewTextBoxColumn6.Name = "dataGridViewTextBoxColumn6";
            // 
            // Estado
            // 
            this.Estado.HeaderText = "Estado";
            this.Estado.Name = "Estado";
            // 
            // GestionPedidos
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(734, 389);
            this.Controls.Add(this.Pedidos);
            this.Controls.Add(this.menuStrip1);
            this.Name = "GestionPedidos";
            this.Text = "GestionPedidos";
            this.Load += new System.EventHandler(this.GestionPedidos_Load);
            this.menuStrip1.ResumeLayout(false);
            this.menuStrip1.PerformLayout();
            this.Pedidos.ResumeLayout(false);
            this.tabPage1.ResumeLayout(false);
            this.Ofertas.ResumeLayout(false);
            this.panel1.ResumeLayout(false);
            this.panel1.PerformLayout();
            ((System.ComponentModel.ISupportInitialize)(this.dataGridView1)).EndInit();
            this.panel2.ResumeLayout(false);
            this.panel2.PerformLayout();
            ((System.ComponentModel.ISupportInitialize)(this.dataGridView2)).EndInit();
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.MenuStrip menuStrip1;
        private System.Windows.Forms.ToolStripMenuItem pedidosToolStripMenuItem;
        private System.Windows.Forms.ToolStripMenuItem ofertasToolStripMenuItem;
        private System.Windows.Forms.TabControl Pedidos;
        private System.Windows.Forms.TabPage tabPage1;
        private System.Windows.Forms.TabPage Ofertas;
        private System.Windows.Forms.Panel panel1;
        private System.Windows.Forms.TextBox tbPrecio;
        private System.Windows.Forms.Label label3;
        private System.Windows.Forms.TextBox tbNombreTaller;
        private System.Windows.Forms.DateTimePicker dtpFecha;
        private System.Windows.Forms.Label label2;
        private System.Windows.Forms.Label label1;
        private System.Windows.Forms.DataGridView dataGridView1;
        private System.Windows.Forms.DataGridViewTextBoxColumn idPedido;
        private System.Windows.Forms.DataGridViewTextBoxColumn idPedidoGestor;
        private System.Windows.Forms.DataGridViewTextBoxColumn Taller;
        private System.Windows.Forms.DataGridViewTextBoxColumn piezasPedidas;
        private System.Windows.Forms.DataGridViewTextBoxColumn FechaLimite;
        private System.Windows.Forms.DataGridViewTextBoxColumn envioOferta;
        private System.Windows.Forms.Panel panel2;
        private System.Windows.Forms.TextBox textBox1;
        private System.Windows.Forms.Label label4;
        private System.Windows.Forms.TextBox textBox2;
        private System.Windows.Forms.DateTimePicker dtpFechaLimite1;
        private System.Windows.Forms.Label label5;
        private System.Windows.Forms.Label label6;
        private System.Windows.Forms.DataGridView dataGridView2;
        private System.Windows.Forms.Button btBuscarPedido;
        private System.Windows.Forms.Button btBuscar;
        private System.Windows.Forms.DateTimePicker dtpFechaLimite2;
        private System.Windows.Forms.Label label7;
        private System.Windows.Forms.TextBox tbpvp1;
        private System.Windows.Forms.Label label8;
        private System.Windows.Forms.TextBox tbpvp2;
        private System.Windows.Forms.Label label9;
        private System.Windows.Forms.DataGridViewTextBoxColumn dataGridViewTextBoxColumn1;
        private System.Windows.Forms.DataGridViewTextBoxColumn dataGridViewTextBoxColumn2;
        private System.Windows.Forms.DataGridViewTextBoxColumn dataGridViewTextBoxColumn3;
        private System.Windows.Forms.DataGridViewTextBoxColumn dataGridViewTextBoxColumn4;
        private System.Windows.Forms.DataGridViewTextBoxColumn dataGridViewTextBoxColumn5;
        private System.Windows.Forms.DataGridViewTextBoxColumn dataGridViewTextBoxColumn6;
        private System.Windows.Forms.DataGridViewTextBoxColumn Estado;

    }
}