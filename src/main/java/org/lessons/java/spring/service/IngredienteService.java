package org.lessons.java.spring.service;

import java.util.List;

import org.lessons.java.spring.model.Ingrediente;
import org.lessons.java.spring.repository.IngredienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IngredienteService {
	
	@Autowired
	private IngredienteRepository repository;
	
	
	public List<Ingrediente> findIngredienti(){
		return repository.findAll();
	}
	
	//public List<Ingrediente> searchIngredienti(String name){
	//	return repository.findByNomeStartsWith(name);
	//}
	
	public Ingrediente findIngredienteById(Integer id){
		return repository.findById(id).get();
	}
	
	public void createIngrediente(Ingrediente ingrediente){
		 repository.save(ingrediente);
	}
	
	
	public void deleteIngredienteById(Integer id){
		 repository.deleteById(id);
	}

}
