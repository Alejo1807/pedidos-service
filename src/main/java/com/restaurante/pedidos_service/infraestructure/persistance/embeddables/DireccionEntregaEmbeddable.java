package com.restaurante.pedidos_service.infraestructure.persistance.embeddables;

import java.io.Serializable;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Embeddable
@AllArgsConstructor
@NoArgsConstructor
public class DireccionEntregaEmbeddable implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	//Departamento de colombia
	private String departamento;

	//Municipio de colombia
	private String municipio;

	//Barrio de entrega
	private String barrio;

	//Dirección (nomenclatura) de entrega
	private String direccion;

}
