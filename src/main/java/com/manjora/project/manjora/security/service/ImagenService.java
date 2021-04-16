package com.manjora.project.manjora.security.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.management.RuntimeErrorException;

import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.manjora.project.manjora.security.repository.ImagenRepository;

@Service
public class ImagenService implements ImagenRepository{

	private final Path pathRoot = Paths.get("uploads");
	
	
	@Override
	public String saveImagen(MultipartFile imagen) {
		try {
			if(!Files.exists(this.pathRoot)) {
				Files.createDirectory(pathRoot);		
			}
	
			Files.copy(imagen.getInputStream(), 
					this.pathRoot.resolve(imagen.getOriginalFilename()));
			
			return imagen.getOriginalFilename().toString();
		}catch(IOException ex) {
			throw new RuntimeException("No se puede guardar: "+ex.getMessage());
 		}
	}

	@Override
	public Resource loadImagen(String path) {
		try {
			Path file = pathRoot.resolve(path); 
			
			Resource resource = new UrlResource(file.toUri());
			if(resource.exists() || resource.isReadable()) {
				return resource;
			}else {
				throw new RuntimeException("error al leer el archivo dentro del else");
			}
		}catch(IOException ex) {
			throw new RuntimeException("error al leer el archivo"+ex.getLocalizedMessage());	
		}
	}

	@Override
	public String deleteImage(String path) {
		try {
			Boolean delete = Files.deleteIfExists(this.pathRoot.resolve(path));				
			return "Borrado";
		}catch(Exception ex) {
			throw new RuntimeException("No se eleminio la imagen");
		}	
	}

	@Override
	public String updateImagen(String pathA,MultipartFile path) {
		String pathR = "";
		try {
		
			Path pathRootC = this.pathRoot.resolve(pathA);
			if(Files.exists(pathRootC)) {
				Files.deleteIfExists(pathRootC);
					Files.copy(path.getInputStream(), 
							this.pathRoot.resolve(path.getOriginalFilename()));
					pathR = path.getOriginalFilename();
				
			}else {
				if(!pathA.isEmpty()) {
					Files.copy(path.getInputStream(), 
							this.pathRoot.resolve(path.getOriginalFilename()));
					pathR = path.getOriginalFilename();
				}
			}
			
		}catch(IOException io) {
			pathR = "Ninguna";
		}
		return pathR;
	}

	
}
