package com.restaurante.pedidos_service.infraestructure.persistance.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.restaurante.pedidos_service.infraestructure.persistance.entities.PedidoEntity;

public interface PedidoRepositoryJPA extends JpaRepository<PedidoEntity, Long> {

}
