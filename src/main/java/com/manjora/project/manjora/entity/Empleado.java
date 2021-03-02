package com.manjora.project.manjora.entity;

import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.manjora.project.manjora.security.entity.UsuarioSec;


@Entity
@Table(name = "empleados")
public class Empleado {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String fotografia;
	private String nombreEmpleado;
	
	@Column(name = "id_categoria")
	private Long categoria;
	
	@OneToOne(cascade = CascadeType.REFRESH)
    @JoinColumn(name="direccion_id", referencedColumnName = "id")
	private Contacto direccionTrabajo;
	
	@OneToOne(cascade = CascadeType.REFRESH)
    @JoinColumn(name="puesto_id", referencedColumnName = "id")
	private Puesto puesto;
	
	private String tituloTrabajo;
	
	@OneToOne(cascade = CascadeType.REFRESH)
    @JoinColumn(name="responsable_id", referencedColumnName = "id")
	private Empleado responsable;
	
	@ManyToOne(cascade = CascadeType.REFRESH)
    @JoinColumn(name="monitor_id", referencedColumnName = "id")
	private Empleado monitor;
	
	@ManyToOne(cascade = CascadeType.REFRESH)
    @JoinColumn(name="horasLaborales_id", referencedColumnName = "id")
	private HoraLaboral horasLaborales;
	
	/*
	@ManyToOne
    @JoinColumn(name="cuentaBancaria_id", referencedColumnName = "id")
	private CuentaBancaria idCuentaBancaria;
	*/
	
	private String direccionPrivada;
	private String contactoEmergencia;
	private String telefonoEmergencia;
	private double kmCasaTrabajo;
	private String sexo;
	private String estadoCivil;
	private int numeroHijos;
	private Date fechaNacimiento;
	private String lugarNacimiento;
	private String nivelCertificado;
	private String escuela;
	private String notaAdicional;
	@OneToOne(cascade = CascadeType.REFRESH)
    @JoinColumn(name="usuario_id", referencedColumnName = "id")
	private UsuarioSec usuario;
	private String nota;
	private boolean estado;
	public Empleado() {
	
	}
	public Empleado(String fotografia, String nombreEmpleado, Long categoria, Contacto direccionTrabajo,
			Puesto puesto, String tituloTrabajo, Empleado responsable, Empleado monitor,
			HoraLaboral horasLaborales, String direccionPrivada, String contactoEmergencia, String telefonoEmergencia,
			double kmCasaTrabajo, String sexo, String estadoCivil, int numeroHijos, Date fechaNacimiento,
			String lugarNacimiento, String nivelCertificado, String escuela, String notaAdicional, UsuarioSec usuario,
			String nota, boolean estado) {
		super();
		
		this.fotografia = fotografia;
		this.nombreEmpleado = nombreEmpleado;
		this.categoria = categoria;
		this.direccionTrabajo = direccionTrabajo;
		this.puesto = puesto;
		this.tituloTrabajo = tituloTrabajo;
		this.responsable = responsable;
		this.monitor = monitor;
		this.horasLaborales = horasLaborales;
		this.direccionPrivada = direccionPrivada;
		this.contactoEmergencia = contactoEmergencia;
		this.telefonoEmergencia = telefonoEmergencia;
		this.kmCasaTrabajo = kmCasaTrabajo;
		this.sexo = sexo;
		this.estadoCivil = estadoCivil;
		this.numeroHijos = numeroHijos;
		this.fechaNacimiento = fechaNacimiento;
		this.lugarNacimiento = lugarNacimiento;
		this.nivelCertificado = nivelCertificado;
		this.escuela = escuela;
		this.notaAdicional = notaAdicional;
		this.usuario = usuario;
		this.nota = nota;
		this.estado = estado;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getFotografia() {
		return fotografia;
	}
	public void setFotografia(String fotografia) {
		this.fotografia = fotografia;
	}
	public String getNombreEmpleado() {
		return nombreEmpleado;
	}
	public void setNombreEmpleado(String nombreEmpleado) {
		this.nombreEmpleado = nombreEmpleado;
	}
	public Long getCategoria() {
		return categoria;
	}
	public void setCategoria(Long categoria) {
		this.categoria = categoria;
	}
	public Contacto getDireccionTrabajo() {
		return direccionTrabajo;
	}
	public void setDireccionTrabajo(Contacto direccionTrabajo) {
		this.direccionTrabajo = direccionTrabajo;
	}
	public Puesto getPuesto() {
		return puesto;
	}
	public void setPuesto(Puesto puesto) {
		this.puesto = puesto;
	}
	public String getTituloTrabajo() {
		return tituloTrabajo;
	}
	public void setTituloTrabajo(String tituloTrabajo) {
		this.tituloTrabajo = tituloTrabajo;
	}
	public Empleado getResponsable() {
		return responsable;
	}
	public void setResponsable(Empleado responsable) {
		this.responsable = responsable;
	}
	public Empleado getMonitor() {
		return monitor;
	}
	public void setMonitor(Empleado monitor) {
		this.monitor = monitor;
	}
	public HoraLaboral getHorasLaborales() {
		return horasLaborales;
	}
	public void setHorasLaborales(HoraLaboral horasLaborales) {
		this.horasLaborales = horasLaborales;
	}
	public String getDireccionPrivada() {
		return direccionPrivada;
	}
	public void setDireccionPrivada(String direccionPrivada) {
		this.direccionPrivada = direccionPrivada;
	}
	public String getContactoEmergencia() {
		return contactoEmergencia;
	}
	public void setContactoEmergencia(String contactoEmergencia) {
		this.contactoEmergencia = contactoEmergencia;
	}
	public String getTelefonoEmergencia() {
		return telefonoEmergencia;
	}
	public void setTelefonoEmergencia(String telefonoEmergencia) {
		this.telefonoEmergencia = telefonoEmergencia;
	}
	public double getKmCasaTrabajo() {
		return kmCasaTrabajo;
	}
	public void setKmCasaTrabajo(double kmCasaTrabajo) {
		this.kmCasaTrabajo = kmCasaTrabajo;
	}
	public String getSexo() {
		return sexo;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	public String getEstadoCivil() {
		return estadoCivil;
	}
	public void setEstadoCivil(String estadoCivil) {
		this.estadoCivil = estadoCivil;
	}
	public int getNumeroHijos() {
		return numeroHijos;
	}
	public void setNumeroHijos(int numeroHijos) {
		this.numeroHijos = numeroHijos;
	}
	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}
	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
	public String getLugarNacimiento() {
		return lugarNacimiento;
	}
	public void setLugarNacimiento(String lugarNacimiento) {
		this.lugarNacimiento = lugarNacimiento;
	}
	public String getNivelCertificado() {
		return nivelCertificado;
	}
	public void setNivelCertificado(String nivelCertificado) {
		this.nivelCertificado = nivelCertificado;
	}
	public String getEscuela() {
		return escuela;
	}
	public void setEscuela(String escuela) {
		this.escuela = escuela;
	}
	public String getNotaAdicional() {
		return notaAdicional;
	}
	public void setNotaAdicional(String notaAdicional) {
		this.notaAdicional = notaAdicional;
	}
	public UsuarioSec getUsuario() {
		return usuario;
	}
	public void setUsuario(UsuarioSec usuario) {
		this.usuario = usuario;
	}
	public String getNota() {
		return nota;
	}
	public void setNota(String nota) {
		this.nota = nota;
	}
	public boolean isEstado() {
		return estado;
	}
	public void setEstado(boolean estado) {
		this.estado = estado;
	}
}
