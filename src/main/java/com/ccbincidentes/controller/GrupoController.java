package com.ccbincidentes.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ccbincidentes.model.Grupo;
import com.ccbincidentes.service.GrupoService;

@Controller
public class GrupoController {

	@Autowired
	private GrupoService service;

	@GetMapping("/grupo/")
	public ModelAndView findAll() {

		ModelAndView mv = new ModelAndView("/grupo");
		mv.addObject("grupos", service.findAll());

		return mv;
	}

	@GetMapping("/grupo/add")
	public ModelAndView add(Grupo grupo) {

		ModelAndView mv = new ModelAndView("/grupoAdd");
		mv.addObject("grupo", grupo);

		return mv;
	}

	@GetMapping("/grupo/edit/{id}")
	public ModelAndView edit(@PathVariable("id") int id) {

		return add(service.findOne(id));
	}

	@GetMapping("/grupo/delete/{id}")
	public ModelAndView delete(@PathVariable("id") int id) {

		service.delete(id);

		return findAll();
	}

	@PostMapping("/grupo/save")
	public ModelAndView save(@Valid Grupo grupo, BindingResult result) {

		if (result.hasErrors()) {
			return add(grupo);
		}

		service.save(grupo);

		return findAll();
	}
}
