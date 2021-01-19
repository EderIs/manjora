package com.manjora.project.manjora.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.manjora.project.manjora.entity.HorariosDeTrabajo;
import com.manjora.project.manjora.repository.HorariosTrabajoRepository;

@Service
@Transactional
public class HorariosTrabajoService {

	@Autowired
	private HorariosTrabajoRepository horarioTrabajoRepository;
	
	
	public List<HorariosDeTrabajo> list(){
		return horarioTrabajoRepository.findAll();
	}
	
	public Optional<HorariosDeTrabajo> getOne(Long id){
		return horarioTrabajoRepository.findById(id);
	}
	
	public Optional<HorariosDeTrabajo> getByNombreHorariosDeTrabajo(String nombreHorariosDeTrabajo){
		return horarioTrabajoRepository.findByNombreHorariosT(nombreHorariosDeTrabajo);
	}
	
	public void save(HorariosDeTrabajo HorariosDeTrabajo) {
		horarioTrabajoRepository.save(HorariosDeTrabajo);
	}
	
	public void delete(Long id) {
		horarioTrabajoRepository.deleteById(id);
	}
	
	public boolean existsById(Long id) {
		return horarioTrabajoRepository.existsById(id);
	}
	
	public boolean existsByNombreHorariosT(String nombreHorariosDeTrabajo) {
		return horarioTrabajoRepository.existsByNombreHorariosT(nombreHorariosDeTrabajo);
	}
	
}
