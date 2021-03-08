package com.manjora.project.manjora.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.manjora.project.manjora.entity.Notificacion;
import com.manjora.project.manjora.repository.NotificacionRepository;
import com.manjora.project.manjora.security.entity.UsuarioSec;

@Service
@Transactional
public class NotificacionService {

	@Autowired
	private NotificacionRepository notificacionRepository;
	
	public void SaveNotificacion(Notificacion notificacion)throws Exception {		
		this.notificacionRepository.save(notificacion);		
	}
	
	public void deleteNotificacion(Notificacion notificacion)throws Exception {
		
		this.notificacionRepository.delete(notificacion);
		
	}
	
	//public List<Notificacion>getNotificaciones(Long idUsuario){
		
		//return this.notificacionRepository.
		
	//}
	
	
}
