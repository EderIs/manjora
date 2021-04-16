package com.manjora.project.manjora.security.controller;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.List;

import org.springframework.security.core.Authentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.manjora.project.manjora.dto.NotificacionDto;
import com.manjora.project.manjora.entity.Notificacion;
import com.manjora.project.manjora.service.NotificacionService;

@Controller
public class CanalesMensajes {

	@Autowired
	private NotificacionService notificacionService;
	
	
	 @MessageMapping("/send/message")
	 @SendTo("/message")
	    public Notificacion notification(NotificacionDto notificacionDto) {    
	        try {
	        	
	        	SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				String strDate= formatter.format(new java.util.Date());
				
	        	 Notificacion notificacion = new Notificacion(notificacionDto.getTitulo()
	    				 ,notificacionDto.getResumen(), strDate
	    				 , notificacionDto.getUsuarioDestino(),true,notificacionDto.getRuta());
	    		 
	    		 this.notificacionService.SaveNotificacion(notificacion);
	    		
	    	        return notificacion;    	
	        }catch(Exception io) {
	        	return null;
	        }
	    } 
}
