package com.manjora.project.manjora.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="horas_Laborales")
public class HoraLaboral {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String nombre;
	private Double promedioHoraDia;
	
	public HoraLaboral() {}

	public HoraLaboral( String nombre, Double promedioHoraDia) {
		
		this.nombre = nombre;
		this.promedioHoraDia = promedioHoraDia;
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

	public Double getPromedioHoraDia() {
		return promedioHoraDia;
	}

	public void setPromedioHoraDia(Double promedioHoraDia) {
		this.promedioHoraDia = promedioHoraDia;
	}
	
}
