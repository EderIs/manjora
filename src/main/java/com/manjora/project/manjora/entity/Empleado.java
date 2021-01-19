package com.manjora.project.manjora.entity;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

//dhjd

@Entity
@Table(name = "empleados")
public class Empleado {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private byte fotografia;
	private String nombreEmpleado;
	
	private Long idCategoria;
	private Long direccionTrabajo;
	
	private Long idPuesto;
	
	private String tituloTrabajo;
	
	@OneToOne
    @JoinColumn(name="responsable_id", referencedColumnName = "id")
	private Empleado idResponsable;
	
	@ManyToOne
    @JoinColumn(name="monitor_id", referencedColumnName = "id")
	private Empleado idMonitor;
	
	@ManyToOne
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
	private String Sexo;
	private String estadoCivil;
	private int numeroHijos;
	private Date fechaNacimiento;
	private String lugarNacimiento;
	private String nivelCertificado;
	private String escuela;
	private String notaAdicional;
	
	@ManyToOne
    @JoinColumn(name="usuario_id", referencedColumnName = "id")
	private Usuario idUsuario;
	
	
	private String nota;
	private boolean estado;
	public Empleado() {
	
	}
	
	public Empleado(byte fotografia, String nombreEmpleado,/* Long idCategoria, Long direccionTrabajo, Long idDepartamento,
			Long idPuesto, */String tituloTrabajo,/* Long idResponsable, Long idMonitor, Long horasLaborales,
			Long idCuentaBancaria,*/ String direccionPrivada, String contactoEmergencia, String telefonoEmergencia,
			double kmCasaTrabajo, String sexo, String estadoCivil, int numeroHijos, Date fechaNacimiento,
			String lugarNacimiento, String nivelCertificado, String escuela, String notaAdicional,/* Long idUsuario,*/
			String nota, boolean estado) {
		this.fotografia = fotografia;
		this.nombreEmpleado = nombreEmpleado;
		/*
		this.idCategoria = idCategoria;
		this.direccionTrabajo = direccionTrabajo;
		this.idDepartamento = idDepartamento;
		this.idPuesto = idPuesto;
		*/
		this.tituloTrabajo = tituloTrabajo;
		/*
		this.idResponsable = idResponsable;
		this.idMonitor = idMonitor;
		this.horasLaborales = horasLaborales;
		this.idCuentaBancaria = idCuentaBancaria;
		*/
		this.direccionPrivada = direccionPrivada;
		this.contactoEmergencia = contactoEmergencia;
		this.telefonoEmergencia = telefonoEmergencia;
		this.kmCasaTrabajo = kmCasaTrabajo;
		Sexo = sexo;
		this.estadoCivil = estadoCivil;
		this.numeroHijos = numeroHijos;
		this.fechaNacimiento = fechaNacimiento;
		this.lugarNacimiento = lugarNacimiento;
		this.nivelCertificado = nivelCertificado;
		this.escuela = escuela;
		this.notaAdicional = notaAdicional;
		//this.idUsuario = idUsuario;
		this.nota = nota;
		this.estado = estado;
	}
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public byte getFotografia() {
		return fotografia;
	}
	public void setFotografia(byte fotogra) {
		this.fotografia = fotografia;
	}
	public String getNombreEmpleado() {
		return nombreEmpleado;
	}
	public void setNombreEmpleado(String nombreEmpleado) {
		this.nombreEmpleado = nombreEmpleado;
	}
	/*
	public Long getIdCategoria() {
		return idCategoria;
	}
	public void setIdCategoria(Long idCategoria) {
		this.idCategoria = idCategoria;
	}
	public Long getDireccionTrabajo() {
		return direccionTrabajo;
	}
	public void setDireccionTrabajo(Long direccionTrabajo) {
		this.direccionTrabajo = direccionTrabajo;
	}
	public Long getIdDepartamento() {
		return idDepartamento;
	}
	public void setIdDepartamento(Long idDepartamento) {
		this.idDepartamento = idDepartamento;
	}
	public Long getIdPuesto() {
		return idPuesto;
	}
	public void setIdPuesto(Long idPuesto) {
		this.idPuesto = idPuesto;
	}
	*/
	public String getTituloTrabajo() {
		return tituloTrabajo;
	}
	public void setTituloTrabajo(String tituloTrabajo) {
		this.tituloTrabajo = tituloTrabajo;
	}
	/*
	public Long getIdResponsable() {
		return idResponsable;
	}
	public void setIdResponsable(Long idResponsable) {
		this.idResponsable = idResponsable;
	}
	public Long getIdMonitor() {
		return idMonitor;
	}
	public void setIdMonitor(Long idMonitor) {
		this.idMonitor = idMonitor;
	}
	public Long getHorasLaborales() {
		return horasLaborales;
	}
	public void setHorasLaborales(Long horasLaborales) {
		this.horasLaborales = horasLaborales;
	}
	public Long getIdCuentaBancaria() {
		return idCuentaBancaria;
	}
	public void setIdCuentaBancaria(Long idCuentaBancaria) {
		this.idCuentaBancaria = idCuentaBancaria;
	}
	*/
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
		return Sexo;
	}
	public void setSexo(String sexo) {
		Sexo = sexo;
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
	/*
	public Long getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(Long idUsuario) {
		this.idUsuario = idUsuario;
	}
	*/
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
