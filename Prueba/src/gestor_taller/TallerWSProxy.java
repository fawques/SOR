package gestor_taller;

public class TallerWSProxy implements gestor_taller.TallerWS_PortType {
  private String _endpoint = null;
  private gestor_taller.TallerWS_PortType tallerWS_PortType = null;
  
  public TallerWSProxy() {
    _initTallerWSProxy();
  }
  
  public TallerWSProxy(String endpoint) {
    _endpoint = endpoint;
    _initTallerWSProxy();
  }
  
  private void _initTallerWSProxy() {
    try {
      tallerWS_PortType = (new gestor_taller.TallerWS_ServiceLocator()).getTallerWSPort();
      if (tallerWS_PortType != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)tallerWS_PortType)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)tallerWS_PortType)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (tallerWS_PortType != null)
      ((javax.xml.rpc.Stub)tallerWS_PortType)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public gestor_taller.TallerWS_PortType getTallerWS_PortType() {
    if (tallerWS_PortType == null)
      _initTallerWSProxy();
    return tallerWS_PortType;
  }
  
  public boolean alta(java.lang.String name, java.lang.String email, java.lang.String address, java.lang.String city, java.lang.String postalCode, java.lang.String telephone) throws java.rmi.RemoteException{
    if (tallerWS_PortType == null)
      _initTallerWSProxy();
    return tallerWS_PortType.alta(name, email, address, city, postalCode, telephone);
  }
  
  public java.lang.Boolean cancelarPedido(java.lang.String idPedido) throws java.rmi.RemoteException{
    if (tallerWS_PortType == null)
      _initTallerWSProxy();
    return tallerWS_PortType.cancelarPedido(idPedido);
  }
  
  public java.lang.String getPedidos() throws java.rmi.RemoteException{
    if (tallerWS_PortType == null)
      _initTallerWSProxy();
    return tallerWS_PortType.getPedidos();
  }
  
  public java.lang.Boolean cambiarEstadoPedido(int estado, java.lang.String id) throws java.rmi.RemoteException{
    if (tallerWS_PortType == null)
      _initTallerWSProxy();
    return tallerWS_PortType.cambiarEstadoPedido(estado, id);
  }
  
  public java.lang.Boolean baja(java.lang.String tallerID) throws java.rmi.RemoteException{
    if (tallerWS_PortType == null)
      _initTallerWSProxy();
    return tallerWS_PortType.baja(tallerID);
  }
  
  public boolean modificar(java.lang.String id, java.lang.String name, java.lang.String email, java.lang.String address, java.lang.String city, java.lang.String postalCode, java.lang.String telephone) throws java.rmi.RemoteException{
    if (tallerWS_PortType == null)
      _initTallerWSProxy();
    return tallerWS_PortType.modificar(id, name, email, address, city, postalCode, telephone);
  }
  
  public java.lang.String hello() throws java.rmi.RemoteException{
    if (tallerWS_PortType == null)
      _initTallerWSProxy();
    return tallerWS_PortType.hello();
  }
  
  public java.lang.String getOfertas(java.lang.String listaPedidos) throws java.rmi.RemoteException{
    if (tallerWS_PortType == null)
      _initTallerWSProxy();
    return tallerWS_PortType.getOfertas(listaPedidos);
  }
  
  public java.lang.String checkActivacion(java.lang.String mail) throws java.rmi.RemoteException{
    if (tallerWS_PortType == null)
      _initTallerWSProxy();
    return tallerWS_PortType.checkActivacion(mail);
  }
  
  public java.lang.Boolean aceptarOferta(java.lang.String ID) throws java.rmi.RemoteException{
    if (tallerWS_PortType == null)
      _initTallerWSProxy();
    return tallerWS_PortType.aceptarOferta(ID);
  }
  
  public java.lang.Boolean rechazarOferta(java.lang.String ID) throws java.rmi.RemoteException{
    if (tallerWS_PortType == null)
      _initTallerWSProxy();
    return tallerWS_PortType.rechazarOferta(ID);
  }
  
  public java.lang.String nuevoPedido(java.lang.String pedido) throws java.rmi.RemoteException, gestor_taller.JMSException{
    if (tallerWS_PortType == null)
      _initTallerWSProxy();
    return tallerWS_PortType.nuevoPedido(pedido);
  }
  
  
}