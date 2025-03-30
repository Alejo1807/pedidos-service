package com.restaurante.pedidos_service.infraestructure.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.restaurante.pedidos_service.application.usecase.pedido.FindPedidoUseCase;
import com.restaurante.pedidos_service.application.usecase.pedido.SavePedidoUseCase;
import com.restaurante.pedidos_service.application.usecase.pedido.UpdatePedidoUseCase;
import com.restaurante.pedidos_service.domain.entities.Pedido;

@RestController
@RequestMapping("api/pedidos")
public class PedidoController {

	@Autowired
	SavePedidoUseCase savePedido;

	@Autowired
	FindPedidoUseCase findPedidoUseCase;

	@Autowired
	UpdatePedidoUseCase updatePedidoUseCase; 

	@GetMapping("/list-all")
	public List<Pedido> findAll(){
		return findPedidoUseCase.findAll();
	}

	@GetMapping("/{idPedido}")
	public ResponseEntity<Pedido> findById(@PathVariable("idPedido") Long idPedido) {
		Optional<Pedido> pedidoOptional = findPedidoUseCase.findById(idPedido);
		if (pedidoOptional.isPresent()) {
			return ResponseEntity.ok(pedidoOptional.get());
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@PostMapping("")
	public Pedido save(@RequestBody Pedido pedido) {
		return savePedido.save(pedido);
	}

	@PutMapping("/")
	public Pedido update(@RequestBody Pedido pedido) {
		return updatePedidoUseCase.update(pedido).get();
	}


}
