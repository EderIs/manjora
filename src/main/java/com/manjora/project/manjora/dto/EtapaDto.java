package com.manjora.project.manjora.dto;



import com.manjora.project.manjora.entity.Proyecto;

public class EtapaDto {

    private String nombre;
	private Proyecto proyecto;
	private Boolean estatus;
	
	public EtapaDto() {
		
	}
	
	public EtapaDto(String nombre, Proyecto proyecto, Boolean estatus) {
		
		this.nombre = nombre;
		this.proyecto = proyecto;
		this.estatus = estatus;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Proyecto getProyecto() {
		return proyecto;
	}

	public void setProyecto(Proyecto proyecto) {
		this.proyecto = proyecto;
	}

	public Boolean getEstatus() {
		return estatus;
	}

	public void setEstatus(Boolean estatus) {
		this.estatus = estatus;
	}
}
