
package gestor_admin;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para setCifradoSimetrico complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="setCifradoSimetrico">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="on" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "setCifradoSimetrico", propOrder = {
    "on"
})
public class SetCifradoSimetrico {

    protected boolean on;

    /**
     * Obtiene el valor de la propiedad on.
     * 
     */
    public boolean isOn() {
        return on;
    }

    /**
     * Define el valor de la propiedad on.
     * 
     */
    public void setOn(boolean value) {
        this.on = value;
    }

}
