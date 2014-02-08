
package org.uddi.api_v3;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para get_authToken complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="get_authToken">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *       &lt;/sequence>
 *       &lt;attribute name="userID" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="cred" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "get_authToken")
public class GetAuthToken {

    @XmlAttribute(name = "userID", required = true)
    protected String userID;
    @XmlAttribute(name = "cred", required = true)
    protected String cred;

    /**
     * Obtiene el valor de la propiedad userID.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUserID() {
        return userID;
    }

    /**
     * Define el valor de la propiedad userID.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUserID(String value) {
        this.userID = value;
    }

    /**
     * Obtiene el valor de la propiedad cred.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCred() {
        return cred;
    }

    /**
     * Define el valor de la propiedad cred.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCred(String value) {
        this.cred = value;
    }

}
