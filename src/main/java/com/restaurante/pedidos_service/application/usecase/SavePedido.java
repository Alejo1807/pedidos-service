package com.restaurante.pedidos_service.application.usecase;

import org.springframework.stereotype.Component;

import com.restaurante.pedidos_service.domain.entities.Pedido;
import com.restaurante.pedidos_service.domain.repositories.PedidoRepositoryPort;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Component
public class SavePedido implements ISavePedido {

	private final PedidoRepositoryPort pedidoRepositoryPort;
	
	@Override
	public Pedido save(Pedido producto) {
		return pedidoRepositoryPort.save(producto);
	}

}
