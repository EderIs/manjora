package com.manjora.project.manjora.dto;

import java.sql.Date;

import javax.validation.constraints.NotBlank;

public class UsuarioDto {
	
	@NotBlank
	private String nombreUsuario;
	private String direccionCorreo;
	private String contrasena;
	private Date fechaCreacion;
	private Date ultimoAcceso;
	private boolean estado;
	
	public UsuarioDto() {
	
	}

	public UsuarioDto(String nombreUsuario, String direccionCorreo, String contrasena, Date fechaCreacion,
			Date ultimoAcceso, boolean estado) {
		super();
		this.nombreUsuario = nombreUsuario;
		this.direccionCorreo = direccionCorreo;
		this.contrasena = contrasena;
		this.fechaCreacion = fechaCreacion;
		this.ultimoAcceso = ultimoAcceso;
		this.estado = estado;
	}
	
	
}
