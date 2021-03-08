package com.manjora.project.manjora.dto;

import com.manjora.project.manjora.security.entity.UsuarioSec;

public class NotasDto {

	private UsuarioSec usuario;
	private String nombreNotas;
	public NotasDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public NotasDto(UsuarioSec usuario, String nombreNotas) {
		super();
		this.usuario = usuario;
		this.nombreNotas = nombreNotas;
	}
	public UsuarioSec getUsuario() {
		return usuario;
	}
	public void setUsuario(UsuarioSec usuario) {
		this.usuario = usuario;
	}
	public String getNombreNotas() {
		return nombreNotas;
	}
	public void setNombreNotas(String nombreNotas) {
		this.nombreNotas = nombreNotas;
	}

	
}
