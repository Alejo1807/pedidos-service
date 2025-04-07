package com.restaurante.pedidos_service.infraestructure.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

import com.restaurante.pedidos_service.application.usecase.cliente.FindClienteUseCase;
import com.restaurante.pedidos_service.application.usecase.cliente.SaveClienteUseCase;
import com.restaurante.pedidos_service.application.usecase.cliente.UpdateClienteUseCase;
import com.restaurante.pedidos_service.domain.entities.Cliente;

@RestController
@RequestMapping("api/clientes")
@Tag(name = "Clientes", description = "Operaciones relacionadas con los clientes del restaurante")
public class ClienteController {

	@Autowired
	FindClienteUseCase findClienteUseCase;

	@Autowired
	SaveClienteUseCase saveClienteUseCase;

	@Autowired
	UpdateClienteUseCase updateClienteUseCase;

	@GetMapping("/{idCliente}")
	@Operation(summary = "Buscar cliente por ID", description = "Obtiene los detalles de un cliente a partir de su ID")
	public ResponseEntity<Cliente> findById(@PathVariable("idCliente") Long idCliente) {
		try {
			Optional<Cliente> clienteOptional = findClienteUseCase.findById(idCliente);
			return clienteOptional.map(ResponseEntity::ok)
					.orElseGet(() -> ResponseEntity.notFound().build());
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
		}
	}

	@PostMapping
	@Operation(summary = "Guardar un nuevo cliente", description = "Registra un nuevo cliente en la base de datos")
	public ResponseEntity<Cliente> save(@RequestBody Cliente cliente) {
		try {
			return ResponseEntity.ok(saveClienteUseCase.save(cliente));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
		}
	}

	@PutMapping
	@Operation(summary = "Actualizar cliente", description = "Modifica los datos de un cliente existente")
	public ResponseEntity<Cliente> update(@RequestBody Cliente cliente) {
		try {
			Optional<Cliente> updatedCliente = updateClienteUseCase.update(cliente);
			return updatedCliente.map(ResponseEntity::ok)
					.orElseGet(() -> ResponseEntity.notFound().build());
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
		}
	}
}
