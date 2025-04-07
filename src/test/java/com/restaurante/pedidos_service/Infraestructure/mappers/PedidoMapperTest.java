package com.restaurante.pedidos_service.Infraestructure.mappers;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;

import com.restaurante.pedidos_service.domain.entities.Cliente;
import com.restaurante.pedidos_service.domain.entities.ItemPedido;
import com.restaurante.pedidos_service.domain.entities.Pedido;
import com.restaurante.pedidos_service.domain.valueobjects.DireccionEntrega;
import com.restaurante.pedidos_service.domain.valueobjects.TotalPedido;
import com.restaurante.pedidos_service.infraestructure.persistance.embeddables.DireccionEntregaEmbeddable;
import com.restaurante.pedidos_service.infraestructure.persistance.embeddables.TotalPedidoEmbeddable;
import com.restaurante.pedidos_service.infraestructure.persistance.entities.ClienteEntity;
import com.restaurante.pedidos_service.infraestructure.persistance.entities.ItemPedidoEntity;
import com.restaurante.pedidos_service.infraestructure.persistance.entities.PedidoEntity;
import com.restaurante.pedidos_service.infraestructure.persistance.mappers.PedidoMapper;

/**
 * Clase de prueba para el mapeador PedidoMapper.
 */
public class PedidoMapperTest {

	@Test
	public void testFromPedidoToPedidoEntity() {
		// Arrange
		Cliente cliente = new Cliente(1L, "Nombre Cliente", 123456789L, "email@cliente.com", true);
		DireccionEntrega direccionEntrega = new DireccionEntrega("Antioquia", "Medellín", "El Poblado", "Calle 10 # 5-30");
		TotalPedido totalPedido = new TotalPedido(100.0, (short) 10, 10.0, 120.0);
		ItemPedido itemPedido = new ItemPedido(1L, 1L, null, 2, 50.0, 100.0, true);
		Pedido pedido = new Pedido(1L, cliente, List.of(itemPedido), direccionEntrega, totalPedido, true);

		// Act
		PedidoEntity result = PedidoMapper.fromPedidoToPedidoEntity(pedido);

		// Assert
		assertEquals(pedido.getIdPedido(), result.getIdPedido());
		assertEquals(pedido.getCliente().getIdCliente(), result.getCliente().getIdCliente());
		assertEquals(pedido.getDireccionEntrega().getDepartamento(), result.getDireccionEntrega().getDepartamento());
		assertEquals(pedido.getTotalPedido().getSubTotal(), result.getTotalPedido().getSubTotal());
		assertEquals(pedido.getEstado(), result.getEstado());
	}

	@Test
	public void testFromPedidoEntityToPedido() {
		// Arrange
		ClienteEntity clienteEntity = new ClienteEntity(1L, "Nombre Cliente", 123456789L, "email@cliente.com", true);
		DireccionEntregaEmbeddable direccionEntregaEmbeddable = new DireccionEntregaEmbeddable("Antioquia", "Medellín", "El Poblado", "Calle 10 # 5-30");
		TotalPedidoEmbeddable totalPedidoEmbeddable = new TotalPedidoEmbeddable(100.0, (short) 10, 10.0, 120.0);
		ItemPedidoEntity itemPedidoEntity = new ItemPedidoEntity(1L, 1L, null, 2, 50.0, 100.0, true);
		PedidoEntity pedidoEntity = new PedidoEntity(1L, clienteEntity, List.of(itemPedidoEntity), direccionEntregaEmbeddable, totalPedidoEmbeddable, true);

		// Act
		Pedido result = PedidoMapper.fromPedidoEntityToPedido(pedidoEntity);

		// Assert
		assertEquals(pedidoEntity.getIdPedido(), result.getIdPedido());
		assertEquals(pedidoEntity.getCliente().getIdCliente(), result.getCliente().getIdCliente());
		assertEquals(pedidoEntity.getDireccionEntrega().getDepartamento(), result.getDireccionEntrega().getDepartamento());
		assertEquals(pedidoEntity.getTotalPedido().getSubTotal(), result.getTotalPedido().getSubTotal());
		assertEquals(pedidoEntity.getEstado(), result.getEstado());
	}

}
