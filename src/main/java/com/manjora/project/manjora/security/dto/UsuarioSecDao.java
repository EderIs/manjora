package com.manjora.project.manjora.security.dto;

import java.io.File;
import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import org.springframework.web.multipart.MultipartFile;

import com.manjora.project.manjora.security.entity.RolSec;

public class UsuarioSecDao {
	
	@NotBlank
    private String nombre;
    @NotBlank
    private String nombreUsuario;
    @Email
    private String email;
    @NotBlank
    private String password;
    
    private Date fechaCreacion;
	
    private Date ultimoAcceso;
	
<<<<<<< HEAD:src/main/java/com/manjora/project/manjora/security/dto/UsuarioSecDao.java
=======
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String nombreUsuario;
	private String direccionCorreo;
	private String contrasena;
	private Date fechaCreacion;
	private Date ultimoAcceso;
>>>>>>> main:src/main/java/com/manjora/project/manjora/entity/Usuario.java
	private boolean estado;
    	
	private String pathImagen;
	
    private Set<RolSec> roles = new HashSet<>();

    
	public UsuarioSecDao() {
		
	}



	public UsuarioSecDao(@NotBlank String nombre, @NotBlank String nombreUsuario, @Email String email,
			@NotBlank String password, Date fechaCreacion, Date ultimoAcceso, boolean estado, Set<RolSec> roles) {
		
		this.nombre = nombre;
		this.nombreUsuario = nombreUsuario;
		this.email = email;
		this.password = password;
		this.fechaCreacion = fechaCreacion;
		this.ultimoAcceso = ultimoAcceso;
		this.estado = estado;
		this.roles = roles;
	}



	public String getNombre() {
		return nombre;
	}



	public void setNombre(String nombre) {
		this.nombre = nombre;
	}



	public String getNombreUsuario() {
		return nombreUsuario;
	}



	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public String getPassword() {
		return password;
	}



	public void setPassword(String password) {
		this.password = password;
	}



	public Date getFechaCreacion() {
		return fechaCreacion;
	}



	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}



	public Date getUltimoAcceso() {
		return ultimoAcceso;
	}



	public void setUltimoAcceso(Date ultimoAcceso) {
		this.ultimoAcceso = ultimoAcceso;
	}



	public boolean isEstado() {
		return estado;
	}



	public void setEstado(boolean estado) {
		this.estado = estado;
	}

<<<<<<< HEAD:src/main/java/com/manjora/project/manjora/security/dto/UsuarioSecDao.java
	
	public Set<RolSec> getRoles() {
		return roles;
	}


	public void setRoles(Set<RolSec> roles) {
		this.roles = roles;
	}



	public String getPathImagen() {
		return pathImagen;
	}



	public void setPathImagen(String pathImagen) {
		this.pathImagen = pathImagen;
	}
	
=======
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
>>>>>>> main:src/main/java/com/manjora/project/manjora/entity/Usuario.java
	
}
