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

import com.manjora.project.manjora.dto.ContactoDto;
import com.manjora.project.manjora.dto.Mensaje;
import com.manjora.project.manjora.dto.UsuarioDto;
import com.manjora.project.manjora.entity.Contacto;
import com.manjora.project.manjora.service.ContactoService;


@RestController
@RequestMapping("/contacto")
@CrossOrigin(origins = "http://localhost:4200")
public class ContactoController {

	@Autowired
	ContactoService contactoService;

	@GetMapping("/list")
	public ResponseEntity<List<Contacto>> List() {
		List<Contacto> list = contactoService.list();
		return new ResponseEntity(list, HttpStatus.OK);
	}

	@GetMapping("/detail/{id}")
	public ResponseEntity<Contacto> getById(@PathVariable("id") Long id) {
		if (!contactoService.existsById(id))
			return new ResponseEntity(new Mensaje("No Existe"), HttpStatus.NOT_FOUND);
		Contacto contacto = contactoService.getOne(id).get();
		return new ResponseEntity<Contacto>(contacto, HttpStatus.OK);
	}

	@GetMapping("/detailname/{nombreContacto}")
	public ResponseEntity<Contacto> getByNombreContacto(@PathVariable("nombreContacto") String nombreContacto) {
		if (!contactoService.existsByNombreContacto(nombreContacto))
			return new ResponseEntity(new Mensaje("No Existe"), HttpStatus.NOT_FOUND);
		Contacto contacto = contactoService.getByNombreContacto(nombreContacto).get();
		return new ResponseEntity<Contacto>(contacto, HttpStatus.OK);
	}


}
