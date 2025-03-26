package com.restaurante.pedidos_service.domain.repositories;

import com.restaurante.pedidos_service.domain.entities.Pedido;

public interface PedidoRepositoryPort {
	Pedido save(Pedido producto);
}
