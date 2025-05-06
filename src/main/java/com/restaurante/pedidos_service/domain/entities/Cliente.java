package com.restaurante.pedidos_service.domain.entities;

import java.io.Serializable;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Clase que representa la entidad Cliente del negocio
 * 
 *
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Cliente implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	//Identificador único del cliente
	private Long idCliente;

	//Nombre del cliente
	@NotEmpty
	private String nombreCliente;

	@NotNull
	//NIT del cliente
	private Long nit;

	@NotEmpty
	//e-mail del cliente
	private String email;
	
	//Estado que representa si el cliente está Activo (True) o Inactivo (False)
	private Boolean estado;

}
