package com.manjora.project.manjora.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.manjora.project.manjora.entity.Departamento;
import com.manjora.project.manjora.repository.DepartamentoRepository;

@Service
@Transactional
public class DepartamentoService {
	
	@Autowired
	private DepartamentoRepository departamentoRepository;
	
	
	public List<Departamento> list(){
		return departamentoRepository.findAll();
	}
	
	public Optional<Departamento> getOne(Long id){
		return departamentoRepository.findById(id);
	}
	
	public Optional<Departamento> getByNombreDepartamento(String nombreDepartamento){
		return departamentoRepository.findByNombreDepartamento(nombreDepartamento);
	}
	
	public void save(Departamento departamento) {
		departamentoRepository.save(departamento);
	}
	
	public void delete(Long id) {
		departamentoRepository.deleteById(id);
	}
	
	public boolean existsById(Long id) {
		return departamentoRepository.existsById(id);
	}
	
	public boolean existsByNombreDepartamento(String nombreDepartamento) {
		return departamentoRepository.existsByNombreDepartamento(nombreDepartamento);
	}

}
