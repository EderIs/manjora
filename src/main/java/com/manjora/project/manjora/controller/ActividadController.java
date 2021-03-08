package com.manjora.project.manjora.controller;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

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

import com.manjora.project.manjora.dto.ActividadDto;
import com.manjora.project.manjora.dto.Mensaje;
import com.manjora.project.manjora.entity.Actividad;
import com.manjora.project.manjora.service.ActividadService;
import com.manjora.project.manjora.service.EmailService;

@RestController
@RequestMapping("/actividad")
@CrossOrigin(origins = "http://localhost:4200")
public class ActividadController {

	
	@Autowired
	private ActividadService actividadService;
	
	@Autowired
	private EmailService emilService;
	
	@GetMapping("getActividades/{idT}")
	public List<Actividad>getActividades(@PathVariable(name="idT")Long idTarea){
		
		return this.actividadService.getActividades(idTarea);
		
	}
	
	@PostMapping("/create")
	public ResponseEntity<?>saveActividad(@RequestBody ActividadDto actividadDto){
		
	try {
		
		Actividad actividad = new Actividad(actividadDto.getActividad(), 
				actividadDto.getResumen(),actividadDto.getFechaInicio(),actividadDto.getFechaFinal(),
				actividadDto.getUsuario(),actividadDto.getEstadoT(),actividadDto.getTarea());
		
		
		
		if(!actividad.getEstadoT()) {
			emilService.sendEmail(actividad.getUsuario().getEmail(), actividad.getActividad(),actividad.getResumen());	
		}else {
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd  HH:mm:ss");
			String strDate= formatter.format(new Date());
			
			actividad.setFechaEntrega(strDate);			
		}
		
		this.actividadService.saveActividad(actividad);
		return new ResponseEntity(actividad,HttpStatus.ACCEPTED);
		
	}catch(Exception io) {
		return new ResponseEntity(new Mensaje("No se guardo"),HttpStatus.BAD_REQUEST);
	}
		
	}
	
	@PutMapping("/updateA/{id}")
	public ResponseEntity<?>updateActividad(@PathVariable(name="id")Long idActividad,@RequestBody ActividadDto actividadDto){
		try {
			
			Actividad actividad = this.actividadService.getActividad(idActividad);
			
			actividad.setEstadoT(actividadDto.getEstadoT());
			
			Date d = new Date();
			
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd  HH:mm:ss");
			String strDate= formatter.format(d);
			
			actividad.setFechaEntrega(strDate);
			
			this.actividadService.saveActividad(actividad);
			
			return new ResponseEntity(actividad,HttpStatus.ACCEPTED);
			
		}catch(Exception io) {
			return new ResponseEntity(new Mensaje("Ocurrio un problema"+io.getMessage()),HttpStatus.BAD_REQUEST);
		}
		
	}
	
	@DeleteMapping("delete/{id}")
	public ResponseEntity<?>deleteActividad(@PathVariable(name="id")Long idActividad ){
		
		try {
			
			Actividad actividad = this.actividadService.getActividad(idActividad);
			
			this.actividadService.deleteActividad(actividad);
			
			return new ResponseEntity(null,HttpStatus.ACCEPTED);
		}catch(Exception io) {
			return new ResponseEntity(new Mensaje("Ocurrio un problema"),HttpStatus.BAD_REQUEST);
		}
		
		
	}
	
	
}
