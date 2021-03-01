package com.manjora.project.manjora.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.manjora.project.manjora.repository.ActividadRepository;

@Service
public class ActividadService {

	@Autowired
	private ActividadRepository actividadRepository;
	
}
