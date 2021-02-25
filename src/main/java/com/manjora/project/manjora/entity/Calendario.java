package com.manjora.project.manjora.entity;


import java.sql.Date;
import java.sql.Time;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonView;
import com.sun.istack.NotNull;

@Entity
public class Calendario{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String resumen;
	@NotNull
	private Date fecha;
	@NotNull
	private Time horaInicio;
	@NotNull
	private Time horaFinal;
	
	@NotNull
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "calendario_contac", joinColumns = @JoinColumn(name = "calendario_id"),
    inverseJoinColumns = @JoinColumn(name = "contacto_id"))
    private Set<Contacto> contactos = new HashSet<>();

	public Calendario() {	
		
	}

	
	public Calendario(Long id, java.util.Date fecha) {
	
		this.id = id;
		this.fecha = new java.sql.Date(fecha.getTime());
	}


	public Calendario( String resumen, Date fecha, Time horaInicio, Time horaFinal) {
		
		this.resumen = resumen;
		this.fecha = fecha;
		this.horaInicio = horaInicio;
		this.horaFinal = horaFinal;
	}
	
	public Calendario(Long id, String resumen, java.util.Date fecha, java.util.Date horaInicio, java.util.Date horaFinal) {
		
		this.id = id;
		this.resumen = resumen;
		this.fecha = new java.sql.Date(fecha.getTime());
		this.horaInicio = new java.sql.Time(horaInicio.getTime());
		this.horaFinal = new java.sql.Time(horaFinal.getTime());
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getResumen() {
		return resumen;
	}

	public void setResumen(String resumen) {
		this.resumen = resumen;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public Time getHoraInicio() {
		return horaInicio;
	}

	public void setHoraInicio(Time horaInicio) {
		this.horaInicio = horaInicio;
	}

	public Time getHoraFinal() {
		return horaFinal;
	}

	public void setHoraFinal(Time horaFinal) {
		this.horaFinal = horaFinal;
	}

	public Set<Contacto> getContactos() {
		return contactos;
	}

	public void setContactos(Set<Contacto> contactos) {
		this.contactos = contactos;
	}
}
