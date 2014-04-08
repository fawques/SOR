
package gestor_taller;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para cancelarPedido complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="cancelarPedido">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="idPedido" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="idTaller" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "cancelarPedido", propOrder = {
    "idPedido",
    "idTaller"
})
public class CancelarPedido {

    protected String idPedido;
    protected String idTaller;

    /**
     * Obtiene el valor de la propiedad idPedido.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIdPedido() {
        return idPedido;
    }

    /**
     * Define el valor de la propiedad idPedido.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIdPedido(String value) {
        this.idPedido = value;
    }

    /**
     * Obtiene el valor de la propiedad idTaller.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIdTaller() {
        return idTaller;
    }

    /**
     * Define el valor de la propiedad idTaller.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIdTaller(String value) {
        this.idTaller = value;
    }

}
