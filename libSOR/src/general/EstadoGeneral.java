/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package general;

/**
 *
 * ACTIVE = Con ID de gestor, activo en el sistema
 * INACTIVE = Dado de baja
 * PENDIENTE = Recien creado, esperando confirmacion desde el gestor. Tiene ID local pero no ID generada por el gestor
 */
public enum EstadoGeneral {
    ACTIVE,INACTIVE, PENDIENTE
}
