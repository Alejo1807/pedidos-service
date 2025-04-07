package com.restaurante.pedidos_service.Infraestructure.mappers;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.restaurante.pedidos_service.domain.entities.Pedido;
import com.restaurante.pedidos_service.infraestructure.persistance.entities.PedidoEntity;
import com.restaurante.pedidos_service.infraestructure.persistance.mappers.PedidoMapper;

/**
 * Clase de prueba para el mapeador PedidoMapper.
 */
public class PedidoMapperTest {

	/**
	 * Prueba para verificar la conversión de Pedido a PedidoEntity.
	 */
	@Test
	public void testFromPedidoToPedidoEntity() {
		Pedido pedido = new Pedido(1L, null, null, null, null, true);
		PedidoEntity pedidoEntity = PedidoMapper.fromPedidoToPedidoEntity(pedido);

		assertEquals(pedido.getIdPedido(), pedidoEntity.getIdPedido());
		assertEquals(pedido.getEstado(), pedidoEntity.getEstado());
	}

	/**
	 * Prueba para verificar la conversión de PedidoEntity a Pedido.
	 */
	@Test
	public void testFromPedidoEntityToPedido() {
		PedidoEntity pedidoEntity = new PedidoEntity(1L, null, null, null, null, true);
		Pedido pedido = PedidoMapper.fromPedidoEntityToPedido(pedidoEntity);

		assertEquals(pedidoEntity.getIdPedido(), pedido.getIdPedido());
		assertEquals(pedidoEntity.getEstado(), pedido.getEstado());
	}
}
