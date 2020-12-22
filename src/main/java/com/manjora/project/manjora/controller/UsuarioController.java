package com.manjora.project.manjora.controller;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.manjora.project.manjora.dto.Mensaje;
import com.manjora.project.manjora.dto.UsuarioDto;
import com.manjora.project.manjora.entity.Usuario;
import com.manjora.project.manjora.service.UsuarioService;

@RestController
@RequestMapping("/usuarios")
@CrossOrigin(origins = "http://localhost:4200")
public class UsuarioController {
	
	@Autowired
	UsuarioService usuarioService;
	
	//Método para listar Usuarios
	@GetMapping("/list")
	public ResponseEntity<List<Usuario>> List(){
		List<Usuario> list = usuarioService.list();
		return new ResponseEntity(list, HttpStatus.OK);
	}
	
	@GetMapping("/detail/{id}")
	public ResponseEntity<Usuario> getById(@PathVariable("id") Long id){
		if(!usuarioService.existsById(id))
			return new ResponseEntity(new Mensaje("No Existe"), HttpStatus.NOT_FOUND);
		Usuario usuario = usuarioService.getOne(id).get();
		return new ResponseEntity<Usuario>(usuario,HttpStatus.OK);
	}
	
	@GetMapping("/detailname/{nombreUsuario}")
	public ResponseEntity<Usuario> getByNombreUsuario(@PathVariable("nombreUsuario") String nombreUsuario){
		if(!usuarioService.existsByNombreUsuario(nombreUsuario))
			return new ResponseEntity(new Mensaje("No Existe"), HttpStatus.NOT_FOUND);
		Usuario usuario = usuarioService.getByNombreUsuario(nombreUsuario).get();
		return new ResponseEntity<Usuario>(usuario,HttpStatus.OK);
	}
	
	@PostMapping("/create")
	public ResponseEntity<?> create(@RequestBody UsuarioDto usuarioDto){
		if(StringUtils.isBlank(usuarioDto.getNombreUsuario()))
			return new ResponseEntity(new Mensaje("El Nombre de Usuario es Obligatorio"), HttpStatus.BAD_REQUEST);
		if(usuarioService.existsByNombreUsuario(usuarioDto.getNombreUsuario()))
			return new ResponseEntity(new Mensaje("El Nombre ingresado ya existe"),HttpStatus.BAD_REQUEST);
		Usuario usuario = new Usuario(usuarioDto.getNombreUsuario(), usuarioDto.getDireccionCorreo(),usuarioDto.getContrasena(),usuarioDto.getFechaCreacion(),usuarioDto.getUltimoAcceso(),usuarioDto.isEstado());
		usuarioService.save(usuario);
		return new ResponseEntity(new Mensaje("Usuario Creado"),HttpStatus.OK);
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<?> update(@PathVariable("id") Long id, @RequestBody UsuarioDto usuarioDto){
		if(!usuarioService.existsById(id))
			return new ResponseEntity(new Mensaje("No Existe"), HttpStatus.NOT_FOUND);
		if(usuarioService.existsByNombreUsuario(usuarioDto.getNombreUsuario()) && usuarioService.getByNombreUsuario(usuarioDto.getNombreUsuario()).get().getId() != id)
			return new ResponseEntity(new Mensaje("El Nombre ingresado ya existe"),HttpStatus.BAD_REQUEST);
		if(StringUtils.isBlank(usuarioDto.getNombreUsuario()))
			return new ResponseEntity(new Mensaje("El Nombre de Usuario es Obligatorio"), HttpStatus.BAD_REQUEST);
		Usuario usuario = usuarioService.getOne(id).get();
		usuario.setNombreUsuario(usuarioDto.getNombreUsuario());
		usuario.setDireccionCorreo(usuarioDto.getDireccionCorreo());
		usuario.setContrasena(usuarioDto.getContrasena());
		usuario.setFechaCreacion(usuarioDto.getFechaCreacion());
		usuario.setUltimoAcceso(usuarioDto.getUltimoAcceso());
		usuario.setEstado(usuarioDto.isEstado());
		usuarioService.save(usuario);
		return new ResponseEntity(new Mensaje("Usuario Actualizado"),HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> delete (@PathVariable("id") Long id){
		if(!usuarioService.existsById(id))
			return new ResponseEntity(new Mensaje("No Existe"), HttpStatus.NOT_FOUND);
		usuarioService.delete(id);
		return new ResponseEntity(new Mensaje("Usuario Eliminado"), HttpStatus.OK);
	}
}
