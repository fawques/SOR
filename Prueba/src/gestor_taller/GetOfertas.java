
package gestor_taller;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para getOfertas complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="getOfertas">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="listaPedidos" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="idTaller" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="password" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getOfertas", propOrder = {
    "listaPedidos",
    "idTaller",
    "password"
})
public class GetOfertas {

    protected String listaPedidos;
    protected String idTaller;
    protected String password;

    /**
     * Obtiene el valor de la propiedad listaPedidos.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getListaPedidos() {
        return listaPedidos;
    }

    /**
     * Define el valor de la propiedad listaPedidos.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setListaPedidos(String value) {
        this.listaPedidos = value;
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

    /**
     * Obtiene el valor de la propiedad password.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPassword() {
        return password;
    }

    /**
     * Define el valor de la propiedad password.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPassword(String value) {
        this.password = value;
    }

}
