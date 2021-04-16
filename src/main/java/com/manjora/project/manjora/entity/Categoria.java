package com.manjora.project.manjora.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.manjora.project.manjora.security.entity.UsuarioSec;

@Entity
@Table(name="categoria")
public class Categoria {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String nombre;
	@ManyToOne
	@JoinColumn(name = "usuario_id")
	private UsuarioSec usuario;
	
	
	public Categoria() {
		super();
	}

	public Categoria(Long id, String nombre, UsuarioSec usuario) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.usuario = usuario;
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

	public void setNombre(String nombreCategoria) {
		this.nombre = nombreCategoria;
	}

	public UsuarioSec getUsuario() {
		return usuario;
	}

	public void setUsuario(UsuarioSec usuario) {
		this.usuario = usuario;
	}
	
	
}
