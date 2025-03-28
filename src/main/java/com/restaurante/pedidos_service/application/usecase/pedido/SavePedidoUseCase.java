package com.restaurante.pedidos_service.application.usecase.pedido;

import com.restaurante.pedidos_service.domain.entities.Pedido;

/**
 * Interface que representa el caso de uso de guardar para la entidad de dominio Pedido
 * @author Usuario
 *
 */
public interface SavePedidoUseCase {

	/**
	 * Guarda un pedido.
	 *
	 * @param pedido El pedido a guardar.
	 * @return El pedido guardado.
	 */
	Pedido save(Pedido pedido);
}
