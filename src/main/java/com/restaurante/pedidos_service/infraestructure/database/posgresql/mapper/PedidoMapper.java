package com.restaurante.pedidos_service.infraestructure.database.posgresql.mapper;

import com.restaurante.pedidos_service.domain.entities.Pedido;
import com.restaurante.pedidos_service.infraestructure.database.posgresql.entity.PedidoEntity;

public class PedidoMapper {
	public static PedidoEntity fromPedidoToPedidoEntity(Pedido pedido) {
		return new PedidoEntity(
				null,
				pedido.getIdPedido(),
				pedido.getCliente(),
				pedido.getItemPedidos(),
				pedido.getDireccionEntrega(),
				pedido.getTotalPedido());
	}
	
	public static Pedido fromPedidoEntityToPedido(PedidoEntity pedidoEntity) {
		return new Pedido(
				pedidoEntity.getId(),
				pedidoEntity.getCliente(),
				pedidoEntity.getItemPedidos(),
				pedidoEntity.getDireccionEntrega(),
				pedidoEntity.getTotalPedido()
				);
	}
}
