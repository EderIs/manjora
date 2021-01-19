package com.manjora.project.manjora.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="bancos")
public class Banco {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String nombre;
	private String codigoIdenBancaria;
	private String calle;
	private String calleSecundaria;
	private String ciudad;


	@OneToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name="estados_id",referencedColumnName = "id")
	private Estado estado;
	
	private int codigoPostal;
	private String telefono;
	private String correoElectronico;
	private Boolean activo;
	
	
	
	public Banco() {}


	public Banco(String nombre, String codigoIdenBancaria, String calle, String calleSecundaria, String ciudad,
			int codigoPostal, String telefono, String correoElectronico, Boolean activo) {
		
		this.nombre = nombre;
		this.codigoIdenBancaria = codigoIdenBancaria;
		this.calle = calle;
		this.calleSecundaria = calleSecundaria;
		this.ciudad = ciudad;
		this.codigoPostal = codigoPostal;
		this.telefono = telefono;
		this.correoElectronico = correoElectronico;
		this.activo = activo;
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


	public String getCodigoIdenBancaria() {
		return codigoIdenBancaria;
	}


	public void setCodigoIdenBancaria(String codigoIdenBancaria) {
		this.codigoIdenBancaria = codigoIdenBancaria;
	}


	public String getCalle() {
		return calle;
	}


	public void setCalle(String calle) {
		this.calle = calle;
	}


	public String getCalleSecundaria() {
		return calleSecundaria;
	}


	public void setCalleSecundaria(String calleSecundaria) {
		this.calleSecundaria = calleSecundaria;
	}


	public String getCiudad() {
		return ciudad;
	}


	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}


	public int getCodigoPostal() {
		return codigoPostal;
	}


	public void setCodigoPostal(int codigoPostal) {
		this.codigoPostal = codigoPostal;
	}


	public String getTelefono() {
		return telefono;
	}


	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}


	public String getCorreoElectronico() {
		return correoElectronico;
	}


	public void setCorreoElectronico(String correoElectronico) {
		this.correoElectronico = correoElectronico;
	}


	public Boolean getActivo() {
		return activo;
	}


	public void setActivo(Boolean activo) {
		this.activo = activo;
	}
	
}
