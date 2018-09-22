package com.ccbincidentes.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import com.ccbincidentes.model.Incidentes;
import com.ccbincidentes.service.IncidentesService;
import com.ccbincidentes.service.ResponsavelService;

@Controller
public class IncidentesController {

	@Autowired
	private IncidentesService service;
	@Autowired
	private ResponsavelService serviceResponsavel;

	@GetMapping("/incidentes/")
	public ModelAndView findAll() {

		ModelAndView mv = new ModelAndView("/incidentes");
		mv.addObject("incidentes", service.findAll());

		return mv;
	}

	@GetMapping("/incidentes/add")
	public ModelAndView add(Incidentes incidentes) {

		ModelAndView mv = new ModelAndView("/incidentesAdd");
		mv.addObject("incidentes", incidentes);
		mv.addObject("responsaveis", serviceResponsavel.findAll());

		return mv;
	}

	@GetMapping("/incidentes/edit/{id}")
	public ModelAndView edit(@PathVariable("id") int id) {

		return add(service.findOne(id));
	}

	@GetMapping("/incidentes/delete/{id}")
	public ModelAndView delete(@PathVariable("id") int id) {

		service.delete(id);

		return findAll();
	}

	@PostMapping("/incidentes/save")
	public ModelAndView save(@Valid Incidentes incidentes, BindingResult result) {

		if (result.hasErrors()) {
			return add(incidentes);
		}

		service.save(incidentes);

		return findAll();
	}
}
