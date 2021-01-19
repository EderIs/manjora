package com.manjora.project.manjora.dto;

public class HoraLaboralDto {

	
	private String nombreHoraL;
	private Double promedioHoraDia;
	
	
	public HoraLaboralDto() {
		
	}


	public HoraLaboralDto(String nombreHoraL, Double promedioHoraDia) {
		
		this.nombreHoraL = nombreHoraL;
		this.promedioHoraDia = promedioHoraDia;
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
