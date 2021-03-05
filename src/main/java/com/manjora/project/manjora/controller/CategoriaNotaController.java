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
import org.springframework.web.bind.annotation.RestController;

import com.manjora.project.manjora.dto.Mensaje;
import com.manjora.project.manjora.entity.CategoriaNota;
import com.manjora.project.manjora.service.CategoriaNotaService;

@RestController
@RequestMapping("/categoriaNota")
@CrossOrigin(origins = "http://localhost:4200")
public class CategoriaNotaController {

	@Autowired
	private CategoriaNotaService categoriaNotaService;
	
	@GetMapping("/getCategorias/{idP}")
	public List<CategoriaNota> getNotas(@PathVariable(name="idP") long idU ){		
		return this.categoriaNotaService.getCategoriaNota(idU);
	}
	
	@PostMapping("/create")
	public ResponseEntity<?> SaveCategoriaNota(@RequestBody CategoriaNota categoriaNotaDto) {
		try {
			CategoriaNota categoria = new CategoriaNota(Long.parseLong("0"),categoriaNotaDto.getNombreCategoria(),
					categoriaNotaDto.getNotas());
			
			this.categoriaNotaService.saveCategoriaNota(categoria);	
			
			return new ResponseEntity(categoria.getId(),HttpStatus.ACCEPTED);
		}catch(Exception ex) {
			return new ResponseEntity(new Mensaje("No se inserto la etapa"),HttpStatus.BAD_REQUEST);
		}
	}
}
