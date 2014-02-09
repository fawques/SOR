
package org.uddi.policy_v3;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


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
 *         &lt;element name="policyName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="policyDescription" type="{urn:uddi-org:policy_v3}policyDescription_type" maxOccurs="unbounded"/>
 *         &lt;element name="policyDecisionPoint" type="{http://www.w3.org/2001/XMLSchema}string"/>
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
    "policyName",
    "policyDescription",
    "policyDecisionPoint"
})
@XmlRootElement(name = "policy")
public class Policy {

    @XmlElement(required = true)
    protected String policyName;
    @XmlElement(required = true)
    protected List<PolicyDescriptionType> policyDescription;
    @XmlElement(required = true)
    protected String policyDecisionPoint;

    /**
     * Obtiene el valor de la propiedad policyName.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPolicyName() {
        return policyName;
    }

    /**
     * Define el valor de la propiedad policyName.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPolicyName(String value) {
        this.policyName = value;
    }

    /**
     * Gets the value of the policyDescription property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the policyDescription property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPolicyDescription().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link PolicyDescriptionType }
     * 
     * 
     */
    public List<PolicyDescriptionType> getPolicyDescription() {
        if (policyDescription == null) {
            policyDescription = new ArrayList<PolicyDescriptionType>();
        }
        return this.policyDescription;
    }

    /**
     * Obtiene el valor de la propiedad policyDecisionPoint.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPolicyDecisionPoint() {
        return policyDecisionPoint;
    }

    /**
     * Define el valor de la propiedad policyDecisionPoint.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPolicyDecisionPoint(String value) {
        this.policyDecisionPoint = value;
    }

}
