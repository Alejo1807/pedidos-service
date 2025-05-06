package com.restaurante.pedidos_service.config;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;

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

    @Bean
	public RabbitTemplate rabbitTemplate(ConnectionFactory connectionFactory) {
		return new RabbitTemplate(connectionFactory);
	}
    
}