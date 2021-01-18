package com.manjora.project.manjora.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.manjora.project.manjora.entity.Titulo;
import com.manjora.project.manjora.entity.Usuario;
import com.manjora.project.manjora.repository.TituloRepository;

@Service
@Transactional
public class TituloService {

	@Autowired
	private TituloRepository tituloRepository;
	
	public List<Titulo> list(){
		return tituloRepository.findAll();
	}
	
	public Optional<Titulo> getOne(Long id){
		return tituloRepository.findById(id);
	}
	
	public Optional<Titulo> getByNombreTitulo(String nombreTitulo){
		return tituloRepository.findByNombreTitulo(nombreTitulo);
	}
	
	public void save(Titulo Titulo) {
		tituloRepository.save(Titulo);
	}
	
	public void delete(Long id) {
		tituloRepository.deleteById(id);
	}
	
	public boolean existsById(Long id) {
		return tituloRepository.existsById(id);
	}
	
	public boolean existsByNombreTitulo(String nombreTitulo) {
		return tituloRepository.existsByNombreTitulo(nombreTitulo);
	}
}
