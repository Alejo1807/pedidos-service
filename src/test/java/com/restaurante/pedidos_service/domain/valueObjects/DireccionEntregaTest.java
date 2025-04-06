package com.restaurante.pedidos_service.domain.valueObjects;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.restaurante.pedidos_service.domain.valueobjects.DireccionEntrega;

/**
 * Clase de prueba para la entidad DireccionEntrega.
 */
public class DireccionEntregaTest {
	/**
	 * Prueba para verificar que el constructor de la clase DireccionEntrega inicializa correctamente los atributos.
	 */
	@Test
	public void testDireccionEntregaConstructor() {
		String departamento = "Antioquia";
		String municipio = "Medellín";
		String barrio = "El Poblado";
		String direccion = "Calle 10 # 20-30";

		DireccionEntrega direccionEntrega = new DireccionEntrega(departamento, municipio, barrio, direccion);

		assertEquals(departamento, direccionEntrega.getDepartamento());
		assertEquals(municipio, direccionEntrega.getMunicipio());
		assertEquals(barrio, direccionEntrega.getBarrio());
		assertEquals(direccion, direccionEntrega.getDireccion());
	}

	/**
	 * Prueba para verificar que los métodos setters y getters de la clase DireccionEntrega funcionan correctamente.
	 */
	@Test
	public void testDireccionEntregaSettersAndGetters() {
		DireccionEntrega direccionEntrega = new DireccionEntrega();

		String departamento = "Antioquia";
		String municipio = "Medellín";
		String barrio = "El Poblado";
		String direccion = "Calle 10 # 20-30";

		direccionEntrega.setDepartamento(departamento);
		direccionEntrega.setMunicipio(municipio);
		direccionEntrega.setBarrio(barrio);
		direccionEntrega.setDireccion(direccion);

		assertEquals(departamento, direccionEntrega.getDepartamento());
		assertEquals(municipio, direccionEntrega.getMunicipio());
		assertEquals(barrio, direccionEntrega.getBarrio());
		assertEquals(direccion, direccionEntrega.getDireccion());
	}

}
