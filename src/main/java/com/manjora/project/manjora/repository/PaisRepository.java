package com.manjora.project.manjora.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.manjora.project.manjora.entity.Pais;


@Repository
public interface PaisRepository extends JpaRepository<Pais, Long> {
	
	Optional<Pais> findByNombrePais(String nombrePais);
	boolean existsByNombrePais(String nombrePais);
}
