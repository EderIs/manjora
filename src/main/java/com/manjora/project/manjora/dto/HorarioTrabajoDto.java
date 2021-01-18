package com.manjora.project.manjora.dto;

import java.sql.Time;
import java.util.Date;

public class HorarioTrabajoDto {

	//Validaciones al final dependiendo requerimientos
	
	private String nombre;
	private String diaSemana;
	private Time trabajarDesde;
	private Time trabajarHasta;
	private Date fechaInicio;
	private Date fechaFinalizacion;
	private String periodoDia;
	//Relacion con Horas laborales
	// private HorasLaborales horasLaborales;
	public HorarioTrabajoDto() {
	}
	public HorarioTrabajoDto(String nombre, String diaSemana, Time trabajarDesde, Time trabajarHasta, Date fechaInicio,
			Date fechaFinalizacion, String periodoDia) {
		
		this.nombre = nombre;
		this.diaSemana = diaSemana;
		this.trabajarDesde = trabajarDesde;
		this.trabajarHasta = trabajarHasta;
		this.fechaInicio = fechaInicio;
		this.fechaFinalizacion = fechaFinalizacion;
		this.periodoDia = periodoDia;
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
