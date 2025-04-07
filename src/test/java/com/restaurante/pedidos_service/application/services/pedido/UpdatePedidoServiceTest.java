package com.restaurante.pedidos_service.application.services.pedido;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import com.restaurante.pedidos_service.application.ports.PedidoRepositoryPort;
import com.restaurante.pedidos_service.domain.entities.Pedido;

/**
 * Clase de prueba para el servicio UpdatePedidoService.
 */
@SpringBootTest
public class UpdatePedidoServiceTest {

	@Mock
	private PedidoRepositoryPort pedidoRepositoryPort;

	@InjectMocks
	private UpdatePedidoService updatePedidoService;

	/**
	 * Prueba para verificar que el método update funciona correctamente.
	 */
	@Test
	public void testUpdatePedido() {
		Pedido pedido = new Pedido(1L, null, null, null, null, true);
		Pedido updatedPedido = new Pedido(1L, null, null, null, null, false);

		Mockito.when(pedidoRepositoryPort.upDate(pedido)).thenReturn(Optional.of(updatedPedido));

		Optional<Pedido> result = updatePedidoService.update(pedido);

		assertTrue(result.isPresent());
		assertEquals(updatedPedido.getEstado(), result.get().getEstado());
	}

}
