package com.restaurante.pedidos_service.infraestructure.persistance.adapters;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.restaurante.pedidos_service.domain.entities.Pedido;
import com.restaurante.pedidos_service.domain.ports.PedidoRepositoryPort;
import com.restaurante.pedidos_service.infraestructure.persistance.entities.ItemPedidoEntity;
import com.restaurante.pedidos_service.infraestructure.persistance.entities.PedidoEntity;
import com.restaurante.pedidos_service.infraestructure.persistance.mappers.PedidoMapper;
import com.restaurante.pedidos_service.infraestructure.persistance.repositories.PedidoRepositoryJPA;

import lombok.Data;

@Data
@Component
public class PedidoRepositoryAdapter implements PedidoRepositoryPort {

	@Autowired
	PedidoRepositoryJPA pedidoRepositoryJPA; 

	@Override
	@Transactional
	public Pedido save(Pedido pedido) {

		PedidoEntity pedidoEntity = PedidoMapper.fromPedidoToPedidoEntity(pedido);
		
		for(ItemPedidoEntity itemPedidoEntity: pedidoEntity.getItemsPedidos()) {
			itemPedidoEntity.setPedido(pedidoEntity);
		}

		return PedidoMapper.fromPedidoEntityToPedido(pedidoRepositoryJPA.save(pedidoEntity));
	}

	@Override
	@Transactional(readOnly=true)
	public Optional<Pedido> findById(Long idPedido) {

		Optional<PedidoEntity> pedidoEntityOptional = pedidoRepositoryJPA.findById(idPedido);

		if (pedidoEntityOptional.isPresent()) {
			Pedido pedido = PedidoMapper.fromPedidoEntityToPedido(pedidoEntityOptional.get());
			return Optional.of(pedido);
		} else {
			return Optional.empty();
		}
	}

	@Override
	@Transactional(readOnly=true)
	public List<Pedido> findAll() {
		return pedidoRepositoryJPA.findAll().stream()
				.map(PedidoMapper::fromPedidoEntityToPedido)
				.collect(Collectors.toList());
	}

	@Override
	@Transactional
	public Optional<Pedido> upDate(Pedido pedido) {
		Optional<PedidoEntity> pedidoEntityOptional = pedidoRepositoryJPA.findById(pedido.getIdPedido());

		if (pedidoEntityOptional.isPresent()) {
			PedidoEntity pedidoEntity = PedidoMapper.fromPedidoToPedidoEntity(pedido);

			PedidoEntity updatedPedidoEntity = pedidoRepositoryJPA.save(pedidoEntity);
			Pedido updatedPedido = PedidoMapper.fromPedidoEntityToPedido(updatedPedidoEntity);
			return Optional.of(updatedPedido);
		} else {
			return Optional.empty();
		}
	}

}
