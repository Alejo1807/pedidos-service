package com.restaurante.pedidos_service.config;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

    @Bean
    public Queue validateOrderQueue() {
        return new Queue("PedidoCreado", true); // Cola de pedidos para validar
    }

    @Bean
    public Queue validateAvailabilityQueue() {
        return new Queue("DisponibilidadValidada", true); // Cola de pedidos para validar
    }

    @Bean
    public Queue inventoryRefreshQueue() {
        return new Queue("InventarioActualizado", true); // Cola de respuesta
    }
    
}