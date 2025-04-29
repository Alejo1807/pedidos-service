package com.restaurante.pedidos_service.infraestructure.rabbitmq;

import com.restaurante.pedidos_service.application.ports.PublisherPort;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@Service
public class RabbitMqPublisherAdapter implements PublisherPort {

    private final RabbitTemplate rabbitTemplate;

    public RabbitMqPublisherAdapter(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    @Override
    public void publish(String queueName, Object message) {
        rabbitTemplate.convertAndSend(queueName, message);
        System.out.println("[RabbitMQ] Mensaje publicado en " + queueName);
    }
}