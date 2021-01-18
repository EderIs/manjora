package com.manjora.project.manjora.dto;

import javax.validation.constraints.NotBlank;

public class TituloDto {

	@NotBlank
	private String titulo;
	@NotBlank
	private String abreviatura;
	
	public TituloDto() {}
	
	public TituloDto(@NotBlank String titulo, @NotBlank String abreviatura) {
		this.titulo = titulo;
		this.abreviatura = abreviatura;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getAbreviatura() {
		return abreviatura;
	}

	public void setAbreviatura(String abreviatura) {
		this.abreviatura = abreviatura;
	}
}
