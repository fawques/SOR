
package org.uddi.api_v3;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para relatedBusinessInfos complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="relatedBusinessInfos">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="relatedBusinessInfo" type="{urn:uddi-org:api_v3}relatedBusinessInfo" maxOccurs="unbounded"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "relatedBusinessInfos", propOrder = {
    "relatedBusinessInfo"
})
public class RelatedBusinessInfos {

    @XmlElement(required = true)
    protected List<RelatedBusinessInfo> relatedBusinessInfo;

    /**
     * Gets the value of the relatedBusinessInfo property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the relatedBusinessInfo property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getRelatedBusinessInfo().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link RelatedBusinessInfo }
     * 
     * 
     */
    public List<RelatedBusinessInfo> getRelatedBusinessInfo() {
        if (relatedBusinessInfo == null) {
            relatedBusinessInfo = new ArrayList<RelatedBusinessInfo>();
        }
        return this.relatedBusinessInfo;
    }

}
