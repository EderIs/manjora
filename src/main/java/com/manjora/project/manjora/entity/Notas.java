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
@Table(name="notas")
public class Notas {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "usuario_id")
	private UsuarioSec usuario;
	
	private String nombreNotas;

	public Notas() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Notas(Long id, String nombreNotas) {
		super();
		this.id = id;
		this.nombreNotas = nombreNotas;
	}
	
	public Notas(Long id, UsuarioSec usuario, String nombreNotas) {
		super();
		this.id = id;
		this.usuario = usuario;
		this.nombreNotas = nombreNotas;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public UsuarioSec getUsuario() {
		return usuario;
	}

	public void setUsuario(UsuarioSec usuario) {
		this.usuario = usuario;
	}

	public String getNombreNotas() {
		return nombreNotas;
	}

	public void setNombreNotas(String nombreNotas) {
		this.nombreNotas = nombreNotas;
	}
	
	
}
