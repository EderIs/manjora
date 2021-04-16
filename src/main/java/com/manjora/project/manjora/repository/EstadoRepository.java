package com.manjora.project.manjora.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.manjora.project.manjora.entity.Banco;
import com.manjora.project.manjora.entity.Estado;



@Repository
public interface EstadoRepository extends JpaRepository<Estado, Long> {

	@Query(value="select * from estados where nombre_estado LIKE %?1%",nativeQuery = true)
	List<Estado>findAllByNombre(String nombreEstado);
	Optional<Estado> findByNombreEstado(String nombreEstado);
	boolean existsByNombreEstado(String nombreEstado);
}
