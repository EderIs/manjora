package com.manjora.project.manjora.service;

import java.util.List;

import javax.persistence.EntityManager;
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
	
	@Autowired
	private EntityManager entityManager;
	
	public void SaveNotificacion(Notificacion notificacion)throws Exception {		
		this.notificacionRepository.save(notificacion);		
	}
	
	public void deleteNotificacion(Notificacion notificacion)throws Exception {
		
		this.notificacionRepository.delete(notificacion);
		
	}
	
	public List<Notificacion>getNotificaciones(Long idUsuario){
		
		String consulta = "select new Notificacion(n.id,n.titulo,n.resumen,n.fechaLlegada,us,n.ruta) from Notificacion n join n.usuarioDestino us "
				+ "where us.id = "+idUsuario+" ";
		List<Notificacion>notificaciones = entityManager.createQuery(consulta,Notificacion.class).getResultList();
		return notificaciones;
	}
	
	
}
