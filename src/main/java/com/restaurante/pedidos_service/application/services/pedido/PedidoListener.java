package com.restaurante.pedidos_service.application.services.pedido;

import java.util.Map;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class PedidoListener {

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
