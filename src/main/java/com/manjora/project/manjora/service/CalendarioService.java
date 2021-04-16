package com.manjora.project.manjora.service;

import java.sql.Date;
import java.sql.Time;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.manjora.project.manjora.entity.Calendario;
import com.manjora.project.manjora.entity.Contacto;
import com.manjora.project.manjora.repository.CalendarioRepository;

@Service
@Transactional
public class CalendarioService {

	@Autowired
	private CalendarioRepository calendarioRepository;

	@Autowired
	private EntityManager entityManager;

	public void SaveCalendario(Calendario calendario) throws Exception {

		this.calendarioRepository.save(calendario);

	}

	public void DeleteCalendario(Calendario id) throws Exception {
		this.calendarioRepository.delete(id);
	}

	public Boolean existsCalendarioByFecha(Date fecha) throws Exception {

		return this.calendarioRepository.existsByFecha(fecha);
	}

	public Boolean existsCalendarioByHoraInicio(Time horaI) throws Exception {
		return this.calendarioRepository.existsByHoraInicio(horaI);
	}

	public List<Calendario> findAllByFecha(Date fecha) {
		return this.calendarioRepository.findAllByFecha(fecha);
	}

	public Calendario findById(Long id) {
	
		return this.calendarioRepository.findById(id).get();
	}

	public List<Calendario> getAll(Date fecha,Date fechaFinal,long idUser) {
		
		String consulta2 = "select NEW com.manjora.project.manjora.entity.Calendario"
				+ "(c.id,c.fecha) from Calendario c join c.contactos co where c.fecha between '"+fecha+"' and '"+fechaFinal+"' and "
						+ "co.usuario = "+idUser+" ";

		List<Calendario> calendarios = (List<Calendario>) entityManager.createQuery(consulta2, Calendario.class).getResultList();
		

		return calendarios;

	}
	
	public Long existCalendarioByHoras(Date fecha ,Time horaI , Time horaF, Long id) {
		
		String consulta = "select count(c.id) from Calendario c join c.contactos co "
				+ "where c.fecha = '"+fecha+"' "
				+ "and (('"+horaI+"' between c.horaInicio and c.horaFinal) or "
				+ "('"+horaF+"' between c.horaInicio and c.horaFinal) or ('"+horaI+"' < c.horaInicio and '"+horaF+"' > c.horaFinal)) "
						+ "and co.id = "+id+" ";
		
			TypedQuery<Long> valor = entityManager.createQuery(consulta, Long.class);
		
		Long dale = valor.getSingleResult();
		
		return dale;
		
	}
	
public Long existCalendarioByHorasId(Date fecha ,Time horaI , Time horaF, Long id,Long idCal) {
		
		String consulta = "select count(c.id) from Calendario c join c.contactos co "
				+ "where c.fecha = '"+fecha+"' "
				+ "and (('"+horaI+"' between c.horaInicio and c.horaFinal) or "
				+ "('"+horaF+"' between c.horaInicio and c.horaFinal) or ('"+horaI+"' < c.horaInicio and '"+horaF+"' > c.horaFinal)) "
						+ "and co.id = "+id+" and c.id != "+idCal+" ";
		
			TypedQuery<Long> valor = entityManager.createQuery(consulta, Long.class);
		
		Long dale = valor.getSingleResult();
			
		return dale;
		
	}
	
	public List<Calendario> findAllByMonth(Date fecha,Long idUser) {

		String consulta2 = "select NEW com.manjora.project.manjora.entity.Calendario"
				+ "(c.id,c.resumen,c.fecha,c.horaInicio,c.horaFinal) from Calendario c join c.contactos co where c.fecha= '"+fecha+"' and "
						+ "co.usuario= "+idUser+" ";

		List<Calendario> calendarios = (List<Calendario>) entityManager.createQuery(consulta2, Calendario.class).getResultList();
		

		return calendarios;
	}

	public Set<Contacto> getContactoByCalendario(Long idCalendario) {
		
		String consulta = "select NEW com.manjora.project.manjora.entity.Contacto(x.id,x.nombreContacto)"
		+ " from Calendario c " + "join c.contactos x where c.id= "+idCalendario+" ";

		TypedQuery<Contacto> query = entityManager.createQuery(new String(consulta), Contacto.class);

		Set<Contacto> contactos = new HashSet<Contacto>(); 
		contactos.addAll(query.getResultList());

		return contactos;
	}
}
