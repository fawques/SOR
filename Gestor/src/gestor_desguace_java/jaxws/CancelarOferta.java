
package gestor_desguace_java.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * This class was generated by Apache CXF 3.0.0-milestone1
 * Sun Feb 23 18:55:15 CET 2014
 * Generated source version: 3.0.0-milestone1
 */

@XmlRootElement(name = "cancelarOferta", namespace = "http://gestor_desguace_java/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "cancelarOferta", namespace = "http://gestor_desguace_java/")

public class CancelarOferta {

    @XmlElement(name = "id")
    private java.lang.String id;

    public java.lang.String getId() {
        return this.id;
    }

    public void setId(java.lang.String newId)  {
        this.id = newId;
    }

}

