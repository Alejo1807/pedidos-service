package com.restaurante.pedidos_service.infraestructure.persistance.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Builder
@Table(name="ITEMS_PEDIDOS")
@AllArgsConstructor
@NoArgsConstructor
public class ItemPedidoEntity {

	//Identificador único del item del pedido
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long idItemPedido;

	//Identificar único de la receta que viene asociada al item,
	//este ID se integra con el módulo de inventarios
	private Long idReceta;
	
	//Pedido al cual está asociado el item
	@ManyToOne
	@JoinColumn(name = "id_pedido", nullable = false)
	@JsonBackReference
	private PedidoEntity pedido;

	//Cantidad de unidades del item que se van a agregar al pedido (valor no nulo mayor a cero)
	@NotNull
	@Min(value = 0)
	private Integer cantidad;

	//Precio que maneja el item del pedido al momento de ser adquirido
	@NotNull
	@Min(value = 0)
	private Double valor;

	//Valor total item (cantidad * valor)
	@NotNull
	@Min(value = 0)
	private Double totalItem;
	
	//Estado que representa si el item está activo (True) o anulado (False)
	@Builder.Default
	private Boolean estado = true;
	
}
