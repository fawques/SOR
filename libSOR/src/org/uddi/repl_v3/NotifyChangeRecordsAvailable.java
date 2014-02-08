
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
 *         &lt;element name="notifyingNode" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="changesAvailable" type="{urn:uddi-org:repl_v3}highWaterMarkVector_type"/>
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
    "notifyingNode",
    "changesAvailable"
})
@XmlRootElement(name = "notify_changeRecordsAvailable")
public class NotifyChangeRecordsAvailable {

    @XmlElement(required = true)
    protected String notifyingNode;
    @XmlElement(required = true)
    protected HighWaterMarkVectorType changesAvailable;

    /**
     * Obtiene el valor de la propiedad notifyingNode.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNotifyingNode() {
        return notifyingNode;
    }

    /**
     * Define el valor de la propiedad notifyingNode.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNotifyingNode(String value) {
        this.notifyingNode = value;
    }

    /**
     * Obtiene el valor de la propiedad changesAvailable.
     * 
     * @return
     *     possible object is
     *     {@link HighWaterMarkVectorType }
     *     
     */
    public HighWaterMarkVectorType getChangesAvailable() {
        return changesAvailable;
    }

    /**
     * Define el valor de la propiedad changesAvailable.
     * 
     * @param value
     *     allowed object is
     *     {@link HighWaterMarkVectorType }
     *     
     */
    public void setChangesAvailable(HighWaterMarkVectorType value) {
        this.changesAvailable = value;
    }

}
