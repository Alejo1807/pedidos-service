package com.restaurante.pedidos_service.Infraestructure.entities;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.restaurante.pedidos_service.infraestructure.persistance.entities.ClienteEntity;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;


/**
 * Clase de prueba para la entidad ClienteEntity.
 */
public class ClienteEntityTest {

	private Validator validator;

	@BeforeEach
	public void setUp() {
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		this.validator = factory.getValidator();
	}

	/**
	 * Prueba para verificar que el constructor de la clase ClienteEntity inicializa correctamente los atributos.
	 */
	@Test
	public void testClienteEntityConstructor() {
		Long idCliente = 1L;
		String nombreCliente = "Juan Perez";
		Long nit = 123456789L;
		String email = "juan.perez@example.com";
		Boolean estado = true;

		ClienteEntity clienteEntity = new ClienteEntity(idCliente, nombreCliente, nit, email, estado);

		assertEquals(idCliente, clienteEntity.getIdCliente());
		assertEquals(nombreCliente, clienteEntity.getNombreCliente());
		assertEquals(nit, clienteEntity.getNit());
		assertEquals(email, clienteEntity.getEmail());
		assertEquals(estado, clienteEntity.getEstado());
	}

	/**
	 * Prueba para verificar que los métodos setters y getters de la clase ClienteEntity funcionan correctamente.
	 */
	@Test
	public void testClienteEntitySettersAndGetters() {
		ClienteEntity clienteEntity = new ClienteEntity();

		Long idCliente = 1L;
		String nombreCliente = "Juan Perez";
		Long nit = 123456789L;
		String email = "juan.perez@example.com";
		Boolean estado = true;

		clienteEntity.setIdCliente(idCliente);
		clienteEntity.setNombreCliente(nombreCliente);
		clienteEntity.setNit(nit);
		clienteEntity.setEmail(email);
		clienteEntity.setEstado(estado);

		assertEquals(idCliente, clienteEntity.getIdCliente());
		assertEquals(nombreCliente, clienteEntity.getNombreCliente());
		assertEquals(nit, clienteEntity.getNit());
		assertEquals(email, clienteEntity.getEmail());
		assertEquals(estado, clienteEntity.getEstado());
	}


	/**
	 * Prueba para verificar que las anotaciones de validación (@NotEmpty, @NotNull) funcionan correctamente.
	 */
	@Test
	public void testClienteEntityValidation() {
		ClienteEntity clienteEntity = new ClienteEntity();

		// Configurar valores inválidos para la validación
		clienteEntity.setNombreCliente("");
		clienteEntity.setNit(null);
		clienteEntity.setEmail("");

		// Ejecutar la validación y verificar que se lanzan las violaciones de restricciones
		Set<ConstraintViolation<ClienteEntity>> violations = validator.validate(clienteEntity);
		assertFalse(violations.isEmpty(), "Expected validation errors but none were found");

		// Verificar detalles de las violaciones
		for (ConstraintViolation<ClienteEntity> violation : violations) {
			System.out.println(violation.getPropertyPath() + ": " + violation.getMessage());
		}
	}
}
