package com.restaurante.pedidos_service.domain.entities;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Set;

import org.junit.jupiter.api.Test;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;

/**
 * Clase de prueba para la entidad Cliente.
 */

public class ClienteTest {

	/**
	 * Prueba para verificar que el constructor de la clase Cliente inicializa correctamente los atributos.
	 */
	@Test
	public void testClienteConstructor() {
		Long idCliente = 1L;
		String nombreCliente = "Juan Perez";
		Long nit = 123456789L;
		String email = "juan.perez@example.com";
		Boolean estado = true;

		Cliente cliente = new Cliente(idCliente, nombreCliente, nit, email, estado);

		assertEquals(idCliente, cliente.getIdCliente());
		assertEquals(nombreCliente, cliente.getNombreCliente());
		assertEquals(nit, cliente.getNit());
		assertEquals(email, cliente.getEmail());
		assertEquals(estado, cliente.getEstado());
	}


	/**
	 * Prueba para verificar que los métodos setters y getters de la clase Cliente funcionan correctamente.
	 */
	@Test
	public void testClienteSettersAndGetters() {
		Cliente cliente = new Cliente();

		cliente.setIdCliente(1L);
		cliente.setNombreCliente("Juan Perez");
		cliente.setNit(123456789L);
		cliente.setEmail("juan.perez@example.com");
		cliente.setEstado(true);

		assertEquals(1L, cliente.getIdCliente());
		assertEquals("Juan Perez", cliente.getNombreCliente());
		assertEquals(123456789L, cliente.getNit());
		assertEquals("juan.perez@example.com", cliente.getEmail());
		assertEquals(true, cliente.getEstado());
	}

	/**
	 * Prueba para verificar que las anotaciones de validación (@NotEmpty, @NotNull) funcionan correctamente.
	 */
	@Test
	public void testClienteValidation() {
		Cliente cliente = new Cliente();

		// Configurar valores inválidos para la validación
		cliente.setNombreCliente("");
		cliente.setNit(null);
		cliente.setEmail("");

		// Crear el validador
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		Validator validator = factory.getValidator();

		// Ejecutar la validación y verificar que se lanzan las violaciones de restricciones
		Set<ConstraintViolation<Cliente>> violations = validator.validate(cliente);
		assertFalse(violations.isEmpty(), "Expected validation errors but none were found");

		// Verificar que se lanza ConstraintViolationException si hay violaciones
		assertThrows(ConstraintViolationException.class, () -> {
			if (!violations.isEmpty()) {
				throw new ConstraintViolationException(violations);
			}
		});
	}

}

