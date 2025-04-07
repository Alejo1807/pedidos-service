package com.restaurante.pedidos_service.application.services.pedido;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import com.restaurante.pedidos_service.application.ports.PedidoRepositoryPort;
import com.restaurante.pedidos_service.domain.entities.Pedido;

/**
 * Clase de prueba para el servicio SavePedidoService.
 */
@SpringBootTest
public class SavePedidoServiceTest {

	@Mock
	private PedidoRepositoryPort pedidoRepositoryPort;

	@InjectMocks
	private SavePedidoService savePedidoService;

	/**
	 * Prueba para verificar que el método save funciona correctamente.
	 */
	@Test
	public void testSavePedido() {
		Pedido pedido = new Pedido(1L, null, null, null, null, true);

		Mockito.when(pedidoRepositoryPort.save(pedido)).thenReturn(pedido);

		Pedido result = savePedidoService.save(pedido);

		assertEquals(pedido, result);
	}
}
