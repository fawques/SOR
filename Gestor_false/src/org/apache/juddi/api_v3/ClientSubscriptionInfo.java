
package org.apache.juddi.api_v3;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Clase Java para clientSubscriptionInfo complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="clientSubscriptionInfo">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="subscriptionKey" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="fromClerk" type="{urn:juddi-apache-org:api_v3}clerk"/>
 *         &lt;element name="toClerk" type="{urn:juddi-apache-org:api_v3}clerk"/>
 *         &lt;element name="lastModified" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "clientSubscriptionInfo", propOrder = {
    "subscriptionKey",
    "fromClerk",
    "toClerk",
    "lastModified"
})
public class ClientSubscriptionInfo {

    @XmlElement(required = true)
    protected String subscriptionKey;
    @XmlElement(required = true)
    protected Clerk fromClerk;
    @XmlElement(required = true)
    protected Clerk toClerk;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar lastModified;

    /**
     * Obtiene el valor de la propiedad subscriptionKey.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSubscriptionKey() {
        return subscriptionKey;
    }

    /**
     * Define el valor de la propiedad subscriptionKey.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSubscriptionKey(String value) {
        this.subscriptionKey = value;
    }

    /**
     * Obtiene el valor de la propiedad fromClerk.
     * 
     * @return
     *     possible object is
     *     {@link Clerk }
     *     
     */
    public Clerk getFromClerk() {
        return fromClerk;
    }

    /**
     * Define el valor de la propiedad fromClerk.
     * 
     * @param value
     *     allowed object is
     *     {@link Clerk }
     *     
     */
    public void setFromClerk(Clerk value) {
        this.fromClerk = value;
    }

    /**
     * Obtiene el valor de la propiedad toClerk.
     * 
     * @return
     *     possible object is
     *     {@link Clerk }
     *     
     */
    public Clerk getToClerk() {
        return toClerk;
    }

    /**
     * Define el valor de la propiedad toClerk.
     * 
     * @param value
     *     allowed object is
     *     {@link Clerk }
     *     
     */
    public void setToClerk(Clerk value) {
        this.toClerk = value;
    }

    /**
     * Obtiene el valor de la propiedad lastModified.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getLastModified() {
        return lastModified;
    }

    /**
     * Define el valor de la propiedad lastModified.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setLastModified(XMLGregorianCalendar value) {
        this.lastModified = value;
    }

}
