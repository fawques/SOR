
package org.uddi.repl_v3;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import org.uddi.api_v3.BindingTemplate;
import org.uddi.api_v3.BusinessEntity;
import org.uddi.api_v3.BusinessService;
import org.uddi.api_v3.OperationalInfo;
import org.uddi.api_v3.TModel;


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
 *         &lt;element ref="{urn:uddi-org:api_v3}businessEntity" minOccurs="0"/>
 *         &lt;element ref="{urn:uddi-org:api_v3}businessService" minOccurs="0"/>
 *         &lt;element ref="{urn:uddi-org:api_v3}bindingTemplate" minOccurs="0"/>
 *         &lt;element ref="{urn:uddi-org:api_v3}tModel" minOccurs="0"/>
 *         &lt;element name="operationalInfo" type="{urn:uddi-org:api_v3}operationalInfo"/>
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
    "businessEntity",
    "businessService",
    "bindingTemplate",
    "tModel",
    "operationalInfo"
})
@XmlRootElement(name = "changeRecordNewData")
public class ChangeRecordNewData {

    @XmlElement(namespace = "urn:uddi-org:api_v3")
    protected BusinessEntity businessEntity;
    @XmlElement(namespace = "urn:uddi-org:api_v3")
    protected BusinessService businessService;
    @XmlElement(namespace = "urn:uddi-org:api_v3")
    protected BindingTemplate bindingTemplate;
    @XmlElement(namespace = "urn:uddi-org:api_v3")
    protected TModel tModel;
    @XmlElement(required = true)
    protected OperationalInfo operationalInfo;

    /**
     * Obtiene el valor de la propiedad businessEntity.
     * 
     * @return
     *     possible object is
     *     {@link BusinessEntity }
     *     
     */
    public BusinessEntity getBusinessEntity() {
        return businessEntity;
    }

    /**
     * Define el valor de la propiedad businessEntity.
     * 
     * @param value
     *     allowed object is
     *     {@link BusinessEntity }
     *     
     */
    public void setBusinessEntity(BusinessEntity value) {
        this.businessEntity = value;
    }

    /**
     * Obtiene el valor de la propiedad businessService.
     * 
     * @return
     *     possible object is
     *     {@link BusinessService }
     *     
     */
    public BusinessService getBusinessService() {
        return businessService;
    }

    /**
     * Define el valor de la propiedad businessService.
     * 
     * @param value
     *     allowed object is
     *     {@link BusinessService }
     *     
     */
    public void setBusinessService(BusinessService value) {
        this.businessService = value;
    }

    /**
     * Obtiene el valor de la propiedad bindingTemplate.
     * 
     * @return
     *     possible object is
     *     {@link BindingTemplate }
     *     
     */
    public BindingTemplate getBindingTemplate() {
        return bindingTemplate;
    }

    /**
     * Define el valor de la propiedad bindingTemplate.
     * 
     * @param value
     *     allowed object is
     *     {@link BindingTemplate }
     *     
     */
    public void setBindingTemplate(BindingTemplate value) {
        this.bindingTemplate = value;
    }

    /**
     * Obtiene el valor de la propiedad tModel.
     * 
     * @return
     *     possible object is
     *     {@link TModel }
     *     
     */
    public TModel getTModel() {
        return tModel;
    }

    /**
     * Define el valor de la propiedad tModel.
     * 
     * @param value
     *     allowed object is
     *     {@link TModel }
     *     
     */
    public void setTModel(TModel value) {
        this.tModel = value;
    }

    /**
     * Obtiene el valor de la propiedad operationalInfo.
     * 
     * @return
     *     possible object is
     *     {@link OperationalInfo }
     *     
     */
    public OperationalInfo getOperationalInfo() {
        return operationalInfo;
    }

    /**
     * Define el valor de la propiedad operationalInfo.
     * 
     * @param value
     *     allowed object is
     *     {@link OperationalInfo }
     *     
     */
    public void setOperationalInfo(OperationalInfo value) {
        this.operationalInfo = value;
    }

}
