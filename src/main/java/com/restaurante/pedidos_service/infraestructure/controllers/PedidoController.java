package com.restaurante.pedidos_service.infraestructure.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

import com.restaurante.pedidos_service.application.usecase.pedido.FindPedidoUseCase;
import com.restaurante.pedidos_service.application.usecase.pedido.SavePedidoUseCase;
import com.restaurante.pedidos_service.application.usecase.pedido.UpdatePedidoUseCase;
import com.restaurante.pedidos_service.domain.entities.Pedido;

@RestController
@RequestMapping("api/pedidos")
@Tag(name = "Pedidos", description = "Operaciones sobre los pedidos del restaurante")
public class PedidoController {

	@Autowired
	SavePedidoUseCase savePedido;

	@Autowired
	FindPedidoUseCase findPedidoUseCase;

	@Autowired
	UpdatePedidoUseCase updatePedidoUseCase;

	@GetMapping("/list-all")
	@Operation(summary = "Obtener todos los pedidos", description = "Devuelve la lista de todos los pedidos registrados")
	public List<Pedido> findAll() {
		return findPedidoUseCase.findAll();
	}

	@GetMapping("/{idPedido}")
	@Operation(summary = "Obtener pedido por ID", description = "Devuelve los detalles de un pedido según su ID")
	public ResponseEntity<Pedido> findById(@PathVariable("idPedido") Long idPedido) {
		Optional<Pedido> pedidoOptional = findPedidoUseCase.findById(idPedido);
		return pedidoOptional.map(ResponseEntity::ok)
				.orElseGet(() -> ResponseEntity.notFound().build());
	}

	@PostMapping
	@Operation(summary = "Crear un nuevo pedido", description = "Registra un nuevo pedido en la base de datos")
	public ResponseEntity<Pedido> save(@RequestBody Pedido pedido) {
		return ResponseEntity.ok(savePedido.save(pedido));
	}

	@PutMapping
	@Operation(summary = "Actualizar un pedido", description = "Modifica la información de un pedido existente")
	public ResponseEntity<Pedido> update(@RequestBody Pedido pedido) {
		return ResponseEntity.ok(updatePedidoUseCase.update(pedido).get());
	}
}
