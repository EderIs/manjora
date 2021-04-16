package com.manjora.project.manjora.security.service;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.manjora.project.manjora.security.entity.RolSec;
import com.manjora.project.manjora.security.enums.RolNombre;
import com.manjora.project.manjora.security.repository.RolRepository;

@Service
@Transactional
public class RolService {

	@Autowired
    RolRepository rolRepository;

    public Optional<RolSec> getByRolNombre(RolNombre rolNombre){
        return rolRepository.findByRolNombre(rolNombre);
    }

    public void save(RolSec rol){
        rolRepository.save(rol);
    }
	
	
	
}
