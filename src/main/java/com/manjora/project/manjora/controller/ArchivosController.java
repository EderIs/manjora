package com.manjora.project.manjora.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.manjora.project.manjora.dto.Mensaje;
import com.manjora.project.manjora.security.service.ImagenService;

@RestController
@RequestMapping("/archivo")
@CrossOrigin(origins = "http://localhost:4200")
public class ArchivosController {

	@Autowired
	ImagenService imagenService;
	
	@PostMapping("/imagen")
	public ResponseEntity<?> datos(@RequestParam("imagen")MultipartFile files) {
		String pathImagen = "";
		if(!files.isEmpty()) {
			pathImagen = imagenService.saveImagen(files);
		}else {
			pathImagen = "Ninguna";
		}
		
		return new ResponseEntity(new Mensaje(pathImagen),
				HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/getImage/{imagen}")
	public ResponseEntity<Resource>getImagen(@PathVariable("imagen")String nombrePath){
		 
		 
			return new ResponseEntity<Resource>(this.imagenService.loadImagen(nombrePath),HttpStatus.ACCEPTED);
	}
	
	@PutMapping("updateImagen/{pathA}")
	public ResponseEntity<String>updateImagen(@PathVariable(name="pathA")String pathA
			,@RequestParam("imagenU")MultipartFile path){
		String mensaje="";
		if(path !=null) {
			 mensaje = imagenService.updateImagen(pathA, path);	
		}else {
			mensaje=pathA;
		}
		
		
		return new ResponseEntity(new Mensaje(mensaje), HttpStatus.ACCEPTED);
	}
}
