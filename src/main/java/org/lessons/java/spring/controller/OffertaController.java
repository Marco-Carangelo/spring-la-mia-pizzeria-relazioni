package org.lessons.java.spring.controller;

import java.util.List;

import org.lessons.java.spring.model.Offerta;
import org.lessons.java.spring.service.OffertaService;
import org.lessons.java.spring.service.PizzaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/offerte")
public class OffertaController {
	
	@Autowired
	private OffertaService offertaService;
	
	@Autowired
	private PizzaService pizzaService;
	
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
	
	@GetMapping("/create/{id}")
	public String create(@PathVariable("id") Integer id ,Model model) {
		Offerta offerta = new Offerta();
		offerta.setPizza(pizzaService.findPizzaById(id));
		model.addAttribute("offerta", offerta);
		return "/offerte/create";
	}

	@PostMapping("/create")
	public String store(
			@Valid @ModelAttribute("offerta") Offerta formOfferta,
			BindingResult bindingResult,
			Model model,
			RedirectAttributes attributes ){
		
		if(bindingResult.hasErrors()) {
			return "/offerte/create";
		}
		
		
		offertaService.createOfferta(formOfferta);
		
		attributes.addFlashAttribute("message", "L'offerta  " + formOfferta.getTitoloOfferta() + " è stata creata");
		
		return "redirect:/offerte";
	}
}
