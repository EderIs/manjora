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
import com.manjora.project.manjora.dto.PaisDto;
import com.manjora.project.manjora.entity.Empleado;
import com.manjora.project.manjora.entity.Pais;
import com.manjora.project.manjora.service.PaisService;

@RestController
@RequestMapping("pais")
@CrossOrigin(origins = "http://localhost:4200")
public class PaisController {

	@Autowired
	PaisService paisService;
	
	@GetMapping("/list")
	public ResponseEntity<List<Pais>> List(){
		List<Pais> list = paisService.list();
		return new ResponseEntity(list, HttpStatus.OK);
	}
	
	@GetMapping("/list/{nombrePais}")
	public ResponseEntity<List<Pais>>ListAllByNombre(@PathVariable("nombrePais") String nombrePais ){
		try {
			List<Pais> list = paisService.findAllByNombre(nombrePais);
			return new ResponseEntity(list, HttpStatus.OK);
		}catch(Exception ex) {
			return new ResponseEntity(new Mensaje("Error"),HttpStatus.BAD_REQUEST);
		}
		
	}
	
	@GetMapping("/detail/{id}")
	public ResponseEntity<Pais> getById(@PathVariable("id") Long id){
		if(!paisService.existsById(id))
			return new ResponseEntity(new Mensaje("No Existe"), HttpStatus.NOT_FOUND);
		Pais pais = paisService.getOne(id).get();
		return new ResponseEntity<Pais>(pais,HttpStatus.OK);
	}
	
	@GetMapping("/detailname/{nombrePais}")
	public ResponseEntity<Pais> getByNombrePais(@PathVariable("nombrePais") String nombrePais){
		if(!paisService.existsByNombrePais(nombrePais))
			return new ResponseEntity(new Mensaje("No Existe"), HttpStatus.NOT_FOUND);
		Pais pais = paisService.getByNombrePais(nombrePais).get();
		return new ResponseEntity<Pais>(pais,HttpStatus.OK);
	}
	
	@PostMapping("/create")
	public ResponseEntity<?> create(@RequestBody PaisDto paisDto){
		if(StringUtils.isBlank(paisDto.getNombrePais()))
			return new ResponseEntity(new Mensaje("El Nombre del Pais es Obligatorio"), HttpStatus.BAD_REQUEST);
		if(paisService.existsByNombrePais(paisDto.getNombrePais()))
			return new ResponseEntity(new Mensaje("El Nombre ingresado ya existe"),HttpStatus.BAD_REQUEST);
		Pais pais = new Pais(paisDto.getNombrePais());
		paisService.save(pais);
		return new ResponseEntity(new Mensaje("Pais Creado"),HttpStatus.OK);
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<?> update(@PathVariable("id") Long id, @RequestBody PaisDto paisDto){
		if(!paisService.existsById(id))
			return new ResponseEntity(new Mensaje("No Existe"), HttpStatus.NOT_FOUND);
		if(paisService.existsByNombrePais(paisDto.getNombrePais()) && paisService.getByNombrePais(paisDto.getNombrePais()).get().getId() != id)
			return new ResponseEntity(new Mensaje("El Nombre ingresado ya existe"),HttpStatus.BAD_REQUEST);
		if(StringUtils.isBlank(paisDto.getNombrePais()))
			return new ResponseEntity(new Mensaje("El Nombre del Pais es Obligatorio"), HttpStatus.BAD_REQUEST);
		Pais pais = paisService.getOne(id).get();
		pais.setNombrePais(paisDto.getNombrePais());
		paisService.save(pais);
		return new ResponseEntity(new Mensaje("Pais Actualizado"),HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> delete (@PathVariable("id") Long id){
		try {
			if(!paisService.existsById(id))
				return new ResponseEntity(new Mensaje("No Existe"), HttpStatus.NOT_FOUND);
			paisService.delete(id);
			return new ResponseEntity(new Mensaje("Pais Eliminado"), HttpStatus.OK);
		}catch(Exception ex) {
			
			return new ResponseEntity(new Mensaje("Error : "+ex.getCause()), HttpStatus.BAD_REQUEST);
		}
	}

}
