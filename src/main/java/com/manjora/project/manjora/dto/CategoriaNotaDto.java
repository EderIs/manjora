package com.manjora.project.manjora.dto;

import com.manjora.project.manjora.security.entity.UsuarioSec;

public class CategoriaNotaDto {
	private String nombre;
	private UsuarioSec usuario;
	public CategoriaNotaDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CategoriaNotaDto(String nombre, UsuarioSec usuario) {
		super();
		this.nombre = nombre;
		this.usuario = usuario;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public UsuarioSec getUsuario() {
		return usuario;
	}
	public void setUsuario(UsuarioSec usuario) {
		this.usuario = usuario;
	}
	
}
