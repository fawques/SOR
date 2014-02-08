
package org.uddi.sub_v3;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para keyBag complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="keyBag">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="deleted" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element ref="{urn:uddi-org:api_v3}tModelKey" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element ref="{urn:uddi-org:api_v3}businessKey" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element ref="{urn:uddi-org:api_v3}serviceKey" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element ref="{urn:uddi-org:api_v3}bindingKey" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "keyBag", propOrder = {
    "deleted",
    "tModelKey",
    "businessKey",
    "serviceKey",
    "bindingKey"
})
public class KeyBag {

    protected boolean deleted;
    @XmlElement(namespace = "urn:uddi-org:api_v3")
    protected List<String> tModelKey;
    @XmlElement(namespace = "urn:uddi-org:api_v3")
    protected List<String> businessKey;
    @XmlElement(namespace = "urn:uddi-org:api_v3")
    protected List<String> serviceKey;
    @XmlElement(namespace = "urn:uddi-org:api_v3")
    protected List<String> bindingKey;

    /**
     * Obtiene el valor de la propiedad deleted.
     * 
     */
    public boolean isDeleted() {
        return deleted;
    }

    /**
     * Define el valor de la propiedad deleted.
     * 
     */
    public void setDeleted(boolean value) {
        this.deleted = value;
    }

    /**
     * Gets the value of the tModelKey property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the tModelKey property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getTModelKey().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getTModelKey() {
        if (tModelKey == null) {
            tModelKey = new ArrayList<String>();
        }
        return this.tModelKey;
    }

    /**
     * Gets the value of the businessKey property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the businessKey property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getBusinessKey().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getBusinessKey() {
        if (businessKey == null) {
            businessKey = new ArrayList<String>();
        }
        return this.businessKey;
    }

    /**
     * Gets the value of the serviceKey property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the serviceKey property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getServiceKey().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getServiceKey() {
        if (serviceKey == null) {
            serviceKey = new ArrayList<String>();
        }
        return this.serviceKey;
    }

    /**
     * Gets the value of the bindingKey property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the bindingKey property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getBindingKey().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getBindingKey() {
        if (bindingKey == null) {
            bindingKey = new ArrayList<String>();
        }
        return this.bindingKey;
    }

}
