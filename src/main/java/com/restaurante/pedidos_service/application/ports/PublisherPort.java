package com.restaurante.pedidos_service.application.ports;

public interface PublisherPort {
    void publish(String queueName, Object message);
}