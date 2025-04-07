package com.restaurante.pedidos_service.application.services.cliente;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import com.restaurante.pedidos_service.application.ports.ClienteRepositoryPort;
import com.restaurante.pedidos_service.domain.entities.Cliente;

/**
 * Clase de prueba para el servicio FindClienteService.
 */
@SpringBootTest
public class FindClienteServiceTest {


	@Mock
	private ClienteRepositoryPort clienteRepositoryPort;

	@InjectMocks
	private FindClienteService findClienteService;

	/**
	 * Prueba para verificar que el método findById funciona correctamente.
	 */
	@Test
	public void testFindById() {
		Long idCliente = 1L;
		Cliente cliente = new Cliente(idCliente, "Juan Perez", 123456789L, "juan.perez@example.com", true);

		Mockito.when(clienteRepositoryPort.findById(idCliente)).thenReturn(Optional.of(cliente));

		Optional<Cliente> result = findClienteService.findById(idCliente);

		assertTrue(result.isPresent());
		assertEquals(idCliente, result.get().getIdCliente());
	}

	/**
	 * Prueba para verificar que el método findAll funciona correctamente.
	 */
	@Test
	public void testFindAll() {
		List<Cliente> clientes = Arrays.asList(
				new Cliente(1L, "Juan Perez", 123456789L, "juan.perez@example.com", true),
				new Cliente(2L, "Maria Gomez", 987654321L, "maria.gomez@example.com", true)
				);

		Mockito.when(clienteRepositoryPort.findAll()).thenReturn(clientes);

		List<Cliente> result = findClienteService.findAll();

		assertEquals(2, result.size());
		assertEquals("Juan Perez", result.get(0).getNombreCliente());
		assertEquals("Maria Gomez", result.get(1).getNombreCliente());
	}
}
