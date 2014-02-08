
package org.uddi.sub_v3;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para get_subscriptionResults complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="get_subscriptionResults">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{urn:uddi-org:api_v3}authInfo" minOccurs="0"/>
 *         &lt;element name="subscriptionKey" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="coveragePeriod" type="{urn:uddi-org:sub_v3}coveragePeriod"/>
 *         &lt;element name="chunkToken" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "get_subscriptionResults", propOrder = {
    "authInfo",
    "subscriptionKey",
    "coveragePeriod",
    "chunkToken"
})
public class GetSubscriptionResults {

    @XmlElement(namespace = "urn:uddi-org:api_v3")
    protected String authInfo;
    @XmlElement(required = true)
    protected String subscriptionKey;
    @XmlElement(required = true)
    protected CoveragePeriod coveragePeriod;
    protected String chunkToken;

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
     * Obtiene el valor de la propiedad coveragePeriod.
     * 
     * @return
     *     possible object is
     *     {@link CoveragePeriod }
     *     
     */
    public CoveragePeriod getCoveragePeriod() {
        return coveragePeriod;
    }

    /**
     * Define el valor de la propiedad coveragePeriod.
     * 
     * @param value
     *     allowed object is
     *     {@link CoveragePeriod }
     *     
     */
    public void setCoveragePeriod(CoveragePeriod value) {
        this.coveragePeriod = value;
    }

    /**
     * Obtiene el valor de la propiedad chunkToken.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getChunkToken() {
        return chunkToken;
    }

    /**
     * Define el valor de la propiedad chunkToken.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setChunkToken(String value) {
        this.chunkToken = value;
    }

}
