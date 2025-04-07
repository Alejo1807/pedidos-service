package com.restaurante.pedidos_service.Infraestructure.entities;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.restaurante.pedidos_service.infraestructure.persistance.embeddables.DireccionEntregaEmbeddable;
import com.restaurante.pedidos_service.infraestructure.persistance.embeddables.TotalPedidoEmbeddable;
import com.restaurante.pedidos_service.infraestructure.persistance.entities.ClienteEntity;
import com.restaurante.pedidos_service.infraestructure.persistance.entities.ItemPedidoEntity;
import com.restaurante.pedidos_service.infraestructure.persistance.entities.PedidoEntity;

/**
 * Clase de prueba para la entidad PedidoEntity.
 */
public class PedidoEntityTest {

	/**
	 * Prueba para verificar que el constructor de la clase PedidoEntity inicializa correctamente los atributos.
	 */
	@Test
	public void testPedidoEntityConstructor() {
		Long idPedido = 1L;
		ClienteEntity cliente = new ClienteEntity(1L, "Juan Perez", 123456789L, "juan.perez@example.com", true);
		List<ItemPedidoEntity> itemsPedidos = Arrays.asList(new ItemPedidoEntity(1L, 1L, null, 2, 100.0, 200.0, true));
		DireccionEntregaEmbeddable direccionEntrega = new DireccionEntregaEmbeddable("Antioquia", "Medellín", "El Poblado", "Calle 10 # 20-30");
		TotalPedidoEmbeddable totalPedido = new TotalPedidoEmbeddable(100.0, (short)19, 19.0, 119.0);
		Boolean estado = true;

		PedidoEntity pedidoEntity = new PedidoEntity(idPedido, cliente, itemsPedidos, direccionEntrega, totalPedido, estado);

		assertEquals(idPedido, pedidoEntity.getIdPedido());
		assertEquals(cliente, pedidoEntity.getCliente());
		assertEquals(itemsPedidos, pedidoEntity.getItemsPedidos());
		assertEquals(direccionEntrega, pedidoEntity.getDireccionEntrega());
		assertEquals(totalPedido, pedidoEntity.getTotalPedido());
		assertEquals(estado, pedidoEntity.getEstado());
	}

	/**
	 * Prueba para verificar que los métodos setters y getters de la clase PedidoEntity funcionan correctamente.
	 */
	@Test
	public void testPedidoEntitySettersAndGetters() {
		PedidoEntity pedidoEntity = new PedidoEntity();

		Long idPedido = 1L;
		ClienteEntity cliente = new ClienteEntity(1L, "Juan Perez", 123456789L, "juan.perez@example.com", true);
		List<ItemPedidoEntity> itemsPedidos = Arrays.asList(new ItemPedidoEntity(1L, 1L, null, 2, 100.0, 200.0, true));
		DireccionEntregaEmbeddable direccionEntrega = new DireccionEntregaEmbeddable("Antioquia", "Medellín", "El Poblado", "Calle 10 # 20-30");
		TotalPedidoEmbeddable totalPedido = new TotalPedidoEmbeddable(100.0, (short)19, 19.0, 119.0);
		Boolean estado = true;

		pedidoEntity.setIdPedido(idPedido);
		pedidoEntity.setCliente(cliente);
		pedidoEntity.setItemsPedidos(itemsPedidos);
		pedidoEntity.setDireccionEntrega(direccionEntrega);
		pedidoEntity.setTotalPedido(totalPedido);
		pedidoEntity.setEstado(estado);

		assertEquals(idPedido, pedidoEntity.getIdPedido());
		assertEquals(cliente, pedidoEntity.getCliente());
		assertEquals(itemsPedidos, pedidoEntity.getItemsPedidos());
		assertEquals(direccionEntrega, pedidoEntity.getDireccionEntrega());
		assertEquals(totalPedido, pedidoEntity.getTotalPedido());
		assertEquals(estado, pedidoEntity.getEstado());
	}
}
