package com.restaurante.pedidos_service.infraestructure.persistance.mappers;

import com.restaurante.pedidos_service.domain.entities.Cliente;
import com.restaurante.pedidos_service.infraestructure.persistance.entities.ClienteEntity;

/**
 * Mapeador que para la conversión entre entidades cliente de dominio e infraestructura
 * @author Usuario
 *
 */
public class ClienteMapper {
	
	/**
	 * Convierte una entidad de cliente del dominio a una de infraestructura
	 * @param cliente
	 * @return entidad ClienteEntity mapeada
	 */
	public static ClienteEntity fromClienteToClienteEntity(Cliente cliente) {
		return new ClienteEntity(
				cliente.getIdCliente(),
				cliente.getNombreCliente(),
				cliente.getNit(),
				cliente.getEmail(),
				cliente.getEstado());		
	}
	
	/**
	 * Convierte una entidad de cliente de infraestructura a una de dominio
	 * @param clienteEntity
	 * @return entidad Cliente mapeada
	 */
	public static Cliente fromClienteEntityToCliente(ClienteEntity clienteEntity) {
		return new Cliente(
				clienteEntity.getIdCliente(),
				clienteEntity.getNombreCliente(),
				clienteEntity.getNit(),
				clienteEntity.getEmail(),
				clienteEntity.getEstado());
	}
}
