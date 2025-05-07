package com.restaurante.pedidos_service.application.services.pedido;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.amqp.rabbit.core.RabbitTemplate;

import com.restaurante.pedidos_service.application.ports.PedidoRepositoryPort;
import com.restaurante.pedidos_service.domain.entities.Pedido;


/**
 * Clase de prueba para el servicio SavePedidoService.
 */
@ExtendWith(MockitoExtension.class)
public class SavePedidoServiceTest {

	@Mock
	private PedidoRepositoryPort pedidoRepositoryPort;

	@Mock
	private RabbitTemplate rabbitTemplate;

	@InjectMocks
	private SavePedidoService savePedidoService;

	@Test
	void testSavePedido() {
		Pedido pedido = new Pedido(1L, null, null, null, null, true);

		when(pedidoRepositoryPort.save(Mockito.any(Pedido.class))).thenReturn(pedido);

		Pedido result = savePedidoService.save(pedido);

		assertEquals(pedido, result);
		verify(rabbitTemplate).convertAndSend("pedido.exchange", "pedido.creado", pedido);
	}
}
