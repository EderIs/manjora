package com.manjora.project.manjora.entity;

import javax.persistence.Entity;
import java.sql.Date;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.manjora.project.manjora.security.entity.UsuarioSec;

@Entity
@Table(name="nota")
public class Nota {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nombre;
	
	@ManyToOne
	@JoinColumn(name="usuario_id")
	private UsuarioSec usuario;
	
	@ManyToOne
	@JoinColumn(name="categoria_id")
	private Categoria categoria;
	
	private Date fechaInicio;
	private Date fechaFinal;
	private boolean estatus;
	
	public Nota() {
		
	}
	
	public Nota(Long id, String nombre) {
		super();
		this.id = id;
		this.nombre = nombre;
	}

	public Nota(Long id, String nombre, UsuarioSec usuario, Categoria categoria,
			Date fechaInicio, Date fechaFinal, boolean estatus) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.usuario = usuario;
		this.categoria = categoria;
		this.fechaInicio = fechaInicio;
		this.fechaFinal = fechaFinal;
		this.estatus = estatus;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public UsuarioSec getUsuario() {
		return usuario;
	}

	public void setUsuario(UsuarioSec usuario) {
		this.usuario = usuario;
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
