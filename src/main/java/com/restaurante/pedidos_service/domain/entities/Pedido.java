package com.restaurante.pedidos_service.domain.entities;

import java.util.List;

import com.restaurante.pedidos_service.domain.valueobjects.DireccionEntrega;
import com.restaurante.pedidos_service.domain.valueobjects.TotalPedido;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Pedido {

	private Long idPedido;

	private Cliente cliente;

	private List<ItemPedido> itemPedidos; 

	private DireccionEntrega direccionEntrega;
	
	private TotalPedido totalPedido;
}
