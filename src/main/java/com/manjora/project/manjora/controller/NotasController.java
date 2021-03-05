package com.manjora.project.manjora.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.manjora.project.manjora.dto.Mensaje;
import com.manjora.project.manjora.dto.NotasDto;
import com.manjora.project.manjora.dto.ProyectoDto;
import com.manjora.project.manjora.entity.Notas;
import com.manjora.project.manjora.entity.Proyecto;
import com.manjora.project.manjora.service.NotasService;
import com.manjora.project.manjora.service.ProyectoService;

@RestController
@RequestMapping("/notas")
@CrossOrigin(origins = "http://localhost:4200")
public class NotasController {

	@Autowired
	private NotasService notasService;
	@GetMapping("/listNotas/{id}")
	public List<Notas>getNotasByUser(@PathVariable(name="id")long idUser){
		return this.notasService.getNotasByIdUser(idUser);
		
	}
	
	
	@PostMapping("/save")
	public ResponseEntity<?>saveNotas(@RequestBody NotasDto notasDto){
		
		Notas notas = new Notas(Long.parseLong("0"), 
				notasDto.getUsuario(), notasDto.getTitulo());
		
		this.notasService.saveNotas(notas);
		
		return new ResponseEntity(new Mensaje("Proyecto Creado"),HttpStatus.ACCEPTED);
		
	}
}
