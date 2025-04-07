package com.restaurante.pedidos_service.infraestructure.excepcion;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ErrorDetails {
	private int statusCode;
	private String message;
	private String details;

	public ErrorDetails(int statusCode, String message, String details) {
		this.statusCode = statusCode;
		this.message = message;
		this.details = details;
	}
}
