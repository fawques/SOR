
package gestor_admin.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * This class was generated by Apache CXF 3.0.0-milestone1
 * Sat Apr 12 11:05:05 CEST 2014
 * Generated source version: 3.0.0-milestone1
 */

@XmlRootElement(name = "setCifradoSimetrico", namespace = "http://gestor_admin/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "setCifradoSimetrico", namespace = "http://gestor_admin/")

public class SetCifradoSimetrico {

    @XmlElement(name = "on")
    private boolean on;

    public boolean getOn() {
        return this.on;
    }

    public void setOn(boolean newOn)  {
        this.on = newOn;
    }

}

