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

	public List<Categoria> getCategoria(long idUser) {

		String consulta = "select DISTINCT new Categoria(cat.id, cat.nombre,usp) from Nota n "
				+ "join n.usuario us right join n.categoria cat join cat.usuario usp "
				+ "where (usp.id= "+idUser+") or (us.id= "+idUser+") " ;
		List<Categoria> categorias = entityManager.createQuery(consulta, Categoria.class).getResultList();

		return categorias;
	}
	
	public void delete(Long id) {
		categoriaRepository.deleteById(id);
	}

	public boolean existsById(Long id) {
		return categoriaRepository.existsById(id);
	}
	
	public Categoria categoriaById(long id) {
		return this.categoriaRepository.findById(id).get();		
	}

}
