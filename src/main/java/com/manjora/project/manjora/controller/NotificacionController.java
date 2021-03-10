package com.manjora.project.manjora.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.manjora.project.manjora.entity.Notificacion;
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
	
	
	
}
