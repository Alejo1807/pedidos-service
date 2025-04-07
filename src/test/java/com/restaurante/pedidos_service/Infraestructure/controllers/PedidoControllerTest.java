package com.restaurante.pedidos_service.Infraestructure.controllers;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.restaurante.pedidos_service.application.usecase.pedido.FindPedidoUseCase;
import com.restaurante.pedidos_service.application.usecase.pedido.SavePedidoUseCase;
import com.restaurante.pedidos_service.application.usecase.pedido.UpdatePedidoUseCase;
import com.restaurante.pedidos_service.domain.entities.Cliente;
import com.restaurante.pedidos_service.domain.entities.ItemPedido;
import com.restaurante.pedidos_service.domain.entities.Pedido;
import com.restaurante.pedidos_service.domain.valueobjects.DireccionEntrega;
import com.restaurante.pedidos_service.domain.valueobjects.TotalPedido;
import com.restaurante.pedidos_service.infraestructure.controllers.PedidoController;

/**
 * Clase de prueba unitaria para PedidoController
 */
@ExtendWith(MockitoExtension.class)
public class PedidoControllerTest {

	@Mock
	private SavePedidoUseCase savePedidoUseCase;

	@Mock
	private FindPedidoUseCase findPedidoUseCase;

	@Mock
	private UpdatePedidoUseCase updatePedidoUseCase;

	@InjectMocks
	private PedidoController pedidoController;

	private Pedido pedido;

	@BeforeEach
	public void setUp() {
		pedido = new Pedido(1L, new Cliente(), List.of(new ItemPedido()), new DireccionEntrega(), new TotalPedido(), true);
	}

	/**
	 * Prueba unitaria para el método findAll
	 */
	@Test
	public void testFindAll() {
		when(findPedidoUseCase.findAll()).thenReturn(List.of(pedido));

		ResponseEntity<List<Pedido>> response = pedidoController.findAll();

		assertEquals(HttpStatus.OK, response.getStatusCode());
		assertEquals(1, response.getBody().size());
		assertEquals(pedido, response.getBody().get(0));
	}

	/**
	 * Prueba unitaria para el método findById
	 */
	@Test
	public void testFindById() {
		when(findPedidoUseCase.findById(1L)).thenReturn(Optional.of(pedido));

		ResponseEntity<Pedido> response = pedidoController.findById(1L);

		assertEquals(HttpStatus.OK, response.getStatusCode());
		assertEquals(pedido, response.getBody());
	}

	/**
	 * Prueba unitaria para el método findById cuando el pedido no se encuentra
	 */
	@Test
	public void testFindByIdNotFound() {
		when(findPedidoUseCase.findById(1L)).thenReturn(Optional.empty());

		ResponseEntity<Pedido> response = pedidoController.findById(1L);

		assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
		assertNull(response.getBody());
	}

	/**
	 * Prueba unitaria para el método save
	 */
	@Test
	public void testSave() {
		when(savePedidoUseCase.save(pedido)).thenReturn(pedido);

		ResponseEntity<Pedido> response = pedidoController.save(pedido);

		assertEquals(HttpStatus.OK, response.getStatusCode());
		assertEquals(pedido, response.getBody());
	}

	/**
	 * Prueba unitaria para el método update
	 */
	@Test
	public void testUpdate() {
		when(updatePedidoUseCase.update(pedido)).thenReturn(Optional.of(pedido));

		ResponseEntity<Pedido> response = pedidoController.update(pedido);

		assertEquals(HttpStatus.OK, response.getStatusCode());
		assertEquals(pedido, response.getBody());
	}

	/**
	 * Prueba unitaria para el método update cuando el pedido no se encuentra
	 */
	@Test
	public void testUpdateNotFound() {
		when(updatePedidoUseCase.update(pedido)).thenReturn(Optional.empty());

		ResponseEntity<Pedido> response = pedidoController.update(pedido);

		assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
		assertNull(response.getBody());
	}

}
