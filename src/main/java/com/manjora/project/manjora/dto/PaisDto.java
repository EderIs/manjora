package com.manjora.project.manjora.dto;

import javax.validation.constraints.NotBlank;

public class PaisDto {
	
	
	@NotBlank
	private String nombrePais;

	public PaisDto() {

	}

	public PaisDto(String nombrePais) {
		super();
		this.nombrePais = nombrePais;
	}

	public String getNombrePais() {
		return nombrePais;
	}

	public void setNombrePais(String nombrePais) {
		this.nombrePais = nombrePais;
	}

}
