package com.manjora.project.manjora.dto;

import java.sql.Date;

import com.manjora.project.manjora.entity.Categoria;
import com.manjora.project.manjora.security.entity.UsuarioSec;

public class NotaDto {

	private UsuarioSec usuario;	
	private String nombre;
	private Categoria categoria;
	
	private Date fechaInicio;
	private Date fechaFinal;
	private boolean estatus;
	public NotaDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public NotaDto(UsuarioSec usuario, Categoria categoria, String nombre,
			Date fechaInicio, Date fechaFinal, boolean estatus) {
		super();
		this.usuario = usuario;
		this.categoria = categoria;
		this.nombre = nombre;
		this.fechaInicio = fechaInicio;
		this.fechaFinal = fechaFinal;
		this.estatus = estatus;
	}
	public UsuarioSec getUsuario() {
		return usuario;
	}
	public void setUsuario(UsuarioSec usuario) {
		this.usuario = usuario;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Categoria getCategoria() {
		return categoria;
	}
	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	public Date getFechaInicio() {
		return fechaInicio;
	}
	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}
	public Date getFechaFinal() {
		return fechaFinal;
	}
	public void setFechaFinal(Date fechaFinal) {
		this.fechaFinal = fechaFinal;
	}
	public boolean isEstatus() {
		return estatus;
	}
	public void setEstatus(boolean estatus) {
		this.estatus = estatus;
	}
	
}
