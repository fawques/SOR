
package org.uddi.repl_v3;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
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
 *         &lt;element name="changeRecord" maxOccurs="unbounded" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="changeID" type="{urn:uddi-org:repl_v3}changeRecordID_type"/>
 *                   &lt;element name="changeRecordNull" type="{http://www.w3.org/2001/XMLSchema}anyType" minOccurs="0"/>
 *                   &lt;element ref="{urn:uddi-org:repl_v3}changeRecordNewData" minOccurs="0"/>
 *                   &lt;element ref="{urn:uddi-org:repl_v3}changeRecordDelete" minOccurs="0"/>
 *                   &lt;element ref="{urn:uddi-org:repl_v3}changeRecordPublisherAssertion" minOccurs="0"/>
 *                   &lt;element ref="{urn:uddi-org:repl_v3}changeRecordHide" minOccurs="0"/>
 *                   &lt;element ref="{urn:uddi-org:repl_v3}changeRecordDeleteAssertion" minOccurs="0"/>
 *                   &lt;element ref="{urn:uddi-org:repl_v3}changeRecordAcknowledgement" minOccurs="0"/>
 *                   &lt;element ref="{urn:uddi-org:repl_v3}changeRecordCorrection" minOccurs="0"/>
 *                   &lt;element ref="{urn:uddi-org:repl_v3}changeRecordNewDataConditional" minOccurs="0"/>
 *                   &lt;element ref="{urn:uddi-org:repl_v3}changeRecordConditionFailed" minOccurs="0"/>
 *                 &lt;/sequence>
 *                 &lt;attribute name="acknowledgementRequested" use="required" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
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
    "changeRecord"
})
@XmlRootElement(name = "changeRecords")
public class ChangeRecords {

    @XmlElement(nillable = true)
    protected List<ChangeRecords.ChangeRecord> changeRecord;

    /**
     * Gets the value of the changeRecord property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the changeRecord property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getChangeRecord().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ChangeRecords.ChangeRecord }
     * 
     * 
     */
    public List<ChangeRecords.ChangeRecord> getChangeRecord() {
        if (changeRecord == null) {
            changeRecord = new ArrayList<ChangeRecords.ChangeRecord>();
        }
        return this.changeRecord;
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
     *         &lt;element name="changeID" type="{urn:uddi-org:repl_v3}changeRecordID_type"/>
     *         &lt;element name="changeRecordNull" type="{http://www.w3.org/2001/XMLSchema}anyType" minOccurs="0"/>
     *         &lt;element ref="{urn:uddi-org:repl_v3}changeRecordNewData" minOccurs="0"/>
     *         &lt;element ref="{urn:uddi-org:repl_v3}changeRecordDelete" minOccurs="0"/>
     *         &lt;element ref="{urn:uddi-org:repl_v3}changeRecordPublisherAssertion" minOccurs="0"/>
     *         &lt;element ref="{urn:uddi-org:repl_v3}changeRecordHide" minOccurs="0"/>
     *         &lt;element ref="{urn:uddi-org:repl_v3}changeRecordDeleteAssertion" minOccurs="0"/>
     *         &lt;element ref="{urn:uddi-org:repl_v3}changeRecordAcknowledgement" minOccurs="0"/>
     *         &lt;element ref="{urn:uddi-org:repl_v3}changeRecordCorrection" minOccurs="0"/>
     *         &lt;element ref="{urn:uddi-org:repl_v3}changeRecordNewDataConditional" minOccurs="0"/>
     *         &lt;element ref="{urn:uddi-org:repl_v3}changeRecordConditionFailed" minOccurs="0"/>
     *       &lt;/sequence>
     *       &lt;attribute name="acknowledgementRequested" use="required" type="{http://www.w3.org/2001/XMLSchema}boolean" />
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "changeID",
        "changeRecordNull",
        "changeRecordNewData",
        "changeRecordDelete",
        "changeRecordPublisherAssertion",
        "changeRecordHide",
        "changeRecordDeleteAssertion",
        "changeRecordAcknowledgement",
        "changeRecordCorrection",
        "changeRecordNewDataConditional",
        "changeRecordConditionFailed"
    })
    public static class ChangeRecord {

        @XmlElement(required = true)
        protected ChangeRecordIDType changeID;
        protected Object changeRecordNull;
        protected ChangeRecordNewData changeRecordNewData;
        protected ChangeRecordDelete changeRecordDelete;
        protected ChangeRecordPublisherAssertion changeRecordPublisherAssertion;
        protected ChangeRecordHide changeRecordHide;
        protected ChangeRecordDeleteAssertion changeRecordDeleteAssertion;
        protected ChangeRecordAcknowledgement changeRecordAcknowledgement;
        protected ChangeRecordCorrection changeRecordCorrection;
        protected ChangeRecordNewDataConditional changeRecordNewDataConditional;
        protected ChangeRecordConditionFailed changeRecordConditionFailed;
        @XmlAttribute(name = "acknowledgementRequested", required = true)
        protected boolean acknowledgementRequested;

        /**
         * Obtiene el valor de la propiedad changeID.
         * 
         * @return
         *     possible object is
         *     {@link ChangeRecordIDType }
         *     
         */
        public ChangeRecordIDType getChangeID() {
            return changeID;
        }

        /**
         * Define el valor de la propiedad changeID.
         * 
         * @param value
         *     allowed object is
         *     {@link ChangeRecordIDType }
         *     
         */
        public void setChangeID(ChangeRecordIDType value) {
            this.changeID = value;
        }

        /**
         * Obtiene el valor de la propiedad changeRecordNull.
         * 
         * @return
         *     possible object is
         *     {@link Object }
         *     
         */
        public Object getChangeRecordNull() {
            return changeRecordNull;
        }

        /**
         * Define el valor de la propiedad changeRecordNull.
         * 
         * @param value
         *     allowed object is
         *     {@link Object }
         *     
         */
        public void setChangeRecordNull(Object value) {
            this.changeRecordNull = value;
        }

        /**
         * Obtiene el valor de la propiedad changeRecordNewData.
         * 
         * @return
         *     possible object is
         *     {@link ChangeRecordNewData }
         *     
         */
        public ChangeRecordNewData getChangeRecordNewData() {
            return changeRecordNewData;
        }

        /**
         * Define el valor de la propiedad changeRecordNewData.
         * 
         * @param value
         *     allowed object is
         *     {@link ChangeRecordNewData }
         *     
         */
        public void setChangeRecordNewData(ChangeRecordNewData value) {
            this.changeRecordNewData = value;
        }

        /**
         * Obtiene el valor de la propiedad changeRecordDelete.
         * 
         * @return
         *     possible object is
         *     {@link ChangeRecordDelete }
         *     
         */
        public ChangeRecordDelete getChangeRecordDelete() {
            return changeRecordDelete;
        }

        /**
         * Define el valor de la propiedad changeRecordDelete.
         * 
         * @param value
         *     allowed object is
         *     {@link ChangeRecordDelete }
         *     
         */
        public void setChangeRecordDelete(ChangeRecordDelete value) {
            this.changeRecordDelete = value;
        }

        /**
         * Obtiene el valor de la propiedad changeRecordPublisherAssertion.
         * 
         * @return
         *     possible object is
         *     {@link ChangeRecordPublisherAssertion }
         *     
         */
        public ChangeRecordPublisherAssertion getChangeRecordPublisherAssertion() {
            return changeRecordPublisherAssertion;
        }

        /**
         * Define el valor de la propiedad changeRecordPublisherAssertion.
         * 
         * @param value
         *     allowed object is
         *     {@link ChangeRecordPublisherAssertion }
         *     
         */
        public void setChangeRecordPublisherAssertion(ChangeRecordPublisherAssertion value) {
            this.changeRecordPublisherAssertion = value;
        }

        /**
         * Obtiene el valor de la propiedad changeRecordHide.
         * 
         * @return
         *     possible object is
         *     {@link ChangeRecordHide }
         *     
         */
        public ChangeRecordHide getChangeRecordHide() {
            return changeRecordHide;
        }

        /**
         * Define el valor de la propiedad changeRecordHide.
         * 
         * @param value
         *     allowed object is
         *     {@link ChangeRecordHide }
         *     
         */
        public void setChangeRecordHide(ChangeRecordHide value) {
            this.changeRecordHide = value;
        }

        /**
         * Obtiene el valor de la propiedad changeRecordDeleteAssertion.
         * 
         * @return
         *     possible object is
         *     {@link ChangeRecordDeleteAssertion }
         *     
         */
        public ChangeRecordDeleteAssertion getChangeRecordDeleteAssertion() {
            return changeRecordDeleteAssertion;
        }

        /**
         * Define el valor de la propiedad changeRecordDeleteAssertion.
         * 
         * @param value
         *     allowed object is
         *     {@link ChangeRecordDeleteAssertion }
         *     
         */
        public void setChangeRecordDeleteAssertion(ChangeRecordDeleteAssertion value) {
            this.changeRecordDeleteAssertion = value;
        }

        /**
         * Obtiene el valor de la propiedad changeRecordAcknowledgement.
         * 
         * @return
         *     possible object is
         *     {@link ChangeRecordAcknowledgement }
         *     
         */
        public ChangeRecordAcknowledgement getChangeRecordAcknowledgement() {
            return changeRecordAcknowledgement;
        }

        /**
         * Define el valor de la propiedad changeRecordAcknowledgement.
         * 
         * @param value
         *     allowed object is
         *     {@link ChangeRecordAcknowledgement }
         *     
         */
        public void setChangeRecordAcknowledgement(ChangeRecordAcknowledgement value) {
            this.changeRecordAcknowledgement = value;
        }

        /**
         * Obtiene el valor de la propiedad changeRecordCorrection.
         * 
         * @return
         *     possible object is
         *     {@link ChangeRecordCorrection }
         *     
         */
        public ChangeRecordCorrection getChangeRecordCorrection() {
            return changeRecordCorrection;
        }

        /**
         * Define el valor de la propiedad changeRecordCorrection.
         * 
         * @param value
         *     allowed object is
         *     {@link ChangeRecordCorrection }
         *     
         */
        public void setChangeRecordCorrection(ChangeRecordCorrection value) {
            this.changeRecordCorrection = value;
        }

        /**
         * Obtiene el valor de la propiedad changeRecordNewDataConditional.
         * 
         * @return
         *     possible object is
         *     {@link ChangeRecordNewDataConditional }
         *     
         */
        public ChangeRecordNewDataConditional getChangeRecordNewDataConditional() {
            return changeRecordNewDataConditional;
        }

        /**
         * Define el valor de la propiedad changeRecordNewDataConditional.
         * 
         * @param value
         *     allowed object is
         *     {@link ChangeRecordNewDataConditional }
         *     
         */
        public void setChangeRecordNewDataConditional(ChangeRecordNewDataConditional value) {
            this.changeRecordNewDataConditional = value;
        }

        /**
         * Obtiene el valor de la propiedad changeRecordConditionFailed.
         * 
         * @return
         *     possible object is
         *     {@link ChangeRecordConditionFailed }
         *     
         */
        public ChangeRecordConditionFailed getChangeRecordConditionFailed() {
            return changeRecordConditionFailed;
        }

        /**
         * Define el valor de la propiedad changeRecordConditionFailed.
         * 
         * @param value
         *     allowed object is
         *     {@link ChangeRecordConditionFailed }
         *     
         */
        public void setChangeRecordConditionFailed(ChangeRecordConditionFailed value) {
            this.changeRecordConditionFailed = value;
        }

        /**
         * Obtiene el valor de la propiedad acknowledgementRequested.
         * 
         */
        public boolean isAcknowledgementRequested() {
            return acknowledgementRequested;
        }

        /**
         * Define el valor de la propiedad acknowledgementRequested.
         * 
         */
        public void setAcknowledgementRequested(boolean value) {
            this.acknowledgementRequested = value;
        }

    }

}
