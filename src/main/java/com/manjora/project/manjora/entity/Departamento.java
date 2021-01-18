package com.manjora.project.manjora.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "departamentos")
public class Departamento {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nombreDepartamento;
	/*
	private Long Responsable;
	private Long DepartamentoPadre;
	*/
	private boolean estado;
	public Departamento() {

	}
	public Departamento(String nombreDepartamento, /*Long responsable, Long departamentoPadre,*/ boolean estado) {
		this.nombreDepartamento = nombreDepartamento;
		//Responsable = responsable;
		//DepartamentoPadre = departamentoPadre;
		this.estado = estado;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
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
