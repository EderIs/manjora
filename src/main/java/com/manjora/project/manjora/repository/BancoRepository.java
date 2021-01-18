package com.manjora.project.manjora.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.manjora.project.manjora.entity.Banco;

@Repository
public interface BancoRepository extends JpaRepository<Banco, Long>{

	Optional<Banco> findByNombreBanco(String nombreBanco);
	boolean existsByNombreBanco(String nombreBanco);
	
}
