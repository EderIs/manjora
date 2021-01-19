package com.manjora.project.manjora.controller;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
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

import com.manjora.project.manjora.dto.BancoDto;
import com.manjora.project.manjora.dto.Mensaje;
import com.manjora.project.manjora.dto.UsuarioDto;
import com.manjora.project.manjora.entity.Banco;
import com.manjora.project.manjora.entity.Usuario;
import com.manjora.project.manjora.repository.BancoRepository;
import com.manjora.project.manjora.service.BancoService;

@RestController
@RequestMapping("/banco")
@CrossOrigin(origins = "http://localhost:4200")
public class BancoController {

	
	@Autowired
	private BancoService bancoService;
	
	@GetMapping("/list")
	public ResponseEntity<List<Banco>> List(){
		List<Banco> list = bancoService.list();
		return new ResponseEntity(list, HttpStatus.OK);
	}
	
	@GetMapping("/detail/{id}")
	public ResponseEntity<Banco> getById(@PathVariable("id") Long id){
		if(!bancoService.existsById(id))
			return new ResponseEntity(new Mensaje("No Existe"), HttpStatus.NOT_FOUND);
		Banco banco = bancoService.getOne(id).get();
		return new ResponseEntity<Banco>(banco,HttpStatus.OK);
	}
	
	@GetMapping("/detailname/{nombre}")
	public ResponseEntity<Banco> getByNombreBanco(@PathVariable("nombre") String nombre){
		if(!bancoService.existsByNombre(nombre))
			return new ResponseEntity(new Mensaje("No Existe"), HttpStatus.NOT_FOUND);
		Banco banco = bancoService.getByNombre(nombre).get();
		return new ResponseEntity<Banco>(banco,HttpStatus.OK);
	}
	
	@PostMapping("/create")
	public ResponseEntity<?> create(@RequestBody BancoDto bancoDto){
		if(StringUtils.isBlank(bancoDto.getNombre()))
			return new ResponseEntity(new Mensaje("El Nombre del banco es Obligatorio"), HttpStatus.BAD_REQUEST);
		if(bancoService.existsByNombre(bancoDto.getNombre()))
			return new ResponseEntity(new Mensaje("El banco ingresado ya existe"),HttpStatus.BAD_REQUEST);
		Banco banco = new Banco(bancoDto.getNombre(),bancoDto.getCodigoIdenBancaria(), bancoDto.getCalle(), 
				bancoDto.getCalleSecundaria(), bancoDto.getCiudad(), bancoDto.getCodigoPostal(),
				bancoDto.getTelefono(), bancoDto.getCorreoElectronico(), bancoDto.getActivo());
		bancoService.save(banco);
		return new ResponseEntity(new Mensaje("Banco Creado"),HttpStatus.OK);
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<?> update(@PathVariable("id") Long id, @RequestBody BancoDto bancoDto){
		if(!bancoService.existsById(id))
			return new ResponseEntity(new Mensaje("No Existe"), HttpStatus.NOT_FOUND);
		if(bancoService.existsByNombre(bancoDto.getNombre()) && bancoService.getByNombre(bancoDto.getNombre()).get().getId() != id)
			return new ResponseEntity(new Mensaje("El Banco ingresado ya existe"),HttpStatus.BAD_REQUEST);
		if(StringUtils.isBlank(bancoDto.getNombre()))
			return new ResponseEntity(new Mensaje("El banco es Obligatorio"), HttpStatus.BAD_REQUEST);
		
		Banco banco = bancoService.getOne(id).get();
		banco.setNombre(bancoDto.getNombre());
		banco.setCodigoIdenBancaria(bancoDto.getCodigoIdenBancaria());
		banco.setCalle(bancoDto.getCalle());
		banco.setCalleSecundaria(bancoDto.getCalleSecundaria());
		banco.setCiudad(bancoDto.getCiudad());
		banco.setCodigoPostal(bancoDto.getCodigoPostal());
		banco.setTelefono(bancoDto.getTelefono());
		banco.setCorreoElectronico(bancoDto.getCorreoElectronico());
		banco.setActivo(bancoDto.getActivo());
		
		bancoService.save(banco);
		return new ResponseEntity(new Mensaje("Banco Actualizado"),HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> delete (@PathVariable("id") Long id){
		if(!bancoService.existsById(id))
			return new ResponseEntity(new Mensaje("No Existe"), HttpStatus.NOT_FOUND);
		bancoService.delete(id);
		return new ResponseEntity(new Mensaje("Banco Eliminado"), HttpStatus.OK);
	}
	
}
