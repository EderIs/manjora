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
@Table(name="proyecto")
public class Proyecto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "usuario_id")
	private UsuarioSec usuario;
	
	private String nombreTarea;

	public Proyecto() {
		
	}
	
	
	public Proyecto(Long id, String nombreTarea) {
		
		this.id = id;
		this.nombreTarea = nombreTarea;
	}


	public Proyecto(Long id, UsuarioSec usuario, String nombreTarea) {
		
		this.id = id;
		this.usuario = usuario;
		this.nombreTarea = nombreTarea;
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

	public String getNombreTarea() {
		return nombreTarea;
	}

	public void setNombreTarea(String nombreTarea) {
		this.nombreTarea = nombreTarea;
	}
}
