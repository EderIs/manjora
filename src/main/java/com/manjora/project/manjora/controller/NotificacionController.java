package com.manjora.project.manjora.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.manjora.project.manjora.dto.NotificacionDto;
import com.manjora.project.manjora.entity.Notificacion;
import com.manjora.project.manjora.security.entity.UsuarioPrincipalSec;
import com.manjora.project.manjora.security.entity.UsuarioSec;
import com.manjora.project.manjora.service.NotificacionService;

@RestController
@RequestMapping("/notificacion")
@CrossOrigin(origins = "http://localhost:4200")
public class NotificacionController {

	@Autowired
	private NotificacionService notificacionService;
	
	 @GetMapping("/listNot/{idUser}")
	 public List<Notificacion>getNotificaciones(@PathVariable(name="idUser")Long idUser){
	
		 return this.notificacionService.getNotificaciones(idUser);
	 }
	
	 @GetMapping("/NotEstatus/{id}")
	public ResponseEntity<?>updateNotificacion(@PathVariable(name="id")Long id){
	try {
		Notificacion notificacion = notificacionService.getNotificacion(id); 
		notificacion.setEstatus(false);
		
		this.notificacionService.SaveNotificacion(notificacion);
		
		return new ResponseEntity(notificacion,HttpStatus.ACCEPTED);
	}catch(Exception io) {
		return new ResponseEntity("Error en: "+io.getLocalizedMessage(),HttpStatus.BAD_REQUEST);
	}
	 }
	
}
