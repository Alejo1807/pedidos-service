package com.restaurante.pedidos_service.application.services.pedido;

import java.util.Map;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

import com.restaurante.pedidos_service.application.ports.PedidoRepositoryPort;
import com.restaurante.pedidos_service.domain.entities.Pedido;

@Component
public class PedidoListener {

	private final PedidoRepositoryPort pedidoRepositoryPort;
	private final RabbitTemplate rabbitTemplate;

	public PedidoListener(PedidoRepositoryPort pedidoRepositoryPort, RabbitTemplate rabbitTemplate) {
		this.pedidoRepositoryPort = pedidoRepositoryPort;
		this.rabbitTemplate = rabbitTemplate;
	}

	@RabbitListener(queues = "DisponibilidadValidada")
	public void handleAvailabilityResponse(Map<String, Object> response) {
		Long pedidoId = (Long) response.get("idPedido");
		Boolean disponible = (Boolean) response.get("availability");

		if (disponible) {
			// Si hay disponibilidad, guardar el pedido
			System.out.println("[RabbitMQ] Mensaje recibido en DisponibilidadValidada: " + pedidoId);
		} else {
			// Manejar caso de no disponibilidad
			throw new IllegalStateException("No hay suficiente inventario disponible para el producto.");
		}
	}

}
