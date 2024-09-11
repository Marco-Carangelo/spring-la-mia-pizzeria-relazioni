package org.lesson.java.spring.controller;

import java.util.List;

import org.lesson.java.spring.model.Pizza;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import jakarta.validation.Valid;


@Controller
@RequestMapping("/pizzas")
public class PizzaController {
	
	public PizzaService service;
	
	@GetMapping
	public String index(Model model, @RequestParam( name = "name", required = false ) String name) {
		
		List<Pizza> result;
		
		if (name != null && !name.isEmpty()) {
			
			result = service.searchPizzas(name);
			
		}else {
			
			result = service.findPizzas();
		}
		
		model.addAttribute("list", result);
		return "/pizzas/index";
	}
	
	@GetMapping("/{id}")
	public String show(@PathVariable("id") Integer id , Model model) {
		model.addAttribute("pizza", service.findPizzaById(id));
		return "/pizzas/show";
	}
	
	@GetMapping("/findByNome/{nome}")
	public String findByNome(@PathVariable("nome")  String nome , Model model) {
		model.addAttribute("list", service.searchPizzas(nome));
		return "/pizzas/index";
	}


	@GetMapping("/create")
	public String create(Model model) {
		model.addAttribute("pizza", new Pizza());
		return "/pizzas/create";
	}
	
	@PostMapping("/create")
	public String store(
			@Valid @ModelAttribute("pizza") Pizza formPizza,
			BindingResult bindingResult,
			Model model,
			RedirectAttributes attributes ){
		
		if(bindingResult.hasErrors()) {
			return "/pizzas/create";
		}
		
		formPizza.setImg_url("/img/logo-mia-pizzeria.png");
		
		service.createPizza(formPizza);
		
		attributes.addFlashAttribute("message", "La pizza  " + formPizza.getNome() + " è stata creata");
		
		return "redirect:/pizzas";
	}
	
	
	@GetMapping("/edit/{id}")
	public String edit(
			@PathVariable("id") Integer id,
			Model model) {
		model.addAttribute("pizza", service.findPizzaById(id));
		return "/pizzas/edit";
	}
	
	@PostMapping("/edit/{id}")
	public String update(
			@Valid @ModelAttribute("pizza") Pizza formPizza,
			BindingResult bindingResult,
			Model model,
			RedirectAttributes attributes ){
		
		if(bindingResult.hasErrors()) {
			return "/pizzas/edit";
		}
		
		service.editPizza(formPizza);
		
		attributes.addFlashAttribute("message", "La pizza  " + formPizza.getNome() + " è stata aggiornata");
		
		return "redirect:/pizzas";
	}
	
	@PostMapping("/delete/{id}")
	public String delete(@PathVariable("id") Integer id,
			RedirectAttributes attributes ) {
		
		service.deletePizzaById(id);
		
		attributes.addFlashAttribute("message", "La pizza con id " + id + " è stata eliminata");
		
		return "redirect:/pizzas";
	}

}
