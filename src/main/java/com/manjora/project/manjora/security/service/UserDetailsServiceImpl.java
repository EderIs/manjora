package com.manjora.project.manjora.security.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.manjora.project.manjora.security.entity.UsuarioPrincipalSec;
import com.manjora.project.manjora.security.entity.UsuarioSec;
import com.manjora.project.manjora.service.UsuarioService;

@Service
public class UserDetailsServiceImpl implements UserDetailsService{

	@Autowired
    UsuarioSecService usuarioService;

    @Override
    public UserDetails loadUserByUsername(String nombreUsuario) throws UsernameNotFoundException {
        UsuarioSec usuario = usuarioService.getByNombreUsuario(nombreUsuario).get();
        return UsuarioPrincipalSec.build(usuario);
    }
}
