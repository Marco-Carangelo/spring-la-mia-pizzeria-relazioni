package org.lessons.java.spring.controller;

import java.util.List;

import org.lessons.java.spring.model.Ingrediente;
import org.lessons.java.spring.model.Pizza;
import org.lessons.java.spring.service.IngredienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/ingredienti")
public class IngredienteController {
	
	@Autowired
	private IngredienteService ingredienteService;
	
	@GetMapping
	public String index(Model model) {
		
		List<Ingrediente> result = ingredienteService.findIngredienti();
		model.addAttribute("list", result);
		
		return  "/ingredienti/index";
	}
	
	@GetMapping("/create")
	public String create(Model model) {
		model.addAttribute("ingrediente", new Ingrediente());
		return "/ingredienti/create";
	}

}
