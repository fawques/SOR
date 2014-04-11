
package gestor_admin;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the gestor_admin package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _GetAltaTalleres_QNAME = new QName("http://gestor_admin/", "getAltaTalleres");
    private final static QName _SetCifradoAsimetricoResponse_QNAME = new QName("http://gestor_admin/", "setCifradoAsimetricoResponse");
    private final static QName _GetTalleresAceptadosResponse_QNAME = new QName("http://gestor_admin/", "getTalleresAceptadosResponse");
    private final static QName _GetTalleresResponse_QNAME = new QName("http://gestor_admin/", "getTalleresResponse");
    private final static QName _GetPedidosResponse_QNAME = new QName("http://gestor_admin/", "getPedidosResponse");
    private final static QName _SendMail_QNAME = new QName("http://gestor_admin/", "sendMail");
    private final static QName _RegistrarResponse_QNAME = new QName("http://gestor_admin/", "RegistrarResponse");
    private final static QName _SendMailResponse_QNAME = new QName("http://gestor_admin/", "sendMailResponse");
    private final static QName _GetDesguacesAceptados_QNAME = new QName("http://gestor_admin/", "getDesguacesAceptados");
    private final static QName _GetDesguacesResponse_QNAME = new QName("http://gestor_admin/", "getDesguacesResponse");
    private final static QName _GetDesguaces_QNAME = new QName("http://gestor_admin/", "getDesguaces");
    private final static QName _Registrar_QNAME = new QName("http://gestor_admin/", "Registrar");
    private final static QName _GetPedidos_QNAME = new QName("http://gestor_admin/", "getPedidos");
    private final static QName _HelloResponse_QNAME = new QName("http://gestor_admin/", "helloResponse");
    private final static QName _AddAccesoDesguaceResponse_QNAME = new QName("http://gestor_admin/", "addAccesoDesguaceResponse");
    private final static QName _GetAltaDesguace_QNAME = new QName("http://gestor_admin/", "getAltaDesguace");
    private final static QName _GetOfertas_QNAME = new QName("http://gestor_admin/", "getOfertas");
    private final static QName _Hello_QNAME = new QName("http://gestor_admin/", "hello");
    private final static QName _DarAccesoTaller_QNAME = new QName("http://gestor_admin/", "darAccesoTaller");
    private final static QName _DarAccesoTallerResponse_QNAME = new QName("http://gestor_admin/", "darAccesoTallerResponse");
    private final static QName _GetOfertasResponse_QNAME = new QName("http://gestor_admin/", "getOfertasResponse");
    private final static QName _GetPedidoID_QNAME = new QName("http://gestor_admin/", "getPedidoID");
    private final static QName _GetTalleres_QNAME = new QName("http://gestor_admin/", "getTalleres");
    private final static QName _AddAccesoDesguace_QNAME = new QName("http://gestor_admin/", "addAccesoDesguace");
    private final static QName _GetPedidoIDResponse_QNAME = new QName("http://gestor_admin/", "getPedidoIDResponse");
    private final static QName _GetOfertasporPedidoResponse_QNAME = new QName("http://gestor_admin/", "getOfertasporPedidoResponse");
    private final static QName _SetCifradoSimetrico_QNAME = new QName("http://gestor_admin/", "setCifradoSimetrico");
    private final static QName _SetCifradoSimetricoResponse_QNAME = new QName("http://gestor_admin/", "setCifradoSimetricoResponse");
    private final static QName _GetOfertasporPedido_QNAME = new QName("http://gestor_admin/", "getOfertasporPedido");
    private final static QName _SetCifradoAsimetrico_QNAME = new QName("http://gestor_admin/", "setCifradoAsimetrico");
    private final static QName _GetAltaTalleresResponse_QNAME = new QName("http://gestor_admin/", "getAltaTalleresResponse");
    private final static QName _GetDesguacesAceptadosResponse_QNAME = new QName("http://gestor_admin/", "getDesguacesAceptadosResponse");
    private final static QName _GetAltaDesguaceResponse_QNAME = new QName("http://gestor_admin/", "getAltaDesguaceResponse");
    private final static QName _GetTalleresAceptados_QNAME = new QName("http://gestor_admin/", "getTalleresAceptados");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: gestor_admin
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetDesguacesResponse }
     * 
     */
    public GetDesguacesResponse createGetDesguacesResponse() {
        return new GetDesguacesResponse();
    }

    /**
     * Create an instance of {@link GetDesguaces }
     * 
     */
    public GetDesguaces createGetDesguaces() {
        return new GetDesguaces();
    }

    /**
     * Create an instance of {@link SendMailResponse }
     * 
     */
    public SendMailResponse createSendMailResponse() {
        return new SendMailResponse();
    }

    /**
     * Create an instance of {@link RegistrarResponse }
     * 
     */
    public RegistrarResponse createRegistrarResponse() {
        return new RegistrarResponse();
    }

    /**
     * Create an instance of {@link GetDesguacesAceptados }
     * 
     */
    public GetDesguacesAceptados createGetDesguacesAceptados() {
        return new GetDesguacesAceptados();
    }

    /**
     * Create an instance of {@link SendMail }
     * 
     */
    public SendMail createSendMail() {
        return new SendMail();
    }

    /**
     * Create an instance of {@link GetTalleresResponse }
     * 
     */
    public GetTalleresResponse createGetTalleresResponse() {
        return new GetTalleresResponse();
    }

    /**
     * Create an instance of {@link GetTalleresAceptadosResponse }
     * 
     */
    public GetTalleresAceptadosResponse createGetTalleresAceptadosResponse() {
        return new GetTalleresAceptadosResponse();
    }

    /**
     * Create an instance of {@link GetPedidosResponse }
     * 
     */
    public GetPedidosResponse createGetPedidosResponse() {
        return new GetPedidosResponse();
    }

    /**
     * Create an instance of {@link SetCifradoAsimetricoResponse }
     * 
     */
    public SetCifradoAsimetricoResponse createSetCifradoAsimetricoResponse() {
        return new SetCifradoAsimetricoResponse();
    }

    /**
     * Create an instance of {@link GetAltaTalleres }
     * 
     */
    public GetAltaTalleres createGetAltaTalleres() {
        return new GetAltaTalleres();
    }

    /**
     * Create an instance of {@link GetAltaDesguaceResponse }
     * 
     */
    public GetAltaDesguaceResponse createGetAltaDesguaceResponse() {
        return new GetAltaDesguaceResponse();
    }

    /**
     * Create an instance of {@link GetTalleresAceptados }
     * 
     */
    public GetTalleresAceptados createGetTalleresAceptados() {
        return new GetTalleresAceptados();
    }

    /**
     * Create an instance of {@link SetCifradoSimetrico }
     * 
     */
    public SetCifradoSimetrico createSetCifradoSimetrico() {
        return new SetCifradoSimetrico();
    }

    /**
     * Create an instance of {@link SetCifradoSimetricoResponse }
     * 
     */
    public SetCifradoSimetricoResponse createSetCifradoSimetricoResponse() {
        return new SetCifradoSimetricoResponse();
    }

    /**
     * Create an instance of {@link GetOfertasporPedido }
     * 
     */
    public GetOfertasporPedido createGetOfertasporPedido() {
        return new GetOfertasporPedido();
    }

    /**
     * Create an instance of {@link SetCifradoAsimetrico }
     * 
     */
    public SetCifradoAsimetrico createSetCifradoAsimetrico() {
        return new SetCifradoAsimetrico();
    }

    /**
     * Create an instance of {@link GetAltaTalleresResponse }
     * 
     */
    public GetAltaTalleresResponse createGetAltaTalleresResponse() {
        return new GetAltaTalleresResponse();
    }

    /**
     * Create an instance of {@link GetDesguacesAceptadosResponse }
     * 
     */
    public GetDesguacesAceptadosResponse createGetDesguacesAceptadosResponse() {
        return new GetDesguacesAceptadosResponse();
    }

    /**
     * Create an instance of {@link GetPedidoIDResponse }
     * 
     */
    public GetPedidoIDResponse createGetPedidoIDResponse() {
        return new GetPedidoIDResponse();
    }

    /**
     * Create an instance of {@link GetOfertasporPedidoResponse }
     * 
     */
    public GetOfertasporPedidoResponse createGetOfertasporPedidoResponse() {
        return new GetOfertasporPedidoResponse();
    }

    /**
     * Create an instance of {@link GetOfertasResponse }
     * 
     */
    public GetOfertasResponse createGetOfertasResponse() {
        return new GetOfertasResponse();
    }

    /**
     * Create an instance of {@link GetPedidoID }
     * 
     */
    public GetPedidoID createGetPedidoID() {
        return new GetPedidoID();
    }

    /**
     * Create an instance of {@link GetTalleres }
     * 
     */
    public GetTalleres createGetTalleres() {
        return new GetTalleres();
    }

    /**
     * Create an instance of {@link AddAccesoDesguace }
     * 
     */
    public AddAccesoDesguace createAddAccesoDesguace() {
        return new AddAccesoDesguace();
    }

    /**
     * Create an instance of {@link Hello }
     * 
     */
    public Hello createHello() {
        return new Hello();
    }

    /**
     * Create an instance of {@link DarAccesoTallerResponse }
     * 
     */
    public DarAccesoTallerResponse createDarAccesoTallerResponse() {
        return new DarAccesoTallerResponse();
    }

    /**
     * Create an instance of {@link DarAccesoTaller }
     * 
     */
    public DarAccesoTaller createDarAccesoTaller() {
        return new DarAccesoTaller();
    }

    /**
     * Create an instance of {@link GetPedidos }
     * 
     */
    public GetPedidos createGetPedidos() {
        return new GetPedidos();
    }

    /**
     * Create an instance of {@link HelloResponse }
     * 
     */
    public HelloResponse createHelloResponse() {
        return new HelloResponse();
    }

    /**
     * Create an instance of {@link GetAltaDesguace }
     * 
     */
    public GetAltaDesguace createGetAltaDesguace() {
        return new GetAltaDesguace();
    }

    /**
     * Create an instance of {@link AddAccesoDesguaceResponse }
     * 
     */
    public AddAccesoDesguaceResponse createAddAccesoDesguaceResponse() {
        return new AddAccesoDesguaceResponse();
    }

    /**
     * Create an instance of {@link GetOfertas }
     * 
     */
    public GetOfertas createGetOfertas() {
        return new GetOfertas();
    }

    /**
     * Create an instance of {@link Registrar }
     * 
     */
    public Registrar createRegistrar() {
        return new Registrar();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAltaTalleres }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://gestor_admin/", name = "getAltaTalleres")
    public JAXBElement<GetAltaTalleres> createGetAltaTalleres(GetAltaTalleres value) {
        return new JAXBElement<GetAltaTalleres>(_GetAltaTalleres_QNAME, GetAltaTalleres.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SetCifradoAsimetricoResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://gestor_admin/", name = "setCifradoAsimetricoResponse")
    public JAXBElement<SetCifradoAsimetricoResponse> createSetCifradoAsimetricoResponse(SetCifradoAsimetricoResponse value) {
        return new JAXBElement<SetCifradoAsimetricoResponse>(_SetCifradoAsimetricoResponse_QNAME, SetCifradoAsimetricoResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetTalleresAceptadosResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://gestor_admin/", name = "getTalleresAceptadosResponse")
    public JAXBElement<GetTalleresAceptadosResponse> createGetTalleresAceptadosResponse(GetTalleresAceptadosResponse value) {
        return new JAXBElement<GetTalleresAceptadosResponse>(_GetTalleresAceptadosResponse_QNAME, GetTalleresAceptadosResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetTalleresResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://gestor_admin/", name = "getTalleresResponse")
    public JAXBElement<GetTalleresResponse> createGetTalleresResponse(GetTalleresResponse value) {
        return new JAXBElement<GetTalleresResponse>(_GetTalleresResponse_QNAME, GetTalleresResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetPedidosResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://gestor_admin/", name = "getPedidosResponse")
    public JAXBElement<GetPedidosResponse> createGetPedidosResponse(GetPedidosResponse value) {
        return new JAXBElement<GetPedidosResponse>(_GetPedidosResponse_QNAME, GetPedidosResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SendMail }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://gestor_admin/", name = "sendMail")
    public JAXBElement<SendMail> createSendMail(SendMail value) {
        return new JAXBElement<SendMail>(_SendMail_QNAME, SendMail.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RegistrarResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://gestor_admin/", name = "RegistrarResponse")
    public JAXBElement<RegistrarResponse> createRegistrarResponse(RegistrarResponse value) {
        return new JAXBElement<RegistrarResponse>(_RegistrarResponse_QNAME, RegistrarResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SendMailResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://gestor_admin/", name = "sendMailResponse")
    public JAXBElement<SendMailResponse> createSendMailResponse(SendMailResponse value) {
        return new JAXBElement<SendMailResponse>(_SendMailResponse_QNAME, SendMailResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetDesguacesAceptados }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://gestor_admin/", name = "getDesguacesAceptados")
    public JAXBElement<GetDesguacesAceptados> createGetDesguacesAceptados(GetDesguacesAceptados value) {
        return new JAXBElement<GetDesguacesAceptados>(_GetDesguacesAceptados_QNAME, GetDesguacesAceptados.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetDesguacesResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://gestor_admin/", name = "getDesguacesResponse")
    public JAXBElement<GetDesguacesResponse> createGetDesguacesResponse(GetDesguacesResponse value) {
        return new JAXBElement<GetDesguacesResponse>(_GetDesguacesResponse_QNAME, GetDesguacesResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetDesguaces }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://gestor_admin/", name = "getDesguaces")
    public JAXBElement<GetDesguaces> createGetDesguaces(GetDesguaces value) {
        return new JAXBElement<GetDesguaces>(_GetDesguaces_QNAME, GetDesguaces.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Registrar }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://gestor_admin/", name = "Registrar")
    public JAXBElement<Registrar> createRegistrar(Registrar value) {
        return new JAXBElement<Registrar>(_Registrar_QNAME, Registrar.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetPedidos }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://gestor_admin/", name = "getPedidos")
    public JAXBElement<GetPedidos> createGetPedidos(GetPedidos value) {
        return new JAXBElement<GetPedidos>(_GetPedidos_QNAME, GetPedidos.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link HelloResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://gestor_admin/", name = "helloResponse")
    public JAXBElement<HelloResponse> createHelloResponse(HelloResponse value) {
        return new JAXBElement<HelloResponse>(_HelloResponse_QNAME, HelloResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddAccesoDesguaceResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://gestor_admin/", name = "addAccesoDesguaceResponse")
    public JAXBElement<AddAccesoDesguaceResponse> createAddAccesoDesguaceResponse(AddAccesoDesguaceResponse value) {
        return new JAXBElement<AddAccesoDesguaceResponse>(_AddAccesoDesguaceResponse_QNAME, AddAccesoDesguaceResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAltaDesguace }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://gestor_admin/", name = "getAltaDesguace")
    public JAXBElement<GetAltaDesguace> createGetAltaDesguace(GetAltaDesguace value) {
        return new JAXBElement<GetAltaDesguace>(_GetAltaDesguace_QNAME, GetAltaDesguace.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetOfertas }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://gestor_admin/", name = "getOfertas")
    public JAXBElement<GetOfertas> createGetOfertas(GetOfertas value) {
        return new JAXBElement<GetOfertas>(_GetOfertas_QNAME, GetOfertas.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Hello }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://gestor_admin/", name = "hello")
    public JAXBElement<Hello> createHello(Hello value) {
        return new JAXBElement<Hello>(_Hello_QNAME, Hello.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DarAccesoTaller }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://gestor_admin/", name = "darAccesoTaller")
    public JAXBElement<DarAccesoTaller> createDarAccesoTaller(DarAccesoTaller value) {
        return new JAXBElement<DarAccesoTaller>(_DarAccesoTaller_QNAME, DarAccesoTaller.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DarAccesoTallerResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://gestor_admin/", name = "darAccesoTallerResponse")
    public JAXBElement<DarAccesoTallerResponse> createDarAccesoTallerResponse(DarAccesoTallerResponse value) {
        return new JAXBElement<DarAccesoTallerResponse>(_DarAccesoTallerResponse_QNAME, DarAccesoTallerResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetOfertasResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://gestor_admin/", name = "getOfertasResponse")
    public JAXBElement<GetOfertasResponse> createGetOfertasResponse(GetOfertasResponse value) {
        return new JAXBElement<GetOfertasResponse>(_GetOfertasResponse_QNAME, GetOfertasResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetPedidoID }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://gestor_admin/", name = "getPedidoID")
    public JAXBElement<GetPedidoID> createGetPedidoID(GetPedidoID value) {
        return new JAXBElement<GetPedidoID>(_GetPedidoID_QNAME, GetPedidoID.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetTalleres }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://gestor_admin/", name = "getTalleres")
    public JAXBElement<GetTalleres> createGetTalleres(GetTalleres value) {
        return new JAXBElement<GetTalleres>(_GetTalleres_QNAME, GetTalleres.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddAccesoDesguace }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://gestor_admin/", name = "addAccesoDesguace")
    public JAXBElement<AddAccesoDesguace> createAddAccesoDesguace(AddAccesoDesguace value) {
        return new JAXBElement<AddAccesoDesguace>(_AddAccesoDesguace_QNAME, AddAccesoDesguace.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetPedidoIDResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://gestor_admin/", name = "getPedidoIDResponse")
    public JAXBElement<GetPedidoIDResponse> createGetPedidoIDResponse(GetPedidoIDResponse value) {
        return new JAXBElement<GetPedidoIDResponse>(_GetPedidoIDResponse_QNAME, GetPedidoIDResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetOfertasporPedidoResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://gestor_admin/", name = "getOfertasporPedidoResponse")
    public JAXBElement<GetOfertasporPedidoResponse> createGetOfertasporPedidoResponse(GetOfertasporPedidoResponse value) {
        return new JAXBElement<GetOfertasporPedidoResponse>(_GetOfertasporPedidoResponse_QNAME, GetOfertasporPedidoResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SetCifradoSimetrico }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://gestor_admin/", name = "setCifradoSimetrico")
    public JAXBElement<SetCifradoSimetrico> createSetCifradoSimetrico(SetCifradoSimetrico value) {
        return new JAXBElement<SetCifradoSimetrico>(_SetCifradoSimetrico_QNAME, SetCifradoSimetrico.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SetCifradoSimetricoResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://gestor_admin/", name = "setCifradoSimetricoResponse")
    public JAXBElement<SetCifradoSimetricoResponse> createSetCifradoSimetricoResponse(SetCifradoSimetricoResponse value) {
        return new JAXBElement<SetCifradoSimetricoResponse>(_SetCifradoSimetricoResponse_QNAME, SetCifradoSimetricoResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetOfertasporPedido }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://gestor_admin/", name = "getOfertasporPedido")
    public JAXBElement<GetOfertasporPedido> createGetOfertasporPedido(GetOfertasporPedido value) {
        return new JAXBElement<GetOfertasporPedido>(_GetOfertasporPedido_QNAME, GetOfertasporPedido.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SetCifradoAsimetrico }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://gestor_admin/", name = "setCifradoAsimetrico")
    public JAXBElement<SetCifradoAsimetrico> createSetCifradoAsimetrico(SetCifradoAsimetrico value) {
        return new JAXBElement<SetCifradoAsimetrico>(_SetCifradoAsimetrico_QNAME, SetCifradoAsimetrico.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAltaTalleresResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://gestor_admin/", name = "getAltaTalleresResponse")
    public JAXBElement<GetAltaTalleresResponse> createGetAltaTalleresResponse(GetAltaTalleresResponse value) {
        return new JAXBElement<GetAltaTalleresResponse>(_GetAltaTalleresResponse_QNAME, GetAltaTalleresResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetDesguacesAceptadosResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://gestor_admin/", name = "getDesguacesAceptadosResponse")
    public JAXBElement<GetDesguacesAceptadosResponse> createGetDesguacesAceptadosResponse(GetDesguacesAceptadosResponse value) {
        return new JAXBElement<GetDesguacesAceptadosResponse>(_GetDesguacesAceptadosResponse_QNAME, GetDesguacesAceptadosResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAltaDesguaceResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://gestor_admin/", name = "getAltaDesguaceResponse")
    public JAXBElement<GetAltaDesguaceResponse> createGetAltaDesguaceResponse(GetAltaDesguaceResponse value) {
        return new JAXBElement<GetAltaDesguaceResponse>(_GetAltaDesguaceResponse_QNAME, GetAltaDesguaceResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetTalleresAceptados }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://gestor_admin/", name = "getTalleresAceptados")
    public JAXBElement<GetTalleresAceptados> createGetTalleresAceptados(GetTalleresAceptados value) {
        return new JAXBElement<GetTalleresAceptados>(_GetTalleresAceptados_QNAME, GetTalleresAceptados.class, null, value);
    }

}
