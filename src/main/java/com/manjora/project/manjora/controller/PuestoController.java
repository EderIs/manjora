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
import com.manjora.project.manjora.dto.PuestoDto;
import com.manjora.project.manjora.entity.Puesto;
import com.manjora.project.manjora.service.PuestoService;

@RestController
@RequestMapping("/puesto")
@CrossOrigin(origins = "http://localhost:4200")
public class PuestoController {

	@Autowired
	private PuestoService puestoService;
	
	@GetMapping("/list")
	public ResponseEntity<List<Puesto>> List(){
		List<Puesto> list = puestoService.list();
		return new ResponseEntity(list, HttpStatus.OK);
	}
	
	@GetMapping("/detail/{id}")
	public ResponseEntity<Puesto> getById(@PathVariable("id") Long id){
		if(!puestoService.existsById(id))
			return new ResponseEntity(new Mensaje("No Existe"), HttpStatus.NOT_FOUND);
		Puesto departamento = puestoService.getOne(id).get();
		return new ResponseEntity<Puesto>(departamento,HttpStatus.OK);
	}
	
	@GetMapping("/detailname/{nombrePuesto}")
	public ResponseEntity<Puesto> getByNombreUsuario(@PathVariable("nombrePuesto") String nombrePuesto){
		if(!puestoService.existsByNombrePuesto(nombrePuesto))
			return new ResponseEntity(new Mensaje("No Existe"), HttpStatus.NOT_FOUND);
		Puesto departamento = puestoService.getByNombrePuesto(nombrePuesto).get();
		return new ResponseEntity<Puesto>(departamento,HttpStatus.OK);
	}
	
	@PostMapping("/create")
	public ResponseEntity<?> create(@RequestBody PuestoDto puestoDto){
		if(StringUtils.isBlank(puestoDto.getNombrePuesto()))
			return new ResponseEntity(new Mensaje("El Nombre del Puesto es Obligatorio"), HttpStatus.BAD_REQUEST);
		if(puestoService.existsByNombrePuesto(puestoDto.getNombrePuesto()))
			return new ResponseEntity(new Mensaje("El Puesto ingresado ya existe"),HttpStatus.BAD_REQUEST);
		Puesto departamento = new Puesto(puestoDto.getNombrePuesto(),puestoDto.getDescripcionTrabajo());
		puestoService.save(departamento);
		return new ResponseEntity(new Mensaje("Puesto Creado"),HttpStatus.OK);
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<?> update(@PathVariable("id") Long id, @RequestBody PuestoDto puestoDto){
		if(!puestoService.existsById(id))
			return new ResponseEntity(new Mensaje("No Existe"), HttpStatus.NOT_FOUND);
		if(puestoService.existsByNombrePuesto(puestoDto.getNombrePuesto()) && puestoService.getByNombrePuesto(puestoDto.getNombrePuesto()).get().getId() != id)
			return new ResponseEntity(new Mensaje("El Puesto ingresado ya existe"),HttpStatus.BAD_REQUEST);
		if(StringUtils.isBlank(puestoDto.getNombrePuesto()))
			return new ResponseEntity(new Mensaje("El Puesto es Obligatorio"), HttpStatus.BAD_REQUEST);
		
		Puesto puesto = puestoService.getOne(id).get();
		puesto.setNombrePuesto(puestoDto.getNombrePuesto());
		puesto.setDescripcionTrabajo(puestoDto.getDescripcionTrabajo());
		
		puestoService.save(puesto);
		return new ResponseEntity(new Mensaje("Puesto Actualizado"),HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> delete (@PathVariable("id") Long id){
		if(!puestoService.existsById(id))
			return new ResponseEntity(new Mensaje("No Existe"), HttpStatus.NOT_FOUND);
		puestoService.delete(id);
		return new ResponseEntity(new Mensaje("Puesto Eliminado"), HttpStatus.OK);
	}
}
