package com.restaurante.pedidos_service.application.services.cliente;

import java.util.Optional;

import org.springframework.stereotype.Component;

import com.restaurante.pedidos_service.application.usecase.cliente.UpdateClienteUseCase;
import com.restaurante.pedidos_service.domain.entities.Cliente;
import com.restaurante.pedidos_service.domain.ports.ClienteRepositoryPort;

import lombok.RequiredArgsConstructor;

/**
 * Servicio que implementa el caso de uso para actualizara Clientes
 * @author Usuario
 *
 */
@RequiredArgsConstructor
@Component
public class UpdateClienteService implements UpdateClienteUseCase {

	/**
	 * Puerto del repositorio de clientes.
	 */
	private final ClienteRepositoryPort clienteRepositoryPort;

	@Override
	public Optional<Cliente> update(Cliente cliente) {
		// TODO Auto-generated method stub
		return clienteRepositoryPort.upDate(cliente);
	}

}
