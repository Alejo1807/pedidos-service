package com.restaurante.pedidos_service.domain.valueObjects;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.restaurante.pedidos_service.domain.valueobjects.TotalPedido;

/**
 * Clase de prueba para la entidad TotalPedido.
 */
public class TotalPedidoTest {

	/**
	 * Prueba para verificar que el constructor de la clase TotalPedido inicializa correctamente los atributos.
	 */
	@Test
	public void testTotalPedidoConstructor() {
		Double subTotal = 100.0;
		Short porcentajeIVA = 19;
		Double iva = subTotal * porcentajeIVA / 100;
		Double totalPedido = subTotal + iva;

		TotalPedido totalPedidoObj = new TotalPedido(subTotal, porcentajeIVA, iva, totalPedido);

		assertEquals(subTotal, totalPedidoObj.getSubTotal());
		assertEquals(porcentajeIVA, totalPedidoObj.getPorcentajeIVA());
		assertEquals(iva, totalPedidoObj.getIva());
		assertEquals(totalPedido, totalPedidoObj.getTotalPedido());
	}

	/**
	 * Prueba para verificar que los métodos setters y getters de la clase TotalPedido funcionan correctamente.
	 */
	@Test
	public void testTotalPedidoSettersAndGetters() {
		TotalPedido totalPedidoObj = new TotalPedido();

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
