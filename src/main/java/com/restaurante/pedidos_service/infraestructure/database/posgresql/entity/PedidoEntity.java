package com.restaurante.pedidos_service.infraestructure.database.posgresql.entity;

import java.util.List;

import com.restaurante.pedidos_service.domain.entities.Cliente;
import com.restaurante.pedidos_service.domain.entities.ItemPedido;
import com.restaurante.pedidos_service.domain.valueobjects.DireccionEntrega;
import com.restaurante.pedidos_service.domain.valueobjects.TotalPedido;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;

@Entity
@Table(name="pedidos")
@Data
@AllArgsConstructor
public class PedidoEntity {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	private Long idPedido;

	private Cliente cliente;

	private List<ItemPedido> itemPedidos; 

	private DireccionEntrega direccionEntrega;
	
	private TotalPedido totalPedido;

}
