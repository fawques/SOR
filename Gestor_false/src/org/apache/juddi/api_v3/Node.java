
package org.apache.juddi.api_v3;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para node complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="node">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="name" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="clientName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="description" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="custodyTransferUrl" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="inquiryUrl" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="publishUrl" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="securityUrl" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="subscriptionUrl" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="subscriptionListenerUrl" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="juddiApiUrl" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="proxyTransport" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="factoryInitial" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="factoryURLPkgs" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="factoryNamingProvider" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "node", propOrder = {
    "name",
    "clientName",
    "description",
    "custodyTransferUrl",
    "inquiryUrl",
    "publishUrl",
    "securityUrl",
    "subscriptionUrl",
    "subscriptionListenerUrl",
    "juddiApiUrl",
    "proxyTransport",
    "factoryInitial",
    "factoryURLPkgs",
    "factoryNamingProvider"
})
public class Node {

    protected String name;
    protected String clientName;
    protected String description;
    protected String custodyTransferUrl;
    protected String inquiryUrl;
    protected String publishUrl;
    protected String securityUrl;
    protected String subscriptionUrl;
    protected String subscriptionListenerUrl;
    protected String juddiApiUrl;
    protected String proxyTransport;
    protected String factoryInitial;
    protected String factoryURLPkgs;
    protected String factoryNamingProvider;

    /**
     * Obtiene el valor de la propiedad name.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getName() {
        return name;
    }

    /**
     * Define el valor de la propiedad name.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setName(String value) {
        this.name = value;
    }

    /**
     * Obtiene el valor de la propiedad clientName.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getClientName() {
        return clientName;
    }

    /**
     * Define el valor de la propiedad clientName.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setClientName(String value) {
        this.clientName = value;
    }

    /**
     * Obtiene el valor de la propiedad description.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescription() {
        return description;
    }

    /**
     * Define el valor de la propiedad description.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescription(String value) {
        this.description = value;
    }

    /**
     * Obtiene el valor de la propiedad custodyTransferUrl.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCustodyTransferUrl() {
        return custodyTransferUrl;
    }

    /**
     * Define el valor de la propiedad custodyTransferUrl.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCustodyTransferUrl(String value) {
        this.custodyTransferUrl = value;
    }

    /**
     * Obtiene el valor de la propiedad inquiryUrl.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getInquiryUrl() {
        return inquiryUrl;
    }

    /**
     * Define el valor de la propiedad inquiryUrl.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setInquiryUrl(String value) {
        this.inquiryUrl = value;
    }

    /**
     * Obtiene el valor de la propiedad publishUrl.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPublishUrl() {
        return publishUrl;
    }

    /**
     * Define el valor de la propiedad publishUrl.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPublishUrl(String value) {
        this.publishUrl = value;
    }

    /**
     * Obtiene el valor de la propiedad securityUrl.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSecurityUrl() {
        return securityUrl;
    }

    /**
     * Define el valor de la propiedad securityUrl.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSecurityUrl(String value) {
        this.securityUrl = value;
    }

    /**
     * Obtiene el valor de la propiedad subscriptionUrl.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSubscriptionUrl() {
        return subscriptionUrl;
    }

    /**
     * Define el valor de la propiedad subscriptionUrl.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSubscriptionUrl(String value) {
        this.subscriptionUrl = value;
    }

    /**
     * Obtiene el valor de la propiedad subscriptionListenerUrl.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSubscriptionListenerUrl() {
        return subscriptionListenerUrl;
    }

    /**
     * Define el valor de la propiedad subscriptionListenerUrl.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSubscriptionListenerUrl(String value) {
        this.subscriptionListenerUrl = value;
    }

    /**
     * Obtiene el valor de la propiedad juddiApiUrl.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getJuddiApiUrl() {
        return juddiApiUrl;
    }

    /**
     * Define el valor de la propiedad juddiApiUrl.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setJuddiApiUrl(String value) {
        this.juddiApiUrl = value;
    }

    /**
     * Obtiene el valor de la propiedad proxyTransport.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProxyTransport() {
        return proxyTransport;
    }

    /**
     * Define el valor de la propiedad proxyTransport.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProxyTransport(String value) {
        this.proxyTransport = value;
    }

    /**
     * Obtiene el valor de la propiedad factoryInitial.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFactoryInitial() {
        return factoryInitial;
    }

    /**
     * Define el valor de la propiedad factoryInitial.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFactoryInitial(String value) {
        this.factoryInitial = value;
    }

    /**
     * Obtiene el valor de la propiedad factoryURLPkgs.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFactoryURLPkgs() {
        return factoryURLPkgs;
    }

    /**
     * Define el valor de la propiedad factoryURLPkgs.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFactoryURLPkgs(String value) {
        this.factoryURLPkgs = value;
    }

    /**
     * Obtiene el valor de la propiedad factoryNamingProvider.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFactoryNamingProvider() {
        return factoryNamingProvider;
    }

    /**
     * Define el valor de la propiedad factoryNamingProvider.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFactoryNamingProvider(String value) {
        this.factoryNamingProvider = value;
    }

}
