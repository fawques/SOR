
package org.uddi.api_v3;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para find_binding complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="find_binding">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="authInfo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="findQualifiers" type="{urn:uddi-org:api_v3}findQualifiers" minOccurs="0"/>
 *         &lt;element name="tModelBag" type="{urn:uddi-org:api_v3}tModelBag" minOccurs="0"/>
 *         &lt;element name="find_tModel" type="{urn:uddi-org:api_v3}find_tModel" minOccurs="0"/>
 *         &lt;element name="categoryBag" type="{urn:uddi-org:api_v3}categoryBag" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="maxRows" type="{http://www.w3.org/2001/XMLSchema}int" />
 *       &lt;attribute name="serviceKey" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="listHead" type="{http://www.w3.org/2001/XMLSchema}int" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "find_binding", propOrder = {
    "authInfo",
    "findQualifiers",
    "tModelBag",
    "findTModel",
    "categoryBag"
})
public class FindBinding {

    protected String authInfo;
    protected FindQualifiers findQualifiers;
    protected TModelBag tModelBag;
    @XmlElement(name = "find_tModel")
    protected FindTModel findTModel;
    protected CategoryBag categoryBag;
    @XmlAttribute(name = "maxRows")
    protected Integer maxRows;
    @XmlAttribute(name = "serviceKey")
    protected String serviceKey;
    @XmlAttribute(name = "listHead")
    protected Integer listHead;

    /**
     * Obtiene el valor de la propiedad authInfo.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAuthInfo() {
        return authInfo;
    }

    /**
     * Define el valor de la propiedad authInfo.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAuthInfo(String value) {
        this.authInfo = value;
    }

    /**
     * Obtiene el valor de la propiedad findQualifiers.
     * 
     * @return
     *     possible object is
     *     {@link FindQualifiers }
     *     
     */
    public FindQualifiers getFindQualifiers() {
        return findQualifiers;
    }

    /**
     * Define el valor de la propiedad findQualifiers.
     * 
     * @param value
     *     allowed object is
     *     {@link FindQualifiers }
     *     
     */
    public void setFindQualifiers(FindQualifiers value) {
        this.findQualifiers = value;
    }

    /**
     * Obtiene el valor de la propiedad tModelBag.
     * 
     * @return
     *     possible object is
     *     {@link TModelBag }
     *     
     */
    public TModelBag getTModelBag() {
        return tModelBag;
    }

    /**
     * Define el valor de la propiedad tModelBag.
     * 
     * @param value
     *     allowed object is
     *     {@link TModelBag }
     *     
     */
    public void setTModelBag(TModelBag value) {
        this.tModelBag = value;
    }

    /**
     * Obtiene el valor de la propiedad findTModel.
     * 
     * @return
     *     possible object is
     *     {@link FindTModel }
     *     
     */
    public FindTModel getFindTModel() {
        return findTModel;
    }

    /**
     * Define el valor de la propiedad findTModel.
     * 
     * @param value
     *     allowed object is
     *     {@link FindTModel }
     *     
     */
    public void setFindTModel(FindTModel value) {
        this.findTModel = value;
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
     * Obtiene el valor de la propiedad maxRows.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getMaxRows() {
        return maxRows;
    }

    /**
     * Define el valor de la propiedad maxRows.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setMaxRows(Integer value) {
        this.maxRows = value;
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

    /**
     * Obtiene el valor de la propiedad listHead.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getListHead() {
        return listHead;
    }

    /**
     * Define el valor de la propiedad listHead.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setListHead(Integer value) {
        this.listHead = value;
    }

}
