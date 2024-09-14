package org.lessons.java.spring.repository;

import java.util.List;

import org.lessons.java.spring.model.Pizza;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PizzaRepository extends JpaRepository<Pizza, Integer>{
	
	public List<Pizza> findByNomeStartsWith(String Nome);

}
