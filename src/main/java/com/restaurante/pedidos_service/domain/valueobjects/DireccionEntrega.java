package com.restaurante.pedidos_service.domain.valueobjects;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Objeto de valor que relaciona una dirección de entrega del pedidio solicitado
 * @author Usuario
 *
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DireccionEntrega implements Serializable {

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
