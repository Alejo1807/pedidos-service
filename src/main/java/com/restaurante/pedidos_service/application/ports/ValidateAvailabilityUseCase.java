package com.restaurante.pedidos_service.application.ports;

import com.restaurante.pedidos_service.application.dto.AvailabilityResponseDTO;

public interface ValidateAvailabilityUseCase {
	void handleAvailabilityResponse(AvailabilityResponseDTO response);
}
