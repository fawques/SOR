
package org.uddi.api_v3;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para tModelInstanceDetails complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="tModelInstanceDetails">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="tModelInstanceInfo" type="{urn:uddi-org:api_v3}tModelInstanceInfo" maxOccurs="unbounded"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "tModelInstanceDetails", propOrder = {
    "tModelInstanceInfo"
})
public class TModelInstanceDetails {

    @XmlElement(required = true)
    protected List<TModelInstanceInfo> tModelInstanceInfo;

    /**
     * Gets the value of the tModelInstanceInfo property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the tModelInstanceInfo property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getTModelInstanceInfo().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TModelInstanceInfo }
     * 
     * 
     */
    public List<TModelInstanceInfo> getTModelInstanceInfo() {
        if (tModelInstanceInfo == null) {
            tModelInstanceInfo = new ArrayList<TModelInstanceInfo>();
        }
        return this.tModelInstanceInfo;
    }

}
