package ecommerce;

import general.EstadoOferta;
import general.Oferta;
import general.Pedido;
import general.Taller;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Type;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import BD.InterfazBD;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

/**
 * Servlet implementation class VerOfertas
 */
@WebServlet("/VerOfertas")
public class VerOfertas extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	InterfazBD bd;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VerOfertas() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try (PrintWriter out = response.getWriter()) {
			try {
	            bd = new InterfazBD("sor_gestor");
	            Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ss").create();
	            ArrayList<Oferta> alP = new ArrayList<Oferta>();
	            /* Comprobar que el usuario que accede a estas ofertas es el correcto
	             * String cookieName = "usuario";
	            Cookie cookies[] = request.getCookies();
	            Cookie myCookie = null;
	            if (cookies != null) {
	                for (int i = 0; i < cookies.length; i++) {
	                    if (cookies[i].getName().equals(cookieName)) {
	                        myCookie = cookies[i];
	                        break;
	                    }
	                }
	            }*/
	            //if (myCookie != null) {
	                alP = bd.getOfertasPedido(request.getParameter("ped").toString());
	                Cookie cs = new Cookie("ofertas", gson.toJson(alP));
	                response.addCookie(cs);
	            //}
	            bd.close();
	            request.getRequestDispatcher("/ofertas.jsp").forward(request, response);
	        } catch (SQLException ex) {
	            Logger.getLogger(actualizarPedidos.class.getName()).log(Level.SEVERE, null, ex);
	        } catch (ClassNotFoundException ex) {
	            Logger.getLogger(actualizarPedidos.class.getName()).log(Level.SEVERE, null, ex);
	        }
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
