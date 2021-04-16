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
	private String fechaEntrega;
	
	@ManyToOne
	@JoinColumn(name="usuario_id")
	private UsuarioSec usuario;
	
	@ManyToOne
	@JoinColumn(name="tarea_id")
	private Tarea tarea;
	
	private Boolean estadoT;

	public Actividad() {}
	
	
	
	public Actividad(Long id, String actividad, String resumen, java.util.Date fechaFinal ,String fechaEntrega,  UsuarioSec usuario
			,Boolean estadoT) {
		
		this.id = id;
		this.actividad = actividad;
		this.resumen = resumen;
		this.fechaFinal = new java.sql.Date(fechaFinal.getTime());
		this.fechaEntrega = fechaEntrega;
		this.usuario =  new UsuarioSec(usuario.getId(), usuario.getNombre(),usuario.getPathImagen());
		this.estadoT = estadoT;
		
	}


	public Actividad(String actividad, String resumen, Date fechaInicio, Date fechaFinal,
			UsuarioSec usuario, Boolean estadoT, Tarea tarea) {
		
		this.actividad = actividad;
		this.resumen = resumen;
		this.fechaInicio = fechaInicio;
		this.fechaFinal = fechaFinal;
		this.usuario = usuario;
		this.tarea = tarea;
		this.estadoT = estadoT;
	}



	public Actividad(Long id, String actividad, String resumen, Date fechaInicio, Date fechaFinal, UsuarioSec usuario,
			Boolean estadoT,Tarea tarea) {
		
		this.id = id;
		this.actividad = actividad;
		this.resumen = resumen;
		this.fechaInicio = fechaInicio;
		this.fechaFinal = fechaFinal;
		this.usuario = usuario;
		this.estadoT = estadoT;
		this.tarea = tarea;
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


	public Tarea getTarea() {
		return tarea;
	}



	public void setTarea(Tarea tarea) {
		this.tarea = tarea;
	}



	public String getFechaEntrega() {
		return fechaEntrega;
	}

	public void setFechaEntrega(String fechaEntrega) {
		this.fechaEntrega = fechaEntrega;
	}
}
