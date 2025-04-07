package com.restaurante.pedidos_service.Infraestructure.entities;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.restaurante.pedidos_service.infraestructure.persistance.entities.ItemPedidoEntity;
import com.restaurante.pedidos_service.infraestructure.persistance.entities.PedidoEntity;

/**
 * Clase de prueba para la entidad ItemPedidoEntity.
 */
public class ItemPedidoEntityTest {
	/**
	 * Prueba para verificar que el constructor de la clase ItemPedidoEntity inicializa correctamente los atributos.
	 */
	@Test
	public void testItemPedidoEntityConstructor() {
		Long idItemPedido = 1L;
		Long idReceta = 1L;
		PedidoEntity pedido = new PedidoEntity(1L, null, null, null, null, true);
		Integer cantidad = 2;
		Double valor = 100.0;
		Double totalItem = 200.0;
		Boolean estado = true;

		ItemPedidoEntity itemPedidoEntity = new ItemPedidoEntity(idItemPedido, idReceta, pedido, cantidad, valor, totalItem, estado);

		assertEquals(idItemPedido, itemPedidoEntity.getIdItemPedido());
		assertEquals(idReceta, itemPedidoEntity.getIdReceta());
		assertEquals(pedido, itemPedidoEntity.getPedido());
		assertEquals(cantidad, itemPedidoEntity.getCantidad());
		assertEquals(valor, itemPedidoEntity.getValor());
		assertEquals(totalItem, itemPedidoEntity.getTotalItem());
		assertEquals(estado, itemPedidoEntity.getEstado());
	}

	/**
	 * Prueba para verificar que los métodos setters y getters de la clase ItemPedidoEntity funcionan correctamente.
	 */
	@Test
	public void testItemPedidoEntitySettersAndGetters() {
		ItemPedidoEntity itemPedidoEntity = new ItemPedidoEntity();

		Long idItemPedido = 1L;
		Long idReceta = 1L;
		PedidoEntity pedido = new PedidoEntity(1L, null, null, null, null, true);
		Integer cantidad = 2;
		Double valor = 100.0;
		Double totalItem = 200.0;
		Boolean estado = true;

		itemPedidoEntity.setIdItemPedido(idItemPedido);
		itemPedidoEntity.setIdReceta(idReceta);
		itemPedidoEntity.setPedido(pedido);
		itemPedidoEntity.setCantidad(cantidad);
		itemPedidoEntity.setValor(valor);
		itemPedidoEntity.setTotalItem(totalItem);
		itemPedidoEntity.setEstado(estado);

		assertEquals(idItemPedido, itemPedidoEntity.getIdItemPedido());
		assertEquals(idReceta, itemPedidoEntity.getIdReceta());
		assertEquals(pedido, itemPedidoEntity.getPedido());
		assertEquals(cantidad, itemPedidoEntity.getCantidad());
		assertEquals(valor, itemPedidoEntity.getValor());
		assertEquals(totalItem, itemPedidoEntity.getTotalItem());
		assertEquals(estado, itemPedidoEntity.getEstado());
	}
}
