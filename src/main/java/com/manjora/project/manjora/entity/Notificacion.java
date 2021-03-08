package com.manjora.project.manjora.entity;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.manjora.project.manjora.security.entity.UsuarioSec;

@Entity
public class Notificacion {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String titulo;
	private String resumen;
	private Date fechaLlegada;
	private String ruta;
	
	@ManyToOne
	@JoinColumn(name = "usuario_id")
	private UsuarioSec usuarioDestino;
	
	@ManyToOne
	@JoinColumn(name = "usuario_id")
	private UsuarioSec usuarioEnvio;

	private boolean estatus;
	
	public Notificacion() {
		
	}

	public Notificacion(long id, String titulo, String resumen, Date fechaLlegada, UsuarioSec usuarioDestino) {
	
		this.id = id;
		this.titulo = titulo;
		this.resumen = resumen;
		this.fechaLlegada = fechaLlegada;
		this.usuarioDestino = usuarioDestino;
	}
	
	public Notificacion(long id, String titulo, String resumen, Date fechaLlegada, UsuarioSec usuarioDestino,
			UsuarioSec usuarioEnvio,boolean estatus,String ruta) {
		
		this.id = id;
		this.titulo = titulo;
		this.resumen = resumen;
		this.fechaLlegada = fechaLlegada;
		this.usuarioDestino = usuarioDestino;
		this.usuarioEnvio = usuarioEnvio;
		this.estatus = estatus;
		this.ruta = ruta;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
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
