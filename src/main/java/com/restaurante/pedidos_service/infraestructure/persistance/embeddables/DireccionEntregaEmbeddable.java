package com.restaurante.pedidos_service.infraestructure.persistance.embeddables;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@Embeddable
@AllArgsConstructor
public class DireccionEntregaEmbeddable {

	//Departamento de colombia
	private String departamento;

	//Municipio de colombia
	private String municipio;

	//Barrio de entrega
	private String barrio;

	//Dirección (nomenclatura) de entrega
	private String direccion;

}
