
package org.uddi.policy_v3_instanceparms;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para authInfoUse_type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * <p>
 * <pre>
 * &lt;simpleType name="authInfoUse_type">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="required"/>
 *     &lt;enumeration value="optional"/>
 *     &lt;enumeration value="ignored"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "authInfoUse_type")
@XmlEnum
public enum AuthInfoUseType {

    @XmlEnumValue("required")
    REQUIRED("required"),
    @XmlEnumValue("optional")
    OPTIONAL("optional"),
    @XmlEnumValue("ignored")
    IGNORED("ignored");
    private final String value;

    AuthInfoUseType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static AuthInfoUseType fromValue(String v) {
        for (AuthInfoUseType c: AuthInfoUseType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
