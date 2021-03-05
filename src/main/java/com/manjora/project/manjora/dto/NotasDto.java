package com.manjora.project.manjora.dto;

import com.manjora.project.manjora.security.entity.UsuarioSec;

public class NotasDto {

	private UsuarioSec usuario;
	private String titulo;
	public NotasDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public NotasDto(UsuarioSec usuario, String titulo) {
		super();
		this.usuario = usuario;
		this.titulo = titulo;
	}
	public UsuarioSec getUsuario() {
		return usuario;
	}
	public void setUsuario(UsuarioSec usuario) {
		this.usuario = usuario;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	
}
