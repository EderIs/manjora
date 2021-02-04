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

import com.manjora.project.manjora.dto.EstadoDto;
import com.manjora.project.manjora.dto.Mensaje;
import com.manjora.project.manjora.dto.UsuarioDto;
import com.manjora.project.manjora.entity.Banco;
import com.manjora.project.manjora.entity.Estado;
import com.manjora.project.manjora.entity.Usuario;
import com.manjora.project.manjora.service.EstadoService;



@RestController
@RequestMapping("/estado")
@CrossOrigin(origins = "http://localhost:4200")
public class EstadoController {

	@Autowired
	
	EstadoService estadoService;
	
	@GetMapping("/list")
	public ResponseEntity<List<Estado>> List(){
		List<Estado> list = estadoService.list();
		return new ResponseEntity(list, HttpStatus.OK);
	}
	
	@GetMapping("/list/{nombreEstado}")
	public ResponseEntity<List<Estado>>ListAllByNombre(@PathVariable("nombreEstado") String nombreEstado ){
		try {
			List<Estado> list = estadoService.findAllByNombre(nombreEstado);
			return new ResponseEntity(list, HttpStatus.OK);
		}catch(Exception ex) {
			return new ResponseEntity(new Mensaje("Error"),HttpStatus.BAD_REQUEST);
		}
		
	}
	
	@GetMapping("/detail/{id}")
	public ResponseEntity<Estado> getById(@PathVariable("id") Long id){
		if(!estadoService.existsById(id))
			return new ResponseEntity(new Mensaje("No Existe"), HttpStatus.NOT_FOUND);
		Estado estado = estadoService.getOne(id).get();
		return new ResponseEntity<Estado>(estado,HttpStatus.OK);
	}
	
	@GetMapping("/detailname/{nombreEstado}")
	public ResponseEntity<Estado> getByNombreEstado(@PathVariable("nombreEstado") String nombreEstado){
		if(!estadoService.existsByNombreEstado(nombreEstado))
			return new ResponseEntity(new Mensaje("No Existe"), HttpStatus.NOT_FOUND);
		Estado estado = estadoService.getByNombreEstado(nombreEstado).get();
		return new ResponseEntity<Estado>(estado,HttpStatus.OK);
	}
	
	@PostMapping("/create")
	public ResponseEntity<?> create(@RequestBody EstadoDto estadoDto){
		if(StringUtils.isBlank(estadoDto.getNombreEstado()))
			return new ResponseEntity(new Mensaje("El Nombre del Estado es Obligatorio"), HttpStatus.BAD_REQUEST);
		if(estadoService.existsByNombreEstado(estadoDto.getNombreEstado()))
			return new ResponseEntity(new Mensaje("El Nombre ingresado ya existe"),HttpStatus.BAD_REQUEST);
		Estado estado = new Estado(estadoDto.getNombreEstado(), estadoDto.getCodigo(),estadoDto.getPais());
		estadoService.save(estado);
		return new ResponseEntity(new Mensaje("Estado Creado"),HttpStatus.OK);
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<?> update(@PathVariable("id") Long id, @RequestBody EstadoDto estadoDto){
		
		//Estado estado = estadoService.getOne(id).get();
		Estado estado = new Estado();
		estado.setId(id);
		estado.setNombreEstado(estadoDto.getNombreEstado());
		estado.setCodigo(estadoDto.getCodigo());
		estado.setPais(estadoDto.getPais());
		
		estadoService.save(estado);
		return new ResponseEntity(new Mensaje("Estado Actualizado"),HttpStatus.OK);
	}
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> delete (@PathVariable("id") Long id){
		if(!estadoService.existsById(id))
			return new ResponseEntity(new Mensaje("No Existe"), HttpStatus.NOT_FOUND);
		estadoService.delete(id);
		return new ResponseEntity(new Mensaje("Estado Eliminado"), HttpStatus.OK);
	}

}
