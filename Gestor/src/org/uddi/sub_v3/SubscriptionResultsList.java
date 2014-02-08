
package org.uddi.sub_v3;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import org.uddi.api_v3.AssertionStatusReport;
import org.uddi.api_v3.BindingDetail;
import org.uddi.api_v3.BusinessDetail;
import org.uddi.api_v3.BusinessList;
import org.uddi.api_v3.RelatedBusinessesList;
import org.uddi.api_v3.ServiceDetail;
import org.uddi.api_v3.ServiceList;
import org.uddi.api_v3.TModelDetail;
import org.uddi.api_v3.TModelList;


/**
 * <p>Clase Java para subscriptionResultsList complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="subscriptionResultsList">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="chunkToken" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="coveragePeriod" type="{urn:uddi-org:sub_v3}coveragePeriod"/>
 *         &lt;element name="subscription" type="{urn:uddi-org:sub_v3}subscription"/>
 *         &lt;element ref="{urn:uddi-org:api_v3}bindingDetail" minOccurs="0"/>
 *         &lt;element ref="{urn:uddi-org:api_v3}businessDetail" minOccurs="0"/>
 *         &lt;element ref="{urn:uddi-org:api_v3}serviceDetail" minOccurs="0"/>
 *         &lt;element ref="{urn:uddi-org:api_v3}tModelDetail" minOccurs="0"/>
 *         &lt;element ref="{urn:uddi-org:api_v3}businessList" minOccurs="0"/>
 *         &lt;element ref="{urn:uddi-org:api_v3}relatedBusinessesList" minOccurs="0"/>
 *         &lt;element ref="{urn:uddi-org:api_v3}serviceList" minOccurs="0"/>
 *         &lt;element ref="{urn:uddi-org:api_v3}tModelList" minOccurs="0"/>
 *         &lt;element ref="{urn:uddi-org:api_v3}assertionStatusReport" minOccurs="0"/>
 *         &lt;element name="keyBag" type="{urn:uddi-org:sub_v3}keyBag" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="someResultsUnavailable" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "subscriptionResultsList", propOrder = {
    "chunkToken",
    "coveragePeriod",
    "subscription",
    "bindingDetail",
    "businessDetail",
    "serviceDetail",
    "tModelDetail",
    "businessList",
    "relatedBusinessesList",
    "serviceList",
    "tModelList",
    "assertionStatusReport",
    "keyBag"
})
public class SubscriptionResultsList {

    protected String chunkToken;
    @XmlElement(required = true)
    protected CoveragePeriod coveragePeriod;
    @XmlElement(required = true)
    protected Subscription subscription;
    @XmlElement(namespace = "urn:uddi-org:api_v3")
    protected BindingDetail bindingDetail;
    @XmlElement(namespace = "urn:uddi-org:api_v3")
    protected BusinessDetail businessDetail;
    @XmlElement(namespace = "urn:uddi-org:api_v3")
    protected ServiceDetail serviceDetail;
    @XmlElement(namespace = "urn:uddi-org:api_v3")
    protected TModelDetail tModelDetail;
    @XmlElement(namespace = "urn:uddi-org:api_v3")
    protected BusinessList businessList;
    @XmlElement(namespace = "urn:uddi-org:api_v3")
    protected RelatedBusinessesList relatedBusinessesList;
    @XmlElement(namespace = "urn:uddi-org:api_v3")
    protected ServiceList serviceList;
    @XmlElement(namespace = "urn:uddi-org:api_v3")
    protected TModelList tModelList;
    @XmlElement(namespace = "urn:uddi-org:api_v3")
    protected AssertionStatusReport assertionStatusReport;
    @XmlElement(nillable = true)
    protected List<KeyBag> keyBag;
    @XmlAttribute(name = "someResultsUnavailable")
    protected Boolean someResultsUnavailable;

    /**
     * Obtiene el valor de la propiedad chunkToken.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getChunkToken() {
        return chunkToken;
    }

    /**
     * Define el valor de la propiedad chunkToken.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setChunkToken(String value) {
        this.chunkToken = value;
    }

    /**
     * Obtiene el valor de la propiedad coveragePeriod.
     * 
     * @return
     *     possible object is
     *     {@link CoveragePeriod }
     *     
     */
    public CoveragePeriod getCoveragePeriod() {
        return coveragePeriod;
    }

    /**
     * Define el valor de la propiedad coveragePeriod.
     * 
     * @param value
     *     allowed object is
     *     {@link CoveragePeriod }
     *     
     */
    public void setCoveragePeriod(CoveragePeriod value) {
        this.coveragePeriod = value;
    }

    /**
     * Obtiene el valor de la propiedad subscription.
     * 
     * @return
     *     possible object is
     *     {@link Subscription }
     *     
     */
    public Subscription getSubscription() {
        return subscription;
    }

    /**
     * Define el valor de la propiedad subscription.
     * 
     * @param value
     *     allowed object is
     *     {@link Subscription }
     *     
     */
    public void setSubscription(Subscription value) {
        this.subscription = value;
    }

    /**
     * Obtiene el valor de la propiedad bindingDetail.
     * 
     * @return
     *     possible object is
     *     {@link BindingDetail }
     *     
     */
    public BindingDetail getBindingDetail() {
        return bindingDetail;
    }

    /**
     * Define el valor de la propiedad bindingDetail.
     * 
     * @param value
     *     allowed object is
     *     {@link BindingDetail }
     *     
     */
    public void setBindingDetail(BindingDetail value) {
        this.bindingDetail = value;
    }

    /**
     * Obtiene el valor de la propiedad businessDetail.
     * 
     * @return
     *     possible object is
     *     {@link BusinessDetail }
     *     
     */
    public BusinessDetail getBusinessDetail() {
        return businessDetail;
    }

    /**
     * Define el valor de la propiedad businessDetail.
     * 
     * @param value
     *     allowed object is
     *     {@link BusinessDetail }
     *     
     */
    public void setBusinessDetail(BusinessDetail value) {
        this.businessDetail = value;
    }

    /**
     * Obtiene el valor de la propiedad serviceDetail.
     * 
     * @return
     *     possible object is
     *     {@link ServiceDetail }
     *     
     */
    public ServiceDetail getServiceDetail() {
        return serviceDetail;
    }

    /**
     * Define el valor de la propiedad serviceDetail.
     * 
     * @param value
     *     allowed object is
     *     {@link ServiceDetail }
     *     
     */
    public void setServiceDetail(ServiceDetail value) {
        this.serviceDetail = value;
    }

    /**
     * Obtiene el valor de la propiedad tModelDetail.
     * 
     * @return
     *     possible object is
     *     {@link TModelDetail }
     *     
     */
    public TModelDetail getTModelDetail() {
        return tModelDetail;
    }

    /**
     * Define el valor de la propiedad tModelDetail.
     * 
     * @param value
     *     allowed object is
     *     {@link TModelDetail }
     *     
     */
    public void setTModelDetail(TModelDetail value) {
        this.tModelDetail = value;
    }

    /**
     * Obtiene el valor de la propiedad businessList.
     * 
     * @return
     *     possible object is
     *     {@link BusinessList }
     *     
     */
    public BusinessList getBusinessList() {
        return businessList;
    }

    /**
     * Define el valor de la propiedad businessList.
     * 
     * @param value
     *     allowed object is
     *     {@link BusinessList }
     *     
     */
    public void setBusinessList(BusinessList value) {
        this.businessList = value;
    }

    /**
     * Obtiene el valor de la propiedad relatedBusinessesList.
     * 
     * @return
     *     possible object is
     *     {@link RelatedBusinessesList }
     *     
     */
    public RelatedBusinessesList getRelatedBusinessesList() {
        return relatedBusinessesList;
    }

    /**
     * Define el valor de la propiedad relatedBusinessesList.
     * 
     * @param value
     *     allowed object is
     *     {@link RelatedBusinessesList }
     *     
     */
    public void setRelatedBusinessesList(RelatedBusinessesList value) {
        this.relatedBusinessesList = value;
    }

    /**
     * Obtiene el valor de la propiedad serviceList.
     * 
     * @return
     *     possible object is
     *     {@link ServiceList }
     *     
     */
    public ServiceList getServiceList() {
        return serviceList;
    }

    /**
     * Define el valor de la propiedad serviceList.
     * 
     * @param value
     *     allowed object is
     *     {@link ServiceList }
     *     
     */
    public void setServiceList(ServiceList value) {
        this.serviceList = value;
    }

    /**
     * Obtiene el valor de la propiedad tModelList.
     * 
     * @return
     *     possible object is
     *     {@link TModelList }
     *     
     */
    public TModelList getTModelList() {
        return tModelList;
    }

    /**
     * Define el valor de la propiedad tModelList.
     * 
     * @param value
     *     allowed object is
     *     {@link TModelList }
     *     
     */
    public void setTModelList(TModelList value) {
        this.tModelList = value;
    }

    /**
     * Obtiene el valor de la propiedad assertionStatusReport.
     * 
     * @return
     *     possible object is
     *     {@link AssertionStatusReport }
     *     
     */
    public AssertionStatusReport getAssertionStatusReport() {
        return assertionStatusReport;
    }

    /**
     * Define el valor de la propiedad assertionStatusReport.
     * 
     * @param value
     *     allowed object is
     *     {@link AssertionStatusReport }
     *     
     */
    public void setAssertionStatusReport(AssertionStatusReport value) {
        this.assertionStatusReport = value;
    }

    /**
     * Gets the value of the keyBag property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the keyBag property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getKeyBag().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link KeyBag }
     * 
     * 
     */
    public List<KeyBag> getKeyBag() {
        if (keyBag == null) {
            keyBag = new ArrayList<KeyBag>();
        }
        return this.keyBag;
    }

    /**
     * Obtiene el valor de la propiedad someResultsUnavailable.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isSomeResultsUnavailable() {
        return someResultsUnavailable;
    }

    /**
     * Define el valor de la propiedad someResultsUnavailable.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setSomeResultsUnavailable(Boolean value) {
        this.someResultsUnavailable = value;
    }

}
