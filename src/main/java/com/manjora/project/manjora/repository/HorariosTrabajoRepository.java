package com.manjora.project.manjora.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.manjora.project.manjora.entity.HorariosDeTrabajo;
@Repository
public interface HorariosTrabajoRepository extends JpaRepository<HorariosDeTrabajo, Long>{

	Optional<HorariosDeTrabajo> findByNombreHorariosT(String nombreHorarios);
	boolean existsByNombreHorariosT(String nombreHorarios);
	
}
