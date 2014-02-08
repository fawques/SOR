
package org.uddi.api_v3;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para operationalInfo complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="operationalInfo">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="created" type="{http://www.w3.org/2001/XMLSchema}anySimpleType" minOccurs="0"/>
 *         &lt;element name="modified" type="{http://www.w3.org/2001/XMLSchema}anySimpleType" minOccurs="0"/>
 *         &lt;element name="modifiedIncludingChildren" type="{http://www.w3.org/2001/XMLSchema}anySimpleType" minOccurs="0"/>
 *         &lt;element name="nodeID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="authorizedName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="entityKey" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "operationalInfo", propOrder = {
    "created",
    "modified",
    "modifiedIncludingChildren",
    "nodeID",
    "authorizedName"
})
public class OperationalInfo {

    @XmlSchemaType(name = "anySimpleType")
    protected Object created;
    @XmlSchemaType(name = "anySimpleType")
    protected Object modified;
    @XmlSchemaType(name = "anySimpleType")
    protected Object modifiedIncludingChildren;
    protected String nodeID;
    protected String authorizedName;
    @XmlAttribute(name = "entityKey", required = true)
    protected String entityKey;

    /**
     * Obtiene el valor de la propiedad created.
     * 
     * @return
     *     possible object is
     *     {@link Object }
     *     
     */
    public Object getCreated() {
        return created;
    }

    /**
     * Define el valor de la propiedad created.
     * 
     * @param value
     *     allowed object is
     *     {@link Object }
     *     
     */
    public void setCreated(Object value) {
        this.created = value;
    }

    /**
     * Obtiene el valor de la propiedad modified.
     * 
     * @return
     *     possible object is
     *     {@link Object }
     *     
     */
    public Object getModified() {
        return modified;
    }

    /**
     * Define el valor de la propiedad modified.
     * 
     * @param value
     *     allowed object is
     *     {@link Object }
     *     
     */
    public void setModified(Object value) {
        this.modified = value;
    }

    /**
     * Obtiene el valor de la propiedad modifiedIncludingChildren.
     * 
     * @return
     *     possible object is
     *     {@link Object }
     *     
     */
    public Object getModifiedIncludingChildren() {
        return modifiedIncludingChildren;
    }

    /**
     * Define el valor de la propiedad modifiedIncludingChildren.
     * 
     * @param value
     *     allowed object is
     *     {@link Object }
     *     
     */
    public void setModifiedIncludingChildren(Object value) {
        this.modifiedIncludingChildren = value;
    }

    /**
     * Obtiene el valor de la propiedad nodeID.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNodeID() {
        return nodeID;
    }

    /**
     * Define el valor de la propiedad nodeID.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNodeID(String value) {
        this.nodeID = value;
    }

    /**
     * Obtiene el valor de la propiedad authorizedName.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAuthorizedName() {
        return authorizedName;
    }

    /**
     * Define el valor de la propiedad authorizedName.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAuthorizedName(String value) {
        this.authorizedName = value;
    }

    /**
     * Obtiene el valor de la propiedad entityKey.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEntityKey() {
        return entityKey;
    }

    /**
     * Define el valor de la propiedad entityKey.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEntityKey(String value) {
        this.entityKey = value;
    }

}
