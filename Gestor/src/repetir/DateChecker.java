package repetir;

import general.EstadoOferta;
import general.EstadoPedido;
import general.Oferta;
import general.Pedido;
import gestor_admin.AdminWS;
import gestor_taller.TallerWS;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

import BD.InterfazBD;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class DateChecker implements Runnable {

	InterfazBD bd;

	@Override
	public void run() {
		System.out.println("Checking dates");
		try {
			bd = new InterfazBD("sor_gestor");
			Gson gson = new GsonBuilder()
					.setDateFormat("yyyy-MM-dd'T'HH:mm:ss").create();
			ArrayList<Oferta> listaOferta = bd
					.getOfertasPorEstado(EstadoOferta.ACTIVE);
			listaOferta.addAll(bd.getOfertasPorEstado(EstadoOferta.ACCEPTED));
			ArrayList<Pedido> listaPedido = bd
					.getPedidosPorEstado(EstadoPedido.ACTIVE);
			listaPedido.addAll(bd.getPedidosPorEstado(EstadoPedido.ACCEPTED));

			for (Pedido pedido : listaPedido) {
				if ((new Date()).after(pedido.getFecha_limite())) {
					if (pedido.getModoAutomatico()) {
						if (!aceptarMejorOferta(pedido)) {
							System.out
									.println("ERROR: no se ha podido aceptar la mejor oferta para el pedido <"
											+ pedido.getID() + ">");
						}
					} else {
						bd.cancelarPedido(pedido.getID());
					}
				}
			}
			for (Oferta oferta : listaOferta) {
				if ((new Date()).after(oferta.getFecha_limite())) {
					bd.cambiarEstadoOferta(EstadoOferta.CANCELLED,
							oferta.getID());
				}
			}

		} catch (SQLException ex) {
			Logger.getLogger(AdminWS.class.getName()).log(Level.SEVERE, null,
					ex);
		} catch (ClassNotFoundException ex) {
			Logger.getLogger(AdminWS.class.getName()).log(Level.SEVERE, null,
					ex);
		}
		bd.close();
	}

	private boolean aceptarMejorOferta(Pedido pedido) {
		System.out.println("Aceptando mejor oferta");
		boolean ok = false;
		ArrayList<Oferta> listaOfertasPedido = pedido.getListaOfertas();
		Oferta elegida = null;
		if (listaOfertasPedido.size() > 0) {
			elegida = listaOfertasPedido.get(0);
			for (Oferta oferta : listaOfertasPedido) {
				if (oferta.getPrecio() < elegida.getPrecio()) {
					elegida = oferta;
				}
			}
		}else{
			System.out.println("Pedido sin ofertas. Cancelando");
			bd.cancelarPedido(pedido.getID());
		}
		if (elegida != null) {
			bd.cambiarEstadoPedido(EstadoPedido.ACCEPTED, pedido.getID());
			bd.cambiarEstadoOferta(EstadoOferta.ACCEPTED, elegida.getID());
			ok = true;
		}
		return ok;

	}

}