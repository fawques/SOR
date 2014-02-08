
package org.uddi.repl_v3;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import org.uddi.api_v3.PublisherAssertion;


/**
 * <p>Clase Java para anonymous complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{urn:uddi-org:api_v3}publisherAssertion"/>
 *         &lt;element name="fromBusinessCheck" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="toBusinessCheck" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="modified" type="{http://www.w3.org/2001/XMLSchema}anySimpleType"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "publisherAssertion",
    "fromBusinessCheck",
    "toBusinessCheck",
    "modified"
})
@XmlRootElement(name = "changeRecordDeleteAssertion")
public class ChangeRecordDeleteAssertion {

    @XmlElement(namespace = "urn:uddi-org:api_v3", required = true)
    protected PublisherAssertion publisherAssertion;
    protected boolean fromBusinessCheck;
    protected boolean toBusinessCheck;
    @XmlElement(required = true)
    @XmlSchemaType(name = "anySimpleType")
    protected Object modified;

    /**
     * Obtiene el valor de la propiedad publisherAssertion.
     * 
     * @return
     *     possible object is
     *     {@link PublisherAssertion }
     *     
     */
    public PublisherAssertion getPublisherAssertion() {
        return publisherAssertion;
    }

    /**
     * Define el valor de la propiedad publisherAssertion.
     * 
     * @param value
     *     allowed object is
     *     {@link PublisherAssertion }
     *     
     */
    public void setPublisherAssertion(PublisherAssertion value) {
        this.publisherAssertion = value;
    }

    /**
     * Obtiene el valor de la propiedad fromBusinessCheck.
     * 
     */
    public boolean isFromBusinessCheck() {
        return fromBusinessCheck;
    }

    /**
     * Define el valor de la propiedad fromBusinessCheck.
     * 
     */
    public void setFromBusinessCheck(boolean value) {
        this.fromBusinessCheck = value;
    }

    /**
     * Obtiene el valor de la propiedad toBusinessCheck.
     * 
     */
    public boolean isToBusinessCheck() {
        return toBusinessCheck;
    }

    /**
     * Define el valor de la propiedad toBusinessCheck.
     * 
     */
    public void setToBusinessCheck(boolean value) {
        this.toBusinessCheck = value;
    }

    /**
     * Obtiene el valor de la propiedad modified.
     * 
     * @return
     *     possible object is
     *     {@link Object }
     *     
     */
    public Object getModified() {
        return modified;
    }

    /**
     * Define el valor de la propiedad modified.
     * 
     * @param value
     *     allowed object is
     *     {@link Object }
     *     
     */
    public void setModified(Object value) {
        this.modified = value;
    }

}
