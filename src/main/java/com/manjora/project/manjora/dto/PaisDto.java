package com.manjora.project.manjora.dto;

import javax.validation.constraints.NotBlank;

public class PaisDto {
	
	
	@NotBlank
	private String nombre;

	public PaisDto() {

	}

	public PaisDto(String nombre) {
		super();
		this.nombre = nombre;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

}
