namespace desguaceNET
{
    partial class NuevaOferta
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
            this.tbIDOferta = new System.Windows.Forms.TextBox();
            this.label1 = new System.Windows.Forms.Label();
            this.taPiezas = new System.Windows.Forms.TextBox();
            this.label2 = new System.Windows.Forms.Label();
            this.tbPVP = new System.Windows.Forms.TextBox();
            this.label3 = new System.Windows.Forms.Label();
            this.dtpFechaLimite = new System.Windows.Forms.DateTimePicker();
            this.label4 = new System.Windows.Forms.Label();
            this.dtpFechaEntrega = new System.Windows.Forms.DateTimePicker();
            this.label5 = new System.Windows.Forms.Label();
            this.SuspendLayout();
            // 
            // tbIDOferta
            // 
            this.tbIDOferta.Location = new System.Drawing.Point(157, 53);
            this.tbIDOferta.Name = "tbIDOferta";
            this.tbIDOferta.Size = new System.Drawing.Size(136, 20);
            this.tbIDOferta.TabIndex = 6;
            // 
            // label1
            // 
            this.label1.AutoSize = true;
            this.label1.Location = new System.Drawing.Point(50, 56);
            this.label1.Name = "label1";
            this.label1.Size = new System.Drawing.Size(48, 13);
            this.label1.TabIndex = 5;
            this.label1.Text = "ID oferta";
            this.label1.Click += new System.EventHandler(this.label1_Click);
            // 
            // taPiezas
            // 
            this.taPiezas.Location = new System.Drawing.Point(157, 89);
            this.taPiezas.Multiline = true;
            this.taPiezas.Name = "taPiezas";
            this.taPiezas.Size = new System.Drawing.Size(136, 106);
            this.taPiezas.TabIndex = 8;
            // 
            // label2
            // 
            this.label2.AutoSize = true;
            this.label2.Location = new System.Drawing.Point(50, 92);
            this.label2.Name = "label2";
            this.label2.Size = new System.Drawing.Size(38, 13);
            this.label2.TabIndex = 7;
            this.label2.Text = "Piezas";
            // 
            // tbPVP
            // 
            this.tbPVP.Location = new System.Drawing.Point(157, 210);
            this.tbPVP.Name = "tbPVP";
            this.tbPVP.Size = new System.Drawing.Size(136, 20);
            this.tbPVP.TabIndex = 10;
            // 
            // label3
            // 
            this.label3.AutoSize = true;
            this.label3.Location = new System.Drawing.Point(50, 213);
            this.label3.Name = "label3";
            this.label3.Size = new System.Drawing.Size(51, 13);
            this.label3.TabIndex = 9;
            this.label3.Text = "PVP total";
            // 
            // dtpFechaLimite
            // 
            this.dtpFechaLimite.Location = new System.Drawing.Point(157, 259);
            this.dtpFechaLimite.Name = "dtpFechaLimite";
            this.dtpFechaLimite.Size = new System.Drawing.Size(199, 20);
            this.dtpFechaLimite.TabIndex = 12;
            // 
            // label4
            // 
            this.label4.AutoSize = true;
            this.label4.Location = new System.Drawing.Point(50, 259);
            this.label4.Name = "label4";
            this.label4.Size = new System.Drawing.Size(65, 13);
            this.label4.TabIndex = 11;
            this.label4.Text = "Fecha límite";
            // 
            // dtpFechaEntrega
            // 
            this.dtpFechaEntrega.Location = new System.Drawing.Point(157, 298);
            this.dtpFechaEntrega.Name = "dtpFechaEntrega";
            this.dtpFechaEntrega.Size = new System.Drawing.Size(199, 20);
            this.dtpFechaEntrega.TabIndex = 14;
            // 
            // label5
            // 
            this.label5.AutoSize = true;
            this.label5.Location = new System.Drawing.Point(50, 298);
            this.label5.Name = "label5";
            this.label5.Size = new System.Drawing.Size(76, 13);
            this.label5.TabIndex = 13;
            this.label5.Text = "Fecha entrega";
            // 
            // NuevaOferta
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(393, 358);
            this.Controls.Add(this.dtpFechaEntrega);
            this.Controls.Add(this.label5);
            this.Controls.Add(this.dtpFechaLimite);
            this.Controls.Add(this.label4);
            this.Controls.Add(this.tbPVP);
            this.Controls.Add(this.label3);
            this.Controls.Add(this.taPiezas);
            this.Controls.Add(this.label2);
            this.Controls.Add(this.tbIDOferta);
            this.Controls.Add(this.label1);
            this.Name = "NuevaOferta";
            this.Text = "Nueva Oferta";
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.TextBox tbIDOferta;
        private System.Windows.Forms.Label label1;
        private System.Windows.Forms.TextBox taPiezas;
        private System.Windows.Forms.Label label2;
        private System.Windows.Forms.TextBox tbPVP;
        private System.Windows.Forms.Label label3;
        private System.Windows.Forms.DateTimePicker dtpFechaLimite;
        private System.Windows.Forms.Label label4;
        private System.Windows.Forms.DateTimePicker dtpFechaEntrega;
        private System.Windows.Forms.Label label5;
    }
}