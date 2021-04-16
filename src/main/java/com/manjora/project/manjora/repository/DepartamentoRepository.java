package com.manjora.project.manjora.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.manjora.project.manjora.entity.Departamento;
import com.manjora.project.manjora.entity.Empleado;

@Repository
public interface DepartamentoRepository extends JpaRepository<Departamento, Long> {

	Optional<Departamento> findByNombreDepartamento(String nombreDepartamento);
	boolean existsByNombreDepartamento(String nombreDepartamento);
}
