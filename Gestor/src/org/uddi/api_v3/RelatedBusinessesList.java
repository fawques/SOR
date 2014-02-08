
package org.uddi.api_v3;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para relatedBusinessesList complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="relatedBusinessesList">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="listDescription" type="{urn:uddi-org:api_v3}listDescription" minOccurs="0"/>
 *         &lt;element name="businessKey" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="relatedBusinessInfos" type="{urn:uddi-org:api_v3}relatedBusinessInfos" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="truncated" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "relatedBusinessesList", propOrder = {
    "listDescription",
    "businessKey",
    "relatedBusinessInfos"
})
public class RelatedBusinessesList {

    protected ListDescription listDescription;
    @XmlElement(required = true)
    protected String businessKey;
    protected RelatedBusinessInfos relatedBusinessInfos;
    @XmlAttribute(name = "truncated")
    protected Boolean truncated;

    /**
     * Obtiene el valor de la propiedad listDescription.
     * 
     * @return
     *     possible object is
     *     {@link ListDescription }
     *     
     */
    public ListDescription getListDescription() {
        return listDescription;
    }

    /**
     * Define el valor de la propiedad listDescription.
     * 
     * @param value
     *     allowed object is
     *     {@link ListDescription }
     *     
     */
    public void setListDescription(ListDescription value) {
        this.listDescription = value;
    }

    /**
     * Obtiene el valor de la propiedad businessKey.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBusinessKey() {
        return businessKey;
    }

    /**
     * Define el valor de la propiedad businessKey.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBusinessKey(String value) {
        this.businessKey = value;
    }

    /**
     * Obtiene el valor de la propiedad relatedBusinessInfos.
     * 
     * @return
     *     possible object is
     *     {@link RelatedBusinessInfos }
     *     
     */
    public RelatedBusinessInfos getRelatedBusinessInfos() {
        return relatedBusinessInfos;
    }

    /**
     * Define el valor de la propiedad relatedBusinessInfos.
     * 
     * @param value
     *     allowed object is
     *     {@link RelatedBusinessInfos }
     *     
     */
    public void setRelatedBusinessInfos(RelatedBusinessInfos value) {
        this.relatedBusinessInfos = value;
    }

    /**
     * Obtiene el valor de la propiedad truncated.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isTruncated() {
        return truncated;
    }

    /**
     * Define el valor de la propiedad truncated.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setTruncated(Boolean value) {
        this.truncated = value;
    }

}
