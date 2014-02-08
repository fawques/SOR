
package org.uddi.repl_v3;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para highWaterMarkVector_type complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="highWaterMarkVector_type">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="highWaterMark" type="{urn:uddi-org:repl_v3}changeRecordID_type" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "highWaterMarkVector_type", propOrder = {
    "highWaterMark"
})
public class HighWaterMarkVectorType {

    @XmlElement(nillable = true)
    protected List<ChangeRecordIDType> highWaterMark;

    /**
     * Gets the value of the highWaterMark property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the highWaterMark property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getHighWaterMark().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ChangeRecordIDType }
     * 
     * 
     */
    public List<ChangeRecordIDType> getHighWaterMark() {
        if (highWaterMark == null) {
            highWaterMark = new ArrayList<ChangeRecordIDType>();
        }
        return this.highWaterMark;
    }

}
