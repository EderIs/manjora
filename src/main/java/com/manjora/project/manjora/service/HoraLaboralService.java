package com.manjora.project.manjora.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.manjora.project.manjora.entity.Banco;
import com.manjora.project.manjora.entity.HoraLaboral;
import com.manjora.project.manjora.repository.HoraLaboralRepository;

@Service
@Transactional
public class HoraLaboralService {

	@Autowired
	private HoraLaboralRepository horaLaboralRepository;
	
	
	public List<HoraLaboral> list(){
		return horaLaboralRepository.findAll();
	}
	
	public List<HoraLaboral> findAllByNombre(String nombreHoraLaboral) {
		
		return horaLaboralRepository.findAllByNombre(nombreHoraLaboral);
	}
	
	public Optional<HoraLaboral> getOne(Long id){
		return horaLaboralRepository.findById(id);
	}
	
	public Optional<HoraLaboral> getByNombreHoraL(String nombreHoraLaboral){
		return horaLaboralRepository.findByNombreHoraL(nombreHoraLaboral);
	}
	
	public void save(HoraLaboral horaLaboral) {
		horaLaboralRepository.save(horaLaboral);
	}
	
	public void delete(Long id) {
		horaLaboralRepository.deleteById(id);
	}
	
	public boolean existsById(Long id) {
		return horaLaboralRepository.existsById(id);
	}
	
	public boolean existsByNombreHoraL(String nombreHoraL) {
		return horaLaboralRepository.existsByNombreHoraL(nombreHoraL);
	}
}
