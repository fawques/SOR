
package org.uddi.api_v3;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para identifierBag complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="identifierBag">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="keyedReference" type="{urn:uddi-org:api_v3}keyedReference" maxOccurs="unbounded"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "identifierBag", propOrder = {
    "keyedReference"
})
public class IdentifierBag {

    @XmlElement(required = true)
    protected List<KeyedReference> keyedReference;

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

}
