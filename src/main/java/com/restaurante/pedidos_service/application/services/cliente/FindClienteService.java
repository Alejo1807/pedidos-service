package com.restaurante.pedidos_service.application.services.cliente;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;

import com.restaurante.pedidos_service.application.usecase.cliente.FindClienteUseCase;
import com.restaurante.pedidos_service.domain.entities.Cliente;
import com.restaurante.pedidos_service.domain.ports.ClienteRepositoryPort;

import lombok.RequiredArgsConstructor;

/**
 * Servicio que implementa el caso de uso para obtener Clientes
 * @author Usuario
 *
 */
@RequiredArgsConstructor
@Component
public class FindClienteService implements FindClienteUseCase {

	/**
	 * Puerto del repositorio de clientes.
	 */
	private final ClienteRepositoryPort clienteRepositoryPort;

	/**
	 * Busca un cliente por su ID.
	 *
	 * @param idCliente ID del cliente a buscar.
	 * @return Un Optional que contiene el cliente si se encuentra, o vacío si no.
	 */
	@Override
	public Optional<Cliente> findById(Long idCliente) {
		return clienteRepositoryPort.findById(idCliente);
	}

	/**
	 * Lista todos los clientes.
	 *
	 * @return Una lista de todos los clientes.
	 */
	@Override
	public List<Cliente> findAll() {
		return clienteRepositoryPort.findAll();
	}

}
