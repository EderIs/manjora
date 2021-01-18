package com.manjora.project.manjora.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.manjora.project.manjora.entity.Titulo;
import com.manjora.project.manjora.entity.Usuario;

@Repository
public interface TituloRepository  extends JpaRepository<Titulo,Long>{

	Optional<Titulo> findByNombreTitulo(String nombreTitulo);
	boolean existsByNombreTitulo(String nombreTitulo);
	
}