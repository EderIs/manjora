package com.manjora.project.manjora.security.controller;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
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
import com.manjora.project.manjora.security.dto.UsuarioSecDao;
import com.manjora.project.manjora.security.entity.UsuarioSec;
import com.manjora.project.manjora.security.service.UsuarioSecService;
import com.manjora.project.manjora.service.EmailService;

@RestController
@RequestMapping("/usuario")
@CrossOrigin(origins = "http://localhost:4200")
public class UsuarioSecController {

	@Autowired
	UsuarioSecService usuarioSecService;

	@Autowired
	EmailService emailService;

	@Autowired
	PasswordEncoder passwordEncoder;

	@GetMapping("/list")
	public ResponseEntity<List<UsuarioSec>> List() {
		List<UsuarioSec> list = usuarioSecService.list();
		return new ResponseEntity(list, HttpStatus.OK);
	}

	@GetMapping("/listByEstado")
	public ResponseEntity<List<String>> ListByEstado() {
		List<String> list = usuarioSecService.findAllByEstado();
		return new ResponseEntity(list, HttpStatus.OK);
	}

	@GetMapping("/detail/{id}")
	public ResponseEntity<UsuarioSec> getById(@PathVariable("id") int id) {
		if (!usuarioSecService.existsById(id))
			return new ResponseEntity(new Mensaje("No Existe"), HttpStatus.NOT_FOUND);
		UsuarioSec usuario = usuarioSecService.getOne(id).get();
		return new ResponseEntity<UsuarioSec>(usuario, HttpStatus.OK);
	}

	@GetMapping("/detailname/{nombreUsuario}")
	public ResponseEntity<UsuarioSec> getByNombreUsuario(@PathVariable("nombreUsuario") String nombreUsuario) {
		if (!usuarioSecService.existsByNombreUsuario(nombreUsuario))
			return new ResponseEntity(new Mensaje("No Existe"), HttpStatus.NOT_FOUND);
		UsuarioSec usuario = usuarioSecService.getByNombreUsuario(nombreUsuario).get();
		return new ResponseEntity<UsuarioSec>(usuario, HttpStatus.OK);
	}

	@PostMapping("/create")
	public ResponseEntity<?> create(@RequestBody UsuarioSecDao usuarioDto) {
		try {
			if (StringUtils.isBlank(usuarioDto.getEmail()))
				return new ResponseEntity(new Mensaje("El correo es Obligatorio"), HttpStatus.BAD_REQUEST);
			if (usuarioSecService.existsByEmail(usuarioDto.getEmail()))
				return new ResponseEntity(new Mensaje("El correo electronico ingresado ya existe"),
						HttpStatus.BAD_REQUEST);
			UsuarioSec usuario = new UsuarioSec(usuarioDto.getNombreUsuario(), usuarioDto.getEmail(),
					passwordEncoder.encode(usuarioDto.getPassword()), usuarioDto.getFechaCreacion(),
					usuarioDto.getUltimoAcceso(), usuarioDto.isEstado());
			usuarioSecService.save(usuario);
			sendEmail(usuario.getEmail(), usuario.getId());
			return new ResponseEntity(new Mensaje("Usuario Creado"), HttpStatus.OK);
		} catch (Exception ex) {

			return new ResponseEntity(new Mensaje("Error: " + ex.getCause()), HttpStatus.BAD_REQUEST);

		}

	}

	public Boolean sendEmail(@RequestBody String email, int idUsusario) {

		try {
			String html = "<h1>Unete a manjora</h1><br>"
					+ "Recientemente, se autorizó ingresar a la aplicación de Manojora,"
					+ "Ingresa los datos para registrarte correctamente y asi podra acceder a su cuenta." + "<br><br>"
					+ "Unete al siguiente link: " + "<a href='http://localhost:4200/#/register/" + idUsusario
					+ ">Registrate" + "</a>";

			emailService.sendEmail(email, "Ingresar", html);
			return true;
		} catch (Exception ex) {
			return false;
		}
	}

	

	@PutMapping("/update/{id}")
	public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody UsuarioSecDao usuarioDto) {
		if (!usuarioSecService.existsById(id))
			return new ResponseEntity(new Mensaje("No Existe"), HttpStatus.NOT_FOUND);
		if (usuarioSecService.existsByNombreUsuario(usuarioDto.getNombreUsuario())
				&& usuarioSecService.getByNombreUsuario(usuarioDto.getNombreUsuario()).get().getId() != id)
			return new ResponseEntity(new Mensaje("El Nombre ingresado ya existe"), HttpStatus.BAD_REQUEST);
		if (StringUtils.isBlank(usuarioDto.getNombreUsuario()))
			return new ResponseEntity(new Mensaje("El Nombre de Usuario es Obligatorio"), HttpStatus.BAD_REQUEST);
		UsuarioSec usuario = usuarioSecService.getOne(id).get();
		usuario.setNombreUsuario(usuarioDto.getNombreUsuario());
		usuario.setEmail(usuarioDto.getEmail());
		usuario.setPassword(passwordEncoder.encode(usuarioDto.getPassword()));
		usuario.setFechaCreacion(usuarioDto.getFechaCreacion());
		usuario.setUltimoAcceso(usuarioDto.getUltimoAcceso());
		usuario.setEstado(usuarioDto.isEstado());
		usuarioSecService.save(usuario);
		return new ResponseEntity(new Mensaje("Usuario Actualizado"), HttpStatus.OK);
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") int id) {
		if (!usuarioSecService.existsById(id))
			return new ResponseEntity(new Mensaje("No Existe"), HttpStatus.NOT_FOUND);
		usuarioSecService.delete(id);
		return new ResponseEntity(new Mensaje("Usuario Eliminado"), HttpStatus.OK);
	}
}
