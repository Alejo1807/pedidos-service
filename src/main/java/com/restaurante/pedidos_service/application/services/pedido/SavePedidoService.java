package com.restaurante.pedidos_service.application.services.pedido;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

import com.restaurante.pedidos_service.application.ports.PedidoRepositoryPort;
import com.restaurante.pedidos_service.application.usecase.pedido.SavePedidoUseCase;
import com.restaurante.pedidos_service.domain.entities.Pedido;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
 
 

/**
 * Servicio que implementa el caso de uso para guardar Pedidos
 * @author Usuario
 *
 */
@RequiredArgsConstructor
@Component
public class SavePedidoService implements SavePedidoUseCase {

	private final PedidoRepositoryPort pedidoRepositoryPort;
	private final RabbitTemplate rabbitTemplate;


	/**
	 * Guarda un pedido.
	 *
	 * @param pedido El pedido a guardar.
	 * @return El pedido guardado.
	 */
	@Override
	public Pedido save(Pedido pedido) {

		// Publicar mensaje para verificar disponibilidad
		rabbitTemplate.convertAndSend("PedidoCreado", pedido);
		
		return pedidoRepositoryPort.save(pedido);


	}

}
