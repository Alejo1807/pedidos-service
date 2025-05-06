package com.restaurante.pedidos_service.infraestructure.config;


import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.restaurante.pedidos_service.infraestructure.persistance.embeddables.DireccionEntregaEmbeddable;
import com.restaurante.pedidos_service.infraestructure.persistance.embeddables.TotalPedidoEmbeddable;
import com.restaurante.pedidos_service.infraestructure.persistance.entities.ClienteEntity;
import com.restaurante.pedidos_service.infraestructure.persistance.entities.ItemPedidoEntity;
import com.restaurante.pedidos_service.infraestructure.persistance.entities.PedidoEntity;
import com.restaurante.pedidos_service.infraestructure.persistance.repositories.ClienteRepositoryJPA;
import com.restaurante.pedidos_service.infraestructure.persistance.repositories.PedidoRepositoryJPA;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class DataInitializer implements CommandLineRunner {

	private final ClienteRepositoryJPA clienteRepository;
	private final PedidoRepositoryJPA pedidoRepository;

	private final Random random = new Random();

	@Override
	@Transactional
	public void run(String... args) throws Exception {
		if (clienteRepository.count() > 0 || pedidoRepository.count() > 0) return;

		for (int i = 1; i <= 10; i++) {
			ClienteEntity cliente = ClienteEntity.builder()
					.nombreCliente("Cliente " + i)
					.nit(100000000L + i)
					.email("cliente" + i + "@correo.com")
					.estado(true)
					.build();

			cliente = clienteRepository.save(cliente);

			PedidoEntity pedido = PedidoEntity.builder()
					.cliente(cliente)
					.direccionEntrega(new DireccionEntregaEmbeddable(
							"Departamento " + i,
							"Municipio " + i,
							"Barrio " + i,
							"Calle " + i + " # " + (10 + i)
							))
					.estado(true)
					.build();
			
			List<ItemPedidoEntity> items = new ArrayList<>();
			double subTotal = 0.0;

			for (int j = 1; j <= 2 + random.nextInt(3); j++) { // 2 a 4 items
				double valor = 10000 + random.nextInt(10000); // entre 10k y 20k
				int cantidad = 1 + random.nextInt(3);
				double totalItem = valor * cantidad;

				ItemPedidoEntity item = ItemPedidoEntity.builder()
						.idReceta((long) (j + 1))
						.cantidad(cantidad)
						.valor(valor)
						.totalItem(totalItem)
						.estado(true)
						.pedido(pedido) // importante
						.build();

				items.add(item);
				subTotal += totalItem;
			}

			double iva = subTotal * 0.19;
			double total = subTotal + iva;

			pedido.setItemsPedidos(items);
			pedido.setTotalPedido(new TotalPedidoEmbeddable(subTotal, (short) 19, iva, total));

			pedidoRepository.save(pedido); // cascade guarda items
		}
	}

}
