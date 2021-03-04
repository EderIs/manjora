package com.manjora.project.manjora.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.manjora.project.manjora.entity.Etapa;
import com.manjora.project.manjora.repository.EtapaRepository;

@Service
@Transactional
public class EtapaService {

	@Autowired
	private EtapaRepository etapaRepository;

	@Autowired
	private EntityManager entityManager;

	public void saveEtapa(Etapa etapa) throws Exception {

		this.etapaRepository.save(etapa);

	}

	public List<Etapa> getEtapas(long idProyecto) {

		String consulta = "select e from Etapa e join e.proyecto p where p.id= " + idProyecto + " ";

		List<Etapa> etapas = entityManager.createQuery(consulta, Etapa.class).getResultList();

		return etapas;
	}

}
