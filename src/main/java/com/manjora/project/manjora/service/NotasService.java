package com.manjora.project.manjora.service;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.manjora.project.manjora.entity.Notas;
import com.manjora.project.manjora.repository.NotasRepository;

@Service
public class NotasService {

	@Autowired
	private NotasRepository notasRepository;
	
	@Autowired
	private EntityManager entityManager;
	
	public List<Notas>getNotasByIdUser(Long idUser){
		
		String consulta = "select new Notas(p.id,p.titulo) from Notas p join p.usuario us where us.id= "+idUser+" ";
		
		List<Notas> notas = entityManager.createQuery(consulta, Notas.class).getResultList();
		
		return notas;
	}
	
	
	public void saveNotas(Notas proyecto) {
		
		this.notasRepository.save(proyecto);
	}
}
