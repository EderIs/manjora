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
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nombreHoraL;
	private Double promedioHoraDia;
	
	public HoraLaboral() {}

	public HoraLaboral( String nombreHoraL, Double promedioHoraDia) {
		
		this.nombreHoraL = nombreHoraL;
		this.promedioHoraDia = promedioHoraDia;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombreHoraL() {
		return nombreHoraL;
	}

	public void setNombreHoraL(String nombreHoraL) {
		this.nombreHoraL = nombreHoraL;
	}

	public Double getPromedioHoraDia() {
		return promedioHoraDia;
	}

	public void setPromedioHoraDia(Double promedioHoraDia) {
		this.promedioHoraDia = promedioHoraDia;
	}
	
}
