package com.manjora.project.manjora.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.manjora.project.manjora.entity.Tarea;
import com.manjora.project.manjora.repository.TareaRepository;

@Service
@Transactional
public class TareaService {

	@Autowired
	private TareaRepository tareaRepository;
	
	@Autowired
	private EntityManager entityManager;
	
	public void SaveTarea(Tarea tarea)throws Exception {
		
		this.tareaRepository.save(tarea);
		
		
	}
	
	public Tarea getByIdTarea(Long id) {
		return this.tareaRepository.findById(id).get();
	}
	
	public List<Tarea> getTareasByEtapa(Long idEtapa) {
		
		String consulta = "select new Tarea(t.id,t.nombre,us,t.fechaFinal) from Tarea t join t.usuario us join t.etapa e where e.id="+idEtapa+" ";
		
		List<Tarea> tareas = entityManager.createQuery(consulta,Tarea.class).getResultList();
		
		return tareas;
	}
	
}
