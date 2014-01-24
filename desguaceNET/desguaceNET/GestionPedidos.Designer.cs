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
            this.btBaja = new System.Windows.Forms.Button();
            this.label5 = new System.Windows.Forms.Label();
            this.panel1 = new System.Windows.Forms.Panel();
            this.btBuscarPedido = new System.Windows.Forms.Button();
            this.tbPrecio = new System.Windows.Forms.TextBox();
            this.label3 = new System.Windows.Forms.Label();
            this.tbIDPedido = new System.Windows.Forms.TextBox();
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
            this.Ofertas = new System.Windows.Forms.TabPage();
            this.button1 = new System.Windows.Forms.Button();
            this.label4 = new System.Windows.Forms.Label();
            this.btAnularOfertaAceptada = new System.Windows.Forms.Button();
            this.btAceptarOferta = new System.Windows.Forms.Button();
            this.btAnularOferta = new System.Windows.Forms.Button();
            this.dgvOfertasAceptadas = new System.Windows.Forms.DataGridView();
            this.dataGridViewTextBoxColumn7 = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.dataGridViewTextBoxColumn8 = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.dataGridViewTextBoxColumn9 = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.dataGridViewTextBoxColumn10 = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.dataGridViewTextBoxColumn11 = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.dataGridViewTextBoxColumn12 = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.dataGridViewTextBoxColumn13 = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.dgvOfertasEnviadas = new System.Windows.Forms.DataGridView();
            this.dataGridViewTextBoxColumn1 = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.dataGridViewTextBoxColumn2 = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.dataGridViewTextBoxColumn3 = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.dataGridViewTextBoxColumn4 = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.dataGridViewTextBoxColumn5 = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.dataGridViewTextBoxColumn6 = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.Estado = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.tpHistorico = new System.Windows.Forms.TabPage();
            this.label6 = new System.Windows.Forms.Label();
            this.dgvHistorico = new System.Windows.Forms.DataGridView();
            this.dataGridViewTextBoxColumn14 = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.dataGridViewTextBoxColumn15 = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.dataGridViewTextBoxColumn16 = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.dataGridViewTextBoxColumn17 = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.dataGridViewTextBoxColumn18 = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.dataGridViewTextBoxColumn19 = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.menuStrip1.SuspendLayout();
            this.Pedidos.SuspendLayout();
            this.tabPage1.SuspendLayout();
            this.panel1.SuspendLayout();
            ((System.ComponentModel.ISupportInitialize)(this.dataGridView1)).BeginInit();
            this.Ofertas.SuspendLayout();
            ((System.ComponentModel.ISupportInitialize)(this.dgvOfertasAceptadas)).BeginInit();
            ((System.ComponentModel.ISupportInitialize)(this.dgvOfertasEnviadas)).BeginInit();
            this.tpHistorico.SuspendLayout();
            ((System.ComponentModel.ISupportInitialize)(this.dgvHistorico)).BeginInit();
            this.SuspendLayout();
            // 
            // menuStrip1
            // 
            this.menuStrip1.Items.AddRange(new System.Windows.Forms.ToolStripItem[] {
            this.pedidosToolStripMenuItem,
            this.ofertasToolStripMenuItem});
            this.menuStrip1.Location = new System.Drawing.Point(0, 0);
            this.menuStrip1.Name = "menuStrip1";
            this.menuStrip1.Size = new System.Drawing.Size(733, 24);
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
            this.Pedidos.Controls.Add(this.tpHistorico);
            this.Pedidos.Location = new System.Drawing.Point(0, 0);
            this.Pedidos.Name = "Pedidos";
            this.Pedidos.SelectedIndex = 0;
            this.Pedidos.Size = new System.Drawing.Size(733, 542);
            this.Pedidos.TabIndex = 3;
            // 
            // tabPage1
            // 
            this.tabPage1.Controls.Add(this.btBaja);
            this.tabPage1.Controls.Add(this.label5);
            this.tabPage1.Controls.Add(this.panel1);
            this.tabPage1.Controls.Add(this.dataGridView1);
            this.tabPage1.Location = new System.Drawing.Point(4, 22);
            this.tabPage1.Name = "tabPage1";
            this.tabPage1.Padding = new System.Windows.Forms.Padding(3);
            this.tabPage1.Size = new System.Drawing.Size(725, 516);
            this.tabPage1.TabIndex = 0;
            this.tabPage1.Text = "Pedidos";
            this.tabPage1.UseVisualStyleBackColor = true;
            // 
            // btBaja
            // 
            this.btBaja.Location = new System.Drawing.Point(602, 480);
            this.btBaja.Name = "btBaja";
            this.btBaja.Size = new System.Drawing.Size(96, 28);
            this.btBaja.TabIndex = 8;
            this.btBaja.Text = "Dar de baja";
            this.btBaja.UseVisualStyleBackColor = true;
            // 
            // label5
            // 
            this.label5.AutoSize = true;
            this.label5.Font = new System.Drawing.Font("Microsoft Sans Serif", 14.25F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.label5.Location = new System.Drawing.Point(275, 171);
            this.label5.Name = "label5";
            this.label5.Size = new System.Drawing.Size(161, 24);
            this.label5.TabIndex = 11;
            this.label5.Text = "Pedidos recibidos";
            // 
            // panel1
            // 
            this.panel1.Controls.Add(this.btBuscarPedido);
            this.panel1.Controls.Add(this.tbPrecio);
            this.panel1.Controls.Add(this.label3);
            this.panel1.Controls.Add(this.tbIDPedido);
            this.panel1.Controls.Add(this.dtpFecha);
            this.panel1.Controls.Add(this.label2);
            this.panel1.Controls.Add(this.label1);
            this.panel1.Location = new System.Drawing.Point(29, 20);
            this.panel1.Name = "panel1";
            this.panel1.Size = new System.Drawing.Size(669, 131);
            this.panel1.TabIndex = 3;
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
            // tbIDPedido
            // 
            this.tbIDPedido.Location = new System.Drawing.Point(138, 31);
            this.tbIDPedido.Name = "tbIDPedido";
            this.tbIDPedido.Size = new System.Drawing.Size(136, 20);
            this.tbIDPedido.TabIndex = 4;
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
            this.dataGridView1.Location = new System.Drawing.Point(29, 209);
            this.dataGridView1.Name = "dataGridView1";
            this.dataGridView1.Size = new System.Drawing.Size(669, 265);
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
            // Ofertas
            // 
            this.Ofertas.Controls.Add(this.button1);
            this.Ofertas.Controls.Add(this.label4);
            this.Ofertas.Controls.Add(this.btAnularOfertaAceptada);
            this.Ofertas.Controls.Add(this.btAceptarOferta);
            this.Ofertas.Controls.Add(this.btAnularOferta);
            this.Ofertas.Controls.Add(this.dgvOfertasAceptadas);
            this.Ofertas.Controls.Add(this.dgvOfertasEnviadas);
            this.Ofertas.Location = new System.Drawing.Point(4, 22);
            this.Ofertas.Name = "Ofertas";
            this.Ofertas.Padding = new System.Windows.Forms.Padding(3);
            this.Ofertas.Size = new System.Drawing.Size(725, 516);
            this.Ofertas.TabIndex = 1;
            this.Ofertas.Text = "Ofertas";
            this.Ofertas.UseVisualStyleBackColor = true;
            // 
            // button1
            // 
            this.button1.Location = new System.Drawing.Point(602, 476);
            this.button1.Name = "button1";
            this.button1.Size = new System.Drawing.Size(96, 28);
            this.button1.TabIndex = 11;
            this.button1.Text = "Dar de baja";
            this.button1.UseVisualStyleBackColor = true;
            // 
            // label4
            // 
            this.label4.AutoSize = true;
            this.label4.Font = new System.Drawing.Font("Microsoft Sans Serif", 14.25F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.label4.Location = new System.Drawing.Point(269, 14);
            this.label4.Name = "label4";
            this.label4.Size = new System.Drawing.Size(149, 24);
            this.label4.TabIndex = 10;
            this.label4.Text = "Ofertas enviadas";
            this.label4.Click += new System.EventHandler(this.label4_Click);
            // 
            // btAnularOfertaAceptada
            // 
            this.btAnularOfertaAceptada.Location = new System.Drawing.Point(154, 479);
            this.btAnularOfertaAceptada.Name = "btAnularOfertaAceptada";
            this.btAnularOfertaAceptada.Size = new System.Drawing.Size(147, 23);
            this.btAnularOfertaAceptada.TabIndex = 9;
            this.btAnularOfertaAceptada.Text = "Anular oferta aceptada";
            this.btAnularOfertaAceptada.UseVisualStyleBackColor = true;
            // 
            // btAceptarOferta
            // 
            this.btAceptarOferta.Location = new System.Drawing.Point(29, 479);
            this.btAceptarOferta.Name = "btAceptarOferta";
            this.btAceptarOferta.Size = new System.Drawing.Size(102, 23);
            this.btAceptarOferta.TabIndex = 8;
            this.btAceptarOferta.Text = "Aceptar oferta";
            this.btAceptarOferta.UseVisualStyleBackColor = true;
            // 
            // btAnularOferta
            // 
            this.btAnularOferta.Location = new System.Drawing.Point(29, 256);
            this.btAnularOferta.Name = "btAnularOferta";
            this.btAnularOferta.Size = new System.Drawing.Size(102, 23);
            this.btAnularOferta.TabIndex = 7;
            this.btAnularOferta.Text = "Anular oferta enviada";
            this.btAnularOferta.UseVisualStyleBackColor = true;
            this.btAnularOferta.Click += new System.EventHandler(this.button1_Click);
            // 
            // dgvOfertasAceptadas
            // 
            this.dgvOfertasAceptadas.ColumnHeadersHeightSizeMode = System.Windows.Forms.DataGridViewColumnHeadersHeightSizeMode.AutoSize;
            this.dgvOfertasAceptadas.Columns.AddRange(new System.Windows.Forms.DataGridViewColumn[] {
            this.dataGridViewTextBoxColumn7,
            this.dataGridViewTextBoxColumn8,
            this.dataGridViewTextBoxColumn9,
            this.dataGridViewTextBoxColumn10,
            this.dataGridViewTextBoxColumn11,
            this.dataGridViewTextBoxColumn12,
            this.dataGridViewTextBoxColumn13});
            this.dgvOfertasAceptadas.Location = new System.Drawing.Point(29, 285);
            this.dgvOfertasAceptadas.Name = "dgvOfertasAceptadas";
            this.dgvOfertasAceptadas.Size = new System.Drawing.Size(669, 180);
            this.dgvOfertasAceptadas.TabIndex = 6;
            // 
            // dataGridViewTextBoxColumn7
            // 
            this.dataGridViewTextBoxColumn7.HeaderText = "idOferta";
            this.dataGridViewTextBoxColumn7.Name = "dataGridViewTextBoxColumn7";
            this.dataGridViewTextBoxColumn7.Width = 75;
            // 
            // dataGridViewTextBoxColumn8
            // 
            this.dataGridViewTextBoxColumn8.HeaderText = "idOfertaGestor";
            this.dataGridViewTextBoxColumn8.Name = "dataGridViewTextBoxColumn8";
            this.dataGridViewTextBoxColumn8.Width = 75;
            // 
            // dataGridViewTextBoxColumn9
            // 
            this.dataGridViewTextBoxColumn9.HeaderText = "Taller";
            this.dataGridViewTextBoxColumn9.Name = "dataGridViewTextBoxColumn9";
            // 
            // dataGridViewTextBoxColumn10
            // 
            this.dataGridViewTextBoxColumn10.HeaderText = "Piezas pedidas";
            this.dataGridViewTextBoxColumn10.Name = "dataGridViewTextBoxColumn10";
            // 
            // dataGridViewTextBoxColumn11
            // 
            this.dataGridViewTextBoxColumn11.HeaderText = "PVP ofrecido";
            this.dataGridViewTextBoxColumn11.Name = "dataGridViewTextBoxColumn11";
            // 
            // dataGridViewTextBoxColumn12
            // 
            this.dataGridViewTextBoxColumn12.HeaderText = "Fecha límite";
            this.dataGridViewTextBoxColumn12.Name = "dataGridViewTextBoxColumn12";
            // 
            // dataGridViewTextBoxColumn13
            // 
            this.dataGridViewTextBoxColumn13.HeaderText = "Estado";
            this.dataGridViewTextBoxColumn13.Name = "dataGridViewTextBoxColumn13";
            // 
            // dgvOfertasEnviadas
            // 
            this.dgvOfertasEnviadas.ColumnHeadersHeightSizeMode = System.Windows.Forms.DataGridViewColumnHeadersHeightSizeMode.AutoSize;
            this.dgvOfertasEnviadas.Columns.AddRange(new System.Windows.Forms.DataGridViewColumn[] {
            this.dataGridViewTextBoxColumn1,
            this.dataGridViewTextBoxColumn2,
            this.dataGridViewTextBoxColumn3,
            this.dataGridViewTextBoxColumn4,
            this.dataGridViewTextBoxColumn5,
            this.dataGridViewTextBoxColumn6,
            this.Estado});
            this.dgvOfertasEnviadas.Location = new System.Drawing.Point(29, 41);
            this.dgvOfertasEnviadas.Name = "dgvOfertasEnviadas";
            this.dgvOfertasEnviadas.Size = new System.Drawing.Size(669, 201);
            this.dgvOfertasEnviadas.TabIndex = 4;
            this.dgvOfertasEnviadas.CellContentClick += new System.Windows.Forms.DataGridViewCellEventHandler(this.dataGridView2_CellContentClick);
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
            // tpHistorico
            // 
            this.tpHistorico.Controls.Add(this.label6);
            this.tpHistorico.Controls.Add(this.dgvHistorico);
            this.tpHistorico.Location = new System.Drawing.Point(4, 22);
            this.tpHistorico.Name = "tpHistorico";
            this.tpHistorico.Padding = new System.Windows.Forms.Padding(3);
            this.tpHistorico.Size = new System.Drawing.Size(725, 516);
            this.tpHistorico.TabIndex = 2;
            this.tpHistorico.Text = "Histórico";
            this.tpHistorico.UseVisualStyleBackColor = true;
            // 
            // label6
            // 
            this.label6.AutoSize = true;
            this.label6.Font = new System.Drawing.Font("Microsoft Sans Serif", 14.25F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.label6.Location = new System.Drawing.Point(275, 34);
            this.label6.Name = "label6";
            this.label6.Size = new System.Drawing.Size(193, 24);
            this.label6.TabIndex = 13;
            this.label6.Text = "Histórico operaciones";
            this.label6.Click += new System.EventHandler(this.label6_Click_1);
            // 
            // dgvHistorico
            // 
            this.dgvHistorico.ColumnHeadersHeightSizeMode = System.Windows.Forms.DataGridViewColumnHeadersHeightSizeMode.AutoSize;
            this.dgvHistorico.Columns.AddRange(new System.Windows.Forms.DataGridViewColumn[] {
            this.dataGridViewTextBoxColumn14,
            this.dataGridViewTextBoxColumn15,
            this.dataGridViewTextBoxColumn16,
            this.dataGridViewTextBoxColumn17,
            this.dataGridViewTextBoxColumn18,
            this.dataGridViewTextBoxColumn19});
            this.dgvHistorico.Location = new System.Drawing.Point(28, 88);
            this.dgvHistorico.Name = "dgvHistorico";
            this.dgvHistorico.Size = new System.Drawing.Size(669, 382);
            this.dgvHistorico.TabIndex = 12;
            // 
            // dataGridViewTextBoxColumn14
            // 
            this.dataGridViewTextBoxColumn14.HeaderText = "idPedido";
            this.dataGridViewTextBoxColumn14.Name = "dataGridViewTextBoxColumn14";
            // 
            // dataGridViewTextBoxColumn15
            // 
            this.dataGridViewTextBoxColumn15.HeaderText = "idPedidoGestor";
            this.dataGridViewTextBoxColumn15.Name = "dataGridViewTextBoxColumn15";
            // 
            // dataGridViewTextBoxColumn16
            // 
            this.dataGridViewTextBoxColumn16.HeaderText = "Taller";
            this.dataGridViewTextBoxColumn16.Name = "dataGridViewTextBoxColumn16";
            // 
            // dataGridViewTextBoxColumn17
            // 
            this.dataGridViewTextBoxColumn17.HeaderText = "Piezas pedidas";
            this.dataGridViewTextBoxColumn17.Name = "dataGridViewTextBoxColumn17";
            // 
            // dataGridViewTextBoxColumn18
            // 
            this.dataGridViewTextBoxColumn18.HeaderText = "Fecha Límite";
            this.dataGridViewTextBoxColumn18.Name = "dataGridViewTextBoxColumn18";
            // 
            // dataGridViewTextBoxColumn19
            // 
            this.dataGridViewTextBoxColumn19.HeaderText = "¿Enviada oferta?";
            this.dataGridViewTextBoxColumn19.Name = "dataGridViewTextBoxColumn19";
            // 
            // GestionPedidos
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(733, 536);
            this.Controls.Add(this.Pedidos);
            this.Controls.Add(this.menuStrip1);
            this.Name = "GestionPedidos";
            this.Text = "GestionPedidos";
            this.Load += new System.EventHandler(this.GestionPedidos_Load);
            this.menuStrip1.ResumeLayout(false);
            this.menuStrip1.PerformLayout();
            this.Pedidos.ResumeLayout(false);
            this.tabPage1.ResumeLayout(false);
            this.tabPage1.PerformLayout();
            this.panel1.ResumeLayout(false);
            this.panel1.PerformLayout();
            ((System.ComponentModel.ISupportInitialize)(this.dataGridView1)).EndInit();
            this.Ofertas.ResumeLayout(false);
            this.Ofertas.PerformLayout();
            ((System.ComponentModel.ISupportInitialize)(this.dgvOfertasAceptadas)).EndInit();
            ((System.ComponentModel.ISupportInitialize)(this.dgvOfertasEnviadas)).EndInit();
            this.tpHistorico.ResumeLayout(false);
            this.tpHistorico.PerformLayout();
            ((System.ComponentModel.ISupportInitialize)(this.dgvHistorico)).EndInit();
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
        private System.Windows.Forms.TextBox tbIDPedido;
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
        private System.Windows.Forms.DataGridView dgvOfertasEnviadas;
        private System.Windows.Forms.Button btBuscarPedido;
        private System.Windows.Forms.DataGridViewTextBoxColumn dataGridViewTextBoxColumn1;
        private System.Windows.Forms.DataGridViewTextBoxColumn dataGridViewTextBoxColumn2;
        private System.Windows.Forms.DataGridViewTextBoxColumn dataGridViewTextBoxColumn3;
        private System.Windows.Forms.DataGridViewTextBoxColumn dataGridViewTextBoxColumn4;
        private System.Windows.Forms.DataGridViewTextBoxColumn dataGridViewTextBoxColumn5;
        private System.Windows.Forms.DataGridViewTextBoxColumn dataGridViewTextBoxColumn6;
        private System.Windows.Forms.DataGridViewTextBoxColumn Estado;
        private System.Windows.Forms.DataGridView dgvOfertasAceptadas;
        private System.Windows.Forms.DataGridViewTextBoxColumn dataGridViewTextBoxColumn7;
        private System.Windows.Forms.DataGridViewTextBoxColumn dataGridViewTextBoxColumn8;
        private System.Windows.Forms.DataGridViewTextBoxColumn dataGridViewTextBoxColumn9;
        private System.Windows.Forms.DataGridViewTextBoxColumn dataGridViewTextBoxColumn10;
        private System.Windows.Forms.DataGridViewTextBoxColumn dataGridViewTextBoxColumn11;
        private System.Windows.Forms.DataGridViewTextBoxColumn dataGridViewTextBoxColumn12;
        private System.Windows.Forms.DataGridViewTextBoxColumn dataGridViewTextBoxColumn13;
        private System.Windows.Forms.Button btAnularOferta;
        private System.Windows.Forms.Button btAnularOfertaAceptada;
        private System.Windows.Forms.Button btAceptarOferta;
        private System.Windows.Forms.Label label4;
        private System.Windows.Forms.Label label5;
        private System.Windows.Forms.Button btBaja;
        private System.Windows.Forms.Button button1;
        private System.Windows.Forms.TabPage tpHistorico;
        private System.Windows.Forms.Label label6;
        private System.Windows.Forms.DataGridView dgvHistorico;
        private System.Windows.Forms.DataGridViewTextBoxColumn dataGridViewTextBoxColumn14;
        private System.Windows.Forms.DataGridViewTextBoxColumn dataGridViewTextBoxColumn15;
        private System.Windows.Forms.DataGridViewTextBoxColumn dataGridViewTextBoxColumn16;
        private System.Windows.Forms.DataGridViewTextBoxColumn dataGridViewTextBoxColumn17;
        private System.Windows.Forms.DataGridViewTextBoxColumn dataGridViewTextBoxColumn18;
        private System.Windows.Forms.DataGridViewTextBoxColumn dataGridViewTextBoxColumn19;

    }
}