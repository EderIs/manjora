package com.manjora.project.manjora.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.manjora.project.manjora.entity.Banco;
import com.manjora.project.manjora.entity.Empleado;

@Repository
public interface EmpleadoRepository extends JpaRepository<Empleado, Long> {

	@Query(value="select * from empleados where nombreEmpleado LIKE %?1%",nativeQuery = true)
	List<Empleado>findAllByNombre(String nombre);
	Optional<Empleado> findByNombreEmpleado(String nombreEmpleado);
	boolean existsByNombreEmpleado(String nombreEmpleado);
}
