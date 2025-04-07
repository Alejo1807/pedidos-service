package com.restaurante.pedidos_service.Infraestructure.controllers;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.restaurante.pedidos_service.application.usecase.cliente.FindClienteUseCase;
import com.restaurante.pedidos_service.application.usecase.cliente.SaveClienteUseCase;
import com.restaurante.pedidos_service.application.usecase.cliente.UpdateClienteUseCase;
import com.restaurante.pedidos_service.domain.entities.Cliente;
import com.restaurante.pedidos_service.infraestructure.controllers.ClienteController;

/**
 * Clase de prueba unitaria para ClienteController
 */
@ExtendWith(MockitoExtension.class)
public class ClienteControllerTest {

	@Mock
	private FindClienteUseCase findClienteUseCase;

	@Mock
	private SaveClienteUseCase saveClienteUseCase;

	@Mock
	private UpdateClienteUseCase updateClienteUseCase;

	@InjectMocks
	ClienteController clienteController;

	private Cliente cliente;

	@BeforeEach
	public void setUp() {
		cliente = new Cliente(1L, "Nombre Cliente", 123456789L, "email@cliente.com", true);
	}

	/**
	 * Prueba unitaria para el método findById
	 */
	@Test
	public void testFindById() {
		when(findClienteUseCase.findById(1L)).thenReturn(Optional.of(cliente));

		ResponseEntity<Cliente> response = clienteController.findById(1L);

		assertEquals(HttpStatus.OK, response.getStatusCode());
		assertEquals(cliente, response.getBody());
	}

	/**
	 * Prueba unitaria para el método findById cuando el cliente no se encuentra
	 */
	@Test
	public void testFindByIdNotFound() {
		when(findClienteUseCase.findById(1L)).thenReturn(Optional.empty());

		ResponseEntity<Cliente> response = clienteController.findById(1L);

		assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
		assertNull(response.getBody());
	}

	/**
	 * Prueba unitaria para el método save
	 */
	@Test
	public void testSave() {
		when(saveClienteUseCase.save(cliente)).thenReturn(cliente);

		ResponseEntity<Cliente> response = clienteController.save(cliente);

		assertEquals(HttpStatus.OK, response.getStatusCode());
		assertEquals(cliente, response.getBody());
	}

	/**
	 * Prueba unitaria para el método update
	 */
	@Test
	public void testUpdate() {
		when(updateClienteUseCase.update(cliente)).thenReturn(Optional.of(cliente));

		ResponseEntity<Cliente> response = clienteController.update(cliente);

		assertEquals(HttpStatus.OK, response.getStatusCode());
		assertEquals(cliente, response.getBody());
	}

	/**
	 * Prueba unitaria para el método update cuando el cliente no se encuentra
	 */
	@Test
	public void testUpdateNotFound() {
		when(updateClienteUseCase.update(cliente)).thenReturn(Optional.empty());

		ResponseEntity<Cliente> response = clienteController.update(cliente);

		assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
		assertNull(response.getBody());
	}
}
