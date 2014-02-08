
package org.uddi.api_v3;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para instanceDetails complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="instanceDetails">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="description" type="{urn:uddi-org:api_v3}description" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="overviewDoc" type="{urn:uddi-org:api_v3}overviewDoc" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="instanceParms" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "instanceDetails", propOrder = {
    "description",
    "overviewDoc",
    "instanceParms"
})
public class InstanceDetails {

    protected List<Description> description;
    protected List<OverviewDoc> overviewDoc;
    protected String instanceParms;

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
     * Gets the value of the overviewDoc property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the overviewDoc property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getOverviewDoc().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link OverviewDoc }
     * 
     * 
     */
    public List<OverviewDoc> getOverviewDoc() {
        if (overviewDoc == null) {
            overviewDoc = new ArrayList<OverviewDoc>();
        }
        return this.overviewDoc;
    }

    /**
     * Obtiene el valor de la propiedad instanceParms.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getInstanceParms() {
        return instanceParms;
    }

    /**
     * Define el valor de la propiedad instanceParms.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setInstanceParms(String value) {
        this.instanceParms = value;
    }

}
