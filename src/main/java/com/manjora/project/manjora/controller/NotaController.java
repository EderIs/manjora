package com.manjora.project.manjora.controller;

import java.sql.Date;
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
import com.manjora.project.manjora.dto.NotasDto;
import com.manjora.project.manjora.dto.TareaDto;
import com.manjora.project.manjora.entity.Categoria;
import com.manjora.project.manjora.entity.Nota;
import com.manjora.project.manjora.entity.Notas;
import com.manjora.project.manjora.entity.Tarea;
import com.manjora.project.manjora.security.entity.UsuarioSec;
import com.manjora.project.manjora.service.NotaService;
import com.manjora.project.manjora.service.TareaService;

@RestController
@RequestMapping("/nota")
@CrossOrigin(origins = "http://localhost:4200")
public class NotaController {
	@Autowired
	private NotaService notaService;
	
	@GetMapping("/getNotas/{idCategoria}")
	public List<Nota>getNota(@PathVariable(name="idCategoria")Long idCategoria){
		return this.notaService.getNotasByIdCategoria(idCategoria);
	}

	@GetMapping("/getNota/{idNota}")
	public Nota getNota2(@PathVariable(name="idNota")Long idNota){
		return this.notaService.getByIdNota(idNota);
	}
	
	@PutMapping("updateNota/{id}")
	private ResponseEntity<?>updateNotaById(@PathVariable(name="id")Long idNota , 
			@RequestBody NotaDto notaDto){
		
	try {
	
		Nota nota = this.notaService.getByIdNota(idNota);
		
		nota.setCategoria(notaDto.getCategoria());
		
		this.notaService.saveNota(nota);
		
		return new ResponseEntity(new Mensaje("Ok"),HttpStatus.ACCEPTED);
	}catch(Exception io) {
		return new ResponseEntity(new Mensaje("No se actualizo"),HttpStatus.BAD_REQUEST);
	}
	
	}
	
	@PutMapping("updateNota2/{id}")
	private ResponseEntity<?>updateNotaById2(@PathVariable(name="id")Long idNota , 
			@RequestBody NotaDto notaDto){
		
	try {
	
		Nota nota = this.notaService.getByIdNota(idNota);
		
		nota.setNombre(notaDto.getNombre());
		nota.setCategoria(notaDto.getCategoria());
		nota.setUsuario(notaDto.getUsuario());
		nota.setFechaInicio(notaDto.getFechaInicio());
		nota.setFechaFinal(notaDto.getFechaFinal());
		nota.setEstatus(notaDto.isEstatus());
		
		this.notaService.saveNota(nota);
		
		return new ResponseEntity(new Mensaje("Ok"),HttpStatus.ACCEPTED);
	}catch(Exception io) {
		return new ResponseEntity(new Mensaje("No se actualizo"),HttpStatus.BAD_REQUEST);
	}
	
	}
	
	@PostMapping("/createNota")
	public ResponseEntity<?>saveNotas(@RequestBody NotaDto notaDto){
		
		Nota notas = new Nota(Long.parseLong("0"),  notaDto.getNombre(), notaDto.getUsuario(),
				notaDto.getCategoria(),
				notaDto.getFechaInicio(), notaDto.getFechaFinal(), notaDto.isEstatus());
		
		this.notaService.saveNota(notas);
		
		return new ResponseEntity(new Mensaje("Nota Creado"),HttpStatus.ACCEPTED);
		
	}
}
