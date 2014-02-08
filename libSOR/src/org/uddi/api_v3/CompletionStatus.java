
package org.uddi.api_v3;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para completionStatus.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * <p>
 * <pre>
 * &lt;simpleType name="completionStatus">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="status:complete"/>
 *     &lt;enumeration value="status:fromKey_incomplete"/>
 *     &lt;enumeration value="status:toKey_incomplete"/>
 *     &lt;enumeration value="status:both_incomplete"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "completionStatus")
@XmlEnum
public enum CompletionStatus {

    @XmlEnumValue("status:complete")
    STATUS_COMPLETE("status:complete"),
    @XmlEnumValue("status:fromKey_incomplete")
    STATUS_FROM_KEY_INCOMPLETE("status:fromKey_incomplete"),
    @XmlEnumValue("status:toKey_incomplete")
    STATUS_TO_KEY_INCOMPLETE("status:toKey_incomplete"),
    @XmlEnumValue("status:both_incomplete")
    STATUS_BOTH_INCOMPLETE("status:both_incomplete");
    private final String value;

    CompletionStatus(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static CompletionStatus fromValue(String v) {
        for (CompletionStatus c: CompletionStatus.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
