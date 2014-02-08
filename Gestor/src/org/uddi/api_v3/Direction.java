
package org.uddi.api_v3;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para direction.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * <p>
 * <pre>
 * &lt;simpleType name="direction">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="fromKey"/>
 *     &lt;enumeration value="toKey"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "direction")
@XmlEnum
public enum Direction {

    @XmlEnumValue("fromKey")
    FROM_KEY("fromKey"),
    @XmlEnumValue("toKey")
    TO_KEY("toKey");
    private final String value;

    Direction(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static Direction fromValue(String v) {
        for (Direction c: Direction.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
