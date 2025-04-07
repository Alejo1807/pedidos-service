package com.restaurante.pedidos_service.Infraestructure.adapters;

import static org.junit.jupiter.api.Assertions.*;
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
import com.restaurante.pedidos_service.domain.entities.ItemPedido;
import com.restaurante.pedidos_service.domain.entities.Pedido;
import com.restaurante.pedidos_service.domain.valueobjects.DireccionEntrega;
import com.restaurante.pedidos_service.domain.valueobjects.TotalPedido;
import com.restaurante.pedidos_service.infraestructure.persistance.adapters.PedidoRepositoryAdapter;
import com.restaurante.pedidos_service.infraestructure.persistance.embeddables.DireccionEntregaEmbeddable;
import com.restaurante.pedidos_service.infraestructure.persistance.embeddables.TotalPedidoEmbeddable;
import com.restaurante.pedidos_service.infraestructure.persistance.entities.ClienteEntity;
import com.restaurante.pedidos_service.infraestructure.persistance.entities.ItemPedidoEntity;
import com.restaurante.pedidos_service.infraestructure.persistance.entities.PedidoEntity;
import com.restaurante.pedidos_service.infraestructure.persistance.repositories.PedidoRepositoryJPA;

/**
 * Clase de prueba unitaria para PedidoRepositoryAdapter
 */
@ExtendWith(MockitoExtension.class)
@SpringBootTest
public class PedidoRepositoryAdapterTest {

	@Mock
	private PedidoRepositoryJPA pedidoRepositoryJPA;

	@InjectMocks
	private PedidoRepositoryAdapter pedidoRepositoryAdapter;

	private Pedido pedido;
	private PedidoEntity pedidoEntity;
	private ItemPedido itemPedido;
	private ItemPedidoEntity itemPedidoEntity;
	private Cliente cliente;
	private ClienteEntity clienteEntity;
	private DireccionEntrega direccionEntrega;
	private DireccionEntregaEmbeddable direccionEntregaEmbeddable;
	private TotalPedido totalPedido;
	private TotalPedidoEmbeddable totalPedidoEmbeddable;

	@BeforeEach
	public void setUp() {
		cliente = new Cliente(1L, "Nombre Cliente", 123456789L, "email@cliente.com", true);
		clienteEntity = new ClienteEntity(1L, "Nombre Cliente", 123456789L, "email@cliente.com", true);

		direccionEntrega = new DireccionEntrega("Antioquia", "Medellín", "El Poblado", "Calle 10 # 5-30");
		direccionEntregaEmbeddable = new DireccionEntregaEmbeddable("Antioquia", "Medellín", "El Poblado", "Calle 10 # 5-30");

		totalPedido = new TotalPedido(100.0, (short) 10, 10.0, 120.0);
		totalPedidoEmbeddable = new TotalPedidoEmbeddable(100.0, (short) 10, 10.0, 120.0);

		itemPedido = new ItemPedido(1L, 1L, null, 2, 50.0, 100.0, true);
		itemPedidoEntity = new ItemPedidoEntity(1L, 1L, null, 2, 50.0, 100.0, true);

		pedido = new Pedido(1L, cliente, List.of(itemPedido), direccionEntrega, totalPedido, true);
		pedidoEntity = new PedidoEntity(1L, clienteEntity, List.of(itemPedidoEntity), direccionEntregaEmbeddable, totalPedidoEmbeddable, true);

		itemPedido.setPedido(pedido);
		itemPedidoEntity.setPedido(pedidoEntity);
	}

	/**
	 * Prueba unitaria para el método save
	 */
	@Test
	public void testSave() {
		when(pedidoRepositoryJPA.save(any(PedidoEntity.class))).thenReturn(pedidoEntity);

		Pedido result = pedidoRepositoryAdapter.save(pedido);

		assertEquals(pedido.getIdPedido(), result.getIdPedido());
		assertEquals(pedido.getCliente().getIdCliente(), result.getCliente().getIdCliente());
		assertEquals(pedido.getDireccionEntrega().getDepartamento(), result.getDireccionEntrega().getDepartamento());
		assertEquals(pedido.getTotalPedido().getSubTotal(), result.getTotalPedido().getSubTotal());
		assertEquals(pedido.getEstado(), result.getEstado());
	}

	/**
	 * Prueba unitaria para el método findById
	 */
	@Test
	public void testFindById() {
		when(pedidoRepositoryJPA.findById(1L)).thenReturn(Optional.of(pedidoEntity));

		Optional<Pedido> result = pedidoRepositoryAdapter.findById(1L);

		assertEquals(true, result.isPresent());
		assertEquals(pedido.getIdPedido(), result.get().getIdPedido());
		assertEquals(pedido.getCliente().getIdCliente(), result.get().getCliente().getIdCliente());
		assertEquals(pedido.getDireccionEntrega().getDepartamento(), result.get().getDireccionEntrega().getDepartamento());
		assertEquals(pedido.getTotalPedido().getSubTotal(), result.get().getTotalPedido().getSubTotal());
		assertEquals(pedido.getEstado(), result.get().getEstado());
	}

	/**
	 * Prueba unitaria para el método findAll
	 */
	@Test
	public void testFindAll() {
		when(pedidoRepositoryJPA.findAll()).thenReturn(List.of(pedidoEntity));

		List<Pedido> result = pedidoRepositoryAdapter.findAll();

		assertEquals(1, result.size());
		assertEquals(pedido.getIdPedido(), result.get(0).getIdPedido());
		assertEquals(pedido.getCliente().getIdCliente(), result.get(0).getCliente().getIdCliente());
		assertEquals(pedido.getDireccionEntrega().getDepartamento(), result.get(0).getDireccionEntrega().getDepartamento());
		assertEquals(pedido.getTotalPedido().getSubTotal(), result.get(0).getTotalPedido().getSubTotal());
		assertEquals(pedido.getEstado(), result.get(0).getEstado());
	}

	/**
	 * Prueba unitaria para el método upDate
	 */
	@Test
	public void testUpDate() {
		when(pedidoRepositoryJPA.findById(1L)).thenReturn(Optional.of(pedidoEntity));
		when(pedidoRepositoryJPA.save(any(PedidoEntity.class))).thenReturn(pedidoEntity);

		Optional<Pedido> result = pedidoRepositoryAdapter.upDate(pedido);

		assertEquals(true, result.isPresent());
		assertEquals(pedido.getIdPedido(), result.get().getIdPedido());
		assertEquals(pedido.getCliente().getIdCliente(), result.get().getCliente().getIdCliente());
		assertEquals(pedido.getDireccionEntrega().getDepartamento(), result.get().getDireccionEntrega().getDepartamento());
		assertEquals(pedido.getTotalPedido().getSubTotal(), result.get().getTotalPedido().getSubTotal());
		assertEquals(pedido.getEstado(), result.get().getEstado());
	}
}
