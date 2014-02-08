
package org.uddi.subr_v3;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import org.uddi.sub_v3.SubscriptionResultsList;


/**
 * <p>Clase Java para notify_subscriptionListener complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="notify_subscriptionListener">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{urn:uddi-org:api_v3}authInfo" minOccurs="0"/>
 *         &lt;element ref="{urn:uddi-org:sub_v3}subscriptionResultsList"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "notify_subscriptionListener", propOrder = {
    "authInfo",
    "subscriptionResultsList"
})
public class NotifySubscriptionListener {

    @XmlElement(namespace = "urn:uddi-org:api_v3")
    protected String authInfo;
    @XmlElement(namespace = "urn:uddi-org:sub_v3", required = true)
    protected SubscriptionResultsList subscriptionResultsList;

    /**
     * Obtiene el valor de la propiedad authInfo.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAuthInfo() {
        return authInfo;
    }

    /**
     * Define el valor de la propiedad authInfo.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAuthInfo(String value) {
        this.authInfo = value;
    }

    /**
     * Obtiene el valor de la propiedad subscriptionResultsList.
     * 
     * @return
     *     possible object is
     *     {@link SubscriptionResultsList }
     *     
     */
    public SubscriptionResultsList getSubscriptionResultsList() {
        return subscriptionResultsList;
    }

    /**
     * Define el valor de la propiedad subscriptionResultsList.
     * 
     * @param value
     *     allowed object is
     *     {@link SubscriptionResultsList }
     *     
     */
    public void setSubscriptionResultsList(SubscriptionResultsList value) {
        this.subscriptionResultsList = value;
    }

}
