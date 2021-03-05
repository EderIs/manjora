package com.manjora.project.manjora.dto;

import com.manjora.project.manjora.entity.CategoriaNota;
import com.manjora.project.manjora.security.entity.UsuarioSec;

public class NotaDto {

	private UsuarioSec usuario;	
	private String nombre;
	private CategoriaNota categoriaNota;
	public NotaDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public NotaDto(UsuarioSec usuario, CategoriaNota categoriaNota, String nombre) {
		super();
		this.usuario = usuario;
		this.categoriaNota = categoriaNota;
		this.nombre = nombre;
	}
	public UsuarioSec getUsuario() {
		return usuario;
	}
	public void setUsuario(UsuarioSec usuario) {
		this.usuario = usuario;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public CategoriaNota getCategoriaNota() {
		return categoriaNota;
	}
	public void setCategoriaNota(CategoriaNota categoriaNota) {
		this.categoriaNota = categoriaNota;
	}
	
	
}
