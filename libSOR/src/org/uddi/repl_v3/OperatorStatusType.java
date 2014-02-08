
package org.uddi.repl_v3;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para operatorStatus_type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * <p>
 * <pre>
 * &lt;simpleType name="operatorStatus_type">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="new"/>
 *     &lt;enumeration value="normal"/>
 *     &lt;enumeration value="resigned"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "operatorStatus_type")
@XmlEnum
public enum OperatorStatusType {

    @XmlEnumValue("new")
    NEW("new"),
    @XmlEnumValue("normal")
    NORMAL("normal"),
    @XmlEnumValue("resigned")
    RESIGNED("resigned");
    private final String value;

    OperatorStatusType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static OperatorStatusType fromValue(String v) {
        for (OperatorStatusType c: OperatorStatusType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
