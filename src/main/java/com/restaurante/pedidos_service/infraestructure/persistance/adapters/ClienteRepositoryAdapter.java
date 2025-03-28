package com.restaurante.pedidos_service.infraestructure.persistance.adapters;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.restaurante.pedidos_service.domain.entities.Cliente;
import com.restaurante.pedidos_service.domain.ports.ClienteRepositoryPort;
import com.restaurante.pedidos_service.infraestructure.persistance.entities.ClienteEntity;
import com.restaurante.pedidos_service.infraestructure.persistance.mappers.ClienteMapper;
import com.restaurante.pedidos_service.infraestructure.persistance.repositories.ClienteRepositoryJPA;

import lombok.Data;

@Data
@Component
public class ClienteRepositoryAdapter implements ClienteRepositoryPort {

	@Autowired
	ClienteRepositoryJPA clienteRepositoryJPA;

	@Override
	@Transactional
	public Cliente save(Cliente cliente) {

		ClienteEntity newCliente = ClienteMapper.fromClienteToClienteEntity(cliente);

		return ClienteMapper.fromClienteEntityToCliente(clienteRepositoryJPA.save(newCliente));
	}

	@Override
	@Transactional(readOnly=true)
	public Optional<Cliente> findById(Long idCliente) {
		Optional<ClienteEntity> clienteEntityOptional = clienteRepositoryJPA.findById(idCliente);

		if(clienteEntityOptional.isPresent()) {
			Cliente cliente = ClienteMapper.fromClienteEntityToCliente(clienteEntityOptional.get());
			return Optional.of(cliente);
		}else {
			return Optional.empty();
		}		
	}

	@Override
	@Transactional(readOnly=true)
	public List<Cliente> findAll() {

		return clienteRepositoryJPA.findAll()
				.stream()
				.map(ClienteMapper::fromClienteEntityToCliente)
				.collect(Collectors.toList());
	}

	@Override
	@Transactional
	public Optional<Cliente> upDate(Cliente cliente) {
		Optional<ClienteEntity> clienteEntityOptional = clienteRepositoryJPA.findById(cliente.getIdCliente());

		if(clienteEntityOptional.isPresent()) {
			ClienteEntity clienteEntity = ClienteMapper.fromClienteToClienteEntity(cliente);
			ClienteEntity updateClienteEntity = clienteRepositoryJPA.save(clienteEntity);
			Cliente updateCliente = ClienteMapper.fromClienteEntityToCliente(updateClienteEntity);
			return Optional.of(updateCliente);

		}else {			
			return Optional.empty();
		}
	}

}
