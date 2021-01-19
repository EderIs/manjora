package com.manjora.project.manjora.dto;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;

import com.manjora.project.manjora.entity.Pais;

public class EstadoDto {

	@NotBlank
	private String nombre;
	private int codigo;
	
	
	@ManyToOne
	@JoinColumn(name = "paises_id")
	private Pais pais;
	
	public EstadoDto() {
		
	}

	public EstadoDto(@NotBlank String nombre, int codigo, Pais pais) {
		super();
		this.nombre = nombre;
		this.codigo = codigo;
		this.pais = pais;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
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
