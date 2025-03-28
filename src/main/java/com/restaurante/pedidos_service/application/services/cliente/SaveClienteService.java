package com.restaurante.pedidos_service.application.services.cliente;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.restaurante.pedidos_service.application.usecase.cliente.SaveClienteUseCase;
import com.restaurante.pedidos_service.domain.entities.Cliente;
import com.restaurante.pedidos_service.domain.ports.ClienteRepositoryPort;

import lombok.RequiredArgsConstructor;

/**
 * Servicio que implementa el caso de uso para guardar Clientes
 * @author Usuario
 *
 */
@RequiredArgsConstructor
@Component
public class SaveClienteService implements SaveClienteUseCase {

	/**
	 * Puerto del repositorio de clientes.
	 */
	private final ClienteRepositoryPort clienteRepositoryPort;

	/**
	 * Guarda un cliente.
	 *
	 * @param cliente El cliente a guardar.
	 * @return El cliente guardado.
	 */
	@Override
	@Transactional
	public Cliente save(Cliente cliente) {
		return clienteRepositoryPort.save(cliente);
	}

}
