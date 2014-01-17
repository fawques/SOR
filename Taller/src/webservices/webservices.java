/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package webservices;

import gestor_taller.JMSException_Exception;

/**
 *
 * @author fawques
 */
public class webservices {
    static public String nuevoPedido_WS(String pedido) throws JMSException_Exception {
        gestor_taller.TallerWS_Service service = new gestor_taller.TallerWS_Service(jUDDIProxy.getWsdl());
        gestor_taller.TallerWS port = service.getTallerWSPort();
        return port.nuevoPedido(pedido);
    }
}
