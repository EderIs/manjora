package com.manjora.project.manjora.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.manjora.project.manjora.repository.TareaRepository;

@Service
public class TareaService {

	@Autowired
	private TareaRepository tareaRepository;
	
}
