package com.manjora.project.manjora.controller;

import java.util.List;
import java.util.Optional;

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
import com.manjora.project.manjora.repository.ContactoRepository;
import com.manjora.project.manjora.service.ContactoService;




@RestController
@RequestMapping("/contacto")
@CrossOrigin(origins = "http://localhost:4200")
public class ContactoController {

	
	@Autowired
	ContactoRepository contactoRepository;
	
	@Autowired
	ContactoService contactoService;

	@GetMapping("/list")
	public ResponseEntity<List<Contacto>> List() {
		List<Contacto> list = contactoService.list();
		return new ResponseEntity(list, HttpStatus.OK);
	}
	
	@GetMapping("/listContactos/{id}")
	public ResponseEntity<List<Contacto>>getContactoToCalendario(@PathVariable(name="id")int id){
		
		return new ResponseEntity(contactoService.getAllContactoToCalendario(id),HttpStatus.OK);
		
	}
	
	@GetMapping("/list/{nombre}")
	public ResponseEntity<List<Contacto>>ListAllByNombre(@PathVariable("nombre") String nombre ){
		try {
			List<Contacto> list = contactoService.findAllByNombre(nombre);
			return new ResponseEntity(list, HttpStatus.OK);
		}catch(Exception ex) {
			return new ResponseEntity(new Mensaje("Error"),HttpStatus.BAD_REQUEST);
		}
		
	}

	@GetMapping("/contactoU/{id}")
	public Long contactoUs(@PathVariable(name="id")int idCont) {
		return this.contactoService.getContactoId(idCont);
	}
	@GetMapping("/detail/{id}")
	public ResponseEntity<Contacto> getById(@PathVariable("id") Long id){
		if(!contactoService.existsById(id))
			return new ResponseEntity(new Mensaje("No Existe"), HttpStatus.NOT_FOUND);
		Contacto contacto = contactoService.getOne(id).get();
		return new ResponseEntity<Contacto>(contacto,HttpStatus.OK);
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
		String pathImagen = "";
		try {
		if(StringUtils.isBlank(contactoDto.getNombreContacto()))
			return new ResponseEntity(new Mensaje("El Nombre del Contacto es Obligatorio"), HttpStatus.BAD_REQUEST);
		if(contactoService.existsByNombreContacto(contactoDto.getNombreContacto()))
			return new ResponseEntity(new Mensaje("El Nombre ingresado ya existe"),HttpStatus.BAD_REQUEST);
		Contacto contacto = new Contacto(
				contactoDto.getNombreContacto(),contactoDto.isTipoContacto(),
				contactoDto.getContacto(),contactoDto.getCalle(),contactoDto.getCalleSecundaria(),
				contactoDto.getCiudad(),contactoDto.getEstado(),contactoDto.getCodigoPostal(),
				contactoDto.getNif(),contactoDto.getPuestoTrabajo(),contactoDto.getTelefono(),
				contactoDto.getMovil(),contactoDto.getCorreoElectronico(),contactoDto.getSitioWeb(),
				contactoDto.getTitulo(),contactoDto.getNotas(),contactoDto.isRol(),
				contactoDto.getUsuario(),contactoDto.getReferenciaInterna(),
				contactoDto.getFechaCreacion(),null);
		contacto.setPathImagen(contactoDto.getPathImagen());
		contactoService.save(contacto);
		return new ResponseEntity(new Mensaje("Contacto Creado"),HttpStatus.OK);
		} catch (Exception ex) {
			
			return new ResponseEntity(new Mensaje("Error: " + ex.getCause()), HttpStatus.BAD_REQUEST);
		}
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
		
		if(contacto.getPathImagen() != contactoDto.getPathImagen())
			contacto.setPathImagen(contactoDto.getPathImagen());
		
		contactoService.save(contacto);
		return new ResponseEntity(new Mensaje("Contacto Actualizado"),HttpStatus.OK);
	}

	
	@DeleteMapping("delete/{id}")
	public Contacto delete(@PathVariable(name = "id") Long id ) {
		
		Optional<Contacto> optional = this.contactoRepository.findById(id);
		if (optional.isPresent()){
			Contacto contacto = optional.get();
			this.contactoRepository.deleteById(id);
			
			return contacto;
			
		}else {
			throw new RuntimeException("contacto sin id"+ id +"no encontrado");
		}
		
		
	}
	
	
//	@DeleteMapping("/delete/{id}")
//	public ResponseEntity<?> delete (@PathVariable("id") Long id){
//		if(!contactoService.existsById(id))
//			return new ResponseEntity(new Mensaje("No Existe"), HttpStatus.NOT_FOUND);
//		contactoService.delete(id);
//		return new ResponseEntity(new Mensaje("Contacto Eliminado"), HttpStatus.OK);
//	}


	
	
	
}
