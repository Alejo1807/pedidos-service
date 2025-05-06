package com.restaurante.pedidos_service.infraestructure.persistance.entities;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name="CLIENTES")
public class ClienteEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	//Identificador único del cliente
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
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
	@Builder.Default
	private Boolean estado = true;

}
