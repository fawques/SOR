
package org.uddi.sub_v3;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import org.uddi.api_v3.FindBinding;
import org.uddi.api_v3.FindBusiness;
import org.uddi.api_v3.FindRelatedBusinesses;
import org.uddi.api_v3.FindService;
import org.uddi.api_v3.FindTModel;
import org.uddi.api_v3.GetAssertionStatusReport;
import org.uddi.api_v3.GetBindingDetail;
import org.uddi.api_v3.GetBusinessDetail;
import org.uddi.api_v3.GetServiceDetail;
import org.uddi.api_v3.GetTModelDetail;


/**
 * <p>Clase Java para subscriptionFilter complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="subscriptionFilter">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{urn:uddi-org:api_v3}find_binding" minOccurs="0"/>
 *         &lt;element ref="{urn:uddi-org:api_v3}find_business" minOccurs="0"/>
 *         &lt;element ref="{urn:uddi-org:api_v3}find_relatedBusinesses" minOccurs="0"/>
 *         &lt;element ref="{urn:uddi-org:api_v3}find_service" minOccurs="0"/>
 *         &lt;element ref="{urn:uddi-org:api_v3}find_tModel" minOccurs="0"/>
 *         &lt;element ref="{urn:uddi-org:api_v3}get_bindingDetail" minOccurs="0"/>
 *         &lt;element ref="{urn:uddi-org:api_v3}get_businessDetail" minOccurs="0"/>
 *         &lt;element ref="{urn:uddi-org:api_v3}get_serviceDetail" minOccurs="0"/>
 *         &lt;element ref="{urn:uddi-org:api_v3}get_tModelDetail" minOccurs="0"/>
 *         &lt;element ref="{urn:uddi-org:api_v3}get_assertionStatusReport" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "subscriptionFilter", propOrder = {
    "findBinding",
    "findBusiness",
    "findRelatedBusinesses",
    "findService",
    "findTModel",
    "getBindingDetail",
    "getBusinessDetail",
    "getServiceDetail",
    "getTModelDetail",
    "getAssertionStatusReport"
})
public class SubscriptionFilter {

    @XmlElement(name = "find_binding", namespace = "urn:uddi-org:api_v3")
    protected FindBinding findBinding;
    @XmlElement(name = "find_business", namespace = "urn:uddi-org:api_v3")
    protected FindBusiness findBusiness;
    @XmlElement(name = "find_relatedBusinesses", namespace = "urn:uddi-org:api_v3")
    protected FindRelatedBusinesses findRelatedBusinesses;
    @XmlElement(name = "find_service", namespace = "urn:uddi-org:api_v3")
    protected FindService findService;
    @XmlElement(name = "find_tModel", namespace = "urn:uddi-org:api_v3")
    protected FindTModel findTModel;
    @XmlElement(name = "get_bindingDetail", namespace = "urn:uddi-org:api_v3")
    protected GetBindingDetail getBindingDetail;
    @XmlElement(name = "get_businessDetail", namespace = "urn:uddi-org:api_v3")
    protected GetBusinessDetail getBusinessDetail;
    @XmlElement(name = "get_serviceDetail", namespace = "urn:uddi-org:api_v3")
    protected GetServiceDetail getServiceDetail;
    @XmlElement(name = "get_tModelDetail", namespace = "urn:uddi-org:api_v3")
    protected GetTModelDetail getTModelDetail;
    @XmlElement(name = "get_assertionStatusReport", namespace = "urn:uddi-org:api_v3")
    protected GetAssertionStatusReport getAssertionStatusReport;

    /**
     * Obtiene el valor de la propiedad findBinding.
     * 
     * @return
     *     possible object is
     *     {@link FindBinding }
     *     
     */
    public FindBinding getFindBinding() {
        return findBinding;
    }

    /**
     * Define el valor de la propiedad findBinding.
     * 
     * @param value
     *     allowed object is
     *     {@link FindBinding }
     *     
     */
    public void setFindBinding(FindBinding value) {
        this.findBinding = value;
    }

    /**
     * Obtiene el valor de la propiedad findBusiness.
     * 
     * @return
     *     possible object is
     *     {@link FindBusiness }
     *     
     */
    public FindBusiness getFindBusiness() {
        return findBusiness;
    }

    /**
     * Define el valor de la propiedad findBusiness.
     * 
     * @param value
     *     allowed object is
     *     {@link FindBusiness }
     *     
     */
    public void setFindBusiness(FindBusiness value) {
        this.findBusiness = value;
    }

    /**
     * Obtiene el valor de la propiedad findRelatedBusinesses.
     * 
     * @return
     *     possible object is
     *     {@link FindRelatedBusinesses }
     *     
     */
    public FindRelatedBusinesses getFindRelatedBusinesses() {
        return findRelatedBusinesses;
    }

    /**
     * Define el valor de la propiedad findRelatedBusinesses.
     * 
     * @param value
     *     allowed object is
     *     {@link FindRelatedBusinesses }
     *     
     */
    public void setFindRelatedBusinesses(FindRelatedBusinesses value) {
        this.findRelatedBusinesses = value;
    }

    /**
     * Obtiene el valor de la propiedad findService.
     * 
     * @return
     *     possible object is
     *     {@link FindService }
     *     
     */
    public FindService getFindService() {
        return findService;
    }

    /**
     * Define el valor de la propiedad findService.
     * 
     * @param value
     *     allowed object is
     *     {@link FindService }
     *     
     */
    public void setFindService(FindService value) {
        this.findService = value;
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
     * Obtiene el valor de la propiedad getBindingDetail.
     * 
     * @return
     *     possible object is
     *     {@link GetBindingDetail }
     *     
     */
    public GetBindingDetail getGetBindingDetail() {
        return getBindingDetail;
    }

    /**
     * Define el valor de la propiedad getBindingDetail.
     * 
     * @param value
     *     allowed object is
     *     {@link GetBindingDetail }
     *     
     */
    public void setGetBindingDetail(GetBindingDetail value) {
        this.getBindingDetail = value;
    }

    /**
     * Obtiene el valor de la propiedad getBusinessDetail.
     * 
     * @return
     *     possible object is
     *     {@link GetBusinessDetail }
     *     
     */
    public GetBusinessDetail getGetBusinessDetail() {
        return getBusinessDetail;
    }

    /**
     * Define el valor de la propiedad getBusinessDetail.
     * 
     * @param value
     *     allowed object is
     *     {@link GetBusinessDetail }
     *     
     */
    public void setGetBusinessDetail(GetBusinessDetail value) {
        this.getBusinessDetail = value;
    }

    /**
     * Obtiene el valor de la propiedad getServiceDetail.
     * 
     * @return
     *     possible object is
     *     {@link GetServiceDetail }
     *     
     */
    public GetServiceDetail getGetServiceDetail() {
        return getServiceDetail;
    }

    /**
     * Define el valor de la propiedad getServiceDetail.
     * 
     * @param value
     *     allowed object is
     *     {@link GetServiceDetail }
     *     
     */
    public void setGetServiceDetail(GetServiceDetail value) {
        this.getServiceDetail = value;
    }

    /**
     * Obtiene el valor de la propiedad getTModelDetail.
     * 
     * @return
     *     possible object is
     *     {@link GetTModelDetail }
     *     
     */
    public GetTModelDetail getGetTModelDetail() {
        return getTModelDetail;
    }

    /**
     * Define el valor de la propiedad getTModelDetail.
     * 
     * @param value
     *     allowed object is
     *     {@link GetTModelDetail }
     *     
     */
    public void setGetTModelDetail(GetTModelDetail value) {
        this.getTModelDetail = value;
    }

    /**
     * Obtiene el valor de la propiedad getAssertionStatusReport.
     * 
     * @return
     *     possible object is
     *     {@link GetAssertionStatusReport }
     *     
     */
    public GetAssertionStatusReport getGetAssertionStatusReport() {
        return getAssertionStatusReport;
    }

    /**
     * Define el valor de la propiedad getAssertionStatusReport.
     * 
     * @param value
     *     allowed object is
     *     {@link GetAssertionStatusReport }
     *     
     */
    public void setGetAssertionStatusReport(GetAssertionStatusReport value) {
        this.getAssertionStatusReport = value;
    }

}
