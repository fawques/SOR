
package gestor_desguace_java.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * This class was generated by Apache CXF 3.0.0-milestone1
 * Sun Feb 09 19:59:12 CET 2014
 * Generated source version: 3.0.0-milestone1
 */

@XmlRootElement(name = "cambiarEstadoPedido", namespace = "http://gestor_desguace_java/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "cambiarEstadoPedido", namespace = "http://gestor_desguace_java/", propOrder = {"id", "estado"})

public class CambiarEstadoPedido {

    @XmlElement(name = "id")
    private java.lang.String id;
    @XmlElement(name = "estado")
    private java.lang.String estado;

    public java.lang.String getId() {
        return this.id;
    }

    public void setId(java.lang.String newId)  {
        this.id = newId;
    }

    public int getEstado() {
        return Integer.parseInt(this.estado);
    }

    public void setEstado(int newEstado)  {
        this.estado = Integer.toString(newEstado);
    }

}

