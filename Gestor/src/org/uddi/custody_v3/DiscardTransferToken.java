
package org.uddi.custody_v3;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para discard_transferToken complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="discard_transferToken">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{urn:uddi-org:api_v3}authInfo" minOccurs="0"/>
 *         &lt;element name="transferToken" type="{urn:uddi-org:custody_v3}transferToken" minOccurs="0"/>
 *         &lt;element name="keyBag" type="{urn:uddi-org:custody_v3}keyBag" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "discard_transferToken", propOrder = {
    "authInfo",
    "transferToken",
    "keyBag"
})
public class DiscardTransferToken {

    @XmlElement(namespace = "urn:uddi-org:api_v3")
    protected String authInfo;
    protected TransferToken transferToken;
    protected KeyBag keyBag;

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
     * Obtiene el valor de la propiedad transferToken.
     * 
     * @return
     *     possible object is
     *     {@link TransferToken }
     *     
     */
    public TransferToken getTransferToken() {
        return transferToken;
    }

    /**
     * Define el valor de la propiedad transferToken.
     * 
     * @param value
     *     allowed object is
     *     {@link TransferToken }
     *     
     */
    public void setTransferToken(TransferToken value) {
        this.transferToken = value;
    }

    /**
     * Obtiene el valor de la propiedad keyBag.
     * 
     * @return
     *     possible object is
     *     {@link KeyBag }
     *     
     */
    public KeyBag getKeyBag() {
        return keyBag;
    }

    /**
     * Define el valor de la propiedad keyBag.
     * 
     * @param value
     *     allowed object is
     *     {@link KeyBag }
     *     
     */
    public void setKeyBag(KeyBag value) {
        this.keyBag = value;
    }

}
