package com.manjora.project.manjora.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.manjora.project.manjora.entity.Puesto;

@Repository
public interface PuestoRepository extends JpaRepository<Puesto, Long> {

	Optional<Puesto> findByNombrePuesto(String nombrePuesto);
	boolean existsByNombrePuesto(String nombrePuesto);
}
