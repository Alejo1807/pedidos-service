package com.restaurante.pedidos_service.infraestructure.persistance.mappers;

import com.restaurante.pedidos_service.domain.entities.ItemPedido;
import com.restaurante.pedidos_service.domain.entities.Pedido;
import com.restaurante.pedidos_service.infraestructure.persistance.entities.ItemPedidoEntity;
import com.restaurante.pedidos_service.infraestructure.persistance.entities.PedidoEntity;

/**
 * Mapeador que para la conversión entre entidades Item de Pedido de dominio e infraestructura
 * @author Usuario
 *
 */
public class ItemPedidoMapper {



	/**
	 * Convierte una entidad de ItemPedido del dominio a una de infraestructura
	 * @param itemPedido
	 * @return entidad ItemPedidoEntity mapeada
	 */
	public static ItemPedidoEntity fromItemPedidoToItemPedidoEntity(ItemPedido itemPedido) {

		PedidoEntity pedidoEntity = new PedidoEntity();
		pedidoEntity.setIdPedido(itemPedido.getIdItemPedido());

		return new ItemPedidoEntity(
				itemPedido.getIdItemPedido(),
				itemPedido.getIdReceta(),
				pedidoEntity,
				itemPedido.getCantidad(),
				itemPedido.getValor(),
				itemPedido.getTotalItem(),
				itemPedido.getEstado()
				);		
	}

	/**
	 * Convierte una entidad de ItemPedido de infraestructura a una de dominio
	 * @param ItemPedidoEntity
	 * @return entidad ItemPedido mapeada
	 */
	public static ItemPedido fromItemPedidoEntityToItemPedido(ItemPedidoEntity itemPedidoEntity) {

		Pedido pedido = new Pedido();
		pedido.setIdPedido(itemPedidoEntity.getIdItemPedido());

		return new ItemPedido(
				itemPedidoEntity.getIdItemPedido(),
				itemPedidoEntity.getIdReceta(),
				pedido,
				itemPedidoEntity.getCantidad(),
				itemPedidoEntity.getValor(),
				itemPedidoEntity.getTotalItem(),
				itemPedidoEntity.getEstado()
				);
	}

}
