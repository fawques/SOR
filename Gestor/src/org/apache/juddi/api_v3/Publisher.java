
package org.apache.juddi.api_v3;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import org.w3._2000._09.xmldsig.SignatureType;


/**
 * <p>Clase Java para publisher complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="publisher">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="publisherName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="emailAddress" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="isAdmin" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="isEnabled" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="maxBindingsPerService" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="maxBusinesses" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="maxServicePerBusiness" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="maxTModels" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element ref="{http://www.w3.org/2000/09/xmldsig#}Signature" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="authorizedName" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "publisher", propOrder = {
    "publisherName",
    "emailAddress",
    "isAdmin",
    "isEnabled",
    "maxBindingsPerService",
    "maxBusinesses",
    "maxServicePerBusiness",
    "maxTModels",
    "signature"
})
public class Publisher {

    @XmlElement(required = true)
    protected String publisherName;
    protected String emailAddress;
    protected String isAdmin;
    protected String isEnabled;
    protected Integer maxBindingsPerService;
    protected Integer maxBusinesses;
    protected Integer maxServicePerBusiness;
    protected Integer maxTModels;
    @XmlElement(name = "Signature", namespace = "http://www.w3.org/2000/09/xmldsig#")
    protected List<SignatureType> signature;
    @XmlAttribute(name = "authorizedName", required = true)
    protected String authorizedName;

    /**
     * Obtiene el valor de la propiedad publisherName.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPublisherName() {
        return publisherName;
    }

    /**
     * Define el valor de la propiedad publisherName.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPublisherName(String value) {
        this.publisherName = value;
    }

    /**
     * Obtiene el valor de la propiedad emailAddress.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEmailAddress() {
        return emailAddress;
    }

    /**
     * Define el valor de la propiedad emailAddress.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEmailAddress(String value) {
        this.emailAddress = value;
    }

    /**
     * Obtiene el valor de la propiedad isAdmin.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIsAdmin() {
        return isAdmin;
    }

    /**
     * Define el valor de la propiedad isAdmin.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIsAdmin(String value) {
        this.isAdmin = value;
    }

    /**
     * Obtiene el valor de la propiedad isEnabled.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIsEnabled() {
        return isEnabled;
    }

    /**
     * Define el valor de la propiedad isEnabled.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIsEnabled(String value) {
        this.isEnabled = value;
    }

    /**
     * Obtiene el valor de la propiedad maxBindingsPerService.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getMaxBindingsPerService() {
        return maxBindingsPerService;
    }

    /**
     * Define el valor de la propiedad maxBindingsPerService.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setMaxBindingsPerService(Integer value) {
        this.maxBindingsPerService = value;
    }

    /**
     * Obtiene el valor de la propiedad maxBusinesses.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getMaxBusinesses() {
        return maxBusinesses;
    }

    /**
     * Define el valor de la propiedad maxBusinesses.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setMaxBusinesses(Integer value) {
        this.maxBusinesses = value;
    }

    /**
     * Obtiene el valor de la propiedad maxServicePerBusiness.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getMaxServicePerBusiness() {
        return maxServicePerBusiness;
    }

    /**
     * Define el valor de la propiedad maxServicePerBusiness.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setMaxServicePerBusiness(Integer value) {
        this.maxServicePerBusiness = value;
    }

    /**
     * Obtiene el valor de la propiedad maxTModels.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getMaxTModels() {
        return maxTModels;
    }

    /**
     * Define el valor de la propiedad maxTModels.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setMaxTModels(Integer value) {
        this.maxTModels = value;
    }

    /**
     * Gets the value of the signature property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the signature property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSignature().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link SignatureType }
     * 
     * 
     */
    public List<SignatureType> getSignature() {
        if (signature == null) {
            signature = new ArrayList<SignatureType>();
        }
        return this.signature;
    }

    /**
     * Obtiene el valor de la propiedad authorizedName.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAuthorizedName() {
        return authorizedName;
    }

    /**
     * Define el valor de la propiedad authorizedName.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAuthorizedName(String value) {
        this.authorizedName = value;
    }

}
