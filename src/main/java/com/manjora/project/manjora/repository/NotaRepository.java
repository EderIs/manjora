package com.manjora.project.manjora.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.manjora.project.manjora.entity.Nota;

@Repository
public interface NotaRepository extends JpaRepository<Nota, Long>{

}
