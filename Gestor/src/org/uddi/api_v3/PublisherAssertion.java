
package org.uddi.api_v3;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import org.w3._2000._09.xmldsig.SignatureType;


/**
 * <p>Clase Java para publisherAssertion complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="publisherAssertion">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="fromKey" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="toKey" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="keyedReference" type="{urn:uddi-org:api_v3}keyedReference"/>
 *         &lt;element ref="{http://www.w3.org/2000/09/xmldsig#}Signature" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "publisherAssertion", propOrder = {
    "fromKey",
    "toKey",
    "keyedReference",
    "signature"
})
public class PublisherAssertion {

    @XmlElement(required = true)
    protected String fromKey;
    @XmlElement(required = true)
    protected String toKey;
    @XmlElement(required = true)
    protected KeyedReference keyedReference;
    @XmlElement(name = "Signature", namespace = "http://www.w3.org/2000/09/xmldsig#")
    protected List<SignatureType> signature;

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
     * Gets the value of the signature property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the signature property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSignature().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link SignatureType }
     * 
     * 
     */
    public List<SignatureType> getSignature() {
        if (signature == null) {
            signature = new ArrayList<SignatureType>();
        }
        return this.signature;
    }

}
