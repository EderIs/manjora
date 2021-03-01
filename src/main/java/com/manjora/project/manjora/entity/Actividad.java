package com.manjora.project.manjora.entity;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.manjora.project.manjora.security.entity.UsuarioSec;

@Entity
@Table(name="actividad")
public class Actividad {

	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String actividad;
	private String resumen;
	private Date fechaInicio;
	private Date fechaFinal;
	
	@ManyToOne
	@JoinColumn(name="usuario_id")
	private UsuarioSec usuario;
	
	private Boolean estadoT;

	public Actividad() {}
	
	public Actividad(Long id, String actividad, String resumen, Date fechaInicio, Date fechaFinal, UsuarioSec usuario,
			Boolean estadoT) {
		
		this.id = id;
		this.actividad = actividad;
		this.resumen = resumen;
		this.fechaInicio = fechaInicio;
		this.fechaFinal = fechaFinal;
		this.usuario = usuario;
		this.estadoT = estadoT;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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
