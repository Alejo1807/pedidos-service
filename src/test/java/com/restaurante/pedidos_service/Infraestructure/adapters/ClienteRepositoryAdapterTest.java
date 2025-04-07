package com.restaurante.pedidos_service.Infraestructure.adapters;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import com.restaurante.pedidos_service.domain.entities.Cliente;
import com.restaurante.pedidos_service.infraestructure.persistance.adapters.ClienteRepositoryAdapter;
import com.restaurante.pedidos_service.infraestructure.persistance.entities.ClienteEntity;
import com.restaurante.pedidos_service.infraestructure.persistance.repositories.ClienteRepositoryJPA;

/**
 * Clase de prueba unitaria para ClienteRepositoryAdapter
 */
@ExtendWith(MockitoExtension.class)
@SpringBootTest
public class ClienteRepositoryAdapterTest {

	@Mock
	private ClienteRepositoryJPA clienteRepositoryJPA;

	@InjectMocks
	private ClienteRepositoryAdapter clienteRepositoryAdapter;

	private Cliente cliente;
	private ClienteEntity clienteEntity;

	@BeforeEach
	public void setUp() {
		cliente = new Cliente(1L, "Nombre Cliente", 123456789L, "email@cliente.com", true);
		clienteEntity = new ClienteEntity(1L, "Nombre Cliente", 123456789L, "email@cliente.com", true);
	}

	/**
	 * Prueba unitaria para el método save
	 */
	@Test
	public void testSave() {
		when(clienteRepositoryJPA.save(any(ClienteEntity.class))).thenReturn(clienteEntity);

		Cliente result = clienteRepositoryAdapter.save(cliente);

		assertEquals(cliente.getIdCliente(), result.getIdCliente());
		assertEquals(cliente.getNombreCliente(), result.getNombreCliente());
		assertEquals(cliente.getNit(), result.getNit());
		assertEquals(cliente.getEmail(), result.getEmail());
		assertEquals(cliente.getEstado(), result.getEstado());
	}

	/**
	 * Prueba unitaria para el método findById
	 */
	@Test
	public void testFindById() {
		when(clienteRepositoryJPA.findById(1L)).thenReturn(Optional.of(clienteEntity));

		Optional<Cliente> result = clienteRepositoryAdapter.findById(1L);

		assertEquals(true, result.isPresent());
		assertEquals(cliente.getIdCliente(), result.get().getIdCliente());
		assertEquals(cliente.getNombreCliente(), result.get().getNombreCliente());
		assertEquals(cliente.getNit(), result.get().getNit());
		assertEquals(cliente.getEmail(), result.get().getEmail());
		assertEquals(cliente.getEstado(), result.get().getEstado());
	}

	/**
	 * Prueba unitaria para el método findAll
	 */
	@Test
	public void testFindAll() {
		when(clienteRepositoryJPA.findAll()).thenReturn(List.of(clienteEntity));

		List<Cliente> result = clienteRepositoryAdapter.findAll();

		assertEquals(1, result.size());
		assertEquals(cliente.getIdCliente(), result.get(0).getIdCliente());
		assertEquals(cliente.getNombreCliente(), result.get(0).getNombreCliente());
		assertEquals(cliente.getNit(), result.get(0).getNit());
		assertEquals(cliente.getEmail(), result.get(0).getEmail());
		assertEquals(cliente.getEstado(), result.get(0).getEstado());
	}

	/**
	 * Prueba unitaria para el método upDate
	 */
	@Test
	public void testUpDate() {
		when(clienteRepositoryJPA.findById(1L)).thenReturn(Optional.of(clienteEntity));
		when(clienteRepositoryJPA.save(any(ClienteEntity.class))).thenReturn(clienteEntity);

		Optional<Cliente> result = clienteRepositoryAdapter.upDate(cliente);

		assertEquals(true, result.isPresent());
		assertEquals(cliente.getIdCliente(), result.get().getIdCliente());
		assertEquals(cliente.getNombreCliente(), result.get().getNombreCliente());
		assertEquals(cliente.getNit(), result.get().getNit());
		assertEquals(cliente.getEmail(), result.get().getEmail());
		assertEquals(cliente.getEstado(), result.get().getEstado());
	}

}
