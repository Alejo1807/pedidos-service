package com.restaurante.pedidos_service.application.dto;

import lombok.Data;

@Data
public class AvailabilityResponseDTO {
	private Long idPedido;
    private boolean availability;
}
