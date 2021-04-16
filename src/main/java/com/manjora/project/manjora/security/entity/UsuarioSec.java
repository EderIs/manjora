package com.manjora.project.manjora.security.entity;

import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import org.springframework.web.multipart.MultipartFile;

import com.sun.istack.NotNull;

@Entity
public class UsuarioSec {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    private String nombre;
    
    @Column(unique = true)
    private String nombreUsuario;
    @NotNull
    private String email;
    @NotNull
    private String password;
    
    private Date fechaCreacion;
	
    private Date ultimoAcceso;
	
	private boolean estado;
	
	private String pathImagen;
	
    
    @NotNull
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "usuario_rol", joinColumns = @JoinColumn(name = "usuario_id"),
    inverseJoinColumns = @JoinColumn(name = "rol_id"))
    private Set<RolSec> roles = new HashSet<>();

    public UsuarioSec() {
    }

    
    public UsuarioSec(int id, String nombre,String email) {
		
		this.id = id;
		this.nombre = nombre;
		this.email = email;
	}

    

	public UsuarioSec(String nombre, @NotNull String nombreUsuario, @NotNull String email, @NotNull String password) {
        this.nombre = nombre;
        this.nombreUsuario = nombreUsuario;
        this.email = email;
        this.password = password;
    }

    public UsuarioSec(int id, String nombre, String nombreUsuario, String email, String password, Date fechaCreacion,
			Date ultimoAcceso, boolean estado, String imagen, Set<RolSec> roles) {
		
    	this.id = id;
		this.nombre = nombre;
		this.nombreUsuario = nombreUsuario;
		this.email = email;
		this.password = password;
		this.fechaCreacion = fechaCreacion;
		this.ultimoAcceso = ultimoAcceso;
		this.estado = estado;
		this.pathImagen = imagen;
		this.roles = roles;
	}

	public UsuarioSec(String nombre,String nombreUsuario, String email, String password, Date fechaCreacion,
			Date ultimoAcceso, boolean estado) {
		this.nombre = nombre;
		this.nombreUsuario = nombreUsuario;
		this.email = email;
		this.password = password;
		this.fechaCreacion = fechaCreacion;
		this.ultimoAcceso = ultimoAcceso;
		this.estado = estado;
	}

	public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public Set<RolSec> getRoles() {
        return roles;
    }

    public void setRoles(Set<RolSec> roles) {
        this.roles = roles;
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

	public String getPathImagen() {
		return pathImagen;
	}

	public void setPathImagen(String imagen) {
		this.pathImagen = imagen;
	}
}
