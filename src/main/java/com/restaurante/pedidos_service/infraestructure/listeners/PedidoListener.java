package com.restaurante.pedidos_service.infraestructure.listeners;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.restaurante.pedidos_service.domain.entities.Pedido;

@Component
public class PedidoListener {	
	
	//@Autowired
    //private RabbitTemplate rabbitTemplate;
	
	@RabbitListener(queues = "PedidoCreado")
    public void recibirPedido(Pedido pedido) {
        System.out.println("📦 Pedido recibido: " + pedido);

        // Publicar mensaje para validar la disponibilidad de inventario
       // rabbitTemplate.convertAndSend("disponibilidad.exchange", "disponibilidad.validada", pedido);
    }

}
