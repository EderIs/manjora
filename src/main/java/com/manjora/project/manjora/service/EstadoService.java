package com.manjora.project.manjora.service;

import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.manjora.project.manjora.entity.Estado;
import com.manjora.project.manjora.repository.EstadoRepository;

@Service
@Transactional
public class EstadoService {

	@Autowired
	EstadoRepository estadoRepository;

	public List<Estado> list() {
		return estadoRepository.findAll();
	}

	public Optional<Estado> getOne(Long id) {
		return estadoRepository.findById(id);
	}

	public Optional<Estado> getByNombreEstado(String nombreEstado) {
		return estadoRepository.findByNombreEstado(nombreEstado);
	}

	public void save(Estado estado) {
		estadoRepository.save(estado);
	}

	public void delete(Long id) {
		estadoRepository.deleteById(id);
	}

	public boolean existsById(Long id) {
		return estadoRepository.existsById(id);
	}

	public boolean existsByNombreEstado(String nombreEstado) {
		return estadoRepository.existsByNombreEstado(nombreEstado);
	}

}
