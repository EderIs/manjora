package com.manjora.project.manjora.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.manjora.project.manjora.entity.CategoriaNota;

@Repository
public interface CategoriaNotaRepository extends JpaRepository<CategoriaNota,Long> {

}
