package com.manjora.project.manjora.dto;

public class DepartamentoDto {

	private String nombreDepartamento;
	
	/*
	private Long Responsable;
	private Long DepartamentoPadre;
	*/
	private boolean estado;
	public DepartamentoDto() {
		
	}
	public DepartamentoDto(String nombreDepartamento,/* Long responsable, Long departamentoPadre,*/ boolean estado) {
		super();
		this.nombreDepartamento = nombreDepartamento;
		/*Responsable = responsable;
		DepartamentoPadre = departamentoPadre;*/
		this.estado = estado;
	}
	public String getNombreDepartamento() {
		return nombreDepartamento;
	}
	public void setNombreDepartamento(String nombreDepartamento) {
		this.nombreDepartamento = nombreDepartamento;
	}
	/*
	public Long getResponsable() {
		return Responsable;
	}
	public void setResponsable(Long responsable) {
		Responsable = responsable;
	}
	public Long getDepartamentoPadre() {
		return DepartamentoPadre;
	}
	
	public void setDepartamentoPadre(Long departamentoPadre) {
		DepartamentoPadre = departamentoPadre;
	}
	*/
	public boolean isEstado() {
		return estado;
	}
	public void setEstado(boolean estado) {
		this.estado = estado;
	}
	
	
}
