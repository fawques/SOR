
package org.uddi.api_v3;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para keyType.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * <p>
 * <pre>
 * &lt;simpleType name="keyType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="businessKey"/>
 *     &lt;enumeration value="tModelKey"/>
 *     &lt;enumeration value="serviceKey"/>
 *     &lt;enumeration value="bindingKey"/>
 *     &lt;enumeration value="subscriptionKey"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "keyType")
@XmlEnum
public enum KeyType {

    @XmlEnumValue("businessKey")
    BUSINESS_KEY("businessKey"),
    @XmlEnumValue("tModelKey")
    T_MODEL_KEY("tModelKey"),
    @XmlEnumValue("serviceKey")
    SERVICE_KEY("serviceKey"),
    @XmlEnumValue("bindingKey")
    BINDING_KEY("bindingKey"),
    @XmlEnumValue("subscriptionKey")
    SUBSCRIPTION_KEY("subscriptionKey");
    private final String value;

    KeyType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static KeyType fromValue(String v) {
        for (KeyType c: KeyType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
