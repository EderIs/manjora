package com.manjora.project.manjora.entity;

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
	
	@ManyToOne
    @JoinColumn(name="departamento_id", referencedColumnName = "id")
	private Departamento idDepartamento;
	
	private String descripcionTrabajo;
	public Puesto() {

	}
	public Puesto(String nombrePuesto, /*Long idDepartamento,*/ String descripcionTrabajo) {
		super();
		this.nombrePuesto = nombrePuesto;
		//this.idDepartamento = idDepartamento;
		descripcionTrabajo = descripcionTrabajo;
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
	/*
	public Long getIdDepartamento() {
		return idDepartamento;
	}
	public void setIdDepartamento(Long idDepartamento) {
		this.idDepartamento = idDepartamento;
	}
	*/	
	public String getDescripcionTrabajo() {
		return descripcionTrabajo;
	}
	public void setDescripcionTrabajo(String descripcionTrabajo) {
		descripcionTrabajo = descripcionTrabajo;
	}
	
	
}
