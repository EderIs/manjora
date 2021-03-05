package com.manjora.project.manjora.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.manjora.project.manjora.entity.CategoriaNota;
import com.manjora.project.manjora.repository.CategoriaNotaRepository;

@Service
@Transactional
public class CategoriaNotaService {
	@Autowired
	private CategoriaNotaRepository categoriaNotaRepository;

	@Autowired
	private EntityManager entityManager;

	public void saveCategoriaNota(CategoriaNota categoria) throws Exception {

		this.categoriaNotaRepository.save(categoria);

	}

	public List<CategoriaNota> getCategoriaNota(long idCategoria) {

		String consulta = "select e from CategoriaNota e join e.notas p where p.id= " + idCategoria + " ";

		List<CategoriaNota> categorias = entityManager.createQuery(consulta, CategoriaNota.class).getResultList();

		return categorias;
	}

}
