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
		
		String consulta = "select new Proyecto(p.id,p.nombreTarea) from Proyecto p join p.usuario us where us.id= "+idUser+" ";
		
		List<Proyecto> proyectos = entityManager.createQuery(consulta, Proyecto.class).getResultList();
		
		return proyectos;
	}
	
	
	public void saveProyecto(Proyecto proyecto) {
		
		this.proyectoRepository.save(proyecto);
	}
	
}
