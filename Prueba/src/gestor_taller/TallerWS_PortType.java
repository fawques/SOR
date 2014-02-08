/**
 * TallerWS_PortType.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package gestor_taller;

public interface TallerWS_PortType extends java.rmi.Remote {
    public boolean alta(java.lang.String name, java.lang.String email, java.lang.String address, java.lang.String city, java.lang.String postalCode, java.lang.String telephone) throws java.rmi.RemoteException;
    public java.lang.Boolean cancelarPedido(java.lang.String idPedido) throws java.rmi.RemoteException;
    public java.lang.String getPedidos() throws java.rmi.RemoteException;
    public java.lang.Boolean cambiarEstadoPedido(int estado, java.lang.String id) throws java.rmi.RemoteException;
    public java.lang.Boolean baja(java.lang.String tallerID) throws java.rmi.RemoteException;
    public boolean modificar(java.lang.String id, java.lang.String name, java.lang.String email, java.lang.String address, java.lang.String city, java.lang.String postalCode, java.lang.String telephone) throws java.rmi.RemoteException;
    public java.lang.String hello() throws java.rmi.RemoteException;
    public java.lang.String getOfertas(java.lang.String listaPedidos) throws java.rmi.RemoteException;
    public java.lang.String checkActivacion(java.lang.String mail) throws java.rmi.RemoteException;
    public java.lang.Boolean aceptarOferta(java.lang.String ID) throws java.rmi.RemoteException;
    public java.lang.Boolean rechazarOferta(java.lang.String ID) throws java.rmi.RemoteException;
    public java.lang.String nuevoPedido(java.lang.String pedido) throws java.rmi.RemoteException, gestor_taller.JMSException;
}
