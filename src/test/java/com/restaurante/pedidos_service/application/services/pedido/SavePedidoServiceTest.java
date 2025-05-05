package com.restaurante.pedidos_service.application.services.pedido;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.beans.factory.annotation.Autowired;

import com.restaurante.pedidos_service.application.ports.PedidoRepositoryPort;
import com.restaurante.pedidos_service.domain.entities.Pedido;
import org.springframework.amqp.rabbit.core.RabbitTemplate;


/**
 * Clase de prueba para el servicio SavePedidoService.
 */
@SpringBootTest
public class SavePedidoServiceTest {

	@MockBean
	private PedidoRepositoryPort pedidoRepositoryPort;

	@MockBean
	private RabbitTemplate rabbitTemplate;

	@Autowired
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

		verify(rabbitTemplate).convertAndSend("PedidoCreado", pedido);
	}
}
