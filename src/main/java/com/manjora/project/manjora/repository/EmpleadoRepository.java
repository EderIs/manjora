package com.manjora.project.manjora.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.manjora.project.manjora.entity.Empleado;

@Repository
public interface EmpleadoRepository extends JpaRepository<Empleado, Long> {

	Optional<Empleado> findByNombreEmpleado(String nombreEmpleado);
	boolean existsByNombreEmpleado(String nombreEmpleado);
}
