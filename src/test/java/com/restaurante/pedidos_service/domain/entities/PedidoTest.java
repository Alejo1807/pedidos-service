package com.restaurante.pedidos_service.domain.entities;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import com.restaurante.pedidos_service.domain.valueobjects.DireccionEntrega;
import com.restaurante.pedidos_service.domain.valueobjects.TotalPedido;

import java.util.Arrays;
import java.util.List;



/**
 * Clase de prueba para la entidad Pedido.
 */
public class PedidoTest {
	/**
	 * Prueba para verificar que el constructor de la clase Pedido inicializa correctamente los atributos.
	 */
	@Test
	public void testPedidoConstructor() {
		Long idPedido = 1L;
		Short iva = 19;
		Cliente cliente = new Cliente(1L, "Juan Perez", 123456789L, "juan.perez@example.com", true);
		List<ItemPedido> itemPedidos = Arrays.asList(new ItemPedido(1L, 1L, null, 2, 100.0, 200.0, true));
		DireccionEntrega direccionEntrega = new DireccionEntrega("Antioquia","Medellin", "Robledo", "CR 80 65-89");
		TotalPedido totalPedido = new TotalPedido(200.0, iva, 20.0, 220.0);
		Boolean estado = true;

		Pedido pedido = new Pedido(idPedido, cliente, itemPedidos, direccionEntrega, totalPedido, estado);

		assertEquals(idPedido, pedido.getIdPedido());
		assertEquals(cliente, pedido.getCliente());
		assertEquals(itemPedidos, pedido.getItemPedidos());
		assertEquals(direccionEntrega, pedido.getDireccionEntrega());
		assertEquals(totalPedido, pedido.getTotalPedido());
		assertEquals(estado, pedido.getEstado());
	}

	/**
	 * Prueba para verificar que los métodos setters y getters de la clase Pedido funcionan correctamente.
	 */
	@Test
	public void testPedidoSettersAndGetters() {
		Pedido pedido = new Pedido();
		Short iva = 19;

		Long idPedido = 1L;
		Cliente cliente = new Cliente(1L, "Juan Perez", 123456789L, "juan.perez@example.com", true);
		List<ItemPedido> itemPedidos = Arrays.asList(new ItemPedido(1L, 1L, null, 2, 100.0, 200.0, true));
		DireccionEntrega direccionEntrega = new DireccionEntrega("Antioquia","Medellin", "Robledo", "CR 80 65-89");
		TotalPedido totalPedido = new TotalPedido(200.0, iva, 20.0, 220.0);
		Boolean estado = true;

		pedido.setIdPedido(idPedido);
		pedido.setCliente(cliente);
		pedido.setItemPedidos(itemPedidos);
		pedido.setDireccionEntrega(direccionEntrega);
		pedido.setTotalPedido(totalPedido);
		pedido.setEstado(estado);

		assertEquals(idPedido, pedido.getIdPedido());
		assertEquals(cliente, pedido.getCliente());
		assertEquals(itemPedidos, pedido.getItemPedidos());
		assertEquals(direccionEntrega, pedido.getDireccionEntrega());
		assertEquals(totalPedido, pedido.getTotalPedido());
		assertEquals(estado, pedido.getEstado());
	}

}
