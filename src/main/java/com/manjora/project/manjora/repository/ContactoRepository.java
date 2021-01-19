package com.manjora.project.manjora.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.manjora.project.manjora.entity.Contacto;


@Repository
public interface ContactoRepository extends JpaRepository<Contacto, Long> {

	Optional<Contacto> findByNombreContacto(String nombreContacto);
	boolean existsByNombreContacto(String nombreContacto);
	
}
