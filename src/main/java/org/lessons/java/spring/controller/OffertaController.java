package org.lessons.java.spring.controller;

import java.util.List;

import org.lessons.java.spring.model.Offerta;
import org.lessons.java.spring.service.OffertaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/offerte")
public class OffertaController {
	
	@Autowired
	private OffertaService offertaService;
	
	@GetMapping
	public String index(Model model) {
		
		model.addAttribute("list", offertaService.findOfferte());
		return "/offerte/index";
	}
	
	@GetMapping("/{id}")
	public String show(@PathVariable("id") Integer id , Model model) {
		model.addAttribute("offerta", offertaService.findOffertaById(id));
		return "/offerte/show";
	}
	
	@GetMapping("/create")
	public String create(Model model) {
		model.addAttribute("offerta", new Offerta());
		return "/offerte/create";
	}

}
