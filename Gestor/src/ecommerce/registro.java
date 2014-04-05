/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ecommerce;

import BD.InterfazBD;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import general.Taller;
import gestor_admin.AdminWS;
import gestor_taller.TallerWS;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author pablovm1990
 */
public class registro extends HttpServlet {

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
            out.println("<title>Servlet registro</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet registro at " + request.getContextPath() + "</h1>");
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
        TallerWS tws = new TallerWS();
        AdminWS aws = new AdminWS();
        if (tws.alta(request.getParameter("usuario"), request.getParameter("email"), request.getParameter("direccion"), request.getParameter("ciudad"), request.getParameter("cpostal"), request.getParameter("telefono"),"1234")) {
            try {
                bd = new InterfazBD("sor_gestor");
                Taller t = bd.getTaller(request.getParameter("email"));
                Gson gson = new GsonBuilder().setDateFormat("MMM dd, yyyy hh:mm:ss a").create();
                Cookie c = new Cookie("usuario", gson.toJson(t));
                response.addCookie(c);
                c = new Cookie("contrasenya", request.getParameter("contrasenya"));
                response.addCookie(c);
                System.out.println("Registro ok");
                bd.close();
            } catch (SQLException ex) {
                Logger.getLogger(registro.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(registro.class.getName()).log(Level.SEVERE, null, ex);
            }
            request.getRequestDispatcher("/gestion.jsp").forward(request, response);
        } else {
            //enviar error
            request.setAttribute("errorMessage", "Registro incorrecto");
            request.getRequestDispatcher("/registro.jsp").forward(request, response);
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
