
package gestor_desguace_java.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * This class was generated by Apache CXF 3.0.0-milestone1
 * Mon Apr 14 10:17:35 CEST 2014
 * Generated source version: 3.0.0-milestone1
 */

@XmlRootElement(name = "getPedidosporID", namespace = "http://gestor_desguace_java/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getPedidosporID", namespace = "http://gestor_desguace_java/", propOrder = {"string", "password"})

public class GetPedidosporID {

    @XmlElement(name = "string")
    private java.lang.String string;
    @XmlElement(name = "password")
    private java.lang.String password;

    public java.lang.String getString() {
        return this.string;
    }

    public void setString(java.lang.String newString)  {
        this.string = newString;
    }

    public java.lang.String getPassword() {
        return this.password;
    }

    public void setPassword(java.lang.String newPassword)  {
        this.password = newPassword;
    }

}

