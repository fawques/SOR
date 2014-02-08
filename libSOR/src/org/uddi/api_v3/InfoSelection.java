
package org.uddi.api_v3;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para infoSelection.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * <p>
 * <pre>
 * &lt;simpleType name="infoSelection">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="all"/>
 *     &lt;enumeration value="hidden"/>
 *     &lt;enumeration value="visible"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "infoSelection")
@XmlEnum
public enum InfoSelection {

    @XmlEnumValue("all")
    ALL("all"),
    @XmlEnumValue("hidden")
    HIDDEN("hidden"),
    @XmlEnumValue("visible")
    VISIBLE("visible");
    private final String value;

    InfoSelection(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static InfoSelection fromValue(String v) {
        for (InfoSelection c: InfoSelection.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
