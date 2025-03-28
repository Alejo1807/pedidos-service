package com.restaurante.pedidos_service.domain.entities;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class ItemPedido {

	private Long idItemPedido;

	private String nombre;

	@NotNull
	@Min(value = 0)
	private Integer cantidad;

	@NotNull
	@Min(value = 0)
	private Double valor;

}
