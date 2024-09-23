package org.lessons.java.spring.service;

import java.util.List;

import org.lessons.java.spring.model.Pizza;
import org.lessons.java.spring.repository.PizzaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PizzaService {
	
	@Autowired
	private PizzaRepository repository;
	
	
	public List<Pizza> findPizzas(){
		return repository.findAll();
	}
	
	public List<Pizza> findPizzasByStart(String name){
		return repository.findByNomeStartsWith(name);
	}
	
	public Pizza findPizzaById(Integer id){
		return repository.findById(id).get();
	}
	
	public void createPizza(Pizza pizza){
		 repository.save(pizza);
	}
	
	public void editPizza(Pizza pizza){
		 repository.save(pizza);
	}
	
	public void deletePizzaById(Integer id){
		 repository.deleteById(id);
	}
}
