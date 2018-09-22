package com.ccbincidentes.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ccbincidentes.model.Grupo;
import com.ccbincidentes.repository.GrupoRepository;

@Service
public class GrupoService {

	@Autowired
	private GrupoRepository repository;

	public List<Grupo> findAll() {
		return repository.findAll();
	}

	public Grupo findOne(int id) {
		return repository.findOne(id);
	}

	public Grupo save(Grupo post) {
		return repository.saveAndFlush(post);
	}

	public void delete(int id) {
		repository.delete(id);
	}
}
