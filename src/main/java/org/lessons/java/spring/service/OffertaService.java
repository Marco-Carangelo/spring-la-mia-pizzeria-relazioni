package org.lessons.java.spring.service;

import java.util.List;

import org.lessons.java.spring.model.Offerta;
import org.lessons.java.spring.repository.OffertaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OffertaService {
	
	@Autowired
	private OffertaRepository repository;
	
	public List<Offerta> findOfferte(){
		return repository.findAll();
	}
	
	public Offerta findOffertaById(Integer id){
		return repository.findById(id).get();
	}
	
	public void createOfferta(Offerta offerta) {
		repository.save(offerta);
	}
	
	public void editOfferta(Offerta offerta) {
		repository.save(offerta);
	}
	
}
