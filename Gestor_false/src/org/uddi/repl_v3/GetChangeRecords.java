
package org.uddi.repl_v3;

import java.math.BigInteger;
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
 *         &lt;element name="requestingNode" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="changesAlreadySeen" type="{urn:uddi-org:repl_v3}highWaterMarkVector_type" minOccurs="0"/>
 *         &lt;element name="responseLimitCount" type="{http://www.w3.org/2001/XMLSchema}integer" minOccurs="0"/>
 *         &lt;element name="responseLimitVector" type="{urn:uddi-org:repl_v3}highWaterMarkVector_type" minOccurs="0"/>
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
    "requestingNode",
    "changesAlreadySeen",
    "responseLimitCount",
    "responseLimitVector"
})
@XmlRootElement(name = "get_changeRecords")
public class GetChangeRecords {

    @XmlElement(required = true)
    protected String requestingNode;
    protected HighWaterMarkVectorType changesAlreadySeen;
    protected BigInteger responseLimitCount;
    protected HighWaterMarkVectorType responseLimitVector;

    /**
     * Obtiene el valor de la propiedad requestingNode.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRequestingNode() {
        return requestingNode;
    }

    /**
     * Define el valor de la propiedad requestingNode.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRequestingNode(String value) {
        this.requestingNode = value;
    }

    /**
     * Obtiene el valor de la propiedad changesAlreadySeen.
     * 
     * @return
     *     possible object is
     *     {@link HighWaterMarkVectorType }
     *     
     */
    public HighWaterMarkVectorType getChangesAlreadySeen() {
        return changesAlreadySeen;
    }

    /**
     * Define el valor de la propiedad changesAlreadySeen.
     * 
     * @param value
     *     allowed object is
     *     {@link HighWaterMarkVectorType }
     *     
     */
    public void setChangesAlreadySeen(HighWaterMarkVectorType value) {
        this.changesAlreadySeen = value;
    }

    /**
     * Obtiene el valor de la propiedad responseLimitCount.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getResponseLimitCount() {
        return responseLimitCount;
    }

    /**
     * Define el valor de la propiedad responseLimitCount.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setResponseLimitCount(BigInteger value) {
        this.responseLimitCount = value;
    }

    /**
     * Obtiene el valor de la propiedad responseLimitVector.
     * 
     * @return
     *     possible object is
     *     {@link HighWaterMarkVectorType }
     *     
     */
    public HighWaterMarkVectorType getResponseLimitVector() {
        return responseLimitVector;
    }

    /**
     * Define el valor de la propiedad responseLimitVector.
     * 
     * @param value
     *     allowed object is
     *     {@link HighWaterMarkVectorType }
     *     
     */
    public void setResponseLimitVector(HighWaterMarkVectorType value) {
        this.responseLimitVector = value;
    }

}
