package com.manjora.project.manjora.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.manjora.project.manjora.entity.Actividad;

@Repository
public interface ActividadRepository  extends JpaRepository<Actividad, Long>{

	
}
