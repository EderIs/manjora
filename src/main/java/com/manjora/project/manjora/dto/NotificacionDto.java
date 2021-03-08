package com.manjora.project.manjora.dto;

import java.sql.Date;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.manjora.project.manjora.security.entity.UsuarioSec;

public class NotificacionDto {

	private String titulo;
	private String resumen;
	private Date fechaLlegada;
	private UsuarioSec usuarioDestino;
	private UsuarioSec usuarioEnvio;
	private boolean estatus;
	private String ruta;
	
	public NotificacionDto() {
	
	}



	public NotificacionDto(String titulo, String resumen, Date fechaLlegada, UsuarioSec usuarioDestino,
			UsuarioSec usuarioEnvio,boolean estatus,String ruta) {
		
		this.titulo = titulo;
		this.resumen = resumen;
		this.fechaLlegada = fechaLlegada;
		this.usuarioDestino = usuarioDestino;
		this.usuarioEnvio = usuarioEnvio;
		this.estatus = estatus;
		this.ruta = ruta;
	}

	public String getTitulo() {
		return titulo;
	}


	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}



	public String getResumen() {
		return resumen;
	}



	public void setResumen(String resumen) {
		this.resumen = resumen;
	}



	public Date getFechaLlegada() {
		return fechaLlegada;
	}



	public void setFechaLlegada(Date fechaLlegada) {
		this.fechaLlegada = fechaLlegada;
	}



	public UsuarioSec getUsuarioDestino() {
		return usuarioDestino;
	}



	public void setUsuarioDestino(UsuarioSec usuarioDestino) {
		this.usuarioDestino = usuarioDestino;
	}



	public UsuarioSec getUsuarioEnvio() {
		return usuarioEnvio;
	}



	public void setUsuarioEnvio(UsuarioSec usuarioEnvio) {
		this.usuarioEnvio = usuarioEnvio;
	}



	public boolean isEstatus() {
		return estatus;
	}



	public void setEstatus(boolean estatus) {
		this.estatus = estatus;
	}



	public String getRuta() {
		return ruta;
	}



	public void setRuta(String ruta) {
		this.ruta = ruta;
	}
	
}
