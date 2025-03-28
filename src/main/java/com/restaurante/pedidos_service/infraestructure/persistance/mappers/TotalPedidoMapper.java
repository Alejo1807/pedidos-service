package com.restaurante.pedidos_service.infraestructure.persistance.mappers;

import com.restaurante.pedidos_service.domain.valueobjects.TotalPedido;
import com.restaurante.pedidos_service.infraestructure.persistance.embeddables.TotalPedidoEmbeddable;

/**
 * Mapeador que para la conversión entre objeto de valor Total Pedido de dominio e infraestructura
 * @author Usuario
 *
 */
public class TotalPedidoMapper {
	
	/**
	 * Convierte un objeto de valor de TotalPedido del dominio a una de infraestructura
	 * @param totalPedido
	 * @return entidad TotalPedidoEmbeddable mapeada
	 */
	public static TotalPedidoEmbeddable fromTotalPedidoToTotalPedidoEmbeddable(TotalPedido totalPedido) {
		return new TotalPedidoEmbeddable(
				totalPedido.getSubTotal(),
				totalPedido.getPorcentajeIVA(),
				totalPedido.getIva(),
				totalPedido.getTotalPedido()
				);	
	}
	
	/**
	 * Convierte un objeto de valor de TotalPedido de infraestructura a una de dominio
	 * @param totalPedidoEmbeddable
	 * @return entidad TotalPedido mapeada
	 */
	public static TotalPedido fromTotalPedidoEmbeddableToTotalPedido(TotalPedidoEmbeddable totalPedidoEmbeddable) {
		return new TotalPedido(
				totalPedidoEmbeddable.getSubTotal(),
				totalPedidoEmbeddable.getPorcentajeIVA(),
				totalPedidoEmbeddable.getIva(),
				totalPedidoEmbeddable.getTotalPedido()
				);
	}
}
