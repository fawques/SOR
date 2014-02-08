
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
 *         &lt;element ref="{urn:uddi-org:repl_v3}changeRecordNewData"/>
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
    "changeRecordNewData"
})
@XmlRootElement(name = "changeRecordNewDataConditional")
public class ChangeRecordNewDataConditional {

    @XmlElement(required = true)
    protected ChangeRecordNewData changeRecordNewData;

    /**
     * Obtiene el valor de la propiedad changeRecordNewData.
     * 
     * @return
     *     possible object is
     *     {@link ChangeRecordNewData }
     *     
     */
    public ChangeRecordNewData getChangeRecordNewData() {
        return changeRecordNewData;
    }

    /**
     * Define el valor de la propiedad changeRecordNewData.
     * 
     * @param value
     *     allowed object is
     *     {@link ChangeRecordNewData }
     *     
     */
    public void setChangeRecordNewData(ChangeRecordNewData value) {
        this.changeRecordNewData = value;
    }

}
