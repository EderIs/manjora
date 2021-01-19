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
import com.manjora.project.manjora.dto.ContactoDto;
import com.manjora.project.manjora.dto.Mensaje;
import com.manjora.project.manjora.entity.Contacto;
import com.manjora.project.manjora.service.ContactoService;


@RestController
@RequestMapping("/contacto")
@CrossOrigin(origins = "http://localhost:4200")
public class ContactoController {

	@Autowired
	ContactoService contactoService;

	@GetMapping("/list")
	public ResponseEntity<List<Contacto>> List() {
		List<Contacto> list = contactoService.list();
		return new ResponseEntity(list, HttpStatus.OK);
	}

	@GetMapping("/detail/{id}")
	public ResponseEntity<Contacto> getById(@PathVariable("id") Long id) {
		if (!contactoService.existsById(id))
			return new ResponseEntity(new Mensaje("No Existe"), HttpStatus.NOT_FOUND);
		Contacto contacto = contactoService.getOne(id).get();
		return new ResponseEntity<Contacto>(contacto, HttpStatus.OK);
	}

	@GetMapping("/detailname/{nombreContacto}")
	public ResponseEntity<Contacto> getByNombreContacto(@PathVariable("nombreContacto") String nombreContacto) {
		if (!contactoService.existsByNombreContacto(nombreContacto))
			return new ResponseEntity(new Mensaje("No Existe"), HttpStatus.NOT_FOUND);
		Contacto contacto = contactoService.getByNombreContacto(nombreContacto).get();
		return new ResponseEntity<Contacto>(contacto, HttpStatus.OK);
	}
	
	@PostMapping("/create")
	public ResponseEntity<?> create(@RequestBody ContactoDto contactoDto){
		if(StringUtils.isBlank(contactoDto.getNombreContacto()))
			return new ResponseEntity(new Mensaje("El Nombre del Contacto es Obligatorio"), HttpStatus.BAD_REQUEST);
		if(contactoService.existsByNombreContacto(contactoDto.getNombreContacto()))
			return new ResponseEntity(new Mensaje("El Nombre ingresado ya existe"),HttpStatus.BAD_REQUEST);
		Contacto contacto = new Contacto(contactoDto.getNombreContacto(),contactoDto.isTipoContacto(),
				contactoDto.getFotografia(),contactoDto.getContacto(),
				contactoDto.getCalle(),contactoDto.getCalleSecundaria(),contactoDto.getCiudad(),
				contactoDto.getEstado(),contactoDto.getCodigoPostal(),contactoDto.getNif(),
				contactoDto.getPuestoTrabajo(),contactoDto.getTelefono(),
				contactoDto.getMovil(),contactoDto.getCorreoElectronico(),
				contactoDto.getSitioWeb(),contactoDto.getTitulo(),contactoDto.getNotas(),
				contactoDto.isRol(),contactoDto.getUsuario(),contactoDto.getReferenciaInterna());
		contactoService.save(contacto);
		return new ResponseEntity(new Mensaje("Contacto Creado"),HttpStatus.OK);
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<?> update(@PathVariable("id") Long id, @RequestBody ContactoDto contactoDto){
		if(!contactoService.existsById(id))
			return new ResponseEntity(new Mensaje("No Existe"), HttpStatus.NOT_FOUND);
		if(contactoService.existsByNombreContacto(contactoDto.getNombreContacto()) && contactoService.getByNombreContacto(contactoDto.getNombreContacto()).get().getId() != id)
			return new ResponseEntity(new Mensaje("El Nombre ingresado ya existe"),HttpStatus.BAD_REQUEST);
		if(StringUtils.isBlank(contactoDto.getNombreContacto()))
			return new ResponseEntity(new Mensaje("El Nombre del Contacto es Obligatorio"), HttpStatus.BAD_REQUEST);
		Contacto contacto = contactoService.getOne(id).get();
		contacto.setNombreContacto(contactoDto.getNombreContacto());
		contacto.setTipoContacto(contactoDto.isTipoContacto());
		contacto.setFotografia(contactoDto.getFotografia());
		contacto.setContacto(contactoDto.getContacto());
		contacto.setCalle(contactoDto.getCalle());
		contacto.setCalleSecundaria(contactoDto.getCalleSecundaria());
		contacto.setCiudad(contactoDto.getCiudad());
		contacto.setEstado(contactoDto.getEstado());
		contacto.setCodigoPostal(contactoDto.getCodigoPostal());
		contacto.setNif(contactoDto.getNif());
		contacto.setPuestoTrabajo(contactoDto.getPuestoTrabajo());
		contacto.setTelefono(contactoDto.getTelefono());
		contacto.setMovil(contactoDto.getMovil());
		contacto.setCorreoElectronico(contactoDto.getCorreoElectronico());
		contacto.setSitioWeb(contactoDto.getSitioWeb());
		contacto.setTitulo(contactoDto.getTitulo());
		contacto.setNotas(contactoDto.getNotas());
		contacto.setRol(contacto.isRol());
		contacto.setUsuario(contactoDto.getUsuario());
		contacto.setReferenciaInterna(contactoDto.getReferenciaInterna());
		contactoService.save(contacto);
		return new ResponseEntity(new Mensaje("Contacto Actualizado"),HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> delete (@PathVariable("id") Long id){
		if(!contactoService.existsById(id))
			return new ResponseEntity(new Mensaje("No Existe"), HttpStatus.NOT_FOUND);
		contactoService.delete(id);
		return new ResponseEntity(new Mensaje("Contacto Eliminado"), HttpStatus.OK);
	}


}
