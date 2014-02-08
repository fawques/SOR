
package org.uddi.repl_v3;

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
 *         &lt;element name="node" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded"/>
 *         &lt;element name="controlledMessage" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded"/>
 *         &lt;element name="edge" maxOccurs="unbounded" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="message" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded"/>
 *                   &lt;element name="messageSender" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="messageReceiver" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="messageReceiverAlternate" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
 *                 &lt;/sequence>
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
    "node",
    "controlledMessage",
    "edge"
})
@XmlRootElement(name = "communicationGraph")
public class CommunicationGraph {

    @XmlElement(required = true)
    protected List<String> node;
    @XmlElement(required = true)
    protected List<String> controlledMessage;
    @XmlElement(nillable = true)
    protected List<CommunicationGraph.Edge> edge;

    /**
     * Gets the value of the node property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the node property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getNode().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getNode() {
        if (node == null) {
            node = new ArrayList<String>();
        }
        return this.node;
    }

    /**
     * Gets the value of the controlledMessage property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the controlledMessage property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getControlledMessage().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getControlledMessage() {
        if (controlledMessage == null) {
            controlledMessage = new ArrayList<String>();
        }
        return this.controlledMessage;
    }

    /**
     * Gets the value of the edge property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the edge property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getEdge().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CommunicationGraph.Edge }
     * 
     * 
     */
    public List<CommunicationGraph.Edge> getEdge() {
        if (edge == null) {
            edge = new ArrayList<CommunicationGraph.Edge>();
        }
        return this.edge;
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
     *         &lt;element name="message" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded"/>
     *         &lt;element name="messageSender" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="messageReceiver" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="messageReceiverAlternate" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
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
        "message",
        "messageSender",
        "messageReceiver",
        "messageReceiverAlternate"
    })
    public static class Edge {

        @XmlElement(required = true)
        protected List<String> message;
        @XmlElement(required = true)
        protected String messageSender;
        @XmlElement(required = true)
        protected String messageReceiver;
        @XmlElement(nillable = true)
        protected List<String> messageReceiverAlternate;

        /**
         * Gets the value of the message property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the message property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getMessage().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link String }
         * 
         * 
         */
        public List<String> getMessage() {
            if (message == null) {
                message = new ArrayList<String>();
            }
            return this.message;
        }

        /**
         * Obtiene el valor de la propiedad messageSender.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getMessageSender() {
            return messageSender;
        }

        /**
         * Define el valor de la propiedad messageSender.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setMessageSender(String value) {
            this.messageSender = value;
        }

        /**
         * Obtiene el valor de la propiedad messageReceiver.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getMessageReceiver() {
            return messageReceiver;
        }

        /**
         * Define el valor de la propiedad messageReceiver.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setMessageReceiver(String value) {
            this.messageReceiver = value;
        }

        /**
         * Gets the value of the messageReceiverAlternate property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the messageReceiverAlternate property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getMessageReceiverAlternate().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link String }
         * 
         * 
         */
        public List<String> getMessageReceiverAlternate() {
            if (messageReceiverAlternate == null) {
                messageReceiverAlternate = new ArrayList<String>();
            }
            return this.messageReceiverAlternate;
        }

    }

}
