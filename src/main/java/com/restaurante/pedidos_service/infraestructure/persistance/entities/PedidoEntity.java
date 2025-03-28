package com.restaurante.pedidos_service.infraestructure.persistance.entities;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.restaurante.pedidos_service.infraestructure.persistance.embeddables.DireccionEntregaEmbeddable;
import com.restaurante.pedidos_service.infraestructure.persistance.embeddables.TotalPedidoEmbeddable;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.AttributeOverrides;
import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Entidad que representa los pedidos que serán persistidos en base de datos
 * @author Usuario
 *
 */
@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name="pedidos")
public class PedidoEntity {

	//Identificador único de la entidad
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long idPedido;

	//Relación de pedido con el cliente que hace el pedido
	@ManyToOne
	@JoinColumn(name = "id_cliente", nullable = false)
	private ClienteEntity cliente;

	//Relación del pedido con los items que contiene
	@OneToMany(mappedBy = "pedido")
	@JsonManagedReference
	private List<ItemPedidoEntity> itemsPedidos; 

	//Objeto de valor embebido que representa la dirección de entrega del pedido
	@Embedded
	@AttributeOverrides({
		@AttributeOverride( name = "departamento", column = @Column(name = "departamento")),
		@AttributeOverride( name = "municipio", column = @Column(name = "municipio")),
		@AttributeOverride( name = "barrio", column = @Column(name = "barrio")),
		@AttributeOverride( name = "direccion", column = @Column(name = "direccion"))
	})
	private DireccionEntregaEmbeddable direccionEntrega;

	//Objeto de valor embebido que representa el detalle de totales del pedido
	@Embedded
	@AttributeOverrides({
		@AttributeOverride( name = "subTotal", column = @Column(name = "subTotal")),
		@AttributeOverride( name = "porcentajeIVA", column = @Column(name = "porcentajeIVA")),
		@AttributeOverride( name = "iva", column = @Column(name = "iva")),
		@AttributeOverride( name = "totalPedido", column = @Column(name = "totalPedido"))
	})
	private TotalPedidoEmbeddable totalPedido;

	//Estado que representa si el cliente está Activo (True) o Inactivo (False)
	@Builder.Default
	private Boolean estado = true;

}
