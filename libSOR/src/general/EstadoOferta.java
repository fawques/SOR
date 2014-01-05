/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package general;

/**
 * NEW = Recien creado, tiene ID local pero no ID generado por el gestor
 * ACTIVE = Con ID del gestor
 * ACCEPTED = El taller ha aceptado esta oferta, el desguace debe confirmarla
 * FINISHED_OK = El desguace ha confirmado la oferta, y la operacion ha finalizado correctamente
 * REJECTED = El taller ha rechazado la oferta
 * CANCELLED = El desguace ha cancelado la oferta
 * 
 */
public enum EstadoOferta {
    NEW,ACTIVE,ACCEPTED,FINISHED_OK,REJECTED,CANCELLED
}
