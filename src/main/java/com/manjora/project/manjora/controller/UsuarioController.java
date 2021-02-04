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
import com.manjora.project.manjora.service.EmailService;
import com.manjora.project.manjora.service.UsuarioService;

@RestController
@RequestMapping("/usuario")
@CrossOrigin(origins = "http://localhost:4200")
public class UsuarioController {
	
	@Autowired
	UsuarioService usuarioService;
	
	@Autowired
	EmailService emailService;
	
	@GetMapping("/list")
	public ResponseEntity<List<Usuario>> List(){
		List<Usuario> list = usuarioService.list();
		return new ResponseEntity(list, HttpStatus.OK);
	}
	
	@GetMapping("/listByEstado")
	public ResponseEntity<List<String>> ListByEstado(){
		List<String> list = usuarioService.findAllByEstado();
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
		if(!usuarioService.existsBydireccionCorreo(nombreUsuario))
			return new ResponseEntity(new Mensaje("No Existe"), HttpStatus.NOT_FOUND);
		Usuario usuario = usuarioService.getByNombreUsuario(nombreUsuario).get();
		return new ResponseEntity<Usuario>(usuario,HttpStatus.OK);
	}
	
	@PostMapping("/create")
	public ResponseEntity<?> create(@RequestBody UsuarioDto usuarioDto){
		try {
			if(StringUtils.isBlank(usuarioDto.getDireccionCorreo()))
				return new ResponseEntity(new Mensaje("El correo es Obligatorio"), HttpStatus.BAD_REQUEST);
			if(usuarioService.existsBydireccionCorreo(usuarioDto.getDireccionCorreo()))
				return new ResponseEntity(new Mensaje("El correo electronico ingresado ya existe"),HttpStatus.BAD_REQUEST);
			Usuario usuario = new Usuario(usuarioDto.getNombreUsuario(), usuarioDto.getDireccionCorreo(),usuarioDto.getContrasena(),usuarioDto.getFechaCreacion(),usuarioDto.getUltimoAcceso(),usuarioDto.isEstado());
			usuarioService.save(usuario);
			sendEmail(usuario.getDireccionCorreo(),usuario.getId());
			return new ResponseEntity(new Mensaje("Usuario Creado"),HttpStatus.OK);	
		}catch(Exception ex) {
			
			return new ResponseEntity(new Mensaje("Error: "+ex.getCause()),HttpStatus.BAD_REQUEST);
			
		}
		
	}

	public Boolean sendEmail(@RequestBody String email,Long idUsusario){
		
		try {
			String html = "<h1>Unete a manjora</h1><br>"+
			"Recientemente, se autorizó ingresar a la aplicación de Manojora,"
			+ "Ingresa los datos para registrarte correctamente y asi podra acceder a su cuenta."+
			"<br><br>"
			+ "Unete al siguiente link: "+"<a href='http://localhost:4200/#/register/"+idUsusario+">Registrate"+"</a>";
			
			emailService.sendEmail(email, "Ingresar", html);
			return true;	
		}catch(Exception ex) {
			return false;
		}
	}
		
	@PutMapping("/ingresoUsuario/{id}")
	public ResponseEntity<?>updateIngreso(@PathVariable("id") Long id, @RequestBody UsuarioDto usuarioDto){
		if(!usuarioService.existsById(id))
			return new ResponseEntity(new Mensaje("No Existe"), HttpStatus.NOT_FOUND);
		if(usuarioService.existBynombreUsuario(usuarioDto.getNombreUsuario()) && usuarioService.getByNombreUsuario(usuarioDto.getNombreUsuario()).get().getId() != id)
			return new ResponseEntity(new Mensaje("El Nombre ingresado ya existe"),HttpStatus.BAD_REQUEST);
		if(StringUtils.isBlank(usuarioDto.getNombreUsuario()))
			return new ResponseEntity(new Mensaje("El Nombre de Usuario es Obligatorio"), HttpStatus.BAD_REQUEST);
		Usuario usuario = usuarioService.getOne(id).get();
		usuario.setNombreUsuario(usuarioDto.getNombreUsuario());
		usuario.setContrasena(usuarioDto.getContrasena());
		usuario.setUltimoAcceso(usuarioDto.getUltimoAcceso());
		usuario.setEstado(usuarioDto.isEstado());
		usuarioService.save(usuario);
		return new ResponseEntity(new Mensaje("Usuario Creado"),HttpStatus.OK);
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<?> update(@PathVariable("id") Long id, @RequestBody UsuarioDto usuarioDto){
		if(!usuarioService.existsById(id))
			return new ResponseEntity(new Mensaje("No Existe"), HttpStatus.NOT_FOUND);
		if(usuarioService.existsBydireccionCorreo(usuarioDto.getNombreUsuario()) && usuarioService.getByNombreUsuario(usuarioDto.getNombreUsuario()).get().getId() != id)
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
