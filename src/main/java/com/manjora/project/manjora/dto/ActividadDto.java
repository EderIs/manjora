package com.manjora.project.manjora.dto;

import java.sql.Date;


import com.manjora.project.manjora.security.entity.UsuarioSec;

public class ActividadDto {

	private String actividad;
	private String resumen;
	private Date fechaInicio;
	private Date fechaFinal;
	private UsuarioSec usuario;
	private Boolean estadoT;
	
	
	public ActividadDto() {}
	
	public ActividadDto(String actividad, String resumen, Date fechaInicio, Date fechaFinal, UsuarioSec usuario,
			Boolean estadoT) {
		
		this.actividad = actividad;
		this.resumen = resumen;
		this.fechaInicio = fechaInicio;
		this.fechaFinal = fechaFinal;
		this.usuario = usuario;
		this.estadoT = estadoT;
	}
	public String getActividad() {
		return actividad;
	}
	public void setActividad(String actividad) {
		this.actividad = actividad;
	}
	public String getResumen() {
		return resumen;
	}
	public void setResumen(String resumen) {
		this.resumen = resumen;
	}
	public Date getFechaInicio() {
		return fechaInicio;
	}
	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}
	public Date getFechaFinal() {
		return fechaFinal;
	}
	public void setFechaFinal(Date fechaFinal) {
		this.fechaFinal = fechaFinal;
	}
	public UsuarioSec getUsuario() {
		return usuario;
	}
	public void setUsuario(UsuarioSec usuario) {
		this.usuario = usuario;
	}
	public Boolean getEstadoT() {
		return estadoT;
	}
	public void setEstadoT(Boolean estadoT) {
		this.estadoT = estadoT;
	}
	
}
