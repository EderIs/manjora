package com.manjora.project.manjora.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.manjora.project.manjora.entity.Puesto;
import com.manjora.project.manjora.repository.PuestoRepository;

@Service
@Transactional
public class PuestoService {

	@Autowired
	private PuestoRepository puestoRepository;
	
	
	public List<Puesto> list(){
		return puestoRepository.findAll();
	}
	
	public Optional<Puesto> getOne(Long id){
		return puestoRepository.findById(id);
	}
	
	public Optional<Puesto> getByNombrePuesto(String nombrePuesto){
		return puestoRepository.findByNombrePuesto(nombrePuesto);
	}
	
	public void save(Puesto puesto) {
		puestoRepository.save(puesto);
	}
	
	public void delete(Long id) {
		puestoRepository.deleteById(id);
	}
	
	public boolean existsById(Long id) {
		return puestoRepository.existsById(id);
	}
	
	public boolean existsByNombrePuesto(String nombrePuesto) {
		return puestoRepository.existsByNombrePuesto(nombrePuesto);
	}
}
