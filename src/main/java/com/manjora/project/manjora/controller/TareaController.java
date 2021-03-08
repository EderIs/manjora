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
import com.manjora.project.manjora.dto.TareaDto;
import com.manjora.project.manjora.entity.Tarea;
import com.manjora.project.manjora.service.TareaService;

@RestController
@RequestMapping("/tarea")
@CrossOrigin(origins = "http://localhost:4200")
public class TareaController {

	@Autowired
	private TareaService tareaService;
	
	@GetMapping("/getTareas/{idEtapa}")
	public List<Tarea>getTareas(@PathVariable(name="idEtapa")Long idEtapa){
		return this.tareaService.getTareasByEtapa(idEtapa);
	}

	@GetMapping("/getTarea/{idTarea}")
	public Tarea getTarea(@PathVariable(name="idTarea")Long idTarea){
		return this.tareaService.getByIdTarea(idTarea);
	}
	@PostMapping("/create")
	public ResponseEntity<?>saveTarea(@RequestBody TareaDto tareaDto){
		try {
			
			Tarea tarea = new Tarea(null,tareaDto.getNombre(), 
					tareaDto.getUsuario(), tareaDto.getEtapa(),tareaDto.getFechaInicio(), 
					tareaDto.getFechaFinal(), tareaDto.getEstatus());
			
		this.tareaService.SaveTarea(tarea);
		
		return new ResponseEntity(tarea,HttpStatus.ACCEPTED);
		}catch(Exception io) {
			return new ResponseEntity(new Mensaje("Ocurrio un problema, "+io.getLocalizedMessage()),HttpStatus.BAD_REQUEST);
		}
	}
	
	@PutMapping("updateTarea/{id}")
	private ResponseEntity<?>updateTareaById(@PathVariable(name="id")Long idTarea , 
			@RequestBody TareaDto tareaDto){
		
	try {
	
		Tarea tarea = this.tareaService.getByIdTarea(idTarea);
		
		tarea.setEtapa(tareaDto.getEtapa());
		
		this.tareaService.SaveTarea(tarea);
		
		return new ResponseEntity(new Mensaje("Ok"),HttpStatus.ACCEPTED);
	}catch(Exception io) {
		return new ResponseEntity(new Mensaje("No se actualizo"),HttpStatus.BAD_REQUEST);
	}
	
	}
	
	@PutMapping("updateTareaA/{id}")
	private ResponseEntity<?>updateTareaById2(@PathVariable(name="id")Long idTarea , 
			@RequestBody TareaDto tareaDto){
		
	try {
	
		Tarea tarea = this.tareaService.getByIdTarea(idTarea);
		
		tarea.setNombre(tareaDto.getNombre());
		tarea.setFechaFinal(tareaDto.getFechaFinal());
		tarea.setUsuario(tareaDto.getUsuario());
		tarea.setEstatus(tareaDto.getEstatus());
		
		this.tareaService.SaveTarea(tarea);
		
		return new ResponseEntity(new Mensaje("Ok"),HttpStatus.ACCEPTED);
	}catch(Exception io) {
		return new ResponseEntity(new Mensaje("No se actualizo"),HttpStatus.BAD_REQUEST);
	}
	
	}
	
	
}
