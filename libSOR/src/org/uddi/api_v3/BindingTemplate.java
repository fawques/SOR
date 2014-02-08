
package org.uddi.api_v3;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import org.w3._2000._09.xmldsig.SignatureType;


/**
 * <p>Clase Java para bindingTemplate complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="bindingTemplate">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="description" type="{urn:uddi-org:api_v3}description" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="accessPoint" type="{urn:uddi-org:api_v3}accessPoint" minOccurs="0"/>
 *         &lt;element name="hostingRedirector" type="{urn:uddi-org:api_v3}hostingRedirector" minOccurs="0"/>
 *         &lt;element name="tModelInstanceDetails" type="{urn:uddi-org:api_v3}tModelInstanceDetails" minOccurs="0"/>
 *         &lt;element name="categoryBag" type="{urn:uddi-org:api_v3}categoryBag" minOccurs="0"/>
 *         &lt;element ref="{http://www.w3.org/2000/09/xmldsig#}Signature" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="bindingKey" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="serviceKey" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "bindingTemplate", propOrder = {
    "description",
    "accessPoint",
    "hostingRedirector",
    "tModelInstanceDetails",
    "categoryBag",
    "signature"
})
public class BindingTemplate {

    @XmlElement(nillable = true)
    protected List<Description> description;
    protected AccessPoint accessPoint;
    protected HostingRedirector hostingRedirector;
    protected TModelInstanceDetails tModelInstanceDetails;
    protected CategoryBag categoryBag;
    @XmlElement(name = "Signature", namespace = "http://www.w3.org/2000/09/xmldsig#")
    protected List<SignatureType> signature;
    @XmlAttribute(name = "bindingKey")
    protected String bindingKey;
    @XmlAttribute(name = "serviceKey")
    protected String serviceKey;

    /**
     * Gets the value of the description property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the description property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDescription().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Description }
     * 
     * 
     */
    public List<Description> getDescription() {
        if (description == null) {
            description = new ArrayList<Description>();
        }
        return this.description;
    }

    /**
     * Obtiene el valor de la propiedad accessPoint.
     * 
     * @return
     *     possible object is
     *     {@link AccessPoint }
     *     
     */
    public AccessPoint getAccessPoint() {
        return accessPoint;
    }

    /**
     * Define el valor de la propiedad accessPoint.
     * 
     * @param value
     *     allowed object is
     *     {@link AccessPoint }
     *     
     */
    public void setAccessPoint(AccessPoint value) {
        this.accessPoint = value;
    }

    /**
     * Obtiene el valor de la propiedad hostingRedirector.
     * 
     * @return
     *     possible object is
     *     {@link HostingRedirector }
     *     
     */
    public HostingRedirector getHostingRedirector() {
        return hostingRedirector;
    }

    /**
     * Define el valor de la propiedad hostingRedirector.
     * 
     * @param value
     *     allowed object is
     *     {@link HostingRedirector }
     *     
     */
    public void setHostingRedirector(HostingRedirector value) {
        this.hostingRedirector = value;
    }

    /**
     * Obtiene el valor de la propiedad tModelInstanceDetails.
     * 
     * @return
     *     possible object is
     *     {@link TModelInstanceDetails }
     *     
     */
    public TModelInstanceDetails getTModelInstanceDetails() {
        return tModelInstanceDetails;
    }

    /**
     * Define el valor de la propiedad tModelInstanceDetails.
     * 
     * @param value
     *     allowed object is
     *     {@link TModelInstanceDetails }
     *     
     */
    public void setTModelInstanceDetails(TModelInstanceDetails value) {
        this.tModelInstanceDetails = value;
    }

    /**
     * Obtiene el valor de la propiedad categoryBag.
     * 
     * @return
     *     possible object is
     *     {@link CategoryBag }
     *     
     */
    public CategoryBag getCategoryBag() {
        return categoryBag;
    }

    /**
     * Define el valor de la propiedad categoryBag.
     * 
     * @param value
     *     allowed object is
     *     {@link CategoryBag }
     *     
     */
    public void setCategoryBag(CategoryBag value) {
        this.categoryBag = value;
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
     * Obtiene el valor de la propiedad bindingKey.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBindingKey() {
        return bindingKey;
    }

    /**
     * Define el valor de la propiedad bindingKey.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBindingKey(String value) {
        this.bindingKey = value;
    }

    /**
     * Obtiene el valor de la propiedad serviceKey.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getServiceKey() {
        return serviceKey;
    }

    /**
     * Define el valor de la propiedad serviceKey.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setServiceKey(String value) {
        this.serviceKey = value;
    }

}
