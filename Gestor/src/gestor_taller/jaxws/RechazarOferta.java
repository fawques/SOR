
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

@XmlRootElement(name = "rechazarOferta", namespace = "http://gestor_taller/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "rechazarOferta", namespace = "http://gestor_taller/", propOrder = {"ID", "idTaller", "password"})

public class RechazarOferta {

    @XmlElement(name = "ID")
    private java.lang.String ID;
    @XmlElement(name = "idTaller")
    private java.lang.String idTaller;
    @XmlElement(name = "password")
    private java.lang.String password;

    public java.lang.String getID() {
        return this.ID;
    }

    public void setID(java.lang.String newID)  {
        this.ID = newID;
    }

    public java.lang.String getIdTaller() {
        return this.idTaller;
    }

    public void setIdTaller(java.lang.String newIdTaller)  {
        this.idTaller = newIdTaller;
    }

    public java.lang.String getPassword() {
        return this.password;
    }

    public void setPassword(java.lang.String newPassword)  {
        this.password = newPassword;
    }

}

