package com.restaurante.pedidos_service.infraestructure.persistance.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.restaurante.pedidos_service.infraestructure.persistance.entities.ClienteEntity;

public interface ClienteRepositoryJPA extends JpaRepository<ClienteEntity, Long> {

}
