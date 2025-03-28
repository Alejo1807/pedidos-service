package com.restaurante.pedidos_service.domain.entities;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * 
 * Clase que representa un item de un pedido del negocio
 *
 */
@Data
@AllArgsConstructor
public class ItemPedido {

	//Identificador único del item del pedido
	private Long idItemPedido;

	//Identificar único de la receta que viene asociada al item,
	//este ID se integra con el módulo de inventarios
	private Long idReceta;
	
	//Pedido al cual está asociado el item
	private Pedido pedido;

	//Cantidad de unidades del item que se van a agregar al pedido (valor no nulo mayor a cero)
	private Integer cantidad;

	//Precio que maneja el item del pedido al momento de ser adquirido
	private Double valor;

	//Valor total item (cantidad * valor)
	private Double totalItem;
	
	//Estado que representa si el item está activo (True) o anulado (False)
	private Boolean estado;

}
