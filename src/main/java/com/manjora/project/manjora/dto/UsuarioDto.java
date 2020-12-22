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

	public String getNombreUsuario() {
		return nombreUsuario;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	public String getDireccionCorreo() {
		return direccionCorreo;
	}

	public void setDireccionCorreo(String direccionCorreo) {
		this.direccionCorreo = direccionCorreo;
	}

	public String getContrasena() {
		return contrasena;
	}

	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}

	public Date getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public Date getUltimoAcceso() {
		return ultimoAcceso;
	}

	public void setUltimoAcceso(Date ultimoAcceso) {
		this.ultimoAcceso = ultimoAcceso;
	}

	public boolean isEstado() {
		return estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}
	
}
