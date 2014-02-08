
package org.uddi.api_v3;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para assertionStatusItem complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="assertionStatusItem">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="fromKey" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="toKey" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="keyedReference" type="{urn:uddi-org:api_v3}keyedReference"/>
 *         &lt;element name="keysOwned" type="{urn:uddi-org:api_v3}keysOwned"/>
 *       &lt;/sequence>
 *       &lt;attribute name="completionStatus" use="required" type="{urn:uddi-org:api_v3}completionStatus" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "assertionStatusItem", propOrder = {
    "fromKey",
    "toKey",
    "keyedReference",
    "keysOwned"
})
public class AssertionStatusItem {

    @XmlElement(required = true)
    protected String fromKey;
    @XmlElement(required = true)
    protected String toKey;
    @XmlElement(required = true)
    protected KeyedReference keyedReference;
    @XmlElement(required = true)
    protected KeysOwned keysOwned;
    @XmlAttribute(name = "completionStatus", required = true)
    protected CompletionStatus completionStatus;

    /**
     * Obtiene el valor de la propiedad fromKey.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFromKey() {
        return fromKey;
    }

    /**
     * Define el valor de la propiedad fromKey.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFromKey(String value) {
        this.fromKey = value;
    }

    /**
     * Obtiene el valor de la propiedad toKey.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getToKey() {
        return toKey;
    }

    /**
     * Define el valor de la propiedad toKey.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setToKey(String value) {
        this.toKey = value;
    }

    /**
     * Obtiene el valor de la propiedad keyedReference.
     * 
     * @return
     *     possible object is
     *     {@link KeyedReference }
     *     
     */
    public KeyedReference getKeyedReference() {
        return keyedReference;
    }

    /**
     * Define el valor de la propiedad keyedReference.
     * 
     * @param value
     *     allowed object is
     *     {@link KeyedReference }
     *     
     */
    public void setKeyedReference(KeyedReference value) {
        this.keyedReference = value;
    }

    /**
     * Obtiene el valor de la propiedad keysOwned.
     * 
     * @return
     *     possible object is
     *     {@link KeysOwned }
     *     
     */
    public KeysOwned getKeysOwned() {
        return keysOwned;
    }

    /**
     * Define el valor de la propiedad keysOwned.
     * 
     * @param value
     *     allowed object is
     *     {@link KeysOwned }
     *     
     */
    public void setKeysOwned(KeysOwned value) {
        this.keysOwned = value;
    }

    /**
     * Obtiene el valor de la propiedad completionStatus.
     * 
     * @return
     *     possible object is
     *     {@link CompletionStatus }
     *     
     */
    public CompletionStatus getCompletionStatus() {
        return completionStatus;
    }

    /**
     * Define el valor de la propiedad completionStatus.
     * 
     * @param value
     *     allowed object is
     *     {@link CompletionStatus }
     *     
     */
    public void setCompletionStatus(CompletionStatus value) {
        this.completionStatus = value;
    }

}
