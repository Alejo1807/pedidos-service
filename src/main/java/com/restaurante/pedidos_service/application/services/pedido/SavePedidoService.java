package com.restaurante.pedidos_service.application.services.pedido;

import org.springframework.stereotype.Component;

import com.restaurante.pedidos_service.application.ports.PedidoRepositoryPort;
import com.restaurante.pedidos_service.application.usecase.pedido.SavePedidoUseCase;
import com.restaurante.pedidos_service.domain.entities.Pedido;

import lombok.RequiredArgsConstructor;

/**
 * Servicio que implementa el caso de uso para guardar Pedidos
 * @author Usuario
 *
 */
@RequiredArgsConstructor
@Component
public class SavePedidoService implements SavePedidoUseCase {

	/**
	 * Puerto del repositorio de pedidos.
	 */
	private final PedidoRepositoryPort pedidoRepositoryPort;

	/**
	 * Guarda un pedido.
	 *
	 * @param pedido El pedido a guardar.
	 * @return El pedido guardado.
	 */
	@Override
	public Pedido save(Pedido producto) {
		return pedidoRepositoryPort.save(producto);
	}

}
