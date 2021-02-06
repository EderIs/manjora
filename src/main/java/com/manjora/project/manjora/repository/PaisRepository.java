package com.manjora.project.manjora.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.manjora.project.manjora.entity.Estado;
import com.manjora.project.manjora.entity.Pais;


@Repository
public interface PaisRepository extends JpaRepository<Pais, Long> {
	@Query(value="select * from paises where nombre_pais LIKE %?1%",nativeQuery = true)
	List<Pais>findAllByNombre(String nombrePais);
	Optional<Pais> findByNombrePais(String nombrePais);
	boolean existsByNombrePais(String nombrePais);
}
