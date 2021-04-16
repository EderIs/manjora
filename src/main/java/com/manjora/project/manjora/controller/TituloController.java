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
import com.manjora.project.manjora.dto.TituloDto;
import com.manjora.project.manjora.entity.Empleado;
import com.manjora.project.manjora.entity.Titulo;
import com.manjora.project.manjora.service.TituloService;

@RestController
@RequestMapping("/titulo")
@CrossOrigin(origins = "http://localhost:4200")
public class TituloController {

	@Autowired
	TituloService tituloService;
	
	@GetMapping("/list")
	public ResponseEntity<List<Titulo>> List(){
		List<Titulo> list = tituloService.list();
		return new ResponseEntity(list, HttpStatus.OK);
	}
	
	@GetMapping("/list/{titulo}")
	public ResponseEntity<List<Titulo>>ListAllByNombre(@PathVariable("titulo") String titulo ){
		try {
			List<Titulo> list = tituloService.findAllByTitulo(titulo);
			return new ResponseEntity(list, HttpStatus.OK);
		}catch(Exception ex) {
			return new ResponseEntity(new Mensaje("Error"),HttpStatus.BAD_REQUEST);
		}
		
	}
	
	@GetMapping("/detail/{id}")
	public ResponseEntity<Titulo> getById(@PathVariable("id") Long id){
		if(!tituloService.existsById(id))
			return new ResponseEntity(new Mensaje("No Existe"), HttpStatus.NOT_FOUND);
		Titulo titulo = tituloService.getOne(id).get();
		return new ResponseEntity<Titulo>(titulo,HttpStatus.OK);
	}
	
	@GetMapping("/detailname/{nombreTitulo}")
	public ResponseEntity<Titulo> getByNombreTitulo(@PathVariable("nombreTitulo") String nombreTitulo){
		if(!tituloService.existsByTitulo(nombreTitulo))
			return new ResponseEntity(new Mensaje("No Existe"), HttpStatus.NOT_FOUND);
		Titulo titulo = tituloService.getByNombreTitulo(nombreTitulo).get();
		return new ResponseEntity<Titulo>(titulo,HttpStatus.OK);
	}
	
	@PostMapping("/create")
	public ResponseEntity<?> create(@RequestBody TituloDto tituloDto){
		if(StringUtils.isBlank(tituloDto.getTitulo()))
			return new ResponseEntity(new Mensaje("El Nombre del titulo es Obligatorio"), HttpStatus.BAD_REQUEST);
		if(tituloService.existsByTitulo(tituloDto.getTitulo()))
			return new ResponseEntity(new Mensaje("El estado ingresado ya existe"),HttpStatus.BAD_REQUEST);
		Titulo titulo = new Titulo(tituloDto.getTitulo(), tituloDto.getAbreviatura());
		tituloService.save(titulo);
		return new ResponseEntity(new Mensaje("Estado Creado"),HttpStatus.OK);
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<?> update(@PathVariable("id") Long id, @RequestBody TituloDto tituloDto){
		if(!tituloService.existsById(id))
			return new ResponseEntity(new Mensaje("No Existe el estado"), HttpStatus.NOT_FOUND);
		if(tituloService.existsByTitulo(tituloDto.getTitulo()) && tituloService.getByNombreTitulo(tituloDto.getTitulo()).get().getId() != id)
			return new ResponseEntity(new Mensaje("El Estado ingresado ya existe"),HttpStatus.BAD_REQUEST);
		if(StringUtils.isBlank(tituloDto.getTitulo()))
			return new ResponseEntity(new Mensaje("El Nombre del estado  es Obligatorio"), HttpStatus.BAD_REQUEST);
		Titulo titulo = tituloService.getOne(id).get();
		titulo.setTitulo(tituloDto.getTitulo());
		titulo.setAbreviatura(tituloDto.getAbreviatura());
		tituloService.save(titulo);
		return new ResponseEntity(new Mensaje("Estado Actualizado"),HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> delete (@PathVariable("id") Long id){
		if(!tituloService.existsById(id))
			return new ResponseEntity(new Mensaje("No Existe el estado"), HttpStatus.NOT_FOUND);
		tituloService.delete(id);
		return new ResponseEntity(new Mensaje("Estado Eliminado"), HttpStatus.OK);
	}
	
}
