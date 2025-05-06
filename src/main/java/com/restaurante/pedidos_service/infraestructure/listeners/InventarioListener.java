package com.restaurante.pedidos_service.infraestructure.listeners;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import com.restaurante.pedidos_service.application.dto.AvailabilityResponseDTO;
import com.restaurante.pedidos_service.application.ports.ValidateAvailabilityUseCase;

@Component
public class InventarioListener {

	private final ValidateAvailabilityUseCase validateAvailabilityUseCase;

	public InventarioListener(ValidateAvailabilityUseCase useCase) {
		this.validateAvailabilityUseCase = useCase;
	}
	
	@RabbitListener(queues = "DisponibilidadValidada")
	public void onAvailabilityMessage(AvailabilityResponseDTO response) {
		System.out.println("✅ Inventario validado para el pedido: " + response.getIdPedido());

		validateAvailabilityUseCase.handleAvailabilityResponse(response);
		System.out.println("📩 Mensaje recibido: " + response);
	}

}
