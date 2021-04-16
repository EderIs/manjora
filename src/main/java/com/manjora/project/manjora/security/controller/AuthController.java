package com.manjora.project.manjora.security.controller;

import java.util.HashSet;
import java.util.Set;

import javax.validation.Valid;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.manjora.project.manjora.dto.Mensaje;
import com.manjora.project.manjora.security.dto.JwtDto;
import com.manjora.project.manjora.security.dto.LoginUsuario;
import com.manjora.project.manjora.security.dto.NuevoUsuario;
import com.manjora.project.manjora.security.dto.UsuarioSecDao;
import com.manjora.project.manjora.security.entity.RolSec;
import com.manjora.project.manjora.security.entity.UsuarioSec;
import com.manjora.project.manjora.security.enums.RolNombre;
import com.manjora.project.manjora.security.jwt.JwtProvider;
import com.manjora.project.manjora.security.service.RolService;
import com.manjora.project.manjora.security.service.UsuarioSecService;

@RestController
@RequestMapping("/auth")
@CrossOrigin
public class AuthController {

	 @Autowired
	    PasswordEncoder passwordEncoder;

	    @Autowired
	    AuthenticationManager authenticationManager;

	    @Autowired
	    UsuarioSecService usuarioService;

	    @Autowired
	    RolService rolService;

	    @Autowired
	    JwtProvider jwtProvider;
	    
	    @Autowired
	    UsuarioSecService usuarioSecService;

	    @PostMapping("/nuevo")
	    public ResponseEntity<?> nuevo(@Valid @RequestBody NuevoUsuario nuevoUsuario, BindingResult bindingResult){
	        if(bindingResult.hasErrors())
	            return new ResponseEntity(new Mensaje("campos mal puestos o email inválido"), HttpStatus.BAD_REQUEST);
	        if(usuarioService.existsByNombreUsuario(nuevoUsuario.getNombreUsuario()))
	            return new ResponseEntity(new Mensaje("ese nombre ya existe"), HttpStatus.BAD_REQUEST);
	        if(usuarioService.existsByEmail(nuevoUsuario.getEmail()))
	            return new ResponseEntity(new Mensaje("ese email ya existe"), HttpStatus.BAD_REQUEST);
	        UsuarioSec usuario =
	                new UsuarioSec(nuevoUsuario.getNombre(), nuevoUsuario.getNombreUsuario(), nuevoUsuario.getEmail(),
	                        passwordEncoder.encode(nuevoUsuario.getPassword()));
	        Set<RolSec> roles = new HashSet<>();
	        roles.add(rolService.getByRolNombre(RolNombre.ROLE_USER).get());
	        if(nuevoUsuario.getRoles().contains("admin"))
	            roles.add(rolService.getByRolNombre(RolNombre.ROLE_ADMIN).get());
	        usuario.setRoles(roles);
	        usuarioService.save(usuario);
	        return new ResponseEntity(new Mensaje("usuario guardado"), HttpStatus.CREATED);
	    }
	    
	    @GetMapping("/detail/{id}")
		public ResponseEntity<UsuarioSec> getById(@PathVariable("id") int id) {
			if (!usuarioSecService.existsById(id))
				return new ResponseEntity(new Mensaje("No Existe"), HttpStatus.NOT_FOUND);
			UsuarioSec usuario = usuarioSecService.getOne(id).get();
			return new ResponseEntity<UsuarioSec>(usuario, HttpStatus.OK);
		}

	    @PutMapping("/ingresoUsuario/{id}")
		public ResponseEntity<?> updateIngreso(@PathVariable("id") int id, @RequestBody UsuarioSecDao usuarioDto) {
			if (!usuarioSecService.existsById(id))
				return new ResponseEntity(new Mensaje("No Existe"), HttpStatus.NOT_FOUND);
			if (usuarioSecService.existsByNombreUsuario(usuarioDto.getNombreUsuario())
					&& usuarioSecService.getByNombreUsuario(usuarioDto.getNombreUsuario()).get().getId() != id)
				return new ResponseEntity(new Mensaje("El Nombre ingresado ya existe"), HttpStatus.BAD_REQUEST);
			if (StringUtils.isBlank(usuarioDto.getNombreUsuario()))
				return new ResponseEntity(new Mensaje("El Nombre de Usuario es Obligatorio"), HttpStatus.BAD_REQUEST);
			UsuarioSec usuario = usuarioSecService.getOne(id).get();
			usuario.setNombreUsuario(usuarioDto.getNombreUsuario());
			usuario.setPassword(passwordEncoder.encode(usuarioDto.getPassword()));
			usuario.setUltimoAcceso(usuarioDto.getUltimoAcceso());
			usuario.setEstado(usuarioDto.isEstado());
			Set<RolSec> roles = new HashSet<>();
	        roles.add(rolService.getByRolNombre(RolNombre.ROLE_USER).get());
	        if(usuarioDto.getRoles().contains("admin"))
	            roles.add(rolService.getByRolNombre(RolNombre.ROLE_ADMIN).get());
	        
	        usuario.setRoles(roles);
			usuarioSecService.save(usuario);
			return new ResponseEntity(new Mensaje("Usuario Creado"), HttpStatus.OK);
		}
	    
	    @PostMapping("/login")
	    public ResponseEntity<JwtDto> login(@Valid @RequestBody LoginUsuario loginUsuario, BindingResult bindingResult){
	        if(bindingResult.hasErrors())
	            return new ResponseEntity(new Mensaje("campos mal puestos"), HttpStatus.BAD_REQUEST);
	        Authentication authentication =
	                authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginUsuario.getNombreUsuario(), loginUsuario.getPassword()));
	        SecurityContextHolder.getContext().setAuthentication(authentication);
	        String jwt = jwtProvider.generateToken(authentication);
	        UserDetails userDetails = (UserDetails)authentication.getPrincipal();
	        JwtDto jwtDto = new JwtDto(jwt, userDetails.getUsername(), userDetails.getAuthorities());
	        return new ResponseEntity(jwtDto, HttpStatus.OK);
	    }
	
	
}
