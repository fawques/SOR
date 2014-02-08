
package org.uddi.api_v3;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para publisherAssertions complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="publisherAssertions">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="publisherAssertion" type="{urn:uddi-org:api_v3}publisherAssertion" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "publisherAssertions", propOrder = {
    "publisherAssertion"
})
public class PublisherAssertions {

    @XmlElement(nillable = true)
    protected List<PublisherAssertion> publisherAssertion;

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

}
