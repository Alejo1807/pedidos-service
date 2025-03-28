package com.restaurante.pedidos_service.application.usecase.pedido;

import java.util.List;
import java.util.Optional;

import com.restaurante.pedidos_service.domain.entities.Pedido;

/**
 * Interface que representa el caso de uso de encontrar para la entidad de dominio Pedido
 * @author Usuario
 *
 */
public interface FindPedidoUseCase {

	/**
	 * Busca un pedido por su ID.
	 *
	 * @param idPedido ID del pedido a buscar.
	 * @return Un Optional que contiene el pedido si se encuentra, o vacío si no.
	 */
	Optional<Pedido> findById(Long idPedido);

	/**
	 * Lista todos los pedidos.
	 *
	 * @return Una lista de todos los pedidos.
	 */
	List<Pedido> findAll();
}
