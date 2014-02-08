
package org.uddi.repl_v3;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import org.uddi.api_v3.Contact;
import org.w3._2000._09.xmldsig.KeyInfoType;
import org.w3._2000._09.xmldsig.SignatureType;


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
 *         &lt;element name="serialNumber" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="timeOfConfigurationUpdate" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="registryContact">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="contact" type="{urn:uddi-org:api_v3}contact"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="operator" maxOccurs="unbounded" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="operatorNodeID" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="operatorStatus" type="{urn:uddi-org:repl_v3}operatorStatus_type"/>
 *                   &lt;element name="contact" type="{urn:uddi-org:api_v3}contact" maxOccurs="unbounded"/>
 *                   &lt;element name="soapReplicationURL" type="{http://www.w3.org/2001/XMLSchema}anyURI"/>
 *                   &lt;element name="KeyInfo" type="{http://www.w3.org/2000/09/xmldsig#}KeyInfoType" maxOccurs="unbounded" minOccurs="0"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element ref="{urn:uddi-org:repl_v3}communicationGraph" minOccurs="0"/>
 *         &lt;element name="maximumTimeToSyncRegistry" type="{http://www.w3.org/2001/XMLSchema}integer" minOccurs="0"/>
 *         &lt;element name="maximumTimeToGetChanges" type="{http://www.w3.org/2001/XMLSchema}integer"/>
 *         &lt;element name="Signature" type="{http://www.w3.org/2000/09/xmldsig#}SignatureType" maxOccurs="unbounded" minOccurs="0"/>
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
    "serialNumber",
    "timeOfConfigurationUpdate",
    "registryContact",
    "operator",
    "communicationGraph",
    "maximumTimeToSyncRegistry",
    "maximumTimeToGetChanges",
    "signature"
})
@XmlRootElement(name = "replicationConfiguration")
public class ReplicationConfiguration {

    protected long serialNumber;
    @XmlElement(required = true)
    protected String timeOfConfigurationUpdate;
    @XmlElement(required = true)
    protected ReplicationConfiguration.RegistryContact registryContact;
    @XmlElement(nillable = true)
    protected List<ReplicationConfiguration.Operator> operator;
    protected CommunicationGraph communicationGraph;
    protected BigInteger maximumTimeToSyncRegistry;
    @XmlElement(required = true)
    protected BigInteger maximumTimeToGetChanges;
    @XmlElement(name = "Signature")
    protected List<SignatureType> signature;

    /**
     * Obtiene el valor de la propiedad serialNumber.
     * 
     */
    public long getSerialNumber() {
        return serialNumber;
    }

    /**
     * Define el valor de la propiedad serialNumber.
     * 
     */
    public void setSerialNumber(long value) {
        this.serialNumber = value;
    }

    /**
     * Obtiene el valor de la propiedad timeOfConfigurationUpdate.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTimeOfConfigurationUpdate() {
        return timeOfConfigurationUpdate;
    }

    /**
     * Define el valor de la propiedad timeOfConfigurationUpdate.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTimeOfConfigurationUpdate(String value) {
        this.timeOfConfigurationUpdate = value;
    }

    /**
     * Obtiene el valor de la propiedad registryContact.
     * 
     * @return
     *     possible object is
     *     {@link ReplicationConfiguration.RegistryContact }
     *     
     */
    public ReplicationConfiguration.RegistryContact getRegistryContact() {
        return registryContact;
    }

    /**
     * Define el valor de la propiedad registryContact.
     * 
     * @param value
     *     allowed object is
     *     {@link ReplicationConfiguration.RegistryContact }
     *     
     */
    public void setRegistryContact(ReplicationConfiguration.RegistryContact value) {
        this.registryContact = value;
    }

    /**
     * Gets the value of the operator property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the operator property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getOperator().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ReplicationConfiguration.Operator }
     * 
     * 
     */
    public List<ReplicationConfiguration.Operator> getOperator() {
        if (operator == null) {
            operator = new ArrayList<ReplicationConfiguration.Operator>();
        }
        return this.operator;
    }

    /**
     * Obtiene el valor de la propiedad communicationGraph.
     * 
     * @return
     *     possible object is
     *     {@link CommunicationGraph }
     *     
     */
    public CommunicationGraph getCommunicationGraph() {
        return communicationGraph;
    }

    /**
     * Define el valor de la propiedad communicationGraph.
     * 
     * @param value
     *     allowed object is
     *     {@link CommunicationGraph }
     *     
     */
    public void setCommunicationGraph(CommunicationGraph value) {
        this.communicationGraph = value;
    }

    /**
     * Obtiene el valor de la propiedad maximumTimeToSyncRegistry.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getMaximumTimeToSyncRegistry() {
        return maximumTimeToSyncRegistry;
    }

    /**
     * Define el valor de la propiedad maximumTimeToSyncRegistry.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setMaximumTimeToSyncRegistry(BigInteger value) {
        this.maximumTimeToSyncRegistry = value;
    }

    /**
     * Obtiene el valor de la propiedad maximumTimeToGetChanges.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getMaximumTimeToGetChanges() {
        return maximumTimeToGetChanges;
    }

    /**
     * Define el valor de la propiedad maximumTimeToGetChanges.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setMaximumTimeToGetChanges(BigInteger value) {
        this.maximumTimeToGetChanges = value;
    }

    /**
     * Gets the value of the signature property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the signature property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSignature().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link SignatureType }
     * 
     * 
     */
    public List<SignatureType> getSignature() {
        if (signature == null) {
            signature = new ArrayList<SignatureType>();
        }
        return this.signature;
    }


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
     *         &lt;element name="operatorNodeID" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="operatorStatus" type="{urn:uddi-org:repl_v3}operatorStatus_type"/>
     *         &lt;element name="contact" type="{urn:uddi-org:api_v3}contact" maxOccurs="unbounded"/>
     *         &lt;element name="soapReplicationURL" type="{http://www.w3.org/2001/XMLSchema}anyURI"/>
     *         &lt;element name="KeyInfo" type="{http://www.w3.org/2000/09/xmldsig#}KeyInfoType" maxOccurs="unbounded" minOccurs="0"/>
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
        "operatorNodeID",
        "operatorStatus",
        "contact",
        "soapReplicationURL",
        "keyInfo"
    })
    public static class Operator {

        @XmlElement(required = true)
        protected String operatorNodeID;
        @XmlElement(required = true)
        protected OperatorStatusType operatorStatus;
        @XmlElement(required = true)
        protected List<Contact> contact;
        @XmlElement(required = true)
        @XmlSchemaType(name = "anyURI")
        protected String soapReplicationURL;
        @XmlElement(name = "KeyInfo")
        protected List<KeyInfoType> keyInfo;

        /**
         * Obtiene el valor de la propiedad operatorNodeID.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getOperatorNodeID() {
            return operatorNodeID;
        }

        /**
         * Define el valor de la propiedad operatorNodeID.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setOperatorNodeID(String value) {
            this.operatorNodeID = value;
        }

        /**
         * Obtiene el valor de la propiedad operatorStatus.
         * 
         * @return
         *     possible object is
         *     {@link OperatorStatusType }
         *     
         */
        public OperatorStatusType getOperatorStatus() {
            return operatorStatus;
        }

        /**
         * Define el valor de la propiedad operatorStatus.
         * 
         * @param value
         *     allowed object is
         *     {@link OperatorStatusType }
         *     
         */
        public void setOperatorStatus(OperatorStatusType value) {
            this.operatorStatus = value;
        }

        /**
         * Gets the value of the contact property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the contact property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getContact().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link Contact }
         * 
         * 
         */
        public List<Contact> getContact() {
            if (contact == null) {
                contact = new ArrayList<Contact>();
            }
            return this.contact;
        }

        /**
         * Obtiene el valor de la propiedad soapReplicationURL.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getSoapReplicationURL() {
            return soapReplicationURL;
        }

        /**
         * Define el valor de la propiedad soapReplicationURL.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setSoapReplicationURL(String value) {
            this.soapReplicationURL = value;
        }

        /**
         * Gets the value of the keyInfo property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the keyInfo property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getKeyInfo().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link KeyInfoType }
         * 
         * 
         */
        public List<KeyInfoType> getKeyInfo() {
            if (keyInfo == null) {
                keyInfo = new ArrayList<KeyInfoType>();
            }
            return this.keyInfo;
        }

    }


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
     *         &lt;element name="contact" type="{urn:uddi-org:api_v3}contact"/>
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
        "contact"
    })
    public static class RegistryContact {

        @XmlElement(required = true)
        protected Contact contact;

        /**
         * Obtiene el valor de la propiedad contact.
         * 
         * @return
         *     possible object is
         *     {@link Contact }
         *     
         */
        public Contact getContact() {
            return contact;
        }

        /**
         * Define el valor de la propiedad contact.
         * 
         * @param value
         *     allowed object is
         *     {@link Contact }
         *     
         */
        public void setContact(Contact value) {
            this.contact = value;
        }

    }

}
