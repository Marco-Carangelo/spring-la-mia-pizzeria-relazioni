package org.lessons.java.spring.controller.api;

import java.util.List;

import org.lessons.java.spring.model.Pizza;
import org.lessons.java.spring.service.PizzaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
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
	
			
			
			
	
	

}
