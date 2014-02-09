
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
 *         &lt;element ref="{urn:uddi-org:repl_v3}changeRecord"/>
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
    "changeRecord"
})
@XmlRootElement(name = "changeRecordCorrection")
public class ChangeRecordCorrection {

    @XmlElement(required = true)
    protected ChangeRecord changeRecord;

    /**
     * Obtiene el valor de la propiedad changeRecord.
     * 
     * @return
     *     possible object is
     *     {@link ChangeRecord }
     *     
     */
    public ChangeRecord getChangeRecord() {
        return changeRecord;
    }

    /**
     * Define el valor de la propiedad changeRecord.
     * 
     * @param value
     *     allowed object is
     *     {@link ChangeRecord }
     *     
     */
    public void setChangeRecord(ChangeRecord value) {
        this.changeRecord = value;
    }

}
