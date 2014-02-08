
package org.uddi.api_v3;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para result complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="result">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="errInfo" type="{urn:uddi-org:api_v3}errInfo" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="keyType" type="{urn:uddi-org:api_v3}keyType" />
 *       &lt;attribute name="errno" use="required" type="{http://www.w3.org/2001/XMLSchema}int" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "result", propOrder = {
    "errInfo"
})
public class Result {

    protected ErrInfo errInfo;
    @XmlAttribute(name = "keyType")
    protected KeyType keyType;
    @XmlAttribute(name = "errno", required = true)
    protected int errno;

    /**
     * Obtiene el valor de la propiedad errInfo.
     * 
     * @return
     *     possible object is
     *     {@link ErrInfo }
     *     
     */
    public ErrInfo getErrInfo() {
        return errInfo;
    }

    /**
     * Define el valor de la propiedad errInfo.
     * 
     * @param value
     *     allowed object is
     *     {@link ErrInfo }
     *     
     */
    public void setErrInfo(ErrInfo value) {
        this.errInfo = value;
    }

    /**
     * Obtiene el valor de la propiedad keyType.
     * 
     * @return
     *     possible object is
     *     {@link KeyType }
     *     
     */
    public KeyType getKeyType() {
        return keyType;
    }

    /**
     * Define el valor de la propiedad keyType.
     * 
     * @param value
     *     allowed object is
     *     {@link KeyType }
     *     
     */
    public void setKeyType(KeyType value) {
        this.keyType = value;
    }

    /**
     * Obtiene el valor de la propiedad errno.
     * 
     */
    public int getErrno() {
        return errno;
    }

    /**
     * Define el valor de la propiedad errno.
     * 
     */
    public void setErrno(int value) {
        this.errno = value;
    }

}
