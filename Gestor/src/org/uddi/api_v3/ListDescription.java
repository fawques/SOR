
package org.uddi.api_v3;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para listDescription complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="listDescription">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="includeCount" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="actualCount" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="listHead" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "listDescription", propOrder = {
    "includeCount",
    "actualCount",
    "listHead"
})
public class ListDescription {

    protected int includeCount;
    protected int actualCount;
    protected int listHead;

    /**
     * Obtiene el valor de la propiedad includeCount.
     * 
     */
    public int getIncludeCount() {
        return includeCount;
    }

    /**
     * Define el valor de la propiedad includeCount.
     * 
     */
    public void setIncludeCount(int value) {
        this.includeCount = value;
    }

    /**
     * Obtiene el valor de la propiedad actualCount.
     * 
     */
    public int getActualCount() {
        return actualCount;
    }

    /**
     * Define el valor de la propiedad actualCount.
     * 
     */
    public void setActualCount(int value) {
        this.actualCount = value;
    }

    /**
     * Obtiene el valor de la propiedad listHead.
     * 
     */
    public int getListHead() {
        return listHead;
    }

    /**
     * Define el valor de la propiedad listHead.
     * 
     */
    public void setListHead(int value) {
        this.listHead = value;
    }

}
