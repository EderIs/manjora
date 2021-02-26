package com.manjora.project.manjora.dto;

import java.sql.Date;

import com.manjora.project.manjora.entity.Etapa;
import com.manjora.project.manjora.security.entity.UsuarioSec;

public class TareaDto {

private String nombre;
	
	private UsuarioSec usuario;
	
	private Etapa etapa;
	
	private Date fechaInicio;
	
	private Date fechaFinal;
	
	private Boolean estatus;

	public TareaDto() {}
	
	public TareaDto(String nombre, UsuarioSec usuario, Etapa etapa, Date fechaInicio, Date fechaFinal,
			Boolean estatus) {
	
		this.nombre = nombre;
		this.usuario = usuario;
		this.etapa = etapa;
		this.fechaInicio = fechaInicio;
		this.fechaFinal = fechaFinal;
		this.estatus = estatus;
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

	public Etapa getEtapa() {
		return etapa;
	}

	public void setEtapa(Etapa etapa) {
		this.etapa = etapa;
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

	public Boolean getEstatus() {
		return estatus;
	}

	public void setEstatus(Boolean estatus) {
		this.estatus = estatus;
	}
}
