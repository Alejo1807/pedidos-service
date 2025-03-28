package com.restaurante.pedidos_service.infraestructure.database.posgresql.adapter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.restaurante.pedidos_service.domain.entities.Pedido;
import com.restaurante.pedidos_service.domain.repositories.PedidoRepositoryPort;
import com.restaurante.pedidos_service.infraestructure.database.posgresql.entity.PedidoEntity;
import com.restaurante.pedidos_service.infraestructure.database.posgresql.mapper.PedidoMapper;
import com.restaurante.pedidos_service.infraestructure.database.posgresql.respository.PedidoRepositoryJPA;

import lombok.Data;

@Data
@Component
public class PedidoRepositoryAdapter implements PedidoRepositoryPort {

	@Autowired
	PedidoRepositoryJPA pedidoRepositoryJPA; 
	
	@Override
	public Pedido save(Pedido pedido) {
		
		PedidoEntity pedidoEntity = PedidoMapper.fromPedidoToPedidoEntity(pedido);
		
		return PedidoMapper.fromPedidoEntityToPedido(pedidoRepositoryJPA.save(pedidoEntity));
	}
	
}
