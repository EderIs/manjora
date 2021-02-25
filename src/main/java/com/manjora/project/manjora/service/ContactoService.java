package com.manjora.project.manjora.service;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
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
	
	@Autowired
	private EntityManager entityManager;

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
	
	public List<Contacto> getAllContactoToCalendario(int id){
		
		String consulta = "select new Contacto(c.id,c.nombreContacto) from Contacto c where c.id != "+id+" ";
		
		List<Contacto> contactos = entityManager.createQuery(consulta, Contacto.class).getResultList();
		
		return contactos;
	}
	
	public Long getContactoId(int idUser) {
		
			String consulta = "select c.id from Contacto c join c.usuario us where us.id = "+idUser+" ";
			
			Long contactoI = entityManager.createQuery(consulta, Long.class).getSingleResult(); 
			
			return contactoI;			
	}

}
