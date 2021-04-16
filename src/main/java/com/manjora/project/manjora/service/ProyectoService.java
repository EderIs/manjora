package com.manjora.project.manjora.service;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import com.manjora.project.manjora.entity.Proyecto;
import com.manjora.project.manjora.repository.ProyectoRepository;

@Service
public class ProyectoService {

	@Autowired
	private ProyectoRepository proyectoRepository;
	
	@Autowired
	private EntityManager entityManager;
	
	public List<Proyecto>getProyectosByIdUser(Long idUser){
		
		String consulta = "select DISTINCT new Proyecto(pro.id, pro.nombreTarea,usp) from Tarea t "
				+ "join t.usuario us right join t.etapa et right join et.proyecto pro join pro.usuario usp "
				+ "where (usp.id= "+idUser+") or (us.id= "+idUser+") " ;
		
		List<Proyecto> proyectos = entityManager.createQuery(consulta, Proyecto.class).getResultList();
		
		return proyectos;
	}
	
	
	public void saveProyecto(Proyecto proyecto) {
		
		this.proyectoRepository.save(proyecto);
	}
	
}
