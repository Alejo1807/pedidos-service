package com.restaurante.pedidos_service.application.usecase;

import com.restaurante.pedidos_service.domain.entities.Pedido;

public interface ISavePedido {
	Pedido save(Pedido producto);
}
