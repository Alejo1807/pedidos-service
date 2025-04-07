package com.restaurante.pedidos_service.Infraestructure.mappers;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.restaurante.pedidos_service.domain.valueobjects.DireccionEntrega;
import com.restaurante.pedidos_service.infraestructure.persistance.embeddables.DireccionEntregaEmbeddable;
import com.restaurante.pedidos_service.infraestructure.persistance.mappers.DireccionEntregaMapper;

/**
 * Clase de prueba para el mapeador DireccionEntregaMapper.
 */
public class DireccionEntregaMapperTest {

	/**
	DireccionEntregaEmbeddable.
	 */
	@Test
	public void testFromDireccionEntregaToDireccionEntregaEmbeddable() {
		DireccionEntrega direccionEntrega = new DireccionEntrega("Antioquia", "Medellín", "El Poblado", "Calle 10 # 20-30");
		DireccionEntregaEmbeddable direccionEntregaEmbeddable = DireccionEntregaMapper.fromDireccionEntregaToDireccionEntregaEmbeddable(direccionEntrega);

		assertEquals(direccionEntrega.getDepartamento(), direccionEntregaEmbeddable.getDepartamento());
		assertEquals(direccionEntrega.getMunicipio(), direccionEntregaEmbeddable.getMunicipio());
		assertEquals(direccionEntrega.getBarrio(), direccionEntregaEmbeddable.getBarrio());
		assertEquals(direccionEntrega.getDireccion(), direccionEntregaEmbeddable.getDireccion());
	}

	/**
	 * Prueba para verificar la conversión de DireccionEntregaEmbeddable a DireccionEntrega.
	 */
	@Test
	public void testFromDireccionEntregaEmbeddableToDireccionEntrega() {
		DireccionEntregaEmbeddable direccionEntregaEmbeddable = new DireccionEntregaEmbeddable("Antioquia", "Medellín", "El Poblado", "Calle 10 # 20-30");
		DireccionEntrega direccionEntrega = DireccionEntregaMapper.fromDireccionEntregaEmbeddableToDireccionEntrega(direccionEntregaEmbeddable);

		assertEquals(direccionEntregaEmbeddable.getDepartamento(), direccionEntrega.getDepartamento());
		assertEquals(direccionEntregaEmbeddable.getMunicipio(), direccionEntrega.getMunicipio());
		assertEquals(direccionEntregaEmbeddable.getBarrio(), direccionEntrega.getBarrio());
		assertEquals(direccionEntregaEmbeddable.getDireccion(), direccionEntrega.getDireccion());
	}
}
