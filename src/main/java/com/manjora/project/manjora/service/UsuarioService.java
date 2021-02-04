package com.manjora.project.manjora.service;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import com.manjora.project.manjora.entity.Usuario;
import com.manjora.project.manjora.repository.UsuarioRepository;

@Service
@Transactional
public class UsuarioService {
	
	@Autowired
	UsuarioRepository usuarioRepository;
	@Autowired
	EntityManager en;
	
	public List<Usuario> list(){
		return usuarioRepository.findAll();
	}
	
	public Optional<Usuario> getOne(Long id){
		return usuarioRepository.findById(id);
	}
	
	public Optional<Usuario> getByNombreUsuario(String nombreUsuario){
		return usuarioRepository.findByNombreUsuario(nombreUsuario);
	}
	
	public void save(Usuario usuario) {
		usuarioRepository.save(usuario);
	}
	
	public void delete(Long id) {
		usuarioRepository.deleteById(id);
	}
	
	public boolean existsById(Long id) {
		return usuarioRepository.existsById(id);
	}
	
	public boolean existsBydireccionCorreo(String direccionCorreo) {
		return usuarioRepository.existsBydireccionCorreo(direccionCorreo);
	}

	public boolean existBynombreUsuario(String nombreUsuario){
		return usuarioRepository.existsBynombreUsuario(nombreUsuario);
	} 
	
	public List<String>findAllByEstado(){
		
		final String consulta = "SELECT direccionCorreo from Usuario where estado=false";
		
		TypedQuery<String>query = en.createQuery(consulta,String.class);
		
		List<String>usuarios= query.getResultList();
		
		return usuarios;		
	}
	
}
