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
import com.manjora.project.manjora.entity.Categoria;
import com.manjora.project.manjora.service.CategoriaService;

@RestController
@RequestMapping("/categorias")
@CrossOrigin(origins = "http://localhost:4200")
public class CategoriaController {

	@Autowired
	private CategoriaService categoriaService;
	
	@GetMapping("/getCategorias/{idP}")
	public List<Categoria> getCategorias(@PathVariable(name="idP") long idU ){		
		return this.categoriaService.getCategoria(idU);
	}
	
	@PostMapping("/create")
	public ResponseEntity<?> SaveCategoriaNota(@RequestBody Categoria categoriaDto) {
		try {
			Categoria categoria = new Categoria(Long.parseLong("0"),categoriaDto.getNombre(),
					categoriaDto.getNotas());
			
			this.categoriaService.saveCategoria(categoria);	
			
			return new ResponseEntity(categoria.getId(),HttpStatus.ACCEPTED);
		}catch(Exception ex) {
			return new ResponseEntity(new Mensaje("No se inserto la etapa"),HttpStatus.BAD_REQUEST);
		}
	}
}
