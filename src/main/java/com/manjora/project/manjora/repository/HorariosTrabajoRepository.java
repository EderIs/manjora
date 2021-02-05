package com.manjora.project.manjora.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.manjora.project.manjora.entity.HoraLaboral;
import com.manjora.project.manjora.entity.HorariosDeTrabajo;
@Repository
public interface HorariosTrabajoRepository extends JpaRepository<HorariosDeTrabajo, Long>{

	@Query(value="select * from horarios_trabajos where nombre_horariost LIKE %?1%",nativeQuery = true)
	List<HorariosDeTrabajo>findAllByNombre(String nombreHorariosT);
	Optional<HorariosDeTrabajo> findByNombreHorariosT(String nombreHorariosT);
	boolean existsByNombreHorariosT(String nombreHorariosT);
	
}
