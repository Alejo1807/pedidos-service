package com.restaurante.pedidos_service.application.services.cliente;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import com.restaurante.pedidos_service.application.ports.ClienteRepositoryPort;
import com.restaurante.pedidos_service.domain.entities.Cliente;

/**
 * Clase de prueba para el servicio UpdateClienteService.
 */
@SpringBootTest
public class UpdateClienteServiceTest {

    @Mock
    private ClienteRepositoryPort clienteRepositoryPort;

    @InjectMocks
    private UpdateClienteService updateClienteService;

    /**
     * Prueba para verificar que el método update funciona correctamente.
     */
    @Test
    public void testUpdateCliente() {
        Cliente cliente = new Cliente(1L, "Juan Perez", 123456789L, "juan.perez@example.com", true);
        Cliente updatedCliente = new Cliente(1L, "Juan Perez", 123456789L, "juan.perez@updated.com", true);

        Mockito.when(clienteRepositoryPort.upDate(cliente)).thenReturn(Optional.of(updatedCliente));

        Optional<Cliente> result = updateClienteService.update(cliente);

        assertTrue(result.isPresent());
        assertEquals(updatedCliente.getEmail(), result.get().getEmail());
    }

}
