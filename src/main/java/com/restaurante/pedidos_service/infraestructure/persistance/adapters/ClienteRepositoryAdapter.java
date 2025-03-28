package com.restaurante.pedidos_service.infraestructure.persistance.adapters;

import java.util.List;
import java.util.Optional;

import com.restaurante.pedidos_service.domain.entities.Cliente;
import com.restaurante.pedidos_service.domain.ports.ClienteRepositoryPort;

public class ClienteRepositoryAdapter implements ClienteRepositoryPort {

	@Override
	public Cliente save(Cliente cliente) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<Cliente> findById(Long idCliente) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	@Override
	public List<Cliente> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<Cliente> upDate(Cliente cliente) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

}
