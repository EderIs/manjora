package com.manjora.project.manjora.security.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.manjora.project.manjora.security.entity.RolSec;
import com.manjora.project.manjora.security.enums.RolNombre;

@Repository
public interface RolRepository extends JpaRepository<RolSec, Integer> {
	Optional<RolSec> findByRolNombre(RolNombre rolNombre);
}
