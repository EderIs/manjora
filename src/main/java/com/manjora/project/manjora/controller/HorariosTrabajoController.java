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

import com.manjora.project.manjora.dto.HorarioTrabajoDto;
import com.manjora.project.manjora.dto.Mensaje;
import com.manjora.project.manjora.dto.TituloDto;
import com.manjora.project.manjora.entity.HorariosDeTrabajo;
import com.manjora.project.manjora.entity.Titulo;
import com.manjora.project.manjora.service.HorariosTrabajoService;

@RestController
@RequestMapping("/horarioT")
@CrossOrigin(origins = "http://localhost:4200")
public class HorariosTrabajoController {

	
	@Autowired
	private HorariosTrabajoService horariosService;
	
	
	@GetMapping("/list")
	public ResponseEntity<List<HorariosDeTrabajo>> List(){
		List<HorariosDeTrabajo> list = horariosService.list();
		return new ResponseEntity(list, HttpStatus.OK);
	}
	
	@GetMapping("/detail/{id}")
	public ResponseEntity<HorariosDeTrabajo> getById(@PathVariable("id") Long id){
		if(!horariosService.existsById(id))
			return new ResponseEntity(new Mensaje("No Existe"), HttpStatus.NOT_FOUND);
		HorariosDeTrabajo horariosDeTrabajo = horariosService.getOne(id).get();
		return new ResponseEntity<HorariosDeTrabajo>(horariosDeTrabajo,HttpStatus.OK);
	}
	
	@GetMapping("/detailname/{nombreHorarioT}")
	public ResponseEntity<HorariosDeTrabajo> getBynombreHorarioT(@PathVariable("nombreHorarioT") String nombreHorarioT){
		if(!horariosService.existsByNombreHorariosDeTrabajo(nombreHorarioT))
			return new ResponseEntity(new Mensaje("No Existe"), HttpStatus.NOT_FOUND);
		HorariosDeTrabajo horariosDeTrabajo = horariosService.getByNombreHorariosDeTrabajo(nombreHorarioT).get();
		return new ResponseEntity<HorariosDeTrabajo>(horariosDeTrabajo,HttpStatus.OK);
	}
	
	@PostMapping("/create")
	public ResponseEntity<?> create(@RequestBody HorarioTrabajoDto horarioTDto){
		if(StringUtils.isBlank(horarioTDto.getNombre()))
			return new ResponseEntity(new Mensaje("El nombre es Obligatorio"), HttpStatus.BAD_REQUEST);
		
		
		HorariosDeTrabajo horariosDeTrabajo =new HorariosDeTrabajo(horarioTDto.getNombre(),
				horarioTDto.getDiaSemana(), horarioTDto.getTrabajarDesde(),horarioTDto.getTrabajarHasta(),
				horarioTDto.getFechaInicio(), horarioTDto.getFechaFinalizacion(), horarioTDto.getPeriodoDia());
				horariosService.save(horariosDeTrabajo);
		return new ResponseEntity(new Mensaje("Horario de trabajo Creado"),HttpStatus.OK);
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<?> update(@PathVariable("id") Long id, @RequestBody HorarioTrabajoDto horarioTDto){
		//if(!horariosService.existsById(id))
			//return new ResponseEntity(new Mensaje("No Existe el estado"), HttpStatus.NOT_FOUND);
		//if(horariosService.existsByNombreTitulo(tituloDto.getTitulo()) && tituloService.getByNombreTitulo(tituloDto.getTitulo()).get().getId() != id)
			//return new ResponseEntity(new Mensaje("El Estado ingresado ya existe"),HttpStatus.BAD_REQUEST);
		//if(StringUtils.isBlank(tituloDto.getTitulo()))
			//return new ResponseEntity(new Mensaje("El Nombre del estado  es Obligatorio"), HttpStatus.BAD_REQUEST);
		
		HorariosDeTrabajo horariosDeTrabajo = horariosService.getOne(id).get();
		horariosDeTrabajo.setNombre(horarioTDto.getNombre());
		horariosDeTrabajo.setDiaSemana(horarioTDto.getDiaSemana());
		horariosDeTrabajo.setTrabajarDesde(horarioTDto.getTrabajarDesde());
		horariosDeTrabajo.setTrabajarHasta(horarioTDto.getTrabajarHasta());
		horariosDeTrabajo.setFechaInicio(horarioTDto.getFechaInicio());
		horariosDeTrabajo.setFechaFinalizacion(horarioTDto.getFechaFinalizacion());
		horariosDeTrabajo.setPeriodoDia(horarioTDto.getPeriodoDia());
		
		horariosService.save(horariosDeTrabajo);
		return new ResponseEntity(new Mensaje("Estado Actualizado"),HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> delete (@PathVariable("id") Long id){
		if(!horariosService.existsById(id))
			return new ResponseEntity(new Mensaje("No Existe el Horario"), HttpStatus.NOT_FOUND);
		horariosService.delete(id);
		return new ResponseEntity(new Mensaje("Horario Eliminado"), HttpStatus.OK);
	}
	
}
