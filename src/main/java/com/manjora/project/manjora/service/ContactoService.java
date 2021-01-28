package com.manjora.project.manjora.service;

import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.manjora.project.manjora.entity.Banco;
import com.manjora.project.manjora.entity.Contacto;
import com.manjora.project.manjora.repository.ContactoRepository;

@Service
@Transactional
public class ContactoService {

	@Autowired
	ContactoRepository contactoRepository;

	public List<Contacto> list() {
		return contactoRepository.findAll();
	}

	public Optional<Contacto> getOne(Long id) {
		return contactoRepository.findById(id);
	}

	public Optional<Contacto> getByNombreContacto(String nombreContacto) {
		return contactoRepository.findByNombreContacto(nombreContacto);
	}

	public void save(Contacto contacto) {
		contactoRepository.save(contacto);
	}

	public void delete(Long id) {
		contactoRepository.deleteById(id);
	}

	public boolean existsById(Long id) {
		return contactoRepository.existsById(id);
	}

	public boolean existsByNombreContacto(String nombreContacto) {
		return contactoRepository.existsByNombreContacto(nombreContacto);
	}
	public List<Contacto> findAllByNombre(String nombre) {
		
		return contactoRepository.findAllByNombre(nombre);
	}

}
