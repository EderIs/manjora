package com.manjora.project.manjora.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.manjora.project.manjora.dto.EtapaDto;
import com.manjora.project.manjora.dto.Mensaje;
import com.manjora.project.manjora.entity.Etapa;
import com.manjora.project.manjora.service.EtapaService;

@RestController
@RequestMapping("/Etapa")
@CrossOrigin(origins = "http://localhost:4200")
public class EtapaController {

	@Autowired
	private EtapaService etapaService;
	
	@GetMapping("/getEtapas/{idP}")
	public List<Etapa> getEtapas(@PathVariable(name="idP") long idU ){		
		return this.etapaService.getEtapas(idU);
	}
	
	@PostMapping("/create")
	public ResponseEntity<?> SaveEtapa(@RequestBody EtapaDto etapaDto) {
		try {
			Etapa etapa = new Etapa(Long.parseLong("0"),etapaDto.getNombre(),
					etapaDto.getProyecto(),etapaDto.getEstatus());
			
			this.etapaService.saveEtapa(etapa);	
			
			return new ResponseEntity(etapa.getId(),HttpStatus.ACCEPTED);
		}catch(Exception ex) {
			return new ResponseEntity(new Mensaje("No se inserto la etapa"),HttpStatus.BAD_REQUEST);
		}
	}
	
	
}
