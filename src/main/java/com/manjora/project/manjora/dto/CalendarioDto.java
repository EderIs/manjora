package com.manjora.project.manjora.dto;

import java.sql.Date;
import java.sql.Time;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import com.manjora.project.manjora.entity.Contacto;
import com.sun.istack.NotNull;

public class CalendarioDto {

	
	private String resumen;
	
	private Date fecha;
	
	private Time horaInicio;
	
	private Time horaFinal;
	
    private Set<Contacto> contactos = new HashSet<>();

	public CalendarioDto() {
		
	}

	public CalendarioDto(String resumen, Date fecha, Time horaInicio, Time horaFinal, Set<Contacto> contactos) {
		this.resumen = resumen;
		this.fecha = fecha;
		this.horaInicio = horaInicio;
		this.horaFinal = horaFinal;
		this.contactos = contactos;
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
