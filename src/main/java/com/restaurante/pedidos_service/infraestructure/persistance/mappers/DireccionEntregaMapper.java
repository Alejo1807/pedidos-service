package com.restaurante.pedidos_service.infraestructure.persistance.mappers;

import com.restaurante.pedidos_service.domain.valueobjects.DireccionEntrega;
import com.restaurante.pedidos_service.infraestructure.persistance.embeddables.DireccionEntregaEmbeddable;

/**
 * Mapeador que para la conversión entre objeto de valor Dirección de entrega de dominio e infraestructura
 * @author Usuario
 *
 */
public class DireccionEntregaMapper {
	
	/**
	 * Convierte una entidad de DireccionEntrega del dominio a una de infraestructura
	 * @param direccionEntrega
	 * @return entidad DireccionEntregaEmbeddable mapeada
	 */
	public static DireccionEntregaEmbeddable fromDireccionEntregaToDireccionEntregaEmbeddable(DireccionEntrega direccionEntrega) {
		return new DireccionEntregaEmbeddable(
				direccionEntrega.getDepartamento(),
				direccionEntrega.getMunicipio(),
				direccionEntrega.getBarrio(),
				direccionEntrega.getDireccion()
				);		
	}
	
	/**
	 * Convierte una entidad de DireccionEntrega de infraestructura a una de dominio
	 * @param direccionEntregaEmbeddable
	 * @return entidad DireccionEntrega mapeada
	 */
	public static DireccionEntrega fromDireccionEntregaEmbeddableToDireccionEntrega(DireccionEntregaEmbeddable direccionEntregaEmbeddable) {
		return new DireccionEntrega(
				direccionEntregaEmbeddable.getDepartamento(),
				direccionEntregaEmbeddable.getMunicipio(),
				direccionEntregaEmbeddable.getBarrio(),
				direccionEntregaEmbeddable.getDireccion());
	}
}
