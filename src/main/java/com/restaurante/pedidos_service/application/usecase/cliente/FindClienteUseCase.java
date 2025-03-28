package com.restaurante.pedidos_service.application.usecase.cliente;

import java.util.List;
import java.util.Optional;

import com.restaurante.pedidos_service.domain.entities.Cliente;

/**
 * Interface que representa el caso de uso de encontrar para la entidad de dominio Cliente
 * @author Usuario
 *
 */
public interface FindClienteUseCase {

	/**
	 * Busca un cliente por su ID.
	 *
	 * @param idCliente ID del cliente a buscar.
	 * @return Un Optional que contiene el cliente si se encuentra, o vacío si no.
	 */
	Optional<Cliente> findById(Long idCliente);

	/**
	 * Lista todos los clientes.
	 *
	 * @return Una lista de todos los clientes.
	 */
	List<Cliente> findAll();
}
