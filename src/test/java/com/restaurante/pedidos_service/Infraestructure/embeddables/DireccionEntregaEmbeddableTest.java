package com.restaurante.pedidos_service.Infraestructure.embeddables;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.restaurante.pedidos_service.infraestructure.persistance.embeddables.DireccionEntregaEmbeddable;

/**
 * Clase de prueba para la entidad embebida DireccionEntregaEmbeddable.
 */
public class DireccionEntregaEmbeddableTest {

	/**
	 * Prueba para verificar que el constructor de la clase DireccionEntregaEmbeddable inicializa correctamente los atributos.
	 */
	@Test
	public void testDireccionEntregaEmbeddableConstructor() {
		String departamento = "Antioquia";
		String municipio = "Medellín";
		String barrio = "El Poblado";
		String direccion = "Calle 10 # 20-30";

		DireccionEntregaEmbeddable direccionEntrega = new DireccionEntregaEmbeddable(departamento, municipio, barrio, direccion);

		assertEquals(departamento, direccionEntrega.getDepartamento());
		assertEquals(municipio, direccionEntrega.getMunicipio());
		assertEquals(barrio, direccionEntrega.getBarrio());
		assertEquals(direccion, direccionEntrega.getDireccion());
	}

	/**
	 * Prueba para verificar que los métodos setters y getters de la clase DireccionEntregaEmbeddable funcionan correctamente.
	 */
	@Test
	public void testDireccionEntregaEmbeddableSettersAndGetters() {
		DireccionEntregaEmbeddable direccionEntrega = new DireccionEntregaEmbeddable();

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
