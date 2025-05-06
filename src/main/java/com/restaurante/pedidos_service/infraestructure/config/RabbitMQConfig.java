package com.restaurante.pedidos_service.infraestructure.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

    @Bean
    public Queue validateOrderQueue() {
        return new Queue("PedidoCreado", true);
    }

    @Bean
    public DirectExchange pedidoExchange() {
        return new DirectExchange("pedido.exchange");
    }

    @Bean
    public Binding pedidoCreadoBinding() {
        return BindingBuilder
            .bind(validateOrderQueue())
            .to(pedidoExchange())
            .with("pedido.creado");
    }
    
    @Bean
    public Queue validateAvailabilityQueue() {
    	return new Queue("DisponibilidadValidada", true); // Cola de pedidos para validar
    }
    
    @Bean
    public DirectExchange disponibilidadExchange() {
        return new DirectExchange("disponibilidad.exchange");
    }

    @Bean
    public Binding disponibilidadBinding() {
        return BindingBuilder
            .bind(validateAvailabilityQueue())
            .to(disponibilidadExchange())
            .with("disponibilidad.validada");
    }
    
    @Bean
    public Queue inventoryRefreshQueue() {
        return new Queue("InventarioActualizado", true); // Cola de respuesta
    }

    @Bean
    public MessageConverter jsonMessageConverter() {
        return new Jackson2JsonMessageConverter();
    }

    @Bean
    public RabbitTemplate rabbitTemplate(ConnectionFactory connectionFactory) {
        RabbitTemplate template = new RabbitTemplate(connectionFactory);
        template.setMessageConverter(jsonMessageConverter());
        return template;
    }
}