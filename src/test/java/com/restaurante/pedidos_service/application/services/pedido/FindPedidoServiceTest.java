package com.restaurante.pedidos_service.application.services.pedido;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import com.restaurante.pedidos_service.application.ports.PedidoRepositoryPort;
import com.restaurante.pedidos_service.domain.entities.Pedido;

/**
 * Clase de prueba para el servicio FindPedidoService.
 */
@SpringBootTest
public class FindPedidoServiceTest {

	@Mock
	private PedidoRepositoryPort pedidoRepositoryPort;

	@InjectMocks
	private FindPedidoService findPedidoService;

	/**
	 * Prueba para verificar que el método findById funciona correctamente.
	 */
	@Test
	public void testFindById() {
		Long idPedido = 1L;
		Pedido pedido = new Pedido(idPedido, null, null, null, null, true);

		Mockito.when(pedidoRepositoryPort.findById(idPedido)).thenReturn(Optional.of(pedido));

		Optional<Pedido> result = findPedidoService.findById(idPedido);

		assertTrue(result.isPresent());
		assertEquals(idPedido, result.get().getIdPedido());
	}

	/**
	 * Prueba para verificar que el método findAll funciona correctamente.
	 */
	@Test
	public void testFindAll() {
		List<Pedido> pedidos = Arrays.asList(
				new Pedido(1L, null, null, null, null, true),
				new Pedido(2L, null, null, null, null, true)
				);

		Mockito.when(pedidoRepositoryPort.findAll()).thenReturn(pedidos);

		List<Pedido> result = findPedidoService.findAll();

		assertEquals(2, result.size());
	}

}
