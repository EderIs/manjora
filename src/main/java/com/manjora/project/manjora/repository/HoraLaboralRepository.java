package com.manjora.project.manjora.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.manjora.project.manjora.entity.HoraLaboral;
import com.manjora.project.manjora.entity.HorariosDeTrabajo;

@Repository
public interface HoraLaboralRepository extends JpaRepository<HoraLaboral, Long>{

	Optional<HoraLaboral> findByNombreHoraL(String nombreHoraL);
	boolean existsByNombreHoraL(String nombreHoraL);
	
}
