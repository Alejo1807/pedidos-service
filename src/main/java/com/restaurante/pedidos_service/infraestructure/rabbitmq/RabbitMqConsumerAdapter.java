package com.restaurante.pedidos_service.infraestructure.rabbitmq;

import com.restaurante.pedidos_service.application.ports.ConsumerPort;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class RabbitMqConsumerAdapter implements ConsumerPort {

    @Override
    public void listen(String queueName) {
        // No es necesario implementar en Spring Boot directamente,
        // usamos la anotación @RabbitListener en métodos.
    }

    @RabbitListener(queues = "DisponibilidadValidada")
    public void receiveMessage(String message) {
        System.out.println("[RabbitMQ] Mensaje recibido en DisponibilidadValidada: " + message);
        // Aquí procesas el mensaje
    }
}