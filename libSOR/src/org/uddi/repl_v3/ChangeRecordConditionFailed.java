
package org.uddi.repl_v3;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para anonymous complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="failedChangeID" type="{urn:uddi-org:repl_v3}changeRecordID_type"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "failedChangeID"
})
@XmlRootElement(name = "changeRecordConditionFailed")
public class ChangeRecordConditionFailed {

    @XmlElement(required = true)
    protected ChangeRecordIDType failedChangeID;

    /**
     * Obtiene el valor de la propiedad failedChangeID.
     * 
     * @return
     *     possible object is
     *     {@link ChangeRecordIDType }
     *     
     */
    public ChangeRecordIDType getFailedChangeID() {
        return failedChangeID;
    }

    /**
     * Define el valor de la propiedad failedChangeID.
     * 
     * @param value
     *     allowed object is
     *     {@link ChangeRecordIDType }
     *     
     */
    public void setFailedChangeID(ChangeRecordIDType value) {
        this.failedChangeID = value;
    }

}
