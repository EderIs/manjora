package com.manjora.project.manjora.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.manjora.project.manjora.dto.CategoriaNotaDto;
import com.manjora.project.manjora.dto.EtapaDto;
import com.manjora.project.manjora.dto.Mensaje;
import com.manjora.project.manjora.entity.Categoria;
import com.manjora.project.manjora.entity.Etapa;
import com.manjora.project.manjora.entity.Nota;
import com.manjora.project.manjora.service.CategoriaService;
import com.manjora.project.manjora.service.NotaService;

@RestController
@RequestMapping("/categoria")
@CrossOrigin(origins = "http://localhost:4200")
public class CategoriaController {

	@Autowired
	private CategoriaService categoriaService;
	
	@Autowired
	private NotaService notaService;
	
	@GetMapping("/getCategorias/{idP}")
	public List<Categoria> getCategorias(@PathVariable(name="idP") long idU ){		
		return this.categoriaService.getCategoria(idU);
	}
	
	@PostMapping("/create")
	public ResponseEntity<?> SaveCategoriaNota(@RequestBody Categoria categoriaDto) {
		try {
			Categoria categoria = new Categoria(Long.parseLong("0"),categoriaDto.getNombre(),
					categoriaDto.getUsuario());
			
			this.categoriaService.saveCategoria(categoria);	
			
			return new ResponseEntity(categoria.getId(),HttpStatus.ACCEPTED);
		}catch(Exception ex) {
			return new ResponseEntity(new Mensaje("No se inserto la etapa"),HttpStatus.BAD_REQUEST);
		}
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> delete (@PathVariable("id") Long id){
		if(!categoriaService.existsById(id))
			return new ResponseEntity(new Mensaje("No Existe"), HttpStatus.NOT_FOUND);
		
		notaService.deleteNotasByIdCategoria(id);
		categoriaService.delete(id);
		return new ResponseEntity(new Mensaje("Categoria Eliminada"), HttpStatus.OK);
	}
	
	@PutMapping("/updateC/{id}")
	public ResponseEntity<?>actualizarCategoria(@PathVariable(name="id")Long idCategoria,@RequestBody CategoriaNotaDto categoriaDto){
		try {
			
			Categoria categoria = this.categoriaService.categoriaById(idCategoria);
			
			categoria.setNombre(categoriaDto.getNombre());
			categoria.setUsuario(categoriaDto.getUsuario());
			
			this.categoriaService.saveCategoria(categoria);
			
			return new ResponseEntity(new Mensaje("Categoria actualizada"),HttpStatus.ACCEPTED);
		}catch(Exception io) {
			return new ResponseEntity(new Mensaje("Ocurrio un problema, "+io.getLocalizedMessage()),HttpStatus.BAD_REQUEST);
		}
		
	}
}
