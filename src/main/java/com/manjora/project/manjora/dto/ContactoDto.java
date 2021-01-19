package com.manjora.project.manjora.dto;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotBlank;

import com.manjora.project.manjora.entity.Contacto;
import com.manjora.project.manjora.entity.Estado;
import com.manjora.project.manjora.entity.Titulo;
import com.manjora.project.manjora.entity.Usuario;

public class ContactoDto {

	@NotBlank
	private String nombre;
	private boolean tipoContacto;
	private byte fotografia;

	@OneToOne
	@JoinColumn(name = "compania_id")
	private Contacto contacto;

	private String calle;
	private String calleSecundaria;
	private String ciudad;

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

	@ManyToOne
	@JoinColumn(name = "comercial_id")
	private Usuario usuario;

	private String referenciaInterna;

	public ContactoDto() {

	}

	public ContactoDto(@NotBlank String nombre, boolean tipoContacto, byte fotografia, Contacto contacto, String calle,
			String calleSecundaria, String ciudad, Estado estado, int codigoPostal, String nif, String puestoTrabajo,
			String telefono, String movil, String correoElectronico, String sitioWeb, Titulo titulo, String notas,
			boolean rol, Usuario usuario, String referenciaInterna) {
		super();
		this.nombre = nombre;
		this.tipoContacto = tipoContacto;
		this.fotografia = fotografia;
		this.contacto = contacto;
		this.calle = calle;
		this.calleSecundaria = calleSecundaria;
		this.ciudad = ciudad;
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
		this.usuario = usuario;
		this.referenciaInterna = referenciaInterna;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
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

	public Contacto getContacto() {
		return contacto;
	}

	public void setContacto(Contacto contacto) {
		this.contacto = contacto;
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

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public String getReferenciaInterna() {
		return referenciaInterna;
	}

	public void setReferenciaInterna(String referenciaInterna) {
		this.referenciaInterna = referenciaInterna;
	}

}
