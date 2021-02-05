package com.manjora.project.manjora.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.manjora.project.manjora.entity.Estado;
import com.manjora.project.manjora.entity.Pais;
import com.manjora.project.manjora.repository.PaisRepository;

@Service
@Transactional
public class PaisService {

	@Autowired
	PaisRepository paisRepository;
	
	public List<Pais> list(){
		return paisRepository.findAll();
	}
	
	public Optional<Pais> getOne(Long id){
		return paisRepository.findById(id);
	}
	
	public Optional<Pais> getByNombrePais(String nombrePais){
		return paisRepository.findByNombrePais(nombrePais);
	}
	
	public void save(Pais pais) {
		paisRepository.save(pais);
	}
	
	public void delete(Long id) {
		paisRepository.deleteById(id);
	}
	
	public boolean existsById(Long id) {
		return paisRepository.existsById(id);
	}
	
	public boolean existsByNombrePais(String nombrePais) {
		return paisRepository.existsByNombrePais(nombrePais);
	}
	
	public List<Pais> findAllByNombre(String nombrePais) {
		
		return paisRepository.findAllByNombre(nombrePais);
	}

}
