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
	@JoinColumn(name="categoria_nota_id")
	private CategoriaNota categoriaNota;
	
	public Nota() {
		
	}
	
	public Nota(Long id, String nombre) {
		super();
		this.id = id;
		this.nombre = nombre;
	}

	public Nota(Long id, String nombre, UsuarioSec usuario, CategoriaNota categoriaNota) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.usuario = usuario;
		this.categoriaNota = categoriaNota;
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

	public CategoriaNota getCategoriaNota() {
		return categoriaNota;
	}

	public void setCategoriaNota(CategoriaNota categoriaNota) {
		this.categoriaNota = categoriaNota;
	}
	
	
}
