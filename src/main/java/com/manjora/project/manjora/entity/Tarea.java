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
@Table(name="tarea")
public class Tarea {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String nombre;
	
	@ManyToOne
	@JoinColumn(name="usuario_id")
	private UsuarioSec usuario;
	
	@ManyToOne
	@JoinColumn(name="etapa_id")
	private Etapa etapa;
	
	private Date fechaInicio;
	
	private Date fechaFinal;
	
	private Boolean estatus;

	public Tarea() {}
	
	public Tarea(Long id, String nombre, UsuarioSec usuario, Etapa etapa, Date fechaInicio, Date fechaFinal,
			Boolean estatus) {
		
		this.id = id;
		this.nombre = nombre;
		this.usuario = usuario;
		this.etapa = etapa;
		this.fechaInicio = fechaInicio;
		this.fechaFinal = fechaFinal;
		this.estatus = estatus;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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
