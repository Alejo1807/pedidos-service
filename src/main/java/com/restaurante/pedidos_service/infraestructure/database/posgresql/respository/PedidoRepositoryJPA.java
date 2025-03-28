package com.restaurante.pedidos_service.infraestructure.database.posgresql.respository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.restaurante.pedidos_service.infraestructure.database.posgresql.entity.PedidoEntity;

public interface PedidoRepositoryJPA extends JpaRepository<PedidoEntity, Long> {

}
