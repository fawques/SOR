﻿using System;
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
    public partial class Inicio : Form
    {
        DesguaceNet main;
        public Inicio()
        {
            InitializeComponent();
            main = main = new DesguaceNet();
        }

        private void button1_Click(object sender, EventArgs e)
        {
            Boolean aceptado = main.comprobarInicio(tbUsuario.Text, tbContrasenya.Text);
            if (aceptado) {
                DialogResult = DialogResult.OK;
            }

        }


    }
}
