package com.restaurante.pedidos_service.application.services.cliente;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import com.restaurante.pedidos_service.application.ports.ClienteRepositoryPort;
import com.restaurante.pedidos_service.domain.entities.Cliente;

/**
 * Clase de prueba para el servicio SaveClienteService.
 */
@SpringBootTest
public class SaveClienteServiceTest {

    @Mock
    private ClienteRepositoryPort clienteRepositoryPort;

    @InjectMocks
    private SaveClienteService saveClienteService;

    /**
     * Prueba para verificar que el método save funciona correctamente.
     */
    @Test
    public void testSaveCliente() {
        Cliente cliente = new Cliente(1L, "Juan Perez", 123456789L, "juan.perez@example.com", true);

        Mockito.when(clienteRepositoryPort.save(cliente)).thenReturn(cliente);

        Cliente result = saveClienteService.save(cliente);

        assertEquals(cliente, result);
    }

}
