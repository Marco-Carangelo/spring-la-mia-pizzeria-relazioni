package org.lessons.java.spring.controller;

import java.util.List;

import org.lessons.java.spring.model.Ingrediente;
import org.lessons.java.spring.service.IngredienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import jakarta.validation.Valid;

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
	
	@PostMapping("/create")
	public String store(
			@Valid @ModelAttribute("ingrediente") Ingrediente formIngrediente,
			BindingResult bindingResult,
			Model model,
			RedirectAttributes attributes ){
		
		if(bindingResult.hasErrors()) {
			return "/ingredienti/create";
		}

		
		ingredienteService.createIngrediente(formIngrediente);
		
		attributes.addFlashAttribute("message", "L'ingrediente " + formIngrediente.getNomeIngrediente() + " è stato creato");
		
		return "redirect:/ingredienti";
	}
}
