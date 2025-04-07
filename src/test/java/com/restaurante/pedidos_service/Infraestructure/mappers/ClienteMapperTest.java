package com.restaurante.pedidos_service.Infraestructure.mappers;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.restaurante.pedidos_service.domain.entities.Cliente;
import com.restaurante.pedidos_service.infraestructure.persistance.entities.ClienteEntity;
import com.restaurante.pedidos_service.infraestructure.persistance.mappers.ClienteMapper;

/**
 * Clase de prueba para el mapeador ClienteMapper.
 */
public class ClienteMapperTest {

	/**
	 * Prueba para verificar la conversión de Cliente a ClienteEntity.
	 */
	@Test
	public void testFromClienteToClienteEntity() {
		Cliente cliente = new Cliente(1L, "Juan Perez", 123456789L, "juan.perez@example.com", true);
		ClienteEntity clienteEntity = ClienteMapper.fromClienteToClienteEntity(cliente);

		assertEquals(cliente.getIdCliente(), clienteEntity.getIdCliente());
		assertEquals(cliente.getNombreCliente(), clienteEntity.getNombreCliente());
		assertEquals(cliente.getNit(), clienteEntity.getNit());
		assertEquals(cliente.getEmail(), clienteEntity.getEmail());
		assertEquals(cliente.getEstado(), clienteEntity.getEstado());
	}

	/**
	 * Prueba para verificar la conversión de ClienteEntity a Cliente.
	 */
	@Test
	public void testFromClienteEntityToCliente() {
		ClienteEntity clienteEntity = new ClienteEntity(1L, "Juan Perez", 123456789L, "juan.perez@example.com", true);
		Cliente cliente = ClienteMapper.fromClienteEntityToCliente(clienteEntity);

		assertEquals(clienteEntity.getIdCliente(), cliente.getIdCliente());
		assertEquals(clienteEntity.getNombreCliente(), cliente.getNombreCliente());
		assertEquals(clienteEntity.getNit(), cliente.getNit());
		assertEquals(clienteEntity.getEmail(), cliente.getEmail());
		assertEquals(clienteEntity.getEstado(), cliente.getEstado());
	}
}
