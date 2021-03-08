package com.manjora.project.manjora.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.manjora.project.manjora.entity.Categoria;
import com.manjora.project.manjora.repository.CategoriaRepository;

@Service
@Transactional
public class CategoriaService {
	@Autowired
	private CategoriaRepository categoriaRepository;

	@Autowired
	private EntityManager entityManager;

	public void saveCategoria(Categoria categoria) throws Exception {

		this.categoriaRepository.save(categoria);

	}

	public List<Categoria> getCategoria(long idCategoria) {

		String consulta = "select e from Categoria e join e.notas p where p.id= " + idCategoria + " ";

		List<Categoria> categorias = entityManager.createQuery(consulta, Categoria.class).getResultList();

		return categorias;
	}

}
