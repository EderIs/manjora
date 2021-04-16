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

import com.manjora.project.manjora.dto.DepartamentoDto;
import com.manjora.project.manjora.dto.Mensaje;
import com.manjora.project.manjora.entity.Departamento;
import com.manjora.project.manjora.service.DepartamentoService;

@RestController
@RequestMapping("/departamento")
@CrossOrigin(origins = "http://localhost:4200")
public class DepartamentoController {

	@Autowired
	private DepartamentoService departamentoService;
	
	@GetMapping("/list")
	public ResponseEntity<List<Departamento>> List(){
		List<Departamento> list = departamentoService.list();
		return new ResponseEntity(list, HttpStatus.OK);
	}
	
	@GetMapping("/detail/{id}")
	public ResponseEntity<Departamento> getById(@PathVariable("id") Long id){
		if(!departamentoService.existsById(id))
			return new ResponseEntity(new Mensaje("No Existe"), HttpStatus.NOT_FOUND);
		Departamento departamento = departamentoService.getOne(id).get();
		return new ResponseEntity<Departamento>(departamento,HttpStatus.OK);
	}
	
	@GetMapping("/detailname/{nombreDepartamento}")
	public ResponseEntity<Departamento> getByNombreUsuario(@PathVariable("nombreDepartamento") String nombreDepartamento){
		if(!departamentoService.existsByNombreDepartamento(nombreDepartamento))
			return new ResponseEntity(new Mensaje("No Existe"), HttpStatus.NOT_FOUND);
		Departamento departamento = departamentoService.getByNombreDepartamento(nombreDepartamento).get();
		return new ResponseEntity<Departamento>(departamento,HttpStatus.OK);
	}
	
	@PostMapping("/create")
	public ResponseEntity<?> create(@RequestBody DepartamentoDto departamentoDto){
		if(StringUtils.isBlank(departamentoDto.getNombreDepartamento()))
			return new ResponseEntity(new Mensaje("El Nombre del departamento es Obligatorio"), HttpStatus.BAD_REQUEST);
		if(departamentoService.existsByNombreDepartamento(departamentoDto.getNombreDepartamento()))
			return new ResponseEntity(new Mensaje("El departamento ingresado ya existe"),HttpStatus.BAD_REQUEST);
		Departamento departamento = new Departamento(departamentoDto.getNombreDepartamento(),departamentoDto.isEstado());
		departamentoService.save(departamento);
		return new ResponseEntity(new Mensaje("Departamento Creado"),HttpStatus.OK);
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<?> update(@PathVariable("id") Long id, @RequestBody DepartamentoDto departamentoDto){
		if(!departamentoService.existsById(id))
			return new ResponseEntity(new Mensaje("No Existe"), HttpStatus.NOT_FOUND);
		if(departamentoService.existsByNombreDepartamento(departamentoDto.getNombreDepartamento()) && departamentoService.getByNombreDepartamento(departamentoDto.getNombreDepartamento()).get().getId() != id)
			return new ResponseEntity(new Mensaje("El Departamento ingresado ya existe"),HttpStatus.BAD_REQUEST);
		if(StringUtils.isBlank(departamentoDto.getNombreDepartamento()))
			return new ResponseEntity(new Mensaje("El Departamento es Obligatorio"), HttpStatus.BAD_REQUEST);
		
		Departamento departamento = departamentoService.getOne(id).get();
		departamento.setNombreDepartamento(departamentoDto.getNombreDepartamento());
		departamento.setEstado(departamentoDto.isEstado());
		
		departamentoService.save(departamento);
		return new ResponseEntity(new Mensaje("Departamento Actualizado"),HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> delete (@PathVariable("id") Long id){
		if(!departamentoService.existsById(id))
			return new ResponseEntity(new Mensaje("No Existe"), HttpStatus.NOT_FOUND);
		departamentoService.delete(id);
		return new ResponseEntity(new Mensaje("Departamento Eliminado"), HttpStatus.OK);
	}
}
