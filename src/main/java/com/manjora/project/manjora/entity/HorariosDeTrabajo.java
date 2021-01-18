package com.manjora.project.manjora.entity;

import java.sql.Time;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="horarios_de_trabajo")
public class HorariosDeTrabajo {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String nombre;
	private String diaSemana;
	private Time trabajarDesde;
	private Time trabajarHasta;
	private Date fechaInicio;
	private Date fechaFinalizacion;
	private String periodoDia;
	//Relacion aqui
	// private HorasLaborales horasLaborales;
	
	public HorariosDeTrabajo() {
		
	}
	
	public HorariosDeTrabajo( String nombre, String diaSemana, Time trabajarDesde, Time trabajarHasta,
			Date fechaInicio, Date fechaFinalizacion, String periodoDia) {
		
		this.nombre = nombre;
		this.diaSemana = diaSemana;
		this.trabajarDesde = trabajarDesde;
		this.trabajarHasta = trabajarHasta;
		this.fechaInicio = fechaInicio;
		this.fechaFinalizacion = fechaFinalizacion;
		this.periodoDia = periodoDia;
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

	public String getDiaSemana() {
		return diaSemana;
	}

	public void setDiaSemana(String diaSemana) {
		this.diaSemana = diaSemana;
	}

	public Time getTrabajarDesde() {
		return trabajarDesde;
	}

	public void setTrabajarDesde(Time trabajarDesde) {
		this.trabajarDesde = trabajarDesde;
	}

	public Time getTrabajarHasta() {
		return trabajarHasta;
	}

	public void setTrabajarHasta(Time trabajarHasta) {
		this.trabajarHasta = trabajarHasta;
	}

	public Date getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public Date getFechaFinalizacion() {
		return fechaFinalizacion;
	}

	public void setFechaFinalizacion(Date fechaFinalizacion) {
		this.fechaFinalizacion = fechaFinalizacion;
	}

	public String getPeriodoDia() {
		return periodoDia;
	}

	public void setPeriodoDia(String periodoDia) {
		this.periodoDia = periodoDia;
	}
}

