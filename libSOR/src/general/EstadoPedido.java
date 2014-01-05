/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package general;

/**
 * NEW = Recien creado, tiene ID local pero no ID generado por el gestor
 * ACTIVE = Con ID del gestor, puede tener ofertas asignadas o no
 * ACCEPTED = El taller ha aceptado una oferta para este pedido, esperando la confirmacion del desguace
 * FINISHED_OK = El desguace ha confirmado la oferta, y la operacion ha finalizado correctamente
 * CANCELLED = El taller ha cancelado el pedido
 */
public enum EstadoPedido {
    NEW,ACTIVE,ACCEPTED,FINISHED_OK,CANCELLED
}
