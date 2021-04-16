package com.manjora.project.manjora.security.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.manjora.project.manjora.security.entity.UsuarioSec;

@Repository
public interface UsuarioSecRepository  extends JpaRepository<UsuarioSec, Integer>{

	Optional<UsuarioSec> findByNombreUsuario(String nombreUsuario);
	  boolean existsByNombreUsuario(String nombreUsuario);
	  boolean existsByEmail(String email);
	
}
