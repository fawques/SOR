
package org.uddi.api_v3;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para serviceList complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="serviceList">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="listDescription" type="{urn:uddi-org:api_v3}listDescription" minOccurs="0"/>
 *         &lt;element name="serviceInfos" type="{urn:uddi-org:api_v3}serviceInfos" minOccurs="0"/>
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
@XmlType(name = "serviceList", propOrder = {
    "listDescription",
    "serviceInfos"
})
public class ServiceList {

    protected ListDescription listDescription;
    protected ServiceInfos serviceInfos;
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
     * Obtiene el valor de la propiedad serviceInfos.
     * 
     * @return
     *     possible object is
     *     {@link ServiceInfos }
     *     
     */
    public ServiceInfos getServiceInfos() {
        return serviceInfos;
    }

    /**
     * Define el valor de la propiedad serviceInfos.
     * 
     * @param value
     *     allowed object is
     *     {@link ServiceInfos }
     *     
     */
    public void setServiceInfos(ServiceInfos value) {
        this.serviceInfos = value;
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
