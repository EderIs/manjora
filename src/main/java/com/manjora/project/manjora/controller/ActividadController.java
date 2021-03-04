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
		
		Actividad actividad = new Actividad(Long.parseLong("0"),actividadDto.getActividad(), 
				actividadDto.getResumen(),actividadDto.getFechaInicio(),actividadDto.getFechaFinal(),
				actividadDto.getUsuario(),actividadDto.getEstadoT(),actividadDto.getTarea());
		
		this.actividadService.saveActividad(actividad);
		
		emilService.sendEmail(actividad.getUsuario().getEmail(), actividad.getActividad(),actividad.getResumen());
		
		return new ResponseEntity(new Mensaje("Actividad guardada"),HttpStatus.ACCEPTED);
		
	}catch(Exception io) {
		return new ResponseEntity(new Mensaje("No se guardo"),HttpStatus.BAD_REQUEST);
	}
		
	}
	
}
