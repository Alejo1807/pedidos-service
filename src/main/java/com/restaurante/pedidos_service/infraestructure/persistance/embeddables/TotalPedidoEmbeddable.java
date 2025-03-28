package com.restaurante.pedidos_service.infraestructure.persistance.embeddables;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Embeddable
@AllArgsConstructor
@NoArgsConstructor
public class TotalPedidoEmbeddable {

	//subtotal (valor antes de IVA)
	private Double subTotal;

	//Porcentaje de IVA a aplicar
	private Short porcentajeIVA;

	//Valor del IVA del pedido (porcentajeIVA * subTotal)
	private Double iva;

	//Valor Total a cobrar al cliente por el pedido
	private Double totalPedido;
}
