package com.manjora.project.manjora.repository;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.manjora.project.manjora.entity.Calendario;
import com.manjora.project.manjora.entity.Notificacion;

@Repository
public interface NotificacionRepository extends JpaRepository<Notificacion, Long>{

}
