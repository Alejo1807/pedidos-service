package com.restaurante.pedidos_service.infraestructure.controllers;

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

import com.restaurante.pedidos_service.application.usecase.cliente.FindClienteUseCase;
import com.restaurante.pedidos_service.application.usecase.cliente.SaveClienteUseCase;
import com.restaurante.pedidos_service.application.usecase.cliente.UpdateClienteUseCase;
import com.restaurante.pedidos_service.domain.entities.Cliente;

@RestController
@RequestMapping("api/clientes")
public class ClienteController {

	@Autowired
	FindClienteUseCase findClienteUseCase;

	@Autowired
	SaveClienteUseCase saveClienteUseCase;

	@Autowired
	UpdateClienteUseCase updateClienteUseCase;

	@GetMapping("/{idCliente}")
	public ResponseEntity<Cliente> findById(@PathVariable("idCliente") Long idCliente) {
		Optional<Cliente> clienteOptional = findClienteUseCase.findById(idCliente);
		if (clienteOptional.isPresent()) {
			return ResponseEntity.ok(clienteOptional.get());
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@PostMapping
	public ResponseEntity<Cliente> save(@RequestBody Cliente cliente) {
		return ResponseEntity.ok(saveClienteUseCase.save(cliente));
	}

	@PutMapping
	public ResponseEntity<Cliente> update(@RequestBody Cliente cliente) {
		return ResponseEntity.ok(updateClienteUseCase.update(cliente).get());
	}

}
