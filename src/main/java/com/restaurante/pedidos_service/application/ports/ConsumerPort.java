package com.restaurante.pedidos_service.application.ports;

public interface ConsumerPort {
    void listen(String queueName);
}