package com.manjora.project.manjora.service;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.manjora.project.manjora.entity.Nota;
import com.manjora.project.manjora.entity.Tarea;
import com.manjora.project.manjora.repository.NotaRepository;

@Service
public class NotaService {

	@Autowired
	private NotaRepository notaRepository;
	
	@Autowired
	private EntityManager entityManager;
	
	public List<Nota>getNotasByIdCategoria(Long idCat){
		
		String consulta = "select new Nota(p.id,p.nombre) from Nota p join p.categoria_nota us where us.id= "+idCat+" ";
		
		List<Nota> notas = entityManager.createQuery(consulta, Nota.class).getResultList();
		
		return notas;
	}
	
	public Nota getByIdNota(Long id) {
		return this.notaRepository.findById(id).get();
	}
	
	
	public void saveNota(Nota nota) {
		
		this.notaRepository.save(nota);
	}
}
