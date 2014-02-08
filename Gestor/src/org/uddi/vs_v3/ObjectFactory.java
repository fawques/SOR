
package org.uddi.vs_v3;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the org.uddi.vs_v3 package. 
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

    private final static QName _ValidateValues_QNAME = new QName("urn:uddi-org:vs_v3", "validate_values");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: org.uddi.vs_v3
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link ValidateValues }
     * 
     */
    public ValidateValues createValidateValues() {
        return new ValidateValues();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ValidateValues }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:uddi-org:vs_v3", name = "validate_values")
    public JAXBElement<ValidateValues> createValidateValues(ValidateValues value) {
        return new JAXBElement<ValidateValues>(_ValidateValues_QNAME, ValidateValues.class, null, value);
    }

}
