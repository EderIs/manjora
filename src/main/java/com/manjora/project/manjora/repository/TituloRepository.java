package com.manjora.project.manjora.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.manjora.project.manjora.entity.Pais;
import com.manjora.project.manjora.entity.Titulo;
import com.manjora.project.manjora.entity.Usuario;

@Repository
public interface TituloRepository  extends JpaRepository<Titulo,Long>{

	@Query(value="select * from titulos where titulo LIKE %?1%",nativeQuery = true)
	List<Titulo>findAllByTitulo(String titulo);
	Optional<Titulo> findByTitulo(String nombreTitulo);
	boolean existsByTitulo(String nombreTitulo);
	
}
