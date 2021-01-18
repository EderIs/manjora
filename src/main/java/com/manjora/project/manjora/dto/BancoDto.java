package com.manjora.project.manjora.dto;

public class BancoDto {

	private String nombre;
	private String codigoIdenBancaria;
	private String calle;
	private String calleSecundaria;
	private String ciudad;
	//relacion con estado
	// private Estado estado;
	private int codigoPostal;
	private String telefono;
	private String correoElectronico;
	private Boolean activo;
	
	public BancoDto() {}

	public BancoDto(String nombre, String codigoIdenBancaria, String calle, String calleSecundaria, String ciudad,
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
