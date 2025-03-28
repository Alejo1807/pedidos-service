package com.restaurante.pedidos_service.application.usecase.pedido;

import java.util.Optional;

import com.restaurante.pedidos_service.domain.entities.Pedido;

/**
 * Interface que representa el caso de uso de actualizar para la entidad de dominio Pedido
 * @author Usuario
 *
 */
public interface UpdatePedidoUseCase {

	/**
	 * Actualiza un pedido.
	 *
	 * @param pedido El pedido a actualizar.
	 * @return Un Optional que contiene el pedido actualizado si se encuentra, o vacío si no.
	 */
	Optional<Pedido> update(Pedido pedido);
}
