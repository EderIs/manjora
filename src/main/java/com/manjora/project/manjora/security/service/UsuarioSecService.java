package com.manjora.project.manjora.security.service;

import java.util.Optional;

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

    public Optional<UsuarioSec> getByNombreUsuario(String nombreUsuario){
        return usuarioRepository.findByNombreUsuario(nombreUsuario);
    }

    public boolean existsByNombreUsuario(String nombreUsuario){
        return usuarioRepository.existsByNombreUsuario(nombreUsuario);
    }

    public boolean existsByEmail(String email){
        return usuarioRepository.existsByEmail(email);
    }

    public void save(UsuarioSec usuario){
        usuarioRepository.save(usuario);
    }	
}
