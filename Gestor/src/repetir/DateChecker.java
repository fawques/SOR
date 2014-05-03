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
import audit.AuditLogger;

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
							AuditLogger.error("No se ha podido aceptar la mejor oferta para el pedido <"
											+ pedido.getID() + ">");
						}
					} else {
						boolean ok = bd.cancelarPedido(pedido.getID());
						if(ok){
							AuditLogger.CRUD_Pedido("Pedido <" + pedido.getID() + "> cancelado");
						}else{
							AuditLogger.error("No se ha podido cancelar el pedido <" + pedido.getID() + ">");
						}
					}
				}
			}
			for (Oferta oferta : listaOferta) {
				if ((new Date()).after(oferta.getFecha_limite())) {
					boolean ok = bd.cambiarEstadoOferta(EstadoOferta.CANCELLED,
							oferta.getID());
					if(ok){
						AuditLogger.CRUD_Oferta("Oferta <" + oferta.getID() + "> cancelada");
					}else{
						AuditLogger.error("No se ha podido cancelar la oferta <" + oferta.getID() + ">");
					}
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
			AuditLogger.error("Pedido <" + pedido.getID() + "> sin ofertas. Cancelando");
			bd.cancelarPedido(pedido.getID());
		}
		if (elegida != null) {
			bd.cambiarEstadoPedido(EstadoPedido.ACCEPTED, pedido.getID());
			AuditLogger.CRUD_Pedido("Pedido <" + pedido.getID() + "> cancelado");
			bd.cambiarEstadoOferta(EstadoOferta.ACCEPTED, elegida.getID());
			AuditLogger.CRUD_Oferta("Oferta <" + elegida.getID() + "> cancelada");
			ok = true;
		}
		return ok;

	}

}