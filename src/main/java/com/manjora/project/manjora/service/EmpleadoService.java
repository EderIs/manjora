package com.manjora.project.manjora.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.manjora.project.manjora.entity.Banco;
import com.manjora.project.manjora.entity.Empleado;
import com.manjora.project.manjora.repository.EmpleadoRepository;

@Service
@Transactional
public class EmpleadoService {

	@Autowired
	private EmpleadoRepository empleadoRepository;
	
	
	public List<Empleado> list(){
		return empleadoRepository.findAll();
	}
	
	public List<Empleado> findAllByNombre(String nombre) {
		
		return empleadoRepository.findAllByNombre(nombre);
	}
	
	public Optional<Empleado> getOne(Long id){
		return empleadoRepository.findById(id);
	}
	
	public Optional<Empleado> getByNombreEmpleado(String nombreEmpleado){
		return empleadoRepository.findByNombreEmpleado(nombreEmpleado);
	}
	
	public void save(Empleado empleado) {
		empleadoRepository.save(empleado);
	}
	
	public void delete(Long id) {
		empleadoRepository.deleteById(id);
	}
	
	public boolean existsById(Long id) {
		return empleadoRepository.existsById(id);
	}
	
	public boolean existsByNombreEmpleado(String nombreEmpleado) {
		return empleadoRepository.existsByNombreEmpleado(nombreEmpleado);
	}
}
