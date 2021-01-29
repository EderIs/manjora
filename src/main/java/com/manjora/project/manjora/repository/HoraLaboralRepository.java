package com.manjora.project.manjora.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.manjora.project.manjora.entity.Banco;
import com.manjora.project.manjora.entity.HoraLaboral;
import com.manjora.project.manjora.entity.HorariosDeTrabajo;

@Repository
public interface HoraLaboralRepository extends JpaRepository<HoraLaboral, Long>{

	@Query(value="select * from horas_laborales where nombre_horal LIKE %?1%",nativeQuery = true)
	List<HoraLaboral>findAllByNombre(String nombreHoraL);
	Optional<HoraLaboral> findByNombreHoraL(String nombreHoraL);
	boolean existsByNombreHoraL(String nombreHoraL);
	
}
