
package gestor_desguace_java.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * This class was generated by Apache CXF 3.0.0-milestone1
 * Sat Apr 12 11:04:49 CEST 2014
 * Generated source version: 3.0.0-milestone1
 */

@XmlRootElement(name = "generarClaveReto", namespace = "http://gestor_desguace_java/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "generarClaveReto", namespace = "http://gestor_desguace_java/", propOrder = {"idDesguace", "password"})

public class GenerarClaveReto {

    @XmlElement(name = "idDesguace")
    private java.lang.String idDesguace;
    @XmlElement(name = "password")
    private java.lang.String password;

    public java.lang.String getIdDesguace() {
        return this.idDesguace;
    }

    public void setIdDesguace(java.lang.String newIdDesguace)  {
        this.idDesguace = newIdDesguace;
    }

    public java.lang.String getPassword() {
        return this.password;
    }

    public void setPassword(java.lang.String newPassword)  {
        this.password = newPassword;
    }

}
