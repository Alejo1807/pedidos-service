package com.restaurante.pedidos_service.application.services.pedido;

import com.restaurante.pedidos_service.application.dto.AvailabilityResponseDTO;
import com.restaurante.pedidos_service.application.ports.PedidoRepositoryPort;
import com.restaurante.pedidos_service.application.ports.ValidateAvailabilityUseCase;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ValidateAvailabilityService implements ValidateAvailabilityUseCase {
	private final PedidoRepositoryPort pedidoRepositoryPort;

    @Override
    public void handleAvailabilityResponse(AvailabilityResponseDTO response) {
    	System.out.println(response);
        var pedido = pedidoRepositoryPort.findById(response.getIdPedido());

        if (pedido.isEmpty()) {
            System.out.println("Pedido no encontrado con ID: " + response.getIdPedido());
            return;
        }

        if (!response.isAvailability()) {
            System.out.println("Pedido cancelado: " + response.getIdPedido());
            pedido.get().setEstado(false);
        } else {
        	System.out.println("Pedido con disponibilidad de inventario: " + response.getIdPedido());
        	pedido.get().setEstado(true);
        }

        pedidoRepositoryPort.save(pedido.get());
    }
}
