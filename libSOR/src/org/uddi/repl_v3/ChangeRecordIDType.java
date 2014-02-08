
package org.uddi.repl_v3;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para changeRecordID_type complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="changeRecordID_type">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="nodeID" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="originatingUSN" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "changeRecordID_type", propOrder = {
    "nodeID",
    "originatingUSN"
})
public class ChangeRecordIDType {

    @XmlElement(required = true)
    protected String nodeID;
    protected Long originatingUSN;

    /**
     * Obtiene el valor de la propiedad nodeID.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNodeID() {
        return nodeID;
    }

    /**
     * Define el valor de la propiedad nodeID.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNodeID(String value) {
        this.nodeID = value;
    }

    /**
     * Obtiene el valor de la propiedad originatingUSN.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getOriginatingUSN() {
        return originatingUSN;
    }

    /**
     * Define el valor de la propiedad originatingUSN.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setOriginatingUSN(Long value) {
        this.originatingUSN = value;
    }

}
