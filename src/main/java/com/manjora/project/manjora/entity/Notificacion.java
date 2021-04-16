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
	private String fechaLlegada;
	private String ruta;
	
	@ManyToOne
	@JoinColumn(name = "usuario_id")
	private UsuarioSec usuarioDestino;
	

	private boolean estatus;
	
	public Notificacion() {
		
	}

	public Notificacion(long id, String titulo, String resumen, String fechaLlegada, UsuarioSec usuarioDestino,
			String ruta,boolean estatus) {
	
		this.id = id;
		this.titulo = titulo;
		this.resumen = resumen;
		this.fechaLlegada = fechaLlegada;
		this.usuarioDestino = new UsuarioSec(usuarioDestino.getId(),usuarioDestino.getNombre(),"");
		this.ruta= ruta;
		this.estatus = estatus;
	}
	
	public Notificacion(String titulo, String resumen, String fechaLlegada, UsuarioSec usuarioDestino,
			boolean estatus,String ruta) {
		
		
		this.titulo = titulo;
		this.resumen = resumen;
		this.fechaLlegada = fechaLlegada;
		this.usuarioDestino = usuarioDestino;
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

	public String getFechaLlegada() {
		return fechaLlegada;
	}

	public void setFechaLlegada(String fechaLlegada) {
		this.fechaLlegada = fechaLlegada;
	}

	public UsuarioSec getUsuarioDestino() {
		return usuarioDestino;
	}

	public void setUsuarioDestino(UsuarioSec usuarioDestino) {
		this.usuarioDestino = usuarioDestino;
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
