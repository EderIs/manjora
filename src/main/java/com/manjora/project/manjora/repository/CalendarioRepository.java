package com.manjora.project.manjora.repository;

import java.sql.Date;
import java.sql.Time;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.manjora.project.manjora.entity.Calendario;

@Repository
public interface CalendarioRepository extends JpaRepository<Calendario, Long> {

	boolean existsByFecha(Date fecha);
	boolean existsByHoraInicio(Time horaI);
	List<Calendario>findAllByFecha(Date Fecha);
	
}
