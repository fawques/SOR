
package org.uddi.repl_v3;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import org.uddi.custody_v3.KeyBag;
import org.uddi.custody_v3.TransferOperationalInfo;
import org.uddi.custody_v3.TransferToken;


/**
 * <p>Clase Java para transfer_custody complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="transfer_custody">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{urn:uddi-org:custody_v3}transferToken"/>
 *         &lt;element ref="{urn:uddi-org:custody_v3}keyBag"/>
 *         &lt;element ref="{urn:uddi-org:custody_v3}transferOperationalInfo"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "transfer_custody", propOrder = {
    "transferToken",
    "keyBag",
    "transferOperationalInfo"
})
public class TransferCustody {

    @XmlElement(namespace = "urn:uddi-org:custody_v3", required = true)
    protected TransferToken transferToken;
    @XmlElement(namespace = "urn:uddi-org:custody_v3", required = true)
    protected KeyBag keyBag;
    @XmlElement(namespace = "urn:uddi-org:custody_v3", required = true)
    protected TransferOperationalInfo transferOperationalInfo;

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

    /**
     * Obtiene el valor de la propiedad transferOperationalInfo.
     * 
     * @return
     *     possible object is
     *     {@link TransferOperationalInfo }
     *     
     */
    public TransferOperationalInfo getTransferOperationalInfo() {
        return transferOperationalInfo;
    }

    /**
     * Define el valor de la propiedad transferOperationalInfo.
     * 
     * @param value
     *     allowed object is
     *     {@link TransferOperationalInfo }
     *     
     */
    public void setTransferOperationalInfo(TransferOperationalInfo value) {
        this.transferOperationalInfo = value;
    }

}
