package com.restaurante.pedidos_service.application.services.pedido;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;

import com.restaurante.pedidos_service.application.usecase.pedido.FindPedidoUseCase;
import com.restaurante.pedidos_service.domain.entities.Pedido;
import com.restaurante.pedidos_service.domain.ports.PedidoRepositoryPort;

import lombok.RequiredArgsConstructor;

/**
 * Servicio que implementa el caso de uso para obtener Pedidos
 * @author Usuario
 *
 */
@RequiredArgsConstructor
@Component
public class FindPedidoService implements FindPedidoUseCase {

	/**
	 * Puerto del repositorio de pedidos.
	 */
	private final PedidoRepositoryPort pedidoRepositoryPort;

	/**
	 * Busca un cliente por su ID.
	 *
	 * @param idCliente ID del pedido a buscar.
	 * @return Un Optional que contiene el pedido si se encuentra, o vacío si no.
	 */
	@Override
	public Optional<Pedido> findById(Long idPedido) {
		return pedidoRepositoryPort.findById(idPedido);
	}

	/**
	 * Lista todos los pedidos.
	 *
	 * @return Una lista de todos los pedidos.
	 */
	@Override
	public List<Pedido> findAll() {
		return pedidoRepositoryPort.findAll();
	}

}
