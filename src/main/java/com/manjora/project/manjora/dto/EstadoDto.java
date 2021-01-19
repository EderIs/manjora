package com.manjora.project.manjora.dto;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;

import com.manjora.project.manjora.entity.Pais;

public class EstadoDto {

	@NotBlank
	private String nombreEstado;
	private int codigo;
	
	
	private Pais pais;
	
	public EstadoDto() {
		
	}

	public EstadoDto(@NotBlank String nombreEstado, int codigo, Pais pais) {
		super();
		this.nombreEstado = nombreEstado;
		this.codigo = codigo;
		this.pais = pais;
	}

	public String getNombreEstado() {
		return nombreEstado;
	}

	public void setNombreEstado(String nombreEstado) {
		this.nombreEstado = nombreEstado;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public Pais getPais() {
		return pais;
	}

	public void setPais(Pais pais) {
		this.pais = pais;
	}
	
	

}
