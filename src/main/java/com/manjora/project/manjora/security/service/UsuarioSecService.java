package com.manjora.project.manjora.security.service;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.manjora.project.manjora.security.entity.UsuarioSec;
import com.manjora.project.manjora.security.repository.UsuarioSecRepository;

@Service
@Transactional
public class UsuarioSecService {

	@Autowired
    UsuarioSecRepository usuarioRepository;
	
	@Autowired
	EntityManager en;

	public List<UsuarioSec> list(){
		return usuarioRepository.findAll();
	}
	
	public Optional<UsuarioSec> getOne(int id){
		return usuarioRepository.findById(id);
	}
	
    public Optional<UsuarioSec> getByNombreUsuario(String nombreUsuario){
        return usuarioRepository.findByNombreUsuario(nombreUsuario);
    }

    public boolean existsByNombreUsuario(String nombreUsuario){
        return usuarioRepository.existsByNombreUsuario(nombreUsuario);
    }

    public boolean existsByEmail(String email){
        return usuarioRepository.existsByEmail(email);
    }

    public boolean existsById(int id) {
		return usuarioRepository.existsById(id);
	}
    
    public void save(UsuarioSec usuario){
        usuarioRepository.save(usuario);
    }	
    
    public void delete(int id) {
		usuarioRepository.deleteById(id);
	}
    
    
    public List<String>findAllByEstado(){
		
		final String consulta = "SELECT email from UsuarioSec where estado=false";
		
		TypedQuery<String>query = en.createQuery(consulta,String.class);
		
		List<String>usuarios= query.getResultList();
		
		return usuarios;		
	}
    
    
}
