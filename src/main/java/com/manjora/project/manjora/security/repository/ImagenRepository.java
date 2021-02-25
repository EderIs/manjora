package com.manjora.project.manjora.security.repository;

import org.springframework.core.io.Resource;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;

@Repository
public interface ImagenRepository {

	//public void init()
	
	public String saveImagen(MultipartFile imagen);
	public Resource loadImagen(String path);
	public String deleteImage(String path);
	public String updateImagen(String pathA,MultipartFile path);	
}
