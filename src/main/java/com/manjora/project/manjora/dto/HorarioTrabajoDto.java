package com.manjora.project.manjora.dto;


import java.sql.Date;
import java.sql.Time;

import com.manjora.project.manjora.entity.HoraLaboral;


public class HorarioTrabajoDto {

	//Validaciones al final dependiendo requerimientos
	
	private String nombreHorariosT;
	private String diaSemana;
	private Time trabajarDesde;
	private Time trabajarHasta;
	private Date fechaInicio;
	private Date fechaFinalizacion;
	private String periodoDia;
	private HoraLaboral horasLaborales;
	public HorarioTrabajoDto() {
	}
	public HorarioTrabajoDto(String nombreHorariosT, String diaSemana, Time trabajarDesde, Time trabajarHasta, Date fechaInicio,
			Date fechaFinalizacion, String periodoDia) {
		
		this.nombreHorariosT = nombreHorariosT;
		this.diaSemana = diaSemana;
		this.trabajarDesde = trabajarDesde;
		this.trabajarHasta = trabajarHasta;
		this.fechaInicio = fechaInicio;
		this.fechaFinalizacion = fechaFinalizacion;
		this.periodoDia = periodoDia;
	}
	public String getNombreHorariosT() {
		return nombreHorariosT;
	}
	public void setNombreHorariosT(String nombreHorariosT) {
		this.nombreHorariosT = nombreHorariosT;
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
	public HoraLaboral getHorasLaborales() {
		return horasLaborales;
	}
	public void setHorasLaborales(HoraLaboral horasLaborales) {
		this.horasLaborales = horasLaborales;
	}
}
