package com.restaurante.pedidos_service.domain.valueobjects;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Clase que represente los totales y subtotales a ser facturados en el pedido
 * @author Usuario
 *
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TotalPedido implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	//subtotal (valor antes de IVA)
	private Double subTotal;

	//Porcentaje de IVA a aplicar
	private Short porcentajeIVA;

	//Valor del IVA del pedido (porcentajeIVA * subTotal)
	private Double iva;

	//Valor Total a cobrar al cliente por el pedido
	private Double totalPedido;
}
