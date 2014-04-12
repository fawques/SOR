
package gestor_desguace_java;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para checkActivacion complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="checkActivacion">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="idDesguace" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="mail" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "checkActivacion", propOrder = {
    "idDesguace",
    "mail"
})
public class CheckActivacion {

    protected String idDesguace;
    protected String mail;

    /**
     * Obtiene el valor de la propiedad idDesguace.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIdDesguace() {
        return idDesguace;
    }

    /**
     * Define el valor de la propiedad idDesguace.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIdDesguace(String value) {
        this.idDesguace = value;
    }

    /**
     * Obtiene el valor de la propiedad mail.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMail() {
        return mail;
    }

    /**
     * Define el valor de la propiedad mail.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMail(String value) {
        this.mail = value;
    }

}
