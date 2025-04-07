package com.restaurante.pedidos_service.Infraestructure.mappers;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.restaurante.pedidos_service.domain.entities.ItemPedido;
import com.restaurante.pedidos_service.infraestructure.persistance.entities.ItemPedidoEntity;
import com.restaurante.pedidos_service.infraestructure.persistance.mappers.ItemPedidoMapper;

/**
 * Clase de prueba para el mapeador ItemPedidoMapper.
 */
public class ItemPedidoMapperTest {

	/**
	 * Prueba para verificar la conversión de ItemPedido a ItemPedidoEntity.
	 */
	@Test
	public void testFromItemPedidoToItemPedidoEntity() {
		ItemPedido itemPedido = new ItemPedido(1L, 1L, null, 2, 100.0, 200.0, true);
		ItemPedidoEntity itemPedidoEntity = ItemPedidoMapper.fromItemPedidoToItemPedidoEntity(itemPedido);

		assertEquals(itemPedido.getIdItemPedido(), itemPedidoEntity.getIdItemPedido());
		assertEquals(itemPedido.getIdReceta(), itemPedidoEntity.getIdReceta());
		assertEquals(itemPedido.getCantidad(), itemPedidoEntity.getCantidad());
		assertEquals(itemPedido.getValor(), itemPedidoEntity.getValor());
		assertEquals(itemPedido.getTotalItem(), itemPedidoEntity.getTotalItem());
		assertEquals(itemPedido.getEstado(), itemPedidoEntity.getEstado());
	}

	/**
	 * Prueba para verificar la conversión de ItemPedidoEntity a ItemPedido.
	 */
	@Test
	public void testFromItemPedidoEntityToItemPedido() {
		ItemPedidoEntity itemPedidoEntity = new ItemPedidoEntity(1L, 1L, null, 2, 100.0, 200.0, true);
		ItemPedido itemPedido = ItemPedidoMapper.fromItemPedidoEntityToItemPedido(itemPedidoEntity);

		assertEquals(itemPedidoEntity.getIdItemPedido(), itemPedido.getIdItemPedido());
		assertEquals(itemPedidoEntity.getIdReceta(), itemPedido.getIdReceta());
		assertEquals(itemPedidoEntity.getCantidad(), itemPedido.getCantidad());
		assertEquals(itemPedidoEntity.getValor(), itemPedido.getValor());
		assertEquals(itemPedidoEntity.getTotalItem(), itemPedido.getTotalItem());
		assertEquals(itemPedidoEntity.getEstado(), itemPedido.getEstado());
	}

}
