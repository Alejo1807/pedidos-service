package com.restaurante.pedidos_service.Infraestructure.mappers;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.restaurante.pedidos_service.domain.valueobjects.TotalPedido;
import com.restaurante.pedidos_service.infraestructure.persistance.embeddables.TotalPedidoEmbeddable;
import com.restaurante.pedidos_service.infraestructure.persistance.mappers.TotalPedidoMapper;

/**
 * Clase de prueba para el mapeador TotalPedidoMapper.
 */
public class TotalPedidoMapperTest {


	/**
	 * Prueba unitaria para el método fromTotalPedidoToTotalPedidoEmbeddable
	 */
	@Test
	public void testFromTotalPedidoToTotalPedidoEmbeddable() {
		// Arrange
		TotalPedido totalPedido = new TotalPedido(100.0, (short) 10, 10.0, 120.0);

		// Act
		TotalPedidoEmbeddable result = TotalPedidoMapper.fromTotalPedidoToTotalPedidoEmbeddable(totalPedido);

		// Assert
		assertEquals(100.0, result.getSubTotal());
		assertEquals((short) 10, result.getPorcentajeIVA());
		assertEquals(10.0, result.getIva());
		assertEquals(120.0, result.getTotalPedido());
	}

	/**
	 * Prueba unitaria para el método fromTotalPedidoEmbeddableToTotalPedido
	 */
	@Test
	public void testFromTotalPedidoEmbeddableToTotalPedido() {
		// Arrange
		TotalPedidoEmbeddable totalPedidoEmbeddable = new TotalPedidoEmbeddable(100.0, (short) 10, 10.0, 120.0);

		// Act
		TotalPedido result = TotalPedidoMapper.fromTotalPedidoEmbeddableToTotalPedido(totalPedidoEmbeddable);

		// Assert
		assertEquals(100.0, result.getSubTotal());
		assertEquals((short) 10, result.getPorcentajeIVA());
		assertEquals(10.0, result.getIva());
		assertEquals(120.0, result.getTotalPedido());
	}


}
