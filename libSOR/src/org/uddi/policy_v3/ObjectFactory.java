
package org.uddi.policy_v3;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the org.uddi.policy_v3 package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _PolicyName_QNAME = new QName("urn:uddi-org:policy_v3", "policyName");
    private final static QName _PolicyDescription_QNAME = new QName("urn:uddi-org:policy_v3", "policyDescription");
    private final static QName _PolicyDecisionPoint_QNAME = new QName("urn:uddi-org:policy_v3", "policyDecisionPoint");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: org.uddi.policy_v3
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Policies }
     * 
     */
    public Policies createPolicies() {
        return new Policies();
    }

    /**
     * Create an instance of {@link PolicyDescriptionType }
     * 
     */
    public PolicyDescriptionType createPolicyDescriptionType() {
        return new PolicyDescriptionType();
    }

    /**
     * Create an instance of {@link org.uddi.policy_v3.Policy }
     * 
     */
    public org.uddi.policy_v3.Policy createPolicy() {
        return new org.uddi.policy_v3.Policy();
    }

    /**
     * Create an instance of {@link Policies.Policy }
     * 
     */
    public Policies.Policy createPoliciesPolicy() {
        return new Policies.Policy();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:uddi-org:policy_v3", name = "policyName")
    public JAXBElement<String> createPolicyName(String value) {
        return new JAXBElement<String>(_PolicyName_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PolicyDescriptionType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:uddi-org:policy_v3", name = "policyDescription")
    public JAXBElement<PolicyDescriptionType> createPolicyDescription(PolicyDescriptionType value) {
        return new JAXBElement<PolicyDescriptionType>(_PolicyDescription_QNAME, PolicyDescriptionType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:uddi-org:policy_v3", name = "policyDecisionPoint")
    public JAXBElement<String> createPolicyDecisionPoint(String value) {
        return new JAXBElement<String>(_PolicyDecisionPoint_QNAME, String.class, null, value);
    }

}
