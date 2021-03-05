package com.manjora.project.manjora.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.manjora.project.manjora.dto.Mensaje;
import com.manjora.project.manjora.dto.NotaDto;
import com.manjora.project.manjora.dto.TareaDto;
import com.manjora.project.manjora.entity.Nota;
import com.manjora.project.manjora.entity.Tarea;
import com.manjora.project.manjora.service.NotaService;
import com.manjora.project.manjora.service.TareaService;

@RestController
@RequestMapping("/nota")
@CrossOrigin(origins = "http://localhost:4200")
public class NotaController {
	@Autowired
	private NotaService notaService;
	
	@GetMapping("/getNotas/{idCategoriaNota}")
	public List<Nota>getNotas(@PathVariable(name="idCategoriaNota")Long idCategoriaNota){
		return this.notaService.getNotasByIdCategoria(idCategoriaNota);
	}

	@GetMapping("/getNota/{idNota}")
	public Nota getNota(@PathVariable(name="idNota")Long idNota){
		return this.notaService.getByIdNota(idNota);
	}
	
	@PutMapping("updateNota/{id}")
	private ResponseEntity<?>updateNotaById(@PathVariable(name="idNota")Long idNota , 
			@RequestBody NotaDto notaDto){
		
	try {
	
		Nota nota = this.notaService.getByIdNota(idNota);
		
		nota.setCategoriaNota(notaDto.getCategoriaNota());
		
		this.notaService.saveNota(nota);
		
		return new ResponseEntity(new Mensaje("Ok"),HttpStatus.ACCEPTED);
	}catch(Exception io) {
		return new ResponseEntity(new Mensaje("No se actualizo"),HttpStatus.BAD_REQUEST);
	}
	
	}
	
	@PutMapping("updateTareaA/{id}")
	private ResponseEntity<?>updateTareaById2(@PathVariable(name="id")Long idNota , 
			@RequestBody NotaDto notaDto){
		
	try {
	
		Nota nota = this.notaService.getByIdNota(idNota);
		
		nota.setNombre(notaDto.getNombre());
		nota.setCategoriaNota(notaDto.getCategoriaNota());
		nota.setUsuario(notaDto.getUsuario());
		
		this.notaService.saveNota(nota);
		
		return new ResponseEntity(new Mensaje("Ok"),HttpStatus.ACCEPTED);
	}catch(Exception io) {
		return new ResponseEntity(new Mensaje("No se actualizo"),HttpStatus.BAD_REQUEST);
	}
	
	}
}
