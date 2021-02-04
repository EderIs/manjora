package com.manjora.project.manjora.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.manjora.project.manjora.entity.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
	

	//@Query(value = "select s.direccion_correo from usuarios s where estado=0",nativeQuery = true)
	//List<Usuario>findAllByEstado();
	
	Optional<Usuario> findByNombreUsuario(String nombreUsuario);
	boolean existsBydireccionCorreo(String direccionCorreo);
	boolean existsBynombreUsuario(String nombreUsuario);
	
}
