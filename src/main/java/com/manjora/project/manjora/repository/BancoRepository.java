package com.manjora.project.manjora.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.manjora.project.manjora.entity.Banco;

@Repository
public interface BancoRepository extends JpaRepository<Banco, Long>{

	@Query(value="select * from bancos where nombre LIKE %?1%",nativeQuery = true)
	List<Banco>findAllByNombre(String nombre);
	Optional<Banco> findByNombre(String nombre);
	boolean existsByNombre(String nombre);
	
}
