
package gestor_taller.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * This class was generated by Apache CXF 3.0.0-milestone1
 * Sun Apr 13 11:05:32 CEST 2014
 * Generated source version: 3.0.0-milestone1
 */

@XmlRootElement(name = "cambiarEstadoPedido", namespace = "http://gestor_taller/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "cambiarEstadoPedido", namespace = "http://gestor_taller/", propOrder = {"idTaller", "password", "estado", "id"})

public class CambiarEstadoPedido {

    @XmlElement(name = "idTaller")
    private java.lang.String idTaller;
    @XmlElement(name = "password")
    private java.lang.String password;
    @XmlElement(name = "estado")
    private int estado;
    @XmlElement(name = "id")
    private java.lang.String id;

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

    public int getEstado() {
        return this.estado;
    }

    public void setEstado(int newEstado)  {
        this.estado = newEstado;
    }

    public java.lang.String getId() {
        return this.id;
    }

    public void setId(java.lang.String newId)  {
        this.id = newId;
    }

}

