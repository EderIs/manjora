package com.manjora.project.manjora.dto;

public class HoraLaboralDto {

	
	private String nombre;
	private Double promedioHoraDia;
	
	
	public HoraLaboralDto() {
		
	}


	public HoraLaboralDto(String nombre, Double promedioHoraDia) {
		
		this.nombre = nombre;
		this.promedioHoraDia = promedioHoraDia;
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
