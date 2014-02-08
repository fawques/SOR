package gestor_admin;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

@WebService(name = "AdminWS_endpoint", targetNamespace = "http://gestor_admin/")
public interface AdminWS_endpoint {

	public void sendMail(String from, String to, String subject, String text);

	/**
	 * This is a sample web service operation
	 */
	public String hello();

	/**
	 * Web service operation
	 */
	public String getPedidos();

	/**
	 * Web service operation
	 */
	public String getOfertas();

	/**
	 * Web service operation
	 */
	public String getDesguaces();

	/**
	 * Web service operation
	 */
	public String getTalleres();

	/**
	 * Web service operation
	 */
	public String getOfertasporPedido(String idPedido);

	/**
	 * Web service operation
	 */
	public String getPedidoID(String id);

	/**
	 * Web service operation
	 */
	public String Registrar();

	/**
	 * Web service operation
	 */
	public String getAltaTalleres();

	/**
	 * Web service operation
	 */
	public Boolean darAccesoTaller(String ID);

	/**
	 * Web service operation
	 */
	public Boolean addAccesoDesguace(String ID);

	/**
	 * Web service operation
	 */
	public String getAltaDesguace();

}