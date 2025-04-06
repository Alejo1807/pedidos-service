package com.restaurante.pedidos_service.domain.entities;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

/**
 * Clase de prueba para la entidad ItemPedido.
 */
public class ItemPedidoTest {
	/**
	 * Prueba para verificar que el constructor de la clase ItemPedido inicializa correctamente los atributos.
	 */
	@Test
	public void testItemPedidoConstructor() {
		Long idItemPedido = 1L;
		Long idReceta = 1L;
		Pedido pedido = new Pedido(1L, null, null, null, null, true);
		Integer cantidad = 2;
		Double valor = 100.0;
		Double totalItem = 200.0;
		Boolean estado = true;

		ItemPedido itemPedido = new ItemPedido(idItemPedido, idReceta, pedido, cantidad, valor, totalItem, estado);

		assertEquals(idItemPedido, itemPedido.getIdItemPedido());
		assertEquals(idReceta, itemPedido.getIdReceta());
		assertEquals(pedido, itemPedido.getPedido());
		assertEquals(cantidad, itemPedido.getCantidad());
		assertEquals(valor, itemPedido.getValor());
		assertEquals(totalItem, itemPedido.getTotalItem());
		assertEquals(estado, itemPedido.getEstado());
	}

	/**
	 * Prueba para verificar que los métodos setters y getters de la clase ItemPedido funcionan correctamente.
	 */
	@Test
	public void testItemPedidoSettersAndGetters() {
		ItemPedido itemPedido = new ItemPedido();

		Long idItemPedido = 1L;
		Long idReceta = 1L;
		Pedido pedido = new Pedido(1L, null, null, null, null, true);
		Integer cantidad = 2;
		Double valor = 100.0;
		Double totalItem = 200.0;
		Boolean estado = true;

		itemPedido.setIdItemPedido(idItemPedido);
		itemPedido.setIdReceta(idReceta);
		itemPedido.setPedido(pedido);
		itemPedido.setCantidad(cantidad);
		itemPedido.setValor(valor);
		itemPedido.setTotalItem(totalItem);
		itemPedido.setEstado(estado);

		assertEquals(idItemPedido, itemPedido.getIdItemPedido());
		assertEquals(idReceta, itemPedido.getIdReceta());
		assertEquals(pedido, itemPedido.getPedido());
		assertEquals(cantidad, itemPedido.getCantidad());
		assertEquals(valor, itemPedido.getValor());
		assertEquals(totalItem, itemPedido.getTotalItem());
		assertEquals(estado, itemPedido.getEstado());
	}

}
