
package org.uddi.repl_v3;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
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
 *         &lt;element name="tModelKey" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="modified" type="{http://www.w3.org/2001/XMLSchema}anySimpleType"/>
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
    "tModelKey",
    "modified"
})
@XmlRootElement(name = "changeRecordHide")
public class ChangeRecordHide {

    @XmlElement(required = true)
    protected String tModelKey;
    @XmlElement(required = true)
    @XmlSchemaType(name = "anySimpleType")
    protected Object modified;

    /**
     * Obtiene el valor de la propiedad tModelKey.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTModelKey() {
        return tModelKey;
    }

    /**
     * Define el valor de la propiedad tModelKey.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTModelKey(String value) {
        this.tModelKey = value;
    }

    /**
     * Obtiene el valor de la propiedad modified.
     * 
     * @return
     *     possible object is
     *     {@link Object }
     *     
     */
    public Object getModified() {
        return modified;
    }

    /**
     * Define el valor de la propiedad modified.
     * 
     * @param value
     *     allowed object is
     *     {@link Object }
     *     
     */
    public void setModified(Object value) {
        this.modified = value;
    }

}
