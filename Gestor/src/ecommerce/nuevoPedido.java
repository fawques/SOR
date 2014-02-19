/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ecommerce;

import BD.InterfazBD;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import general.EstadoPedido;
import general.Oferta;
import general.Pedido;
import general.Pieza;
import general.Taller;
import gestor_taller.TallerWS;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Type;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.jms.JMSException;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author pablovm1990
 */
public class nuevoPedido extends HttpServlet {

    InterfazBD bd;

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet nuevoPedido</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet nuevoPedido at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

   /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ss").create();
        String cookieName = "usuario";
        Cookie cookies[] = request.getCookies();
        Cookie myCookie = null;
        if (cookies != null) {
            for (int i = 0; i < cookies.length; i++) {
                if (cookies[i].getName().equals(cookieName)) {
                    myCookie = cookies[i];
                    break;
                }
            }
        }

        if (myCookie != null) {
            Type collectionType = new TypeToken<Taller>() {
            }.getType();

            Taller t = gson.fromJson(myCookie.getValue(), collectionType);

            Date today = new Date();
            String fecha = request.getParameter("fecha");
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            Date fechaLimite = new Date();
            try {
                fechaLimite = dateFormat.parse(fecha);
            } catch (ParseException ex) {
                Logger.getLogger(nuevoPedido.class.getName()).log(Level.SEVERE, null, ex);
            }
            ArrayList<Pieza> piezasPedido = new ArrayList<>();
            ArrayList<Integer> cantidadPiezas = new ArrayList<>();
            /*for (Iterator it = data.iterator(); it.hasNext();) {
             TablePieza tp = (TablePieza) it.next();            piezasPedido.add(new Pieza(tp.getId()));
             cantidadPiezas.add(tp.getCantidad());
             }*/
            TallerWS tws = new TallerWS();
            Pedido p = new Pedido("", t.getID(), today, new Date(1970, 1, 1), fechaLimite, EstadoPedido.ACTIVE, "Automatico".equals(request.getParameter("modo")), new ArrayList<Pieza>(), new ArrayList<Integer>(), new ArrayList<Oferta>());
            try {
                if (!"".equals(tws.nuevoPedido(gson.toJson(p)))) {
                    System.out.println("pedido creado");
                    request.getRequestDispatcher("/gestion.jsp").forward(request, response);
                }
            } catch (JMSException ex) {
                Logger.getLogger(nuevoPedido.class.getName()).log(Level.SEVERE, null, ex);
            }

        } else {
            System.out.println("No hay cookie");
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
