package com.manjora.project.manjora.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "puestos")
public class Puesto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nombrePuesto;
	

	@ManyToOne(cascade = CascadeType.REFRESH)
	@JoinColumn(name = "departamento_id")
	private Departamento departamento;
	
	private String descripcionTrabajo;
	
	
	public Puesto() {

	}


	public Puesto(String nombrePuesto, Departamento departamento, String descripcionTrabajo) {
		super();
		this.nombrePuesto = nombrePuesto;
		this.departamento = departamento;
		this.descripcionTrabajo = descripcionTrabajo;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getNombrePuesto() {
		return nombrePuesto;
	}


	public void setNombrePuesto(String nombrePuesto) {
		this.nombrePuesto = nombrePuesto;
	}


	public Departamento getDepartamento() {
		return departamento;
	}


	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}


	public String getDescripcionTrabajo() {
		return descripcionTrabajo;
	}


	public void setDescripcionTrabajo(String descripcionTrabajo) {
		this.descripcionTrabajo = descripcionTrabajo;
	}

	
}
