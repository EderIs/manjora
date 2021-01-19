package com.manjora.project.manjora.dto;

public class PuestoDto {

	private String nombrePuesto;
	//private Long idDepartamento;
	private String descripcionTrabajo;
	public PuestoDto() {

	}
	public PuestoDto(String nombrePuesto, /*Long idDepartamento,*/ String descripcionTrabajo) {
		this.nombrePuesto = nombrePuesto;
		//this.idDepartamento = idDepartamento;
		this.descripcionTrabajo = descripcionTrabajo;
	}
	public String getNombrePuesto() {
		return nombrePuesto;
	}
	public void setNombrePuesto(String nombrePuesto) {
		this.nombrePuesto = nombrePuesto;
	}
	public String getDescripcionTrabajo() {
		return descripcionTrabajo;
	}
	public void setDescripcionTrabajo(String descripcionTrabajo) {
		this.descripcionTrabajo = descripcionTrabajo;
	}
	/*
	public Long getIdDepartamento() {
		return idDepartamento;
	}
	public void setIdDepartamento(Long idDepartamento) {
		this.idDepartamento = idDepartamento;
	}
	*/
	
}
