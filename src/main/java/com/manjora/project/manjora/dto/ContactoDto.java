package com.manjora.project.manjora.dto;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;

import com.manjora.project.manjora.entity.Estado;
import com.manjora.project.manjora.entity.Titulo;

public class ContactoDto {
	
	
	@NotBlank
	private boolean tipoContacto;
	private byte fotografia;
	private String compania;
	private String ciudad;
	private String calleSecundaria;
	
	@ManyToOne
	@JoinColumn(name = "estados_id")
	private Estado estado;
	
	private int codigoPostal;
	private String nif;
	private String puestoTrabajo;
	private String telefono;
	private String movil;
	private String correoElectronico;
	private String sitioWeb;
	
	@ManyToOne
	@JoinColumn(name = "titulos_id")
	private Titulo titulo;
	private String notas;
	private boolean rol;
	private String comercial;
	private String referenciaInterna;

	public ContactoDto() {
		
	}

	public ContactoDto(@NotBlank boolean tipoContacto, byte fotografia, String compania, String ciudad,
			String calleSecundaria, Estado estado, int codigoPostal, String nif, String puestoTrabajo, String telefono,
			String movil, String correoElectronico, String sitioWeb, Titulo titulo, String notas, boolean rol,
			String comercial, String referenciaInterna) {
		super();
		this.tipoContacto = tipoContacto;
		this.fotografia = fotografia;
		this.compania = compania;
		this.ciudad = ciudad;
		this.calleSecundaria = calleSecundaria;
		this.estado = estado;
		this.codigoPostal = codigoPostal;
		this.nif = nif;
		this.puestoTrabajo = puestoTrabajo;
		this.telefono = telefono;
		this.movil = movil;
		this.correoElectronico = correoElectronico;
		this.sitioWeb = sitioWeb;
		this.titulo = titulo;
		this.notas = notas;
		this.rol = rol;
		this.comercial = comercial;
		this.referenciaInterna = referenciaInterna;
	}

	public boolean isTipoContacto() {
		return tipoContacto;
	}

	public void setTipoContacto(boolean tipoContacto) {
		this.tipoContacto = tipoContacto;
	}

	public byte getFotografia() {
		return fotografia;
	}

	public void setFotografia(byte fotografia) {
		this.fotografia = fotografia;
	}

	public String getCompania() {
		return compania;
	}

	public void setCompania(String compania) {
		this.compania = compania;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public String getCalleSecundaria() {
		return calleSecundaria;
	}

	public void setCalleSecundaria(String calleSecundaria) {
		this.calleSecundaria = calleSecundaria;
	}

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	public int getCodigoPostal() {
		return codigoPostal;
	}

	public void setCodigoPostal(int codigoPostal) {
		this.codigoPostal = codigoPostal;
	}

	public String getNif() {
		return nif;
	}

	public void setNif(String nif) {
		this.nif = nif;
	}

	public String getPuestoTrabajo() {
		return puestoTrabajo;
	}

	public void setPuestoTrabajo(String puestoTrabajo) {
		this.puestoTrabajo = puestoTrabajo;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getMovil() {
		return movil;
	}

	public void setMovil(String movil) {
		this.movil = movil;
	}

	public String getCorreoElectronico() {
		return correoElectronico;
	}

	public void setCorreoElectronico(String correoElectronico) {
		this.correoElectronico = correoElectronico;
	}

	public String getSitioWeb() {
		return sitioWeb;
	}

	public void setSitioWeb(String sitioWeb) {
		this.sitioWeb = sitioWeb;
	}

	public Titulo getTitulo() {
		return titulo;
	}

	public void setTitulo(Titulo titulo) {
		this.titulo = titulo;
	}

	public String getNotas() {
		return notas;
	}

	public void setNotas(String notas) {
		this.notas = notas;
	}

	public boolean isRol() {
		return rol;
	}

	public void setRol(boolean rol) {
		this.rol = rol;
	}

	public String getComercial() {
		return comercial;
	}

	public void setComercial(String comercial) {
		this.comercial = comercial;
	}

	public String getReferenciaInterna() {
		return referenciaInterna;
	}

	public void setReferenciaInterna(String referenciaInterna) {
		this.referenciaInterna = referenciaInterna;
	}
	
	

}
