package com.manjora.project.manjora.service;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.manjora.project.manjora.entity.Nota;
import com.manjora.project.manjora.repository.NotaRepository;

@Service
@Transactional
public class NotaService {

	@Autowired
	private NotaRepository notaRepository;
	
	@Autowired
	private EntityManager entityManager;
	
	public List<Nota>getNotasByIdCategoria(Long idNota){
		
		String consulta = "select new Nota(t.id,t.nombre,us,t.fechaFinal) from "
				+ "Nota t join t.usuario us join t.categoria e "
				+ "where e.id="+idNota;
		List<Nota> notas = entityManager.createQuery(consulta, Nota.class).getResultList();
		
		return notas;
	}
	
	public void deleteNotasByIdCategoria(Long idNota){
		
		String consulta = "DELETE FROM Nota WHERE categoria_id ="+idNota;
		entityManager.createQuery(consulta).executeUpdate();
	}
	
	public Nota getByIdNota(Long id) {
		return this.notaRepository.findById(id).get();
	}
	
	
	public void saveNota(Nota nota) {
		
		this.notaRepository.save(nota);
	}
	
	public void delete(Long id) {
		notaRepository.deleteById(id);
	}

	public boolean existsById(Long id) {
		return notaRepository.existsById(id);
	}
}
