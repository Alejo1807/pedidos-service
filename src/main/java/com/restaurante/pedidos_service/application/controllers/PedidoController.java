package com.restaurante.pedidos_service.application.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.restaurante.pedidos_service.application.usecase.ISavePedido;
import com.restaurante.pedidos_service.domain.entities.Pedido;

@RestController
@RequestMapping("api/pedidos")
public class PedidoController {
	
	@Autowired
	ISavePedido savePedido;
	
	@PostMapping("/")
	public Pedido save(@RequestBody Pedido pedido) {
		return savePedido.save(pedido);
	}
}
