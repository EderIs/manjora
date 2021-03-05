package com.manjora.project.manjora.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.manjora.project.manjora.entity.Actividad;
import com.manjora.project.manjora.repository.ActividadRepository;

@Service
@Transactional
public class ActividadService {

	@Autowired
	private ActividadRepository actividadRepository;

	@Autowired
	private EntityManager entityManager;
	
	public void saveActividad(Actividad actividad)throws Exception {
		this.actividadRepository.save(actividad);
	}
	
	
	public void deleteActividad(Actividad actividad)throws Exception{
		
		this.actividadRepository.delete(actividad);
	}
	
	public Actividad getActividad(Long idA) {
		
		return this.actividadRepository.findById(idA).get();
	}
	
	public List<Actividad>getActividades(Long idT){
		String consulta = "select new Actividad(a.id,a.actividad,a.resumen,a.fechaFinal,a.fechaEntrega,us,a.estadoT) from "
				+ "Actividad a join a.usuario us join a.tarea t where t.id= "+idT+" ";
		
		List<Actividad>actividades = entityManager.createQuery(consulta, Actividad.class).getResultList();
		
		return actividades;
		
	}
	
	
}
