package com.restaurante.pedidos_service.Infraestructure.embeddables;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.restaurante.pedidos_service.infraestructure.persistance.embeddables.TotalPedidoEmbeddable;

/**
 * Clase de prueba para la entidad embebida TotalPedidoEmbeddable.
 */
public class TotalPedidoEmbeddableTest {

	/**
	 * Prueba para verificar que el constructor de la clase TotalPedidoEmbeddable inicializa correctamente los atributos.
	 */
	@Test
	public void testTotalPedidoEmbeddableConstructor() {
		Double subTotal = 100.0;
		Short porcentajeIVA = 19;
		Double iva = subTotal * porcentajeIVA / 100;
		Double totalPedido = subTotal + iva;

		TotalPedidoEmbeddable totalPedidoObj = new TotalPedidoEmbeddable(subTotal, porcentajeIVA, iva, totalPedido);

		assertEquals(subTotal, totalPedidoObj.getSubTotal());
		assertEquals(porcentajeIVA, totalPedidoObj.getPorcentajeIVA());
		assertEquals(iva, totalPedidoObj.getIva());
		assertEquals(totalPedido, totalPedidoObj.getTotalPedido());
	}

	/**
	 * Prueba para verificar que los métodos setters y getters de la clase TotalPedidoEmbeddable funcionan correctamente.
	 */
	@Test
	public void testTotalPedidoEmbeddableSettersAndGetters() {
		TotalPedidoEmbeddable totalPedidoObj = new TotalPedidoEmbeddable();

		Double subTotal = 100.0;
		Short porcentajeIVA = 19;
		Double iva = subTotal * porcentajeIVA / 100;
		Double totalPedido = subTotal + iva;

		totalPedidoObj.setSubTotal(subTotal);
		totalPedidoObj.setPorcentajeIVA(porcentajeIVA);
		totalPedidoObj.setIva(iva);
		totalPedidoObj.setTotalPedido(totalPedido);

		assertEquals(subTotal, totalPedidoObj.getSubTotal());
		assertEquals(porcentajeIVA, totalPedidoObj.getPorcentajeIVA());
		assertEquals(iva, totalPedidoObj.getIva());
		assertEquals(totalPedido, totalPedidoObj.getTotalPedido());
	}
}
