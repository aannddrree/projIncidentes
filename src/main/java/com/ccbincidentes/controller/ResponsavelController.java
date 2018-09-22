package com.ccbincidentes.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import com.ccbincidentes.model.Responsavel;
import com.ccbincidentes.service.GrupoService;
import com.ccbincidentes.service.ResponsavelService;

@Controller
public class ResponsavelController {

	@Autowired
	private ResponsavelService service;
	@Autowired
	private GrupoService serviceGrupo;

	@GetMapping("/responsavel/")
	public ModelAndView findAll() {

		ModelAndView mv = new ModelAndView("/responsavel");
		mv.addObject("responsaveis", service.findAll());
		return mv;
	}

	@GetMapping("/responsavel/add")
	public ModelAndView add(Responsavel responsavel) {

		ModelAndView mv = new ModelAndView("/responsavelAdd");
		mv.addObject("responsavel", responsavel);
		mv.addObject("grupos", serviceGrupo.findAll());

		return mv;
	}

	@GetMapping("/responsavel/edit/{id}")
	public ModelAndView edit(@PathVariable("id") int id) {

		return add(service.findOne(id));
	}

	@GetMapping("/responsavel/delete/{id}")
	public ModelAndView delete(@PathVariable("id") int id) {

		service.delete(id);

		return findAll();
	}

	@PostMapping("/responsavel/save")
	public ModelAndView save(@Valid Responsavel responsavel, BindingResult result) {

		if (result.hasErrors()) {
			return add(responsavel);
		}

		service.save(responsavel);

		return findAll();
	}
}
