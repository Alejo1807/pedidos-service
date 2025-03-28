package com.restaurante.pedidos_service.application.services.pedido;

import java.util.Optional;

import org.springframework.stereotype.Component;

import com.restaurante.pedidos_service.application.usecase.pedido.UpdatePedidoUseCase;
import com.restaurante.pedidos_service.domain.entities.Pedido;
import com.restaurante.pedidos_service.domain.ports.PedidoRepositoryPort;

import lombok.RequiredArgsConstructor;

/**
 * Servicio que implementa el caso de uso para actualizar Pedidos
 * @author Usuario
 *
 */
@RequiredArgsConstructor
@Component
public class UpdatePedidoService implements UpdatePedidoUseCase {

	/**
	 * Puerto del repositorio de pedidos.
	 */
	private final PedidoRepositoryPort pedidoRepositoryPort;

	@Override
	public Optional<Pedido> update(Pedido pedido) {
		// TODO Auto-generated method stub
		return pedidoRepositoryPort.upDate(pedido);
	}

}
