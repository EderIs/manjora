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

import com.manjora.project.manjora.dto.HoraLaboralDto;
import com.manjora.project.manjora.dto.Mensaje;
import com.manjora.project.manjora.entity.HoraLaboral;
import com.manjora.project.manjora.entity.HorariosDeTrabajo;
import com.manjora.project.manjora.service.HoraLaboralService;

@RestController
@RequestMapping("/horaL")
@CrossOrigin(origins = "http://localhost:4200")
public class HoraLaboralController {

	@Autowired
	private HoraLaboralService horaLaboralService;
	
	@GetMapping("/list")
	public ResponseEntity<List<HorariosDeTrabajo>> List(){
		List<HoraLaboral> list = horaLaboralService.list();
		return new ResponseEntity(list, HttpStatus.OK);
	}
	
	@GetMapping("/detail/{id}")
	public ResponseEntity<HoraLaboral> getById(@PathVariable("id") Long id){
		if(!horaLaboralService.existsById(id))
			return new ResponseEntity(new Mensaje("No Existe"), HttpStatus.NOT_FOUND);
		HoraLaboral horaLaboral = horaLaboralService.getOne(id).get();
		return new ResponseEntity<HoraLaboral>(horaLaboral,HttpStatus.OK);
	}
	
	@GetMapping("/detailname/{nombreHorarioT}")
	public ResponseEntity<HoraLaboral> getBynombreHoraL(@PathVariable("nombreHoraL") String nombreHoraL){
		if(!horaLaboralService.existsByNombreHoraL(nombreHoraL))
			return new ResponseEntity(new Mensaje("No Existe"), HttpStatus.NOT_FOUND);
		HoraLaboral horaLaboral = horaLaboralService.getByNombreHoraL(nombreHoraL).get();
		return new ResponseEntity<HoraLaboral>(horaLaboral,HttpStatus.ACCEPTED);
	}
	
	@PostMapping("/create")
	public ResponseEntity<?> create(@RequestBody HoraLaboralDto horaLaboralDto){
		if(StringUtils.isBlank(horaLaboralDto.getNombre()))
			return new ResponseEntity(new Mensaje("El nombre es Obligatorio"), HttpStatus.BAD_REQUEST);
		
		HoraLaboral horaLaboral =new HoraLaboral(horaLaboralDto.getNombre(),horaLaboralDto.getPromedioHoraDia());
		return new ResponseEntity(new Mensaje("Hora laboral Creada"),HttpStatus.OK);
	}
	
	
	@PutMapping("/update/{id}")
	public ResponseEntity<?> update(@PathVariable("id") Long id, @RequestBody HoraLaboralDto horaLaboralDto){
		if(!horaLaboralService.existsById(id))
			return new ResponseEntity(new Mensaje("No Existe el estado"), HttpStatus.NOT_FOUND);
		//if(horariosService.existsByNombreTitulo(tituloDto.getTitulo()) && tituloService.getByNombreTitulo(tituloDto.getTitulo()).get().getId() != id)
			//return new ResponseEntity(new Mensaje("El Estado ingresado ya existe"),HttpStatus.BAD_REQUEST);
		if(StringUtils.isBlank(horaLaboralDto.getNombre()))
			return new ResponseEntity(new Mensaje("La hora laboral es Obligatoria"), HttpStatus.BAD_REQUEST);
		
		HoraLaboral horaLaboral = horaLaboralService.getOne(id).get();
		
		horaLaboral.setNombre(horaLaboralDto.getNombre());
		horaLaboral.setPromedioHoraDia(horaLaboralDto.getPromedioHoraDia());
		
		horaLaboralService.save(horaLaboral);
		return new ResponseEntity(new Mensaje("Estado Actualizado"),HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> delete (@PathVariable("id") Long id){
		if(!horaLaboralService.existsById(id))
			return new ResponseEntity(new Mensaje("No Existe la hora laboral"), HttpStatus.NOT_FOUND);
		horaLaboralService.delete(id);
		return new ResponseEntity(new Mensaje("Hora laboral Eliminado"), HttpStatus.OK);
	}
	
}
