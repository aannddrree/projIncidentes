package com.ccbincidentes.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ccbincidentes.model.Incidentes;
import com.ccbincidentes.repository.IncidentesRepository;

@Service
public class IncidentesService {

	@Autowired
	private IncidentesRepository repository;

	public List<Incidentes> findAll() {
		return repository.findAll();
	}

	public Incidentes findOne(int id) {
		return repository.findOne(id);
	}

	public Incidentes save(Incidentes post) {
		return repository.saveAndFlush(post);
	}

	public void delete(int id) {
		repository.delete(id);
	}
}
