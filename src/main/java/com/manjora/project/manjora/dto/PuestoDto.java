package com.manjora.project.manjora.dto;

import com.manjora.project.manjora.entity.Departamento;

public class PuestoDto {

	private String nombrePuesto;
	private Departamento departamento;
	private String descripcionTrabajo;
	
	public PuestoDto() {

	}

	public PuestoDto(String nombrePuesto, Departamento departamento, String descripcionTrabajo) {
		super();
		this.nombrePuesto = nombrePuesto;
		this.departamento = departamento;
		this.descripcionTrabajo = descripcionTrabajo;
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
