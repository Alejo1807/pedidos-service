package com.restaurante.pedidos_service.infraestructure.persistance.mappers;

import java.util.stream.Collectors;

import com.restaurante.pedidos_service.domain.entities.Pedido;
import com.restaurante.pedidos_service.infraestructure.persistance.entities.PedidoEntity;

public class PedidoMapper {
	public static PedidoEntity fromPedidoToPedidoEntity(Pedido pedido) {
		return new PedidoEntity(
				pedido.getIdPedido(),
				ClienteMapper.fromClienteToClienteEntity(pedido.getCliente()),
				pedido.getItemPedidos().stream()
				.map(ItemPedidoMapper::fromItemPedidoToItemPedidoEntity)
				.collect(Collectors.toList()),
				DireccionEntregaMapper.fromDireccionEntregaToDireccionEntregaEmbeddable(pedido.getDireccionEntrega()),
				TotalPedidoMapper.fromTotalPedidoToTotalPedidoEmbeddable(pedido.getTotalPedido()),
				pedido.getEstado()
				);
	}

	public static Pedido fromPedidoEntityToPedido(PedidoEntity pedidoEntity) {
				
		return new Pedido(
				pedidoEntity.getIdPedido(),
				ClienteMapper.fromClienteEntityToCliente(pedidoEntity.getCliente()),
				pedidoEntity.getItemsPedidos().stream()
				.map(ItemPedidoMapper::fromItemPedidoEntityToItemPedido)
				.collect(Collectors.toList()),
				DireccionEntregaMapper.fromDireccionEntregaEmbeddableToDireccionEntrega(pedidoEntity.getDireccionEntrega()),
				TotalPedidoMapper.fromTotalPedidoEmbeddableToTotalPedido(pedidoEntity.getTotalPedido()),
				pedidoEntity.getEstado()
				);
	}
}
