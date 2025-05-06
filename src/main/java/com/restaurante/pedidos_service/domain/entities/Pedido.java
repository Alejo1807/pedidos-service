package com.restaurante.pedidos_service.domain.entities;

import java.io.Serializable;
import java.util.List;

import com.restaurante.pedidos_service.domain.valueobjects.DireccionEntrega;
import com.restaurante.pedidos_service.domain.valueobjects.TotalPedido;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Clase que representa un Pedido del negocio
 * 
 * @author Usuario
 *
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Pedido implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	//Identificador único del Pedido
	private Long idPedido;

	//Entidad Cliente para el cual va dirigido el Pedido
	private Cliente cliente;

	//Lista de items agregados al Pedido
	private List<ItemPedido> itemPedidos; 

	//Valor agregado: Dirección de entrega del Pedido
	private DireccionEntrega direccionEntrega;

	//Valor agregado: detalle del factura y valor total a cobrar por impuestos que apliquen
	private TotalPedido totalPedido;
	
	//Estado que representa si el pedido está activo (True) o anulado (False)
	private Boolean estado;
}
