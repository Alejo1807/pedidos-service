package com.restaurante.pedidos_service.application.usecase.cliente;

import java.util.Optional;

import com.restaurante.pedidos_service.domain.entities.Cliente;

/**
 * Interface que representa el caso de uso de actualizar para la entidad de dominio Pedido
 * @author Usuario
 *
 */
public interface UpdateClienteUseCase {
	
	/**
	 * Actualiza un cliente.
	 *
	 * @param pedido El cliente a actualizar.
	 * @return Un Optional que contiene el cliente actualizado si se encuentra, o vacío si no.
	 */
	Optional<Cliente> update(Cliente cliente);

}
