package com.manjora.project.manjora.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="titulos")
public class Titulo {

@Id
@GeneratedValue(strategy = GenerationType.AUTO)
private Long id;
private String titulo;
private String abreviatura;

public Titulo() {}

public Titulo(String titulo, String abreviatura) {
	
	this.titulo = titulo;
	this.abreviatura = abreviatura;
}

public Long getId() {
	return id;
}

public void setId(Long id) {
	this.id = id;
}

public String getTitulo() {
	return titulo;
}

public void setTitulo(String titulo) {
	this.titulo = titulo;
}

public String getAbreviatura() {
	return abreviatura;
}

public void setAbreviatura(String abreviatura) {
	this.abreviatura = abreviatura;
}

}
