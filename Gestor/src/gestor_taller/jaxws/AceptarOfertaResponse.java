
package gestor_taller.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * This class was generated by Apache CXF 3.0.0-milestone1
 * Tue Apr 08 17:48:51 CEST 2014
 * Generated source version: 3.0.0-milestone1
 */

@XmlRootElement(name = "aceptarOfertaResponse", namespace = "http://gestor_taller/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "aceptarOfertaResponse", namespace = "http://gestor_taller/")

public class AceptarOfertaResponse {

    @XmlElement(name = "return")
    private java.lang.Boolean _return;

    public java.lang.Boolean getReturn() {
        return this._return;
    }

    public void setReturn(java.lang.Boolean new_return)  {
        this._return = new_return;
    }

}

