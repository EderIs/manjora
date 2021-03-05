package com.manjora.project.manjora.dto;

import com.manjora.project.manjora.entity.Notas;

public class CategoriaNotaDto {
	private String nombre;
	private Notas notas;
	public CategoriaNotaDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CategoriaNotaDto(String nombre, Notas notas) {
		super();
		this.nombre = nombre;
		this.notas = notas;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Notas getNotas() {
		return notas;
	}
	public void setNotas(Notas notas) {
		this.notas = notas;
	}
	
	
}
