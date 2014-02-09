
package gestor_desguace_java;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the gestor_desguace_java package. 
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

    private final static QName _NuevaOfertaResponse_QNAME = new QName("http://gestor_desguace_java/", "nuevaOfertaResponse");
    private final static QName _NuevaOferta_QNAME = new QName("http://gestor_desguace_java/", "nuevaOferta");
    private final static QName _CambiarEstadoPedido_QNAME = new QName("http://gestor_desguace_java/", "cambiarEstadoPedido");
    private final static QName _CambiarEstadoPedidoResponse_QNAME = new QName("http://gestor_desguace_java/", "cambiarEstadoPedidoResponse");
    private final static QName _GetOfertas_QNAME = new QName("http://gestor_desguace_java/", "getOfertas");
    private final static QName _CheckActivacion_QNAME = new QName("http://gestor_desguace_java/", "checkActivacion");
    private final static QName _AceptarOfertaFin_QNAME = new QName("http://gestor_desguace_java/", "aceptarOfertaFin");
    private final static QName _GetPedidosporID_QNAME = new QName("http://gestor_desguace_java/", "getPedidosporID");
    private final static QName _CancelarOferta_QNAME = new QName("http://gestor_desguace_java/", "cancelarOferta");
    private final static QName _AltaResponse_QNAME = new QName("http://gestor_desguace_java/", "altaResponse");
    private final static QName _AceptarOfertaFinResponse_QNAME = new QName("http://gestor_desguace_java/", "aceptarOfertaFinResponse");
    private final static QName _GetPedidosporIDResponse_QNAME = new QName("http://gestor_desguace_java/", "getPedidosporIDResponse");
    private final static QName _Alta_QNAME = new QName("http://gestor_desguace_java/", "alta");
    private final static QName _CancelarOfertaResponse_QNAME = new QName("http://gestor_desguace_java/", "cancelarOfertaResponse");
    private final static QName _GetOfertasResponse_QNAME = new QName("http://gestor_desguace_java/", "getOfertasResponse");
    private final static QName _BajaResponse_QNAME = new QName("http://gestor_desguace_java/", "bajaResponse");
    private final static QName _CheckActivacionResponse_QNAME = new QName("http://gestor_desguace_java/", "checkActivacionResponse");
    private final static QName _Baja_QNAME = new QName("http://gestor_desguace_java/", "baja");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: gestor_desguace_java
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Alta }
     * 
     */
    public Alta createAlta() {
        return new Alta();
    }

    /**
     * Create an instance of {@link CancelarOfertaResponse }
     * 
     */
    public CancelarOfertaResponse createCancelarOfertaResponse() {
        return new CancelarOfertaResponse();
    }

    /**
     * Create an instance of {@link GetOfertasResponse }
     * 
     */
    public GetOfertasResponse createGetOfertasResponse() {
        return new GetOfertasResponse();
    }

    /**
     * Create an instance of {@link BajaResponse }
     * 
     */
    public BajaResponse createBajaResponse() {
        return new BajaResponse();
    }

    /**
     * Create an instance of {@link CheckActivacionResponse }
     * 
     */
    public CheckActivacionResponse createCheckActivacionResponse() {
        return new CheckActivacionResponse();
    }

    /**
     * Create an instance of {@link Baja }
     * 
     */
    public Baja createBaja() {
        return new Baja();
    }

    /**
     * Create an instance of {@link NuevaOfertaResponse }
     * 
     */
    public NuevaOfertaResponse createNuevaOfertaResponse() {
        return new NuevaOfertaResponse();
    }

    /**
     * Create an instance of {@link NuevaOferta }
     * 
     */
    public NuevaOferta createNuevaOferta() {
        return new NuevaOferta();
    }

    /**
     * Create an instance of {@link CambiarEstadoPedido }
     * 
     */
    public CambiarEstadoPedido createCambiarEstadoPedido() {
        return new CambiarEstadoPedido();
    }

    /**
     * Create an instance of {@link CambiarEstadoPedidoResponse }
     * 
     */
    public CambiarEstadoPedidoResponse createCambiarEstadoPedidoResponse() {
        return new CambiarEstadoPedidoResponse();
    }

    /**
     * Create an instance of {@link GetOfertas }
     * 
     */
    public GetOfertas createGetOfertas() {
        return new GetOfertas();
    }

    /**
     * Create an instance of {@link CheckActivacion }
     * 
     */
    public CheckActivacion createCheckActivacion() {
        return new CheckActivacion();
    }

    /**
     * Create an instance of {@link AceptarOfertaFin }
     * 
     */
    public AceptarOfertaFin createAceptarOfertaFin() {
        return new AceptarOfertaFin();
    }

    /**
     * Create an instance of {@link GetPedidosporID }
     * 
     */
    public GetPedidosporID createGetPedidosporID() {
        return new GetPedidosporID();
    }

    /**
     * Create an instance of {@link CancelarOferta }
     * 
     */
    public CancelarOferta createCancelarOferta() {
        return new CancelarOferta();
    }

    /**
     * Create an instance of {@link AltaResponse }
     * 
     */
    public AltaResponse createAltaResponse() {
        return new AltaResponse();
    }

    /**
     * Create an instance of {@link GetPedidosporIDResponse }
     * 
     */
    public GetPedidosporIDResponse createGetPedidosporIDResponse() {
        return new GetPedidosporIDResponse();
    }

    /**
     * Create an instance of {@link AceptarOfertaFinResponse }
     * 
     */
    public AceptarOfertaFinResponse createAceptarOfertaFinResponse() {
        return new AceptarOfertaFinResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link NuevaOfertaResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://gestor_desguace_java/", name = "nuevaOfertaResponse")
    public JAXBElement<NuevaOfertaResponse> createNuevaOfertaResponse(NuevaOfertaResponse value) {
        return new JAXBElement<NuevaOfertaResponse>(_NuevaOfertaResponse_QNAME, NuevaOfertaResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link NuevaOferta }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://gestor_desguace_java/", name = "nuevaOferta")
    public JAXBElement<NuevaOferta> createNuevaOferta(NuevaOferta value) {
        return new JAXBElement<NuevaOferta>(_NuevaOferta_QNAME, NuevaOferta.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CambiarEstadoPedido }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://gestor_desguace_java/", name = "cambiarEstadoPedido")
    public JAXBElement<CambiarEstadoPedido> createCambiarEstadoPedido(CambiarEstadoPedido value) {
        return new JAXBElement<CambiarEstadoPedido>(_CambiarEstadoPedido_QNAME, CambiarEstadoPedido.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CambiarEstadoPedidoResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://gestor_desguace_java/", name = "cambiarEstadoPedidoResponse")
    public JAXBElement<CambiarEstadoPedidoResponse> createCambiarEstadoPedidoResponse(CambiarEstadoPedidoResponse value) {
        return new JAXBElement<CambiarEstadoPedidoResponse>(_CambiarEstadoPedidoResponse_QNAME, CambiarEstadoPedidoResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetOfertas }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://gestor_desguace_java/", name = "getOfertas")
    public JAXBElement<GetOfertas> createGetOfertas(GetOfertas value) {
        return new JAXBElement<GetOfertas>(_GetOfertas_QNAME, GetOfertas.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CheckActivacion }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://gestor_desguace_java/", name = "checkActivacion")
    public JAXBElement<CheckActivacion> createCheckActivacion(CheckActivacion value) {
        return new JAXBElement<CheckActivacion>(_CheckActivacion_QNAME, CheckActivacion.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AceptarOfertaFin }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://gestor_desguace_java/", name = "aceptarOfertaFin")
    public JAXBElement<AceptarOfertaFin> createAceptarOfertaFin(AceptarOfertaFin value) {
        return new JAXBElement<AceptarOfertaFin>(_AceptarOfertaFin_QNAME, AceptarOfertaFin.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetPedidosporID }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://gestor_desguace_java/", name = "getPedidosporID")
    public JAXBElement<GetPedidosporID> createGetPedidosporID(GetPedidosporID value) {
        return new JAXBElement<GetPedidosporID>(_GetPedidosporID_QNAME, GetPedidosporID.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CancelarOferta }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://gestor_desguace_java/", name = "cancelarOferta")
    public JAXBElement<CancelarOferta> createCancelarOferta(CancelarOferta value) {
        return new JAXBElement<CancelarOferta>(_CancelarOferta_QNAME, CancelarOferta.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AltaResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://gestor_desguace_java/", name = "altaResponse")
    public JAXBElement<AltaResponse> createAltaResponse(AltaResponse value) {
        return new JAXBElement<AltaResponse>(_AltaResponse_QNAME, AltaResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AceptarOfertaFinResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://gestor_desguace_java/", name = "aceptarOfertaFinResponse")
    public JAXBElement<AceptarOfertaFinResponse> createAceptarOfertaFinResponse(AceptarOfertaFinResponse value) {
        return new JAXBElement<AceptarOfertaFinResponse>(_AceptarOfertaFinResponse_QNAME, AceptarOfertaFinResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetPedidosporIDResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://gestor_desguace_java/", name = "getPedidosporIDResponse")
    public JAXBElement<GetPedidosporIDResponse> createGetPedidosporIDResponse(GetPedidosporIDResponse value) {
        return new JAXBElement<GetPedidosporIDResponse>(_GetPedidosporIDResponse_QNAME, GetPedidosporIDResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Alta }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://gestor_desguace_java/", name = "alta")
    public JAXBElement<Alta> createAlta(Alta value) {
        return new JAXBElement<Alta>(_Alta_QNAME, Alta.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CancelarOfertaResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://gestor_desguace_java/", name = "cancelarOfertaResponse")
    public JAXBElement<CancelarOfertaResponse> createCancelarOfertaResponse(CancelarOfertaResponse value) {
        return new JAXBElement<CancelarOfertaResponse>(_CancelarOfertaResponse_QNAME, CancelarOfertaResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetOfertasResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://gestor_desguace_java/", name = "getOfertasResponse")
    public JAXBElement<GetOfertasResponse> createGetOfertasResponse(GetOfertasResponse value) {
        return new JAXBElement<GetOfertasResponse>(_GetOfertasResponse_QNAME, GetOfertasResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BajaResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://gestor_desguace_java/", name = "bajaResponse")
    public JAXBElement<BajaResponse> createBajaResponse(BajaResponse value) {
        return new JAXBElement<BajaResponse>(_BajaResponse_QNAME, BajaResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CheckActivacionResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://gestor_desguace_java/", name = "checkActivacionResponse")
    public JAXBElement<CheckActivacionResponse> createCheckActivacionResponse(CheckActivacionResponse value) {
        return new JAXBElement<CheckActivacionResponse>(_CheckActivacionResponse_QNAME, CheckActivacionResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Baja }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://gestor_desguace_java/", name = "baja")
    public JAXBElement<Baja> createBaja(Baja value) {
        return new JAXBElement<Baja>(_Baja_QNAME, Baja.class, null, value);
    }

}
