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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.manjora.project.manjora.dto.Mensaje;
import com.manjora.project.manjora.dto.ProyectoDto;
import com.manjora.project.manjora.entity.Proyecto;
import com.manjora.project.manjora.service.ProyectoService;

@RestController
@RequestMapping("/proyecto")
@CrossOrigin(origins = "http://localhost:4200")
public class ProyectoController {

	@Autowired
	private ProyectoService proyectoService;
	@GetMapping("/listProyecto/{id}")
	public List<Proyecto>getProyectosByUser(@PathVariable(name="id")long idUser){
		return this.proyectoService.getProyectosByIdUser(idUser);
		
	}
	
	
	@PostMapping("/save")
	public ResponseEntity<?>saveProyecto(@RequestBody ProyectoDto proyectoDto){
		
		Proyecto proyecto = new Proyecto(Long.parseLong("0"), 
				proyectoDto.getUsuario(), proyectoDto.getNombreTarea());
		
		this.proyectoService.saveProyecto(proyecto);
		
		return new ResponseEntity(new Mensaje("Proyecto Creado"),HttpStatus.ACCEPTED);
		
	}
	
}
