package com.ccbincidentes.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ccbincidentes.model.Grupo;

@Repository
public interface GrupoRepository extends JpaRepository<Grupo, Integer> { } 
