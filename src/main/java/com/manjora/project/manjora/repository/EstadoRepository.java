package com.manjora.project.manjora.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.manjora.project.manjora.entity.Estado;



@Repository
public interface EstadoRepository extends JpaRepository<Estado, Long> {

	Optional<Estado> findByNombreEstado(String nombreEstado);
	boolean existsByNombreEstado(String nombreEstado);
}
