package org.lessons.java.spring.service;

import org.lesson.java.spring.controller.PizzaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PizzaService {
	
	@Autowired
	private PizzaRepository repository;

}
