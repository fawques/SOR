
package org.uddi.sub_v3;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.Duration;


/**
 * <p>Clase Java para subscription complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="subscription">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="subscriptionKey" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="subscriptionFilter" type="{urn:uddi-org:sub_v3}subscriptionFilter" minOccurs="0"/>
 *         &lt;element ref="{urn:uddi-org:api_v3}bindingKey" minOccurs="0"/>
 *         &lt;element name="notificationInterval" type="{http://www.w3.org/2001/XMLSchema}duration" minOccurs="0"/>
 *         &lt;element name="maxEntities" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="expiresAfter" type="{http://www.w3.org/2001/XMLSchema}anySimpleType" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="brief" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "subscription", propOrder = {
    "subscriptionKey",
    "subscriptionFilter",
    "bindingKey",
    "notificationInterval",
    "maxEntities",
    "expiresAfter"
})
public class Subscription {

    protected String subscriptionKey;
    protected SubscriptionFilter subscriptionFilter;
    @XmlElement(namespace = "urn:uddi-org:api_v3")
    protected String bindingKey;
    protected Duration notificationInterval;
    protected Integer maxEntities;
    @XmlSchemaType(name = "anySimpleType")
    protected Object expiresAfter;
    @XmlAttribute(name = "brief")
    protected Boolean brief;

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
     * Obtiene el valor de la propiedad subscriptionFilter.
     * 
     * @return
     *     possible object is
     *     {@link SubscriptionFilter }
     *     
     */
    public SubscriptionFilter getSubscriptionFilter() {
        return subscriptionFilter;
    }

    /**
     * Define el valor de la propiedad subscriptionFilter.
     * 
     * @param value
     *     allowed object is
     *     {@link SubscriptionFilter }
     *     
     */
    public void setSubscriptionFilter(SubscriptionFilter value) {
        this.subscriptionFilter = value;
    }

    /**
     * Obtiene el valor de la propiedad bindingKey.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBindingKey() {
        return bindingKey;
    }

    /**
     * Define el valor de la propiedad bindingKey.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBindingKey(String value) {
        this.bindingKey = value;
    }

    /**
     * Obtiene el valor de la propiedad notificationInterval.
     * 
     * @return
     *     possible object is
     *     {@link Duration }
     *     
     */
    public Duration getNotificationInterval() {
        return notificationInterval;
    }

    /**
     * Define el valor de la propiedad notificationInterval.
     * 
     * @param value
     *     allowed object is
     *     {@link Duration }
     *     
     */
    public void setNotificationInterval(Duration value) {
        this.notificationInterval = value;
    }

    /**
     * Obtiene el valor de la propiedad maxEntities.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getMaxEntities() {
        return maxEntities;
    }

    /**
     * Define el valor de la propiedad maxEntities.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setMaxEntities(Integer value) {
        this.maxEntities = value;
    }

    /**
     * Obtiene el valor de la propiedad expiresAfter.
     * 
     * @return
     *     possible object is
     *     {@link Object }
     *     
     */
    public Object getExpiresAfter() {
        return expiresAfter;
    }

    /**
     * Define el valor de la propiedad expiresAfter.
     * 
     * @param value
     *     allowed object is
     *     {@link Object }
     *     
     */
    public void setExpiresAfter(Object value) {
        this.expiresAfter = value;
    }

    /**
     * Obtiene el valor de la propiedad brief.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isBrief() {
        return brief;
    }

    /**
     * Define el valor de la propiedad brief.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setBrief(Boolean value) {
        this.brief = value;
    }

}
