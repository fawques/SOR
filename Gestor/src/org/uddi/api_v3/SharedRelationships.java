
package org.uddi.api_v3;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para sharedRelationships complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="sharedRelationships">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="keyedReference" type="{urn:uddi-org:api_v3}keyedReference" maxOccurs="unbounded"/>
 *         &lt;element name="publisherAssertion" type="{urn:uddi-org:api_v3}publisherAssertion" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="direction" use="required" type="{urn:uddi-org:api_v3}direction" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "sharedRelationships", propOrder = {
    "keyedReference",
    "publisherAssertion"
})
public class SharedRelationships {

    @XmlElement(required = true)
    protected List<KeyedReference> keyedReference;
    @XmlElement(nillable = true)
    protected List<PublisherAssertion> publisherAssertion;
    @XmlAttribute(name = "direction", required = true)
    protected Direction direction;

    /**
     * Gets the value of the keyedReference property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the keyedReference property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getKeyedReference().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link KeyedReference }
     * 
     * 
     */
    public List<KeyedReference> getKeyedReference() {
        if (keyedReference == null) {
            keyedReference = new ArrayList<KeyedReference>();
        }
        return this.keyedReference;
    }

    /**
     * Gets the value of the publisherAssertion property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the publisherAssertion property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPublisherAssertion().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link PublisherAssertion }
     * 
     * 
     */
    public List<PublisherAssertion> getPublisherAssertion() {
        if (publisherAssertion == null) {
            publisherAssertion = new ArrayList<PublisherAssertion>();
        }
        return this.publisherAssertion;
    }

    /**
     * Obtiene el valor de la propiedad direction.
     * 
     * @return
     *     possible object is
     *     {@link Direction }
     *     
     */
    public Direction getDirection() {
        return direction;
    }

    /**
     * Define el valor de la propiedad direction.
     * 
     * @param value
     *     allowed object is
     *     {@link Direction }
     *     
     */
    public void setDirection(Direction value) {
        this.direction = value;
    }

}
