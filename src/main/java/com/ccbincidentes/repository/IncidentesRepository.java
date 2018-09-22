package com.ccbincidentes.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ccbincidentes.model.Incidentes;

@Repository
public interface IncidentesRepository extends JpaRepository<Incidentes, Integer> { } 
