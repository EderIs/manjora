package com.manjora.project.manjora.controller;

import java.sql.Date;
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;
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

import com.manjora.project.manjora.dto.CalendarioDto;
import com.manjora.project.manjora.dto.ContactoDto;
import com.manjora.project.manjora.dto.Mensaje;
import com.manjora.project.manjora.entity.Calendario;
import com.manjora.project.manjora.entity.Contacto;
import com.manjora.project.manjora.service.CalendarioService;
import com.manjora.project.manjora.service.EmailService;

@RestController
@RequestMapping("/calendario")
@CrossOrigin(origins = "http://localhost:4200")
public class CalendarioController {

	@Autowired
	private CalendarioService calendarioService;
	
	@Autowired
	private EmailService emailService;
	
	@GetMapping("/mostrar/{fechaI}&{fechaF}&{idUser}")
	public List<Calendario>getFechas(@PathVariable(name="fechaI") java.sql.Date fechaI,
			@PathVariable(name="fechaF")java.sql.Date fechaF,@PathVariable(name="idUser") long idUser){
		
		List<Calendario> calendarios = this.calendarioService.getAll(
				new Date(fechaI.getTime()),new Date(fechaF.getTime()),idUser);
		
		List<Calendario> calendarios2 = new ArrayList<Calendario>();
		
		for (Calendario calendario : calendarios) {
			
			calendarios2.add(new Calendario(calendario.getId(), calendario.getFecha()));
		}
		
		return calendarios2;

	}
	
	@GetMapping("/list2/{fecha3}&{idUser}")
	public List<Calendario>getFecha(@PathVariable(name="fecha3") java.sql.Date fecha,
			@PathVariable(name="idUser")Long idUser)throws Exception{

	List<Calendario> calendarios = this.calendarioService.findAllByMonth(fecha,idUser);
	
	for (Calendario calendario2 : calendarios) {
		
	calendario2.setContactos(this.calendarioService.getContactoByCalendario(calendario2.getId()));
	
	}
	
	return calendarios;
	}
	
	@GetMapping("/getCalendario/{id}")
	public Calendario getCalendarioById(@PathVariable(name="id")Long id)throws Exception {
		
		Calendario calendario = this.calendarioService.findById(id);
		return calendario = calendario!=null ? calendario : null;
	}
	
	
	@PostMapping("/create")
	public ResponseEntity<?>insertCalendario(@RequestBody CalendarioDto calendarioDto) throws Exception{
		
		if(calendarioDto.getContactos().size() == 0) 
			return new ResponseEntity(new Mensaje("Es necesario por lo menos un contacto"),HttpStatus.BAD_REQUEST);
		
		for (Contacto contacto : calendarioDto.getContactos()) {
			
			if(calendarioService.existCalendarioByHoras(calendarioDto.getFecha(),
					calendarioDto.getHoraInicio(), calendarioDto.getHoraFinal(), contacto.getId()) >= 1) {
				if(contacto.getNombreContacto() == "Yo") {
					return new ResponseEntity(new Mensaje("Elige una horario diferente"),HttpStatus.BAD_REQUEST);
				}else {
					return new ResponseEntity(new Mensaje("El usuario: "+contacto.getNombreContacto()+" Tiene una fecha asignada"),HttpStatus.BAD_REQUEST);	
				}
				
			}
		}
		
			Set<Contacto>contactos = new HashSet<Contacto>();
		
		contactos = calendarioDto.getContactos();
		
		Calendario calendario = new Calendario(Long.parseLong("0"),calendarioDto.getResumen(),
				calendarioDto.getFecha()
				,calendarioDto.getHoraInicio(),calendarioDto.getHoraFinal());
		
		calendario.setContactos(contactos);
		
		calendarioService.SaveCalendario(calendario);
		
		return new ResponseEntity(new Mensaje("Fecha registrada"),HttpStatus.ACCEPTED);
		
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<?>editarCalendario(@PathVariable(name="id")Long id,@RequestBody CalendarioDto calendarioDto)throws Exception{
		
		
	 for (Contacto contacto :calendarioDto.getContactos()) {
			
			if(calendarioService.existCalendarioByHorasId(calendarioDto.getFecha(),
					calendarioDto.getHoraInicio(), calendarioDto.getHoraFinal(), contacto.getId(),id) >= 1) {
				return new ResponseEntity(new Mensaje("El usuario: "+contacto.getNombreContacto()+" Tiene una fecha asignada"),HttpStatus.BAD_REQUEST);
			
			}
		}
		
		Calendario calendario = this.calendarioService.findById(id);
		
		calendario.setResumen(calendarioDto.getResumen());
		calendario.setFecha(calendarioDto.getFecha());
		calendario.setHoraInicio(calendarioDto.getHoraInicio());
		calendario.setHoraFinal(calendarioDto.getHoraFinal());
		
		
		Set<Contacto> contactos = new HashSet<Contacto>();
		
		for (Contacto contacto : calendarioDto.getContactos()) {		
			contactos.add(new Contacto(contacto.getId(),contacto.getNombreContacto()));			
		}
		
		calendario.setContactos(contactos);
		
		calendarioService.SaveCalendario(calendario);
		
		return new ResponseEntity(new Mensaje("Se actualizo correctamente la fecha"),HttpStatus.ACCEPTED);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?>eliminarCalendario(@PathVariable(name="id") Long idCal)throws Exception{
		
		if(idCal > 0) {
			
			Calendario calendario = this.calendarioService.findById(idCal);
			
			calendarioService.DeleteCalendario(calendario);
			return new ResponseEntity(new Mensaje("Se elimino con exito"),HttpStatus.ACCEPTED);
		}else {
			
			return new ResponseEntity(new Mensaje("No se elimino con exito"),HttpStatus.BAD_REQUEST);	
		}
		
	}
	
	
	}
