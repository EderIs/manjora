package com.manjora.project.manjora.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.manjora.project.manjora.entity.Banco;
import com.manjora.project.manjora.entity.Contacto;


@Repository
public interface ContactoRepository extends JpaRepository<Contacto, Long> {
	@Query(value="select * from contactos where nombre_contacto LIKE %?1%",nativeQuery = true)
	List<Contacto>findAllByNombre(String nombre);
	Optional<Contacto> findByNombreContacto(String nombreContacto);
	boolean existsByNombreContacto(String nombreContacto);
}
