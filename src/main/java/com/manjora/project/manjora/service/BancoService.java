package com.manjora.project.manjora.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.manjora.project.manjora.entity.Banco;
import com.manjora.project.manjora.entity.Usuario;
import com.manjora.project.manjora.repository.BancoRepository;

@Service
@Transactional
public class BancoService {

	@Autowired
	private BancoRepository bancoRepository;
	
	
	public List<Banco> list(){
		return bancoRepository.findAll();
	}
	
	public Optional<Banco> getOne(Long id){
		return bancoRepository.findById(id);
	}
	
	public Optional<Banco> getByNombreBanco(String nombreBanco){
		return bancoRepository.findByNombreBanco(nombreBanco);
	}
	
	public void save(Banco Banco) {
		bancoRepository.save(Banco);
	}
	
	public void delete(Long id) {
		bancoRepository.deleteById(id);
	}
	
	public boolean existsById(Long id) {
		return bancoRepository.existsById(id);
	}
	
	public boolean existsByNombreBanco(String nombreBanco) {
		return bancoRepository.existsByNombreBanco(nombreBanco);
	}
	
	
	
}