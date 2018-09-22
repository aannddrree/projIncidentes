package com.ccbincidentes.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ccbincidentes.model.Responsavel;
import com.ccbincidentes.repository.ResponsavelRepository;

@Service
public class ResponsavelService {

	@Autowired
	private ResponsavelRepository repository;

	public List<Responsavel> findAll() {
		return repository.findAll();
	}

	public Responsavel findOne(int id) {
		return repository.findOne(id);
	}

	public Responsavel save(Responsavel post) {
		return repository.saveAndFlush(post);
	}

	public void delete(int id) {
		repository.delete(id);
	}
}
