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

import com.manjora.project.manjora.dto.EmpleadoDto;
import com.manjora.project.manjora.dto.Mensaje;
import com.manjora.project.manjora.dto.PuestoDto;
import com.manjora.project.manjora.entity.Departamento;
import com.manjora.project.manjora.entity.Empleado;
import com.manjora.project.manjora.entity.Puesto;
import com.manjora.project.manjora.service.EmpleadoService;

@RestController
@RequestMapping("/puesto")
@CrossOrigin(origins = "http://localhost:4200")
public class EmpleadoController {

	@Autowired
	private EmpleadoService empleadoService;
	
	@GetMapping("/list")
	public ResponseEntity<List<Empleado>> List(){
		List<Empleado> list = empleadoService.list();
		return new ResponseEntity(list, HttpStatus.OK);
	}
	
	@GetMapping("/detail/{id}")
	public ResponseEntity<Empleado> getById(@PathVariable("id") Long id){
		if(!empleadoService.existsById(id))
			return new ResponseEntity(new Mensaje("No Existe"), HttpStatus.NOT_FOUND);
		Empleado empleado = empleadoService.getOne(id).get();
		return new ResponseEntity<Empleado>(empleado,HttpStatus.OK);
	}
	
	@GetMapping("/detailname/{nombreEmpleado}")
	public ResponseEntity<Empleado> getByNombreUsuario(@PathVariable("nombreEmpleado") String nombreEmpleado){
		if(!empleadoService.existsByNombreEmpleado(nombreEmpleado))
			return new ResponseEntity(new Mensaje("No Existe"), HttpStatus.NOT_FOUND);
		Empleado empleado = empleadoService.getByNombreEmpleado(nombreEmpleado).get();
		return new ResponseEntity<Empleado>(empleado,HttpStatus.OK);
	}
	
	@PostMapping("/create")
	public ResponseEntity<?> create(@RequestBody EmpleadoDto empleadoDto){
		if(StringUtils.isBlank(empleadoDto.getNombreEmpleado()))
			return new ResponseEntity(new Mensaje("El Nombre del Puesto es Obligatorio"), HttpStatus.BAD_REQUEST);
		if(empleadoService.existsByNombreEmpleado(empleadoDto.getNombreEmpleado()))
			return new ResponseEntity(new Mensaje("El Puesto ingresado ya existe"),HttpStatus.BAD_REQUEST);
		Empleado empleado = new Empleado(
				empleadoDto.getFotografia(),
				empleadoDto.getNombreEmpleado(),
				empleadoDto.getTituloTrabajo(),
				empleadoDto.getDireccionPrivada(),
				empleadoDto.getContactoEmergencia(),
				empleadoDto.getTelefonoEmergencia(),
				empleadoDto.getKmCasaTrabajo(),
				empleadoDto.getSexo(),
				empleadoDto.getEstadoCivil(),
				empleadoDto.getNumeroHijos(),
				empleadoDto.getFechaNacimiento(),
				empleadoDto.getLugarNacimiento(),
				empleadoDto.getNivelCertificado(),
				empleadoDto.getEscuela(),
				empleadoDto.getNotaAdicional(),
				empleadoDto.getNota(),
				empleadoDto.isEstado()
				);
		empleadoService.save(empleado);
		return new ResponseEntity(new Mensaje("Puesto Creado"),HttpStatus.OK);
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<?> update(@PathVariable("id") Long id, @RequestBody EmpleadoDto empleadoDto){
		if(!empleadoService.existsById(id))
			return new ResponseEntity(new Mensaje("No Existe"), HttpStatus.NOT_FOUND);
		if(empleadoService.existsByNombreEmpleado(empleadoDto.getNombreEmpleado()) && empleadoService.getByNombreEmpleado(empleadoDto.getNombreEmpleado()).get().getId() != id)
			return new ResponseEntity(new Mensaje("El Empleado ingresado ya existe"),HttpStatus.BAD_REQUEST);
		if(StringUtils.isBlank(empleadoDto.getNombreEmpleado()))
			return new ResponseEntity(new Mensaje("El Empleado es Obligatorio"), HttpStatus.BAD_REQUEST);
		
		Empleado empleado = empleadoService.getOne(id).get();
		empleado.setFotografia(empleadoDto.getFotografia());
		empleado.setNombreEmpleado(empleadoDto.getNombreEmpleado());
		empleado.setTituloTrabajo(empleadoDto.getTituloTrabajo());
		empleado.setDireccionPrivada(empleadoDto.getDireccionPrivada());
		empleado.setContactoEmergencia(empleadoDto.getContactoEmergencia());
		empleado.setTelefonoEmergencia(empleadoDto.getTelefonoEmergencia());
		empleado.setKmCasaTrabajo(empleadoDto.getKmCasaTrabajo());
		empleado.setSexo(empleadoDto.getSexo());
		empleado.setEstadoCivil(empleadoDto.getEstadoCivil());
		empleado.setNumeroHijos(empleadoDto.getNumeroHijos());
		empleado.setFechaNacimiento(empleadoDto.getFechaNacimiento());
		empleado.setLugarNacimiento(empleadoDto.getLugarNacimiento());
		empleado.setNivelCertificado(empleadoDto.getNivelCertificado());
		empleado.setEscuela(empleadoDto.getEscuela());
		empleado.setNotaAdicional(empleadoDto.getNotaAdicional());
		empleado.setNota(empleadoDto.getNota());
		empleado.setEstado(empleadoDto.isEstado());
		
		empleadoService.save(empleado);
		return new ResponseEntity(new Mensaje("Empleado Actualizado"),HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> delete (@PathVariable("id") Long id){
		if(!empleadoService.existsById(id))
			return new ResponseEntity(new Mensaje("No Existe"), HttpStatus.NOT_FOUND);
		empleadoService.delete(id);
		return new ResponseEntity(new Mensaje("Empleado Eliminado"), HttpStatus.OK);
	}
}
