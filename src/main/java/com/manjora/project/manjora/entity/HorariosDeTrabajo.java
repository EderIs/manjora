package com.manjora.project.manjora.entity;

import java.sql.Date;
import java.sql.Time;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;



@Entity
@Table(name="horarios_trabajos")
public class HorariosDeTrabajo {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String nombreHorariosT;
	
	private String diaSemana;
	
	private Time trabajarDesde;
	
	private Time trabajarHasta;
	
	private Date fechaInicio;
	
	private Date fechaFinalizacion;
	
	private String periodoDia;
	
	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name="horalaboral_id", referencedColumnName = "id")
	private HoraLaboral horasLaborales;
	
	public HorariosDeTrabajo() {
		
	}
	
	public HorariosDeTrabajo( String nombreHorariosT, String diaSemana, Time trabajarDesde, Time trabajarHasta,
			Date fechaInicio, Date fechaFinalizacion, String periodoDia) {
		
		this.nombreHorariosT = nombreHorariosT;
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
}

