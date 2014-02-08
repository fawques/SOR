
package org.uddi.custody_v3;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Clase Java para transferToken complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="transferToken">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{urn:uddi-org:api_v3}nodeID"/>
 *         &lt;element name="expirationTime" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="opaqueToken" type="{http://www.w3.org/2001/XMLSchema}base64Binary"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "transferToken", propOrder = {
    "nodeID",
    "expirationTime",
    "opaqueToken"
})
public class TransferToken {

    @XmlElement(namespace = "urn:uddi-org:api_v3", required = true)
    protected String nodeID;
    @XmlElement(required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar expirationTime;
    @XmlElement(required = true)
    protected byte[] opaqueToken;

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
     * Obtiene el valor de la propiedad expirationTime.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getExpirationTime() {
        return expirationTime;
    }

    /**
     * Define el valor de la propiedad expirationTime.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setExpirationTime(XMLGregorianCalendar value) {
        this.expirationTime = value;
    }

    /**
     * Obtiene el valor de la propiedad opaqueToken.
     * 
     * @return
     *     possible object is
     *     byte[]
     */
    public byte[] getOpaqueToken() {
        return opaqueToken;
    }

    /**
     * Define el valor de la propiedad opaqueToken.
     * 
     * @param value
     *     allowed object is
     *     byte[]
     */
    public void setOpaqueToken(byte[] value) {
        this.opaqueToken = value;
    }

}
