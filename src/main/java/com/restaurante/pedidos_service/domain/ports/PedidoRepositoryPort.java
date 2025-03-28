package com.restaurante.pedidos_service.domain.ports;

import java.util.List;
import java.util.Optional;

import com.restaurante.pedidos_service.domain.entities.Pedido;

/**
 * 
 * Interface que funciona como puerto a los métodos CRUD que requiere la capa de dominio en la entidad Pedido
 *
 */
public interface PedidoRepositoryPort {

	/**
	 * Método para guardar un nuevo pedido
	 * @param pedido
	 * @return Pedido Guardado
	 */
	Pedido save(Pedido pedido);

	/**
	 * Método que encuentra un pedido por su ID 
	 * @param idPedido
	 * @return un objeto Optional con el pedido en caso de encontrarlo
	 */
	Optional<Pedido> findById(Long idPedido);

	/**
	 * Método para listar todos los pedidos
	 * @return lista de todos los pedidos
	 */
	List<Pedido> findAll();

	/**
	 * Método para actualizar un pedido existente
	 * @param pedido
	 * @return un objeto Optional con el que se puede obtener el pedido actualizado (si existe el id)
	 */
	Optional<Pedido> upDate(Pedido pedido);
}
