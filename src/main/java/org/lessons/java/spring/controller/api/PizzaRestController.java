package org.lessons.java.spring.controller.api;

import java.util.List;
import java.util.Optional;

import org.lessons.java.spring.model.Pizza;
import org.lessons.java.spring.service.PizzaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping("/api/pizzas")
public class PizzaRestController {
	
	@Autowired
	private PizzaService pizzaService;
	
	@GetMapping
	public List<Pizza> index(@RequestParam( name = "searchedText" , required = false ) String searchedText ){
		
		List<Pizza> result;
		
		if(searchedText != null && !searchedText.isEmpty() ) {
			 result = pizzaService.findPizzasByStart(searchedText);
		}else {
			 result = pizzaService.findPizzas();
		}
				
		return result;
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Pizza> show(@PathVariable("id") Integer id) {
		Optional<Pizza> pizza = Optional.of(pizzaService.findPizzaById(id));
		
		if(pizza.isPresent()) {
			
			return new ResponseEntity<>(pizza.get(), HttpStatus.OK);
		}
		
		return new ResponseEntity<>( HttpStatus.NOT_FOUND);
	}
	
	@PostMapping
	public Pizza store(@RequestBody Pizza pizza) {
		Pizza newPizza = pizzaService.createPizza(pizza);
		
		return newPizza;
		
	}
	
	@PutMapping("/{id}")
	public Pizza update(@RequestBody Pizza pizza, @PathVariable("id") Integer id) {
		Pizza newPizza = pizzaService.updatePizza(pizza);
		
		return newPizza;
		
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable("id") Integer id) {
		pizzaService.deletePizzaById(id);
	}
	
			
			
			
	
	

}
