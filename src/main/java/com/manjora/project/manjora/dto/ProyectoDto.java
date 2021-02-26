package com.manjora.project.manjora.dto;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.manjora.project.manjora.security.entity.UsuarioSec;

public class ProyectoDto {

	private UsuarioSec usuario;	
	private String nombreTarea;
	
	public ProyectoDto() {}
	public ProyectoDto(UsuarioSec usuario, String nombreTarea) {
		
		this.usuario = usuario;
		this.nombreTarea = nombreTarea;
	}
	public UsuarioSec getUsuario() {
		return usuario;
	}
	public void setUsuario(UsuarioSec usuario) {
		this.usuario = usuario;
	}
	public String getNombreTarea() {
		return nombreTarea;
	}
	public void setNombreTarea(String nombreTarea) {
		this.nombreTarea = nombreTarea;
	}
}
