package com.restaurante.pedidos_service.application.usecase.cliente;

import com.restaurante.pedidos_service.domain.entities.Cliente;

/**
 * Interface que representa el caso de uso de guardar para la entidad de dominio Cliente
 * @author Usuario
 *
 */
public interface SaveClienteUseCase {

	/**
	 * Guarda un cliente.
	 *
	 * @param cliente El cliente a guardar.
	 * @return El cliente guardado.
	 */
	Cliente save(Cliente cliente);

}
