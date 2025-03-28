package com.restaurante.pedidos_service.domain.ports;

import java.util.List;
import java.util.Optional;

import com.restaurante.pedidos_service.domain.entities.Cliente;

/**
 * Interface que funciona como puerto a los métodos CRUD que requiere la capa de dominio en la entidad Cliente
 * @author Usuario
 *
 */
public interface ClienteRepositoryPort {
	
	/**
	 * Método para guardar un nuevo Cliente
	 * @param cliente
	 * @return Cliente Guardado
	 */
	Cliente save(Cliente cliente);

	/**
	 * Método que encuentra un pedido por su ID 
	 * @param idCliente
	 * @return un objeto Optional con el pedido en caso de encontrarlo
	 */
	Optional<Cliente> findById(Long idCliente);

	/**
	 * Método para listar todos los clientes
	 * @return lista de todos los clientes
	 */
	List<Cliente> findAll();

	/**
	 * Método para actualizar un pedido existente
	 * @param cliente
	 * @return un objeto Optional con el que se puede obtener el cliente actualizado (si existe el id)
	 */
	Optional<Cliente> upDate(Cliente cliente);
}
